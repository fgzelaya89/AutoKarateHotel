package model.responseRest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AvailabilitiesItem{

	@JsonProperty("code")
	private String code;

	@JsonProperty("hotel_booking_policy")
	private HotelBookingPolicy hotelBookingPolicy;

	@JsonProperty("rates_type")
	private String ratesType;

	@JsonProperty("messages")
	private Messages messages;

	@JsonProperty("hotel")
	private int hotel;

	@JsonProperty("prices")
	private Prices prices;

	@JsonProperty("board")
	private String board;

	@JsonProperty("combination")
	private Combination combination;

	@JsonProperty("added_value_services")
	private Object addedValueServices;

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setHotelBookingPolicy(HotelBookingPolicy hotelBookingPolicy){
		this.hotelBookingPolicy = hotelBookingPolicy;
	}

	public HotelBookingPolicy getHotelBookingPolicy(){
		return hotelBookingPolicy;
	}

	public void setRatesType(String ratesType){
		this.ratesType = ratesType;
	}

	public String getRatesType(){
		return ratesType;
	}

	public void setMessages(Messages messages){
		this.messages = messages;
	}

	public Messages getMessages(){
		return messages;
	}

	public void setHotel(int hotel){
		this.hotel = hotel;
	}

	public int getHotel(){
		return hotel;
	}

	public void setPrices(Prices prices){
		this.prices = prices;
	}

	public Prices getPrices(){
		return prices;
	}

	public void setBoard(String board){
		this.board = board;
	}

	public String getBoard(){
		return board;
	}

	public void setCombination(Combination combination){
		this.combination = combination;
	}

	public Combination getCombination(){
		return combination;
	}

	public void setAddedValueServices(Object addedValueServices){
		this.addedValueServices = addedValueServices;
	}

	public Object getAddedValueServices(){
		return addedValueServices;
	}

	@Override
 	public String toString(){
		return 
			"AvailabilitiesItem{" + 
			"code = '" + code + '\'' + 
			",hotel_booking_policy = '" + hotelBookingPolicy + '\'' + 
			",rates_type = '" + ratesType + '\'' + 
			",messages = '" + messages + '\'' + 
			",hotel = '" + hotel + '\'' + 
			",prices = '" + prices + '\'' + 
			",board = '" + board + '\'' + 
			",combination = '" + combination + '\'' + 
			",added_value_services = '" + addedValueServices + '\'' + 
			"}";
		}
}