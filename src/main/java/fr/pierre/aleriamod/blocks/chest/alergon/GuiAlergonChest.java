package fr.pierre.aleriamod.blocks.chest.alergon;

import fr.pierre.aleriamod.utilis.Constants;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

import java.awt.*;

public class GuiAlergonChest extends GuiContainer {

    private final ResourceLocation GUI_CHEST = new ResourceLocation(Constants.MODID, "textures/gui/container/chest/alergon_chest.png");
    private final InventoryPlayer inventoryPlayer;
    private final TileEntityAlergonChest tileEntityAlergonChest;

    public GuiAlergonChest(InventoryPlayer inventoryPlayer, TileEntityAlergonChest tileEntityAlergonChest, EntityPlayer player) {
        super(new ContainerAlergonChest(inventoryPlayer, tileEntityAlergonChest, player));

        this.tileEntityAlergonChest = tileEntityAlergonChest;
        this.inventoryPlayer = inventoryPlayer;

        this.xSize = 230;
        this.ySize = 222;

    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        //this.fontRenderer.drawString(this.tileEntityAlergonChest.getDisplayName().getUnformattedText(), 8, 6, Color.RED.getRGB());
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GUI_CHEST);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
    }
}
