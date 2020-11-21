package fr.pierre.aleriamod.entities.render;

import fr.pierre.aleriamod.entities.DarkKnight;
import fr.pierre.aleriamod.utilis.Constants;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.util.ResourceLocation;

public class RenderDarkKnight extends RenderLiving<DarkKnight> {

    private final ResourceLocation texture = new ResourceLocation(Constants.MODID, "textures/entity/darkknight.png");


    public RenderDarkKnight(ModelBase modelbaseIn, float shadowsizeIn) {
        super(Minecraft.getMinecraft().getRenderManager(), modelbaseIn, shadowsizeIn);
    }

    @Override
    public ResourceLocation getEntityTexture(DarkKnight entity) {
        return texture;
    }







}
