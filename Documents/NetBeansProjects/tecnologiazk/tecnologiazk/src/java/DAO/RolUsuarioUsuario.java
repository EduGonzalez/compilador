package DAO;
// Generated Dec 11, 2014 10:21:29 PM by Hibernate Tools 3.6.0



/**
 * RolUsuarioUsuario generated by hbm2java
 */
public class RolUsuarioUsuario  implements java.io.Serializable {


     private long id;
     private Long usuarioId;
     private Long rolUsuarioId;

    public RolUsuarioUsuario() {
    }

	
    public RolUsuarioUsuario(long id) {
        this.id = id;
    }
    public RolUsuarioUsuario(long id, Long usuarioId, Long rolUsuarioId) {
       this.id = id;
       this.usuarioId = usuarioId;
       this.rolUsuarioId = rolUsuarioId;
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
    public Long getRolUsuarioId() {
        return this.rolUsuarioId;
    }
    
    public void setRolUsuarioId(Long rolUsuarioId) {
        this.rolUsuarioId = rolUsuarioId;
    }




}

