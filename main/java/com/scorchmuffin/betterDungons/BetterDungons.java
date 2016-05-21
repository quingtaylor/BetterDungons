package com.scorchmuffin.betterDungons;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = BetterDungons.MODID, version = BetterDungons.VERSION, name = BetterDungons.NAME)
public class BetterDungons {
	public static final String NAME = "Better Dungons";
	public static final String MODID = "BD";
	public static final String VERSION = "0.0.1";
	@Mod.Instance(MODID)
	public static BetterDungons instance;

	private static final TestItem TEST_ITEM = new TestItem();

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		TEST_ITEM.setUnlocalizedName(TestItem.NAME).setCreativeTab(tabBetterDungons);
		GameRegistry.registerItem(TEST_ITEM, TestItem.NAME);

		/*
		 * Item/Block init and registering, plus Config handling
		 */
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		GameRegistry.addRecipe(new ItemStack(TEST_ITEM), new Object[] { "D D", " D ", "   ", 'D', Blocks.dirt });

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

		/*
		 * Proxy, TileEntity, entity, GUI and Packet Registering
		 */
	}

	public static CreativeTabs tabBetterDungons = new CreativeTabs("tabBetterDungons") {
		@Override
		public Item getTabIconItem() {
			return new ItemStack(Items.command_block_minecart).getItem();
		}
	};

}
