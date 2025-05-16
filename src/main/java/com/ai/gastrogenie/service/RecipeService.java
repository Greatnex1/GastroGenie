package com.ai.gastrogenie.service;

import com.ai.gastrogenie.model.Recipe;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.ai.converter.ListOutputConverter;
import org.springframework.ai.converter.MapOutputConverter;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Service
public class RecipeService implements RecipeUseCase {

    private final ChatClient chatClient;

    public RecipeService(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    public String suggestRecipe(String message) {

        final String systemPrompt = "Suggest sea food recipes, if user asks for anything else, " +
                "respond with 'I am not sure about that, but I can suggest some sea food recipes.'";
        return this.chatClient.prompt()
                .system(c -> c.text(systemPrompt))
                .user(message)
                .call()
                .content();
    }

    public List<String> suggestRecipeFromIngredients(@RequestParam(name = "ingredient", defaultValue = "shrimp")
                                                     String ingredient) {

        String messages = """
                Please suggest me the best 10 dishes containing the ingredient {ingredient}
                Just say, i don't know, if no answer is found{format}
                """;

        final ListOutputConverter listOutputConverter = new ListOutputConverter(new DefaultConversionService());

        final PromptTemplate promptTemplate = new PromptTemplate(messages, Map.of
                (
                        "ingredient", ingredient,
                        "format", listOutputConverter.getFormat()
                )
        );
        String response = this.chatClient.prompt(promptTemplate.create())
                .call()
                .content();
        return listOutputConverter.convert(response);
    }

    public Map<String, Object> suggestRecipeFromIngredientsByCountry(@RequestParam(name = "ingredient", defaultValue = "shrimp")
                                                                     String ingredient) {

        String messages = """
                Please suggest me the best 10 dishes containing the ingredient {ingredient}
                include the country of origin as a key and the dish name as a value
                Just say, i don't know, if no answer is found{format}
                """;

        final MapOutputConverter mapOutputConverter = new MapOutputConverter();

        final PromptTemplate promptTemplate = new PromptTemplate(messages, Map.of
                (
                        "ingredient", ingredient,
                        "format", mapOutputConverter.getFormat()
                )
        );
        String response = this.chatClient.prompt(promptTemplate.create())
                .call()
                .content();
        return mapOutputConverter.convert(response);
    }

    public Recipe suggestBestRecipeFromIngredientsAndIncludeTheNumberOfCalories(@RequestParam(name = "ingredient", defaultValue = "shrimp")
                                                                                                   String ingredient) {

        String messages = """
                Please suggest me the best 10 dishes containing the ingredient {ingredient}
                include the country of origin, the dish name and number of calories the dishe contains as a value
                Just say, i don't know, if no answer is found{format}
                """;

        final BeanOutputConverter<Recipe> beanOutputConverter = new BeanOutputConverter(Recipe.class );

        final PromptTemplate promptTemplate = new PromptTemplate(messages, Map.of
                (
                        "ingredient", ingredient,
                        "format", beanOutputConverter.getFormat()
                )
        );
        String response = this.chatClient.prompt(promptTemplate.create())
                .call()
                .content();
        return beanOutputConverter.convert(response);
    }
    public List<Recipe> suggestBestRecipeFromIngredientsAsList(@RequestParam(name = "ingredient", defaultValue = "shrimp")
                                                                                  String ingredient) {

        String messages = """
                Please suggest me the best 10 dishes containing the ingredient {ingredient}
                include the country of origin, the dish name and number of calories the dishe contains as a value
                Just say, i don't know, if no answer is found{format}
                """;
        ParameterizedTypeReference<List<Recipe>> typeReference = new ParameterizedTypeReference<>() {};
        final BeanOutputConverter <List<Recipe>> beanOutputConverter = new BeanOutputConverter(typeReference);

        final PromptTemplate promptTemplate = new PromptTemplate(messages, Map.of
                (
                        "ingredient", ingredient,
                        "format", beanOutputConverter.getFormat()
                )
        );
        String response = this.chatClient.prompt(promptTemplate.create())
                .call()
                .content();
        return beanOutputConverter.convert(response);
    }


}