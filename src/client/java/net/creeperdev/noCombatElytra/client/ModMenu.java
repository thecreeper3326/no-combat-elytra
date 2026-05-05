package net.creeperdev.noCombatElytra.client;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.creeperdev.figManager.FigManager;
import net.creeperdev.figManagerClient.FigScreen;
import net.minecraft.network.chat.Component;

public class ModMenu implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return p -> new FigScreen<>(Component.literal(""), 100, FigManager.FIGS, p);
    }
}

