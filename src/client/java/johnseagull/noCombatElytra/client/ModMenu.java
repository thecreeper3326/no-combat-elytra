package johnseagull.noCombatElytra.client;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import johnseagull.figManager.FigManager;
import johnseagull.figManagerClient.FigScreen;
import net.minecraft.network.chat.Component;

public class ModMenu implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return p -> new FigScreen<>(Component.literal(""), 0.5f, FigManager.FIGS, p, true);
    }
}

