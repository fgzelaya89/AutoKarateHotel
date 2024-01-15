package model.request.newRquestRest;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Destination{

	@JsonProperty("country")
	private String country;

	@JsonProperty("hotels")
	private List<Integer> hotels;

	@JsonProperty("destination")
	private String destination;

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setHotels(List<Integer> hotels){
		this.hotels = hotels;
	}

	public List<Integer> getHotels(){
		return hotels;
	}

	public void setDestination(String destination){
		this.destination = destination;
	}

	public String getDestination(){
		return destination;
	}

	@Override
 	public String toString(){
		return 
			"Destination{" + 
			"country = '" + country + '\'' + 
			",hotels = '" + hotels + '\'' + 
			",destination = '" + destination + '\'' + 
			"}";
		}
}