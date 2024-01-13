package model.auxResponseSOAP;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DesglosePreciosDtoItem{

	@JsonProperty("precio")
	private String precio;

	@JsonProperty("concepto")
	private String concepto;

	@JsonProperty("incluido")
	private String incluido;

	public void setPrecio(String precio){
		this.precio = precio;
	}

	public String getPrecio(){
		return precio;
	}

	public void setConcepto(String concepto){
		this.concepto = concepto;
	}

	public String getConcepto(){
		return concepto;
	}

	public void setIncluido(String incluido){
		this.incluido = incluido;
	}

	public String getIncluido(){
		return incluido;
	}

	@Override
 	public String toString(){
		return 
			"DesglosePreciosDtoItem{" + 
			"precio = '" + precio + '\'' + 
			",concepto = '" + concepto + '\'' + 
			",incluido = '" + incluido + '\'' + 
			"}";
		}
}