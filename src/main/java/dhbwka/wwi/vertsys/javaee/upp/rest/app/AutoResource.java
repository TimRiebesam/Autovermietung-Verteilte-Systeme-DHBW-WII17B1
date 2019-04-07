/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.vertsys.javaee.upp.rest.app;

import dhbwka.wwi.vertsys.javaee.upp.auto.jpa.Auto;
import dhbwka.wwi.vertsys.javaee.upp.auto.ejb.AutoBean;
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
 * @author Nicolas
 */
@Path("Auto")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AutoResource {
    
    @EJB
    AutoBean  autoBean;
    
    @GET
    public List<Auto> findAutos(){
        return this.autoBean.getAllAutos();
    }
    
    @POST
    public Auto saveNewAuto(@Valid Auto auto) {
        return this.autoBean.saveNew(auto);
    }
    
    @Path("{id}")
    @GET
    public Auto getAuto(@PathParam("id") long id) {
        return this.autoBean.findById(id);
    }
    
    @Path("{id}")
    @PUT
    public Auto updateAuto(@Valid Auto auto) {
        return this.autoBean.update(auto);
    }
    
    @Path("{id}")
    @DELETE
    public Auto deleteAuto(@PathParam("id") long id) {
        Auto auto = this.autoBean.findById(id);

        if (auto != null) {
            this.autoBean.delete(auto);
        }

        return auto;
    }
    
    
    
    
}
