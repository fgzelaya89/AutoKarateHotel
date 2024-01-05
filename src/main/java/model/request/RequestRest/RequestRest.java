package model.request.RequestRest;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestRest {

    @JsonProperty("guest_checkin_date")
    private String guestCheckinDate;

    @JsonProperty("room_types")
    private List<String> roomTypes = new ArrayList<String>();;

    @JsonProperty("country_origin")
    private String countryOrigin;

    @JsonProperty("vendor")
    private String vendor;

    @JsonProperty("guest_checkout_date")
    private String guestCheckoutDate;

    @JsonProperty("destination")
    private Destination destination;

    @JsonProperty("guest_distributions")
    private List<GuestDistributionsItem> guestDistributions = new ArrayList<GuestDistributionsItem>();

    @JsonProperty("channel")
    private String channel;

    @JsonProperty("boards")
    private List<String> boards = new ArrayList<String>();

    public String getGuestCheckinDate() {
        return guestCheckinDate;
    }

    public List<String> getRoomTypes() {
        return roomTypes;
    }

    public String getCountryOrigin() {
        return countryOrigin;
    }

    public String getVendor() {
        return vendor;
    }

    public String getGuestCheckoutDate() {
        return guestCheckoutDate;
    }

    public Destination getDestination() {
        return destination;
    }

    public List<GuestDistributionsItem> getGuestDistributions() {
        return guestDistributions;
    }

    public String getChannel() {
        return channel;
    }

    public List<String> getBoards() {
        return boards;
    }

    public void addBoards(String boards){
        this.boards.add(boards);
    }

    public void setGuestCheckinDate(String guestCheckinDate) {
        this.guestCheckinDate = guestCheckinDate;
    }

    public void setRoomTypes(List<String> roomTypes) {
        this.roomTypes = roomTypes;
    }

    public void addRoomTypes(String roomTypes) {
        this.roomTypes.add(roomTypes);
    }

    public void setCountryOrigin(String countryOrigin) {
        this.countryOrigin = countryOrigin;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setGuestCheckoutDate(String guestCheckoutDate) {
        this.guestCheckoutDate = guestCheckoutDate;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public void setGuestDistributions(List<GuestDistributionsItem> guestDistributions) {
        this.guestDistributions = guestDistributions;
    }

    public void addGuestDistributions(GuestDistributionsItem guestDistributions) {
        this.guestDistributions.add(guestDistributions);
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public void setBoards(List<String> boards) {
        this.boards = boards;
    }

    @Override
    public String toString() {
        return "RequestRest{" +
                "guestCheckinDate='" + guestCheckinDate + '\'' +
                ", roomTypes=" + roomTypes +
                ", countryOrigin='" + countryOrigin + '\'' +
                ", vendor='" + vendor + '\'' +
                ", guestCheckoutDate='" + guestCheckoutDate + '\'' +
                ", destination=" + destination +
                ", guestDistributions=" + guestDistributions +
                ", channel='" + channel + '\'' +
                ", boards=" + boards +
                '}';
    }
}