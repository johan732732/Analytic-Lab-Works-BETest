/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Bus;

/**
 *
 * @author johan
 */
@Stateless
public class BusFacade extends AbstractFacade<Bus> implements BusFacadeLocal {

    @PersistenceContext(unitName = "BackEndTestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BusFacade() {
        super(Bus.class);
    }

    @Override
    public List<Bus> findWhereType(String t) {
        String consulta = "SELECT b FROM Bus b WHERE "
                + " b.type = '" + t + "'";
        try {
            Query query = em.createQuery(consulta);
            return (List<Bus>) query.getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public List<Bus> summaryBus() {
        String consulta = "SELECT b FROM Bus b GROUP BY b.type";
        try {
            Query query = em.createQuery(consulta);
            return (List<Bus>) query.getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }
}
