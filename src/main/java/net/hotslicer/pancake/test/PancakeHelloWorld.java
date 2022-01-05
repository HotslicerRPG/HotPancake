package net.hotslicer.pancake.test;

import lombok.experimental.UtilityClass;
import net.hotslicer.pancake.material.PancakeMaterial;
import net.hotslicer.pancake.registry.Registry;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.minestom.server.item.Material;
import net.minestom.server.utils.NamespaceID;

/**
 * @author Jenya705
 */
@UtilityClass
public class PancakeHelloWorld {

    public final PancakeMaterial helloWorld =
            PancakeMaterial
                    .builder()
                    .namespaceID(NamespaceID.from("pancake", "hello_world"))
                    .id(0)
                    .material(Material.STICK)
                    .customName(Component
                            .text("Hello, World!")
                            .color(NamedTextColor.RED)
                    )
                    .build();

    public final Registry<PancakeMaterial> registry = new Registry<>(PancakeHelloWorld.class, PancakeMaterial.class);

}
