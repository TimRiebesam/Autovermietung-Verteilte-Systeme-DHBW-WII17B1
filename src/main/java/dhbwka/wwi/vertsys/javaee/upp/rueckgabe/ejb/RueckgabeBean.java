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

package dhbwka.wwi.vertsys.javaee.upp.rueckgabe.ejb;

import dhbwka.wwi.vertsys.javaee.upp.common.ejb.EntityBean;
import dhbwka.wwi.vertsys.javaee.upp.rueckgabe.jpa.Rueckgabe;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

/**
 *
 * @author TimRiebesam
 */

@Stateless
@RolesAllowed("app-user")
public class RueckgabeBean extends EntityBean<Rueckgabe, Long> {
    
    public RueckgabeBean() {
        super(Rueckgabe.class);
    }
    
    public List<Rueckgabe> getAllRueckgaben(){
        return em.createQuery("SELECT r FROM Rueckgabe r").getResultList();
    }
    
    public Rueckgabe getRueckgabe(long id){
        return  em.find(Rueckgabe.class, id);
    }
    
    public Rueckgabe saveRueckgabe(Rueckgabe rueckgabe){
        em.persist(rueckgabe);
        return em.merge(rueckgabe);
    }
    
    public Rueckgabe updateRueckgabe(Rueckgabe rueckgabe){
        return em.merge(rueckgabe);
    }
    
    public void deleteRueckgabe(Rueckgabe rueckgabe){
        em.remove(rueckgabe);
    }
    
    public void deleteAllRueckgaben(){
        List<Rueckgabe> rueckgaben = getAllRueckgaben();
        rueckgaben.forEach(rueckgabe -> {
            deleteRueckgabe(rueckgabe);
        });
    }
    
}
