package model.request.newRquestRest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoyaltyRiupartnerclass{

	@JsonProperty("account_code")
	private int accountCode;

	public void setAccountCode(int accountCode){
		this.accountCode = accountCode;
	}

	public int getAccountCode(){
		return accountCode;
	}

	@Override
 	public String toString(){
		return 
			"LoyaltyRiupartnerclass{" + 
			"account_code = '" + accountCode + '\'' + 
			"}";
		}
}