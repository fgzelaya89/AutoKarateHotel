package model.newResponseRest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransferPriceWithTax{

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
			"TransferPriceWithTax{" + 
			"amount = '" + amount + '\'' + 
			",currency = '" + currency + '\'' + 
			"}";
		}
}