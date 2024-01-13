package model.auxResponseSOAP;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TranslationDtoItem{

	@JsonProperty("description")
	private String description;

	@JsonProperty("language")
	private String language;

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setLanguage(String language){
		this.language = language;
	}

	public String getLanguage(){
		return language;
	}

	@Override
 	public String toString(){
		return 
			"TranslationDtoItem{" + 
			"description = '" + description + '\'' + 
			",language = '" + language + '\'' + 
			"}";
		}
}