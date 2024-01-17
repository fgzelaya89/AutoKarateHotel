package model.newResponseRest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AvailabilitiesItem{

	@JsonProperty("sales_scope")
	private String salesScope;

	@JsonProperty("code")
	private String code;

	@JsonProperty("hotel_booking_policy")
	private HotelBookingPolicy hotelBookingPolicy;

	@JsonProperty("rates_type")
	private String ratesType;

	@JsonProperty("messages")
	private Object messages;

	@JsonProperty("hotel")
	private int hotel;

	@JsonProperty("availability")
	private int availability;

	@JsonProperty("prices")
	private Prices prices;

	@JsonProperty("board")
	private String board;

	@JsonProperty("combination")
	private Combination combination;

	@JsonProperty("added_value_services")
	private Object addedValueServices;

	public String getSalesScope(){
		return salesScope;
	}

	public String getCode(){
		return code;
	}

	public HotelBookingPolicy getHotelBookingPolicy(){
		return hotelBookingPolicy;
	}

	public String getRatesType(){
		return ratesType;
	}

	public Object getMessages(){
		return messages;
	}

	public int getHotel(){
		return hotel;
	}

	public int getAvailability(){
		return availability;
	}

	public Prices getPrices(){
		return prices;
	}

	public String getBoard(){
		return board;
	}

	public Combination getCombination(){
		return combination;
	}

	public Object getAddedValueServices(){
		return addedValueServices;
	}

	@Override
 	public String toString(){
		return 
			"AvailabilitiesItem{" + 
			"sales_scope = '" + salesScope + '\'' + 
			",code = '" + code + '\'' + 
			",hotel_booking_policy = '" + hotelBookingPolicy + '\'' + 
			",rates_type = '" + ratesType + '\'' + 
			",messages = '" + messages + '\'' + 
			",hotel = '" + hotel + '\'' + 
			",availability = '" + availability + '\'' + 
			",prices = '" + prices + '\'' + 
			",board = '" + board + '\'' + 
			",combination = '" + combination + '\'' + 
			",added_value_services = '" + addedValueServices + '\'' + 
			"}";
		}
}