package model.auxResponseSOAP;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Objeto{

	@JsonProperty("soap:Body")
	private SoapBody soapBody;

	@JsonProperty("out")
	private Out out;

	@JsonProperty("ValorarCombinacionesRbDto")
	private List<ValorarCombinacionesRbDtoItem> valorarCombinacionesRbDto;

	public void setSoapBody(SoapBody soapBody){
		this.soapBody = soapBody;
	}

	public SoapBody getSoapBody(){
		return soapBody;
	}

	public void setOut(Out out){
		this.out = out;
	}

	public Out getOut(){
		return out;
	}

	public void setValorarCombinacionesRbDto(List<ValorarCombinacionesRbDtoItem> valorarCombinacionesRbDto){
		this.valorarCombinacionesRbDto = valorarCombinacionesRbDto;
	}

	public List<ValorarCombinacionesRbDtoItem> getValorarCombinacionesRbDto(){
		return valorarCombinacionesRbDto;
	}

	@Override
 	public String toString(){
		return 
			"Objeto{" + 
			"soap:Body = '" + soapBody + '\'' + 
			",out = '" + out + '\'' + 
			",valorarCombinacionesRbDto = '" + valorarCombinacionesRbDto + '\'' + 
			"}";
		}
}