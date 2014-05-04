package com.presidentnick.aut.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.presidentnick.aut.AUT;
import com.presidentnick.aut.lib.ModInfo;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSinterer extends BlockContainer {

	public BlockSinterer() {
		super(Material.iron);
		this.setHardness(5F);
		this.setResistance(10F);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileSinterer();
	}

	@SideOnly(Side.CLIENT)
	public static IIcon topIcon;

	@SideOnly(Side.CLIENT)
	public static IIcon frontIcon;

	@SideOnly(Side.CLIENT)
	public static IIcon defaultSideIcon;

	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		topIcon = iconRegister.registerIcon(ModInfo.ID.toLowerCase() + ":" + "testTexture_top");
		frontIcon = iconRegister.registerIcon(ModInfo.ID.toLowerCase() + ":" + "testTexture_front");
		defaultSideIcon = iconRegister.registerIcon(ModInfo.ID.toLowerCase() + ":" + "testTexture_default_side");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		if (side == 3 && meta == 0) { // forces render of front side when this block is in inventory
			return frontIcon;
		} else if (side == 0 || side == 1) {
			return topIcon;
		} else if (side != meta) {
			return defaultSideIcon;
		} else {
			return frontIcon;
		}
	}

	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
		setDefaultDirection(world, x, y, z);
	}

	private void setDefaultDirection(World world, int x, int y, int z) {
		if (!world.isRemote) {
			Block zNeg = world.getBlock(x, y, z - 1);
			Block zPos = world.getBlock(x, y, z + 1);
			Block xNeg = world.getBlock(x - 1, y, z);
			Block xPos = world.getBlock(x + 1, y, z);
			byte meta = 3;

			if (xNeg.func_149730_j() && !xPos.func_149730_j()) {
				meta = 5;
			}

			if (xPos.func_149730_j() && !xNeg.func_149730_j()) {
				meta = 4;
			}

			if (zNeg.func_149730_j() && !zPos.func_149730_j()) {
				meta = 3;
			}

			if (zPos.func_149730_j() && !zPos.func_149730_j()) {
				meta = 2;
			}

			world.setBlockMetadataWithNotify(x, y, z, meta, 2);
		}
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack) {
		int rotation = MathHelper.floor_double((double)(entity.rotationYaw * 4F / 360F) + 0.5D) & 3;

		if (rotation == 0) {
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}

		if (rotation == 1) {
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}

		if (rotation == 2) {
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}

		if (rotation == 3) {
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			FMLNetworkHandler.openGui(player, AUT.instance, 0, world, x, y, z);
		}
		return true;
	}
}
