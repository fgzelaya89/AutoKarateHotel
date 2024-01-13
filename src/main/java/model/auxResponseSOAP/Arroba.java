package model.auxResponseSOAP;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Arroba{

	@JsonProperty("xmlns")
	private String xmlns;

	@JsonProperty("xsi:nil")
	private String xsiNil;

	@JsonProperty("xmlns:xsd")
	private String xmlnsXsd;

	@JsonProperty("xmlns:soap")
	private String xmlnsSoap;

	@JsonProperty("xmlns:xsi")
	private String xmlnsXsi;

	public void setXmlns(String xmlns){
		this.xmlns = xmlns;
	}

	public String getXmlns(){
		return xmlns;
	}

	public void setXsiNil(String xsiNil){
		this.xsiNil = xsiNil;
	}

	public String getXsiNil(){
		return xsiNil;
	}

	public void setXmlnsXsd(String xmlnsXsd){
		this.xmlnsXsd = xmlnsXsd;
	}

	public String getXmlnsXsd(){
		return xmlnsXsd;
	}

	public void setXmlnsSoap(String xmlnsSoap){
		this.xmlnsSoap = xmlnsSoap;
	}

	public String getXmlnsSoap(){
		return xmlnsSoap;
	}

	public void setXmlnsXsi(String xmlnsXsi){
		this.xmlnsXsi = xmlnsXsi;
	}

	public String getXmlnsXsi(){
		return xmlnsXsi;
	}

	@Override
 	public String toString(){
		return 
			"Arroba{" + 
			"xmlns = '" + xmlns + '\'' + 
			",xsi:nil = '" + xsiNil + '\'' + 
			",xmlns:xsd = '" + xmlnsXsd + '\'' + 
			",xmlns:soap = '" + xmlnsSoap + '\'' + 
			",xmlns:xsi = '" + xmlnsXsi + '\'' + 
			"}";
		}
}