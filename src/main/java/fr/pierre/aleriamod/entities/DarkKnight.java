package fr.pierre.aleriamod.entities;

import fr.pierre.aleriamod.init.Items;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

public class DarkKnight extends EntityMob {

    public DarkKnight(World worldIn) {
        super(worldIn);

        /*this.tasks.addTask(0, new EntityAILookIdle(this));
        this.tasks.addTask(1, new EntityAITempt(this, 1D, Items.itemTest, false));*/
    }

    @Override
    public void onUpdate() {
        super.onUpdate();


    }

    @Override
    public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.8D);

    }
}
