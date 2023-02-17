package com.uraneptus.glowworms.core.registry;

import com.uraneptus.glowworms.GlowwormsMod;
import com.uraneptus.glowworms.common.blocks.Glowworms;
import com.uraneptus.glowworms.core.other.GlowwormsProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = GlowwormsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GlowwormsItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GlowwormsMod.MOD_ID);

    public static final RegistryObject<Item> GLOWWORMS = ITEMS.register("glowworms", () -> new BlockItem(GlowwormsBlocks.GLOWWORMS.get(), GlowwormsProperties.Items.DECORATIONS));


}
