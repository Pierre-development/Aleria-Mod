package fr.pierre.aleriamod.blocks.chest.alergon;

import net.minecraft.block.BlockChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerAlergonChest extends Container {

    private final int numRows;
    private final TileEntityAlergonChest chestInventory;


    public ContainerAlergonChest(InventoryPlayer playerInv, TileEntityAlergonChest chestInventory, EntityPlayer player) {
        this.chestInventory = chestInventory;
        this.numRows = chestInventory.getSizeInventory() / 9;
        chestInventory.openInventory(player);

        for (int j = 0; j < 6; ++j)
        {
            for (int k = 0; k < 12; ++k)
            {
                this.addSlotToContainer(new Slot(chestInventory, k + j * 9, 8 + k * 18, 18 + j * 18));
            }
        }

        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                this.addSlotToContainer(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 103 + i * 18 + 37));
            }
        }

        for(int i = 0; i < 9; i++)
        {
            this.addSlotToContainer(new Slot(playerInv, i, 8 + i * 18, 161 + 37));
        }

    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index < this.numRows * 9)
            {
                if (!this.mergeItemStack(itemstack1, this.numRows * 9, this.inventorySlots.size(), true))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 0, this.numRows * 9, false))
            {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty())
            {
                slot.putStack(ItemStack.EMPTY);
            }
            else
            {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return this.chestInventory.isUsableByPlayer(playerIn);
    }

    @Override
    public void onContainerClosed(EntityPlayer playerIn) {
        super.onContainerClosed(playerIn);
        chestInventory.closeInventory(playerIn);
    }

    public TileEntityAlergonChest getChestInventory() {
        return chestInventory;
    }
}
