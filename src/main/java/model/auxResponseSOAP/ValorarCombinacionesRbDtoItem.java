package model.auxResponseSOAP;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValorarCombinacionesRbDtoItem{

	@JsonProperty("tipTransfer")
	private TipTransfer tipTransfer;

	@JsonProperty("tipoCombinacion")
	private String tipoCombinacion;

	@JsonProperty("translationTHabs")
	private TranslationTHabs translationTHabs;

	@JsonProperty("release")
	private String release;

	@JsonProperty("precioAnteriorSinImpuestos")
	private String precioAnteriorSinImpuestos;

	@JsonProperty("descuentoPuntosGeneradoDto")
	private DescuentoPuntosGeneradoDto descuentoPuntosGeneradoDto;

	@JsonProperty("LMensajesAvail")
	private LMensajesAvail lMensajesAvail;

	@JsonProperty("precioTransferSinImpuestos")
	private String precioTransferSinImpuestos;

	@JsonProperty("lmotivo")
	private Object lmotivo;

	@JsonProperty("precio")
	private String precio;

	@JsonProperty("hotel")
	private String hotel;

	@JsonProperty("ambito")
	private String ambito;

	@JsonProperty("precioAnterior")
	private String precioAnterior;

	@JsonProperty("id")
	private String id;

	@JsonProperty("listaDesglose")
	private ListaDesglose listaDesglose;

	@JsonProperty("paradaventa")
	private Object paradaventa;

	@JsonProperty("listaMultiCurrency")
	private ListaMultiCurrency listaMultiCurrency;

	@JsonProperty("tipoTarifa")
	private Object tipoTarifa;

	@JsonProperty("listaTransfers")
	private ListaTransfers listaTransfers;

	@JsonProperty("cadenaValidacionComb")
	private String cadenaValidacionComb;

	@JsonProperty("estmin")
	private String estmin;

	@JsonProperty("hotelObjetotarifa")
	private String hotelObjetotarifa;

	@JsonProperty("precioSinImpuestos")
	private String precioSinImpuestos;

	@JsonProperty("codigoDivisa")
	private String codigoDivisa;

	@JsonProperty("precioSinPuntos")
	private String precioSinPuntos;

	@JsonProperty("disponibilidad")
	private String disponibilidad;

	@JsonProperty("listaHabitaciones")
	private ListaHabitaciones listaHabitaciones;

	@JsonProperty("precioTransfer")
	private String precioTransfer;

	@JsonProperty("puntosHabitacion")
	private String puntosHabitacion;

	@JsonProperty("version1")
	private String version1;

	@JsonProperty("listaResortCreditsAddedValues")
	private ListaResortCreditsAddedValues listaResortCreditsAddedValues;

	@JsonProperty("switaxinl")
	private String switaxinl;

	public void setTipTransfer(TipTransfer tipTransfer){
		this.tipTransfer = tipTransfer;
	}

	public TipTransfer getTipTransfer(){
		return tipTransfer;
	}

	public void setTipoCombinacion(String tipoCombinacion){
		this.tipoCombinacion = tipoCombinacion;
	}

	public String getTipoCombinacion(){
		return tipoCombinacion;
	}

	public void setTranslationTHabs(TranslationTHabs translationTHabs){
		this.translationTHabs = translationTHabs;
	}

	public TranslationTHabs getTranslationTHabs(){
		return translationTHabs;
	}

	public void setRelease(String release){
		this.release = release;
	}

	public String getRelease(){
		return release;
	}

	public void setPrecioAnteriorSinImpuestos(String precioAnteriorSinImpuestos){
		this.precioAnteriorSinImpuestos = precioAnteriorSinImpuestos;
	}

	public String getPrecioAnteriorSinImpuestos(){
		return precioAnteriorSinImpuestos;
	}

	public void setDescuentoPuntosGeneradoDto(DescuentoPuntosGeneradoDto descuentoPuntosGeneradoDto){
		this.descuentoPuntosGeneradoDto = descuentoPuntosGeneradoDto;
	}

	public DescuentoPuntosGeneradoDto getDescuentoPuntosGeneradoDto(){
		return descuentoPuntosGeneradoDto;
	}

	public void setLMensajesAvail(LMensajesAvail lMensajesAvail){
		this.lMensajesAvail = lMensajesAvail;
	}

	public LMensajesAvail getLMensajesAvail(){
		return lMensajesAvail;
	}

	public void setPrecioTransferSinImpuestos(String precioTransferSinImpuestos){
		this.precioTransferSinImpuestos = precioTransferSinImpuestos;
	}

	public String getPrecioTransferSinImpuestos(){
		return precioTransferSinImpuestos;
	}

	public void setLmotivo(Object lmotivo){
		this.lmotivo = lmotivo;
	}

	public Object getLmotivo(){
		return lmotivo;
	}

	public void setPrecio(String precio){
		this.precio = precio;
	}

	public String getPrecio(){
		return precio;
	}

	public void setHotel(String hotel){
		this.hotel = hotel;
	}

	public String getHotel(){
		return hotel;
	}

	public void setAmbito(String ambito){
		this.ambito = ambito;
	}

	public String getAmbito(){
		return ambito;
	}

	public void setPrecioAnterior(String precioAnterior){
		this.precioAnterior = precioAnterior;
	}

	public String getPrecioAnterior(){
		return precioAnterior;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setListaDesglose(ListaDesglose listaDesglose){
		this.listaDesglose = listaDesglose;
	}

	public ListaDesglose getListaDesglose(){
		return listaDesglose;
	}

	public void setParadaventa(Object paradaventa){
		this.paradaventa = paradaventa;
	}

	public Object getParadaventa(){
		return paradaventa;
	}

	public void setListaMultiCurrency(ListaMultiCurrency listaMultiCurrency){
		this.listaMultiCurrency = listaMultiCurrency;
	}

	public ListaMultiCurrency getListaMultiCurrency(){
		return listaMultiCurrency;
	}

	public void setTipoTarifa(Object tipoTarifa){
		this.tipoTarifa = tipoTarifa;
	}

	public Object getTipoTarifa(){
		return tipoTarifa;
	}

	public void setListaTransfers(ListaTransfers listaTransfers){
		this.listaTransfers = listaTransfers;
	}

	public ListaTransfers getListaTransfers(){
		return listaTransfers;
	}

	public void setCadenaValidacionComb(String cadenaValidacionComb){
		this.cadenaValidacionComb = cadenaValidacionComb;
	}

	public String getCadenaValidacionComb(){
		return cadenaValidacionComb;
	}

	public void setEstmin(String estmin){
		this.estmin = estmin;
	}

	public String getEstmin(){
		return estmin;
	}

	public void setHotelObjetotarifa(String hotelObjetotarifa){
		this.hotelObjetotarifa = hotelObjetotarifa;
	}

	public String getHotelObjetotarifa(){
		return hotelObjetotarifa;
	}

	public void setPrecioSinImpuestos(String precioSinImpuestos){
		this.precioSinImpuestos = precioSinImpuestos;
	}

	public String getPrecioSinImpuestos(){
		return precioSinImpuestos;
	}

	public void setCodigoDivisa(String codigoDivisa){
		this.codigoDivisa = codigoDivisa;
	}

	public String getCodigoDivisa(){
		return codigoDivisa;
	}

	public void setPrecioSinPuntos(String precioSinPuntos){
		this.precioSinPuntos = precioSinPuntos;
	}

	public String getPrecioSinPuntos(){
		return precioSinPuntos;
	}

	public void setDisponibilidad(String disponibilidad){
		this.disponibilidad = disponibilidad;
	}

	public String getDisponibilidad(){
		return disponibilidad;
	}

	public void setListaHabitaciones(ListaHabitaciones listaHabitaciones){
		this.listaHabitaciones = listaHabitaciones;
	}

	public ListaHabitaciones getListaHabitaciones(){
		return listaHabitaciones;
	}

	public void setPrecioTransfer(String precioTransfer){
		this.precioTransfer = precioTransfer;
	}

	public String getPrecioTransfer(){
		return precioTransfer;
	}

	public void setPuntosHabitacion(String puntosHabitacion){
		this.puntosHabitacion = puntosHabitacion;
	}

	public String getPuntosHabitacion(){
		return puntosHabitacion;
	}

	public void setVersion1(String version1){
		this.version1 = version1;
	}

	public String getVersion1(){
		return version1;
	}

	public void setListaResortCreditsAddedValues(ListaResortCreditsAddedValues listaResortCreditsAddedValues){
		this.listaResortCreditsAddedValues = listaResortCreditsAddedValues;
	}

	public ListaResortCreditsAddedValues getListaResortCreditsAddedValues(){
		return listaResortCreditsAddedValues;
	}

	public void setSwitaxinl(String switaxinl){
		this.switaxinl = switaxinl;
	}

	public String getSwitaxinl(){
		return switaxinl;
	}

	@Override
 	public String toString(){
		return 
			"ValorarCombinacionesRbDtoItem{" + 
			"tipTransfer = '" + tipTransfer + '\'' + 
			",tipoCombinacion = '" + tipoCombinacion + '\'' + 
			",translationTHabs = '" + translationTHabs + '\'' + 
			",release = '" + release + '\'' + 
			",precioAnteriorSinImpuestos = '" + precioAnteriorSinImpuestos + '\'' + 
			",descuentoPuntosGeneradoDto = '" + descuentoPuntosGeneradoDto + '\'' + 
			",lMensajesAvail = '" + lMensajesAvail + '\'' + 
			",precioTransferSinImpuestos = '" + precioTransferSinImpuestos + '\'' + 
			",lmotivo = '" + lmotivo + '\'' + 
			",precio = '" + precio + '\'' + 
			",hotel = '" + hotel + '\'' + 
			",ambito = '" + ambito + '\'' + 
			",precioAnterior = '" + precioAnterior + '\'' + 
			",id = '" + id + '\'' + 
			",listaDesglose = '" + listaDesglose + '\'' + 
			",paradaventa = '" + paradaventa + '\'' + 
			",listaMultiCurrency = '" + listaMultiCurrency + '\'' + 
			",tipoTarifa = '" + tipoTarifa + '\'' + 
			",listaTransfers = '" + listaTransfers + '\'' + 
			",cadenaValidacionComb = '" + cadenaValidacionComb + '\'' + 
			",estmin = '" + estmin + '\'' + 
			",hotelObjetotarifa = '" + hotelObjetotarifa + '\'' + 
			",precioSinImpuestos = '" + precioSinImpuestos + '\'' + 
			",codigoDivisa = '" + codigoDivisa + '\'' + 
			",precioSinPuntos = '" + precioSinPuntos + '\'' + 
			",disponibilidad = '" + disponibilidad + '\'' + 
			",listaHabitaciones = '" + listaHabitaciones + '\'' + 
			",precioTransfer = '" + precioTransfer + '\'' + 
			",puntosHabitacion = '" + puntosHabitacion + '\'' + 
			",version1 = '" + version1 + '\'' + 
			",listaResortCreditsAddedValues = '" + listaResortCreditsAddedValues + '\'' + 
			",switaxinl = '" + switaxinl + '\'' + 
			"}";
		}
}