package fr.pierre.aleria.init;

import fr.pierre.aleria.blocks.chests.alergon.AlergonChestContainer;
import fr.pierre.aleria.utils.Constants;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerTypes {
    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES =  new DeferredRegister<>(ForgeRegistries.CONTAINERS, Constants.MODID);

    public static final RegistryObject<ContainerType<AlergonChestContainer>> ALERGON_CHEST = CONTAINER_TYPES.register("alergon_chest", () -> IForgeContainerType.create(AlergonChestContainer::new));
}
