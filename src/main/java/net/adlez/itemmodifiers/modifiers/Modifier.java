package net.adlez.itemmodifiers.modifiers;

import com.mojang.serialization.Codec;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;


import java.util.List;

public enum Modifier {
    UNCHANGED("Unchanged",Rarity.UNCHANGED, EquipmentSlotGroup.ANY),

    // Weapons / Tools
    POINTY(
            "Pointy",
            Rarity.COMMON,
            EquipmentSlotGroup.MAINHAND,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.1,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    RAPID(
            "Rapid",
            Rarity.UNCOMMON,
            EquipmentSlotGroup.MAINHAND,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, 0.15,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    MURDEROUS(
            "Murderous",
            Rarity.RARE,
            EquipmentSlotGroup.MAINHAND,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.125F,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, 0.125F,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    DEMONIC(
            "Demonic",
            Rarity.EPIC,
            EquipmentSlotGroup.MAINHAND,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.15,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    LEGENDARY(
            "Legendary",
            Rarity.LEGENDARY,
            EquipmentSlotGroup.MAINHAND,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.15,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, 0.1,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    UNREAL(
            "Unreal",
            Rarity.MYTHIC,
            EquipmentSlotGroup.MAINHAND,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.4,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, 0.25F,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),


    // Armors
    PADDED(
            "Padded",
            Rarity.COMMON,
            EquipmentSlotGroup.ARMOR,
            new ModifierService.ModifierAttribute(Attributes.ARMOR, 1.0,
                    AttributeModifier.Operation.ADD_VALUE)
    ),
    LIGHT(
            "Light",
            Rarity.COMMON,
            EquipmentSlotGroup.ARMOR,
            new ModifierService.ModifierAttribute(Attributes.MAX_HEALTH, 0.05,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.ARMOR, -0.5,
                    AttributeModifier.Operation.ADD_VALUE)
    ),
    AGILE(
            "Agile",
            Rarity.UNCOMMON,
            EquipmentSlotGroup.ARMOR,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, 0.05,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    LUCK(
            "Luck",
            Rarity.RARE,
            EquipmentSlotGroup.ARMOR,
            new ModifierService.ModifierAttribute(Attributes.LUCK, 1.0,
                    AttributeModifier.Operation.ADD_VALUE),
            new ModifierService.ModifierAttribute(Attributes.ARMOR, 1.0, AttributeModifier.Operation.ADD_VALUE)
    ),
    WARLORD(
            "Warlord",
            Rarity.EPIC,
            EquipmentSlotGroup.ARMOR,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.1,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.ARMOR, 2.0, AttributeModifier.Operation.ADD_VALUE)
    ),
    DIVINE_PROTECTION(
            "Divine protection",
            Rarity.LEGENDARY,
            EquipmentSlotGroup.ARMOR,
            new ModifierService.ModifierAttribute(Attributes.ARMOR_TOUGHNESS, 2.0,
                    AttributeModifier.Operation.ADD_VALUE),
            new ModifierService.ModifierAttribute(Attributes.ARMOR, 3.0, AttributeModifier.Operation.ADD_VALUE
                    ),
            new ModifierService.ModifierAttribute(Attributes.KNOCKBACK_RESISTANCE, 4.0,
                    AttributeModifier.Operation.ADD_VALUE
                    )
    ),
    CELESTIAL_BLESSING(
            "Celestial blessing",
            Rarity.MYTHIC,
            EquipmentSlotGroup.ARMOR,
            new ModifierService.ModifierAttribute(Attributes.MAX_HEALTH, 0.25,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, 0.15,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.15,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.LUCK, 3.0,
                    AttributeModifier.Operation.ADD_VALUE),
            new ModifierService.ModifierAttribute(Attributes.FALL_DAMAGE_MULTIPLIER, 0.5,
                    AttributeModifier.Operation.ADD_VALUE)
    ),
    ;

    private final String name;
    private final Rarity rarity;
    private final EquipmentSlotGroup slot;
    private final List<ModifierService.ModifierAttribute> attribute;

    public static final Codec<Modifier> MODIFIER_CODEC = Codec.STRING.xmap(Modifier::valueOf, Modifier::name);

    Modifier(String name, Rarity rarity, EquipmentSlotGroup slot, ModifierService.ModifierAttribute... attribute) {
        this.name = name;
        this.rarity = rarity;
        this.slot = slot;
        this.attribute = List.of(attribute);
    }



    public Rarity getRarity() {
        return this.rarity;
    }
    public List<ModifierService.ModifierAttribute> getAttribute() { return this.attribute; }
    public String getName() { return this.name; }
    public EquipmentSlotGroup getSlot() {return this.slot; }
}
