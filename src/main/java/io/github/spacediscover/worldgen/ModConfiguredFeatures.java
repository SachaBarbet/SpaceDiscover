package io.github.spacediscover.worldgen;

import io.github.spacediscover.SpaceDiscover;
import io.github.spacediscover.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_ALUMINUM = registerKey("ore_aluminum");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_ALUMINUM_SMALL = registerKey("ore_aluminum_small");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_NICKEL_SMALL = registerKey("ore_nickel_small");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_NICKEL_LARGE = registerKey("ore_nickel_large");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_NICKEL_BURIED = registerKey("ore_nickel_buried");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest ruleTestStone = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest ruleTestDeepslate = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        List<OreConfiguration.TargetBlockState> aluminumList = List.of(OreConfiguration.target(ruleTestStone, ModBlocks.ALUMINUM_ORE.get().defaultBlockState()), OreConfiguration.target(ruleTestDeepslate, ModBlocks.DEEPSLATE_ALUMINUM_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> nickelList = List.of(OreConfiguration.target(ruleTestStone, ModBlocks.NICKEL_ORE.get().defaultBlockState()), OreConfiguration.target(ruleTestDeepslate, ModBlocks.DEEPSLATE_NICKEL_ORE.get().defaultBlockState()));
        register(context, ORE_ALUMINUM, Feature.ORE, new OreConfiguration(aluminumList, 9));
        register(context, ORE_ALUMINUM_SMALL, Feature.ORE, new OreConfiguration(aluminumList, 4));
        register(context, ORE_NICKEL_SMALL, Feature.ORE, new OreConfiguration(nickelList, 4, 0.2F));
        register(context, ORE_NICKEL_LARGE, Feature.ORE, new OreConfiguration(nickelList, 12, 0.3F));
        register(context, ORE_NICKEL_BURIED, Feature.ORE, new OreConfiguration(nickelList, 8, 1.0F));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(SpaceDiscover.MOD_ID, name));
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                         ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
