package model.newResponseRest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HotelBookingPolicy{

	@JsonProperty("minimum_stay_days")
	private int minimumStayDays;

	@JsonProperty("release_days")
	private int releaseDays;

	public int getMinimumStayDays(){
		return minimumStayDays;
	}

	public int getReleaseDays(){
		return releaseDays;
	}

	@Override
 	public String toString(){
		return 
			"HotelBookingPolicy{" + 
			"minimum_stay_days = '" + minimumStayDays + '\'' + 
			",release_days = '" + releaseDays + '\'' + 
			"}";
		}
}