package com.eihei.hq.registry;

import com.eihei.hq.hq;
import com.eihei.hq.entity.BlockHole.BlackHoleEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
  public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister
      .create(ForgeRegistries.ENTITY_TYPES, hq.MODID);
  public static final RegistryObject<EntityType<BlackHoleEntity>> BLACKHOLE = ENTITY_TYPES.register("obsidian",
      () -> EntityType.Builder.of(BlackHoleEntity::new, MobCategory.MISC)
          .sized(1f, 1f)
          .build(new ResourceLocation(hq.MODID, "blockhole").toString()));
          // 生成的大小width height
          
          // 生成的大小width height


  public static void registry(IEventBus eventBus) {
    ENTITY_TYPES.register(eventBus);
  }

  @SubscribeEvent
  public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
    event.put(BLACKHOLE.get(), BlackHoleEntity.registerAttributes().build());
  }
}
