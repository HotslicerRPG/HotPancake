package net.hotslicer.pancake;

import lombok.experimental.UtilityClass;
import net.minestom.server.tag.Tag;

/**
 * @author Jenya705
 */
@UtilityClass
public class ItemTags {

    public final Tag<Integer> rarityTag = Tag.Integer("rarity");

    public final Tag<String> namespaceTag = Tag.String("pancake");

}
