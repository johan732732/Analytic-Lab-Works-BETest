/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.DeviceType;

/**
 *
 * @author johan
 */
@Stateless
public class DeviceTypeFacade extends AbstractFacade<DeviceType> implements DeviceTypeFacadeLocal {

    @PersistenceContext(unitName = "BackEndTestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DeviceTypeFacade() {
        super(DeviceType.class);
    }
    
}
