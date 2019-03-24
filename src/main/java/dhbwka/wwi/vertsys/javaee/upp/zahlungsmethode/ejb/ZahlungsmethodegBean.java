/**
 * Copyright © 2019
 *  Marcel Jakob
 *  Nicolas Neuhof
 *  Raphael Menken
 *  Tim Riebesam
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */

package dhbwka.wwi.vertsys.javaee.upp.zahlungsmethode.ejb;

import dhbwka.wwi.vertsys.javaee.upp.common.ejb.EntityBean;
import dhbwka.wwi.vertsys.javaee.upp.zahlungsmethode.jpa.Zahlungsmethode;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

/**
 *
 * @author Marcel Jakob
 */

@Stateless
@RolesAllowed("app-user")
public class ZahlungsmethodegBean extends EntityBean<Zahlungsmethode, Long> {
    
    public ZahlungsmethodegBean() {
        super(Zahlungsmethode.class);
    }
    
    public List<Zahlungsmethode> getAllZahlungsmethode(){
        return em.createQuery("SELECT r FROM Zahlungsmethode r").getResultList();
    }
    
    public Zahlungsmethode getZahlungsmethode(long id){
        return  em.find(Zahlungsmethode.class, id);
    }
    
    public Zahlungsmethode saveZahlungsmethode(Zahlungsmethode zahlungsmethode){
        em.persist(zahlungsmethode);
        return em.merge(zahlungsmethode);
    }
    
    public Zahlungsmethode updateZahlungsmethode(Zahlungsmethode zahlungsmethode){
        return em.merge(zahlungsmethode);
    }
    
    public void deleteZahlungsmethode(Zahlungsmethode zahlungsmethode){
        em.remove(zahlungsmethode);
    }
    
}
