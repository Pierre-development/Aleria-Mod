package fr.pierre.aleriamod.proxy;

import fr.pierre.aleriamod.init.Entities;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.Display;

public class Client extends Common {

    private Minecraft mc = Minecraft.getMinecraft();

    @Override
    public void preInit() {
        super.preInit();

        Display.setTitle("Aleria | " + this.mc.getSession().getUsername());
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void postInit() {
        super.postInit();

        Entities.registerEntitiesRenders();
    }
}
