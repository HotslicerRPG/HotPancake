# HotPancake
Custom item manager for minestom server

## Usage

```java
public class PancakeHelloWorld extends Extension {

    /*
    Creates material for unique item (id doesn't matter)
    */
    public static final PancakeMaterial helloWorld =
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

    /*
    Creates registry belong to this extension
    */
    public static final Registry<PancakeMaterial> registry = new Registry<>(PancakeHelloWorld.class, PancakeMaterial.class);
   
    @Override
    public void initialize() {
        Registry.globalize(PancakeHelloWorld.registry); // globalize our registry
        MinecraftServer.getGlobalEventHandler().addListener(PlayerLoginEvent.class, e -> {
            // When player joins, give him our unique item
            e.getPlayer().getInventory().addItemStack(
                    ItemUtils.generateItemStack(PancakeHelloWorld.helloWorld)
            );
        });
        MinecraftServer.getGlobalEventHandler().addListener(PlayerBlockBreakEvent.class, e -> {
            // If he breaks the block with item in his hand, send 'hello, world!' to him
            PancakeItemStack itemStack = new PancakeItemStack(e.getPlayer().getItemInMainHand());
            if (itemStack.getMaterial() == PancakeHelloWorld.helloWorld) {
                e.getPlayer().sendMessage("hello world!");
            }
        });
    }

}
```
_[source](https://github.com/HotslicerRPG/HotPancake/blob/main/src/main/java/net/hotslicer/pancake/test/PancakeHelloWorld.java)_
