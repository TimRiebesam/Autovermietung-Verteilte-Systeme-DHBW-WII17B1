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

package dhbwka.wwi.vertsys.javaee.upp.auto.ejb;

import dhbwka.wwi.vertsys.javaee.upp.auto.jpa.Auto;
import dhbwka.wwi.vertsys.javaee.upp.common.ejb.EntityBean;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Nicolas
 */
@Stateless
@RolesAllowed("app-user")

public class AutoBean extends EntityBean<Auto, Long> {
    
    @PersistenceContext
    protected EntityManager em;
    
    
    public AutoBean(){
        super(Auto.class);
    }
    
    public List<Auto> getAllAutos() {
        return em.createQuery("SELECT r FROM Auto r").getResultList();
    }
    
    public Auto getAuto(long id) {
        return em.find(Auto.class, id);
    }
    
    public List<Auto> getAutoByTyp (String typ){
        return em.createQuery("SELECT r FROM Auto r"
        + " WHERE r.typ LIKE :typ").setParameter("typ", typ).getResultList();
    }
    
    public Auto saveAuto(Auto auto){
        em.persist(auto);
        return em.merge(auto);
    }

    public Auto updateAuto(Auto auto){
        return em.merge(auto);
    }
    
    public void deleteAuto(Auto auto){
         em.remove(auto);
    }
    
 
}
