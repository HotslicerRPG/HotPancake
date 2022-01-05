package net.hotslicer.pancake.material;

import lombok.experimental.UtilityClass;
import net.hotslicer.pancake.ItemTags;
import net.minestom.server.item.ItemStack;
import net.minestom.server.item.ItemStackBuilder;

/**
 * @author Jenya705
 */
@UtilityClass
public class ItemUtils {

    public ItemStack generateItemStack(PancakeMaterial material) {
        return generateItemStackBuilder(material).build();
    }

    public ItemStackBuilder generateItemStackBuilder(PancakeMaterial material) {
        return ItemStack
                .builder(material.getMinestomMaterial())
                .displayName(material.customName())
                .meta(itemMetaBuilder -> itemMetaBuilder
                        .set(ItemTags.namespaceTag, material.getNamespace().toString())
                );
    }

}
