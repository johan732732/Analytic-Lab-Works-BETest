/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import logic.ConcessionaireLogicLocal;
import model.Bus;
import model.Device;

/**
 *
 * @author johan
 */
@ManagedBean
@RequestScoped
public class ConcessionaireView {

    private List<Bus> busList;
    private List<Device> deviceList;
    private List<Device> summaryDeviceList;
    private List<Bus> summaryBusList;

    @EJB
    private ConcessionaireLogicLocal concessLogic;

    /**
     * Creates a new instance of ConcessionaireView
     */
    public ConcessionaireView() {
    }

    public List<Bus> getBusList() throws Exception {
        busList = concessLogic.listBusesC1();
        return busList;
    }

    public void setBusList(List<Bus> busList) {
        this.busList = busList;
    }

    public List<Device> getDeviceList() {
        deviceList = concessLogic.findDevicesBNVR();
        return deviceList;
    }

    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
    }

    public List<Device> getSummaryDeviceList() {
        summaryDeviceList = concessLogic.sumaryDevice();
        return summaryDeviceList;
    }

    public void setSummaryDeviceList(List<Device> summaryDeviceList) {
        this.summaryDeviceList = summaryDeviceList;
    }

    public List<Bus> getSummaryBusList() {
        summaryBusList = concessLogic.sumaryBus();
        return summaryBusList;
    }

    public void setSummaryBusList(List<Bus> summaryBusList) {
        this.summaryBusList = summaryBusList;
    }

    public ConcessionaireLogicLocal getConcessLogic() {
        return concessLogic;
    }

    public void setConcessLogic(ConcessionaireLogicLocal concessLogic) {
        this.concessLogic = concessLogic;
    }

}
