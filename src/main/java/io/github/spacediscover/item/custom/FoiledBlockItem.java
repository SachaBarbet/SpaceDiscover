package io.github.spacediscover.item.custom;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class FoiledBlockItem extends BlockItem {
    public FoiledBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public boolean isFoil(@NotNull ItemStack p_41453_) {
        return true;
    }

    @Override
    @NotNull
    public Rarity getRarity(@NotNull ItemStack itemStack) {
        return Rarity.RARE;
    }
}
