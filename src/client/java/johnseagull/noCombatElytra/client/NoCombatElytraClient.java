package johnseagull.noCombatElytra.client;

import johnseagull.figManagerClient.FigManagerClient;
import johnseagull.noCombatElytra.Figs;
import net.fabricmc.api.ClientModInitializer;

public class NoCombatElytraClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        FigManagerClient g = new FigManagerClient();
        g.init(Figs.instance,0.5f);
    }
}
