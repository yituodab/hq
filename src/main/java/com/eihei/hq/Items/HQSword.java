package com.eihei.hq.Items;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.eihei.hq.animations.PlayAnimation;
import com.eihei.hq.registry.ModParticleTypes;
import com.eihei.hq.tools.Pos;
import com.eihei.hq.tools.Ways;

import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RedStoneWireBlock;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class HQSword extends Item{

    public HQSword(Properties p_43272_) {
        super(p_43272_);
        //TODO Auto-generated constructor stub
    }
    public double PI = 2 * Math.PI;

    public static Map<String, KeyframeAnimationPlayer> animations = new HashMap<>();
    //TODO Auto-generated constructor stu
    @SuppressWarnings("null")
    @Override
    public boolean hurtEnemy(ItemStack item, LivingEntity entity, LivingEntity player){
        /*AbstractClientPlayer pplayer = Minecraft.getInstance().player;
        KeyframeAnimationPlayer animation = new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(
            new ResourceLocation(hq.MODID,"shoot")));//GetAnimation.main("hq/hurt");
        if(player != null){
            var animations = (ModifierLayer<IAnimation>)PlayerAnimationAccess.getPlayerAssociatedData(
                pplayer).
            get(new ResourceLocation(hq.MODID,"player_animation"));
            if(animations != null&&!animations.isActive()){
                animations.setAnimation(animation);
            }
        }
        double XRot = player.getXRot() + 180;
        Level level = Minecraft.getInstance().player.getLevel();
        double y = player.getY()+1.5+0.9;
        for(double m = XRot-90;m<=XRot+90;m++,y=y-0.01){
            for(double distance = 1.5;distance<=2;distance=distance+0.1){
                double r = Math.toRadians(m);
                if(r<0)r=r+PI;
                if(r>PI)r=r-PI;
                double x = player.getX() + Math.cos(r)*distance;
                double z = player.getZ() + Math.sin(r)*distance;
                level.addParticle(ModParticleTypes.PURPLE, x, y, z, 0, 0, 0);
            }
        }*/
        entity.hurt(DamageSource.MAGIC,14);
        return super.hurtEnemy(item, entity, player);
        // TODO Auto-generated method stub
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand p_41434_) {
        if(level.isClientSide()){
            Entity entity = Ways.getPointedEntity(player, 5);
            if(entity!=null){
                Skill(player, level, entity);
            }
                /*
                LivingEntity livingEntity = (LivingEntity)entity;
                if(livingEntity.getHealth()<=40)entity.kill();
                else entity.hurt(DamageSource.MAGIC,40);
                player.experienceLevel = player.experienceLevel - 1;
            }
            double XRot = player.getXRot()+180;
                int i = new Random().nextInt(2);
                if(i==0){
                    PlayAnimation.main((AbstractClientPlayer)player, "skill45");
                    //45
                    double y = player.getY()+1.5-1.8;
                    for(double m = XRot-90;m<=XRot+90;m++,y=y+0.02){
                        for(double distance = 1.5;distance<=2;distance=distance+0.1){
                        double n = Math.toRadians(m);
                        if(n<0)n=n+PI;
                        if(n>PI)n=n-PI;
                        double x = player.getX() + Math.cos(n) * distance;
                        double z = player.getZ() + Math.sin(n) * distance;
                        level.addParticle(DustParticleOptions.REDSTONE,x,y,z,0,0,0);
                        }
                    }
                }
                if(i==1){
                    PlayAnimation.main((AbstractClientPlayer)player, "skill90");
                    //90
                    double y = player.getY()+1.5-1.8;
                    for(double distance = 0.6;distance<=1.1;distance=distance+0.1){
                        double r=distance;
                        double r2=distance+0.9;
                        for(double m=XRot-90;m<=XRot;m++,y=y+0.02,r=r+0.01){
                            double n = Math.toRadians(m);
                            if(n<0)n=n+PI;
                            if(n>PI)n=n-PI;
                            double x = player.getX() + Math.cos(n)*r;
                            double z = player.getZ() + Math.sin(n)*r;
                            level.addParticle(DustParticleOptions.REDSTONE, x, y, z, 0, 0, 0);
                        }
                        for(double m=XRot;m<=XRot+90;m++,y=y+0.02,r2=r2-0.01){
                            double n = Math.toRadians(m);
                            if(n<0)n=n+PI;
                            if(n>PI)n=n-PI;
                            double x = player.getX() + Math.cos(n)*r2;
                            double z = player.getZ() + Math.sin(n)*r2;
                            level.addParticle(DustParticleOptions.REDSTONE, x, y, z, 0, 0, 0);
                        }
                    }
                }
            player.getCooldowns().addCooldown(this, 1*20);*/
        }
        
         /* 
            if(entity != null)hqstill.Still(entity, player, level,player.getItemInHand(p_41434_).getItem());
        }*/

    
            // TODO Auto-generated catch block
    
        // TODO Auto-generated method stub
    return super.use(level, player, p_41434_);
    }
    @Override
    public void inventoryTick(ItemStack item, Level p_41405_, Entity p_41406_, int p_41407_, boolean p_41408_) {
        item.getOrCreateTag().putInt("canmeng", 0);

        // TODO Auto-generated method stub
        super.inventoryTick(item, p_41405_, p_41406_, p_41407_, p_41408_);
    }
    public static void Skill(Player player,Level level,Entity entity){
        if(level.isClientSide()){
            entity.lookAt(Anchor.EYES, player.getEyePosition());
            double XRot = entity.getXRot();
            Vec3 angle1 = new Vec3(entity.getX()+Math.cos(Math.toRadians(XRot+90))*2,0,entity.getZ()+Math.cos(Math.toRadians(XRot+90))*2);
            Vec3 angle2 = new Vec3(entity.getX()+Math.cos(Math.toRadians(XRot-90))*2,0,entity.getZ()+Math.cos(Math.toRadians(XRot-90))*2);
            Vec3 vec1 = new Vec3(angle1.x,entity.getY(),angle1.z);
            Vec3 vec2 = new Vec3(angle2.x,entity.getY()+4,angle2.z);
            Vec3 vec3 = new Vec3(angle1.x,entity.getY()+4,angle1.z);
            Vec3 vec4 = new Vec3(angle2.x,entity.getY(),angle2.z);
            Vec3 add1 = Pos.getAdd(vec1, vec2);
            Vec3 add2 = Pos.getAdd(vec3, vec4);
            for(int n = 1;n<=5;n++){
                for(int i=1;i<=6;i++,vec1=vec1.add(add1)){level.addParticle(ModParticleTypes.PURPLE,vec1.x,vec1.y,vec1.z,0,0,0);}
                for(int i=1;i<=6;i++,vec3=vec4.add(add2)){level.addParticle(ModParticleTypes.PURPLE,vec3.x,vec3.y,vec3.z,0,0,0);}
            }
            /*try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            level.addParticle(ModParticleTypes.BLACK,entity.getX(),entity.getY(),entity.getZ(),0,0,0);*/
        }
    }
}
            //(ServerLevel)player.getLevel().addParticle(, z, count, i, r, x, z);
        
        // TODO Auto-generated method stub
    
        // TODO Auto-generated method stub
