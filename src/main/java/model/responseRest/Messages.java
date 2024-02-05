package model.responseRest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Messages{

	@JsonProperty("info")
	private List<InfoItem> info;

	public List<InfoItem> getInfo(){
		return info;
	}
}