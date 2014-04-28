package com.presidentnick.aut.items;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;

import com.google.common.collect.Sets;
import com.presidentnick.aut.blocks.ShellSand;

public class ItemRake extends ItemTool {

	private static final Set effectiveAgainst = Sets.newHashSet(new Block[] {});
	
	public ItemRake(float p_i45333_1_, ToolMaterial p_i45333_2_, Set p_i45333_3_) {
		super(p_i45333_1_, p_i45333_2_, p_i45333_3_);
	}
	
	public ItemRake(ToolMaterial material) {
		super(0, material, effectiveAgainst);
	}
	
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack)) {
			return false;
		} else {
			if (par3World.getBlock(par4, par5, par6) instanceof ShellSand) {
				System.out.println("Can rake.");
			}
		}
		return false;
	}

}
