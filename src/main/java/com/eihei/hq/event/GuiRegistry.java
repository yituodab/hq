package com.eihei.hq.event;

import com.eihei.hq.hq;
import com.eihei.hq.gui.CanmengGui;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = hq.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class GuiRegistry {
    @SubscribeEvent
    public static void registerGui(RegisterGuiOverlaysEvent event){
        event.registerAboveAll("canmeng", CanmengGui.HUD_CANMENG);

    }


}
