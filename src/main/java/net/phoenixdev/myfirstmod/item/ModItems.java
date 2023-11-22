package net.phoenixdev.myfirstmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.phoenixdev.myfirstmod.Block.Wireless_Reciever;
import net.phoenixdev.myfirstmod.MyFirstMod;
import org.apache.http.impl.conn.Wire;

public class ModItems {
    public static final Item Jade = registerItems("jade",new Item(new FabricItemSettings()));
    public static final Block Jadium_Block = registerBlocks("jadium_block",new JadiumBlock(
            FabricBlockSettings.create().mapColor(MapColor.IRON_GRAY).instrument(Instrument.IRON_XYLOPHONE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL)));
    public static final Item Wireless_scanner = registerItems("wireless_scanner", new Wireless_Scanner(new FabricItemSettings()));
    public static final Block Wireless_reciever = registerBlocks("wireless_reciever", new Wireless_Reciever(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK).nonOpaque()));


    private static void addToRedstoneTab(FabricItemGroupEntries entry) {
        entry.add(Jade);
        entry.add(Wireless_scanner);}

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
