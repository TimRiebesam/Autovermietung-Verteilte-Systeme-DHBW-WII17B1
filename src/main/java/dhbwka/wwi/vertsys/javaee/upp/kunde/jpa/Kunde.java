
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

package dhbwka.wwi.vertsys.javaee.upp.kunde.jpa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * 
 * @author RaphaelMenken
 *
 */
@Entity
@Table(name = "UPP_Kunde")
public class Kunde implements Serializable{
	
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "kunde_kundenNr")
    @TableGenerator(name = "kunde_kundenNr", initialValue = 0, allocationSize = 50)
    private Long kundenNr;

    private String name = "";
    private String vorname;
    private int alter;
    private String wohnort;
    private int telefonNr;
    private String eMail;
    private int zahlungsId;

    public Kunde() {
    }

    public Kunde(String name) {
        this.name = name;
    }

    public Long getKundenNr() {
        return kundenNr;
    }

    public void setKundenNr(Long id) {
        this.kundenNr = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    
    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }
    
    public String getWohnort() {
        return wohnort;
    }

    public void setWohnort(String wohnort) {
        this.wohnort = wohnort;
    }
    
    public int getTelefonNr() {
        return telefonNr;
    }

    public void setTelefonNr(int telefonNr) {
        this.telefonNr = telefonNr;
    }
    
    public String getEmail() {
        return eMail;
    }

    public void setEmail(String eMail) {
        this.eMail = eMail;
    }
    
    public int getZahlungsId() {
        return zahlungsId;
    }

    public void setZahlungsId(int zahlungsId) {
        this.zahlungsId = zahlungsId;
    }
}
