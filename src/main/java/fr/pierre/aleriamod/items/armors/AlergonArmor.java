package fr.pierre.aleriamod.items.armors;

import fr.pierre.aleriamod.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class AlergonArmor extends ItemArmor {
    public AlergonArmor(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        this.setRegistryName(name).setUnlocalizedName(name);
        Items.getInstance().getItems().add(this);

    }

}
