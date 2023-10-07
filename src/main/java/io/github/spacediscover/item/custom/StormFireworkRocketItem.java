package io.github.spacediscover.item.custom;

import com.google.common.collect.Lists;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.FireworkRocketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class StormFireworkRocketItem extends FireworkRocketItem {
    public StormFireworkRocketItem(Properties properties) {
        super(properties);
    }

    public static ItemStack setTags(ItemStack itemStack) {
        CompoundTag compoundTag = itemStack.getOrCreateTagElement("Fireworks");
        compoundTag.putByte("Flight", (byte) 3);
        ListTag listTag = new ListTag();

        // Firework Explosion
        CompoundTag starCompoundTag = new CompoundTag();
        List<Integer> list = Lists.newArrayList();
        list.add(((DyeItem)Items.LIGHT_BLUE_DYE).getDyeColor().getFireworkColor());
        list.add(((DyeItem)Items.ORANGE_DYE).getDyeColor().getFireworkColor());
        starCompoundTag.putIntArray("Colors", list);
        Shape.LARGE_BALL.save(starCompoundTag);

        listTag.add(starCompoundTag);

        compoundTag.put("Explosions", listTag);

        return itemStack;
    }

    @NotNull
    public  ItemStack getDefaultInstance() {
        ItemStack itemStack = new ItemStack(this);
        return setTags(itemStack);
    }

    @Override
    public void onCraftedBy(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull Player player) {
        setTags(itemStack);
    }
}
