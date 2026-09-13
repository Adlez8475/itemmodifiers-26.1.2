package net.adlez.itemmodifiers.modifiers;

import net.adlez.itemmodifiers.ItemModifiers;
import net.adlez.itemmodifiers.event.ModifierEvents;
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
            modifiers = modifiers.withModifierAdded(effect.attribute(), attributeModifier, modifier.getSlot());
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

    public static Modifier modifierRoll(ItemStack stack) {
        Random random = new Random();
        int number = random.nextInt(101);
        Rarity rarity;
        EquipmentSlotGroup slot;
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

        if (rarity != Rarity.UNCHANGED) {
            int nbrRarete = 0;

            if (ModifierEvents.canHaveModifiersArmor(stack)) {
                slot = EquipmentSlotGroup.ARMOR;
                for (Modifier modifier : Modifier.values()) {
                    if (modifier.getRarity() == rarity && modifier.getSlot() == slot) {
                        nbrRarete++;
                    }
                }
            } else if (ModifierEvents.canHaveModifiersWeapon(stack) || ModifierEvents.canHaveModifiersBow(stack)) {
                slot = EquipmentSlotGroup.HAND;
                for (Modifier modifier : Modifier.values()) {
                    if (modifier.getRarity() == rarity && modifier.getSlot() == slot) {
                        nbrRarete++;
                    }
                }

            }

            Modifier[] modifiers = new Modifier[nbrRarete + 1];
            int i = 0;

            if (ModifierEvents.canHaveModifiersArmor(stack)) {
                slot = EquipmentSlotGroup.ARMOR;
                for (Modifier modifier : Modifier.values()) {
                    if (modifier.getRarity() == rarity  && modifier.getSlot() == slot) {
                        modifiers[i] = modifier;
                        i++;
                    }
                }
            }
            if (ModifierEvents.canHaveModifiersWeapon(stack) || ModifierEvents.canHaveModifiersBow(stack)) {
                slot = EquipmentSlotGroup.HAND;
                for (Modifier modifier : Modifier.values()) {
                    if (modifier.getRarity() == rarity  && modifier.getSlot() == slot) {
                        modifiers[i] = modifier;
                        i++;
                    }
                }
            }

            number = random.nextInt(nbrRarete);
            return modifiers[number];
        }
        return Modifier.UNCHANGED;
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
            }
        }
    }
}
