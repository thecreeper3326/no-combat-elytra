package johnseagull.noCombatElytra;



import johnseagull.figManager.Fig.*;


public class Figs {
    public static Figs instance = new Figs();
    public BooleanFig enable = new BooleanFig("Enable Mod","Enable the mod",true);
    public IntFig cooldown = new IntFig("Cooldown","Amount of time a player's elytra will be disabled after being attacked",1200,0,Integer.MAX_VALUE);
    public BooleanFig doMessage = new  BooleanFig("Show Message","Show message and cooldown time to players in combat",true);
    public StringFig message = new StringFig("Message", "Message to appear when a player's elytra is unequipped. %S will be replaced with seconds left. %T will be replaced with ticks left.","Elytra are disabled in combat! Usable in %S seconds",64);
    public StringFig complte = new StringFig("Restore message", "Message to appear when elytra use is restored", "Elytra are now enabled!",64);
}
