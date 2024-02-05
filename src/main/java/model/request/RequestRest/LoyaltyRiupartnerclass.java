package model.request.RequestRest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoyaltyRiupartnerclass{

	@JsonProperty("account_code")
	private String accountCode;

	public void setAccountCode(String accountCode){
		this.accountCode = accountCode;
	}

	public String getAccountCode(){
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