package model.request.RequestRest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class GuestDistributionsItem{

	@JsonProperty("children")
	private int children;

	@JsonProperty("adults")
	private int adults;

	@JsonProperty("babies")
	private int babies;

	@JsonProperty("children_ages")
	private List<Integer> childrenAges = new ArrayList<Integer>();

	public GuestDistributionsItem( int adults, int children,int babies) {
		this.children = children;
		this.adults = adults;
		this.babies = babies;
	}

	public int getChildren(){
		return children;
	}

	public int getAdults(){
		return adults;
	}

	public int getBabies(){
		return babies;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public void setAdults(int adults) {
		this.adults = adults;
	}

	public void setBabies(int babies) {
		this.babies = babies;
	}

	public List<Integer> getChildrenAges() {
		return childrenAges;
	}

	public void setChildrenAges(List<Integer> childrenAges) {
		this.childrenAges = childrenAges;
	}

	public void addChildrenAges(int childrenAges) {
		this.childrenAges.add(childrenAges);
	}


	@Override
	public String toString() {
		return "GuestDistributionsItem{" +
				"children=" + children +
				", adults=" + adults +
				", babies=" + babies +
				", childrenAges=" + childrenAges +
				'}';
	}
}