package fr.pierre.aleria.init;

import fr.pierre.aleria.utils.Constants;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Items {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Constants.MODID);

    public static final RegistryObject<Item> ALERGON_INGOT = ITEMS.register("alergon_ingot", () -> new Item(new Item.Properties()));


}
