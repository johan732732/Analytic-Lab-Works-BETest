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
import model.Concessionaire;
import model.Device;
import model.DeviceType;

/**
 *
 * @author johan
 */
@Stateless
public class ConcessionaireFacade extends AbstractFacade<Concessionaire> implements ConcessionaireFacadeLocal {

    @PersistenceContext(unitName = "BackEndTestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConcessionaireFacade() {
        super(Concessionaire.class);
    }

    /**
     * Gets Concessionaire buses
     *
     * Se realiza la consulta suponiendo que ya existen los datos en la tabla
     *
     * @param c
     * @return
     */
    @Override
    public List<Bus> listBusesC1() {
        String consulta = "SELECT b FROM Bus b WHERE "
                + " b.concessionaireId.id = 1";
        try {
            Query query = em.createQuery(consulta);
            return (List<Bus>) query.getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }
}
