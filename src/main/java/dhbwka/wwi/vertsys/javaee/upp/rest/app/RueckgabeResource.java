/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.vertsys.javaee.upp.rest.app;

import dhbwka.wwi.vertsys.javaee.upp.rueckgabe.ejb.RueckgabeBean;
import dhbwka.wwi.vertsys.javaee.upp.rueckgabe.jpa.Rueckgabe;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author TimRiebesam
 */
@Path("Rueckgabe")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RueckgabeResource {
    
    @EJB
    RueckgabeBean rueckgabeBean;
    
    @GET
    public Rueckgabe findRueckgabe(){
        return this.rueckgabeBean.getAllRueckgaben().get(0);
    }
    
}
