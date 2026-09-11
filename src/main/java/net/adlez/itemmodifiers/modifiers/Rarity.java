package net.adlez.itemmodifiers.modifiers;

import net.minecraft.ChatFormatting;

public enum Rarity {
    UNCHANGED(ChatFormatting.GRAY, 100),
    COMMON(ChatFormatting.GRAY, 55),
    UNCOMMON(ChatFormatting.GREEN, 40),
    RARE(ChatFormatting.BLUE, 25),
    EPIC(ChatFormatting.LIGHT_PURPLE, 15),
    LEGENDARY(ChatFormatting.GOLD, 8),
    MYTHIC(ChatFormatting.RED, 3);

    private final ChatFormatting color;
    private final int weight;

    private Rarity(ChatFormatting color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public ChatFormatting getColor() {
        return this.color;
    }

    public int getWeight() {
        return this.weight;
    }
}
