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
@Table(name = "room_allocate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoomAllocate.findAll", query = "SELECT r FROM RoomAllocate r"),
    @NamedQuery(name = "RoomAllocate.findByStudentid", query = "SELECT r FROM RoomAllocate r WHERE r.studentid = :studentid"),
    @NamedQuery(name = "RoomAllocate.findByRoomnumber", query = "SELECT r FROM RoomAllocate r WHERE r.roomnumber = :roomnumber")})
public class RoomAllocate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "studentid")
    private Integer studentid;
    @Column(name = "roomnumber")
    private String roomnumber;

    public RoomAllocate() {
    }

    public RoomAllocate(Integer studentid) {
        this.studentid = studentid;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
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
        hash += (studentid != null ? studentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoomAllocate)) {
            return false;
        }
        RoomAllocate other = (RoomAllocate) object;
        if ((this.studentid == null && other.studentid != null) || (this.studentid != null && !this.studentid.equals(other.studentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTITY.RoomAllocate[ studentid=" + studentid + " ]";
    }
    
}
