package net.adlez.itemmodifiers.modifiers;

import com.mojang.serialization.Codec;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;


import java.util.List;

public enum Modifier {
    UNCHANGED("Unchanged",Rarity.UNCHANGED, EquipmentSlotGroup.ANY, ItemType.ANY),

    // Weapons
    HEFTY(
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
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    SMALL(
            "Small",
            Rarity.COMMON,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, -0.1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    DULL(
            "Dull",
            Rarity.COMMON,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, -0.15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    BLUNT(
            "Blunt",
            Rarity.COMMON,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, -0.2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    HEAVY(
            "Heavy",
            Rarity.COMMON,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, -0.15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    SLUGGISH(
            "Sluggish",
            Rarity.COMMON,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, -0.25, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    DENTED(
            "Dented",
            Rarity.COMMON,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, -0.25, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    LIGHTWEIGHT(
            "Lightweight",
            Rarity.COMMON,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, -0.05, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    RUSTY(
            "Rusty",
            Rarity.COMMON,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, -0.1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    BULKY(
            "Bulky",
            Rarity.COMMON,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.MOVEMENT_SPEED, -0.1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    NIMBLE(
            "Nimble",
            Rarity.UNCOMMON,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    JAGGED(
            "Jagged",
            Rarity.UNCOMMON,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    CUMBERSOME(
            "Cumbersome",
            Rarity.UNCOMMON,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, -0.15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, -0.15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    QUICK(
            "Quick",
            Rarity.UNCOMMON,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.MOVEMENT_SPEED, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    SERRATED(
            "Serrated",
            Rarity.UNCOMMON,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    RAPID(
            "Rapid",
            Rarity.UNCOMMON,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    HURTFUL(
            "Hurtful",
            Rarity.UNCOMMON,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    SWIFT(
            "Swift",
            Rarity.RARE,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, 0.2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    SHARP(
            "Sharp",
            Rarity.RARE,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    BALANCED(
            "Balanced",
            Rarity.RARE,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    PRECISE(
            "Precise",
            Rarity.RARE,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.075, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    ENDURING(
            "Enduring",
            Rarity.RARE,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.MOVEMENT_SPEED, 0.05, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    MOMENTUM(
            "Momentum",
            Rarity.RARE,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, 0.3, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.MOVEMENT_SPEED, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    DEADLY(
            "Deadly",
            Rarity.RARE,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    MURDEROUS(
            "Murderous",
            Rarity.RARE,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.125, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, 0.125, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    VICIOUS(
            "Vicious",
            Rarity.EPIC,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    AGILE(
            "Agile",
            Rarity.EPIC,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, 0.2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, -0.05, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    FRENZIED(
            "Frenzied",
            Rarity.EPIC,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, 0.25, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, -0.1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    LUMBERING(
            "Lumbering",
            Rarity.EPIC,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, -0.2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    GODLY(
            "Godly",
            Rarity.EPIC,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    DEMONIC(
            "Demonic",
            Rarity.EPIC,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    CELESTIAL(
            "Celestial",
            Rarity.EPIC,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE,0.2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.MOVEMENT_SPEED, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    ETHEREAL(
            "Ethereal",
            Rarity.EPIC,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED,0.4, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    LEGENDARY(
            "Legendary",
            Rarity.LEGENDARY,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    RAZOR(
            "Razor",
            Rarity.LEGENDARY,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.3, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    INDESTRUCTIBLE(
            "Indestructible",
            Rarity.LEGENDARY,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.MOVEMENT_SPEED, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    TITANS_SLAYER(
            "Titan's Slayer",
            Rarity.LEGENDARY,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.35, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, 0.3, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    CHRONOS(
            "Chronos",
            Rarity.LEGENDARY,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, 0.6, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.MOVEMENT_SPEED, 0.2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)

    ),
    UNREAL(
            "Unreal",
            Rarity.MYTHIC,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.4, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, 0.25F, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    ETERNAL(
            "Eternal",
            Rarity.MYTHIC,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.MOVEMENT_SPEED,0.25, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    DIVINE(
            "Divine",
            Rarity.MYTHIC,
            EquipmentSlotGroup.MAINHAND,
            ItemType.WEAPONS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.5, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, 0.5, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),

    // Tool
    HEFTY_TOOL(
            "Hefty",
            Rarity.COMMON,
            EquipmentSlotGroup.MAINHAND,
            ItemType.TOOLS,
            new ModifierService.ModifierAttribute(Attributes.MOVEMENT_SPEED, -0.05, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    QUICK_TOOL(
            "Quick",
            Rarity.COMMON,
            EquipmentSlotGroup.MAINHAND,
            ItemType.TOOLS,
            new ModifierService.ModifierAttribute(Attributes.MOVEMENT_SPEED, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
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
            new ModifierService.ModifierAttribute(Attributes.BLOCK_BREAK_SPEED,0.15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    REINFORCED(
            "Reinforced",
            Rarity.UNCOMMON,
            EquipmentSlotGroup.MAINHAND,
            ItemType.TOOLS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.BLOCK_BREAK_SPEED , 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    FORTUITOUS(
          "Fortuitous",
          Rarity.RARE,
          EquipmentSlotGroup.MAINHAND,
          ItemType.TOOLS,
          new ModifierService.ModifierAttribute(ModDataComponents.DOUBLE_DROP_CHANCE, 0.1, AttributeModifier.Operation.ADD_VALUE),
          new ModifierService.ModifierAttribute(Attributes.BLOCK_BREAK_SPEED, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    ENDURING_TOOL(
          "Enduring",
          Rarity.RARE,
          EquipmentSlotGroup.MAINHAND,
          ItemType.TOOLS,
          new ModifierService.ModifierAttribute(Attributes.MOVEMENT_SPEED, 0.05, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    PROSPECTOR(
          "Prospector",
          Rarity.RARE,
          EquipmentSlotGroup.MAINHAND,
          ItemType.TOOLS,
          new ModifierService.ModifierAttribute(ModDataComponents.DOUBLE_DROP_CHANCE, 0.15, AttributeModifier.Operation.ADD_VALUE),
          new ModifierService.ModifierAttribute(Attributes.BLOCK_BREAK_SPEED,0.1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)

    ),
    LETHAL(
            "Lethal",
            Rarity.EPIC,
            EquipmentSlotGroup.MAINHAND,
            ItemType.TOOLS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.25, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(ModDataComponents.DOUBLE_DROP_CHANCE, 0.05, AttributeModifier.Operation.ADD_VALUE)
    ),
    LUCKY(
            "Lucky",
            Rarity.EPIC,
            EquipmentSlotGroup.MAINHAND,
            ItemType.TOOLS,
            new ModifierService.ModifierAttribute(ModDataComponents.DOUBLE_DROP_CHANCE, 0.15, AttributeModifier.Operation.ADD_VALUE),
            new ModifierService.ModifierAttribute(Attributes.LUCK,2.0, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    FLEET(
            "Fleet",
            Rarity.EPIC,
            EquipmentSlotGroup.MAINHAND,
            ItemType.TOOLS,
            new ModifierService.ModifierAttribute(Attributes.BLOCK_BREAK_SPEED,0.1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.MOVEMENT_SPEED,0.2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    ARCANE(
            "Arcane",
            Rarity.EPIC,
            EquipmentSlotGroup.MAINHAND,
            ItemType.TOOLS,
            new ModifierService.ModifierAttribute(Attributes.BLOCK_BREAK_SPEED,0.3, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(ModDataComponents.DOUBLE_DROP_CHANCE, 0.2, AttributeModifier.Operation.ADD_VALUE)
    ),
    CELESTIAL_TOOL(
            "Celestial",
            Rarity.EPIC,
            EquipmentSlotGroup.MAINHAND,
            ItemType.TOOLS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE,0.2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.MOVEMENT_SPEED, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
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
    TITANIC(
            "Titanic",
            Rarity.MYTHIC,
            EquipmentSlotGroup.MAINHAND,
            ItemType.TOOLS,
            new ModifierService.ModifierAttribute(Attributes.MOVEMENT_SPEED,1.0, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(ModDataComponents.DOUBLE_DROP_CHANCE, 0.25, AttributeModifier.Operation.ADD_VALUE)
    ),
    ETERNAL_TOOL(
            "Eternal",
            Rarity.MYTHIC,
            EquipmentSlotGroup.MAINHAND,
            ItemType.TOOLS,
            new ModifierService.ModifierAttribute(Attributes.MOVEMENT_SPEED,0.25, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    COSMIC(
            "Cosmic",
            Rarity.MYTHIC,
            EquipmentSlotGroup.MAINHAND,
            ItemType.TOOLS,
            new ModifierService.ModifierAttribute(Attributes.BLOCK_BREAK_SPEED,1.5, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(ModDataComponents.DOUBLE_DROP_CHANCE, 0.4, AttributeModifier.Operation.ADD_VALUE),
            new ModifierService.ModifierAttribute(Attributes.MOVEMENT_SPEED, 0.3, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    OMNIPOTENT(
            "Omnipotent",
            Rarity.MYTHIC,
            EquipmentSlotGroup.MAINHAND,
            ItemType.TOOLS,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED,0.4, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.BLOCK_BREAK_SPEED,1.0, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.MOVEMENT_SPEED, 0.25, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
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
            new ModifierService.ModifierAttribute(Attributes.ARMOR, 1.0, AttributeModifier.Operation.ADD_VALUE)
    ),
    LIGHT(
            "Light",
            Rarity.COMMON,
            EquipmentSlotGroup.ARMOR,
            ItemType.ARMOR,
            new ModifierService.ModifierAttribute(Attributes.MOVEMENT_SPEED, 0.05, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.ARMOR, -0.5, AttributeModifier.Operation.ADD_VALUE)
    ),
    TOUGH(
            "Tough",
            Rarity.COMMON,
            EquipmentSlotGroup.ARMOR,
            ItemType.ARMOR,
            new ModifierService.ModifierAttribute(Attributes.ARMOR_TOUGHNESS, 1.0, AttributeModifier.Operation.ADD_VALUE)
    ),
    AGILE_ARMOR(
            "Agile",
            Rarity.UNCOMMON,
            EquipmentSlotGroup.ARMOR,
            ItemType.ARMOR,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, 0.05, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    HEALTHY(
            "Healthy",
            Rarity.UNCOMMON,
            EquipmentSlotGroup.ARMOR,
            ItemType.ARMOR,
            new ModifierService.ModifierAttribute(Attributes.MAX_HEALTH, 1.0, AttributeModifier.Operation.ADD_VALUE)
    ),
    LUCKY_ARMOR(
            "Lucky",
            Rarity.RARE,
            EquipmentSlotGroup.ARMOR,
            ItemType.ARMOR,
            new ModifierService.ModifierAttribute(Attributes.LUCK, 1.0, AttributeModifier.Operation.ADD_VALUE),
            new ModifierService.ModifierAttribute(Attributes.ARMOR, 1.0, AttributeModifier.Operation.ADD_VALUE)
    ),
    PROTECTIVE(
            "Protective",
            Rarity.RARE,
            EquipmentSlotGroup.ARMOR,
            ItemType.ARMOR,
            new ModifierService.ModifierAttribute(Attributes.ARMOR_TOUGHNESS, 1.0, AttributeModifier.Operation.ADD_VALUE),
            new ModifierService.ModifierAttribute(Attributes.ARMOR, 2.0, AttributeModifier.Operation.ADD_VALUE)
    ),
    VIGOROUS(
            "Vigorous",
            Rarity.RARE,
            EquipmentSlotGroup.ARMOR,
            ItemType.ARMOR,
            new ModifierService.ModifierAttribute(Attributes.MAX_HEALTH, 2.0, AttributeModifier.Operation.ADD_VALUE),
            new ModifierService.ModifierAttribute(Attributes.MOVEMENT_SPEED, 0.05, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    WARLORD(
            "Warlord",
            Rarity.EPIC,
            EquipmentSlotGroup.ARMOR,
            ItemType.ARMOR,
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.ARMOR, 2.0, AttributeModifier.Operation.ADD_VALUE)
    ),
    TITANS_GRIP(
            "Titan's grip",
            Rarity.EPIC,
            EquipmentSlotGroup.ARMOR,
            ItemType.ARMOR,
            new ModifierService.ModifierAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.1, AttributeModifier.Operation.ADD_VALUE),
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.05, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.ARMOR, 2.0, AttributeModifier.Operation.ADD_VALUE)
    ),
    SWIFT_FOOTED(
            "Swift-footed",
            Rarity.EPIC,
            EquipmentSlotGroup.ARMOR,
            ItemType.ARMOR,
            new ModifierService.ModifierAttribute(Attributes.MOVEMENT_SPEED, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.FALL_DAMAGE_MULTIPLIER, -0.2, AttributeModifier.Operation.ADD_VALUE),
            new ModifierService.ModifierAttribute(Attributes.ARMOR, 2.0, AttributeModifier.Operation.ADD_VALUE)


    ),
    DIVINE_PROTECTION(
            "Divine protection",
            Rarity.LEGENDARY,
            EquipmentSlotGroup.ARMOR,
            ItemType.ARMOR,
            new ModifierService.ModifierAttribute(Attributes.ARMOR, 3.0, AttributeModifier.Operation.ADD_VALUE),
            new ModifierService.ModifierAttribute(Attributes.ARMOR_TOUGHNESS, 2.0, AttributeModifier.Operation.ADD_VALUE),
            new ModifierService.ModifierAttribute(Attributes.MAX_HEALTH, 4.0, AttributeModifier.Operation.ADD_VALUE)
    ),
    BLESSED_AGILITY(
            "Blessed Agility",
            Rarity.LEGENDARY,
            EquipmentSlotGroup.ARMOR,
            ItemType.ARMOR,
            new ModifierService.ModifierAttribute(Attributes.MOVEMENT_SPEED, 0.2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    ),
    GODLY_ARMOR(
            "Godly",
            Rarity.MYTHIC,
            EquipmentSlotGroup.ARMOR,
            ItemType.ARMOR,
            new ModifierService.ModifierAttribute(Attributes.ARMOR, 4.0, AttributeModifier.Operation.ADD_VALUE),
            new ModifierService.ModifierAttribute(Attributes.ARMOR_TOUGHNESS, 3.0, AttributeModifier.Operation.ADD_VALUE),
            new ModifierService.ModifierAttribute(Attributes.MAX_HEALTH, 6.0, AttributeModifier.Operation.ADD_VALUE),
            new ModifierService.ModifierAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.2, AttributeModifier.Operation.ADD_VALUE)

    ),
    CELESTIAL_BLESSING(
            "Celestial blessing",
            Rarity.MYTHIC,
            EquipmentSlotGroup.ARMOR,
            ItemType.ARMOR,
            new ModifierService.ModifierAttribute(Attributes.MOVEMENT_SPEED, 0.25, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.ATTACK_SPEED, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.ATTACK_DAMAGE, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new ModifierService.ModifierAttribute(Attributes.LUCK, 3.0, AttributeModifier.Operation.ADD_VALUE),
            new ModifierService.ModifierAttribute(Attributes.FALL_DAMAGE_MULTIPLIER, -0.5, AttributeModifier.Operation.ADD_VALUE)
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
