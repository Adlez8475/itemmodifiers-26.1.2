package net.adlez.itemmodifiers.event;


import net.adlez.itemmodifiers.ItemsQueue;
import net.adlez.itemmodifiers.modifiers.ItemType;
import net.adlez.itemmodifiers.modifiers.Modifier;
import net.adlez.itemmodifiers.modifiers.ModifierService;
import net.adlez.itemmodifiers.modifiers.Rarity;

import net.minecraft.world.item.*;
import net.minecraft.world.entity.player.Player;

import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;

import net.neoforged.fml.common.EventBusSubscriber;

import net.neoforged.neoforge.event.entity.player.ItemEntityPickupEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;


@EventBusSubscriber(modid = "itemmodifiers")
public class ModifierEvents {

    @SubscribeEvent(
            priority = EventPriority.NORMAL,
            receiveCanceled = true
    )
    public static void itemTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        Modifier modifier = ModifierService.getModifier(stack);
        if (modifier != null && modifier.getRarity() != Rarity.UNCHANGED) {
            event.getToolTip().set(0, (event.getToolTip().getFirst()).copy().withStyle((style) -> style.withColor((modifier.getRarity().getColor()))));
        }
    }


    // Cover events or things that entities do to
    @SubscribeEvent
    public static void inventoryChanged(ItemEntityPickupEvent.Post event) {
        processInventory(event.getPlayer());
    }



    @SubscribeEvent
    public static void playerJoiningWorld (PlayerEvent.PlayerLoggedInEvent event) {
        processInventory(event.getEntity());
    }

    @SubscribeEvent
    public static void onCraftedItem(PlayerEvent.ItemCraftedEvent event) {
        ItemStack craftedItem = event.getCrafting();
        if (ItemType.getItemType(craftedItem) != ItemType.ANY) {
            if (ModifierService.getModifier(craftedItem) == null) {
                ItemsQueue.addItem(craftedItem, event.getEntity());
            }
        }
        processInventory(event.getEntity());
    }


    private static void processInventory(Player player) {
        for(ItemStack stack : player.getInventory()) {
            if (ItemType.getItemType(stack) != ItemType.ANY && ModifierService.getModifier(stack) == null) {
                ItemsQueue.addItem(stack, player);
            }
        }
    }
}
