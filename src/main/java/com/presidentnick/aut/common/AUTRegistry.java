package com.presidentnick.aut.common;

import java.util.HashMap;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.stats.Achievement;

import com.presidentnick.aut.achievements.AUTAchievements;
import com.presidentnick.aut.blocks.BlockSinterer;
import com.presidentnick.aut.blocks.BlockShellSand;
import com.presidentnick.aut.blocks.TileSinterer;
import com.presidentnick.aut.items.ItemGem;
import com.presidentnick.aut.items.ItemRake;
import com.presidentnick.aut.items.ItemShell;
import com.presidentnick.aut.lib.AlmostUselessTab;
import com.presidentnick.aut.lib.ModInfo;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class AUTRegistry {
	
	public static CreativeTabs AUTTab;
	
	public AUTRegistry() {
		this.addCreativeTabs();
		this.registerItems();
		this.registerItemRecipes();
		this.registerBlocks();
		this.registerBlockRecipes();
		this.registerNames();
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
		ContentRepository.shellSand = new BlockShellSand().setBlockName("shellSand");
		ContentRepository.shellSand.setCreativeTab(AUTRegistry.AUTTab);
		GameRegistry.registerBlock(ContentRepository.shellSand, "shellSand");
		
		GameRegistry.registerTileEntity(TileSinterer.class, "sinterer");
		
		ContentRepository.sintererInactive = new BlockSinterer(false).setBlockName("sintererInactive");
		ContentRepository.sintererInactive.setCreativeTab(AUTRegistry.AUTTab);
		GameRegistry.registerBlock(ContentRepository.sintererInactive, "sintererInactive");
		ContentRepository.sintererActive = new BlockSinterer(true).setBlockName("sintererActive");
		GameRegistry.registerBlock(ContentRepository.sintererActive, "sintererActive");
	}
	
	public void registerBlockRecipes() {
		
	}
	
	public void registerNames() {
		
	}
	
	public void addChestLoot() {
		
	}
	
	public void addAchievements() {
		HashMap<String, Achievement> achievements = AUTAchievements.achievements;
		
		achievements.put("AUT:sandy", new Achievement("AUT:sandy", "AUT.sandy", 0, 0, ContentRepository.shellSand, null));
	}
	
}
