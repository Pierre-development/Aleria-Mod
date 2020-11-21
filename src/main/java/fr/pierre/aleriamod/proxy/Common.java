package fr.pierre.aleriamod.proxy;

import fr.pierre.aleriamod.init.*;
import net.minecraftforge.common.MinecraftForge;

public class Common {

    public void preInit() {
        MinecraftForge.EVENT_BUS.register(Items.getInstance());
        MinecraftForge.EVENT_BUS.register(Blocks.getInstance());

        Entities.registerEntities();

    }

    public void init() {

    }

    public void postInit() {

    }
}
