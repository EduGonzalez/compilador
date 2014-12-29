/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UIVM;

import DAO.Sitio;
import DAO.RutaTuristica;
import DAO.SitioRutaTuristica;
import Hibernate.HibernateUtil;
import VistaModelo.Sitios;
import VistaModelo.SitiosRutas;
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
/**
 *
 * @author Edu Gonzalez
 */
    
public class SitioRutaVM extends SelectorComposer<Component>{
    private List<Sitio> AllSitioInDB = null;
    private List<Sitio> SitioFiltrado = null;
    private Sitio seleccionado;
    private String sitioNombre;
    private String rutaNombre;

    public List<Sitio> getAllSitioInDB() {
        return AllSitioInDB;
    }

    public List<Sitio> getSitioFiltrado() {
        return SitioFiltrado;
    }

    public String getRutaNombre() {
        return rutaNombre;
    }

    public Sitio getSeleccionado() {
        return seleccionado;
    }

    public String getSitioNombre() {
        return sitioNombre;
    }

    public void setAllSitioInDB(List<Sitio> AllSitioInDB) {
        this.AllSitioInDB = AllSitioInDB;
    }

    public void setSitioFiltrado(List<Sitio> SitioFiltrado) {
        this.SitioFiltrado = SitioFiltrado;
    }

    public void setRutaNombre(String rutaNombre) {
        this.rutaNombre = rutaNombre;
    }

    public void setSeleccionado(Sitio seleccionado) {
        this.seleccionado = seleccionado;
    }

    public void setSitioNombre(String sitioNombre) {
        this.sitioNombre = sitioNombre;
    }
    
    
    @GlobalCommand
    @NotifyChange("sitiolist")
    public void GuardarNuevoSitioRuta() {
        SitioRutaTuristica daoSitio = new SitioRutaTuristica();
        SitiosRutas sit = new SitiosRutas();
        
        daoSitio.setSitioId(seleccionado.getId());
         sit.saveSitioRuta(daoSitio);
        System.out.println("+++++++++++++++++++++++++++++++++++"+seleccionado.getNombre());
               AllSitioInDB = null;
       //getsitiolist();
        
    }
}
