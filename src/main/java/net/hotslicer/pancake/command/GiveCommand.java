package net.hotslicer.pancake.command;

import net.hotslicer.pancake.material.ItemUtils;
import net.hotslicer.pancake.registry.Registry;
import net.minestom.server.command.builder.Command;
import net.minestom.server.command.builder.arguments.Argument;
import net.minestom.server.command.builder.arguments.ArgumentType;
import net.minestom.server.entity.Player;
import net.minestom.server.item.ItemStack;
import net.minestom.server.item.Material;
import net.minestom.server.utils.NamespaceID;

/**
 * @author Jenya705
 */
public class GiveCommand extends Command {

    public GiveCommand() {
        this("give");
    }

    public GiveCommand(String name, String... aliases) {
        super(name, aliases);

        var item = ArgumentType.String("item");

        addSyntax((sender, context) -> {
            String itemNamespace = context.get(item);
            NamespaceID namespaceID = NamespaceID.from(itemNamespace);
            ItemStack toGive;
            if (namespaceID.getDomain().equals("minecraft")) {
                toGive = ItemStack.of(Material.fromNamespaceId(namespaceID));
            }
            else {
                toGive = ItemUtils.generateItemStack(Registry.globalItems.getObject(namespaceID));
            }
            ((Player) sender).getInventory().addItemStack(toGive);
        }, item);

    }

}
