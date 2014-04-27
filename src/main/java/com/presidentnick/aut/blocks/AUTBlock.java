package com.presidentnick.aut.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AUTBlock extends Block 
{

	public String[] textureNames;
    public IIcon[] icons;
	
	public AUTBlock(Material material, float hardness, String[] textures) {
		super(material);
		this.setHardness(hardness);
		textureNames = textures;
	}
	
	@Override
    public int damageDropped (int meta)
    {
        return meta;
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons (IIconRegister iconRegister)
    {
        this.icons = new IIcon[textureNames.length];

        for (int i = 0; i < this.icons.length; ++i)
        {
            this.icons[i] = iconRegister.registerIcon("aut:" + textureNames[i]);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon (int side, int meta)
    {
        return meta < icons.length ? icons[meta] : icons[0];
    }

}
