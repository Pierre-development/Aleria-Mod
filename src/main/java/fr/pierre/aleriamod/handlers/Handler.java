package fr.pierre.aleriamod.handlers;

import fr.pierre.aleriamod.Main;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class Handler {
    @Mod.EventHandler
    public static void registerHandlers() {
        NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandlers());

    }
}
