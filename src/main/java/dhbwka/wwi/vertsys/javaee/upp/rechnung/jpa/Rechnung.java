
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

package dhbwka.wwi.vertsys.javaee.upp.rechnung.jpa;

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
@Table(name = "UPP_Rechnung")
public class Rechnung implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "rechnung_ids")
    @TableGenerator(name = "rechnung_ids", initialValue = 0, allocationSize = 50)
    private long id;
    
//    @OneToOne
//    @NotNull(message = "Zu einer Rechnung wird eine Buchung/Kunde/Fahrzeug/Zahlungsmethode benötigt.")
//    private Buchung buchung;
//    private Kunde kunde;
//    private Fahrzeug fahrzeug;
//    private Zahlungsmethode zahlungsmethode;
    
    @Lob
    private String buchungId;
    
    private String kundeId;
    
    private String fahrzeugId;
    
    private String zahlungsmethodeId;
    
    public Rechnung(){
        
    }
    
    public Rechnung(String buchungId, String kundeId, String fahrzeugId, String zahlungsmethode){
        this.buchungId = buchungId;
        this.kundeId = kundeId;
        this.fahrzeugId = fahrzeugId;
        this.zahlungsmethodeId = zahlungsmethode;

    }

    public long getId() {
        return id;
    }

    public String getBuchungId() {
        return buchungId;
    }

    public void setBuchungId(String buchungId) {
        this.buchungId = buchungId;
    }

    public String getKundeId() {
        return kundeId;
    }

    public void setKundeId(String kundeId) {
        this.kundeId = kundeId;
    }

    public String getFahrzeugId() {
        return fahrzeugId;
    }

    public void setFahrzeugId(String fahrzeugId) {
        this.fahrzeugId = fahrzeugId;
    }

    public String getZahlungsmethodeId() {
        return zahlungsmethodeId;
    }

    public void setZahlungsmethodeId(String zahlungsmethodeId) {
        this.zahlungsmethodeId = zahlungsmethodeId;
    }

    
    
}
