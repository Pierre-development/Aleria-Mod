package fr.pierre.aleria.blocks.chests.alergon;

import fr.pierre.aleria.init.Blocks;
import fr.pierre.aleria.init.ContainerTypes;
import fr.pierre.aleria.utils.Constants;
import net.minecraft.client.renderer.tileentity.ChestTileEntityRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.ResourceLocation;

import java.util.Objects;

public class AlergonChestContainer extends Container {



    public final AlergonChestTileEntity alergonChestTileEntity;
    private final IWorldPosCallable canInteractWithCallable;

    public AlergonChestContainer(final int windowId, final PlayerInventory playerInventory, final AlergonChestTileEntity alergonChestTileEntity) {
        super(ContainerTypes.ALERGON_CHEST.get(), windowId);
        this.alergonChestTileEntity = alergonChestTileEntity;
        this.canInteractWithCallable = IWorldPosCallable.of(alergonChestTileEntity.getWorld(), alergonChestTileEntity.getPos());

        for(int j = 0; j < 6; ++j)
        {
            for (int k = 0; k < 12; ++k)
            {
                ChestTileEntityRenderer
                this.addSlot(new Slot(alergonChestTileEntity, k + j * 12, 8 + k * 18, 18 + j * 18));
            }
        }
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 103 + i * 18 + 37));
            }
        }

        for(int i = 0; i < 9; i++)
        {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 161 + 37));
        }
    }
    private static AlergonChestTileEntity getAlergonChestTileEntity(final PlayerInventory playerInventory, final PacketBuffer data) {
        Objects.requireNonNull(playerInventory, "dlayerInventory cannot be null");
        Objects.requireNonNull(data, "data cannot be null");
        final TileEntity tileEntity = playerInventory.player.world.getTileEntity(data.readBlockPos());

        if(tileEntity instanceof AlergonChestTileEntity) {
            return (AlergonChestTileEntity)tileEntity;
        } throw  new IllegalStateException("Tile Entity is not correct " + tileEntity);
    }

    public AlergonChestContainer(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data) {
        this(windowId, playerInventory, getAlergonChestTileEntity(playerInventory, data));
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(canInteractWithCallable, playerIn, Blocks.ALERGON_CHEST.get());
    }

    @Override
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (index < 72) {
                if (!this.mergeItemStack(itemstack1, 72, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, 72, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }
}
