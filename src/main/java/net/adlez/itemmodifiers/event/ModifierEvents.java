package net.adlez.itemmodifiers.event;


import net.adlez.itemmodifiers.ItemsQueue;
import net.adlez.itemmodifiers.modifiers.*;

import net.adlez.itemmodifiers.modifiers.Rarity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.*;
import net.minecraft.world.entity.player.Player;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;

import net.neoforged.fml.common.EventBusSubscriber;

import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.neoforged.neoforge.event.entity.player.ItemEntityPickupEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.neoforge.event.entity.player.PlayerContainerEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.level.block.BreakBlockEvent;


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
    public static void playerBlockBreak(BreakBlockEvent event) {
        LevelAccessor var2 = event.getLevel();
        if (var2 instanceof ServerLevel serverLevel) {
            Player player = event.getPlayer();
            ItemStack tool = player.getMainHandItem();
            Modifier modifier = ModifierService.getModifier(tool);
            if (modifier != null) {
                double doubleChance = getMinedDropDoubleChance(modifier);
                if (!(doubleChance <= (double)0.0F)) {
                    if (serverLevel.getRandom().nextDouble() < doubleChance) {
                        for(ItemStack drop : Block.getDrops(event.getState(), serverLevel, event.getPos(), null, player, tool )) {
                            Block.popResource(serverLevel, event.getPos(), drop.copy());
                        }
                    }
                }
            }
        }
    }

    private static double getMinedDropDoubleChance(Modifier modifier) {
        for(Modifier.ModifierAttribute entry : modifier.getAttribute()) {
            if (entry.attribute().equals(ModDataComponents.DOUBLE_DROP_CHANCE)) {
                return (entry.amount());
            }
        }
        return 0.0;
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
        for(ItemStack stack : player.getInventory().getNonEquipmentItems()) {
            if (ItemType.getItemType(stack) != ItemType.ANY && ModifierService.getModifier(stack) == null) {
                ItemsQueue.addItem(stack, player);
            }
        }
    }

    @SubscribeEvent
    public static void onChestOpen(PlayerContainerEvent.Open event) {
        if (event.getContainer() instanceof ChestMenu chestMenu && !event.getEntity().level().isClientSide()) {
            processChestItems(chestMenu);
        }
    }

    private static void processChestItems(ChestMenu chestMenu) {
        for(int i = 0; i < chestMenu.getContainer().getContainerSize(); ++i) {
            ItemStack stack = chestMenu.getContainer().getItem(i);
            if (!stack.isEmpty() && ItemType.getItemType(stack) != ItemType.ANY && ModifierService.getModifier(stack) == null) {
                ModifierService.setModifier(stack, ModifierService.modifierRoll(stack));
                ModifierService.setItemNameAndColor(stack);
                chestMenu.getContainer().setItem(i, stack);
            }
        }

    }

    /*
    @SubscribeEvent
    public static void drawingRangedWeapons(LivingEntityUseItemEvent.Start event) {
        if (event.getEntity() instanceof Player && (event.getItem().getItem() instanceof BowItem || event.getItem().getItem() instanceof CrossbowItem)) {
            ItemStack rangedWeapon = event.getItem();
        }
    }
     */

}
