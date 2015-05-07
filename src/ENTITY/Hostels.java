/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTITY;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yepson
 */
@Entity
@Table(name = "hostels")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hostels.findAll", query = "SELECT h FROM Hostels h"),
    @NamedQuery(name = "Hostels.findByIdhostels", query = "SELECT h FROM Hostels h WHERE h.idhostels = :idhostels"),
    @NamedQuery(name = "Hostels.findByHostelname", query = "SELECT h FROM Hostels h WHERE h.hostelname = :hostelname"),
    @NamedQuery(name = "Hostels.findByNumberRooms", query = "SELECT h FROM Hostels h WHERE h.numberRooms = :numberRooms")})
public class Hostels implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idhostels")
    private Integer idhostels;
    @Column(name = "hostelname")
    private String hostelname;
    @Column(name = "number_rooms")
    private String numberRooms;

    public Hostels() {
    }

    public Hostels(Integer idhostels) {
        this.idhostels = idhostels;
    }

    public Integer getIdhostels() {
        return idhostels;
    }

    public void setIdhostels(Integer idhostels) {
        this.idhostels = idhostels;
    }

    public String getHostelname() {
        return hostelname;
    }

    public void setHostelname(String hostelname) {
        this.hostelname = hostelname;
    }

    public String getNumberRooms() {
        return numberRooms;
    }

    public void setNumberRooms(String numberRooms) {
        this.numberRooms = numberRooms;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhostels != null ? idhostels.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hostels)) {
            return false;
        }
        Hostels other = (Hostels) object;
        if ((this.idhostels == null && other.idhostels != null) || (this.idhostels != null && !this.idhostels.equals(other.idhostels))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTITY.Hostels[ idhostels=" + idhostels + " ]";
    }
    
}
