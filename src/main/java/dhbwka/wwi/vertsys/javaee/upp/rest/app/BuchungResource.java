/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.vertsys.javaee.upp.rest.app;

import dhbwka.wwi.vertsys.javaee.upp.buchung.ejb.BuchungBean;
import dhbwka.wwi.vertsys.javaee.upp.buchung.jpa.Buchung;
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


@Path("Buchung")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BuchungResource {
    
    @EJB
    BuchungBean buchungBean;
    
    @GET
    public List<Buchung> findBuchung(){
        return this.buchungBean.getAllBuchungen();
    }
    
    @POST
    public Buchung saveNewBuchung(@Valid Buchung buchung) {
        return this.buchungBean.saveNew(buchung);
    }
    
    @Path("{id}")
    @GET
    public Buchung getBuchung(@PathParam("id") long id) {
        return this.buchungBean.findById(id);
    }
    
    @Path("{id}")
    @PUT
    public Buchung updateBuchung(@Valid Buchung buchung) {
        return this.buchungBean.update(buchung);
    }
    
    @Path("{id}")
    @DELETE
    public Buchung deleteBuchung(@PathParam("id") long id) {
        Buchung buchung = this.buchungBean.findById(id);

        if (buchung != null) {
            this.buchungBean.delete(buchung);
        }

        return buchung;
    }
    
}
