package model.auxResponseSOAP;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LMensajesAvail{

	@JsonProperty("MensajeDto")
	private MensajeDto mensajeDto;

	public void setMensajeDto(MensajeDto mensajeDto){
		this.mensajeDto = mensajeDto;
	}

	public MensajeDto getMensajeDto(){
		return mensajeDto;
	}

	@Override
 	public String toString(){
		return 
			"LMensajesAvail{" + 
			"mensajeDto = '" + mensajeDto + '\'' + 
			"}";
		}
}