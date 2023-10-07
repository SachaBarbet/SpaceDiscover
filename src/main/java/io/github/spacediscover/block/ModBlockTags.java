package io.github.spacediscover.block;

import io.github.spacediscover.SpaceDiscover;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags {
    public static TagKey<Block> FORGE_ORES_ALUMINUM = BlockTags.create(new ResourceLocation("forge", "ores/aluminum"));
    public static TagKey<Block> ORES_ALUMINUM = BlockTags.create(new ResourceLocation(SpaceDiscover.MOD_ID, "aluminum_ores"));
    public static TagKey<Block> FORGE_ORES_NICKEL = BlockTags.create(new ResourceLocation("forge", "ores/nickel"));
    public static TagKey<Block> ORES_NICKEL = BlockTags.create(new ResourceLocation(SpaceDiscover.MOD_ID, "nickel_ores"));

    public static TagKey<Block> FORGE_STORAGE_ALUMINUM = BlockTags.create(new ResourceLocation("forge", "storage_blocks/aluminum"));
    public static TagKey<Block> FORGE_STORAGE_NICKEL = BlockTags.create(new ResourceLocation("forge", "storage_blocks/nickel"));
}
