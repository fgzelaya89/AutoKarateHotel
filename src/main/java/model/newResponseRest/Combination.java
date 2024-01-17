package model.newResponseRest;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Combination{

	@JsonProperty("rooms")
	private List<RoomsItem> rooms;

	@JsonProperty("combination_type")
	private String combinationType;

	public List<RoomsItem> getRooms(){
		return rooms;
	}

	public String getCombinationType(){
		return combinationType;
	}

	@Override
 	public String toString(){
		return 
			"Combination{" + 
			"rooms = '" + rooms + '\'' + 
			",combination_type = '" + combinationType + '\'' + 
			"}";
		}
}