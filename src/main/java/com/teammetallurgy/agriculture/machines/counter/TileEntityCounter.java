package com.teammetallurgy.agriculture.machines.counter;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import com.teammetallurgy.agriculture.machines.BaseMachineTileEntity;

public class TileEntityCounter extends BaseMachineTileEntity {
    private final InventoryCabinet cabinet = new InventoryCabinet("", false, 24, this);
    float leftDoorAngle;

    int numUsingPlayers;
    // Left door
    float prevLeftDoorAngle;

    // Right door
    double prevRightDoorAngle;
    float rightDoorAngle;

    public IInventory getCabinet()
    {
        return cabinet;
    }

    @Override
    public void markDirty()
    {
    }

    @Override
    public void readFromNBT(final NBTTagCompound tag)
    {
        final NBTTagList tagList = tag.getTagList("Items", 10);

        for (int i = 0; i < tagList.tagCount(); i++)
        {
            final NBTTagCompound base = (NBTTagCompound) tagList.getCompoundTagAt(i);
            final int slot = Integer.valueOf(base.getByte("Slot"));
            cabinet.setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(base));
        }

        super.readFromNBT(tag);
    }

    @Override
    public boolean receiveClientEvent(final int id, final int value)
    {
        if (id == 1)
        {
            numUsingPlayers = value;
            return true;
        }
        else
        {
            return super.receiveClientEvent(id, value);
        }
    }

    @Override
    public void updateEntity()
    {
        prevLeftDoorAngle = leftDoorAngle;
        if (numUsingPlayers == 0 && leftDoorAngle > 0.0F || numUsingPlayers > 0 && leftDoorAngle < 1.0F)
        {
            if (numUsingPlayers > 0)
            {
                leftDoorAngle += 0.1;
            }
            else
            {
                leftDoorAngle -= 0.1;
            }

            if (leftDoorAngle > 1.0F)
            {
                leftDoorAngle = 1.0F;
            }

            if (leftDoorAngle < 0.0F)
            {
                leftDoorAngle = 0.0F;
            }
        }
    }

    @Override
    public void writeToNBT(final NBTTagCompound tag)
    {

        final NBTTagList nbtTagList = new NBTTagList();
        for (int i = 0; i < cabinet.getSizeInventory(); ++i)
        {
            if (cabinet.getStackInSlot(i) != null)
            {
                final NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte) i);
                cabinet.getStackInSlot(i).writeToNBT(nbttagcompound1);
                nbtTagList.appendTag(nbttagcompound1);
            }
        }

        tag.setTag("Items", nbtTagList);

        super.writeToNBT(tag);
    }
}
