/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.ejb.Local;
import model.Device;

/**
 *
 * @author johan
 */
@Local
public interface DeviceFacadeLocal {

    void create(Device device);

    void edit(Device device);

    void remove(Device device);

    Device find(Object id);

    List<Device> findAll();

    List<Device> findRange(int[] range);

    int count();

    public List<Device> findDevicesBNVR(String b);
    public List<Device> summaryDevice();

}
