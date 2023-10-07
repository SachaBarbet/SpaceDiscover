package io.github.spacediscover.item;

import io.github.spacediscover.SpaceDiscover;
import io.github.spacediscover.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


public class ModCreativeModeTab {
    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB_DEFERRED_REGISTER =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SpaceDiscover.MOD_ID);

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB_DEFERRED_REGISTER.register(eventBus);
    }

    public static final RegistryObject<CreativeModeTab> SPACEDISCOVER_TAB =
            CREATIVE_MODE_TAB_DEFERRED_REGISTER.register( "spacediscover_tab", () ->
                    CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ALUMINUM_INGOT.get()))
                            .title(Component.translatable("creativetab.spacediscover_tab"))
                            .displayItems((pParameters, pOutput) -> {
                                pOutput.accept(ModItems.RAW_ALUMINUM.get());
                                pOutput.accept(ModItems.ALUMINUM_INGOT.get());
                                pOutput.accept(ModItems.RAW_NICKEL.get());
                                pOutput.accept(ModItems.NICKEL_INGOT.get());

                                pOutput.accept(ModBlocks.ALUMINUM_ORE.get());
                                pOutput.accept(ModBlocks.DEEPSLATE_ALUMINUM_ORE.get());
                                pOutput.accept(ModBlocks.RAW_ALUMINUM_BLOCK.get());
                                pOutput.accept(ModBlocks.ALUMINUM_BLOCK.get());
                                pOutput.accept(ModBlocks.NICKEL_ORE.get());
                                pOutput.accept(ModBlocks.DEEPSLATE_NICKEL_ORE.get());
                                pOutput.accept(ModBlocks.RAW_NICKEL_BLOCK.get());
                                pOutput.accept(ModBlocks.NICKEL_BLOCK.get());

                                pOutput.accept(ModBlocks.IRON_ROD.get());
                                pOutput.accept(ModBlocks.WIRED_IRON_ROD.get());
                                pOutput.accept(ModBlocks.MAGNETIZED_IRON_ROD.get());

                                pOutput.accept(ModBlocks.MAGNETIZED_GENERATOR.get());

                                pOutput.accept(ModItems.STORM_FIREWORK_ROCKET.get().getDefaultInstance());

                                pOutput.accept(ModItems.IRON_KNIFE.get());
                                pOutput.accept(ModItems.COPPER_WIRE.get());

                            })
                            .build());
}
