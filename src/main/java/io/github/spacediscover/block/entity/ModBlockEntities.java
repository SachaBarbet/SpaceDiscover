package io.github.spacediscover.block.entity;

import io.github.spacediscover.SpaceDiscover;
import io.github.spacediscover.block.ModBlocks;
import io.github.spacediscover.block.custom.MagnetizedGeneratorBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SpaceDiscover.MOD_ID);

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITY_TYPES.register(eventBus);
    }

    public static final RegistryObject<BlockEntityType<MagnetizedGeneratorBlockEntity>> MAGNETIZED_GENERATOR = BLOCK_ENTITY_TYPES.register("magnetized_generator", () -> BlockEntityType.Builder.of(MagnetizedGeneratorBlockEntity::new, ModBlocks.MAGNETIZED_GENERATOR.get()).build(null));
}
