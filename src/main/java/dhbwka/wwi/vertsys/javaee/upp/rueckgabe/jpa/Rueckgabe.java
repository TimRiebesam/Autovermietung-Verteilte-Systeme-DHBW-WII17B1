
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

import dhbwka.wwi.vertsys.javaee.upp.common.jpa.User;
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

/**
 *
 * @author TimRiebesam
 */
@Entity
@Table(name = "UPP_Rueckgabe")
public class Rueckgabe implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "rueckgabe_ids")
    @TableGenerator(name = "rueckgabe_ids", initialValue = 0, allocationSize = 50)
    private long id;
    
//    @OneToOne
//    @NotNull(message = "Zu einer Rückgabe wird ein Auftrag benötigt.")
//    private Auftrag auftrag;
    
    @Lob
    private String schadensMeldung;
    
    private Date rueckgabeDatum;
    
    private String rueckgabeOrt;
    
    private int gesamtZufriedenheit;
    
    private int fahrzeugtZufriedenheit;
    
    public Rueckgabe(){
        
    }
    
    public Rueckgabe(String schadensMeldung, String rueckgabeOrt, int gesamtZufriedenheit, int fahrzeugtZufriedenheit){
        this.schadensMeldung = schadensMeldung;
        this.rueckgabeDatum = new Date();
        this.rueckgabeOrt = rueckgabeOrt;
        this.gesamtZufriedenheit = gesamtZufriedenheit;
        this.fahrzeugtZufriedenheit = fahrzeugtZufriedenheit;
    }

    public long getId() {
        return id;
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

    public int getFahrzeugtZufriedenheit() {
        return fahrzeugtZufriedenheit;
    }

    public void setFahrzeugtZufriedenheit(int fahrzeugtZufriedenheit) {
        this.fahrzeugtZufriedenheit = fahrzeugtZufriedenheit;
    }
    
}
