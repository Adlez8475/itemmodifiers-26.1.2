package net.adlez.itemmodifiers.modifiers;

import com.mojang.serialization.Codec;

public enum Modifier {
    UNCHANGED(Rarity.UNCHANGED),
    POINTY(Rarity.COMMON),
    RAPID(Rarity.UNCOMMON),
    MURDEROUS(Rarity.RARE),
    DEMONIC(Rarity.EPIC),
    LEGENDARY(Rarity.LEGENDARY),
    UNREAL(Rarity.MYTHIC),
    ;

    private Rarity rarity;

    public static final Codec<Modifier> MODIFIER_CODEC = Codec.STRING.xmap(Modifier::valueOf, Modifier::name);

    Modifier(Rarity rarity) {
        this.rarity = rarity;
    }

    public Rarity getRarity() {
        return this.rarity;
    }
}
