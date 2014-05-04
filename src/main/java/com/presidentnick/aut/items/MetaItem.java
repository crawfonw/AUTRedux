package com.presidentnick.aut.items;

import java.util.List;

import com.presidentnick.aut.lib.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

public class MetaItem extends Item {

	String[] unlocalizedNames;
    String[] iconNames;
    IIcon[] icons;
    String iconPrefix;
	
	public MetaItem(String[] itemNames, String[] textureNames, String iconPrefix) {
		this.unlocalizedNames = itemNames;
		this.iconNames = textureNames;
		this.iconPrefix = iconPrefix;
		this.setHasSubtypes(true);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta) {
        return this.icons[meta];
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister) {
        this.icons = new IIcon[iconNames.length];

        for (int i = 0; i < this.icons.length; ++i)
        {
            this.icons[i] = iconRegister.registerIcon(ModInfo.ID.toLowerCase() + ":" + this.iconPrefix + "_" + this.iconNames[i]);
        }
    }
	
	@Override
    public String getUnlocalizedName(ItemStack stack) {
        int arr = MathHelper.clamp_int(stack.getItemDamage(), 0, this.unlocalizedNames.length);
        return ModInfo.ID.toLowerCase() + ".item." + this.unlocalizedNames[arr];
    }
	
	@Override
    public void getSubItems(Item b, CreativeTabs tab, List list) {
        for (int i = 0; i < this.unlocalizedNames.length; i++)
            list.add(new ItemStack(b, 1, i));
    }
	
}
