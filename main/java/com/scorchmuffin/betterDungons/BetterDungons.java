package com.scorchmuffin.betterDungons;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
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

	private static ArmorMaterial TANSINITEARMOR = EnumHelper.addArmorMaterial("TansiniteArmorMaterial",
			MODID + ":TansiniteArmor", 35, new int[] { 5, 10, 8, 3 }, 25);
	private static ToolMaterial TANSINITETOOL = EnumHelper.addToolMaterial("TansiniteToolMaterial", 5, 2000, 10, 10,
			25);

	private static final TestItem TEST_ITEM = new TestItem();
	private static final Tansinite CRYSTAL1 = new Tansinite();
	private static final TansiniteHelm CRYSTALARMOR1 = new TansiniteHelm(TANSINITEARMOR, 0, 0);
	private static final TansiniteChestplate CRYSTALARMOR2 = new TansiniteChestplate(TANSINITEARMOR, 0, 1);
	private static final TansiniteLegs CRYSTALARMOR3 = new TansiniteLegs(TANSINITEARMOR, 0, 2);
	private static final TansiniteBoots CRYSTALARMOR4 = new TansiniteBoots(TANSINITEARMOR, 0, 3);
	private static final TansiniteSword CRYSTALSWORD1 = new TansiniteSword(TANSINITETOOL);

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		TEST_ITEM.setUnlocalizedName(TestItem.NAME).setCreativeTab(tabBetterDungons);
		CRYSTAL1.setUnlocalizedName(Tansinite.NAME).setCreativeTab(tabBetterDungons);
		CRYSTALARMOR1.setUnlocalizedName(TansiniteHelm.NAME).setCreativeTab(tabBetterDungons);
		CRYSTALARMOR2.setUnlocalizedName(TansiniteChestplate.NAME).setCreativeTab(tabBetterDungons);
		CRYSTALARMOR3.setUnlocalizedName(TansiniteLegs.NAME).setCreativeTab(tabBetterDungons);
		CRYSTALARMOR4.setUnlocalizedName(TansiniteBoots.NAME).setCreativeTab(tabBetterDungons);
		GameRegistry.registerItem(TEST_ITEM, TestItem.NAME);
		GameRegistry.registerItem(CRYSTAL1, Tansinite.NAME);
		GameRegistry.registerItem(CRYSTALARMOR1, TansiniteHelm.NAME);
		GameRegistry.registerItem(CRYSTALARMOR2, TansiniteChestplate.NAME);
		GameRegistry.registerItem(CRYSTALARMOR3, TansiniteLegs.NAME);
		GameRegistry.registerItem(CRYSTALARMOR4, TansiniteBoots.NAME);

		/*
		 * Item/Block init and registering, plus Config handling
		 */
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		GameRegistry.addRecipe(new ItemStack(TEST_ITEM), new Object[] { "D D", " D ", "   ", 'D', Blocks.dirt });
		GameRegistry.addRecipe(new ItemStack(CRYSTALARMOR1),
				new Object[] { "TTT", "T T", "   ", 'T', BetterDungons.CRYSTAL1 });
		GameRegistry.addRecipe(new ItemStack(CRYSTALARMOR2),
				new Object[] { "T T", "TTT", "TTT", 'T', BetterDungons.CRYSTAL1 });
		GameRegistry.addRecipe(new ItemStack(CRYSTALARMOR3),
				new Object[] { "TTT", "T T", "T T", 'T', BetterDungons.CRYSTAL1 });
		GameRegistry.addRecipe(new ItemStack(CRYSTALARMOR4),
				new Object[] { "   ", "T T", "T T", 'T', BetterDungons.CRYSTAL1 });

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
