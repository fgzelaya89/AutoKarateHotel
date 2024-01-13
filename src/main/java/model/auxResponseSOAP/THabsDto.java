package model.auxResponseSOAP;

import com.fasterxml.jackson.annotation.JsonProperty;

public class THabsDto{

	@JsonProperty("listTranslation")
	private ListTranslation listTranslation;

	@JsonProperty("hotel")
	private String hotel;

	@JsonProperty("codTha")
	private String codTha;

	public void setListTranslation(ListTranslation listTranslation){
		this.listTranslation = listTranslation;
	}

	public ListTranslation getListTranslation(){
		return listTranslation;
	}

	public void setHotel(String hotel){
		this.hotel = hotel;
	}

	public String getHotel(){
		return hotel;
	}

	public void setCodTha(String codTha){
		this.codTha = codTha;
	}

	public String getCodTha(){
		return codTha;
	}

	@Override
 	public String toString(){
		return 
			"THabsDto{" + 
			"listTranslation = '" + listTranslation + '\'' + 
			",hotel = '" + hotel + '\'' + 
			",codTha = '" + codTha + '\'' + 
			"}";
		}
}