package com.eihei.hq.entity.BlockHole;

import com.eihei.hq.registry.ModEntityTypes;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class BlackHoleEntity extends Mob implements IAnimatable{


  public BlackHoleEntity(EntityType<? extends Mob> p_21368_, Level p_21369_) {
    super(p_21368_, p_21369_);
    //TODO Auto-generated constructor stub
  }


  @SuppressWarnings({ "unused", "removal" })
  private AnimationFactory factory = new AnimationFactory(this);


@Override
public void registerControllers(AnimationData data) {
  // TODO Auto-generated method stub
}
  // TODO Auto-generated method stub
  // TODO Auto-generated method st


public static AttributeSupplier.Builder registerAttributes() {
  return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 100000);
  // TODO Auto-generated method stub
}


@Override
public AnimationFactory getFactory() {
  // TODO Auto-generated method stub
  return factory;
}
public static BlackHoleEntity spawn(Level level, Entity SpawnEntity, Vec3 SpawnPosition){
  BlackHoleEntity blockhole = new BlackHoleEntity(ModEntityTypes.BLACKHOLE.get(), level);
  blockhole.setPos(SpawnPosition);
  Vec3 pos = SpawnEntity.position();
  ParticleOptions particle = ParticleTypes.FALLING_OBSIDIAN_TEAR;
  double y = pos.y;
  for(int i = 1;i<=5;i++){
    for(int n = 5;n<=360;n=n+5){
      double r = Math.toRadians(n);
      double x = pos.x + Math.cos(r)*i;
      double z = pos.z + Math.sin(r)*i;
      level.addParticle(particle,x,y,z,x,y,z);
    }
  }
  level.addFreshEntity(blockhole);
  return blockhole;

}


  // TODO Auto-generated method stub

  // TODO Auto-generated method stub
}

