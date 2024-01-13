package model.responseRest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PriceWithoutTax{

	@JsonProperty("amount")
	private Object amount;

	@JsonProperty("currency")
	private String currency;

	public void setAmount(Object amount){
		this.amount = amount;
	}

	public Object getAmount(){
		return amount;
	}

	public void setCurrency(String currency){
		this.currency = currency;
	}

	public String getCurrency(){
		return currency;
	}

	@Override
 	public String toString(){
		return 
			"PriceWithoutTax{" + 
			"amount = '" + amount + '\'' + 
			",currency = '" + currency + '\'' + 
			"}";
		}
}