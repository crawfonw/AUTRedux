package com.presidentnick.aut.client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.presidentnick.aut.AUT;
import com.presidentnick.aut.blocks.TileSinterer;
import com.presidentnick.aut.client.container.ContainerSinterer;
import com.presidentnick.aut.client.gui.GUISinterer;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GUIHandler implements IGuiHandler {

	public GUIHandler() {
		NetworkRegistry.INSTANCE.registerGuiHandler(AUT.instance, this);
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		switch (ID) {
		case 0:
			if (entity != null && entity instanceof TileSinterer) {
				return new ContainerSinterer(player.inventory, (TileSinterer)entity);
			} else {
				return null;
			}
		default:
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		switch (ID) {
		case 0:
			if (entity != null && entity instanceof TileSinterer) {
				return new GUISinterer(player.inventory, (TileSinterer)entity);
			} else {
				return null;
			}
		default:
			return null;
		}
	}

}
