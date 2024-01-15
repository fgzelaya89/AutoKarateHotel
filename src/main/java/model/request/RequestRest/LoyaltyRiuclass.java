package model.request.RequestRest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoyaltyRiuclass{

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
			"LoyaltyRiuclass{" + 
			"account_code = '" + accountCode + '\'' + 
			"}";
		}
}