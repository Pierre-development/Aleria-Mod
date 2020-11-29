package fr.pierre.aleriamod.init;


import com.google.common.collect.Lists;
import fr.pierre.aleriamod.items.armors.AlergonArmor;
import fr.pierre.aleriamod.items.tools.ItemHoe;
import fr.pierre.aleriamod.items.tools.ItemPickaxe;
import fr.pierre.aleriamod.items.tools.ItemSpade;
import fr.pierre.aleriamod.items.tools.ItemSword;
import fr.pierre.aleriamod.utilis.Constants;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;

public class Items {

     private static final Items instance = new Items();

    public static net.minecraft.item.Item alergonBoots, alergonLeggings, alergonChestplate, alergonHelmet;
    public static net.minecraft.item.Item alergonSword, alergonPickaxe, alergonHoe, alergonShovel, alergonAxe;

    private List<net.minecraft.item.Item> items;

    public void init() {

        items = Lists.newArrayList();



        alergonBoots = new AlergonArmor("alergon_boots", ArmorMaterial.ALERGON, 6, EntityEquipmentSlot.FEET);
        alergonLeggings = new AlergonArmor("alergon_leggings", ArmorMaterial.ALERGON, 6, EntityEquipmentSlot.LEGS);
        alergonChestplate = new AlergonArmor("alergon_chestplate", ArmorMaterial.ALERGON, 6, EntityEquipmentSlot.CHEST);
        alergonHelmet = new AlergonArmor("alergon_helmet", ArmorMaterial.ALERGON, 6, EntityEquipmentSlot.HEAD);

        alergonSword = new ItemSword(ToolMaterial.ALERGON).setRegistryName("alergon_sword").setUnlocalizedName("alergon_sword");
        alergonPickaxe = new ItemPickaxe(ToolMaterial.ALERGON).setRegistryName("alergon_pickaxe").setUnlocalizedName("alergon_pickaxe");
        alergonHoe = new ItemHoe(ToolMaterial.ALERGON).setRegistryName("alergon_hoe").setUnlocalizedName("alergon_hoe");
        alergonShovel = new ItemSpade(ToolMaterial.ALERGON).setRegistryName("alergon_shovel").setUnlocalizedName("alergon_shovel");
       // alergonAxe = new ItemAxe(ToolMaterial.ALERGON).setRegistryName("alergon_axe").setUnlocalizedName("alergon_axe");
    }

    @SubscribeEvent
    public void registerModels(ModelRegistryEvent modelRegistryEvent) {
        for(net.minecraft.item.Item item : items) {
            registerModel(item);
        }
    }

    private void registerModel(net.minecraft.item.Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Constants.MODID, item.getUnlocalizedName().substring(5)), "inventory"));
    }

    public List<net.minecraft.item.Item> getItems() {
        return items;
    }

    public static Items getInstance() {
        return instance;
    }

    public static class ArmorMaterial {
        public static final ItemArmor.ArmorMaterial ALERGON = EnumHelper.addArmorMaterial("alergon", Constants.MODID + ":alergon", 40, new int[] {10, 10, 10, 20}, 19, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
       // public static final ItemArmor.ArmorMaterial NEODYME = EnumHelper.addArmorMaterial("neodyme", "neodyme", 50, new int[] {6, 12, 16, 6}, 19, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
    }

    public static class ToolMaterial {
        public static final net.minecraft.item.Item.ToolMaterial ALERGON = EnumHelper.addToolMaterial("alergon", 4, 2000, 15.0F, 13.0F, 14);
    }

}
