package com.presidentnick.aut.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

import com.presidentnick.aut.lib.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Shell extends Item {

	public static String[] itemNames = new String[] { "shell.auger", "shell.junonia", "shell.turkeywing" };
	public static String[] textureNames = new String[] { "shellAuger", "shellJunonia", "shellTurkeyWing" };
	
	String[] unlocalizedNames;
    String[] iconNames;
    IIcon[] icons;
	
	public Shell() {
		super();
		//this.unlocalizedNames = itemNames; //will abstract out later
		//this.iconNames = textureNames;
		
		this.setHasSubtypes(true);
		
		this.unlocalizedNames = new String[] { "shell.auger", "shell.junonia", "shell.turkeywing" };
		this.iconNames = new String[] { "shellAuger", "shellJunonia", "shellTurkeyWing" };
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta) {
        return icons[meta];
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister) {
        this.icons = new IIcon[iconNames.length];

        for (int i = 0; i < this.icons.length; ++i)
        {
            this.icons[i] = iconRegister.registerIcon(ModInfo.ID.toLowerCase() + ":" + iconNames[i]);
        }
    }
	
	@Override
    public String getUnlocalizedName(ItemStack stack) {
        int arr = MathHelper.clamp_int(stack.getItemDamage(), 0, unlocalizedNames.length);
        return "item." + ModInfo.ID.toLowerCase() + "." + unlocalizedNames[arr];
    }
	
	@Override
    public void getSubItems(Item b, CreativeTabs tab, List list) {
        for (int i = 0; i < unlocalizedNames.length; i++)
            list.add(new ItemStack(b, 1, i));
    }
}
