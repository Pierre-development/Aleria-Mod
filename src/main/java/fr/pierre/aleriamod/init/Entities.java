package fr.pierre.aleriamod.init;

import fr.pierre.aleriamod.Main;
import fr.pierre.aleriamod.entities.DarkKnight;
import fr.pierre.aleriamod.entities.render.RenderDarkKnight;
import fr.pierre.aleriamod.utilis.Constants;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Entities {

    private static int modelId = 0;

    public static void registerEntities() {
        EntityRegistry.registerModEntity(new ResourceLocation(Constants.MODID, "darkkninght"), DarkKnight.class, "DarkKnight", modelId++, Main.instance, 60, 1, true);
    }

    @SideOnly(Side.CLIENT)
    public static void registerEntitiesRenders() {
        RenderingRegistry.registerEntityRenderingHandler(DarkKnight.class, new RenderDarkKnight(new ModelPlayer(1f, false), 0.6F));
    }
}
