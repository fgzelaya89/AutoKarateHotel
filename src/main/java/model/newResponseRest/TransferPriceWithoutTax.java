package model.newResponseRest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransferPriceWithoutTax{

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
			"TransferPriceWithoutTax{" + 
			"amount = '" + amount + '\'' + 
			",currency = '" + currency + '\'' + 
			"}";
		}
}