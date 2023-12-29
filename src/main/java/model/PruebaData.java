package model;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PruebaData {
    private String idPrueba = null;
    private String ambito = null;
    private String codPai = null;
    private String usuario = null;
    private String puntosGastar = null;
    private String promocode = null;
    private String ideHot = null;
    private String nomHot = null;
    private String fecEmi = null;
    private String fecLle = null;
    private String fecSal = null;
    private String numHab = null;
    private String codTha1 = null;
    private String codTha2 = null;
    private String codTha3 = null;
    private String numAdu1 = null;
    private String numNin1 = null;
    private String numAdu2 = null;
    private String numNin2 = null;
    private String numAdu3 = null;
    private String numNin3 = null;
    private String codTre = null;
    private String importeActHa1 = null;
    private String importeActHa2 = null;
    private String importeActHa3 = null;
    private String importeTotAct = null;
    private String codDivAct = null;
    private String puntosAct = null;
    private String importeBeHa1 = null;
    private String importeBeHa2 = null;
    private String importeBeHa3 = null;
    private String importeTotBe = null;
    private String codDivBe = null;
    private String puntosBe = null;
    private String creationDate = null;
    private String lastUpdateDate = null;
    private String obs = null;

    public PruebaData() {
    }

    public String getIdPrueba() {
        return idPrueba;
    }

    public int IdPrueba() {
        return Integer.parseInt(getIdPrueba().split("\\.")[0]);
    }

    public void setIdPrueba(String idPrueba) {
        this.idPrueba = idPrueba;
    }

    public String Ambito() {
        switch (getAmbito()) {
            case "DIR":
                return "DIRECTO";

            case "opcion2":
                return "Valor para Opción 2";

            case "opcion3":
                return "Valor para Opción 3";

            default:
                return "No Parametrizado";
        }
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public String getCodPai() {
        return codPai;
    }

    public void setCodPai(String codPai) {
        this.codPai = codPai;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPuntosGastar() {
        return puntosGastar;
    }

    public void setPuntosGastar(String puntosGastar) {
        this.puntosGastar = puntosGastar;
    }

    public String getPromocode() {
        return promocode;
    }

    public void setPromocode(String promocode) {
        this.promocode = promocode;
    }

    public String getIdeHot() {
        return ideHot;
    }

    public void setIdeHot(String ideHot) {
        this.ideHot = ideHot;
    }

    public String getNomHot() {
        return nomHot;
    }

    public void setNomHot(String nomHot) {
        this.nomHot = nomHot;
    }

    public String getFecEmi() {
        return fecEmi;
    }

    public void setFecEmi(String fecEmi) {
        this.fecEmi = fecEmi;
    }

    public String getFecLle() {
        return fecLle;
    }

    public void setFecLle(String fecLle) {
        this.fecLle = fecLle;
    }

    public String getFecSal() {
        return fecSal;
    }

    public void setFecSal(String fecSal) {
        this.fecSal = fecSal;
    }

    public String getNumHab() {
        return numHab;
    }

    public void setNumHab(String numHab) {
        this.numHab = numHab;
    }

    public String getCodTha1() {
        return codTha1;
    }

    public void setCodTha1(String codTha1) {
        this.codTha1 = codTha1;
    }

    public String getCodTha2() {
        return codTha2;
    }

    public void setCodTha2(String codTha2) {
        this.codTha2 = codTha2;
    }

    public String getCodTha3() {
        return codTha3;
    }

    public void setCodTha3(String codTha3) {
        this.codTha3 = codTha3;
    }

    public String getNumAdu1() {
        return numAdu1;
    }

    public void setNumAdu1(String numAdu1) {
        this.numAdu1 = numAdu1;
    }

    public String getNumNin1() {
        return numNin1;
    }

    public void setNumNin1(String numNin1) {
        this.numNin1 = numNin1;
    }

    public String getNumAdu2() {
        return numAdu2;
    }

    public void setNumAdu2(String numAdu2) {
        this.numAdu2 = numAdu2;
    }

    public String getNumNin2() {
        return numNin2;
    }

    public void setNumNin2(String numNin2) {
        this.numNin2 = numNin2;
    }

    public String getNumAdu3() {
        return numAdu3;
    }

    public void setNumAdu3(String numAdu3) {
        this.numAdu3 = numAdu3;
    }

    public String getNumNin3() {
        return numNin3;
    }

    public void setNumNin3(String numNin3) {
        this.numNin3 = numNin3;
    }

    public String getCodTre() {
        return codTre;
    }

    public void setCodTre(String codTre) {
        this.codTre = codTre;
    }

    public String getImporteActHa1() {
        return importeActHa1;
    }

    public void setImporteActHa1(String importeActHa1) {
        this.importeActHa1 = importeActHa1;
    }

    public String getImporteActHa2() {
        return importeActHa2;
    }

    public void setImporteActHa2(String importeActHa2) {
        this.importeActHa2 = importeActHa2;
    }

    public String getImporteActHa3() {
        return importeActHa3;
    }

    public void setImporteActHa3(String importeActHa3) {
        this.importeActHa3 = importeActHa3;
    }

    public String getImporteTotAct() {
        return importeTotAct;
    }

    public void setImporteTotAct(String importeTotAct) {
        this.importeTotAct = importeTotAct;
    }

    public String getCodDivAct() {
        return codDivAct;
    }

    public void setCodDivAct(String codDivAct) {
        this.codDivAct = codDivAct;
    }

    public String getPuntosAct() {
        return puntosAct;
    }

    public void setPuntosAct(String puntosAct) {
        this.puntosAct = puntosAct;
    }

    public String getImporteBeHa1() {
        return importeBeHa1;
    }

    public void setImporteBeHa1(String importeBeHa1) {
        this.importeBeHa1 = importeBeHa1;
    }

    public String getImporteBeHa2() {
        return importeBeHa2;
    }

    public void setImporteBeHa2(String importeBeHa2) {
        this.importeBeHa2 = importeBeHa2;
    }

    public String getImporteBeHa3() {
        return importeBeHa3;
    }

    public void setImporteBeHa3(String importeBeHa3) {
        this.importeBeHa3 = importeBeHa3;
    }

    public String getImporteTotBe() {
        return importeTotBe;
    }

    public void setImporteTotBe(String importeTotBe) {
        this.importeTotBe = importeTotBe;
    }

    public String getCodDivBe() {
        return codDivBe;
    }

    public void setCodDivBe(String codDivBe) {
        this.codDivBe = codDivBe;
    }

    public String getPuntosBe() {
        return puntosBe;
    }

    public void setPuntosBe(String puntosBe) {
        this.puntosBe = puntosBe;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    @Override
    public String toString() {
        return "PruebaData{" +
                "idPrueba='" + idPrueba + '\'' +
                ", ambito='" + ambito + '\'' +
                ", codPai='" + codPai + '\'' +
                ", usuario='" + usuario + '\'' +
                ", puntosGastar='" + puntosGastar + '\'' +
                ", promocode='" + promocode + '\'' +
                ", ideHot='" + ideHot + '\'' +
                ", nomHot='" + nomHot + '\'' +
                ", fecEmi='" + fecEmi + '\'' +
                ", fecLle='" + fecLle + '\'' +
                ", fecSal='" + fecSal + '\'' +
                ", numHab='" + numHab + '\'' +
                ", codTha1='" + codTha1 + '\'' +
                ", codTha2='" + codTha2 + '\'' +
                ", codTha3='" + codTha3 + '\'' +
                ", numAdu1='" + numAdu1 + '\'' +
                ", numNin1='" + numNin1 + '\'' +
                ", numAdu2='" + numAdu2 + '\'' +
                ", numNin2='" + numNin2 + '\'' +
                ", numAdu3='" + numAdu3 + '\'' +
                ", numNin3='" + numNin3 + '\'' +
                ", codTre='" + codTre + '\'' +
                ", importeActHa1='" + importeActHa1 + '\'' +
                ", importeActHa2='" + importeActHa2 + '\'' +
                ", importeActHa3='" + importeActHa3 + '\'' +
                ", importeTotAct='" + importeTotAct + '\'' +
                ", codDivAct='" + codDivAct + '\'' +
                ", puntosAct='" + puntosAct + '\'' +
                ", importeBeHa1='" + importeBeHa1 + '\'' +
                ", importeBeHa2='" + importeBeHa2 + '\'' +
                ", importeBeHa3='" + importeBeHa3 + '\'' +
                ", importeTotBe='" + importeTotBe + '\'' +
                ", codDivBe='" + codDivBe + '\'' +
                ", puntosBe='" + puntosBe + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", lastUpdateDate='" + lastUpdateDate + '\'' +
                ", obs='" + obs + '\'' +
                '}';
    }

    public static PruebaData getPruebaDataRowExcel(Row row) throws ParseException {

            String c = fechaEnFormatoCorrecto(row.getCell(8));
        PruebaData pruebaData = new PruebaData();
        pruebaData.setIdPrueba(row.getCell(0).toString());
        pruebaData.setAmbito(row.getCell(1).toString());
        pruebaData.setCodPai(row.getCell(2).toString());
        pruebaData.setUsuario(row.getCell(3).toString());
        pruebaData.setPuntosGastar(row.getCell(4).toString());
        pruebaData.setPromocode(row.getCell(5).toString());
        pruebaData.setIdeHot(row.getCell(6).toString());
        pruebaData.setNomHot(row.getCell(7).toString());

        //Fechas
        pruebaData.setFecEmi(fechaEnFormatoCorrecto(row.getCell(8)));
        pruebaData.setFecLle(fechaEnFormatoCorrecto(row.getCell(9)));
        pruebaData.setFecSal(fechaEnFormatoCorrecto(row.getCell(10)));


        pruebaData.setNumHab(row.getCell(11).toString());
        pruebaData.setCodTha1(row.getCell(12).toString());
        pruebaData.setCodTha2(row.getCell(13).toString());
        pruebaData.setCodTha3(row.getCell(14).toString());
        pruebaData.setNumAdu1(row.getCell(15).toString());
        pruebaData.setNumNin1(row.getCell(16).toString());
        pruebaData.setNumAdu2(row.getCell(17).toString());
        pruebaData.setNumNin2(row.getCell(18).toString());
        pruebaData.setNumAdu3(row.getCell(19).toString());
        pruebaData.setNumNin3(row.getCell(20).toString());
        pruebaData.setCodTre(row.getCell(21).toString());
        pruebaData.setImporteActHa1(row.getCell(22).toString());
        pruebaData.setImporteActHa2(row.getCell(23).toString());
        pruebaData.setImporteActHa3(row.getCell(24).toString());
        pruebaData.setImporteTotAct(row.getCell(25).toString());
        pruebaData.setCodDivAct(row.getCell(26).toString());
        pruebaData.setPuntosAct(row.getCell(27).toString());
        pruebaData.setImporteBeHa1(row.getCell(28).toString());
        pruebaData.setImporteBeHa2(row.getCell(29).toString());
        pruebaData.setImporteBeHa3(row.getCell(30).toString());
        pruebaData.setImporteTotBe(row.getCell(31).toString());
        pruebaData.setCodDivBe(row.getCell(32).toString());
        pruebaData.setPuntosBe(row.getCell(33).toString());
        //Fechas (fechaEnFormatoCorrecto(row.getCell(8)))
        //pruebaData.setCreationDate(row.getCell(34).toString());
        pruebaData.setCreationDate(fechaEnFormatoCorrecto(row.getCell(34)));
        pruebaData.setLastUpdateDate(fechaEnFormatoCorrecto(row.getCell(35)));

        pruebaData.setObs(row.getCell(36).toString());


        return pruebaData;
    }

    public static String fechaEnFormatoCorrecto(Cell c){
        DataFormatter dataFormatter = new DataFormatter();
        String fechaEnFormatoCorrecto = dataFormatter.formatCellValue(c); // cell es la celda que contiene la fecha
        return fechaEnFormatoCorrecto;
    }


}
