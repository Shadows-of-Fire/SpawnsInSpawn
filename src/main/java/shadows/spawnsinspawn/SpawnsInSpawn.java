package shadows.spawnsinspawn;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(SpawnsInSpawn.MODID)
public class SpawnsInSpawn {

	public static final String MODID = "spawnsinspawn";
	public static final Logger LOG = LogManager.getLogger(MODID);

	public SpawnsInSpawn() {
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, SpawnsConfig.SPEC);
	}

}
