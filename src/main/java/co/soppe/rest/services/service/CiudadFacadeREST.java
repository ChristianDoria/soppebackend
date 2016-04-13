/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.soppe.rest.services.service;

import co.soppe.jpa.entities.Ciudad;
import co.soppe.jpa.entities.CiudadPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author adsi1
 */
@Stateless
@Path("co.soppe.jpa.entities.ciudad")
public class CiudadFacadeREST extends AbstractFacade<Ciudad> {

    @PersistenceContext(unitName = "com.mycompany_soppeBackend_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    private CiudadPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idCiudad=idCiudadValue;idDepartamentos=idDepartamentosValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        co.soppe.jpa.entities.CiudadPK key = new co.soppe.jpa.entities.CiudadPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idCiudad = map.get("idCiudad");
        if (idCiudad != null && !idCiudad.isEmpty()) {
            key.setIdCiudad(new java.lang.Integer(idCiudad.get(0)));
        }
        java.util.List<String> idDepartamentos = map.get("idDepartamentos");
        if (idDepartamentos != null && !idDepartamentos.isEmpty()) {
            key.setIdDepartamentos(new java.lang.Integer(idDepartamentos.get(0)));
        }
        return key;
    }

    public CiudadFacadeREST() {
        super(Ciudad.class);
    }

    @POST
    @Override
    @Consumes({ MediaType.APPLICATION_JSON})
    public void create(Ciudad entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({ MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Ciudad entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        co.soppe.jpa.entities.CiudadPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON})
    public Ciudad find(@PathParam("id") PathSegment id) {
        co.soppe.jpa.entities.CiudadPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Ciudad> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Ciudad> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
