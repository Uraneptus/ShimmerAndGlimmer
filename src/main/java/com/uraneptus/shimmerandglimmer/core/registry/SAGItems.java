package com.uraneptus.shimmerandglimmer.core.registry;

import com.uraneptus.shimmerandglimmer.ShimmerAndGlimmer;
import com.uraneptus.shimmerandglimmer.core.other.SAGProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = ShimmerAndGlimmer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SAGItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ShimmerAndGlimmer.MOD_ID);

    public static final RegistryObject<Item> GLOWWORMS = ITEMS.register("glowworms", () -> new BlockItem(SAGBlocks.GLOWWORMS.get(), SAGProperties.Items.DECORATIONS));


}
