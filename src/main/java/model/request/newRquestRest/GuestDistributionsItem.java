package model.request.newRquestRest;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GuestDistributionsItem{

	@JsonProperty("children")
	private int children;

	@JsonProperty("adults")
	private int adults;

	@JsonProperty("children_ages")
	private List<Integer> childrenAges;

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

	public void setChildrenAges(List<Integer> childrenAges){
		this.childrenAges = childrenAges;
	}

	public List<Integer> getChildrenAges(){
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
			"GuestDistributionsItem{" + 
			"children = '" + children + '\'' + 
			",adults = '" + adults + '\'' + 
			",children_ages = '" + childrenAges + '\'' + 
			",babies = '" + babies + '\'' + 
			"}";
		}
}