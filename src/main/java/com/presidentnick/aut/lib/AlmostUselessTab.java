package com.presidentnick.aut.lib;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AlmostUselessTab extends CreativeTabs {

	public AlmostUselessTab(int id, String name){
		super(id, name);
	}
	
	public AlmostUselessTab(String name){
		super(name);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return Item.getItemFromBlock(Blocks.dirt);
	}

}
