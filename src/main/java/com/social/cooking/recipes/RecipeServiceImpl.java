package com.social.cooking.recipes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("recipeService")
public class RecipeServiceImpl implements RecipeService{

	@Autowired
	private RecipeRepository recipeRepository;
	
	@Transactional
	@Override
	public Recipe saveRecipe(Recipe recipe) {
		return recipeRepository.save(recipe);
	}

	@Transactional
	@Override
	public void deleteRecipe(Recipe recipe) {
		recipeRepository.delete(recipe);
	}
	
	@Transactional
	@Override
	public void deleteRecipe(String recipeId) {
		recipeRepository.delete(recipeId);		
	}

	@Override
	public Page<Recipe> searchRecipesByName(String name, Pageable pageable) {
		return recipeRepository.findByName(name, pageable);
	}

	@Override
	public Recipe findById(String recipeId) {
		return recipeRepository.findOne(recipeId);
	}

	@Override
	public Page<Recipe> searchRecipesByIngredients(List<String> ingredients, Pageable pageable) {
		return recipeRepository.findByIngredients(ingredients, pageable);
	}

	@Override
	public Page<Recipe> searchRecipesByTag(List<String> tags, Pageable pageable) {
		return recipeRepository.findByTags(tags, pageable);
	}
}
