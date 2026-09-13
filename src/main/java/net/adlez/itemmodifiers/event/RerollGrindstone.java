package net.adlez.itemmodifiers.event;

import net.adlez.itemmodifiers.ItemModifiers;
import net.adlez.itemmodifiers.modifiers.Modifier;
import net.adlez.itemmodifiers.modifiers.ModifierService;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.GrindstoneBlock;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;


@EventBusSubscriber(modid = "itemmodifiers")
public class RerollGrindstone {

    @SubscribeEvent
    public static void rightClickOnGrindstone(PlayerInteractEvent.RightClickBlock event) {
        if (event.getLevel().isClientSide()) {
            return;
        }

        if (event.getLevel().getBlockState(event.getPos()).getBlock() instanceof GrindstoneBlock) {
            Player player = event.getEntity();
            ItemStack heldItem = player.getMainHandItem();
            if ((ModifierEvents.canHaveModifiersWeapon(heldItem) || ModifierEvents.canHaveModifiersBow(heldItem) || ModifierEvents.canHaveModifiersArmor(heldItem)) && ModifierService.getModifier(heldItem) != null) {
                ItemModifiers.LOGGER.info("1. Avant suppression : {}", ModifierService.getModifier(heldItem));
                ModifierService.removeModifier(heldItem);
                ItemModifiers.LOGGER.info("2. Après suppression : {}", ModifierService.getModifier(heldItem));
                Modifier newModifier = ModifierService.modifierRoll(heldItem);
                ModifierService.setModifier(heldItem, newModifier);
                ModifierService.setItemNameAndColor(heldItem);
                ItemModifiers.LOGGER.info("Reroll done");
                event.setCanceled(true);
            }
            ItemModifiers.LOGGER.info("3. Après suppression : {}", ModifierService.getModifier(heldItem));

            /*
            // ItemsQueue.addItem(heldItem, player);
            ModifierService.setModifier(heldItem, ModifierService.modifierRoll(heldItem));
            ModifierService.setItemNameAndColor(heldItem);

            ItemModifiers.LOGGER.info("Reroll done");
            ItemModifiers.LOGGER.info("Now having " + ModifierService.getModifier(heldItem).getName() + " on your " + heldItem.getItemName());

             */

            event.setCanceled(true);
        }
    }
}
