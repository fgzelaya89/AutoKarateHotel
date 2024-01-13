package model.auxResponseSOAP;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseSOAP{

	@JsonProperty("soap:Envelope")
	private SoapEnvelope soapEnvelope;

	public void setSoapEnvelope(SoapEnvelope soapEnvelope){
		this.soapEnvelope = soapEnvelope;
	}

	public SoapEnvelope getSoapEnvelope(){
		return soapEnvelope;
	}

	@Override
 	public String toString(){
		return 
			"ResponseSOAP{" + 
			"soap:Envelope = '" + soapEnvelope + '\'' + 
			"}";
		}
}