package DAO;
// Generated Dec 11, 2014 10:21:29 PM by Hibernate Tools 3.6.0



/**
 * SitioRutaTuristica generated by hbm2java
 */
public class SitioRutaTuristica  implements java.io.Serializable {


     private long id;
     private Long sitioId;
     private Long rutaTuristicaId;

    public SitioRutaTuristica() {
    }

	
    public SitioRutaTuristica(long id) {
        this.id = id;
    }
    public SitioRutaTuristica(long id, Long sitioId, Long rutaTuristicaId) {
       this.id = id;
       this.sitioId = sitioId;
       this.rutaTuristicaId = rutaTuristicaId;
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
    public Long getRutaTuristicaId() {
        return this.rutaTuristicaId;
    }
    
    public void setRutaTuristicaId(Long rutaTuristicaId) {
        this.rutaTuristicaId = rutaTuristicaId;
    }




}


