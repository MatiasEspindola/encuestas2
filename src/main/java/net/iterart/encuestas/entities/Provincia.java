/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iterart.encuestas.entities;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gtoffa
 */
@Entity
@Table(name = "provincias")
public class Provincia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id_prv")
    private Integer pkIdPrv;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    

    public Provincia() {
    }

    public Provincia(Integer pkIdPrv) {
        this.pkIdPrv = pkIdPrv;
    }

    public Provincia(Integer pkIdPrv, String nombre) {
        this.pkIdPrv = pkIdPrv;
        this.nombre = nombre;
    }

    public Integer getPkIdPrv() {
        return pkIdPrv;
    }

    public void setPkIdPrv(Integer pkIdPrv) {
        this.pkIdPrv = pkIdPrv;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static String ucFirst(String str) {
    	  if (str == null || str.isEmpty()) {
    	    return str;            
    	  } else {
    	    return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase(); 
    	  }
    }

    @Override
    public String toString() {
        return ucFirst(getNombre());
    }

  
}