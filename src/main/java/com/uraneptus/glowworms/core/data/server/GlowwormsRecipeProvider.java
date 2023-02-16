package com.uraneptus.glowworms.core.data.server;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.function.Consumer;

@SuppressWarnings("SameParameterValue")
public class GlowwormsRecipeProvider extends RecipeProvider {

    public GlowwormsRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {


    }

}
