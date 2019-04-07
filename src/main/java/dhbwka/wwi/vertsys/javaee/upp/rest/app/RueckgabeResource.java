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
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    public List<Rueckgabe> findRueckgaben(){
        return this.rueckgabeBean.getAllRueckgaben();
    }
    
    @POST
    public Rueckgabe saveNewRueckgabe(@Valid Rueckgabe rueckgabe) {
        return this.rueckgabeBean.saveNew(rueckgabe);
    }
    
    @Path("{id}")
    @GET
    public Rueckgabe getRueckgabe(@PathParam("id") long id) {
        return this.rueckgabeBean.findById(id);
    }
    
    @Path("{id}")
    @PUT
    public Rueckgabe updateRueckgabe(@Valid Rueckgabe rueckgabe) {
        return this.rueckgabeBean.update(rueckgabe);
    }
    
    @Path("{id}")
    @DELETE
    public Rueckgabe deleteRueckgabe(@PathParam("id") long id) {
        Rueckgabe rueckgabe = this.rueckgabeBean.findById(id);

        if (rueckgabe != null) {
            this.rueckgabeBean.delete(rueckgabe);
        }

        return rueckgabe;
    }
    
}
