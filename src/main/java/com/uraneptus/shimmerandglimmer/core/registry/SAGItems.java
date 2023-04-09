package com.uraneptus.shimmerandglimmer.core.registry;

import com.uraneptus.shimmerandglimmer.ShimmerAndGlimmer;
import com.uraneptus.shimmerandglimmer.common.items.BioluminescentDyeItem;
import com.uraneptus.shimmerandglimmer.common.items.FilledBlockItem;
import com.uraneptus.shimmerandglimmer.core.other.SAGProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = ShimmerAndGlimmer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SAGItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ShimmerAndGlimmer.MOD_ID);

    public static final RegistryObject<Item> GLOWWORMS = ITEMS.register("glowworms", () -> new BlockItem(SAGBlocks.GLOWWORMS.get(), SAGProperties.Items.DECORATIONS));
    public static final RegistryObject<Item> BIOLUMINESCENT_DYE = ITEMS.register("bioluminescent_dye", () -> new BioluminescentDyeItem(SAGProperties.Items.MISC_AND_MATERIALS));
    public static final RegistryObject<Item> BIOLUMINESCENT_WOOL = ITEMS.register("bioluminescent_wool", () -> new FilledBlockItem(SAGBlocks.BIOLUMINESCENT_WOOL.get(), Items.BLACK_WOOL, SAGProperties.Items.BUILDING));


}
