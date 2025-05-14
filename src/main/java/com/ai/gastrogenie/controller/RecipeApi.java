package com.ai.gastrogenie.controller;

import com.ai.gastrogenie.service.RecipeService;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.scan.UrlJar;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.model.chat.client.autoconfigure.ChatClientBuilderProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.ai.gastrogenie.constants.ApiConstant.URL;

@RestController
@RequestMapping(URL + "/recipes/sea-food")
@AllArgsConstructor
public class RecipeApi {

   private final RecipeService recipeService;
    @GetMapping("/suggest-recipe")
    public String suggestRecipes(@RequestParam(name = "message", defaultValue = "Suggest a recipe for dinner")
                                 String message) {return recipeService.suggestRecipe(message);}
}