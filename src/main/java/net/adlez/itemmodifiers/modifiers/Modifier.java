package net.adlez.itemmodifiers.modifiers;

import com.mojang.serialization.Codec;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;


import java.util.List;

public enum Modifier {
    UNCHANGED("Unchanged",Rarity.UNCHANGED),
    POINTY(
            "Pointy",
            Rarity.COMMON,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.1,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, EquipmentSlotGroup.MAINHAND)
    ),
    RAPID(
            "Rapid",
            Rarity.UNCOMMON,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, 0.15,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, EquipmentSlotGroup.MAINHAND)
    ),
    MURDEROUS(
            "Murderous",
            Rarity.RARE,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.125F,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, EquipmentSlotGroup.MAINHAND),
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, 0.125F,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, EquipmentSlotGroup.MAINHAND)
    ),
    DEMONIC(
            "Demonic",
            Rarity.EPIC,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.15,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, EquipmentSlotGroup.MAINHAND)
    ),
    LEGENDARY(
            "Legendary",
            Rarity.LEGENDARY,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.15,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, EquipmentSlotGroup.MAINHAND),
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, 0.1,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, EquipmentSlotGroup.MAINHAND)
    ),
    UNREAL(
            "Unreal",
            Rarity.MYTHIC,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.4,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, EquipmentSlotGroup.MAINHAND),
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, 0.25F,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, EquipmentSlotGroup.MAINHAND)
    ),
    ;

    private final String name;
    private final Rarity rarity;
    private final List<ModifierService.ModifierAttribute> attribute;

    public static final Codec<Modifier> MODIFIER_CODEC = Codec.STRING.xmap(Modifier::valueOf, Modifier::name);

    Modifier(String name, Rarity rarity, ModifierService.ModifierAttribute... attribute) {
        this.name = name;
        this.rarity = rarity;
        this.attribute = List.of(attribute);
    }



    public Rarity getRarity() {
        return this.rarity;
    }
    public List<ModifierService.ModifierAttribute> getAttribute() { return this.attribute; }
    public String getName() { return this.name; }
}
