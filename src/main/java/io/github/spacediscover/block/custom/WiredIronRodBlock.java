package io.github.spacediscover.block.custom;

import io.github.spacediscover.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.jetbrains.annotations.NotNull;

public class WiredIronRodBlock extends IronRodBlock {
    public WiredIronRodBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.UP).setValue(WATERLOGGED, false));
    }

    @Override
    public void neighborChanged(@NotNull BlockState blockState, Level level, @NotNull BlockPos blockPos1, @NotNull Block block, @NotNull BlockPos blockPos2, boolean bool) {
        if (!level.isClientSide && level.isThundering() && level.getBlockState(blockPos2).getBlock() == Blocks.LIGHTNING_ROD) {
            if (level.getBlockState(blockPos2).getValue(BlockStateProperties.POWERED)) {
                BlockState previousBlockState = level.getBlockState(blockPos2);
                BlockState newBlockState = ModBlocks.MAGNETIZED_IRON_ROD.get().defaultBlockState().setValue(FACING, previousBlockState.getValue(BlockStateProperties.FACING)).setValue(WATERLOGGED, previousBlockState.getValue(BlockStateProperties.WATERLOGGED));
                boolean result = level.setBlock(blockPos1, newBlockState, 3);
                if (result) {
                    level.updateNeighborsAt(blockPos1, newBlockState.getBlock());
                }
            }
        }
    }
}