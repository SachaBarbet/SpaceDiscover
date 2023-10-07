package io.github.spacediscover.block.entity;

import io.github.spacediscover.SpaceDiscover;
import io.github.spacediscover.util.ModEnergyStorage;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RedStoneWireBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MagnetizedGeneratorBlockEntity extends BlockEntity {
    private final ModEnergyStorage ENERGY_STORAGE = new ModEnergyStorage(1000, 150) {
        @Override
        public void onChanged() {
            super.onChanged();
        }
    };
    private LazyOptional<IEnergyStorage> LAZY_ENERGY_STORAGE = LazyOptional.empty();

    public MagnetizedGeneratorBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.MAGNETIZED_GENERATOR.get(), blockPos, blockState);
    }

    public static <T extends BlockEntity> void tick(Level level, BlockPos blockPos, BlockState blockState, T t) {
        if (!level.isClientSide()) {
            SpaceDiscover.LOGGER.info("ping");
        }
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag) {
        compoundTag.putInt("magnetized_generator.energy", ENERGY_STORAGE.getEnergyStored());
        super.saveAdditional(compoundTag);
    }

    @Override
    public void load(@NotNull CompoundTag compoundTag) {
        super.load(compoundTag);
        ENERGY_STORAGE.setEnergy(compoundTag.getInt("magnetized_generator.energy"));
    }

    @Override
    public void onLoad() {
        super.onLoad();
        LAZY_ENERGY_STORAGE = LazyOptional.of(() -> ENERGY_STORAGE);
    }



    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        LAZY_ENERGY_STORAGE.invalidate();
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ENERGY) {
            if (side == null) {
                return LAZY_ENERGY_STORAGE.cast();
            }
        }
        return super.getCapability(cap);
    }

}
