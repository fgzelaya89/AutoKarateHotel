package model.request.RequestRest;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Destination{

	@JsonProperty("country")
	private String country;

	@JsonProperty("hotels")
	private List<Integer> hotels = new ArrayList<Integer>();

	@JsonProperty("destination")
	private String destination;



	public String getCountry(){
		return country;
	}

	public List<Integer> getHotels(){
		return hotels;
	}

	public String getDestination(){
		return destination;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void addHotels(int hotels) {
		this.hotels.add(hotels);
	}
	public void setHotels(List<Integer> hotels) {
		this.hotels = hotels;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}


	@Override
	public String toString() {
		return "Destination{" +
				"country='" + country + '\'' +
				", hotels=" + hotels +
				", destination='" + destination + '\'' +
				'}';
	}
}