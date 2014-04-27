package com.presidentnick.aut.common;

import net.minecraft.creativetab.CreativeTabs;

import com.presidentnick.aut.blocks.ShellSand;
import com.presidentnick.aut.lib.AlmostUselessTab;
import com.presidentnick.aut.lib.ModInfo;

public class ContentRegistry {
	
	public static CreativeTabs AUTTab;
	
	public ContentRegistry() {
		//1. Register items
		//2. Register recipes
		//3. Register blocks
		this.registerBlocks();
		//4. Register block recipes
		//5. Setup creative tabs
		this.addCreativeTabs();
		//6. Add chest loot
		//7. Add achievements
	}
	
	public void registerItems() {
		
	}
	
	public void registerBlocks() {
		ContentRepository.shellSand = new ShellSand().setBlockName("ShellSand");
		ContentRepository.shellSand.setCreativeTab(AUTTab);
	}
	
	public void addCreativeTabs(){
		ContentRegistry.AUTTab = new AlmostUselessTab(CreativeTabs.getNextID(), ModInfo.NAME);
	}
	
}
