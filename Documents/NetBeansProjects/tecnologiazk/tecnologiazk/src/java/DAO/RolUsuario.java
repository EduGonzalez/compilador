package DAO;
// Generated Dec 11, 2014 10:21:29 PM by Hibernate Tools 3.6.0



/**
 * RolUsuario generated by hbm2java
 */
public class RolUsuario  implements java.io.Serializable {


     private long id;
     private String rol;

    public RolUsuario() {
    }

	
    public RolUsuario(long id) {
        this.id = id;
    }
    public RolUsuario(long id, String rol) {
       this.id = id;
       this.rol = rol;
    }
   
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public String getRol() {
        return this.rol;
    }
    
    public void setRol(String rol) {
        this.rol = rol;
    }




}


