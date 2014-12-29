/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UIVM;

import DAO.Sitio;
import DAO.SitioRutaTuristica;
import Hibernate.HibernateUtil;
import VistaModelo.Sitios;
import VistaModelo.SitiosRutas;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zul.Window;
import org.zkoss.bind.BindUtils;
import java.util.HashMap;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.Wire;
import java.util.Date;

/**
 *
 * @author Edu Gonzalez
 */
public class SitioVM extends SelectorComposer<Component>{
    
    private List<Sitio> AllSitioInDB = null;
    private List<Sitio> SitioFiltrado = null;
    private Sitio seleccionado;
    private String sitioNombre;
    private String nombreZona;
    private String direccion;
    private String descripcion;
    private String latitud;
    private String longitud; 
    private int habilitado;
    private String telefono;
    private Timestamp fecha;

    public List<Sitio> getAllSitioInDB() {
        return AllSitioInDB;
    }

    public List<Sitio> getSitioFiltrado() {
        return SitioFiltrado;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getHabilitado() {
        return habilitado;
    }

    public String getTelefono() {
        return telefono;
    }

    public Sitio getSeleccionado() {
        return seleccionado;
    }

    public String getSitioNombre() {
        return sitioNombre;
    }

    public String getNombreZona() {
        return nombreZona;
    }

    public String getLatitud() {
        return latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setAllSitioInDB(List<Sitio> AllSitioInDB) {
        this.AllSitioInDB = AllSitioInDB;
    }

    public void setSitioFiltrado(List<Sitio> SitioFiltrado) {
        this.SitioFiltrado = SitioFiltrado;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setHabilitado(int habilitado) {
        this.habilitado = habilitado;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setSeleccionado(Sitio seleccionado) {
        this.seleccionado = seleccionado;
    }

    public void setSitioNombre(String sitioNombre) {
        this.sitioNombre = sitioNombre;
    }

    public void setNombreZona(String nombreZona) {
        this.nombreZona = nombreZona;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
    
     @Init
    public void init() {    // Initialize
        if (AllSitioInDB == null) {
            SitioFiltrado = new ArrayList<Sitio>();
            AllSitioInDB = new Sitios().getListaSitios();

            for (Sitio item : AllSitioInDB) {
                SitioFiltrado.add(item);
            }
        }
        seleccionado = SitioFiltrado.get(0);  //el primer item
    }
    
     public List<Sitio> getsitiolist() {
        if (AllSitioInDB == null) {
            SitioFiltrado = new ArrayList<Sitio>();
            AllSitioInDB = new Sitios().getListaSitios();
            for (Sitio item : AllSitioInDB) {
                SitioFiltrado.add(item);
            }
        }

        return SitioFiltrado;
    }
   
       @Command
    @NotifyChange("sitiolist")
    public void doFilter() {
        SitioFiltrado.clear();

        //Si no hay valor en la caja de texto para filtrar cargar todos los registros de la bd
        if (sitioNombre == null || "".equals(sitioNombre)) {
            SitioFiltrado.addAll(AllSitioInDB);
        }

        //Si se ingresa valor para filtrar 

        if (sitioNombre != null && !sitioNombre.equals("")) {

            for (Sitio item : AllSitioInDB) {
                if (item.getNombre().toLowerCase().indexOf(sitioNombre.toLowerCase()) == 0) {
                    SitioFiltrado.add(item);
                }
            }
        }
    }
    
    @GlobalCommand
    @NotifyChange("sitiolist")
    public void GuardarNuevoSitio() {
        Sitio daoSitio = new Sitio();
        Sitios sit = new Sitios();
        
        daoSitio.setNombre(sitioNombre);
        daoSitio.setDireccion(direccion);
        daoSitio.setLatitud(latitud);
        daoSitio.setLongitud(longitud);
        daoSitio.setDescripcion(descripcion);
        daoSitio.setTelefono(telefono);
        daoSitio.setFecha(fecha);
         sit.saveSitio(daoSitio);
        
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createSQLQuery("Select max(id) as Ultimo from sitio"); 
        List result = q.list();
      
        AllSitioInDB = null;
       getsitiolist();
        
    }
        @NotifyChange("sitiolist")
    @Command
    public void EliminarSitio() {

        Messagebox.show("Esta Seguro que Desea Eliminar el Sitio?", "Eliminar Registro", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION,
                new org.zkoss.zk.ui.event.EventListener() {
            public void onEvent(Event evt) {
                switch (((Integer) evt.getData()).intValue()) {
                    case Messagebox.YES:
                        Sitios ca = new Sitios();
                        ca.deleteSitio(seleccionado);
                        AllSitioInDB = null;
                        getsitiolist();
                        BindUtils.postNotifyChange(null, null, SitioVM.this, "sitiolist");

                        break;
                    case Messagebox.NO:
                        break;
                }

            }
        });
    }
    
    
           @GlobalCommand
    @NotifyChange("sitiolist")
    public void showModalEditar() {
          
     final HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("Sitio", this.seleccionado);
        
        Window window = (Window)Executions.createComponents(
                "SitioEditar.zul",  null, map);
        window.doModal();
    }
     
    
    
}
