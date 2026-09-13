package net.adlez.itemmodifiers.modifiers;

import net.adlez.itemmodifiers.ItemModifiers;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import java.util.Random;

public class ModifierService {

    public static void setModifier (ItemStack stack, Modifier modifier) {
        ItemAttributeModifiers modifiers = stack.getOrDefault(DataComponents.ATTRIBUTE_MODIFIERS, ItemAttributeModifiers.EMPTY);
        for (ModifierAttribute effect : modifier.getAttribute()) {
            AttributeModifier attributeModifier = new AttributeModifier(getModifierId(modifier), effect.amount(), effect.operation());
            modifiers = modifiers.withModifierAdded(effect.attribute(), attributeModifier, effect.slot());
        }

        stack.set(DataComponents.ATTRIBUTE_MODIFIERS, modifiers);
        stack.set(ModDataComponents.MODIFIER.get(), modifier);
    }

    private static Identifier getModifierId(Modifier modifier) {
        return Identifier.fromNamespaceAndPath(
                ItemModifiers.MODID,
                "modifier." + modifier.name().toLowerCase()
        );
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
                                    AttributeModifier.Operation operation, EquipmentSlotGroup slot) {}

    public static void setItemNameAndColor(ItemStack stack) {
        Modifier modifier = ModifierService.getModifier(stack);
        if (modifier != null && modifier.getRarity() != Rarity.UNCHANGED) {
            String itemName = stack.getItemName().getString();
            String modifierName = modifier.getName();
            if (!stack.getHoverName().getString().startsWith(modifierName)) {
                MutableComponent newName = Component.translatable(modifierName + " ").append(Component.translatable(itemName)).withStyle((style) -> style.withColor(modifier.getRarity().getColor()).withItalic(false));
                stack.set(DataComponents.CUSTOM_NAME, newName);
            }
        }
    }
}
