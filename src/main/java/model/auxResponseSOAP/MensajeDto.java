package model.auxResponseSOAP;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MensajeDto{

	@JsonProperty("codigo")
	private String codigo;

	@JsonProperty("LValores")
	private Object lValores;

	@JsonProperty("valorGeneral")
	private String valorGeneral;

	public void setCodigo(String codigo){
		this.codigo = codigo;
	}

	public String getCodigo(){
		return codigo;
	}

	public void setLValores(Object lValores){
		this.lValores = lValores;
	}

	public Object getLValores(){
		return lValores;
	}

	public void setValorGeneral(String valorGeneral){
		this.valorGeneral = valorGeneral;
	}

	public String getValorGeneral(){
		return valorGeneral;
	}

	@Override
 	public String toString(){
		return 
			"MensajeDto{" + 
			"codigo = '" + codigo + '\'' + 
			",lValores = '" + lValores + '\'' + 
			",valorGeneral = '" + valorGeneral + '\'' + 
			"}";
		}
}