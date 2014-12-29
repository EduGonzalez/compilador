/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UIVM;

/**
 *
 * @author Edu Gonzalez
 */
import DAO.RutaTuristica;
import Hibernate.HibernateUtil;
import VistaModelo.Rutas;
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

public class RutaVM extends SelectorComposer<Component>{
    private List<RutaTuristica> AllRutaInDB = null;
    private List<RutaTuristica> RutaFiltrado = null;
    private RutaTuristica seleccionado;
    private String rutaNombre;
    private String descripcion;
    private int habilitado;

    public List<RutaTuristica> getAllRutaInDB() {
        return AllRutaInDB;
    }

    public List<RutaTuristica> getRutaFiltrado() {
        return RutaFiltrado;
    }

    public RutaTuristica getSeleccionado() {
        return seleccionado;
    }

    public String getRutaNombre() {
        return rutaNombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getHabilitado() {
        return habilitado;
    }

    public void setAllRutaInDB(List<RutaTuristica> AllRutaInDB) {
        this.AllRutaInDB = AllRutaInDB;
    }

    public void setRutaFiltrado(List<RutaTuristica> RutaFiltrado) {
        this.RutaFiltrado = RutaFiltrado;
    }

    public void setSeleccionado(RutaTuristica seleccionado) {
        this.seleccionado = seleccionado;
    }

    public void setRutaNombre(String rutaNombre) {
        this.rutaNombre = rutaNombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setHabilitado(int habilitado) {
        this.habilitado = habilitado;
    }
    
         @Init
    public void init() {    // Initialize
        if (AllRutaInDB == null) {
            RutaFiltrado = new ArrayList<RutaTuristica>();
            AllRutaInDB = new Rutas().getListaRutas();

            for (RutaTuristica item : AllRutaInDB) {
                RutaFiltrado.add(item);
            }
        }
        seleccionado = RutaFiltrado.get(0);  //el primer item
    }
    
         public List<RutaTuristica> getrutalist() {
        if (AllRutaInDB == null) {
            RutaFiltrado = new ArrayList<RutaTuristica>();
            AllRutaInDB = new Rutas().getListaRutas();
            for (RutaTuristica item : AllRutaInDB) {
                RutaFiltrado.add(item);
            }
        }

        return RutaFiltrado;
    }
   
       @Command
    @NotifyChange("rutalist")
    public void doFilter() {
        RutaFiltrado.clear();

        //Si no hay valor en la caja de texto para filtrar cargar todos los registros de la bd
        if (rutaNombre == null || "".equals(rutaNombre)) {
            RutaFiltrado.addAll(AllRutaInDB);
        }

        //Si se ingresa valor para filtrar 

        if (rutaNombre != null && !rutaNombre.equals("")) {

            for (RutaTuristica item : AllRutaInDB) {
                if (item.getNombre().toLowerCase().indexOf(rutaNombre.toLowerCase()) == 0) {
                    RutaFiltrado.add(item);
                }
            }
        }
    }
    
      @GlobalCommand
    @NotifyChange("rutalist")
    public void GuardarNuevaRuta() {
        RutaTuristica daoRuta = new RutaTuristica();
        Rutas sit = new Rutas();
        
        daoRuta.setNombre(rutaNombre);
        daoRuta.setDescripcion(descripcion);
         sit.saveRuta(daoRuta);
        
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createSQLQuery("Select max(id) as Ultimo from ruta_turistica"); 
        List result = q.list();

        AllRutaInDB = null;
       getrutalist();
        
    }
    
    
}
