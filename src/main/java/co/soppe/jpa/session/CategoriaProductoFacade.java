/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.soppe.jpa.session;

import co.soppe.jpa.entities.CategoriaProducto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author adsi1
 */
@Stateless
public class CategoriaProductoFacade extends AbstractFacade<CategoriaProducto> {

    @PersistenceContext(unitName = "com.mycompany_soppeBackend_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriaProductoFacade() {
        super(CategoriaProducto.class);
    }
    
}
