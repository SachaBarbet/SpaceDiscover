package io.github.spacediscover.data;

import io.github.spacediscover.SpaceDiscover;
import io.github.spacediscover.block.ModBlockTags;
import io.github.spacediscover.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {

    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SpaceDiscover.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // MINECRAFT BLOCK TAGS
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                ModBlocks.ALUMINUM_ORE.get(),
                ModBlocks.DEEPSLATE_ALUMINUM_ORE.get(),
                ModBlocks.RAW_ALUMINUM_BLOCK.get(),
                ModBlocks.ALUMINUM_BLOCK.get(),
                ModBlocks.NICKEL_ORE.get(),
                ModBlocks.DEEPSLATE_NICKEL_ORE.get(),
                ModBlocks.RAW_NICKEL_BLOCK.get(),
                ModBlocks.NICKEL_BLOCK.get(),
                ModBlocks.IRON_ROD.get(),
                ModBlocks.WIRED_IRON_ROD.get(),
                ModBlocks.MAGNETIZED_IRON_ROD.get(),
                ModBlocks.MAGNETIZED_GENERATOR.get()
        );

        this.tag(BlockTags.NEEDS_STONE_TOOL).add(
                ModBlocks.ALUMINUM_ORE.get(),
                ModBlocks.DEEPSLATE_ALUMINUM_ORE.get(),
                ModBlocks.RAW_ALUMINUM_BLOCK.get(),
                ModBlocks.ALUMINUM_BLOCK.get(),
                ModBlocks.IRON_ROD.get(),
                ModBlocks.WIRED_IRON_ROD.get(),
                ModBlocks.MAGNETIZED_IRON_ROD.get()
        );

        this.tag(BlockTags.NEEDS_IRON_TOOL).add(
                ModBlocks.NICKEL_ORE.get(),
                ModBlocks.DEEPSLATE_NICKEL_ORE.get(),
                ModBlocks.RAW_NICKEL_BLOCK.get(),
                ModBlocks.NICKEL_BLOCK.get()
        );

        // FORGE BLOCK TAGS
        this.tag(Tags.Blocks.ORES).add(
                ModBlocks.ALUMINUM_ORE.get(),
                ModBlocks.DEEPSLATE_ALUMINUM_ORE.get(),
                ModBlocks.NICKEL_ORE.get(),
                ModBlocks.DEEPSLATE_NICKEL_ORE.get()
        );

        this.tag(Tags.Blocks.ORE_RATES_SINGULAR).add(
                ModBlocks.ALUMINUM_ORE.get(),
                ModBlocks.DEEPSLATE_ALUMINUM_ORE.get(),
                ModBlocks.NICKEL_ORE.get(),
                ModBlocks.DEEPSLATE_NICKEL_ORE.get()
        );

        this.tag(Tags.Blocks.ORES_IN_GROUND_STONE).add(
                ModBlocks.ALUMINUM_ORE.get(),
                ModBlocks.NICKEL_ORE.get()
        );

        this.tag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE).add(
                ModBlocks.DEEPSLATE_ALUMINUM_ORE.get(),
                ModBlocks.DEEPSLATE_NICKEL_ORE.get()
        );

        this.tag(Tags.Blocks.STORAGE_BLOCKS).add(
                ModBlocks.RAW_ALUMINUM_BLOCK.get(),
                ModBlocks.RAW_NICKEL_BLOCK.get(),
                ModBlocks.ALUMINUM_BLOCK.get(),
                ModBlocks.NICKEL_BLOCK.get()
        );

        // MOD BLOCK TAGS
        this.tag(ModBlockTags.ORES_ALUMINUM).add(
                ModBlocks.ALUMINUM_ORE.get(),
                ModBlocks.DEEPSLATE_ALUMINUM_ORE.get()
        );
        this.tag(ModBlockTags.FORGE_ORES_ALUMINUM).addTag(ModBlockTags.ORES_ALUMINUM);

        this.tag(ModBlockTags.ORES_NICKEL).add(
                ModBlocks.NICKEL_ORE.get(),
                ModBlocks.DEEPSLATE_NICKEL_ORE.get()
        );
        this.tag(ModBlockTags.FORGE_ORES_NICKEL).addTag(ModBlockTags.ORES_NICKEL);

        this.tag(ModBlockTags.FORGE_STORAGE_ALUMINUM).add(
                ModBlocks.RAW_ALUMINUM_BLOCK.get(),
                ModBlocks.ALUMINUM_BLOCK.get()
        );

        this.tag(ModBlockTags.FORGE_STORAGE_NICKEL).add(
                ModBlocks.RAW_NICKEL_BLOCK.get(),
                ModBlocks.NICKEL_BLOCK.get()
        );
    }
}