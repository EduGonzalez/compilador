package DAO;
// Generated Dec 11, 2014 10:21:29 PM by Hibernate Tools 3.6.0



/**
 * TelefonoSitio generated by hbm2java
 */
public class TelefonoSitio  implements java.io.Serializable {


     private long id;
     private String numero;
     private Long sitioId;

    public TelefonoSitio() {
    }

	
    public TelefonoSitio(long id) {
        this.id = id;
    }
    public TelefonoSitio(long id, String numero, Long sitioId) {
       this.id = id;
       this.numero = numero;
       this.sitioId = sitioId;
    }
   
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public String getNumero() {
        return this.numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public Long getSitioId() {
        return this.sitioId;
    }
    
    public void setSitioId(Long sitioId) {
        this.sitioId = sitioId;
    }




}

