package shadows.spawnsinspawn.mixin;

import java.util.Objects;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.spawner.WorldEntitySpawner;
import shadows.spawnsinspawn.SpawnsConfig;

@Mixin(WorldEntitySpawner.class)
public abstract class MixinWorldEntitySpawner {

	/**
	 * 
	 * [VANILLA-COPY] - only changes are the commented out lines - easier to overwrite than it is to null out the branch.
	 * @Author Shadows_of_Fire
	 * @reason We need spawns in spawn!
	 */
	@Overwrite
	private static boolean isRightDistanceToPlayerAndSpawnPoint(ServerWorld world, IChunk chunk, BlockPos.Mutable pos, double distToPlayer) {
		if (distToPlayer <= SpawnsConfig.INSTANCE.minPlayerDist.get() * SpawnsConfig.INSTANCE.minPlayerDist.get()) {
			return false;
		} else if (world.getSharedSpawnPos().closerThan(new Vector3d(pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D), SpawnsConfig.INSTANCE.minSpawnDist.get())) {
			return false;
		} else {
			ChunkPos chunkpos = new ChunkPos(pos);
			return Objects.equals(chunkpos, chunk.getPos()) || world.getChunkSource().isEntityTickingChunk(chunkpos);
		}
	}
}