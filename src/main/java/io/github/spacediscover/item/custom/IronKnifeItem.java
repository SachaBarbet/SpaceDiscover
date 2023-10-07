package io.github.spacediscover.item.custom;

import io.github.spacediscover.item.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class IronKnifeItem extends Item {
    public IronKnifeItem(Properties properties) {
        super(properties.durability(128).defaultDurability(128));
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        ItemStack newItemStack = new ItemStack(ModItems.IRON_KNIFE.get());
        newItemStack.setDamageValue(itemStack.getDamageValue()+1);
        if (newItemStack.getMaxDamage() == newItemStack.getDamageValue()) {
            return ItemStack.EMPTY;
        }
        return newItemStack;
    }
}
