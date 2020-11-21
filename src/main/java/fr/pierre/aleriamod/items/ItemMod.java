package fr.pierre.aleriamod.items;

import fr.pierre.aleriamod.init.Items;

public class ItemMod extends net.minecraft.item.Item {

    public ItemMod(String name) {

        this.setRegistryName(name).setUnlocalizedName(name);

        Items.getInstance().getItems().add(this);

    }


}
