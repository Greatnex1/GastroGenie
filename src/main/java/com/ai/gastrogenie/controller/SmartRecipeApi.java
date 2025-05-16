package com.ai.gastrogenie.controller;

import com.ai.gastrogenie.model.Recipe;
import com.ai.gastrogenie.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static com.ai.gastrogenie.constants.ApiConstant.URL;

@RequestMapping(URL + "/recipes/suggester")
@RestController
@RequiredArgsConstructor
public class SmartRecipeApi {

   RecipeService recipeService;

    @GetMapping("/suggest-recipe")
    public List<String> suggestRecipeFromIngredients(@RequestParam(name = "ingredient", defaultValue = "shrimp")
                                                         String ingredient) {
                      return recipeService.suggestRecipeFromIngredients(ingredient);
    }

    @GetMapping("/country")
    public Map<String, Object> suggestRecipeFromIngredientsByCountry(@RequestParam(name = "ingredient", defaultValue = "shrimp")
                                                            String ingredient) {

       return recipeService.suggestRecipeFromIngredientsByCountry(ingredient);
    }

    @GetMapping("/best-recipe")
    public Recipe suggestBestRecipeFromIngredientsAndIncludeTheNumberOfCalories(@RequestParam(name = "ingredient", defaultValue = "shrimp")
                                                                      String ingredient) {
        return recipeService.suggestBestRecipeFromIngredientsAndIncludeTheNumberOfCalories(ingredient);
    }

    //presenting the model as json response in a list
    @GetMapping("/best-list-recipe")
    public List<Recipe> suggestBestRecipeFromIngredientsAsList(@RequestParam(name = "ingredient", defaultValue = "shrimp")
                                                         String ingredient) {
return recipeService.suggestBestRecipeFromIngredientsAsList(ingredient);
    }


}
