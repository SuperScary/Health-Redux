package superscary.healthredux.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import superscary.healthredux.HealthReduxMod;

@Mod.EventBusSubscriber(modid = HealthReduxMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ServerConfig
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.BooleanValue LOG_DIRT_BLOCK = BUILDER
            .comment("Whether to log the dirt block on common setup")
            .define("logDirtBlock", true);

    public static final ForgeConfigSpec SPEC = BUILDER.build();

    public static boolean logDirtBlock;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {

    }
}
