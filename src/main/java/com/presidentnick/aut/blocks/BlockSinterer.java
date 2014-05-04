package com.presidentnick.aut.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSinterer extends Block {

	public BlockSinterer() {
		super(Material.rock);
	}
	
	public TileEntity createTileEntity(World world, int meta) {
		return new TileSinterer();
	}
}
