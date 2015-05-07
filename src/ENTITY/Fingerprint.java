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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yepson
 */
@Entity
@Table(name = "fingerprint")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fingerprint.findAll", query = "SELECT f FROM Fingerprint f"),
    @NamedQuery(name = "Fingerprint.findByIdfingerprint", query = "SELECT f FROM Fingerprint f WHERE f.idfingerprint = :idfingerprint"),
    @NamedQuery(name = "Fingerprint.findByStudentid", query = "SELECT f FROM Fingerprint f WHERE f.studentid = :studentid")})
public class Fingerprint implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idfingerprint")
    private Integer idfingerprint;
    @Column(name = "studentid")
    private String studentid;
    @Lob
    @Column(name = "template1")
    private byte[] template1;
    @Lob
    @Column(name = "template2")
    private byte[] template2;
    @Lob
    @Column(name = "template3")
    private byte[] template3;
    @Lob
    @Column(name = "template4")
    private byte[] template4;
    @Lob
    @Column(name = "template5")
    private byte[] template5;

    public Fingerprint() {
    }

    public Fingerprint(Integer idfingerprint) {
        this.idfingerprint = idfingerprint;
    }

    public Integer getIdfingerprint() {
        return idfingerprint;
    }

    public void setIdfingerprint(Integer idfingerprint) {
        this.idfingerprint = idfingerprint;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public byte[] getTemplate1() {
        return template1;
    }

    public void setTemplate1(byte[] template1) {
        this.template1 = template1;
    }

    public byte[] getTemplate2() {
        return template2;
    }

    public void setTemplate2(byte[] template2) {
        this.template2 = template2;
    }

    public byte[] getTemplate3() {
        return template3;
    }

    public void setTemplate3(byte[] template3) {
        this.template3 = template3;
    }

    public byte[] getTemplate4() {
        return template4;
    }

    public void setTemplate4(byte[] template4) {
        this.template4 = template4;
    }

    public byte[] getTemplate5() {
        return template5;
    }

    public void setTemplate5(byte[] template5) {
        this.template5 = template5;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfingerprint != null ? idfingerprint.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fingerprint)) {
            return false;
        }
        Fingerprint other = (Fingerprint) object;
        if ((this.idfingerprint == null && other.idfingerprint != null) || (this.idfingerprint != null && !this.idfingerprint.equals(other.idfingerprint))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ENTITY.Fingerprint[ idfingerprint=" + idfingerprint + " ]";
    }
    
}
