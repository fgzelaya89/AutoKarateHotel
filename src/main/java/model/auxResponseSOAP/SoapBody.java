package model.auxResponseSOAP;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SoapBody{

	@JsonProperty("recuperarTablaPreciosRBResponse")
	private RecuperarTablaPreciosRBResponse recuperarTablaPreciosRBResponse;

	public void setRecuperarTablaPreciosRBResponse(RecuperarTablaPreciosRBResponse recuperarTablaPreciosRBResponse){
		this.recuperarTablaPreciosRBResponse = recuperarTablaPreciosRBResponse;
	}

	public RecuperarTablaPreciosRBResponse getRecuperarTablaPreciosRBResponse(){
		return recuperarTablaPreciosRBResponse;
	}

	@Override
 	public String toString(){
		return 
			"SoapBody{" + 
			"recuperarTablaPreciosRBResponse = '" + recuperarTablaPreciosRBResponse + '\'' + 
			"}";
		}
}