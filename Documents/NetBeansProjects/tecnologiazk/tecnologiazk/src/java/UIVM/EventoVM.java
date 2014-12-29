/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UIVM;

import DAO.Evento;
import DAO.Sitio;
import Hibernate.HibernateUtil;
import VistaModelo.Eventos;
import VistaModelo.Sitios;
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
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.Wire;

/**
 *
 * @author Edu Gonzalez
 */
public class EventoVM extends SelectorComposer<Component>{
        
    private List<Evento> AllEventoInDB = null;
    private List<Evento> EventoFiltrado = null;
    private Evento seleccionado;
    private String eventoNombre;
    private String descripcion;
    private String lugar;

    public List<Evento> getAllEventoInDB() {
        return AllEventoInDB;
    }

    public List<Evento> getEventoFiltrado() {
        return EventoFiltrado;
    }

    public Evento getSeleccionado() {
        return seleccionado;
    }

    public String getEventoNombre() {
        return eventoNombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setAllEventoInDB(List<Evento> AllEventoInDB) {
        this.AllEventoInDB = AllEventoInDB;
    }

    public void setEventoFiltrado(List<Evento> EventoFiltrado) {
        this.EventoFiltrado = EventoFiltrado;
    }

    public void setSeleccionado(Evento seleccionado) {
        this.seleccionado = seleccionado;
    }

    public void setEventoNombre(String eventoNombre) {
        this.eventoNombre = eventoNombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    
    
         @Init
    public void init() {    // Initialize
        if (AllEventoInDB == null) {
            EventoFiltrado = new ArrayList<Evento>();
            AllEventoInDB = new Eventos().getListaEventos();

            for (Evento item : AllEventoInDB) {
                EventoFiltrado.add(item);
            }
        }
        seleccionado = EventoFiltrado.get(0);  //el primer item
    }
    
         public List<Evento> geteventolist() {
        if (AllEventoInDB == null) {
            EventoFiltrado = new ArrayList<Evento>();
            AllEventoInDB = new Eventos().getListaEventos();
            for (Evento item : AllEventoInDB) {
                EventoFiltrado.add(item);
            }
        }

        return EventoFiltrado;
    }
    
           @Command
    @NotifyChange("eventolist")
    public void doFilter() {
        EventoFiltrado.clear();

        //Si no hay valor en la caja de texto para filtrar cargar todos los registros de la bd
        if (eventoNombre == null || "".equals(eventoNombre)) {
            EventoFiltrado.addAll(AllEventoInDB);
        }

        //Si se ingresa valor para filtrar 

        if (eventoNombre != null && !eventoNombre.equals("")) {

            for (Evento item : AllEventoInDB) {
                if (item.getNombre().toLowerCase().indexOf(eventoNombre.toLowerCase()) == 0) {
                    EventoFiltrado.add(item);
                }
            }
        }
    }
    
       @GlobalCommand
    @NotifyChange("eventolist")
    public void GuardarNuevoEvento() {
        Evento daoEvento = new Evento();
        Eventos sit = new Eventos();
        
        daoEvento.setNombre(eventoNombre);
        daoEvento.setDescripcion(descripcion);
        daoEvento.setLugar(lugar);
          sit.saveEvento(daoEvento);
        
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createSQLQuery("Select max(id) as Ultimo from evento"); 
        List result = q.list();
      
        AllEventoInDB = null;
       geteventolist();
        
    }
    
            @NotifyChange("eventolist")
    @Command
    public void EliminarEvento() {

        Messagebox.show("Esta Seguro que Desea Eliminar el Evento?", "Eliminar Registro", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION,
                new org.zkoss.zk.ui.event.EventListener() {
            public void onEvent(Event evt) {
                switch (((Integer) evt.getData()).intValue()) {
                    case Messagebox.YES:
                        Eventos ca = new Eventos();
                        ca.deleteEvento(seleccionado);
                        AllEventoInDB = null;
                        geteventolist();
                        BindUtils.postNotifyChange(null, null, EventoVM.this, "eventolist");

                        break;
                    case Messagebox.NO:
                        break;
                }

            }
        });
    }
    
               @GlobalCommand
    @NotifyChange("eventolist")
    public void showModalEditar() {
          
     final HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("Evento", this.seleccionado);
        
        Window window = (Window)Executions.createComponents(
                "EventoEditar.zul",  null, map);
        window.doModal();
    }
    
       
}
