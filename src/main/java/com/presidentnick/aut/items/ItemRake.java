package com.presidentnick.aut.items;

import java.util.Random;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.FakePlayer;

import com.google.common.collect.Sets;
import com.presidentnick.aut.blocks.ShellSand;
import com.presidentnick.aut.common.ContentRepository;
import com.presidentnick.aut.lib.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRake extends ItemTool {

	@SideOnly(Side.CLIENT)
	public static IIcon blockIcon;
	
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
				Block block = Blocks.sand;
				par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), block.stepSound.getBreakSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
				
				par3World.setBlock(par4, par5, par6, block);
				if (par3World.isRemote) {
					return true;
				} else {
					Random generator = new Random();
					int meta = generator.nextInt(ItemShell.itemNames.length);
					int total = generator.nextInt(5);
					if (total > 0) {
						EntityItem entityitem = new EntityItem(par3World, par2EntityPlayer.posX, par2EntityPlayer.posY - 1.0D, par2EntityPlayer.posZ, new ItemStack(ContentRepository.shells, total, meta));
						par3World.spawnEntityInWorld(entityitem);
						if (!(par2EntityPlayer instanceof FakePlayer)) {
			                entityitem.onCollideWithPlayer(par2EntityPlayer);
						}
					}
					par1ItemStack.damageItem(1, par2EntityPlayer);
					return true;
				}
			}
		}
		return false;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons (IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(ModInfo.ID.toLowerCase() + ":" + "sandRake");
    }
	
	@Override
    public String getUnlocalizedName (ItemStack stack) {
        return "item." + ModInfo.ID.toLowerCase() + "." + "tool.sandRake";
    }
	
}
