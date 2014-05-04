package com.presidentnick.aut.blocks;

import java.util.Random;

import net.minecraft.block.BlockSand;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import com.presidentnick.aut.lib.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockShellSand extends BlockSand {

	public BlockShellSand(){
		super();
		this.setStepSound(soundTypeSand);
		this.setHardness(0.5F);
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
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return Item.getItemFromBlock(Blocks.sand);
	}
	
	@Override
    public int damageDropped (int meta)
    {
        return 0;
    }

}
