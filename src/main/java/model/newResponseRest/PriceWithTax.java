package model.newResponseRest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PriceWithTax{

	@JsonProperty("amount")
	private Object amount;

	@JsonProperty("currency")
	private String currency;

	public Object getAmount(){
		return amount;
	}

	public String getCurrency(){
		return currency;
	}

	@Override
 	public String toString(){
		return 
			"PriceWithTax{" + 
			"amount = '" + amount + '\'' + 
			",currency = '" + currency + '\'' + 
			"}";
		}
}