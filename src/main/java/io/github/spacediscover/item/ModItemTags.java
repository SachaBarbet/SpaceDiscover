package io.github.spacediscover.item;

import io.github.spacediscover.SpaceDiscover;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.tags.ItemTags;

public class ModItemTags {
    public static TagKey<Item> FORGE_ORES_ALUMINUM = ItemTags.create(new ResourceLocation("forge", "ores/aluminum"));
    public static TagKey<Item> ORES_ALUMINUM = ItemTags.create(new ResourceLocation(SpaceDiscover.MOD_ID, "aluminum_ores"));
    public static TagKey<Item> FORGE_ORES_NICKEL = ItemTags.create(new ResourceLocation("forge", "ores/nickel"));
    public static TagKey<Item> ORES_NICKEL = ItemTags.create(new ResourceLocation(SpaceDiscover.MOD_ID, "nickel_ores"));

    public static TagKey<Item> FORGE_ALUMINUM_INGOT = ItemTags.create(new ResourceLocation("forge", "ingots/aluminum"));
    public static TagKey<Item> FORGE_NICKEL_INGOT = ItemTags.create(new ResourceLocation("forge", "ingots/nickel"));
    public static TagKey<Item> FORGE_RAW_ALUMINUM = ItemTags.create(new ResourceLocation("forge", "raw_materials/aluminum"));
    public static TagKey<Item> FORGE_RAW_NICKEL = ItemTags.create(new ResourceLocation("forge", "raw_materials/nickel"));
    public static TagKey<Item> FORGE_STORAGE_ALUMINUM = ItemTags.create(new ResourceLocation("forge", "storage_blocks/aluminum"));
    public static TagKey<Item> FORGE_STORAGE_NICKEL = ItemTags.create(new ResourceLocation("forge", "storage_blocks/nickel"));
}
