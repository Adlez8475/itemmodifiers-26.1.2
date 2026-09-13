package net.adlez.itemmodifiers;

import net.adlez.itemmodifiers.event.ModifierEvents;
import net.adlez.itemmodifiers.modifiers.ModifierService;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.ServerTickEvent;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@EventBusSubscriber(modid = "itemmodifiers")
public class ItemsQueue {
    private static final Queue<QueuedItem> itemQueue = new ConcurrentLinkedQueue<>();

    public static void addItem(ItemStack stack, Player player) {
        itemQueue.offer(new QueuedItem(stack, player));
    }

    @SubscribeEvent
    public static void onServerTick(ServerTickEvent.Post event) {
        processQueue();
    }

    private static void processQueue() {
        QueuedItem queuedItem;
        for(; (queuedItem = (QueuedItem)itemQueue.poll()) != null; ModifierService.setItemNameAndColor(queuedItem.stack)) {
            if ((ModifierEvents.canHaveModifiersArmor(queuedItem.stack) || (ModifierEvents.canHaveModifiersBow(queuedItem.stack) || ModifierEvents.canHaveModifiersWeapon(queuedItem.stack))) && ModifierService.getModifier(queuedItem.stack) == null) {
                ModifierService.setModifier(queuedItem.stack, ModifierService.modifierRoll(queuedItem.stack));
            }
        }

    }

    private static class QueuedItem {
        final ItemStack stack;
        final Player player;

        QueuedItem(ItemStack stack, Player player) {
            this.stack = stack;
            this.player = player;
        }
    }
}
