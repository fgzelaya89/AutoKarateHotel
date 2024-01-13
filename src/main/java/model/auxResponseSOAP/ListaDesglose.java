package model.auxResponseSOAP;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ListaDesglose{

	@JsonProperty("DesglosePreciosDto")
	private List<DesglosePreciosDtoItem> desglosePreciosDto;

	public void setDesglosePreciosDto(List<DesglosePreciosDtoItem> desglosePreciosDto){
		this.desglosePreciosDto = desglosePreciosDto;
	}

	public List<DesglosePreciosDtoItem> getDesglosePreciosDto(){
		return desglosePreciosDto;
	}

	@Override
 	public String toString(){
		return 
			"ListaDesglose{" + 
			"desglosePreciosDto = '" + desglosePreciosDto + '\'' + 
			"}";
		}
}