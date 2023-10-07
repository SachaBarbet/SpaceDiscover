package io.github.spacediscover.item;

import io.github.spacediscover.SpaceDiscover;
import io.github.spacediscover.item.custom.IronKnifeItem;
import io.github.spacediscover.item.custom.StormFireworkRocketItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SpaceDiscover.MOD_ID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
    // Items
    public static final RegistryObject<Item> RAW_ALUMINUM =
            ITEMS.register("raw_aluminum", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ALUMINUM_INGOT =
            ITEMS.register("aluminum_ingot", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_NICKEL =
            ITEMS.register("raw_nickel", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NICKEL_INGOT =
            ITEMS.register("nickel_ingot", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> STORM_FIREWORK_ROCKET =
            ITEMS.register("storm_firework_rocket", () -> new StormFireworkRocketItem(new Item.Properties()));

    public static final RegistryObject<Item> IRON_KNIFE =
            ITEMS.register("iron_knife", () -> new IronKnifeItem(new Item.Properties()));

    public static final RegistryObject<Item> COPPER_WIRE =
            ITEMS.register("copper_wire", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GOLD_WIRE =
            ITEMS.register("gold_wire", () -> new Item(new Item.Properties()));
}
