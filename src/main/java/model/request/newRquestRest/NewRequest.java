package model.request.newRquestRest;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NewRequest{

	@JsonProperty("guest_checkin_date")
	private String guestCheckinDate;

	@JsonProperty("query_effective_date")
	private String queryEffectiveDate;

	@JsonProperty("country_origin")
	private String countryOrigin;

	@JsonProperty("loyalty_riuclass")
	private LoyaltyRiuclass loyaltyRiuclass;

	@JsonProperty("guest_checkout_date")
	private String guestCheckoutDate;

	@JsonProperty("destination")
	private Destination destination;

	@JsonProperty("guest_distributions")
	private List<GuestDistributionsItem> guestDistributions;

	@JsonProperty("channel")
	private String channel;

	@JsonProperty("boards")
	private List<String> boards;

	@JsonProperty("promocode")
	private String promocode;

	@JsonProperty("booking_reference")
	private String bookingReference;

	@JsonProperty("loyalty_riupartnerclass")
	private LoyaltyRiupartnerclass loyaltyRiupartnerclass;

	@JsonProperty("rate_reference")
	private String rateReference;

	@JsonProperty("room_types")
	private List<String> roomTypes;

	@JsonProperty("vendor")
	private String vendor;

	@JsonProperty("client")
	private int client;

	public void setGuestCheckinDate(String guestCheckinDate){
		this.guestCheckinDate = guestCheckinDate;
	}

	public String getGuestCheckinDate(){
		return guestCheckinDate;
	}

	public void setQueryEffectiveDate(String queryEffectiveDate){
		this.queryEffectiveDate = queryEffectiveDate;
	}

	public String getQueryEffectiveDate(){
		return queryEffectiveDate;
	}

	public void setCountryOrigin(String countryOrigin){
		this.countryOrigin = countryOrigin;
	}

	public String getCountryOrigin(){
		return countryOrigin;
	}

	public void setLoyaltyRiuclass(LoyaltyRiuclass loyaltyRiuclass){
		this.loyaltyRiuclass = loyaltyRiuclass;
	}

	public LoyaltyRiuclass getLoyaltyRiuclass(){
		return loyaltyRiuclass;
	}

	public void setGuestCheckoutDate(String guestCheckoutDate){
		this.guestCheckoutDate = guestCheckoutDate;
	}

	public String getGuestCheckoutDate(){
		return guestCheckoutDate;
	}

	public void setDestination(Destination destination){
		this.destination = destination;
	}

	public Destination getDestination(){
		return destination;
	}

	public void setGuestDistributions(List<GuestDistributionsItem> guestDistributions){
		this.guestDistributions = guestDistributions;
	}

	public List<GuestDistributionsItem> getGuestDistributions(){
		return guestDistributions;
	}

	public void setChannel(String channel){
		this.channel = channel;
	}

	public String getChannel(){
		return channel;
	}

	public void setBoards(List<String> boards){
		this.boards = boards;
	}

	public List<String> getBoards(){
		return boards;
	}

	public void setPromocode(String promocode){
		this.promocode = promocode;
	}

	public String getPromocode(){
		return promocode;
	}

	public void setBookingReference(String bookingReference){
		this.bookingReference = bookingReference;
	}

	public String getBookingReference(){
		return bookingReference;
	}

	public void setLoyaltyRiupartnerclass(LoyaltyRiupartnerclass loyaltyRiupartnerclass){
		this.loyaltyRiupartnerclass = loyaltyRiupartnerclass;
	}

	public LoyaltyRiupartnerclass getLoyaltyRiupartnerclass(){
		return loyaltyRiupartnerclass;
	}

	public void setRateReference(String rateReference){
		this.rateReference = rateReference;
	}

	public String getRateReference(){
		return rateReference;
	}

	public void setRoomTypes(List<String> roomTypes){
		this.roomTypes = roomTypes;
	}

	public List<String> getRoomTypes(){
		return roomTypes;
	}

	public void setVendor(String vendor){
		this.vendor = vendor;
	}

	public String getVendor(){
		return vendor;
	}

	public void setClient(int client){
		this.client = client;
	}

	public int getClient(){
		return client;
	}

	@Override
 	public String toString(){
		return 
			"NewRequest{" + 
			"guest_checkin_date = '" + guestCheckinDate + '\'' + 
			",query_effective_date = '" + queryEffectiveDate + '\'' + 
			",country_origin = '" + countryOrigin + '\'' + 
			",loyalty_riuclass = '" + loyaltyRiuclass + '\'' + 
			",guest_checkout_date = '" + guestCheckoutDate + '\'' + 
			",destination = '" + destination + '\'' + 
			",guest_distributions = '" + guestDistributions + '\'' + 
			",channel = '" + channel + '\'' + 
			",boards = '" + boards + '\'' + 
			",promocode = '" + promocode + '\'' + 
			",booking_reference = '" + bookingReference + '\'' + 
			",loyalty_riupartnerclass = '" + loyaltyRiupartnerclass + '\'' + 
			",rate_reference = '" + rateReference + '\'' + 
			",room_types = '" + roomTypes + '\'' + 
			",vendor = '" + vendor + '\'' + 
			",client = '" + client + '\'' + 
			"}";
		}
}