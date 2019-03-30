
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
package dhbwka.wwi.vertsys.javaee.upp.kunde.ejb;

import dhbwka.wwi.vertsys.javaee.upp.common.ejb.EntityBean;
import dhbwka.wwi.vertsys.javaee.upp.kunde.jpa.Kunde;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
/**
 * 
 * @author RaphaelMenken
 *
 */

@Stateless
@RolesAllowed("app-user")
public class KundeBean extends EntityBean<Kunde, Long> {
	
	public KundeBean() {
		super(Kunde.class);
	}
	
	public List<Kunde> getAllKunde(){
		return em.createQuery("SELECT r FROM Kunde r").getResultList();
	}
	
	public Kunde getKunde(long kundenNr) {
		return em.find(Kunde.class, kundenNr);
	}
	
	public Kunde saveKunde(Kunde kunde) {
		em.persist(kunde);
		return em.merge(kunde);
	}
	
	public Kunde updateKunde(Kunde kunde) {
		return em.merge(kunde);
	}
	
	public void deleteKunde(Kunde kunde) {
		em.remove(kunde);
	}
}
