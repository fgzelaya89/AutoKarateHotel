package model.auxResponseSOAP;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DescuentoPuntosGeneradoDto{

	@JsonProperty("precioCodDiv")
	private String precioCodDiv;

	@JsonProperty("descuento")
	private String descuento;

	@JsonProperty("maximo")
	private Maximo maximo;

	@JsonProperty("porcentaje")
	private String porcentaje;

	@JsonProperty("puntos")
	private String puntos;

	public void setPrecioCodDiv(String precioCodDiv){
		this.precioCodDiv = precioCodDiv;
	}

	public String getPrecioCodDiv(){
		return precioCodDiv;
	}

	public void setDescuento(String descuento){
		this.descuento = descuento;
	}

	public String getDescuento(){
		return descuento;
	}

	public void setMaximo(Maximo maximo){
		this.maximo = maximo;
	}

	public Maximo getMaximo(){
		return maximo;
	}

	public void setPorcentaje(String porcentaje){
		this.porcentaje = porcentaje;
	}

	public String getPorcentaje(){
		return porcentaje;
	}

	public void setPuntos(String puntos){
		this.puntos = puntos;
	}

	public String getPuntos(){
		return puntos;
	}

	@Override
 	public String toString(){
		return 
			"DescuentoPuntosGeneradoDto{" + 
			"precioCodDiv = '" + precioCodDiv + '\'' + 
			",descuento = '" + descuento + '\'' + 
			",maximo = '" + maximo + '\'' + 
			",porcentaje = '" + porcentaje + '\'' + 
			",puntos = '" + puntos + '\'' + 
			"}";
		}
}