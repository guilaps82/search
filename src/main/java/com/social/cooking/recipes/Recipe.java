package com.social.cooking.recipes;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

@Document(indexName="socialcooking",type="recipe")
@Setting(settingPath="/elasticsearch/autocomplete-analyser.json")
public class Recipe {

	@Id
	@Field(type=FieldType.String , index=FieldIndex.not_analyzed)
	private String id;
	
	@Field(type = FieldType.String,index=FieldIndex.analyzed,analyzer = "autocomplete",searchAnalyzer="standard",store=true)
    private String name;
	
	@Field(type=FieldType.Nested,store=true)
	private List<Ingredients> ingredients;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Ingredients> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredients> ingredients) {
		this.ingredients = ingredients;
	}
	
	
	public static class Ingredients{
		
		@Field(type = FieldType.String,index = FieldIndex.analyzed, analyzer="autocomplete",searchAnalyzer="standard",store=true)
		private String name;
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
	
}
