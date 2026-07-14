package johnseagull.noCombatElytra.mixin;

import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;

import net.minecraft.world.item.component.CustomData;
import org.apache.logging.log4j.core.jmx.Server;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(method="hurtServer",at=@At("TAIL"))
    public void handleDamageEvent(ServerLevel serverLevel, DamageSource damageSource, float f, CallbackInfoReturnable<Boolean> cir) {
        ServerPlayer me =  (ServerPlayer)(Object)this;
        if (damageSource.getEntity() instanceof ServerPlayer) {
            CompoundTag nbt =new CompoundTag();
            nbt.putInt("time_since_combat",0);
            me.setComponent(DataComponents.CUSTOM_DATA, CustomData.of(nbt));
        }
        if (damageSource.type().toString().contains("player")) {
            CompoundTag nbt =new CompoundTag();
            nbt.putInt("time_since_combat",0);
            me.setComponent(DataComponents.CUSTOM_DATA, CustomData.of(nbt));
        }
    }
}
