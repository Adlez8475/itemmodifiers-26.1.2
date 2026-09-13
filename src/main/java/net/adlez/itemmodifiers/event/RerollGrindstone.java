package net.adlez.itemmodifiers.event;

import net.adlez.itemmodifiers.modifiers.Modifier;
import net.adlez.itemmodifiers.modifiers.ModifierService;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
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
                if (player.experienceLevel >= 3 || player.isCreative()) {
                    ModifierService.removeModifier(heldItem);
                    Modifier newModifier = ModifierService.modifierRoll(heldItem);
                    ModifierService.setModifier(heldItem, newModifier);
                    ModifierService.setItemNameAndColor(heldItem);
                    if (!player.isCreative()) {
                        player.giveExperienceLevels(-3);
                    }
                    player.sendSystemMessage(Component.literal("Re-roll success!"));
                    event.getLevel().playSound(null, event.getPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS, 1.0F, 0.8F + event.getLevel().getRandom().nextFloat() * 1.2F);
                    event.setCanceled(true);
                } else {
                    player.sendSystemMessage(Component.literal("Not enough XP to re-roll. Need 3 levels."));
                    event.setCanceled(true);
                }
            }
        }
    }
}
