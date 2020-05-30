/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Bus;
import model.Concessionaire;
import model.Device;
import model.DeviceType;
import persistence.BusFacadeLocal;
import persistence.ConcessionaireFacadeLocal;
import persistence.DeviceFacadeLocal;
import persistence.DeviceTypeFacadeLocal;

/**
 *
 * @author johan
 */
@Stateless
public class ConcessionaireLogic implements ConcessionaireLogicLocal {

    @EJB
    private ConcessionaireFacadeLocal concessDAO;
    @EJB
    private BusFacadeLocal busDAO;
    @EJB
    private DeviceFacadeLocal deviceDAO;

    public ConcessionaireFacadeLocal getConcessDAO() {
        return concessDAO;
    }

    @Override
    public List<Bus> All() throws Exception {
        return busDAO.findAll();
    }

    /**
     * Gets a Concessionaire
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Concessionaire find(Integer id) throws Exception {
        return concessDAO.find(id);
    }

    @Override
    public List<Bus> listBusesC1() {
        return concessDAO.listBusesC1();
    }

    @Override
    public List<Device> findDevicesBNVR() {
        List<Bus> b = busDAO.findWhereType("Bi-articulado");

        String lista = b.stream()
                .map((x) -> String.valueOf(x.getId()))
                .collect(Collectors.joining(","));

        return deviceDAO.findDevicesBNVR(lista);
    }

    @Override
    public List<Device> sumaryDevice() {
        return deviceDAO.summaryDevice();
    }

    @Override
    public List<Bus> sumaryBus() {
        return busDAO.summaryBus();
    }

}
