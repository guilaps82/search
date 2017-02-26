package com.social.cooking.recipes;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RecipeService {
	Recipe findById(String recipeId);
	Recipe saveRecipe(Recipe recipe);
	void   deleteRecipe(Recipe recipe);
	void   deleteRecipe(String recipeId);
	Page<Recipe> searchRecipesByName(String name,Pageable pageable);
	Page<Recipe> searchRecipesByIngredients(String name,List<String> ingredients,Pageable pageable);
	
}
