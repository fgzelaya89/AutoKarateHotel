package model.responseRest;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseRest{

	@JsonProperty("availabilities")
	private List<AvailabilitiesItem> availabilities;

	@JsonProperty("messages")
	private Object messages;

	public void setAvailabilities(List<AvailabilitiesItem> availabilities){
		this.availabilities = availabilities;
	}

	public List<AvailabilitiesItem> getAvailabilities(){
		return availabilities;
	}

	public void setMessages(Object messages){
		this.messages = messages;
	}

	public Object getMessages(){
		return messages;
	}

	@Override
 	public String toString(){
		return 
			"ResponseRest{" + 
			"availabilities = '" + availabilities + '\'' + 
			",messages = '" + messages + '\'' + 
			"}";
		}
}