package DAO;
// Generated Dec 11, 2014 10:21:29 PM by Hibernate Tools 3.6.0



/**
 * CalificacionSitio generated by hbm2java
 */
public class CalificacionSitio  implements java.io.Serializable {


     private long id;
     private Long sitioId;
     private Long usuarioId;
     private Integer calificacion;

    public CalificacionSitio() {
    }

	
    public CalificacionSitio(long id) {
        this.id = id;
    }
    public CalificacionSitio(long id, Long sitioId, Long usuarioId, Integer calificacion) {
       this.id = id;
       this.sitioId = sitioId;
       this.usuarioId = usuarioId;
       this.calificacion = calificacion;
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
    public Long getUsuarioId() {
        return this.usuarioId;
    }
    
    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
    public Integer getCalificacion() {
        return this.calificacion;
    }
    
    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }




}


