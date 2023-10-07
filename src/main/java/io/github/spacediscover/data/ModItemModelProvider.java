package io.github.spacediscover.data;

import io.github.spacediscover.SpaceDiscover;
import io.github.spacediscover.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SpaceDiscover.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.RAW_ALUMINUM);
        simpleItem(ModItems.ALUMINUM_INGOT);
        simpleItem(ModItems.RAW_NICKEL);
        simpleItem(ModItems.NICKEL_INGOT);

        simpleItem(ModItems.STORM_FIREWORK_ROCKET);
        simpleItem(ModItems.COPPER_WIRE);
    }

    private void simpleItem(RegistryObject<Item> item) {
        withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SpaceDiscover.MOD_ID, "item/" + item.getId().getPath()));
    }
}
