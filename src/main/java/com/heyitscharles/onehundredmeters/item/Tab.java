package com.heyitscharles.onehundredmeters.item;

import com.heyitscharles.onehundredmeters.OneHundredMeters;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class Tab {

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, OneHundredMeters.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TANK_TAB = TABS.register("tank_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(TankItems.STANDARD_TANK.get()))
            .title(Component.translatable("creativetab.onehundredmeters.tanks"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(TankItems.STANDARD_TANK.get());

            }).build());


    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }

}
