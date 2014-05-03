package com.presidentnick.aut.common;

import java.util.HashMap;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.stats.Achievement;

import com.presidentnick.aut.achievements.AUTAchievements;
import com.presidentnick.aut.blocks.ShellSand;
import com.presidentnick.aut.items.ItemRake;
import com.presidentnick.aut.items.Shell;
import com.presidentnick.aut.lib.AlmostUselessTab;
import com.presidentnick.aut.lib.ModInfo;

import cpw.mods.fml.common.registry.GameRegistry;

public class ContentRegistry {
	
	public static CreativeTabs AUTTab;
	
	public ContentRegistry() {
		//1. Register items
		this.registerItems();
		//2. Register recipes
		//3. Register blocks
		this.registerBlocks();
		//4. Register block recipes
		//5. Setup creative tabs
		this.addCreativeTabs();
		//6. Add chest loot
		//7. Add achievements
		this.addAchievements();
	}
	
	public void registerItems() {
		ContentRepository.sandRake = new ItemRake(ToolMaterial.IRON).setUnlocalizedName("sandRake");
		ContentRepository.sandRake.setCreativeTab(AUTTab);
		GameRegistry.registerItem(ContentRepository.sandRake, "sandRake");
		
		ContentRepository.shells = new Shell().setUnlocalizedName("shell");
		ContentRepository.shells.setCreativeTab(AUTTab);
		GameRegistry.registerItem(ContentRepository.shells, "shell");
	}
	
	public void registerBlocks() {
		ContentRepository.shellSand = new ShellSand().setBlockName("ShellSand");
		ContentRepository.shellSand.setCreativeTab(AUTTab);
		
		GameRegistry.registerBlock(ContentRepository.shellSand, "ShellSand");
	}
	
	public void addCreativeTabs() {
		ContentRegistry.AUTTab = new AlmostUselessTab(CreativeTabs.getNextID(), ModInfo.NAME);
	}
	
	public void addAchievements() {
		HashMap<String, Achievement> achievements = AUTAchievements.achievements;
		
		achievements.put("AUT:sandy", new Achievement("AUT:sandy", "AUT.sandy", 0, 0, ContentRepository.shellSand, null));
	}
	
}
