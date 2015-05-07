/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTITY;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "complaints")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Complaints.findAll", query = "SELECT c FROM Complaints c"),
    @NamedQuery(name = "Complaints.findByIdcomplaints", query = "SELECT c FROM Complaints c WHERE c.idcomplaints = :idcomplaints"),
    @NamedQuery(name = "Complaints.findByRoomnumber", query = "SELECT c FROM Complaints c WHERE c.roomnumber = :roomnumber"),
    @NamedQuery(name = "Complaints.findByType", query = "SELECT c FROM Complaints c WHERE c.type = :type"),
    @NamedQuery(name = "Complaints.findByDescription", query = "SELECT c FROM Complaints c WHERE c.description = :description")})
public class Complaints implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcomplaints")
    private Integer idcomplaints;
    @Column(name = "roomnumber")
    private String roomnumber;
    @Column(name = "type")
    private String type;
    @Column(name = "description")
    private String description;

    public Complaints() {
    }

    public Complaints(Integer idcomplaints) {
        this.idcomplaints = idcomplaints;
    }

    public Integer getIdcomplaints() {
        return idcomplaints;
    }

    public void setIdcomplaints(Integer idcomplaints) {
        this.idcomplaints = idcomplaints;
    }

    public String getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(String roomnumber) {
        this.roomnumber = roomnumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcomplaints != null ? idcomplaints.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Complaints)) {
            return false;
        }
        Complaints other = (Complaints) object;
        if ((this.idcomplaints == null && other.idcomplaints != null) || (this.idcomplaints != null && !this.idcomplaints.equals(other.idcomplaints))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTITY.Complaints[ idcomplaints=" + idcomplaints + " ]";
    }
    
}
