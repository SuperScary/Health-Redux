package superscary.healthredux.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import superscary.healthredux.HealthReduxMod;

@Mod.EventBusSubscriber(modid = HealthReduxMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonConfig
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    /**
     * Globals
     */
    private static final ForgeConfigSpec.BooleanValue ENABLED = BUILDER.comment("Globally enables the mod.").define("enabled", true);
    private static final ForgeConfigSpec.BooleanValue ADAPTIVE_LEARNING = BUILDER.comment("Allows for entity AI to adaptively learn (Machine Learning).").define("adaptiveLearning", true);
    private static final ForgeConfigSpec.BooleanValue MODIFY_VANILLA_MOBS = BUILDER.comment("Allows Health Redux to modify the behavior of vanilla mobs.").define("modVanillaMobs", true);
    private static final ForgeConfigSpec.BooleanValue REALISTIC_INJURIES = BUILDER.comment("Allows for realistic injuries.").define("realisticInjuries", false);

    /**
     * FOOD
     */
    private static final ForgeConfigSpec.BooleanValue EATING_HEALS = BUILDER.comment("Allows the player to heal by eating food.").define("eatingHeals", false);

    /**
     * Player Values
     */
    private static final ForgeConfigSpec.DoubleValue DEFAULT_PLAYER_HEALTH_VALUE = BUILDER.comment("The default player health.").defineInRange("defaultPlayerHealth", 100d, 0, 1000);
    private static final ForgeConfigSpec.DoubleValue DEFAULT_PLAYER_BLOOD_VALUE = BUILDER.comment("The default player blood amount.").defineInRange("defaultPlayerBlood", 120d, 0, 1000);


    public static final ForgeConfigSpec SPEC = BUILDER.build();

    public static boolean enabled;
    public static boolean adaptiveLearning;
    public static boolean modVanillaMobs;
    public static boolean realisticInjuries;
    public static boolean eatingHeals;

    public static double defaultPlayerHealth;
    public static double defaultPlayerBloodAmount;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        enabled = ENABLED.get();
        adaptiveLearning = ADAPTIVE_LEARNING.get();
        modVanillaMobs = MODIFY_VANILLA_MOBS.get();
        realisticInjuries = REALISTIC_INJURIES.get();

        eatingHeals = EATING_HEALS.get();

        defaultPlayerHealth = DEFAULT_PLAYER_HEALTH_VALUE.get();
        defaultPlayerBloodAmount = DEFAULT_PLAYER_BLOOD_VALUE.get();
    }
}
