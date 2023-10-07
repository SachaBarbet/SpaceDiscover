package io.github.spacediscover.data.loot;

import io.github.spacediscover.block.ModBlocks;
import io.github.spacediscover.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModBlockLootSubProvider extends BlockLootSubProvider {
    public ModBlockLootSubProvider() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.RAW_ALUMINUM_BLOCK.get());
        this.dropSelf(ModBlocks.ALUMINUM_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_NICKEL_BLOCK.get());
        this.dropSelf(ModBlocks.NICKEL_BLOCK.get());

        this.add(ModBlocks.ALUMINUM_ORE.get(), block -> createOreDrop(block, ModItems.RAW_ALUMINUM.get()));
        this.add(ModBlocks.DEEPSLATE_ALUMINUM_ORE.get(), block -> createOreDrop(block, ModItems.RAW_ALUMINUM.get()));
        this.add(ModBlocks.NICKEL_ORE.get(), block -> createOreDrop(block, ModItems.RAW_NICKEL.get()));
        this.add(ModBlocks.DEEPSLATE_NICKEL_ORE.get(), block -> createOreDrop(block, ModItems.RAW_NICKEL.get()));

        this.dropSelf(ModBlocks.IRON_ROD.get());
        this.dropSelf(ModBlocks.WIRED_IRON_ROD.get());
        this.dropSelf(ModBlocks.MAGNETIZED_IRON_ROD.get());

        this.dropSelf(ModBlocks.MAGNETIZED_GENERATOR.get());
    }

    @Override
    @NotNull
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
