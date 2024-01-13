package model.responseRest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Prices{

	@JsonProperty("price_without_tax")
	private PriceWithoutTax priceWithoutTax;

	@JsonProperty("price_with_tax")
	private PriceWithTax priceWithTax;

	@JsonProperty("transfer_price_with_tax")
	private TransferPriceWithTax transferPriceWithTax;

	@JsonProperty("transfer_price_without_tax")
	private TransferPriceWithoutTax transferPriceWithoutTax;

	@JsonProperty("riuclass_points")
	private Object riuclassPoints;

	@JsonProperty("previous_price_with_tax")
	private PreviousPriceWithTax previousPriceWithTax;

	@JsonProperty("previous_price_without_tax")
	private PreviousPriceWithoutTax previousPriceWithoutTax;

	public void setPriceWithoutTax(PriceWithoutTax priceWithoutTax){
		this.priceWithoutTax = priceWithoutTax;
	}

	public PriceWithoutTax getPriceWithoutTax(){
		return priceWithoutTax;
	}

	public void setPriceWithTax(PriceWithTax priceWithTax){
		this.priceWithTax = priceWithTax;
	}

	public PriceWithTax getPriceWithTax(){
		return priceWithTax;
	}

	public void setTransferPriceWithTax(TransferPriceWithTax transferPriceWithTax){
		this.transferPriceWithTax = transferPriceWithTax;
	}

	public TransferPriceWithTax getTransferPriceWithTax(){
		return transferPriceWithTax;
	}

	public void setTransferPriceWithoutTax(TransferPriceWithoutTax transferPriceWithoutTax){
		this.transferPriceWithoutTax = transferPriceWithoutTax;
	}

	public TransferPriceWithoutTax getTransferPriceWithoutTax(){
		return transferPriceWithoutTax;
	}

	public void setRiuclassPoints(Object riuclassPoints){
		this.riuclassPoints = riuclassPoints;
	}

	public Object getRiuclassPoints(){
		return riuclassPoints;
	}

	public void setPreviousPriceWithTax(PreviousPriceWithTax previousPriceWithTax){
		this.previousPriceWithTax = previousPriceWithTax;
	}

	public PreviousPriceWithTax getPreviousPriceWithTax(){
		return previousPriceWithTax;
	}

	public void setPreviousPriceWithoutTax(PreviousPriceWithoutTax previousPriceWithoutTax){
		this.previousPriceWithoutTax = previousPriceWithoutTax;
	}

	public PreviousPriceWithoutTax getPreviousPriceWithoutTax(){
		return previousPriceWithoutTax;
	}

	@Override
 	public String toString(){
		return 
			"Prices{" + 
			"price_without_tax = '" + priceWithoutTax + '\'' + 
			",price_with_tax = '" + priceWithTax + '\'' + 
			",transfer_price_with_tax = '" + transferPriceWithTax + '\'' + 
			",transfer_price_without_tax = '" + transferPriceWithoutTax + '\'' + 
			",riuclass_points = '" + riuclassPoints + '\'' + 
			",previous_price_with_tax = '" + previousPriceWithTax + '\'' + 
			",previous_price_without_tax = '" + previousPriceWithoutTax + '\'' + 
			"}";
		}
}