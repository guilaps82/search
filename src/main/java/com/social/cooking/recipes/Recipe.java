package com.social.cooking.recipes;

import java.util.List;
import java.util.UUID;

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
	private UUID id;
	
	@Field(type = FieldType.String,index=FieldIndex.analyzed,analyzer = "autocomplete",searchAnalyzer="standard")
	private String title;
	
	private String shortDescription;
	
	private String description;
	
	private int difficulty;
	
	private int userDifficulty;
	
	private String coverImage;
	
	private String thumbnail;
	
	private String coverVideo;
	
	@Field(type=FieldType.Object)
	private List<Ingredient> ingredients;
	
	@Field(type=FieldType.Object,index = FieldIndex.analyzed, analyzer="autocomplete",searchAnalyzer="standard")
	private List<String> tags;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public int getUserDifficulty() {
		return userDifficulty;
	}

	public void setUserDifficulty(int userDifficulty) {
		this.userDifficulty = userDifficulty;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getCoverVideo() {
		return coverVideo;
	}

	public void setCoverVideo(String coverVideo) {
		this.coverVideo = coverVideo;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}
}
