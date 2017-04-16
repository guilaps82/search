package com.social.cooking.recipes;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface RecipeRepository  extends ElasticsearchRepository<Recipe, UUID>{
	
    @Query("{\"match\": {\"title\": \"?0\"}}")
	Page<Recipe> findByTitle(String title, Pageable pageable);

    @Query("{\"match\":{\"ingredients.name\":\"?0\"}}")
    Page<Recipe> findByIngredients(List<String> ingredient, Pageable pageable);
    
    @Query("{\"match\": {\"tags\": \"?0\"}}")
    Page<Recipe> findByTags(List<String> tags,Pageable pageable);
}
