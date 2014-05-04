package com.presidentnick.aut.common;

import java.util.HashMap;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.stats.Achievement;

import com.presidentnick.aut.achievements.AUTAchievements;
import com.presidentnick.aut.blocks.BlockSinterer;
import com.presidentnick.aut.blocks.ShellSand;
import com.presidentnick.aut.blocks.TileSinterer;
import com.presidentnick.aut.items.ItemGem;
import com.presidentnick.aut.items.ItemRake;
import com.presidentnick.aut.items.ItemShell;
import com.presidentnick.aut.lib.AlmostUselessTab;
import com.presidentnick.aut.lib.ModInfo;

import cpw.mods.fml.common.registry.GameRegistry;

public class AUTRegistry {
	
	public static CreativeTabs AUTTab;
	
	public AUTRegistry() {
		this.addCreativeTabs();
		this.registerItems();
		this.registerItemRecipes();
		this.registerBlocks();
		this.registerBlockRecipes();
		this.addChestLoot();
		this.addAchievements();
	}
	
	public void addCreativeTabs() {
		AUTRegistry.AUTTab = new AlmostUselessTab(CreativeTabs.getNextID(), ModInfo.NAME);
	}
	
	public void registerItems() {
		ContentRepository.sandRake = new ItemRake(ToolMaterial.IRON).setUnlocalizedName("sandRake");
		ContentRepository.sandRake.setCreativeTab(AUTRegistry.AUTTab);
		GameRegistry.registerItem(ContentRepository.sandRake, "sandRake");
		
		ContentRepository.shells = new ItemShell().setUnlocalizedName("shell");
		ContentRepository.shells.setCreativeTab(AUTRegistry.AUTTab);
		GameRegistry.registerItem(ContentRepository.shells, "shell");
		
		ContentRepository.gems = new ItemGem().setUnlocalizedName("gem");
		ContentRepository.gems.setCreativeTab(AUTRegistry.AUTTab);
		GameRegistry.registerItem(ContentRepository.gems, "gem");
	}
	
	public void registerItemRecipes() {
		
	}
	
	public void registerBlocks() {
		ContentRepository.shellSand = new ShellSand().setBlockName("ShellSand");
		ContentRepository.shellSand.setCreativeTab(AUTRegistry.AUTTab);
		GameRegistry.registerBlock(ContentRepository.shellSand, "ShellSand");
		
		GameRegistry.registerTileEntity(TileSinterer.class, "sinterer");
		ContentRepository.sinterer = new BlockSinterer().setBlockName("sinterer");
		ContentRepository.sinterer.setCreativeTab(AUTRegistry.AUTTab);
		GameRegistry.registerBlock(ContentRepository.sinterer, "sinterer");
	}
	
	public void registerBlockRecipes() {
		
	}
	
	public void addChestLoot() {
		
	}
	
	public void addAchievements() {
		HashMap<String, Achievement> achievements = AUTAchievements.achievements;
		
		achievements.put("AUT:sandy", new Achievement("AUT:sandy", "AUT.sandy", 0, 0, ContentRepository.shellSand, null));
	}
	
}
