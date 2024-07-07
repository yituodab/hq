package com.eihei.hq.Items;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.eihei.hq.hq;
import com.eihei.hq.animations.GetAnimation;
import com.eihei.hq.tools.Pos;
import com.eihei.hq.tools.Ways;
import dev.kosmx.playerAnim.api.layered.IAnimation;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class HQSword extends Item{

    public HQSword(Properties p_43272_) {
        super(p_43272_);
        //TODO Auto-generated constructor stub
    }

    public static Map<String, KeyframeAnimationPlayer> animations = new HashMap<>();
    //TODO Auto-generated constructor stu
    @SuppressWarnings("null")
    @Override
    public boolean hurtEnemy(ItemStack item, LivingEntity entity, LivingEntity pplayer){
        AbstractClientPlayer player = Minecraft.getInstance().player;
        KeyframeAnimationPlayer animation = new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(
            new ResourceLocation(hq.MODID,"player_animation/hq/hurt.json")));//GetAnimation.main("hq/hurt");
        PlayerAnimationAccess.getPlayerAnimLayer(player).addAnimLayer(1, animation);
        if(player != null){
            ModifierLayer<IAnimation> animations = (ModifierLayer<IAnimation>)PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation(hq.MODID,"animation"));
            if(animations != null){
                animations.setAnimation(animation);
                
            }
        }
        animation.setupAnim(1);
        Vec3 pos = player.position();
        Vec3 location = entity.position();
       // Vec3 pos = Pos.getPos(play
        float angle = player.getXRot() - 90;
        //(new Vec3(entity.getX(),entity.getY(),entity.getZ()), new Vec3(player.getX(),player.getY(),player.getZ()));;
        ClientLevel level = Minecraft.getInstance().level;
        float MaxAngle = angle + 180;
        //double line = pos.distanceTo(location);
        for(double i = 0;i<=0.2;i=i+0.1){
            for(double y = location.y + 0.9;angle < MaxAngle;y = y - 0.01,angle = angle + 1){
                double r = Math.toRadians((double)angle);
                double x = pos.x + Math.cos(r)*(3+i);
                double z = pos.z + Math.sin(r)*(3+i);
                level.addParticle(DustParticleOptions.REDSTONE, x, y, z, 0, 0, 0);
            }
        }
        return super.hurtEnemy(item, entity, pplayer);
        // TODO Auto-generated method stub
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand p_41434_) {
        if(level.isClientSide()){
            Entity entity = Ways.getPointedEntity(player, 5);
            if(entity!=null){
                double XRot = player.getXRot();
                player.moveTo(entity.position());
                int i = new Random().nextInt(1)+1;
                if(i<=1){
                    //45
                    double y = player.getY()+1.5+0.9;
                    for(double m = XRot-90;m<=XRot+90;m++,y=y-0.01){
                        for(double distance = 1.5;distance<=2;distance=distance+0.1){
                        double n = Math.toRadians(m);
                        double x = player.getX() + Math.cos(n) * distance;
                        double z = player.getZ() + Math.sin(n) * distance;
                        level.addParticle(DustParticleOptions.REDSTONE,x,y,z,0,0,0);
                        }
                    }
                }
                if(i>1){
                    //90
                    double YRot = player.getYRot();
                    for(double m = YRot-90;m<=YRot+90;m++){
                        for(double distance = 1.5;distance<=2;distance=distance+0.1){
                            double r = 0;
                            if(m<=YRot)r=r+1;
                            if(m>YRot)r=r-1;
                            double n = Math.toRadians(m);
                            double y = player.getY()+1.5+Math.cos(n)*distance;
                            double x = player.getX()+player.getLookAngle().x*r;
                            double z = player.getZ()+player.getLookAngle().z*r;
                            level.addParticle(DustParticleOptions.REDSTONE,x,y,z,0,0,0);
                        }
                    }
                }
            }
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
