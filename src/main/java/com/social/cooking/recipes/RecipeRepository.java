package com.social.cooking.recipes;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface RecipeRepository  extends ElasticsearchRepository<Recipe, String>{
	
    @Query("{\"match\": {\"name\": \"?0\"}}")
	Page<Recipe> findByName(String name, Pageable pageable);

    @Query("{\"nested\":{\"path\":\"ingredients\",\"query\":{\"bool\":{\"must\":[{\"match\":{\"ingredients.name\":\"?1\"}}]}}}}")
    Page<Recipe> findByIngredients(String name, List<String> ingredient, Pageable pageable);
}
