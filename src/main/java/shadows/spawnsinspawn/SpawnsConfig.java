package shadows.spawnsinspawn;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;

public class SpawnsConfig {

	public static final ForgeConfigSpec SPEC;
	public static final SpawnsConfig INSTANCE;
	static {
		Pair<SpawnsConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(SpawnsConfig::new);
		SPEC = specPair.getRight();
		INSTANCE = specPair.getLeft();
	}

	public final IntValue minPlayerDist;
	public final IntValue minSpawnDist;

	public SpawnsConfig(ForgeConfigSpec.Builder build) {
		build.comment("Server configuration");
		build.push("server");
		minPlayerDist = build.comment("How far away (in blocks) a player must be for entities to spawn.").defineInRange("playerdist", 24, 0, 128);
		minSpawnDist = build.comment("How far away (in blocks) an entity must be from the spawn point to spawn.").defineInRange("spawndist", 0, 0, 512);
		build.pop();
	}

}
