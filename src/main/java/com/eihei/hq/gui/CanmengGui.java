package com.eihei.hq.gui;


import com.eihei.hq.hq;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.font.FontSet;
import net.minecraft.client.gui.font.FontTexture;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class CanmengGui {
    private static final ResourceLocation CANMENG = new ResourceLocation(hq.MODID,
            "textures/gui/canmeng.png");
    public static final IGuiOverlay HUD_CANMENG = ((gui, poseStack, partialTick, width, height) -> {
    int x = width/2;
    int y = height;

    RenderSystem.setShader(GameRenderer::getPositionShader);
    RenderSystem.setShaderColor(1.0F,1.0F,1.0F,1.0F);
    RenderSystem.setShaderTexture(0,CANMENG);

    for(int i=0;i<10;i++){
        GuiComponent.blit(poseStack,x-94 + (i * 9),y-54,0,0,12,12,12,12);
    }

    });

    
}
