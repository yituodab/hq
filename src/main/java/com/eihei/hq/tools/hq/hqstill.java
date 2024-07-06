package com.eihei.hq.tools.hq;


import com.eihei.hq.tools.Pos;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class hqstill{

        //TODO Auto-generated constructor stub
    
    //TODO Auto-generated constructor stu
    public static void Still(Entity entity, Player player,Level level,Item item){
        Vec3 pos = entity.position();
        Vec3 StartPos = player.position();
        entity.lookAt(Anchor.EYES, player.getEyePosition());
        double angle = entity.getXRot();
        Double[] Angle = new Double[2];
        Angle[0] = angle - 180;
        Angle[1] = angle + 180;
        Vec3[] vec = new Vec3[4];
        for(int n = 0;n<=1;n++){
            double y1 = pos.y-2;
            double y2 = pos.y+2;
            double r = Math.toRadians(Angle[n]);
            double x = pos.x + Math.cos(r)*2;
            double z = pos.z + Math.sin(r)*2;
            vec[n] = new Vec3(x,y1,z);
            vec[n+2] = new Vec3(x,y2,z);
        }
        for(int i = 0;i<=1;i++){
            int m = 0;
            if(i==0)m = 3;
            if(i==1)m = 2;
            Vec3 first = vec[i];
            Vec3 second = vec[m];
            Vec3 add = Pos.getAdd(first, second);
            player.getCooldowns().addCooldown(item, 1);
            player.teleportTo(first.x, first.y, first.z);
            for(double line=0;line<7;line++,first = first.add(add)){
                level.addParticle(DustParticleOptions.REDSTONE,first.x,first.y,first.z,0,0,0);
            }
            player.getCooldowns().addCooldown(item, 1);
            player.teleportTo(second.x,second.y,second.z);
        }
        player.getCooldowns().addCooldown(item, 1);
        player.teleportTo(StartPos.x,StartPos.y,StartPos.z);
        player.getCooldowns().addCooldown(item, 20);
        PrimedTnt tnt = new PrimedTnt(EntityType.TNT,level);
        tnt.setPos(pos);
        tnt.setFuse(0);
        level.addFreshEntity(tnt);
    }
}
