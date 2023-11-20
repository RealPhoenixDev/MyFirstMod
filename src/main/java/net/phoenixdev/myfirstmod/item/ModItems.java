package net.phoenixdev.myfirstmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.phoenixdev.myfirstmod.MyFirstMod;

public class ModItems {
    public static final Item Jade = registerItems("jade",new Item(new FabricItemSettings()));
    public static final Block Jadium_Block = registerBlocks("jadium_block",new JadiumBlock(
            FabricBlockSettings.create().mapColor(MapColor.IRON_GRAY).instrument(Instrument.IRON_XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL)));

    private static void addToRedstoneTab(FabricItemGroupEntries entry) {
        entry.add(Jade);}

    private static void addToBuildingTab(FabricItemGroupEntries entry) {
        entry.add(Jadium_Block);}
    private static Item registerItems(String name, Item item) {
        return Registry.register(Registries.ITEM,new Identifier(MyFirstMod.MOD_ID, name),item);
    }

    private static Block registerBlocks(String name, Block block) {
        Registry.register(Registries.ITEM,new Identifier(MyFirstMod.MOD_ID, name), new BlockItem(block,new FabricItemSettings()));
        return Registry.register(Registries.BLOCK,new Identifier(MyFirstMod.MOD_ID, name),block);
    }
    public static void registerModItems() {

        MyFirstMod.LOGGER.info("Registering items for: " + MyFirstMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(ModItems::addToRedstoneTab);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModItems::addToBuildingTab);
    }
}
