package com.social.cooking.recipes.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.social.cooking.recipes.Recipe;
import com.social.cooking.recipes.RecipeService;

@RestController
public class RecipeRestController {

	@Autowired
	private RecipeService recipeService;

	@RequestMapping(value = "/recipes", method = RequestMethod.POST)
	public Recipe addRecipeHandler(@RequestBody Recipe recipe) {
		return recipeService.saveRecipe(recipe);
	}

	@RequestMapping(value = "/recipes", method = RequestMethod.PUT)
	public Recipe updateRecipe(@RequestBody Recipe recipe) {
		return recipeService.saveRecipe(recipe);
	}

	@RequestMapping(value = "/recipes/{recipeId}", method = RequestMethod.DELETE)
	public void deleteRecipe(@PathVariable("recipeId") String recipeId) {
		recipeService.deleteRecipe(recipeId);
	}

	@RequestMapping(value = "/recipes/{recipeId}", method = RequestMethod.GET)
	public Recipe findRecipe(@PathVariable("recipeId") String recipeId) {
		Recipe result = recipeService.findById(recipeId);
		return result;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/search/recipes/", method = RequestMethod.GET)
	public PagedResources<Recipe> searchRecipes(@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "ingredients[]",required=false) List<String> ingredients,
			Pageable pageable,
			PagedResourcesAssembler assembler) {
		
		Page<Recipe> page = null;
		
	    if(ingredients != null && !ingredients.isEmpty()){
	    	page = recipeService.searchRecipesByIngredients(name, ingredients, pageable);
	    }
	    else{
	    	page = recipeService.searchRecipesByName(name, pageable);
	    }
		return assembler.toResource(page);
	}
}
