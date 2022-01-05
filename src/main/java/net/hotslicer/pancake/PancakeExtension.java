package net.hotslicer.pancake;

import net.hotslicer.pancake.command.GiveCommand;
import net.hotslicer.pancake.registry.Registry;
import net.hotslicer.pancake.test.PancakeHelloWorld;
import net.minestom.server.MinecraftServer;
import net.minestom.server.event.player.PlayerBlockBreakEvent;
import net.minestom.server.event.player.PlayerLoginEvent;
import net.minestom.server.extensions.Extension;
import net.minestom.server.item.ItemStack;
import net.minestom.server.item.Material;

/**
 * @author Jenya705
 */
public class PancakeExtension extends Extension {

    @Override
    public void initialize() {
        Registry.globalize(PancakeHelloWorld.registry);
        MinecraftServer.getCommandManager().register(new GiveCommand());
        MinecraftServer.getGlobalEventHandler().addListener(PlayerLoginEvent.class, e -> {
            e.getPlayer().getInventory().addItemStack(
                    ItemStack
                            .builder(Material.STICK)
                            .amount(1)
                            .build()
                            .withTag(ItemTags.namespaceTag, PancakeHelloWorld.helloWorld.getNamespace().toString())
            );
        });
        MinecraftServer.getGlobalEventHandler().addListener(PlayerBlockBreakEvent.class, e -> {
            PancakeItemStack itemStack = new PancakeItemStack(e.getPlayer().getItemInMainHand());
            if (itemStack.getMaterial() == PancakeHelloWorld.helloWorld) {
                e.getPlayer().sendMessage("hello world!");
            }
        });
    }

    @Override
    public void terminate() {

    }
}
