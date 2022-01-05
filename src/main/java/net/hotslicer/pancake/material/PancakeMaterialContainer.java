package net.hotslicer.pancake.material;

import net.kyori.adventure.text.Component;
import net.minestom.server.item.Material;
import net.minestom.server.utils.NamespaceID;

/**
 * @author Jenya705
 */
public record PancakeMaterialContainer(
        NamespaceID namespace,
        int id,
        Material minestomMaterial,
        int maxAmount,
        Component customName) implements PancakeMaterial {

    @Override
    public NamespaceID getNamespace() {
        return namespace;
    }

    @Override
    public Material getMinestomMaterial() {
        return minestomMaterial;
    }

    @Override
    public int getMaxAmount() {
        return maxAmount;
    }

}
