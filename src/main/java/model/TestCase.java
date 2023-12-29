package model;

public class TestCase {
    private int numCaso;
    private NumeroTexto numeroTexto;

    public TestCase(int numCaso, NumeroTexto numeroTexto) {
        this.numCaso = numCaso;
        this.numeroTexto = numeroTexto;
    }

    public int getNumCaso() {
        return numCaso;
    }

    public NumeroTexto getNumeroTexto() {
        return numeroTexto;
    }

    @Override
    public String toString() {
        return "TestCase{" +
                "numCaso=" + numCaso +
                ", numeroTexto=" + numeroTexto +
                '}';
    }
}
