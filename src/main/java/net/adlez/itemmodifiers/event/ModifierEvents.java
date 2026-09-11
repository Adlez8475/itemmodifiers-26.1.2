package net.adlez.itemmodifiers.event;


import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;

public class ModifierEvents {
    public static boolean canHaveModifiersWeapon(ItemStack stack) {
        return !stack.isEmpty() && stack.get(DataComponents.WEAPON) != null;
    }
    public static boolean canHaveModifiersArmor(ItemStack stack) {
        return !stack.isEmpty() && stack.get(DataComponents.EQUIPPABLE) != null;
    }
    public static boolean canHaveModifiersBow(ItemStack stack) {
        return !stack.isEmpty() && stack.getItem() instanceof BowItem;
    }
}
