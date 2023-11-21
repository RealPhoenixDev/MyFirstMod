package net.phoenixdev.myfirstmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.phoenixdev.myfirstmod.MyFirstMod;

public class ModItemGroup {

    public static final ItemGroup TestGroup = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.Jade))
            .displayName(Text.translatable("itemgroup.test"))
            .entries((displayContext, entries) -> {
                entries.add(ModItems.Jade);
                entries.add(ModItems.Jadium_Block);
                entries.add(ModItems.Wireless_scanner);
            }).build();

    private static ItemGroup registerItemGroup(String name, ItemGroup item) {
        return Registry.register(Registries.ITEM_GROUP, new Identifier(MyFirstMod.MOD_ID,name),item);
    }
    public static void registerModItemGroups() {
        registerItemGroup("jade_group",TestGroup);
        MyFirstMod.LOGGER.info("Registering item groups for: " + MyFirstMod.MOD_ID);
    }
}
