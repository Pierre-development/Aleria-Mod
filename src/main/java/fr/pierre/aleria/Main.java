package fr.pierre.aleria;


import fr.pierre.aleria.blocks.chests.alergon.AlergonChestScreen;
import fr.pierre.aleria.init.Blocks;
import fr.pierre.aleria.init.Items;
import fr.pierre.aleria.init.ContainerTypes;
import fr.pierre.aleria.init.TileEntities;
import fr.pierre.aleria.utils.Constants;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MODID)
public class Main {

    public Main() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);

        IEventBus iEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        TileEntities.TILE_ENTITY_TYPE.register(iEventBus);
        Items.ITEMS.register(iEventBus);
        Blocks.BLOCKS.register(iEventBus);
        ContainerTypes.CONTAINER_TYPES.register(iEventBus);
    }

    private void setup(FMLCommonSetupEvent event) {

    }

    private void clientSetup(FMLClientSetupEvent event) {
        ScreenManager.registerFactory(ContainerTypes.ALERGON_CHEST.get(), AlergonChestScreen::new);
    }
}
