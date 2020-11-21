package fr.pierre.aleriamod.blocks;

import fr.pierre.aleriamod.init.Blocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockMod extends Block {


    public BlockMod(String name, Material materialIn) {
        super(materialIn);

        this.setUnlocalizedName(name).setRegistryName(name);

        Blocks.getInstance().getBlocks().add(this);
    }

    public BlockMod(String name, Material materialIn, float hardness, float resistance) {
        super(materialIn);

        this.setRegistryName(name).setHardness(hardness).setResistance(resistance);

        Blocks.getInstance().getBlocks().add(this);

    }

    public BlockMod(String name, Material materialIn, float hardness, float resistance, String harvestType, int harvestLevel) {
        super(materialIn);

        this.setRegistryName(name).setHardness(hardness).setResistance(resistance).setHarvestLevel(harvestType, harvestLevel);

        Blocks.getInstance().getBlocks().add(this);

    }
}
