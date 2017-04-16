package com.social.cooking.recipes;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RecipeService {
	Recipe findById(UUID recipeId);
	Recipe saveRecipe(Recipe recipe);
	void   deleteRecipe(Recipe recipe);
	void   deleteRecipe(UUID recipeId);
	Page<Recipe> searchRecipesByTitle(String title,Pageable pageable);
	Page<Recipe> searchRecipesByIngredients(List<String> ingredients,Pageable pageable);
	Page<Recipe> searchRecipesByTag(List<String> tags,Pageable pageable);
}
