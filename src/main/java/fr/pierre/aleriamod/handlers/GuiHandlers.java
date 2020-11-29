package fr.pierre.aleriamod.handlers;

import fr.pierre.aleriamod.blocks.chest.alergon.ContainerAlergonChest;
import fr.pierre.aleriamod.blocks.chest.alergon.GuiAlergonChest;
import fr.pierre.aleriamod.blocks.chest.alergon.TileEntityAlergonChest;
import fr.pierre.aleriamod.utilis.Constants;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandlers implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == Constants.ALERGONCHESTGUI) {
            return new ContainerAlergonChest(player.inventory, (TileEntityAlergonChest) world.getTileEntity(new BlockPos(x, y, z)), player);
        }
        return null;
    }


    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == Constants.ALERGONCHESTGUI) {
            return new GuiAlergonChest(player.inventory, (TileEntityAlergonChest) world.getTileEntity(new BlockPos(x, y, z)), player);
        }
        return null;
    }
}
