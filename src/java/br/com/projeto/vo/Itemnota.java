/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.vo;

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
 * @author luiz
 */
@Entity
@Table(name = "ITEMNOTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itemnota.findAll", query = "SELECT i FROM Itemnota i"),
    @NamedQuery(name = "Itemnota.findByIdnota", query = "SELECT i FROM Itemnota i WHERE i.idnota = :idnota"),
    @NamedQuery(name = "Itemnota.findByIdproduto", query = "SELECT i FROM Itemnota i WHERE i.idproduto = :idproduto"),
    @NamedQuery(name = "Itemnota.findByQtde", query = "SELECT i FROM Itemnota i WHERE i.qtde = :qtde"),
    @NamedQuery(name = "Itemnota.findByValorunitario", query = "SELECT i FROM Itemnota i WHERE i.valorunitario = :valorunitario")})
public class Itemnota implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDNOTA")
    private Integer idnota;
    @Column(name = "IDPRODUTO")
    private Integer idproduto;
    @Column(name = "QTDE")
    private Integer qtde;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALORUNITARIO")
    private Double valorunitario;

    public Itemnota() {
    }

    public Itemnota(Integer idnota) {
        this.idnota = idnota;
    }

    public Integer getIdnota() {
        return idnota;
    }

    public void setIdnota(Integer idnota) {
        this.idnota = idnota;
    }

    public Integer getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(Integer idproduto) {
        this.idproduto = idproduto;
    }

    public Integer getQtde() {
        return qtde;
    }

    public void setQtde(Integer qtde) {
        this.qtde = qtde;
    }

    public Double getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario(Double valorunitario) {
        this.valorunitario = valorunitario;
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
        if (!(object instanceof Itemnota)) {
            return false;
        }
        Itemnota other = (Itemnota) object;
        if ((this.idnota == null && other.idnota != null) || (this.idnota != null && !this.idnota.equals(other.idnota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.projeto.vo.Itemnota[ idnota=" + idnota + " ]";
    }
    
}
