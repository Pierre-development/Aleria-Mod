package fr.pierre.aleriamod.proxy;

import fr.pierre.aleriamod.handlers.GuiHandlers;
import fr.pierre.aleriamod.handlers.Handler;
import fr.pierre.aleriamod.init.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class Common {

    public void preInit() {
        MinecraftForge.EVENT_BUS.register(Items.getInstance());
        MinecraftForge.EVENT_BUS.register(Blocks.getInstance());

        Entities.registerEntities();

    }

    public void init() {
        Handler.registerHandlers();
    }

    public void postInit() {

    }
}
