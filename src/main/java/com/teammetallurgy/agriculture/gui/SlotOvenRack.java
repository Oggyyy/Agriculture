package com.teammetallurgy.agriculture.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.teammetallurgy.agriculture.AgricultureItems;

public class SlotOvenRack extends Slot {

    public SlotOvenRack(final IInventory par1iInventory, final int par2, final int par3, final int par4)
    {
        super(par1iInventory, par2, par3, par4);
    }

    /**
     * Return whether this slot's stack can be taken from this slot.
     */
    @Override
    public boolean canTakeStack(final EntityPlayer par1EntityPlayer)
    {
        int slotStart = 5;
        if (getSlotIndex() == 17)
        {
            slotStart = 5;
        }
        if (getSlotIndex() == 18)
        {
            slotStart = 9;
        }
        if (getSlotIndex() == 19)
        {
            slotStart = 13;
        }

        for (int i = 0; i < 4; i++)
        {
            if (inventory.getStackInSlot(slotStart + i) != null) { return false; }
        }
        return true;
    }

    @Override
    public int getSlotStackLimit()
    {
        return 1;
    }

    @Override
    public boolean isItemValid(final ItemStack par1ItemStack)
    {
        return par1ItemStack.getItem() == AgricultureItems.ovenRack.getItem();
    }
}
