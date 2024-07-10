package com.eihei.hq.animations;

import com.eihei.hq.hq;

import dev.kosmx.playerAnim.api.layered.IAnimation;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.resources.ResourceLocation;

public class PlayAnimation {
    public static void main(AbstractClientPlayer player,String location){
        KeyframeAnimationPlayer animation = new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation(hq.MODID,location)));
        if(player != null){
            var animations = (ModifierLayer<IAnimation>)PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation(hq.MODID,"player_animation"));
            if(animations != null && ! animations.isActive()){
                animations.setAnimation(animation);
            }
        }
    }

}
