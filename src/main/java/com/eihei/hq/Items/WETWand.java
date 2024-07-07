package com.eihei.hq.Items;

import com.eihei.hq.tools.Ways;

import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class WETWand extends Item{

    public WETWand(Properties arg0) {
        super(arg0);
        //TODO Auto-generated constructor stub
    }
    @Override
    public boolean hurtEnemy(ItemStack p_41395_, LivingEntity entity, LivingEntity p_41397_) {
        // TODO Auto-generated method stub
        return super.hurtEnemy(p_41395_, entity, p_41397_);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand p_41434_) {
        if(level.isClientSide()){
            Entity entity = Ways.getPointedEntity(player, 5);
            if(entity != null){
                LivingEntity livingEntity = (LivingEntity)entity;
                livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,10*20,5));
                livingEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS,10*20,5));
                for(double distance = 0.5;distance<=5;distance=distance+0.5){
                    for(double r = 0;r<=360;r=r+5){
                        double n = Math.toRadians(r);
                        double x = entity.getX()+Math.cos(n)*distance;
                        double z = entity.getZ()+Math.cos(n)*distance;
                        level.addParticle(DustParticleOptions.REDSTONE,x,entity.getY(),z,0,0,0);
                    }
                }
            }
        }
        // TODO Auto-generated method stub
        return super.use(level, player, p_41434_);
    }


}
