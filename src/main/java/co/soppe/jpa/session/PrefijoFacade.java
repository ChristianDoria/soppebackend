/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.soppe.jpa.session;

import co.soppe.jpa.entities.Prefijo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author adsi1
 */
@Stateless
public class PrefijoFacade extends AbstractFacade<Prefijo> {

    @PersistenceContext(unitName = "com.mycompany_soppeBackend_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrefijoFacade() {
        super(Prefijo.class);
    }
    
}
