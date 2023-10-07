package io.github.spacediscover.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class MagnetizedIronRodBlock extends IronRodBlock {
    public MagnetizedIronRodBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.UP).setValue(WATERLOGGED, false));
    }

    @Override
    public void animateTick(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos pos, @NotNull RandomSource randomSource) {
        float particleSpawnChance = 0.80F;
        if (particleSpawnChance > randomSource.nextFloat()) {
            ParticleUtils.spawnParticlesAlongAxis(blockState.getValue(FACING).getAxis(), level, pos, 0.05D, ParticleTypes.ELECTRIC_SPARK, UniformInt.of(1, 2));
        }

        super.animateTick(blockState, level, pos, randomSource);
    }
 }