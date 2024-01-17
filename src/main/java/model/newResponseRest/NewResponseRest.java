package model.newResponseRest;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NewResponseRest{

	@JsonProperty("availabilities")
	private List<AvailabilitiesItem> availabilities;

	@JsonProperty("messages")
	private Object messages;

	public List<AvailabilitiesItem> getAvailabilities(){
		return availabilities;
	}

	public Object getMessages(){
		return messages;
	}

	@Override
 	public String toString(){
		return 
			"NewResponseRest{" + 
			"availabilities = '" + availabilities + '\'' + 
			",messages = '" + messages + '\'' + 
			"}";
		}
}