package net.adlez.itemmodifiers.event;


import net.adlez.itemmodifiers.ItemModifiers;
import net.adlez.itemmodifiers.modifiers.Modifier;
import net.adlez.itemmodifiers.modifiers.ModifierService;
import net.adlez.itemmodifiers.modifiers.Rarity;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

@EventBusSubscriber(modid = "itemmodifiers")
public class ModifierEvents {
    public static boolean canHaveModifiersWeapon(ItemStack stack) {
        return !stack.isEmpty() && stack.get(DataComponents.WEAPON) != null;
    }
    public static boolean canHaveModifiersArmor(ItemStack stack) {
        return !stack.isEmpty() && stack.get(DataComponents.EQUIPPABLE) != null;
    }
    public static boolean canHaveModifiersBow(ItemStack stack) {
        return !stack.isEmpty() && stack.getItem() instanceof BowItem || stack.getItem() instanceof CrossbowItem;
    }

    @SubscribeEvent(
            priority = EventPriority.NORMAL,
            receiveCanceled = true
    )
    public static void itemTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        Modifier modifier = ModifierService.getModifier(stack);
        if (modifier != null && modifier.getRarity() != Rarity.UNCHANGED) {
            event.getToolTip().set(0, ((Component) event.getToolTip().getFirst()).copy().withStyle((style) -> style.withColor((modifier.getRarity().getColor()))));
        }
    }

    @SubscribeEvent
    public static void onCraftedItem(PlayerEvent.ItemCraftedEvent event) {
        ItemStack craftedItem = event.getCrafting();
        Container whereItem = event.getInventory();
        if (canHaveModifiersWeapon(craftedItem)) {
            if (ModifierService.getModifier(craftedItem) == null) {
                Modifier modifier = ModifierService.modifierRoll();
                ModifierService.setModifier(craftedItem, modifier);
                ModifierService.setItemNameAndColor(craftedItem);
                ItemModifiers.LOGGER.info("L'arme vient de recevoir le modifier {}", modifier);
                ItemModifiers.LOGGER.info("Components après modification : {}",craftedItem.getComponents());
            }
        }
        if (canHaveModifiersArmor(craftedItem)){
            ItemModifiers.LOGGER.info("Le PJ a fabriqué une armure.");
        }
        if (canHaveModifiersBow(craftedItem)) {
            ItemModifiers.LOGGER.info("Le PJ a fabriqué un arc ou une arbalète.");
        }
    }
}
