package DAO;
// Generated Dec 11, 2014 10:21:29 PM by Hibernate Tools 3.6.0



/**
 * CategoriaEvento generated by hbm2java
 */
public class CategoriaEvento  implements java.io.Serializable {


     private long id;
     private String categoriaEvento;

    public CategoriaEvento() {
    }

	
    public CategoriaEvento(long id) {
        this.id = id;
    }
    public CategoriaEvento(long id, String categoriaEvento) {
       this.id = id;
       this.categoriaEvento = categoriaEvento;
    }
   
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public String getCategoriaEvento() {
        return this.categoriaEvento;
    }
    
    public void setCategoriaEvento(String categoriaEvento) {
        this.categoriaEvento = categoriaEvento;
    }




}

