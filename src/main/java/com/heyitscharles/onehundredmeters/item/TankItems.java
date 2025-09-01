package com.heyitscharles.onehundredmeters.item;

import com.heyitscharles.onehundredmeters.OneHundredMeters;
import net.minecraft.server.Services;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;
import java.util.stream.Stream;

public class TankItems {

    public static final DeferredRegister<Item> TANKS = DeferredRegister.create(ForgeRegistries.ITEMS, OneHundredMeters.MOD_ID);

    public static final RegistryObject<Item> STANDARD_TANK = TANKS.register("standard_tank", () -> new DiveItem(1));

    public static void register(IEventBus eventBus) {
        TANKS.register(eventBus);
    }
}
