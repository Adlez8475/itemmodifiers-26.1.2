package net.adlez.itemmodifiers.modifiers;

import net.minecraft.world.item.ItemStack;

import java.util.Random;

public class ModifierService {
    public static Modifier setModifier (ItemStack stack, Modifier modifier) {
        return stack.set(ModifierRegistry.MODIFIER.get(), modifier);
    }
    public static Modifier getModifier (ItemStack stack) {
        return stack.get(ModifierRegistry.MODIFIER.get());
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
}
