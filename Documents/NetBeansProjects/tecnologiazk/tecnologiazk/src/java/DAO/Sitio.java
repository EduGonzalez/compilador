package DAO;
// Generated Dec 11, 2014 10:21:29 PM by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * Sitio generated by hbm2java
 */
public class Sitio  implements java.io.Serializable {


     private long id;
     private String nombre;
     private String direccion;
     private String latitud;
     private String longitud;
     private Long usuarioId;
     private String descripcion;
     private Integer habilitado;
     private Date fecha;
     private String telefono;

    public Sitio() {
    }

	
    public Sitio(long id) {
        this.id = id;
    }
    public Sitio(long id, String nombre, String direccion, String latitud, String longitud, Long usuarioId, String descripcion, Integer habilitado, Date fecha, String telefono) {
       this.id = id;
       this.nombre = nombre;
       this.direccion = direccion;
       this.latitud = latitud;
       this.longitud = longitud;
       this.usuarioId = usuarioId;
       this.descripcion = descripcion;
       this.habilitado = habilitado;
       this.fecha = fecha;
       this.telefono = telefono;
    }
   
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getLatitud() {
        return this.latitud;
    }
    
    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }
    public String getLongitud() {
        return this.longitud;
    }
    
    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
    public Long getUsuarioId() {
        return this.usuarioId;
    }
    
    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
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
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }




}


