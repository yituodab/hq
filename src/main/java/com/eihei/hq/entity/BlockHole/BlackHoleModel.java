package com.eihei.hq.entity.BlockHole;

import com.eihei.hq.hq;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BlackHoleModel extends AnimatedGeoModel<BlackHoleEntity>{

        // TODO Auto-generated method stu

    @Override
    public ResourceLocation getModelResource(BlackHoleEntity object) {
        // TODO Auto-generated method stub
        return new ResourceLocation(hq.MODID,"geo/blackhole.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BlackHoleEntity object) {
        // TODO Auto-generated method stub
        return new ResourceLocation(hq.MODID,"textures/entity/blackhole.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BlackHoleEntity animatable) {
        // TODO Auto-generated method stub
        return null;
    }

}
