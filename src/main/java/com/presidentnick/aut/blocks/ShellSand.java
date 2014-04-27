package com.presidentnick.aut.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

import com.presidentnick.aut.lib.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ShellSand extends BlockSand {

	public ShellSand(){
		super();
		this.setStepSound(soundTypeSand);
	}
	
	@SideOnly(Side.CLIENT)
	public static IIcon blockIcon;
	
	@Override
    public void registerBlockIcons (IIconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon(ModInfo.ID.toLowerCase() + ":" + "shellSand");
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		return blockIcon;
	}

}
