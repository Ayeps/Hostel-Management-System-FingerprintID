/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTITY;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yepson
 */
@Entity
@Table(name = "students")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Students.findAll", query = "SELECT s FROM Students s"),
    @NamedQuery(name = "Students.findByIdstudents", query = "SELECT s FROM Students s WHERE s.idstudents = :idstudents"),
    @NamedQuery(name = "Students.findByRefnumber", query = "SELECT s FROM Students s WHERE s.refnumber = :refnumber"),
    @NamedQuery(name = "Students.findByName", query = "SELECT s FROM Students s WHERE s.name = :name"),
    @NamedQuery(name = "Students.findByGender", query = "SELECT s FROM Students s WHERE s.gender = :gender"),
    @NamedQuery(name = "Students.findByDateBirth", query = "SELECT s FROM Students s WHERE s.dateBirth = :dateBirth"),
    @NamedQuery(name = "Students.findByAmountpaid", query = "SELECT s FROM Students s WHERE s.amountpaid = :amountpaid"),
    @NamedQuery(name = "Students.findByPhonenumber", query = "SELECT s FROM Students s WHERE s.phonenumber = :phonenumber"),
    @NamedQuery(name = "Students.findByRoomnumber", query = "SELECT s FROM Students s WHERE s.roomnumber = :roomnumber"),
    @NamedQuery(name = "Students.findByProgramme", query = "SELECT s FROM Students s WHERE s.programme = :programme"),
    @NamedQuery(name = "Students.findByAddress", query = "SELECT s FROM Students s WHERE s.address = :address"),
    @NamedQuery(name = "Students.findByHostelname", query = "SELECT s FROM Students s WHERE s.hostelname = :hostelname"),
    @NamedQuery(name = "Students.findByFingerprintid", query = "SELECT s FROM Students s WHERE s.fingerprintid = :fingerprintid")})
public class Students implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idstudents")
    private Integer idstudents;
    @Column(name = "refnumber")
    private String refnumber;
    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private String gender;
    @Column(name = "date_birth")
    @Temporal(TemporalType.DATE)
    private Date dateBirth;
    @Column(name = "amountpaid")
    private String amountpaid;
    @Column(name = "phonenumber")
    private String phonenumber;
    @Column(name = "roomnumber")
    private String roomnumber;
    @Column(name = "programme")
    private String programme;
    @Column(name = "address")
    private String address;
    @Column(name = "hostelname")
    private String hostelname;
    @Column(name = "fingerprintid")
    private Integer fingerprintid;

    public Students() {
    }

    public Students(Integer idstudents) {
        this.idstudents = idstudents;
    }

    public Integer getIdstudents() {
        return idstudents;
    }

    public void setIdstudents(Integer idstudents) {
        Integer oldIdstudents = this.idstudents;
        this.idstudents = idstudents;
        changeSupport.firePropertyChange("idstudents", oldIdstudents, idstudents);
    }

    public String getRefnumber() {
        return refnumber;
    }

    public void setRefnumber(String refnumber) {
        String oldRefnumber = this.refnumber;
        this.refnumber = refnumber;
        changeSupport.firePropertyChange("refnumber", oldRefnumber, refnumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        String oldGender = this.gender;
        this.gender = gender;
        changeSupport.firePropertyChange("gender", oldGender, gender);
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        Date oldDateBirth = this.dateBirth;
        this.dateBirth = dateBirth;
        changeSupport.firePropertyChange("dateBirth", oldDateBirth, dateBirth);
    }

    public String getAmountpaid() {
        return amountpaid;
    }

    public void setAmountpaid(String amountpaid) {
        String oldAmountpaid = this.amountpaid;
        this.amountpaid = amountpaid;
        changeSupport.firePropertyChange("amountpaid", oldAmountpaid, amountpaid);
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        String oldPhonenumber = this.phonenumber;
        this.phonenumber = phonenumber;
        changeSupport.firePropertyChange("phonenumber", oldPhonenumber, phonenumber);
    }

    public String getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(String roomnumber) {
        String oldRoomnumber = this.roomnumber;
        this.roomnumber = roomnumber;
        changeSupport.firePropertyChange("roomnumber", oldRoomnumber, roomnumber);
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        String oldProgramme = this.programme;
        this.programme = programme;
        changeSupport.firePropertyChange("programme", oldProgramme, programme);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    public String getHostelname() {
        return hostelname;
    }

    public void setHostelname(String hostelname) {
        String oldHostelname = this.hostelname;
        this.hostelname = hostelname;
        changeSupport.firePropertyChange("hostelname", oldHostelname, hostelname);
    }

    public Integer getFingerprintid() {
        return fingerprintid;
    }

    public void setFingerprintid(Integer fingerprintid) {
        Integer oldFingerprintid = this.fingerprintid;
        this.fingerprintid = fingerprintid;
        changeSupport.firePropertyChange("fingerprintid", oldFingerprintid, fingerprintid);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idstudents != null ? idstudents.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Students)) {
            return false;
        }
        Students other = (Students) object;
        if ((this.idstudents == null && other.idstudents != null) || (this.idstudents != null && !this.idstudents.equals(other.idstudents))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTITY.Students[ idstudents=" + idstudents + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
