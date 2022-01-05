package net.hotslicer.pancake.material;

import net.kyori.adventure.text.Component;
import net.minestom.server.item.Material;
import net.minestom.server.utils.NamespaceID;

/**
 * @author Jenya705
 */
public record MinestomPancakeMaterial(Material material) implements PancakeMaterial {

    @Override
    public NamespaceID getNamespace() {
        return material.namespace();
    }

    @Override
    public int id() {
        return material.id();
    }

    @Override
    public Material getMinestomMaterial() {
        return material;
    }

    @Override
    public int getMaxAmount() {
        return material.maxStackSize();
    }

    @Override
    public Component customName() {
        return Component.text(material.name());
    }
}
