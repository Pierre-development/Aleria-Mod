package fr.pierre.aleriamod.init;

import com.google.common.collect.Lists;
import fr.pierre.aleriamod.blocks.BlockMod;
import fr.pierre.aleriamod.utilis.Constants;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.List;

public class Blocks {

    private static final Blocks instance = new Blocks();

    public static Block alergon_block;

    private List<Block> blocks;

    public void init() {

        blocks = Lists.newArrayList();

        alergon_block = new BlockMod("alergon_block", Material.IRON);
    }

    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event) {
        for(Block block : blocks) {
            registerModel(block);
        }
    }

    private void registerModel(Block block) {

        ItemBlock itemBlock = new ItemBlock(block);
        itemBlock.setRegistryName(block.getRegistryName());
        GameRegistry.findRegistry(Item.class).register(itemBlock);

        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(Constants.MODID, block.getUnlocalizedName().substring(5)), "inventory"));
    }

    public static Blocks getInstance() {
        return instance;
    }

    public List<Block> getBlocks() {
        return blocks;
    }
}
