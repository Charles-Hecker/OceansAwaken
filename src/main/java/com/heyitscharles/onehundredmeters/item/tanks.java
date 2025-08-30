package com.heyitscharles.onehundredmeters.item;

import com.heyitscharles.onehundredmeters.OneHundredMeters;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class tanks {

    public static final DeferredRegister<Item> TANKS = DeferredRegister.create(ForgeRegistries.ITEMS, OneHundredMeters.MOD_ID);

    public static final RegistryObject<Item> STANDARD = TANKS.register("standard", () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        TANKS.register(eventBus);
    }
}
