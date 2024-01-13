package model.auxResponseSOAP;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Errores{

	@JsonProperty("Arroba")
	private Arroba arroba;

	@JsonProperty("Objeto")
	private Object objeto;

	public void setArroba(Arroba arroba){
		this.arroba = arroba;
	}

	public Arroba getArroba(){
		return arroba;
	}

	public void setObjeto(Object objeto){
		this.objeto = objeto;
	}

	public Object getObjeto(){
		return objeto;
	}

	@Override
 	public String toString(){
		return 
			"Errores{" + 
			"arroba = '" + arroba + '\'' + 
			",objeto = '" + objeto + '\'' + 
			"}";
		}
}