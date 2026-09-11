package net.adlez.itemmodifiers;

import net.adlez.itemmodifiers.event.ModifierEvents;
import net.adlez.itemmodifiers.modifiers.Modifier;
import net.adlez.itemmodifiers.modifiers.ModifierService;
import net.adlez.itemmodifiers.modifiers.Rarity;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

import net.neoforged.neoforge.event.GrindstoneEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;



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

    /*
    @SubscribeEvent
    public static void playerIsCrafting(PlayerEvent.ItemCraftedEvent event) {
        ItemModifiers.LOGGER.info("Pj a créé un objet");
    }

    @SubscribeEvent
    public static void playerIsCrafting2(PlayerEvent.ItemCraftedEvent event) {
        ItemModifiers.LOGGER.info("Pj a créé un objet avec des modif");

    }
    */
    /*
    @SubscribeEvent
    public static void whichObject(PlayerEvent.ItemCraftedEvent event) {
        ItemStack craftedItem = event.getCrafting();
        craftedItem.getItemName().toString();
        ItemModifiers.LOGGER.info("Pj a créé " +  craftedItem.getItemName().toString() + ".");
    }
    */

    @SubscribeEvent
    public static void isWorkingPlz(PlayerEvent.ItemCraftedEvent event) {
        ItemStack craftedItem = event.getCrafting();
        ItemModifiers.LOGGER.info("CRAFT EVENT : item={}, count={}", craftedItem.getItem(), craftedItem.getCount());
        if (ModifierEvents.canHaveModifiersWeapon(craftedItem)) {
            ItemModifiers.LOGGER.info("Le PJ a fabriqué une arme.");
            Modifier test = ModifierService.getModifier(craftedItem);
            if (test != null) {
                ItemModifiers.LOGGER.info("L'arme a déjà un modifier");
            } else {
                ModifierService.setModifier(craftedItem, ModifierService.modifierRoll());
                ItemModifiers.LOGGER.info("L'arme vient de recevoir le modifier " + ModifierService.getModifier(craftedItem).toString());
                for (ModifierService.ModifierAttribute attribute : ModifierService.getModifier(craftedItem).getAttribute()) {
                    ItemModifiers.LOGGER.info(attribute.toString());
                }


            }
        }
        if (ModifierEvents.canHaveModifiersArmor(craftedItem)){
            ItemModifiers.LOGGER.info("Le PJ a fabriqué une armure.");
        }
        if (ModifierEvents.canHaveModifiersBow(craftedItem)) {
            ItemModifiers.LOGGER.info("Le PJ a fabriqué un arc.");
        }
    }

    @SubscribeEvent(
            priority = EventPriority.NORMAL,
            receiveCanceled = true
    )
    public static void itemTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        Modifier modifier = ModifierService.getModifier(stack);
        if (modifier != null && modifier.getRarity() != Rarity.UNCHANGED) {

            Component modifierName = Component.literal(modifier.getName());

            Component originalName = ((Component)event.getToolTip().get(0)).copy().withStyle((style -> style.withColor(modifier.getRarity().getColor()).withItalic(false)));

            event.getToolTip().set(
                    0,
                    modifierName.copy().append(" ").append(originalName).withStyle(style -> style.withColor(modifier.getRarity().getColor()).withItalic(false))
            );
        }
    }
}