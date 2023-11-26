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

    private static final ForgeConfigSpec.BooleanValue ENABLED = BUILDER.comment("Globally enables the mod.").define("enabled", true);
    private static final ForgeConfigSpec.DoubleValue DEFAULT_PLAYER_HEALTH_VALUE = BUILDER.comment("The default player health.").defineInRange("defaultPlayerHealth", 100d, 0, 1000);
    private static final ForgeConfigSpec.DoubleValue DEFAULT_PLAYER_BLOOD_VALUE = BUILDER.comment("The default player blood amount.").defineInRange("defaultPlayerBlood", 120d, 0, 1000);


    public static final ForgeConfigSpec SPEC = BUILDER.build();

    public static boolean enabled;

    public static double defaultPlayerHealth;
    public static double defaultPlayerBloodAmount;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        enabled = ENABLED.get();

        defaultPlayerHealth = DEFAULT_PLAYER_HEALTH_VALUE.get();
        defaultPlayerBloodAmount = DEFAULT_PLAYER_BLOOD_VALUE.get();
    }
}
