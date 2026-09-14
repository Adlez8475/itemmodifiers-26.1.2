package net.adlez.itemmodifiers.modifiers;

import net.minecraft.world.item.*;
import net.minecraft.tags.ItemTags;


public enum ItemType {
    SWORD,
    BOW,
    ARMOR,
    TOOLS,
    ANY;

    public static ItemType getItemType(ItemStack stack) {
        if (stack.is(ItemTags.FOOT_ARMOR) || stack.is(ItemTags.LEG_ARMOR) || stack.is(ItemTags.CHEST_ARMOR) || stack.is(ItemTags.HEAD_ARMOR)) {
            return ARMOR;
        }
        if (stack.is(ItemTags.SWORDS)) {
            return SWORD;
        }
        if (stack.is(ItemTags.AXES) || stack.is(ItemTags.SHOVELS) || stack.is(ItemTags.HOES) || stack.is(ItemTags.PICKAXES)) {
            return TOOLS;
        }
        /*
        if (stack.getItem() instanceof BowItem) {
            return BOW;
        }

         */
        return ANY;
    }
}
