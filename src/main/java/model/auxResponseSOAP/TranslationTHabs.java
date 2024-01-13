package model.auxResponseSOAP;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TranslationTHabs{

	@JsonProperty("estado")
	private Estado estado;

	@JsonProperty("listTHabs")
	private ListTHabs listTHabs;

	@JsonProperty("errores")
	private Errores errores;

	public void setEstado(Estado estado){
		this.estado = estado;
	}

	public Estado getEstado(){
		return estado;
	}

	public void setListTHabs(ListTHabs listTHabs){
		this.listTHabs = listTHabs;
	}

	public ListTHabs getListTHabs(){
		return listTHabs;
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
			"TranslationTHabs{" + 
			"estado = '" + estado + '\'' + 
			",listTHabs = '" + listTHabs + '\'' + 
			",errores = '" + errores + '\'' + 
			"}";
		}
}