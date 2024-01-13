package model.auxResponseSOAP;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecuperarTablaPreciosRBResponse{

	@JsonProperty("Arroba")
	private Arroba arroba;

	@JsonProperty("Objeto")
	private Objeto objeto;

	public void setArroba(Arroba arroba){
		this.arroba = arroba;
	}

	public Arroba getArroba(){
		return arroba;
	}

	public void setObjeto(Objeto objeto){
		this.objeto = objeto;
	}

	public Objeto getObjeto(){
		return objeto;
	}

	@Override
 	public String toString(){
		return 
			"RecuperarTablaPreciosRBResponse{" + 
			"arroba = '" + arroba + '\'' + 
			",objeto = '" + objeto + '\'' + 
			"}";
		}
}