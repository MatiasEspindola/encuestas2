package net.iterart.encuestas.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "encuestas")
//@Where(clause = "activo = true")
public class Encuesta implements Serializable {

    

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id_enc")
    private int id;

    @NotBlank(message = "El título es requerido")
    @Size(max = 110)
    private String titulo;

    @NotBlank(message = "La presentación es requerida")
    @Size(max = 250)
    private String presentacion;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_inicio", nullable = false)
    private Date fechaInicio;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_caducidad", nullable = false)
    private Date fechaCaducidad;

    @Column(name = "imagen_portada", nullable = true)
    private String portadaImg;

    @NotNull(message = "La localidad es requerida")
    @ManyToOne
    @JoinColumn(name = "fk_id_loc")
    private Localidad localidad;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id_enc")
    private List<Pregunta> pregunta;
    
    
    
    public Encuesta() {
		pregunta = new ArrayList<Pregunta>();
               
	}
    
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getPortadaImg() {
        return portadaImg;
    }

    public void setPortadaImg(String portadaImg) {
        this.portadaImg = portadaImg;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public List<Pregunta> getPregunta() {
        return pregunta;
    }

    

    void setPregunta(List<Pregunta> pregunta) {
        this.pregunta = pregunta;
    }

   
}
