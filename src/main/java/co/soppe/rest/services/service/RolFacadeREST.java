package co.soppe.rest.services.service;

import co.soppe.jpa.entities.Rol;
import co.soppe.jpa.session.RolFacade;
import java.util.List;
import javax.ejb.EJB;
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
 * @author adsi1
 */
@Path("roles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RolFacadeREST {
    @EJB
    RolFacade rolFacade;


    @GET
    @Path("{id}")
    public Rol find(@PathParam("id") Integer id) {
        return rolFacade.find(id);
    }

    @GET
    public List<Rol> findAll() {
        return rolFacade.findAll();
    }

}
