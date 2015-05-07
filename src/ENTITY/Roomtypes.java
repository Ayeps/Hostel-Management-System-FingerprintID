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
@Table(name = "roomtypes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roomtypes.findAll", query = "SELECT r FROM Roomtypes r"),
    @NamedQuery(name = "Roomtypes.findByIdroomtypes", query = "SELECT r FROM Roomtypes r WHERE r.idroomtypes = :idroomtypes"),
    @NamedQuery(name = "Roomtypes.findByRoomtype", query = "SELECT r FROM Roomtypes r WHERE r.roomtype = :roomtype"),
    @NamedQuery(name = "Roomtypes.findByRoomnumber", query = "SELECT r FROM Roomtypes r WHERE r.roomnumber = :roomnumber")})
public class Roomtypes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idroomtypes")
    private Integer idroomtypes;
    @Column(name = "roomtype")
    private String roomtype;
    @Column(name = "roomnumber")
    private String roomnumber;

    public Roomtypes() {
    }

    public Roomtypes(Integer idroomtypes) {
        this.idroomtypes = idroomtypes;
    }

    public Integer getIdroomtypes() {
        return idroomtypes;
    }

    public void setIdroomtypes(Integer idroomtypes) {
        this.idroomtypes = idroomtypes;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public String getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(String roomnumber) {
        this.roomnumber = roomnumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idroomtypes != null ? idroomtypes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roomtypes)) {
            return false;
        }
        Roomtypes other = (Roomtypes) object;
        if ((this.idroomtypes == null && other.idroomtypes != null) || (this.idroomtypes != null && !this.idroomtypes.equals(other.idroomtypes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTITY.Roomtypes[ idroomtypes=" + idroomtypes + " ]";
    }
    
}
