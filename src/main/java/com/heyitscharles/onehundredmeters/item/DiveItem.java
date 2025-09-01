package com.heyitscharles.onehundredmeters.item;

import com.heyitscharles.onehundredmeters.effect.OxygenEffectContainer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;


public class DiveItem extends Item implements ICurioItem {

    int availableTicks;
    int tickCount = 0;

    public DiveItem(int Tier) {

        super(new Item.Properties().stacksTo(1).defaultDurability(0));

        availableTicks = ((Tier * 600) - 300);

    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {

        Player player = (Player) slotContext.entity();

        if ((tickCount != 0) && (tickCount != availableTicks)) player.addEffect(new MobEffectInstance(OxygenEffectContainer.OXYGEN.get(), (availableTicks - tickCount)));

        if (player.isUnderWater()) {
            //Counts down available ticks if underwater
            if (tickCount != availableTicks) {
                tickCount++;
            }

        } else {

            //Regenerate 10 seconds of oxygen per second when out of water
            if (tickCount > 0) {
                tickCount -= 10;
            }

            //Clamp tick count above 0
            if (tickCount <= 0) {
                player.removeEffect(OxygenEffectContainer.OXYGEN.get());
                tickCount = 0;
            }
        }

        ICurioItem.super.curioTick(slotContext, stack);
    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {

        Player player = (Player) slotContext.entity();

        if (player.hasEffect(OxygenEffectContainer.OXYGEN.get())) {
            player.removeEffect(OxygenEffectContainer.OXYGEN.get());
        }

        ICurioItem.super.onUnequip(slotContext, newStack, stack);
    }
}
