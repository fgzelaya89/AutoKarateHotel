package model.responseSOAP;

import java.util.ArrayList;
import java.util.List;

public class ListaAvail {
    private List<ValorarCombinacionesRbDto> listaAvail = new ArrayList<ValorarCombinacionesRbDto>();

    public List<ValorarCombinacionesRbDto> getListaAvail() {
        return listaAvail;
    }

    public void setListaAvail(List<ValorarCombinacionesRbDto> listaAvail) {
        this.listaAvail = listaAvail;
    }

    public void addListaAvail(ValorarCombinacionesRbDto valorarCombinacionesRbDto) {
        this.listaAvail.add(valorarCombinacionesRbDto);
    }

    @Override
    public String toString() {
        return "listaAvail{" +
                "listaAvail=" + listaAvail +
                '}';
    }
}
