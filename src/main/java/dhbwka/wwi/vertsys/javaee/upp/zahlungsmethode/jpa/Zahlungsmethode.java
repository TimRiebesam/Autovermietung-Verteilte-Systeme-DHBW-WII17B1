
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

package dhbwka.wwi.vertsys.javaee.upp.zahlungsmethode.jpa;

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
@Table(name = "UPP_Zahlungsmethode")
public class Zahlungsmethode implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "zahlungsmethode_ids")
    @TableGenerator(name = "zahlungsmethode_ids", initialValue = 0, allocationSize = 50)
    private long id;
    
//    @OneToOne
//    @NotNull(message = "Zu einer Zahlungsmethode wird ein Kunde benötigt.")
//    private Kunde kunde;
    
    @Lob
    
    private String kundeId;
    
    private String kreditkartenNummer;
    
    private String kreditkartenDatum;
    
    private String paypalEmail;
    
    private String iban;
    
    private String bic;
    
    public Zahlungsmethode(){
        
    }

    public Zahlungsmethode(String kundeId, String kreditkartenNummer, String kreditkartenDatum, String paypalEmail, String iban, String bic) {
        this.kundeId = kundeId;
        this.kreditkartenNummer = kreditkartenNummer;
        this.kreditkartenDatum = kreditkartenDatum;
        this.paypalEmail = paypalEmail;
        this.iban = iban;
        this.bic = bic;
    }
    
   
    public long getId() {
        return id;
    }

    public String getKundeId() {
        return kundeId;
    }

    public void setKundeId(String kundeId) {
        this.kundeId = kundeId;
    }

    public String getKreditkartenNummer() {
        return kreditkartenNummer;
    }

    public void setKreditkartenNummer(String kreditkartenNummer) {
        this.kreditkartenNummer = kreditkartenNummer;
    }

    public String getKreditkartenDatum() {
        return kreditkartenDatum;
    }

    public void setKreditkartenDatum(String kreditkartenDatum) {
        this.kreditkartenDatum = kreditkartenDatum;
    }

    public String getPaypalEmail() {
        return paypalEmail;
    }

    public void setPaypalEmail(String paypalEmail) {
        this.paypalEmail = paypalEmail;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

   
    
}
