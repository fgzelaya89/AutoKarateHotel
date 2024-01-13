package model.auxResponseSOAP;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Estado{

	@JsonProperty("Arroba")
	private Arroba arroba;

	@JsonProperty("Objeto")
	private String objeto;

	public void setArroba(Arroba arroba){
		this.arroba = arroba;
	}

	public Arroba getArroba(){
		return arroba;
	}

	public void setObjeto(String objeto){
		this.objeto = objeto;
	}

	public String getObjeto(){
		return objeto;
	}

	@Override
 	public String toString(){
		return 
			"Estado{" + 
			"arroba = '" + arroba + '\'' + 
			",objeto = '" + objeto + '\'' + 
			"}";
		}
}