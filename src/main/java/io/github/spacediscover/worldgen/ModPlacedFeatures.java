package io.github.spacediscover.worldgen;

import io.github.spacediscover.SpaceDiscover;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> ORE_ALUMINUM = createKey("ore_aluminum");
    public static final ResourceKey<PlacedFeature> ORE_ALUMINUM_SMALL = createKey("ore_aluminum_small");
    public static final ResourceKey<PlacedFeature> ORE_NICKEL_SMALL = createKey("ore_nickel_small");
    public static final ResourceKey<PlacedFeature> ORE_NICKEL_LARGE = createKey("ore_nickel_large");
    public static final ResourceKey<PlacedFeature> ORE_NICKEL_BURIED = createKey("ore_nickel_buried");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);

        Holder<ConfiguredFeature<?, ?>> holderOreAluminum = holdergetter.getOrThrow(ModConfiguredFeatures.ORE_ALUMINUM);
        Holder<ConfiguredFeature<?, ?>> holderOreAluminumSmall = holdergetter.getOrThrow(ModConfiguredFeatures.ORE_ALUMINUM_SMALL);
        Holder<ConfiguredFeature<?, ?>> holderOreNickelSmall = holdergetter.getOrThrow(ModConfiguredFeatures.ORE_NICKEL_SMALL);
        Holder<ConfiguredFeature<?, ?>> holderOreNickelLarge = holdergetter.getOrThrow(ModConfiguredFeatures.ORE_NICKEL_LARGE);
        Holder<ConfiguredFeature<?, ?>> holderOreNickelBuried = holdergetter.getOrThrow(ModConfiguredFeatures.ORE_NICKEL_BURIED);

        register(context, ORE_ALUMINUM, holderOreAluminum, ModOrePlacement.commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(40))));
        register(context, ORE_ALUMINUM_SMALL, holderOreAluminumSmall, ModOrePlacement.commonOrePlacement(8, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(72))));
        register(context, ORE_NICKEL_SMALL, holderOreNickelSmall, ModOrePlacement.commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
        register(context, ORE_NICKEL_LARGE, holderOreNickelLarge, ModOrePlacement.rareOrePlacement(12, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
        register(context, ORE_NICKEL_BURIED, holderOreNickelBuried, ModOrePlacement.commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
    }

    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(SpaceDiscover.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuredFeatureHolder, List<PlacementModifier> modifierList) {
        context.register(key, new PlacedFeature(configuredFeatureHolder, List.copyOf(modifierList)));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuredFeatureHolder, PlacementModifier... modifiers) {
        register(context, key, configuredFeatureHolder, List.of(modifiers));
    }
}
