package com.teammetallurgy.agriculture.machines.icebox;

import com.teammetallurgy.agriculture.AgricultureItems;

import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;

public class InventoryIcebox extends InventoryBasic
{
	private TileEntityIcebox oven;
	
	public InventoryIcebox(String par1Str, boolean par2, int par3)
	{
		super(par1Str, par2, par3);
	}
	
	public InventoryIcebox(String par1Str, boolean par2, int par3, TileEntityIcebox tileEntityOven)
	{
		super(par1Str, par2, par3);
		
		this.oven = tileEntityOven;
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}
	
	@Override
	public void openChest()
	{
		if (this.oven.numUsingPlayers < 0)
		{
			this.oven.numUsingPlayers = 0;
		}

		++this.oven.numUsingPlayers;
		this.oven.worldObj.addBlockEvent(this.oven.xCoord, this.oven.yCoord, this.oven.zCoord, this.oven.getBlockType().blockID, 1, this.oven.numUsingPlayers);
	}

	@Override
	public void closeChest()
	{
		if (this.oven.getBlockType() != null && this.oven.getBlockType() instanceof BlockIcebox)
		{
			--this.oven.numUsingPlayers;
			this.oven.worldObj.addBlockEvent(this.oven.xCoord, this.oven.yCoord, this.oven.zCoord, this.oven.getBlockType().blockID, 1, this.oven.numUsingPlayers);
		}
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack)
	{
		if (i >= 17 && i <= 19)
		{
			return itemstack.itemID == AgricultureItems.ovenRack.itemID;
		}

		return true;
	}
}