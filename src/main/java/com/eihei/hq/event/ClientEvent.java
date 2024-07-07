package com.eihei.hq.event;

import com.eihei.hq.hq;
import com.eihei.hq.utils.Keybinding;

import dev.kosmx.playerAnim.api.layered.IAnimation;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationFactory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import com.eihei.hq.registry.ModItems;

@Mod.EventBusSubscriber(modid = hq.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvent {
    public static class ClientForgeEvent{
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event){
            if(Keybinding.BT_KEY_MAPPING.consumeClick()){
                Player player = Minecraft.getInstance().player;
                ItemStack item = player.getItemInHand(InteractionHand.MAIN_HAND);
                if(item.getItem().equals(ModItems.HQ_SWORD.get())){
                    if(item.getOrCreateTag().getInt("canmeng") == 9){

                    }
                }
            }
        }
        public static void hurtEntity(LivingDamageEvent event){
            if(event.getEntity().equals(EntityType.PLAYER)){
                LivingEntity entity = event.getEntity();
                if(entity instanceof Player player){
                    ItemStack item = player.getItemInHand(InteractionHand.MAIN_HAND);
                    CompoundTag tag = item.getOrCreateTag();
                    if(item.getItem().equals(ModItems.HQ_SWORD.get())){
                        int canmeng = tag.getInt("canmeng");
                        if(canmeng < 9){
                            canmeng = canmeng + 1;
                            tag.putInt("canmeng", canmeng);
                        }
                    }
                }
            }
        }
    }
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event){
        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(
        new ResourceLocation(hq.MODID,"animation"),
        42, 
        ClientEvent::registerPlayerAnimation);
    }
    private static IAnimation registerPlayerAnimation(AbstractClientPlayer player){
        return new ModifierLayer<>();
    }
    public static class ClientModBusEvents{ 
        @SubscribeEvent
        public static void register(RegisterKeyMappingsEvent event){
            event.register(Keybinding.BT_KEY_MAPPING);
        }
    }
}
