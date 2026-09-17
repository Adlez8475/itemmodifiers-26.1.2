package net.adlez.itemmodifiers;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.common.ModConfigSpec;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    static final ModConfigSpec SPEC = BUILDER.build();

    public static final ModConfigSpec SERVER_SPEC;
    public static final ModConfigSpec.Builder SERVER_BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec.IntValue REROLL_COST;

    static {
        SERVER_BUILDER.push("reroll");

        REROLL_COST = SERVER_BUILDER
                .comment("Cost in levels for rerolling an item modifier.")
                .defineInRange("rerollCost", 3, 0, 100);

        SERVER_BUILDER.pop();

        SERVER_SPEC = SERVER_BUILDER.build();
    }

    private static boolean validateItemName(final Object obj) {
        return obj instanceof String itemName && BuiltInRegistries.ITEM.containsKey(Identifier.parse(itemName));
    }
}
