package com.eihei.hq.registry;

import com.eihei.hq.hq;
import com.eihei.hq.Items.HQSword;
import com.eihei.hq.Items.WETWand;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, hq.MODID);
    public static final  RegistryObject<Item> HQ_SWORD = ITEMS.register("hq_sword",
    () -> new HQSword(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1)));
    public static final  RegistryObject<Item> WETWAND = ITEMS.register("wet_wand",
    () -> new WETWand(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1)));
}
