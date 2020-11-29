package fr.pierre.aleriamod.events;

import fr.pierre.aleriamod.blocks.chest.alergon.RenderAlergonChest;
import fr.pierre.aleriamod.blocks.chest.alergon.TileEntityAlergonChest;
import fr.pierre.aleriamod.init.Blocks;
import fr.pierre.aleriamod.init.Items;
import fr.pierre.aleriamod.utilis.Constants;
import net.minecraft.block.Block;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RegisteringEvent {

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        Items.getInstance().init();
        event.getRegistry().registerAll(Items.getInstance().getItems().toArray(new Item[0]));

    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onOpenGui(GuiOpenEvent event) {
        if(event.getGui() != null && event.getGui().getClass() == GuiMainMenu.class) {
            event.setGui(new fr.pierre.aleriamod.gui.GuiMainMenu());
        }
        if(event.getGui() != null && event.getGui().getClass() == GuiIngameMenu.class) {
            event.setGui(new fr.pierre.aleriamod.gui.GUiInGameMenu());
        }
    }


    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        Blocks.getInstance().init();
        event.getRegistry().registerAll(Blocks.getInstance().getBlocks().toArray(new Block[0]));
        GameRegistry.registerTileEntity(TileEntityAlergonChest.class, new ResourceLocation(Constants.MODID + ":alergon_chest"));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAlergonChest.class, new RenderAlergonChest());
    }

}
