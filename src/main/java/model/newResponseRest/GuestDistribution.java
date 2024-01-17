package model.newResponseRest;

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

	public int getChildren(){
		return children;
	}

	public int getAdults(){
		return adults;
	}

	public Object getChildrenAges(){
		return childrenAges;
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