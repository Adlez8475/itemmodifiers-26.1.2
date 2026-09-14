package net.adlez.itemmodifiers.modifiers;

import com.mojang.serialization.Codec;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;


import java.util.List;

public enum Modifier {
    UNCHANGED("Unchanged",Rarity.UNCHANGED, EquipmentSlotGroup.ANY, ItemType.ANY),

    // Weapons
    HEFTY_WEAPON(
            "Hefty",
            Rarity.COMMON,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.MOVEMENT_SPEED, -0.05, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    POINTY(
            "Pointy",
            Rarity.COMMON,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.1,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    RAPID(
            "Rapid",
            Rarity.UNCOMMON,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, 0.15,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    MURDEROUS(
            "Murderous",
            Rarity.RARE,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.125F,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, 0.125F,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    DEMONIC(
            "Demonic",
            Rarity.EPIC,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.15,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    LEGENDARY(
            "Legendary",
            Rarity.LEGENDARY,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.15,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, 0.1,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    UNREAL(
            "Unreal",
            Rarity.MYTHIC,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.4,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, 0.25F,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),

    // Tool
    HEFTY_TOOL(
            "Hefty",
            Rarity.COMMON,
            EquipmentSlotGroup.MAINHAND,
            ItemType.TOOLS,
            new ModifierService.ModifierAttribute(Attributes.MOVEMENT_SPEED, -0.05, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    STURDY(
            "Sturdy",
            Rarity.UNCOMMON,
            EquipmentSlotGroup.MAINHAND,
            ItemType.TOOLS,
            new ModifierService.ModifierAttribute(Attributes.BLOCK_BREAK_SPEED,0.2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    EFFICIENT(
            "Efficient",
            Rarity.UNCOMMON,
            EquipmentSlotGroup.MAINHAND,
            ItemType.TOOLS,
            new ModifierService.ModifierAttribute(Attributes.BLOCK_BREAK_SPEED,0.15,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    FORTUITOUS(
          "Fortuitous",
          Rarity.RARE,
          EquipmentSlotGroup.MAINHAND,
          ItemType.TOOLS,
          new ModifierService.ModifierAttribute(ModDataComponents.DOUBLE_DROP_CHANCE, 0.1, AttributeModifier.Operation.ADD_VALUE)
    ),
    PROSPECTOR(
          "Prospector",
          Rarity.RARE,
          EquipmentSlotGroup.MAINHAND,
          ItemType.TOOLS,
          new ModifierService.ModifierAttribute(Attributes.BLOCK_BREAK_SPEED,0.1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
          new ModifierService.ModifierAttribute(ModDataComponents.DOUBLE_DROP_CHANCE, 0.15, AttributeModifier.Operation.ADD_VALUE)
    ),
    FLEET(
            "Fleet",
            Rarity.EPIC,
            EquipmentSlotGroup.MAINHAND,
            ItemType.TOOLS,
            new ModifierService.ModifierAttribute(Attributes.BLOCK_BREAK_SPEED,0.1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.MOVEMENT_SPEED,0.2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    LUCKY(
            "Lucky",
            Rarity.EPIC,
            EquipmentSlotGroup.MAINHAND,
            ItemType.TOOLS,
            new ModifierService.ModifierAttribute(Attributes.LUCK,2.0, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(ModDataComponents.DOUBLE_DROP_CHANCE, 0.15, AttributeModifier.Operation.ADD_VALUE)
    ),
    ARCANE(
            "Arcane",
            Rarity.EPIC,
            EquipmentSlotGroup.MAINHAND,
            ItemType.TOOLS,
            new ModifierService.ModifierAttribute(Attributes.BLOCK_BREAK_SPEED,0.3, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(ModDataComponents.DOUBLE_DROP_CHANCE, 0.2, AttributeModifier.Operation.ADD_VALUE)
    ),
    MIGHTY(
            "Mighty",
            Rarity.LEGENDARY,
            EquipmentSlotGroup.MAINHAND,
            ItemType.TOOLS,
            new ModifierService.ModifierAttribute(Attributes.BLOCK_BREAK_SPEED,0.5, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    EARTH_SHAKER(
            "Earth Shaker",
            Rarity.LEGENDARY,
            EquipmentSlotGroup.MAINHAND,
            ItemType.TOOLS,
            new ModifierService.ModifierAttribute(Attributes.BLOCK_BREAK_SPEED,0.75, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(ModDataComponents.DOUBLE_DROP_CHANCE, 0.3, AttributeModifier.Operation.ADD_VALUE)
    ),
    ETERNAL(
            "Eternal",
            Rarity.MYTHIC,
            EquipmentSlotGroup.MAINHAND,
            ItemType.TOOLS,
            new ModifierService.ModifierAttribute(Attributes.MOVEMENT_SPEED,0.25, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    TITANIC(
            "Titanic",
            Rarity.MYTHIC,
            EquipmentSlotGroup.MAINHAND,
            ItemType.TOOLS,
            new ModifierService.ModifierAttribute(Attributes.MOVEMENT_SPEED,1.0, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(ModDataComponents.DOUBLE_DROP_CHANCE, 0.25, AttributeModifier.Operation.ADD_VALUE)
    ),
    COSMIC(
            "Cosmic",
            Rarity.MYTHIC,
            EquipmentSlotGroup.MAINHAND,
            ItemType.TOOLS,
            new ModifierService.ModifierAttribute(Attributes.MOVEMENT_SPEED,1.5, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(ModDataComponents.DOUBLE_DROP_CHANCE, 0.4, AttributeModifier.Operation.ADD_VALUE),
            new ModifierService.ModifierAttribute(Attributes.MOVEMENT_SPEED, 0.3, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),


    // Armors
    HEFTY_ARMOR(
            "Hefty",
            Rarity.COMMON,
            EquipmentSlotGroup.ARMOR,
            ItemType.ARMOR,
            new ModifierService.ModifierAttribute(Attributes.MOVEMENT_SPEED, -0.05, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    PADDED(
            "Padded",
            Rarity.COMMON,
            EquipmentSlotGroup.ARMOR,
            ItemType.ARMOR,
            new ModifierService.ModifierAttribute(Attributes.ARMOR, 1.0,
                    AttributeModifier.Operation.ADD_VALUE)
    ),
    LIGHT(
            "Light",
            Rarity.COMMON,
            EquipmentSlotGroup.ARMOR,
            ItemType.ARMOR,
            new ModifierService.ModifierAttribute(Attributes.MAX_HEALTH, 0.05,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.ARMOR, -0.5,
                    AttributeModifier.Operation.ADD_VALUE)
    ),
    AGILE(
            "Agile",
            Rarity.UNCOMMON,
            EquipmentSlotGroup.ARMOR,
            ItemType.ARMOR,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, 0.05,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    LUCK(
            "Luck",
            Rarity.RARE,
            EquipmentSlotGroup.ARMOR,
            ItemType.ARMOR,
            new ModifierService.ModifierAttribute(Attributes.LUCK, 1.0,
                    AttributeModifier.Operation.ADD_VALUE),
            new ModifierService.ModifierAttribute(Attributes.ARMOR, 1.0, AttributeModifier.Operation.ADD_VALUE)
    ),
    WARLORD(
            "Warlord",
            Rarity.EPIC,
            EquipmentSlotGroup.ARMOR,
            ItemType.ARMOR,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.1,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.ARMOR, 2.0, AttributeModifier.Operation.ADD_VALUE)
    ),
    DIVINE_PROTECTION(
            "Divine protection",
            Rarity.LEGENDARY,
            EquipmentSlotGroup.ARMOR,
            ItemType.ARMOR,
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
            ItemType.ARMOR,
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
    private final ItemType type;
    private final List<ModifierService.ModifierAttribute> attribute;


    public static final Codec<Modifier> MODIFIER_CODEC = Codec.STRING.xmap(Modifier::valueOf, Modifier::name);

    Modifier(String name, Rarity rarity, EquipmentSlotGroup slot,
             ItemType type, ModifierService.ModifierAttribute... attribute) {
        this.name = name;
        this.rarity = rarity;
        this.slot = slot;
        this.type = type;
        this.attribute = List.of(attribute);
    }



    public Rarity getRarity() {
        return this.rarity;
    }
    public List<ModifierService.ModifierAttribute> getAttribute() { return this.attribute; }
    public String getName() { return this.name; }
    public ItemType getType() {return this.type;}
    public EquipmentSlotGroup getSlot() {return this.slot; }
}
