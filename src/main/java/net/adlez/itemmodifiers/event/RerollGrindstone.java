package net.adlez.itemmodifiers.event;

import net.adlez.itemmodifiers.modifiers.ItemType;
import net.adlez.itemmodifiers.modifiers.Modifier;
import net.adlez.itemmodifiers.modifiers.ModifierService;
import net.adlez.itemmodifiers.Config;
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
            if (ItemType.getItemType(heldItem) != ItemType.ANY && ModifierService.getModifier(heldItem) != null) {
                int rerollCost = Config.REROLL_COST.get();
                if (player.experienceLevel >= rerollCost || player.isCreative()) {
                    ModifierService.removeModifier(heldItem);
                    Modifier newModifier = ModifierService.modifierRoll(heldItem);
                    ModifierService.setModifier(heldItem, newModifier);
                    ModifierService.setItemNameAndColor(heldItem);
                    if (!player.isCreative()) {
                        player.giveExperienceLevels(-rerollCost);
                    }
                    player.sendSystemMessage(Component.literal("Re-roll success!"));
                    event.getLevel().playSound(null, event.getPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS, 1.0F, 0.8F + event.getLevel().getRandom().nextFloat() * 1.2F);
                    event.setCanceled(true);
                } else {
                    player.sendSystemMessage(Component.literal("Not enough XP to re-roll. Need " + rerollCost + " levels."));
                    event.setCanceled(true);
                }
            }
        }
    }
}
