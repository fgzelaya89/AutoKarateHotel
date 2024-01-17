package model.newResponseRest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PreviousPriceWithTax{

	@JsonProperty("amount")
	private int amount;

	@JsonProperty("currency")
	private String currency;

	public int getAmount(){
		return amount;
	}

	public String getCurrency(){
		return currency;
	}

	@Override
 	public String toString(){
		return 
			"PreviousPriceWithTax{" + 
			"amount = '" + amount + '\'' + 
			",currency = '" + currency + '\'' + 
			"}";
		}
}