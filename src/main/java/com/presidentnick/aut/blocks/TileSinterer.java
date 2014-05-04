package com.presidentnick.aut.blocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;

public class TileSinterer extends TileEntity implements IInventory {

	private ItemStack[] inventory;
	
	public TileSinterer() {
		inventory = new ItemStack[9];
	}
	
	@Override
	public int getSizeInventory() {
		return this.inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return this.inventory[i];
	}

	@Override
	public ItemStack decrStackSize(int slot, int count) {
		ItemStack stack = getStackInSlot(slot);
		if (stack != null) {
			if (stack.stackSize <= count) {
				setInventorySlotContents(slot, null);
			} else {
				stack = stack.splitStack(count);
				if (stack.stackSize == 0) {
					setInventorySlotContents(slot, null);
				}
			}
		}
		markDirty();
		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		ItemStack stack = getStackInSlot(slot);
		setInventorySlotContents(slot, null);
		return stack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		inventory[slot] = stack;
		if (stack != null && stack.stackSize > getInventoryStackLimit()) {
			stack.stackSize = getInventoryStackLimit();
		}
		markDirty();
	}

	@Override
	public String getInventoryName() {
		return "sinterer";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return player.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64;
	}

	@Override
	public void openInventory() {
		
	}

	@Override
	public void closeInventory() {
		
	}

	@Override
	public boolean isItemValidForSlot(int var1, ItemStack var2) {
		return true;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compund) {
		super.writeToNBT(compund);
		
		NBTTagList list = new NBTTagList();
		for (int i = 0; i < getSizeInventory(); i++) {
			ItemStack stack = getStackInSlot(i);
			if (stack != null) {
				NBTTagCompound item = new NBTTagCompound();
				item.setByte("SlotSinterer", (byte)i);
				stack.writeToNBT(item);
				
				list.appendTag(item);
			}
		}
		
		compund.setTag("ItemsSinterer", list);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
	  super.readFromNBT(compound);

	  NBTTagList list = compound.getTagList("ItemsSinterer", Constants.NBT.TAG_COMPOUND);

	  for(int i = 0; i < list.tagCount(); i++) {
	        NBTTagCompound item = list.getCompoundTagAt(i);
	        int slot = item.getByte("SlotSinterer");

	        if(slot >= 0 && slot < getSizeInventory()) {
	          setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
	        }
	  }
	}
	
}
