
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

package dhbwka.wwi.vertsys.javaee.upp.rueckgabe.jpa;

import dhbwka.wwi.vertsys.javaee.upp.buchung.jpa.Buchung;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;

/**
 *
 * @author TimRiebesam
 */
@Entity
@Table(name = "UPP_Rueckgabe")
public class Rueckgabe implements Serializable{
    
    //private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "rueckgabe_ids")
    @TableGenerator(name = "rueckgabe_ids", initialValue = 0, allocationSize = 50)
    private long id;
    
    @OneToOne
    @NotNull(message = "Zu einer Rückgabe wird ein Auftrag benötigt.")
    private Buchung buchung;
    
    @Lob
    private String schadensMeldung;
    
    private Date rueckgabeDatum; 
    
    private String rueckgabeOrt;
    
    private int gesamtZufriedenheit;
    
    private int fahrzeugZufriedenheit;
    
    @Lob
    private String kommentar;
    
    public Rueckgabe(){
        
    }
    
    public Rueckgabe(String schadensMeldung, String rueckgabeOrt, int gesamtZufriedenheit, int fahrzeugZufriedenheit, String kommentar){
        this.schadensMeldung = schadensMeldung;
        this.rueckgabeDatum = new Date();
        this.rueckgabeOrt = rueckgabeOrt;
        this.gesamtZufriedenheit = gesamtZufriedenheit;
        this.fahrzeugZufriedenheit = fahrzeugZufriedenheit;
        this.kommentar = kommentar;
    }

    public long getId() {
        return id;
    }
    
    public Buchung getBuchung(){
        return buchung;
    }
    
    public void setBuchung(Buchung buchung){
        this.buchung = buchung;
    }

    public String getSchadensMeldung() {
        return schadensMeldung;
    }

    public void setSchadensMeldung(String schadensMeldung) {
        this.schadensMeldung = schadensMeldung;
    }

    public Date getRueckgabeDatum() {
        return rueckgabeDatum;
    }

    public void setRueckgabeDatum(Date rueckgabeDatum) {
        this.rueckgabeDatum = rueckgabeDatum;
    }

    public String getRueckgabeOrt() {
        return rueckgabeOrt;
    }

    public void setRueckgabeOrt(String rueckgabeOrt) {
        this.rueckgabeOrt = rueckgabeOrt;
    }

    public int getGesamtZufriedenheit() {
        return gesamtZufriedenheit;
    }

    public void setGesamtZufriedenheit(int gesamtZufriedenheit) {
        this.gesamtZufriedenheit = gesamtZufriedenheit;
    }

    public int getFahrzeugZufriedenheit() {
        return fahrzeugZufriedenheit;
    }

    public void setFahrzeugZufriedenheit(int fahrzeugZufriedenheit) {
        this.fahrzeugZufriedenheit = fahrzeugZufriedenheit;
    }
    
    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }
}
