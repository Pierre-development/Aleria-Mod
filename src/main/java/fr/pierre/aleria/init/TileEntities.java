package fr.pierre.aleria.init;

import fr.pierre.aleria.blocks.chests.alergon.AlergonChestTileEntity;
import fr.pierre.aleria.utils.Constants;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntities {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPE = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, Constants.MODID);

    public static final RegistryObject<TileEntityType<AlergonChestTileEntity>> ALERGON_CHEST  = TILE_ENTITY_TYPE.register("alergon_chest", () -> TileEntityType.Builder.create(AlergonChestTileEntity::new, Blocks.ALERGON_CHEST.get()).build(null));
}
