package com.uraneptus.glowworms.core.registry;

import com.uraneptus.glowworms.Glowworms;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Glowworms.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SMItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Glowworms.MOD_ID);


}
