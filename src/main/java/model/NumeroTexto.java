package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NumeroTexto {
    @JsonProperty("Numero")
    private String numero;

    @JsonProperty("TextoNumero")
    private String textoNumero;

    // Constructores, getters y setters (puedes generarlos automáticamente en tu IDE)

    public String getNumero() {
        return numero;
    }

    public String getTextoNumero() {
        return textoNumero;
    }

    @Override
    public String toString() {
        return "NumeroTexto{" +
                "numero='" + numero + '\'' +
                ", textoNumero='" + textoNumero + '\'' +
                '}';
    }
}