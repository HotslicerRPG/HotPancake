package net.hotslicer.pancake;

import net.hotslicer.pancake.material.PancakeMaterial;
import net.hotslicer.pancake.registry.Registry;
import net.minestom.server.item.ItemStack;
import net.minestom.server.utils.NamespaceID;

/**
 * @author Jenya705
 */
public record PancakeItemStack(ItemStack itemStack) {

    public PancakeMaterial getMaterial() {
        String namespace = itemStack.getTag(ItemTags.namespaceTag);
        if (namespace == null) return PancakeMaterial.minestom(itemStack.getMaterial());
        return Registry.globalItems.getObject(NamespaceID.from(namespace));
    }

    public ItemRarity getRarity() {
        Integer rarity = itemStack.getTag(ItemTags.rarityTag);
        if (rarity == null) {
            return null;
        }
        return ItemRarity.values()[rarity];
    }

}
