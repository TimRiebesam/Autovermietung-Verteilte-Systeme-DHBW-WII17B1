
/*
 * Copyright © 2019
 *  Marcel Jakob
 *  Nicolas Neuhof
 *  Raphael Menken
 *  Tim Riebesam
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package dhbwka.wwi.vertsys.javaee.upp.auto.jpa;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Nicolas
 */
@Entity
@Table(name = "UPP_AUTO")
public class Auto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;

    private String marke;
    private String modell;
    private String groeße;
    private String typ;
    private String kraftstoff;
    private int anzahl_sitzplaetze;
    private int anzahl_tueren;
    private double kmStand;
    private String getriebetyp;
    private double preis;
    private String bildquelle;

    //Konstruktoren
    public Auto() {

    }

    public Auto(String marke, String modell, String groeße, String typ, String kraftstoff, int anzahl_sitzplaetze, int anzahl_tueren, String getriebetyp, double kmStand, double preis, String bildquelle) {
        this.marke = marke;
        this.modell = modell;
        this.groeße = groeße;
        this.typ = typ;
        this.kraftstoff = kraftstoff;
        this.anzahl_sitzplaetze = anzahl_sitzplaetze;
        this.anzahl_tueren = anzahl_tueren;
        this.getriebetyp = getriebetyp;
        this.preis = preis;
        this.bildquelle = bildquelle;
        this.kmStand = kmStand;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public String getGroeße() {
        return groeße;
    }

    public void setGroeße(String groeße) {
        this.groeße = groeße;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getKraftstoff() {
        return kraftstoff;
    }

    public void setKraftstoff(String kraftstoff) {
        this.kraftstoff = kraftstoff;
    }

    public int getAnzahl_sitzplaetze() {
        return anzahl_sitzplaetze;
    }

    public void setAnzahl_sitzplaetze(int anzahl_sitzplaetze) {
        this.anzahl_sitzplaetze = anzahl_sitzplaetze;
    }

    public int getAnzahl_tueren() {
        return anzahl_tueren;
    }

    public void setAnzahl_tueren(int anzahl_tueren) {
        this.anzahl_tueren = anzahl_tueren;
    }

    public String getGetriebetyp() {
        return getriebetyp;
    }

    public void setGetriebetyp(String getriebetyp) {
        this.getriebetyp = getriebetyp;
    }

    public double getKmStand() {
        return kmStand;
    }

    public void setKmStand(double kmStand) {
        this.kmStand = kmStand;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public String getBildquelle() {
        return bildquelle;
    }

    public void setBildquelle(String bildquelle) {
        this.bildquelle = bildquelle;
    }

}//end of class
