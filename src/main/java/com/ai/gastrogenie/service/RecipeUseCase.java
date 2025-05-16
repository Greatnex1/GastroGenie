package com.ai.gastrogenie.service;

import com.ai.gastrogenie.model.Recipe;

import java.util.List;
import java.util.Map;

public interface RecipeUseCase {

    String suggestRecipe(String message);

    Map<String, Object> suggestRecipeFromIngredientsByCountry(String message) ;

    Recipe suggestBestRecipeFromIngredientsAndIncludeTheNumberOfCalories(String message) ;

     List<Recipe> suggestBestRecipeFromIngredientsAsList(String message) ;

    }
