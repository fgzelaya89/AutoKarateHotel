package model.auxResponseSOAP;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Out{

	@JsonProperty("estado")
	private Estado estado;

	@JsonProperty("listaAvail")
	private ListaAvail listaAvail;

	@JsonProperty("LMensajes")
	private LMensajes lMensajes;

	@JsonProperty("errores")
	private Errores errores;

	public void setEstado(Estado estado){
		this.estado = estado;
	}

	public Estado getEstado(){
		return estado;
	}

	public void setListaAvail(ListaAvail listaAvail){
		this.listaAvail = listaAvail;
	}

	public ListaAvail getListaAvail(){
		return listaAvail;
	}

	public void setLMensajes(LMensajes lMensajes){
		this.lMensajes = lMensajes;
	}

	public LMensajes getLMensajes(){
		return lMensajes;
	}

	public void setErrores(Errores errores){
		this.errores = errores;
	}

	public Errores getErrores(){
		return errores;
	}

	@Override
 	public String toString(){
		return 
			"Out{" + 
			"estado = '" + estado + '\'' + 
			",listaAvail = '" + listaAvail + '\'' + 
			",lMensajes = '" + lMensajes + '\'' + 
			",errores = '" + errores + '\'' + 
			"}";
		}
}