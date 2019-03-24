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

package dhbwka.wwi.vertsys.javaee.upp.buchung.ejb;

import dhbwka.wwi.vertsys.javaee.upp.common.ejb.EntityBean;
import dhbwka.wwi.vertsys.javaee.upp.buchung.jpa.Buchung;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

/**
 *
 * @author Marcel Jaokb
 */

@Stateless
@RolesAllowed("app-user")
public class BuchungBean extends EntityBean<Buchung, Long> {
    
    public BuchungBean() {
        super(Buchung.class);
    }
    
    public List<Buchung> getAllBuchungen(){
        return em.createQuery("SELECT r FROM Buchung r").getResultList();
    }
    
    public Buchung getBuchung(long id){
        return  em.find(Buchung.class, id);
    }
    
    public Buchung saveBuchung(Buchung buchung){
        em.persist(buchung);
        return em.merge(buchung);
    }
    
    public Buchung updateBuchung(Buchung buchung){
        return em.merge(buchung);
    }
    
    public void deleteBuchung(Buchung buchung){
        em.remove(buchung);
    }
    
}
