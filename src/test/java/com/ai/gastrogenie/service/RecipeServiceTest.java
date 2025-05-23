package com.ai.gastrogenie.service;

import com.ai.gastrogenie.model.Recipe;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RecipeServiceTest {
@InjectMocks
    private RecipeService recipeService;


    @Test
    void testThatRecipeCanBeSuggested() {
        String messageSuggester = "Suggest sea food recipes, if user asks for anything else, " +
                "respond with 'I am not sure about that, but I can suggest some sea food recipes.'";
        assertDoesNotThrow(() -> {recipeService.suggestRecipe(messageSuggester);});
    }


}