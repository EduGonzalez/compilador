package DAO;
// Generated Dec 11, 2014 10:21:29 PM by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * RutaTuristica generated by hbm2java
 */
public class RutaTuristica  implements java.io.Serializable {


     private long id;
     private Long usuarioId;
     private String nombre;
     private String descripcion;
     private Integer habilitado;
     private Date fecha;

    public RutaTuristica() {
    }

	
    public RutaTuristica(long id) {
        this.id = id;
    }
    public RutaTuristica(long id, Long usuarioId, String nombre, String descripcion, Integer habilitado, Date fecha) {
       this.id = id;
       this.usuarioId = usuarioId;
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.habilitado = habilitado;
       this.fecha = fecha;
    }
   
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public Long getUsuarioId() {
        return this.usuarioId;
    }
    
    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Integer getHabilitado() {
        return this.habilitado;
    }
    
    public void setHabilitado(Integer habilitado) {
        this.habilitado = habilitado;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }




}

