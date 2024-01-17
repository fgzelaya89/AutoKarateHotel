package model.newResponseRest;

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

	public List<PriceWithoutTaxItem> getPriceWithoutTax(){
		return priceWithoutTax;
	}

	public GuestDistribution getGuestDistribution(){
		return guestDistribution;
	}

	public String getRoomTypeCode(){
		return roomTypeCode;
	}

	public List<PriceWithTaxItem> getPriceWithTax(){
		return priceWithTax;
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