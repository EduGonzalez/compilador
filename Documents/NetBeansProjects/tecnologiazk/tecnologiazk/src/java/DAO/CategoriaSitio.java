package DAO;
// Generated Dec 11, 2014 10:21:29 PM by Hibernate Tools 3.6.0



/**
 * CategoriaSitio generated by hbm2java
 */
public class CategoriaSitio  implements java.io.Serializable {


     private long id;
     private String categoriaSitio;

    public CategoriaSitio() {
    }

	
    public CategoriaSitio(long id) {
        this.id = id;
    }
    public CategoriaSitio(long id, String categoriaSitio) {
       this.id = id;
       this.categoriaSitio = categoriaSitio;
    }
   
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public String getCategoriaSitio() {
        return this.categoriaSitio;
    }
    
    public void setCategoriaSitio(String categoriaSitio) {
        this.categoriaSitio = categoriaSitio;
    }




}


