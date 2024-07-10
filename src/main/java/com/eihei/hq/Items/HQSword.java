package com.eihei.hq.Items;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.eihei.hq.animations.PlayAnimation;
import com.eihei.hq.tools.Pos;
import com.eihei.hq.tools.Ways;

import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

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
                entity.hurt(DamageSource.MAGIC, 40);
            }
            double XRot = player.getXRot()+180;
                int i = new Random().nextInt(2);
                if(i==0){
                    PlayAnimation.main((AbstractClientPlayer)player, "skill45");
                    //45
                    double y = player.getY()+1.5-0.9;
                    for(double m = XRot-90;m<=XRot+90;m++,y=y+0.01){
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
            player.getCooldowns().addCooldown(this, 1*20);
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
}
            //(ServerLevel)player.getLevel().addParticle(, z, count, i, r, x, z);
        
        // TODO Auto-generated method stub
    
        // TODO Auto-generated method stub
