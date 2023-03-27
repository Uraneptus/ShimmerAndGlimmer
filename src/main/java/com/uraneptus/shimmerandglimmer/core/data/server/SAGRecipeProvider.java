package com.uraneptus.shimmerandglimmer.core.data.server;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.function.Consumer;

@SuppressWarnings("SameParameterValue")
public class SAGRecipeProvider extends RecipeProvider {

    public SAGRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {


    }

}
