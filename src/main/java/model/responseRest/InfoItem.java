package model.responseRest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class InfoItem{

	@JsonProperty("code")
	private String code;

	@JsonProperty("values")
	private List<String> values;

	@JsonProperty("description")
	private String description;

	public String getCode(){
		return code;
	}

	public List<String> getValues(){
		return values;
	}

	public String getDescription(){
		return description;
	}
}