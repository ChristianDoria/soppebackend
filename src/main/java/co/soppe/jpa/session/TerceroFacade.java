/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.soppe.jpa.session;

import co.soppe.jpa.entities.Tercero;
import co.soppe.rest.auth.AuthUtils;
import com.nimbusds.jose.JOSEException;
import java.text.ParseException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author adsi1
 */
@Stateless
public class TerceroFacade extends AbstractFacade<Tercero> {

    @PersistenceContext(unitName = "com.mycompany_soppeBackend_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TerceroFacade() {
        super(Tercero.class);
    }
    
    public Tercero findByEmail(String email) {
        try {
            return (Tercero) getEntityManager().createNamedQuery("Tercero.findByEmail")
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }

    public List<Tercero> findByNombre(String nombre) {
        return getEntityManager().createNamedQuery("Tercero.findByNombres")
                .setParameter("nombres", nombre + "%")
                .getResultList();
    }

    public Tercero getAuthUser(HttpServletRequest request) throws ParseException, JOSEException {
        String subject = AuthUtils.getSubject(request.getHeader(AuthUtils.AUTH_HEADER_KEY));
        return super.find(Integer.parseInt(subject));
    }

   // public Tercero findByEmail(String email) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   // }
    
}
