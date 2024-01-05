package model.request.testBorrar;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestMyStoreApi{

	@JsonProperty("price")
	private int price;

	@JsonProperty("name")
	private String name;

	@JsonProperty("description")
	private String description;

	@JsonProperty("category")
	private String category;

	@JsonProperty("manufacturer")
	private String manufacturer;

	@JsonProperty("tags")
	private String tags;

	public void setPrice(int price){
		this.price = price;
	}

	public int getPrice(){
		return price;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	public void setManufacturer(String manufacturer){
		this.manufacturer = manufacturer;
	}

	public String getManufacturer(){
		return manufacturer;
	}

	public void setTags(String tags){
		this.tags = tags;
	}

	public String getTags(){
		return tags;
	}

	@Override
 	public String toString(){
		return 
			"RequestMyStoreApi{" + 
			"price = '" + price + '\'' + 
			",name = '" + name + '\'' + 
			",description = '" + description + '\'' + 
			",category = '" + category + '\'' + 
			",manufacturer = '" + manufacturer + '\'' + 
			",tags = '" + tags + '\'' + 
			"}";
		}

	public RequestMyStoreApi(int price, String name, String description, String category, String manufacturer, String tags) {
		this.price = price;
		this.name = name;
		this.description = description;
		this.category = category;
		this.manufacturer = manufacturer;
		this.tags = tags;
	}
}