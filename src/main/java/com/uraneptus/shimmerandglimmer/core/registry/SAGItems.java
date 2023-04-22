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
    public static final RegistryObject<Item> BIOLUMINESCENT_TERRACOTTA = ITEMS.register("bioluminescent_terracotta", () -> new FilledBlockItem(SAGBlocks.BIOLUMINESCENT_TERRACOTTA.get(), Items.BLACK_TERRACOTTA, SAGProperties.Items.BUILDING));
    public static final RegistryObject<Item> BIOLUMINESCENT_CONCRETE = ITEMS.register("bioluminescent_concrete", () -> new FilledBlockItem(SAGBlocks.BIOLUMINESCENT_CONCRETE.get(), Items.BLACK_CONCRETE, SAGProperties.Items.BUILDING));
    public static final RegistryObject<Item> BIOLUMINESCENT_CONCRETE_POWDER = ITEMS.register("bioluminescent_concrete_powder", () -> new FilledBlockItem(SAGBlocks.BIOLUMINESCENT_CONCRETE_POWDER.get(), Items.BLACK_CONCRETE_POWDER, SAGProperties.Items.BUILDING));
    public static final RegistryObject<Item> BIOLUMINESCENT_STAINED_GLASS = ITEMS.register("bioluminescent_stained_glass", () -> new FilledBlockItem(SAGBlocks.BIOLUMINESCENT_STAINED_GLASS.get(), Items.BLACK_STAINED_GLASS, SAGProperties.Items.BUILDING));

}
