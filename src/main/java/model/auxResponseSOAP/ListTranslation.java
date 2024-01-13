package model.auxResponseSOAP;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ListTranslation{

	@JsonProperty("TranslationDto")
	private List<TranslationDtoItem> translationDto;

	public void setTranslationDto(List<TranslationDtoItem> translationDto){
		this.translationDto = translationDto;
	}

	public List<TranslationDtoItem> getTranslationDto(){
		return translationDto;
	}

	@Override
 	public String toString(){
		return 
			"ListTranslation{" + 
			"translationDto = '" + translationDto + '\'' + 
			"}";
		}
}