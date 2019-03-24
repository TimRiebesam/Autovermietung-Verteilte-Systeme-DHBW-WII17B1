
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

package dhbwka.wwi.vertsys.javaee.upp.buchung.jpa;

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
 * @author Marcel Jakob
 */
@Entity
@Table(name = "UPP_Buchung")
public class Buchung implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "buchung_ids")
    @TableGenerator(name = "buchung_ids", initialValue = 0, allocationSize = 50)
    private long id;
    
//    @OneToOne
//    @NotNull(message = "Zu einer Buchung wird ein Fahrzeug und Kunde benötigt.")
//    private Fahrzeug fahrzeug;
//    private Kunde kunde;
    
    @Lob
    private String buchungNr;
    
    private Date startDatum;
    
    private Date endDatum;
    
    private int buchungPreis;
    
    private String buchungAbholort;
    
    
    public Buchung(){
        
    }
    
    public Buchung(String buchungNr, Date startDatum, Date endDatum, int buchungPreis, String buchungAbholort){
        this.buchungNr = buchungNr;
        this.startDatum = new Date();
        this.endDatum = new Date();
        this.buchungPreis = buchungPreis;
        this.buchungAbholort = buchungAbholort;
    }

    public long getId() {
        return id;
    }

    public String getBuchungNr() {
        return buchungNr;
    }

    public void setBuchungNr(String buchungNr) {
        this.buchungNr = buchungNr;
    }

    public Date getStartDatum() {
        return startDatum;
    }

    public void setStartDatum(Date startDatum) {
        this.startDatum = startDatum;
    }

    public Date getEndDatum() {
        return endDatum;
    }

    public void setEndDatum(Date endDatum) {
        this.endDatum = endDatum;
    }

    public int getBuchungPreis() {
        return buchungPreis;
    }

    public void setBuchungPreis(int buchungPreis) {
        this.buchungPreis = buchungPreis;
    }

    public String getBuchungAbholort() {
        return buchungAbholort;
    }

    public void setBuchungAbholort(String buchungAbholort) {
        this.buchungAbholort = buchungAbholort;
    }
    
}
