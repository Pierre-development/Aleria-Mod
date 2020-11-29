package fr.pierre.aleriamod.blocks.chest.alergon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * ModelChest - Either Mojang or a mod author
 * Created using Tabula 7.1.0
 */

@SideOnly(Side.CLIENT)
public class ModelAlergonChest extends ModelBase {
    public ModelRenderer handle;
    public ModelRenderer lid;
    public ModelRenderer storage;

    public ModelAlergonChest() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.lid = new ModelRenderer(this, 0, 0);
        this.lid.setRotationPoint(1.0F, 7.0F, 15.0F);
        this.lid.addBox(0.0F, -5.0F, -14.0F, 14, 5, 14, 0.0F);
        this.handle = new ModelRenderer(this, 0, 0);
        this.handle.setRotationPoint(8.0F, 7.0F, 15.0F);
        this.handle.addBox(-1.0F, -2.0F, -15.0F, 2, 4, 1, 0.0F);
        this.storage = new ModelRenderer(this, 0, 19);
        this.storage.setRotationPoint(1.0F, 6.0F, 1.0F);
        this.storage.addBox(0.0F, 0.0F, 0.0F, 14, 10, 14, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.lid.render(f5);
        this.handle.render(f5);
        this.storage.render(f5);
    }

    public void renderAll() {
        this.handle.rotateAngleX = this.lid.rotateAngleX;
        this.lid.render(0.0625F);
        this.handle.render(0.0625F);
        this.storage.render(0.0625F);

    }
}
