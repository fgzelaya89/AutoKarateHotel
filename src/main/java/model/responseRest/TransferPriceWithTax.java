package model.responseRest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransferPriceWithTax{

	@JsonProperty("amount")
	private int amount;

	@JsonProperty("currency")
	private String currency;

	public void setAmount(int amount){
		this.amount = amount;
	}

	public int getAmount(){
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
			"TransferPriceWithTax{" + 
			"amount = '" + amount + '\'' + 
			",currency = '" + currency + '\'' + 
			"}";
		}
}