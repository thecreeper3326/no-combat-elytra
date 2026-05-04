package net.creeperdev.noCombatElytra.client;

import net.creeperdev.figManagerClient.FigManagerClient;
import net.creeperdev.figManager.FigManager;
import net.creeperdev.noCombatElytra.Figs;
import net.fabricmc.api.ClientModInitializer;

public class NoCombatElytraClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        FigManagerClient g = new FigManagerClient();
        g.init(Figs.instance,0.5f);
    }
}
