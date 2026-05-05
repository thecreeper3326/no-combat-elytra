package net.creeperdev.noCombatElytra;

import net.creeperdev.figManager.FigManager;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CustomData;

public class NoCombatElytra implements ModInitializer {
    public static String figManagerName = "no_combat_elytra";
    public static String projectVersion = "1.0";
    @Override
    public void onInitialize() {
        FigManager e = new FigManager();
        e.init(figManagerName,projectVersion,Figs.instance);



        ServerTickEvents.END_SERVER_TICK.register((server) -> {
            Figs f = (Figs) FigManager.FIGS;
            for (ServerPlayer player : server.getPlayerList().getPlayers()) {
                int time = 0;



                CustomData cd = player.get(DataComponents.CUSTOM_DATA);
                try {
                    CompoundTag n = cd.copyTag();
                    if (!n.contains("time_since_combat")) {
                        n.putInt("time_since_combat", f.cooldown.value + 1);
                        player.setComponent(DataComponents.CUSTOM_DATA, CustomData.of(n));
                        break;
                    }
                    if (cd.copyTag().getInt("time_since_combat").isPresent()) {
                        time = cd.copyTag().getInt("time_since_combat").get();
                    }
                    CompoundTag nbt =new CompoundTag();
                    nbt.putInt("time_since_combat",time+1);
                    player.setComponent(DataComponents.CUSTOM_DATA,CustomData.of(nbt));
                    if (time <= f.cooldown.value){
                        boolean returned = false;
                        Inventory  inv = player.getInventory();
                        ItemStack stack = inv.getItem(38);
                        if (stack.is(Items.ELYTRA) ) {
                            for(int j = 0; j < 36; ++j) {
                                ItemStack stack1 = inv.getItem(j);
                                if (stack1.is(ItemStack.EMPTY.getItem()) && !returned) {
                                    stack1 = stack.copy();
                                    inv.setItem(j, stack1);
                                    inv.setItem(38,ItemStack.EMPTY);
                                    returned = true;
                                }
                            }
                            if (!returned) {
                                player.drop(stack, false);
                                inv.setItem(38,ItemStack.EMPTY);
                            }
                        }
                        if (f.cooldown.value - time == 0) {
                            player.sendSystemMessage(Component.literal(f.complte.value),true);
                        } else {
                            String msg = f.message.value.replace("%T",String.valueOf(f.cooldown.value-time)).replace("%S",String.valueOf((Math.round((float) (f.cooldown.value - time) / 20))));
                            player.sendSystemMessage(Component.literal(msg), true);
                        }

                    }
                } catch (NullPointerException ex ){
                  CompoundTag nbt =new CompoundTag();
                    nbt.putInt("time_since_combat",f.cooldown.value+1);
                    player.setComponent(DataComponents.CUSTOM_DATA,CustomData.of(nbt));
                }
            }
        });
        

    }
}
