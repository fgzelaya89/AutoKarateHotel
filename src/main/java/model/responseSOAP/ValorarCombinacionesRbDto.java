package model.responseSOAP;

import java.util.ArrayList;
import java.util.List;

public class ValorarCombinacionesRbDto {
    //LMensajesAvail pendiente es una lista
    private String ambito;
    private String cadenaValidacionComb;
    private String codigoDivisa;
    //descuentoPuntosGeneradoDto pendiente es una lista
    private String disponibilidad;
    private String estmin;
    private String hotel;
    private String hotel_tarifa;
    private String id;
    //listaDesglose pendiente es una lista
    private List<HabitacionesValCombinacionesDto> listaHabitaciones = new ArrayList<HabitacionesValCombinacionesDto>();
    // <listaMultiCurrency xsi:nil="true"/>
    //<listaResortCreditsAddedValues xsi:nil="true"/>
    //<listaTransfers xsi:nil="true"/>
    private String lmotivo;
    private String paradaventa;
    private String precio;
    private String precioAnterior;
    private String precioAnteriorSinImpuestos;
    private String precioSinImpuestos;
    private String precioSinPuntos;
    private String precioTransfer;
    private String precioTransferSinImpuestos;
    private String puntosHabitacion;
    private String release;
    private String switaxinl;
    //<tipTransfer xsi:nil="true"/>
    private String tipoCombinacion;
    private String tipoTarifa;
    //translationTHabs pendiente es una lista
    private String version1;

    public ValorarCombinacionesRbDto() {
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public void setCadenaValidacionComb(String cadenaValidacionComb) {
        this.cadenaValidacionComb = cadenaValidacionComb;
    }

    public void setCodigoDivisa(String codigoDivisa) {
        this.codigoDivisa = codigoDivisa;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public void setEstmin(String estmin) {
        this.estmin = estmin;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public void setHotel_tarifa(String hotel_tarifa) {
        this.hotel_tarifa = hotel_tarifa;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setListaHabitaciones(List<HabitacionesValCombinacionesDto> listaHabitaciones) {
        this.listaHabitaciones = listaHabitaciones;
    }

    public void addListaHabitaciones(HabitacionesValCombinacionesDto habitacionesValCombinacionesDto) {
        this.listaHabitaciones.add(habitacionesValCombinacionesDto);
    }

    public void setLmotivo(String lmotivo) {
        this.lmotivo = lmotivo;
    }

    public void setParadaventa(String paradaventa) {
        this.paradaventa = paradaventa;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void setPrecioAnterior(String precioAnterior) {
        this.precioAnterior = precioAnterior;
    }

    public void setPrecioAnteriorSinImpuestos(String precioAnteriorSinImpuestos) {
        this.precioAnteriorSinImpuestos = precioAnteriorSinImpuestos;
    }

    public void setPrecioSinImpuestos(String precioSinImpuestos) {
        this.precioSinImpuestos = precioSinImpuestos;
    }

    public void setPrecioSinPuntos(String precioSinPuntos) {
        this.precioSinPuntos = precioSinPuntos;
    }

    public void setPrecioTransfer(String precioTransfer) {
        this.precioTransfer = precioTransfer;
    }

    public void setPrecioTransferSinImpuestos(String precioTransferSinImpuestos) {
        this.precioTransferSinImpuestos = precioTransferSinImpuestos;
    }

    public void setPuntosHabitacion(String puntosHabitacion) {
        this.puntosHabitacion = puntosHabitacion;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public void setSwitaxinl(String switaxinl) {
        this.switaxinl = switaxinl;
    }

    public void setTipoCombinacion(String tipoCombinacion) {
        this.tipoCombinacion = tipoCombinacion;
    }

    public void setTipoTarifa(String tipoTarifa) {
        this.tipoTarifa = tipoTarifa;
    }

    public void setVersion1(String version1) {
        this.version1 = version1;
    }

    public String getAmbito() {
        return ambito;
    }

    public String getCadenaValidacionComb() {
        return cadenaValidacionComb;
    }

    public String getCodigoDivisa() {
        return codigoDivisa;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public String getEstmin() {
        return estmin;
    }

    public String getHotel() {
        return hotel;
    }

    public String getHotel_tarifa() {
        return hotel_tarifa;
    }

    public String getId() {
        return id;
    }

    public List<HabitacionesValCombinacionesDto> getListaHabitaciones() {
        return listaHabitaciones;
    }

    public String getLmotivo() {
        return lmotivo;
    }

    public String getParadaventa() {
        return paradaventa;
    }

    public String getPrecio() {
        return precio;
    }

    public String getPrecioAnterior() {
        return precioAnterior;
    }

    public String getPrecioAnteriorSinImpuestos() {
        return precioAnteriorSinImpuestos;
    }

    public String getPrecioSinImpuestos() {
        return precioSinImpuestos;
    }

    public String getPrecioSinPuntos() {
        return precioSinPuntos;
    }

    public String getPrecioTransfer() {
        return precioTransfer;
    }

    public String getPrecioTransferSinImpuestos() {
        return precioTransferSinImpuestos;
    }

    public String getPuntosHabitacion() {
        return puntosHabitacion;
    }

    public String getRelease() {
        return release;
    }

    public String getSwitaxinl() {
        return switaxinl;
    }

    public String getTipoCombinacion() {
        return tipoCombinacion;
    }

    public String getTipoTarifa() {
        return tipoTarifa;
    }

    public String getVersion1() {
        return version1;
    }

    @Override
    public String toString() {
        return "ValorarCombinacionesRbDto{" +
                "ambito='" + ambito + '\'' +
                ", cadenaValidacionComb='" + cadenaValidacionComb + '\'' +
                ", codigoDivisa='" + codigoDivisa + '\'' +
                ", disponibilidad='" + disponibilidad + '\'' +
                ", estmin='" + estmin + '\'' +
                ", hotel='" + hotel + '\'' +
                ", hotel_tarifa='" + hotel_tarifa + '\'' +
                ", id='" + id + '\'' +
                ", listaHabitaciones=" + listaHabitaciones +
                ", lmotivo='" + lmotivo + '\'' +
                ", paradaventa='" + paradaventa + '\'' +
                ", precio='" + precio + '\'' +
                ", precioAnterior='" + precioAnterior + '\'' +
                ", precioAnteriorSinImpuestos='" + precioAnteriorSinImpuestos + '\'' +
                ", precioSinImpuestos='" + precioSinImpuestos + '\'' +
                ", precioSinPuntos='" + precioSinPuntos + '\'' +
                ", precioTransfer='" + precioTransfer + '\'' +
                ", precioTransferSinImpuestos='" + precioTransferSinImpuestos + '\'' +
                ", puntosHabitacion='" + puntosHabitacion + '\'' +
                ", release='" + release + '\'' +
                ", switaxinl='" + switaxinl + '\'' +
                ", tipoCombinacion='" + tipoCombinacion + '\'' +
                ", tipoTarifa='" + tipoTarifa + '\'' +
                ", version1='" + version1 + '\'' +
                '}';
    }


}
