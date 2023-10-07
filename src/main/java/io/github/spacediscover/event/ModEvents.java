package io.github.spacediscover.event;

import io.github.spacediscover.SpaceDiscover;
import io.github.spacediscover.item.ModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.EntityLeaveLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = SpaceDiscover.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {

    @SubscribeEvent
    public static void onEntityLeaveLevel(EntityLeaveLevelEvent event) {
        Level level = event.getLevel();
        Entity entity = event.getEntity();

        // Storm firework explosion
        if (!level.isClientSide && level.dimension() == Level.OVERWORLD && !level.isThundering() && entity instanceof FireworkRocketEntity fireworkRocketEntity ) {
            ItemStack eventItem = fireworkRocketEntity.getItem();
            if (eventItem.is(ModItems.STORM_FIREWORK_ROCKET.get())) {
                ServerLevel serverLevel = Objects.requireNonNull(Objects.requireNonNull(level.getServer()).getLevel(level.dimension()));
                serverLevel.setWeatherParameters(0, 3600, true, true);
            }
        }
    }
}
