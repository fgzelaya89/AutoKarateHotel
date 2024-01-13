package model.responseRest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GuestDistribution{

	@JsonProperty("children")
	private int children;

	@JsonProperty("adults")
	private int adults;

	@JsonProperty("children_ages")
	private Object childrenAges;

	@JsonProperty("babies")
	private int babies;

	public void setChildren(int children){
		this.children = children;
	}

	public int getChildren(){
		return children;
	}

	public void setAdults(int adults){
		this.adults = adults;
	}

	public int getAdults(){
		return adults;
	}

	public void setChildrenAges(Object childrenAges){
		this.childrenAges = childrenAges;
	}

	public Object getChildrenAges(){
		return childrenAges;
	}

	public void setBabies(int babies){
		this.babies = babies;
	}

	public int getBabies(){
		return babies;
	}

	@Override
 	public String toString(){
		return 
			"GuestDistribution{" + 
			"children = '" + children + '\'' + 
			",adults = '" + adults + '\'' + 
			",children_ages = '" + childrenAges + '\'' + 
			",babies = '" + babies + '\'' + 
			"}";
		}
}