package com.eihei.hq.animations;

import static dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry.getAnimation;

import com.eihei.hq.hq;

import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import net.minecraft.resources.ResourceLocation;

public class GetAnimation {

    public static KeyframeAnimationPlayer main(String location){
        KeyframeAnimationPlayer key = new KeyframeAnimationPlayer(getAnimation(new ResourceLocation(hq.MODID,"player_animation/"+location+".json")));
        return key;
    }

}
