package model.auxResponseSOAP;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ListTHabs{

	@JsonProperty("THabsDto")
	private THabsDto tHabsDto;

	public void setTHabsDto(THabsDto tHabsDto){
		this.tHabsDto = tHabsDto;
	}

	public THabsDto getTHabsDto(){
		return tHabsDto;
	}

	@Override
 	public String toString(){
		return 
			"ListTHabs{" + 
			"tHabsDto = '" + tHabsDto + '\'' + 
			"}";
		}
}