package com.eihei.hq.registry;

import com.mojang.math.Vector3f;

import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.eventbus.api.IEventBus;


public class ModParticleTypes {
  
    public static final DustParticleOptions PURPLE = new DustParticleOptions(new Vector3f(Vec3.fromRGB24(11023007)), 1f);
    public static final DustParticleOptions BLACK = new DustParticleOptions(new Vector3f(Vec3.fromRGB24(0)), 1f);

    public static void register(IEventBus bus)
    {
       bus.register(PURPLE);
       bus.register(BLACK);
    }
}
