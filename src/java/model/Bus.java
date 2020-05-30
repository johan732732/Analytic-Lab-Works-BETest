/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author johan
 */
@Entity
@Table(name = "bus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bus.findAll", query = "SELECT b FROM Bus b")
    , @NamedQuery(name = "Bus.findById", query = "SELECT b FROM Bus b WHERE b.id = :id")
    , @NamedQuery(name = "Bus.findByType", query = "SELECT b FROM Bus b WHERE b.type = :type")
    , @NamedQuery(name = "Bus.findByMotor", query = "SELECT b FROM Bus b WHERE b.motor = :motor")
    , @NamedQuery(name = "Bus.findByBrakes", query = "SELECT b FROM Bus b WHERE b.brakes = :brakes")})
public class Bus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "type")
    private String type;
    @Size(max = 45)
    @Column(name = "motor")
    private String motor;
    @Size(max = 45)
    @Column(name = "brakes")
    private String brakes;
    @JoinColumn(name = "concessionaire_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Concessionaire concessionaireId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "busId")
    private List<Device> deviceList;

    public Bus() {
    }

    public Bus(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getBrakes() {
        return brakes;
    }

    public void setBrakes(String brakes) {
        this.brakes = brakes;
    }

    public Concessionaire getConcessionaireId() {
        return concessionaireId;
    }

    public void setConcessionaireId(Concessionaire concessionaireId) {
        this.concessionaireId = concessionaireId;
    }

    @XmlTransient
    public List<Device> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bus)) {
            return false;
        }
        Bus other = (Bus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Bus[ id=" + id + " ]";
    }
    
}
