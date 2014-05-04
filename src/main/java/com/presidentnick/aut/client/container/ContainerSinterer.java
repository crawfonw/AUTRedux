package com.presidentnick.aut.client.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.presidentnick.aut.blocks.TileSinterer;

public class ContainerSinterer extends Container {

	private TileSinterer sinterer;

	public ContainerSinterer(InventoryPlayer invPlayer, TileSinterer entity) {
		this.sinterer = entity;

		for (int x = 0; x < 9; x++) { //hotbar
			this.addSlotToContainer(new Slot(invPlayer, x, 8 + x * 18, 142));
		}

		for (int y = 0; y < 3; y++) { //inventory
			for (int x = 0; x < 9; x++) {
				this.addSlotToContainer(new Slot(invPlayer, 9 + x + y * 9, 8 + x * 18, 84 + y * 18));
			}
		}

		for (int y = 0; y < 3; y++) { //container
			for (int x = 0; x < 3; x++) {
				addSlotToContainer(new Slot(entity, x + y * 3, 62 + x * 18, 17 + y * 18));
			}
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return this.sinterer.isUseableByPlayer(player);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int i) {
		Slot slot = getSlot(i);

		if (slot != null && slot.getHasStack()) {
			ItemStack stack = slot.getStack();
			ItemStack result = stack.copy();

			if (i >= 36) {
				if (!mergeItemStack(stack, 0, 36, false)) {
					return null;
				}
			} else if(!mergeItemStack(stack, 36, 36 + sinterer.getSizeInventory(), false)) {
				return null;
			}
			
			if (stack.stackSize == 0) {
				slot.putStack(null);
			} else {
				slot.onSlotChanged();
			}
			slot.onPickupFromSlot(player, stack);
			return result;
		}
		return null;
	}

}
