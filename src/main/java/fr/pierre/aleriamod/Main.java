package fr.pierre.aleriamod;

import fr.pierre.aleriamod.events.RegisteringEvent;
import fr.pierre.aleriamod.handlers.GuiHandlers;
import fr.pierre.aleriamod.proxy.Common;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import static fr.pierre.aleriamod.utilis.Constants.*;

@Mod(modid = MODID, name = NAME, version = VERSION)
public class Main {


    public Main() {
        MinecraftForge.EVENT_BUS.register(new RegisteringEvent());
    }

    @Mod.Instance(MODID)
    public static Main instance;

    @SidedProxy(clientSide = CLIENTPROXY, serverSide = SERVERPROXY)
    public static Common proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit();
    }


}