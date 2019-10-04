package net.iterart.encuestas.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Where;

@Entity
@Table(name = "usuarios")
@Where(clause = "activo = true")
public class Usuario implements Serializable {

   

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id_usuario")
    private int id;

    @NotEmpty
    @Size(max = 35)
    private String apellido;

    @NotEmpty
    @Size(max = 35)
    private String nombre;

    @Size(min = 8)
    private String documento;

    @NotEmpty
    @Size(max = 65)
    private String email;

    @NotEmpty
    @Size(max = 20, min = 6)
    //@Column(unique=true)
    private String usuario;

    @NotEmpty
    @Size(max = 70)
    private String clave;

    @Column(name = "salt")
    private String salt;
    
    @ManyToOne
    @JoinColumn(name = "fk_id_permiso", referencedColumnName = "pk_id_permiso")
    private Permiso permiso;

    @Column(name = "activo", columnDefinition = "boolean default 1")
    private boolean activo;

    @PrePersist
    public void prePersist() {
        activo = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return apellido + ", " + nombre;
    }

   
    public String getSalt() {
        return salt;
    }

    
    public void setSalt(String salt) {
        this.salt = salt;
    }
}
