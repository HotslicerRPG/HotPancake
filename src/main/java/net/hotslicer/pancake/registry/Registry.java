package net.hotslicer.pancake.registry;

import lombok.NoArgsConstructor;
import net.hotslicer.pancake.material.PancakeMaterial;
import net.hotslicer.pancake.test.PancakeHelloWorld;
import net.minestom.server.utils.NamespaceID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Modifier;
import java.util.*;

/**
 * @author Jenya705
 */
@NoArgsConstructor
public class Registry<T extends PancakeMaterial> {

    public static final Logger logger = LoggerFactory.getLogger("HotPancake - Registry");

    /**
     * Global registry for all items on server between extensions
     */
    public static final Registry<PancakeMaterial> globalItems = new Registry<>();

    private final Map<NamespaceID, T> namespaceToMaterial = new HashMap<>();
    private final Map<Integer, T> idToMaterial = new HashMap<>();

    public static void globalize(Registry<? extends PancakeMaterial> registry) {
        globalItems.register(registry);
    }

    /**
     * Read all fields from given class and register it into this register
     *
     * @param clazz class with fields
     */
    public Registry(Class<?> clazz, Class<T> typeClass) {
        Arrays.stream(clazz.getDeclaredFields())
                .filter(it -> typeClass.isAssignableFrom(it.getType()))
                .filter(it -> Modifier.isStatic(it.getModifiers()))
                .map(it -> {
                    try {
                        boolean canAccess = it.canAccess(null);
                        if (!canAccess) it.setAccessible(true);
                        @SuppressWarnings("unchecked")
                        T object = (T) it.get(null);
                        if (!canAccess) it.setAccessible(false);
                        return object;
                    } catch (Exception e) {
                        logger.error("Can not register object: ", e);
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .forEach(this::register);
    }

    public void register(Registry<? extends T> registry) {
        registry.allObjects()
                .forEach(this::register);
    }

    public void register(T material) {
        namespaceToMaterial.put(material.getNamespace(), material);
        idToMaterial.put(material.id(), material);
    }

    public T getObject(NamespaceID namespaceID) {
        return namespaceToMaterial.get(namespaceID);
    }

    public T getObject(int id) {
        return idToMaterial.get(id);
    }

    public Collection<T> allObjects() {
        return namespaceToMaterial.values();
    }
}
