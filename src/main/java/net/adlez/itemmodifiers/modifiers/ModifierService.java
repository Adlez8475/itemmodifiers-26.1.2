package net.adlez.itemmodifiers.modifiers;

import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;

import java.util.Random;

public class ModifierService {
    public static Modifier setModifier (ItemStack stack, Modifier modifier) {
        return stack.set(ModDataComponents.MODIFIER.get(), modifier);
    }

    public static Modifier getModifier (ItemStack stack) {
        return stack.get(ModDataComponents.MODIFIER.get());
    }

    public static Modifier modifierRoll() {
        Random random = new Random();
        int number = random.nextInt(100);
        Rarity rarity;
        if (number < Rarity.MYTHIC.getWeight()) {
            rarity = Rarity.MYTHIC;
        } else if (number < Rarity.LEGENDARY.getWeight()) {
            rarity = Rarity.LEGENDARY;
        } else if (number < Rarity.EPIC.getWeight()) {
            rarity = Rarity.EPIC;
        } else if (number < Rarity.RARE.getWeight()) {
            rarity = Rarity.RARE;
        } else if (number < Rarity.UNCOMMON.getWeight()) {
            rarity = Rarity.UNCOMMON;
        } else if (number < Rarity.COMMON.getWeight()) {
            rarity = Rarity.COMMON;
        } else {
            rarity = Rarity.UNCHANGED;
        }

        int nbrRarete = 0;

        for (Modifier modifier : Modifier.values()) {
            if (modifier.getRarity() == rarity) {
                nbrRarete++;
            }
        }

        Modifier[] modifiers = new Modifier[nbrRarete];
        int i = 0;

        for (Modifier modifier : Modifier.values()) {
            if (modifier.getRarity() == rarity) {
                modifiers[i] = modifier;
                i++;
            }
        }

        number = random.nextInt(nbrRarete);
        return modifiers[number];

    }

    public record ModifierAttribute(Holder<Attribute> attribute, double amount,
                                    AttributeModifier.Operation operation) {}

    public static void setItemNameAndColor(ItemStack stack) {
        Modifier modifier = ModifierService.getModifier(stack);
        if (modifier != null && modifier.getRarity() != Rarity.UNCHANGED) {
            String itemName = stack.getItemName().getString();
            String modifierName = modifier.getName();
            if (!stack.getHoverName().getString().startsWith(modifierName)) {
                MutableComponent newName = Component.translatable(modifierName + " ").append(Component.translatable(itemName)).withStyle((style) -> style.withColor(modifier.getRarity().getColor()).withItalic(false));
                stack.set(DataComponents.CUSTOM_NAME, newName);
            } else {
                stack.set(DataComponents.CUSTOM_NAME, null);
            }
        }
    }
}
