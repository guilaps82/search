package com.social.cooking.recipes.web;

import java.util.List;
import java.util.UUID;

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
	public void deleteRecipe(@PathVariable("recipeId") UUID recipeId) {
		recipeService.deleteRecipe(recipeId);
	}

	@RequestMapping(value = "/recipes/{recipeId}", method = RequestMethod.GET)
	public Recipe findRecipe(@PathVariable("recipeId") UUID recipeId) {
		Recipe result = recipeService.findById(recipeId);
		return result;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/search/recipes/", method = RequestMethod.GET)
	public PagedResources<Recipe> searchRecipes(@RequestParam(name = "title", defaultValue = "") String name,
			@RequestParam(name = "ingredients[]",required=false) List<String> ingredients,
			@RequestParam(name = "tags[]",required=false) List<String> tags,
			Pageable pageable,
			PagedResourcesAssembler assembler) {
		
		Page<Recipe> page = null;
		
	    if(ingredients != null && !ingredients.isEmpty()){
	    	page = recipeService.searchRecipesByIngredients(ingredients, pageable);
	    }
	    else if(tags != null && !tags.isEmpty()){
	    	page = recipeService.searchRecipesByTag(tags,pageable);
	    }
	    else{
	    	page = recipeService.searchRecipesByTitle(name, pageable);
	    }
		return assembler.toResource(page);
	}
	
	
}
