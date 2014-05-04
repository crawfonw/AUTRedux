package com.presidentnick.aut.client.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

import com.presidentnick.aut.blocks.TileSinterer;

public class ContainerSinterer extends Container {

	private TileSinterer sinterer;
	
	public ContainerSinterer(InventoryPlayer invPlayer, TileSinterer entity) {
		this.sinterer = entity;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return this.sinterer.isUseableByPlayer(player);
	}
	
}
