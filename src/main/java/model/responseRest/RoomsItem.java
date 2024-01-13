package model.responseRest;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RoomsItem{

	@JsonProperty("price_without_tax")
	private List<PriceWithoutTaxItem> priceWithoutTax;

	@JsonProperty("guest_distribution")
	private GuestDistribution guestDistribution;

	@JsonProperty("room_type_code")
	private String roomTypeCode;

	@JsonProperty("price_with_tax")
	private List<PriceWithTaxItem> priceWithTax;

	@JsonProperty("free_paxes")
	private Object freePaxes;

	public void setPriceWithoutTax(List<PriceWithoutTaxItem> priceWithoutTax){
		this.priceWithoutTax = priceWithoutTax;
	}

	public List<PriceWithoutTaxItem> getPriceWithoutTax(){
		return priceWithoutTax;
	}

	public void setGuestDistribution(GuestDistribution guestDistribution){
		this.guestDistribution = guestDistribution;
	}

	public GuestDistribution getGuestDistribution(){
		return guestDistribution;
	}

	public void setRoomTypeCode(String roomTypeCode){
		this.roomTypeCode = roomTypeCode;
	}

	public String getRoomTypeCode(){
		return roomTypeCode;
	}

	public void setPriceWithTax(List<PriceWithTaxItem> priceWithTax){
		this.priceWithTax = priceWithTax;
	}

	public List<PriceWithTaxItem> getPriceWithTax(){
		return priceWithTax;
	}

	public void setFreePaxes(Object freePaxes){
		this.freePaxes = freePaxes;
	}

	public Object getFreePaxes(){
		return freePaxes;
	}

	@Override
 	public String toString(){
		return 
			"RoomsItem{" + 
			"price_without_tax = '" + priceWithoutTax + '\'' + 
			",guest_distribution = '" + guestDistribution + '\'' + 
			",room_type_code = '" + roomTypeCode + '\'' + 
			",price_with_tax = '" + priceWithTax + '\'' + 
			",free_paxes = '" + freePaxes + '\'' + 
			"}";
		}
}