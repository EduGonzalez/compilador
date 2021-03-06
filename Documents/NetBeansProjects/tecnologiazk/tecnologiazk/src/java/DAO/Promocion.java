package DAO;
// Generated Dec 11, 2014 10:21:29 PM by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * Promocion generated by hbm2java
 */
public class Promocion  implements java.io.Serializable {


     private long id;
     private Long sitioId;
     private Date validez;
     private String descripcion;
     private String nombre;

    public Promocion() {
    }

	
    public Promocion(long id) {
        this.id = id;
    }
    public Promocion(long id, Long sitioId, Date validez, String descripcion, String nombre) {
       this.id = id;
       this.sitioId = sitioId;
       this.validez = validez;
       this.descripcion = descripcion;
       this.nombre = nombre;
    }
   
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public Long getSitioId() {
        return this.sitioId;
    }
    
    public void setSitioId(Long sitioId) {
        this.sitioId = sitioId;
    }
    public Date getValidez() {
        return this.validez;
    }
    
    public void setValidez(Date validez) {
        this.validez = validez;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }




}


