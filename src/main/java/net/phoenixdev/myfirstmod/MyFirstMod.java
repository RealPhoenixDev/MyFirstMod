package net.phoenixdev.myfirstmod;

import net.fabricmc.api.ModInitializer;

import net.phoenixdev.myfirstmod.item.ModItemGroup;
import net.phoenixdev.myfirstmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyFirstMod implements ModInitializer {
	public static final String MOD_ID = "myfirstmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		ModItems.registerModItems();
		ModItemGroup.registerModItemGroups();
	}
}