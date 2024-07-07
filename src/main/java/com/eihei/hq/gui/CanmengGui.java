package com.eihei.hq.gui;


import com.eihei.hq.hq;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class CanmengGui {
    private static final ResourceLocation CANMENG = new ResourceLocation(hq.MODID,
            "textures/gui/canmeng.png");
    public static final IGuiOverlay HUD_CANMENG = ((gui, poseStack, partialTick, width, height) -> {
        int x = (width/5)*4;
        int y = height/5;
        RenderSystem.setShader(GameRenderer::getPositionShader);
        RenderSystem.setShaderColor(1.0F,1.0F,1.0F,1.0F);
        RenderSystem.setShaderTexture(0,CANMENG);
        GuiComponent.blit(poseStack,x,y,0,0,32,32,32,32);

    });

    
}
