package net.hotslicer.pancake.material;

import net.kyori.adventure.text.Component;
import net.minestom.server.item.Material;
import net.minestom.server.utils.NamespaceID;

/**
 * @author Jenya705
 */
public interface PancakeMaterial {

    static PancakeMaterial minestom(Material material) {
        return new MinestomPancakeMaterial(material);
    }

    static PancakeMaterialBuilder builder() {
        return new PancakeMaterialBuilder();
    }

    static PancakeMaterial of(NamespaceID namespace, int id, Material minestomMaterial, int maxAmount, Component customName) {
        return new PancakeMaterialContainer(namespace, id, minestomMaterial, maxAmount, customName);
    }

    NamespaceID getNamespace();

    int id();

    Material getMinestomMaterial();

    int getMaxAmount();

    Component customName();

}
