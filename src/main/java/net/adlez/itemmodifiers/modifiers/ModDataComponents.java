package net.adlez.itemmodifiers.modifiers;

import net.adlez.itemmodifiers.ItemModifiers;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModDataComponents {
    public static final DeferredRegister.DataComponents COMPONENTS =
            DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, ItemModifiers.MODID);

    public static final Supplier<DataComponentType<Modifier>> MODIFIER = COMPONENTS.registerComponentType("modifier",
            builder -> builder.persistent(Modifier.MODIFIER_CODEC));

}
