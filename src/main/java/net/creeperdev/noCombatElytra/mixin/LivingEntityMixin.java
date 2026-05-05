package net.creeperdev.noCombatElytra.mixin;

import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;

import net.minecraft.world.item.component.CustomData;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Inject(method="handleDamageEvent",at=@At("HEAD"))
    public void handleDamageEvent(DamageSource damageSource, CallbackInfo ci) {
        if (damageSource.getEntity() instanceof ServerPlayer me) {
            CompoundTag nbt =new CompoundTag();
            nbt.putInt("time_since_combat",0);
            me.setComponent(DataComponents.CUSTOM_DATA, CustomData.of(nbt));
        }
    }
}
