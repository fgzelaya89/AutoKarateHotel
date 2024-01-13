package model.responseRest;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Combination{

	@JsonProperty("rooms")
	private List<RoomsItem> rooms;

	@JsonProperty("combination_type")
	private String combinationType;

	public void setRooms(List<RoomsItem> rooms){
		this.rooms = rooms;
	}

	public List<RoomsItem> getRooms(){
		return rooms;
	}

	public void setCombinationType(String combinationType){
		this.combinationType = combinationType;
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