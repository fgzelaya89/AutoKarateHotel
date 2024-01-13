package model.auxResponseSOAP;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HabitacionesValCombinacionesDtoItem{

	@JsonProperty("gratuidades")
	private Object gratuidades;

	@JsonProperty("numbb")
	private String numbb;

	@JsonProperty("precio")
	private String precio;

	@JsonProperty("codtre")
	private String codtre;

	@JsonProperty("numni")
	private String numni;

	@JsonProperty("edades")
	private Object edades;

	@JsonProperty("listaPeriodosPrecio")
	private ListaPeriodosPrecio listaPeriodosPrecio;

	@JsonProperty("numHab")
	private String numHab;

	@JsonProperty("precioSinImpuestos")
	private String precioSinImpuestos;

	@JsonProperty("flagCompararOcupacionEnEquals")
	private String flagCompararOcupacionEnEquals;

	@JsonProperty("numad")
	private String numad;

	@JsonProperty("codtha")
	private String codtha;

	public void setGratuidades(Object gratuidades){
		this.gratuidades = gratuidades;
	}

	public Object getGratuidades(){
		return gratuidades;
	}

	public void setNumbb(String numbb){
		this.numbb = numbb;
	}

	public String getNumbb(){
		return numbb;
	}

	public void setPrecio(String precio){
		this.precio = precio;
	}

	public String getPrecio(){
		return precio;
	}

	public void setCodtre(String codtre){
		this.codtre = codtre;
	}

	public String getCodtre(){
		return codtre;
	}

	public void setNumni(String numni){
		this.numni = numni;
	}

	public String getNumni(){
		return numni;
	}

	public void setEdades(Object edades){
		this.edades = edades;
	}

	public Object getEdades(){
		return edades;
	}

	public void setListaPeriodosPrecio(ListaPeriodosPrecio listaPeriodosPrecio){
		this.listaPeriodosPrecio = listaPeriodosPrecio;
	}

	public ListaPeriodosPrecio getListaPeriodosPrecio(){
		return listaPeriodosPrecio;
	}

	public void setNumHab(String numHab){
		this.numHab = numHab;
	}

	public String getNumHab(){
		return numHab;
	}

	public void setPrecioSinImpuestos(String precioSinImpuestos){
		this.precioSinImpuestos = precioSinImpuestos;
	}

	public String getPrecioSinImpuestos(){
		return precioSinImpuestos;
	}

	public void setFlagCompararOcupacionEnEquals(String flagCompararOcupacionEnEquals){
		this.flagCompararOcupacionEnEquals = flagCompararOcupacionEnEquals;
	}

	public String getFlagCompararOcupacionEnEquals(){
		return flagCompararOcupacionEnEquals;
	}

	public void setNumad(String numad){
		this.numad = numad;
	}

	public String getNumad(){
		return numad;
	}

	public void setCodtha(String codtha){
		this.codtha = codtha;
	}

	public String getCodtha(){
		return codtha;
	}

	@Override
 	public String toString(){
		return 
			"HabitacionesValCombinacionesDtoItem{" + 
			"gratuidades = '" + gratuidades + '\'' + 
			",numbb = '" + numbb + '\'' + 
			",precio = '" + precio + '\'' + 
			",codtre = '" + codtre + '\'' + 
			",numni = '" + numni + '\'' + 
			",edades = '" + edades + '\'' + 
			",listaPeriodosPrecio = '" + listaPeriodosPrecio + '\'' + 
			",numHab = '" + numHab + '\'' + 
			",precioSinImpuestos = '" + precioSinImpuestos + '\'' + 
			",flagCompararOcupacionEnEquals = '" + flagCompararOcupacionEnEquals + '\'' + 
			",numad = '" + numad + '\'' + 
			",codtha = '" + codtha + '\'' + 
			"}";
		}
}