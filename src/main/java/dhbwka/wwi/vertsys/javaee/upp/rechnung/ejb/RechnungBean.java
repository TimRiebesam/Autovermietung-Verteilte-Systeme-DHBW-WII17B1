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

package dhbwka.wwi.vertsys.javaee.upp.rechnung.ejb;

import dhbwka.wwi.vertsys.javaee.upp.common.ejb.EntityBean;
import dhbwka.wwi.vertsys.javaee.upp.rechnung.jpa.Rechnung;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

/**
 *
 * @author Marcel Jakob
 */

@Stateless
@RolesAllowed("app-user")
public class RechnungBean extends EntityBean<Rechnung, Long> {
    
    public RechnungBean() {
        super(Rechnung.class);
    }
    
    public List<Rechnung> getAllRechnungen(){
        return em.createQuery("SELECT r FROM Rechnung r").getResultList();
    }
    
    public Rechnung getRechnung(long id){
        return  em.find(Rechnung.class, id);
    }
    
    public Rechnung saveRechnung(Rechnung rechnung){
        em.persist(rechnung);
        return em.merge(rechnung);
    }
    
    public Rechnung updateRechnung(Rechnung rechnung){
        return em.merge(rechnung);
    }
    
    public void deleteRechnung(Rechnung rechnung){
        em.remove(rechnung);
    }
    
}
