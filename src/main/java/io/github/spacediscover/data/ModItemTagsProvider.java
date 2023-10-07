package io.github.spacediscover.data;

import io.github.spacediscover.SpaceDiscover;
import io.github.spacediscover.block.ModBlocks;
import io.github.spacediscover.item.ModItemTags;
import io.github.spacediscover.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, SpaceDiscover.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // MINECRAFT ITEM TAGS
        this.tag(ItemTags.SWORDS).add(ModItems.IRON_KNIFE.get());

        this.tag(ItemTags.PIGLIN_LOVED).add(ModItems.COPPER_WIRE.get());

        // FORGE ITEM TAGS
        this.tag(Tags.Items.RAW_MATERIALS).add(
                ModItems.RAW_ALUMINUM.get(),
                ModItems.RAW_NICKEL.get()
        );

        this.tag(Tags.Items.ORES).add(
                ModBlocks.ALUMINUM_ORE.get().asItem(),
                ModBlocks.DEEPSLATE_ALUMINUM_ORE.get().asItem(),
                ModBlocks.NICKEL_ORE.get().asItem(),
                ModBlocks.DEEPSLATE_NICKEL_ORE.get().asItem()
        );

        this.tag(Tags.Items.ORE_RATES_SINGULAR).add(
                ModBlocks.ALUMINUM_ORE.get().asItem(),
                ModBlocks.DEEPSLATE_ALUMINUM_ORE.get().asItem(),
                ModBlocks.NICKEL_ORE.get().asItem(),
                ModBlocks.DEEPSLATE_NICKEL_ORE.get().asItem()
        );

        this.tag(Tags.Items.ORES_IN_GROUND_STONE).add(
                ModBlocks.ALUMINUM_ORE.get().asItem(),
                ModBlocks.NICKEL_ORE.get().asItem()
        );

        this.tag(Tags.Items.ORES_IN_GROUND_DEEPSLATE).add(
                ModBlocks.DEEPSLATE_ALUMINUM_ORE.get().asItem(),
                ModBlocks.DEEPSLATE_NICKEL_ORE.get().asItem()
        );

        this.tag(Tags.Items.INGOTS).add(
                ModItems.ALUMINUM_INGOT.get(),
                ModItems.NICKEL_INGOT.get()
        );

        this.tag(Tags.Items.STORAGE_BLOCKS).add(
                ModBlocks.RAW_ALUMINUM_BLOCK.get().asItem(),
                ModBlocks.RAW_NICKEL_BLOCK.get().asItem(),
                ModBlocks.ALUMINUM_BLOCK.get().asItem(),
                ModBlocks.NICKEL_BLOCK.get().asItem()
        );

        // MOD ITEM TAGS
        this.tag(ModItemTags.ORES_ALUMINUM).add(
                ModBlocks.ALUMINUM_ORE.get().asItem(),
                ModBlocks.DEEPSLATE_ALUMINUM_ORE.get().asItem()
        );
        this.tag(ModItemTags.FORGE_ORES_ALUMINUM).addTag(ModItemTags.ORES_ALUMINUM);

        this.tag(ModItemTags.ORES_NICKEL).add(
                ModBlocks.NICKEL_ORE.get().asItem(),
                ModBlocks.DEEPSLATE_NICKEL_ORE.get().asItem()
        );
        this.tag(ModItemTags.FORGE_ORES_NICKEL).addTag(ModItemTags.ORES_NICKEL);

        this.tag(ModItemTags.FORGE_RAW_ALUMINUM).add(
                ModItems.RAW_ALUMINUM.get()
        );

        this.tag(ModItemTags.FORGE_RAW_NICKEL).add(
                ModItems.RAW_NICKEL.get()
        );

        this.tag(ModItemTags.FORGE_ALUMINUM_INGOT).add(
                ModItems.ALUMINUM_INGOT.get()
        );

        this.tag(ModItemTags.FORGE_NICKEL_INGOT).add(
                ModItems.NICKEL_INGOT.get()
        );

        this.tag(ModItemTags.FORGE_STORAGE_ALUMINUM).add(
                ModBlocks.RAW_ALUMINUM_BLOCK.get().asItem(),
                ModBlocks.ALUMINUM_BLOCK.get().asItem()
        );

        this.tag(ModItemTags.FORGE_STORAGE_NICKEL).add(
                ModBlocks.RAW_NICKEL_BLOCK.get().asItem(),
                ModBlocks.NICKEL_BLOCK.get().asItem()
        );
    }
}
