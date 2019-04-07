/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.vertsys.javaee.upp.rest.app;

import dhbwka.wwi.vertsys.javaee.upp.common.ejb.UserBean;
import dhbwka.wwi.vertsys.javaee.upp.common.jpa.User;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author RaphaelMenken
 */
@Path("User")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    
    @EJB
    UserBean userBean;
    
    
    @GET
    public User findCurrentUser() {
        return this.userBean.getCurrentUser();
    }
    
    
}

