package net.adlez.itemmodifiers;

import net.adlez.itemmodifiers.event.ModifierEvents;
import net.adlez.itemmodifiers.modifiers.Modifier;
import net.adlez.itemmodifiers.modifiers.ModifierService;

import net.minecraft.world.item.ItemStack;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

import net.neoforged.neoforge.event.GrindstoneEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;


// Reroll on Grindstone
@EventBusSubscriber(modid = "itemmodifiers")
public class DebugModifiers {

    @SubscribeEvent
    public static void onPlaceIteminGrindstone(GrindstoneEvent.OnPlaceItem event) {
        ItemModifiers.LOGGER.info("Placement d'un objet dans le tailleur de pierre");
        ItemStack stack = event.getOutput();
        if (ModifierEvents.canHaveModifiersWeapon(stack) || ModifierEvents.canHaveModifiersBow(stack) || ModifierEvents.canHaveModifiersArmor(stack)) {
            ItemModifiers.LOGGER.info("Possibilité de reroll.");
        }
    }

    @SubscribeEvent
    public static void onTakeIteminGrindstone(GrindstoneEvent.OnTakeItem event) {
        ItemModifiers.LOGGER.info("Retrait d'un objet dans le tailleur de pierre");
    }

    // Trying to apply modifiers compared to their nature (weapons, armor or bow)
}