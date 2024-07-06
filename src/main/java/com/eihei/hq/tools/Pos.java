package com.eihei.hq.tools;


import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class Pos {
    public static Vec3 getPos(Entity entity){
        Vec3 pos = new Vec3(entity.getX(),entity.getY(),entity.getZ());
        return pos;
    }
    public static Vec3 main(double distance,Entity entity){
        HitResult hitResult = entity.pick(distance, 0, false);
        Vec3 location = hitResult.getLocation();
        return location;
    }

    public static double getHitAngle(Vec3 location, Vec3 Pos){
        /*double c = Pos.distanceTo(location);
        double a = Math.sqrt(c*c-b*b);*/
        double x1 = Pos.x + Math.cos(0);
        double x2 = location.x;
        double x0 = Pos.x;
        double z1 = Pos.z + Math.sin(0);
        double z2 = location.z;
        double z0 = Pos.z;
        double n = Math.abs(Math.atan((x1-x0)/(z1-z0))-Math.atan((x2-x0)/(z2-z0)));
        /*for(double i = 0;i<=360;i++){
            //if(new BigDecimal(location.x).setScale(2,RoundingMode.DOWN).doubleValue() == x){
                    return i
        }*/
        return n;
    }
    public static Vec3 getAdd(Vec3 first, Vec3 second){
        double line = first.distanceTo(second);
        double x = first.x-second.x;
        double y = first.y-second.y;
        double z = first.z-second.z;
        double X = x/line;
        double Y = y/line;
        double Z = z/line;
        Vec3 add = new Vec3(X,Y,Z);
        return add;
    }
}
