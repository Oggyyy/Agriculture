package com.teammetallurgy.agriculture.machines.counter;

import com.teammetallurgy.agriculture.machines.oven.BlockOven;

import net.minecraft.inventory.InventoryBasic;

public class InventoryCabinet extends InventoryBasic
{

	TileEntityCounter counter;
	public InventoryCabinet(String par1Str, boolean par2, int par3, TileEntityCounter tileEntityCounter)
	{
		super(par1Str, par2, par3);
		this.counter = tileEntityCounter;
	}
	
	@Override
	public void openChest()
	{
		if (this.counter.numUsingPlayers < 0)
		{
			this.counter.numUsingPlayers = 0;
		}

		++this.counter.numUsingPlayers;
		this.counter.worldObj.addBlockEvent(this.counter.xCoord, this.counter.yCoord, this.counter.zCoord, this.counter.getBlockType().blockID, 1, this.counter.numUsingPlayers);
	}

	@Override
	public void closeChest()
	{
		if (this.counter.getBlockType() != null && this.counter.getBlockType() instanceof BlockCounter)
		{
			--this.counter.numUsingPlayers;
			this.counter.worldObj.addBlockEvent(this.counter.xCoord, this.counter.yCoord, this.counter.zCoord, this.counter.getBlockType().blockID, 1, this.counter.numUsingPlayers);
		}
	}

}