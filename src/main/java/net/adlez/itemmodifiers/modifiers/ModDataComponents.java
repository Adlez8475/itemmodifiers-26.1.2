package net.adlez.itemmodifiers.modifiers;

import net.adlez.itemmodifiers.ItemModifiers;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModDataComponents {
    public static final DeferredRegister<Attribute> ATTRIBUTES =
            DeferredRegister.create(Registries.ATTRIBUTE,ItemModifiers.MODID);

    public static final DeferredHolder<Attribute, Attribute> DOUBLE_DROP_CHANCE = ATTRIBUTES.register(
            "double_drop_chance", () -> new RangedAttribute("attribute.itemmodifiers.double_drop_chance", 0.0, 0.0,
                    1.0).setSyncable(true).setSentiment(Attribute.Sentiment.POSITIVE));

    public static final DeferredRegister.DataComponents COMPONENTS =
            DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, ItemModifiers.MODID);

    public static final Supplier<DataComponentType<Modifier>> MODIFIER = COMPONENTS.registerComponentType("modifier",
            builder -> builder.persistent(Modifier.MODIFIER_CODEC));
}
