package model.responseSOAP;

public class HabitacionesValCombinacionesDto {
    private String codtha, codtre, edades, flagCompararOcupacionEnEquals, gratuidades, numHab, numad, numbb, numni,precio,precioSinImpuestos;
    //Pendientes
    //<edades/>
    //<gratuidades/>
    //<listaPeriodosPrecio xsi:nil="true"/> preguntar


    public HabitacionesValCombinacionesDto() {
    }

    public void setCodtha(String codtha) {
        this.codtha = codtha;
    }

    public void setCodtre(String codtre) {
        this.codtre = codtre;
    }

    public void setEdades(String edades) {
        this.edades = edades;
    }

    public void setFlagCompararOcupacionEnEquals(String flagCompararOcupacionEnEquals) {
        this.flagCompararOcupacionEnEquals = flagCompararOcupacionEnEquals;
    }

    public void setGratuidades(String gratuidades) {
        this.gratuidades = gratuidades;
    }

    public void setNumHab(String numHab) {
        this.numHab = numHab;
    }

    public void setNumad(String numad) {
        this.numad = numad;
    }

    public void setNumbb(String numbb) {
        this.numbb = numbb;
    }

    public void setNumni(String numni) {
        this.numni = numni;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void setPrecioSinImpuestos(String precioSinImpuestos) {
        this.precioSinImpuestos = precioSinImpuestos;
    }

    public String getCodtha() {
        return codtha;
    }

    public String getCodtre() {
        return codtre;
    }

    public String getEdades() {
        return edades;
    }

    public String getFlagCompararOcupacionEnEquals() {
        return flagCompararOcupacionEnEquals;
    }

    public String getGratuidades() {
        return gratuidades;
    }

    public String getNumHab() {
        return numHab;
    }

    public String getNumad() {
        return numad;
    }

    public String getNumbb() {
        return numbb;
    }

    public String getNumni() {
        return numni;
    }

    public String getPrecio() {
        return precio;
    }

    public String getPrecioSinImpuestos() {
        return precioSinImpuestos;
    }

    @Override
    public String toString() {
        return "HabitacionesValCombinacionesDto{" +
                "codtha='" + codtha + '\'' +
                ", codtre='" + codtre + '\'' +
                ", edades='" + edades + '\'' +
                ", flagCompararOcupacionEnEquals='" + flagCompararOcupacionEnEquals + '\'' +
                ", gratuidades='" + gratuidades + '\'' +
                ", numHab='" + numHab + '\'' +
                ", numad='" + numad + '\'' +
                ", numbb='" + numbb + '\'' +
                ", numni='" + numni + '\'' +
                ", precio='" + precio + '\'' +
                ", precioSinImpuestos='" + precioSinImpuestos + '\'' +
                '}';
    }
}
