package net.hotslicer.pancake.material;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.minestom.server.item.Material;
import net.minestom.server.utils.NamespaceID;

/**
 * @author Jenya705
 */
public class PancakeMaterialBuilder {

    private NamespaceID namespace;
    private int id;
    private Material minestomMaterial;
    private int maxAmount = 1;
    private Component customName;

    public PancakeMaterialBuilder namespaceID(NamespaceID namespaceID) {
        this.namespace = namespaceID;
        return this;
    }

    public PancakeMaterialBuilder id(int id) {
        this.id = id;
        return this;
    }

    public PancakeMaterialBuilder material(Material minestomMaterial) {
        this.minestomMaterial = minestomMaterial;
        return this;
    }

    public PancakeMaterialBuilder maxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
        return this;
    }

    public PancakeMaterialBuilder customName(Component customName) {
        this.customName = customName;
        return this;
    }

    public PancakeMaterialBuilder customName(String customName) {
        return customName(LegacyComponentSerializer.legacyAmpersand().deserialize(customName));
    }

    public PancakeMaterial build() {
        if (namespace == null || minestomMaterial == null) {
            throw new IllegalStateException("You didn't set namespace nor minestom material");
        }
        return new PancakeMaterialContainer(namespace, id, minestomMaterial, maxAmount, customName);
    }

}
