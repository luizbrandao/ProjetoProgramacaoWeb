/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.vo;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luiz
 */
@Entity
@Table(name = "NOTAFISCAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notafiscal.findAll", query = "SELECT n FROM Notafiscal n"),
    @NamedQuery(name = "Notafiscal.findByIdnota", query = "SELECT n FROM Notafiscal n WHERE n.idnota = :idnota"),
    @NamedQuery(name = "Notafiscal.findByNomecliente", query = "SELECT n FROM Notafiscal n WHERE n.nomecliente = :nomecliente"),
    @NamedQuery(name = "Notafiscal.findByDataemissao", query = "SELECT n FROM Notafiscal n WHERE n.dataemissao = :dataemissao")})
public class Notafiscal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDNOTA")
    private Integer idnota;
    @Basic(optional = false)
    @Column(name = "NOMECLIENTE")
    private String nomecliente;
    @Basic(optional = false)
    @Column(name = "DATAEMISSAO")
    @Temporal(TemporalType.DATE)
    private Date dataemissao;

    public Notafiscal() {
    }

    public Notafiscal(Integer idnota) {
        this.idnota = idnota;
    }

    public Notafiscal(Integer idnota, String nomecliente, Date dataemissao) {
        this.idnota = idnota;
        this.nomecliente = nomecliente;
        this.dataemissao = dataemissao;
    }

    public Integer getIdnota() {
        return idnota;
    }

    public void setIdnota(Integer idnota) {
        this.idnota = idnota;
    }

    public String getNomecliente() {
        return nomecliente;
    }

    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }

    public Date getDataemissao() {
        return dataemissao;
    }

    public void setDataemissao(Date dataemissao) {
        this.dataemissao = dataemissao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnota != null ? idnota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notafiscal)) {
            return false;
        }
        Notafiscal other = (Notafiscal) object;
        if ((this.idnota == null && other.idnota != null) || (this.idnota != null && !this.idnota.equals(other.idnota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.projeto.vo.Notafiscal[ idnota=" + idnota + " ]";
    }
    
}
