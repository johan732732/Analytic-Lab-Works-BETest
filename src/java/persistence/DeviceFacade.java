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
import model.Device;

/**
 *
 * @author johan
 */
@Stateless
public class DeviceFacade extends AbstractFacade<Device> implements DeviceFacadeLocal {

    @PersistenceContext(unitName = "BackEndTestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DeviceFacade() {
        super(Device.class);
    }

    @Override
    public List<Device> findDevicesBNVR(String b) {
        String consulta = "SELECT d FROM Device d WHERE d.busId.id IN (+" + b + ") AND d.deviceTypeId.id = 2 ";
        try {
            Query query = em.createQuery(consulta);
            return (List<Device>) query.getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public List<Device> summaryDevice() {
//        String consulta = "SELECT d.status, COUNT(d) AS t FROM Device d GROUP BY d.status";
        String consulta = "SELECT d FROM Device d  GROUP BY d.status";

        try {
            Query query = em.createQuery(consulta);
            return (List<Device>) query.getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

}
