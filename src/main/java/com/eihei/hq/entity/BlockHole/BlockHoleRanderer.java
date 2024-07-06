package com.eihei.hq.entity.BlockHole;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class BlockHoleRanderer extends GeoEntityRenderer<BlackHoleEntity>{
    public BlockHoleRanderer(Context renderManager) {
        super(renderManager, new BlackHoleModel());
        this.shadowRadius = 1.0F;
        //TODO Auto-generated constructor stub
    }
        // TODO Auto-generated method stub

}
