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
import DAO.Sitio;
import java.util.List;
import VistaModelo.Sitios;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.ExecutionArgParam;

public class SitioEditaVM extends SelectorComposer<Component>{
    
    private Sitio seleccionado;

    public Sitio getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Sitio seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    @AfterCompose
    public void initSetup(@ExecutionArgParam("Sitio") Sitio selsitio) {  
        seleccionado = selsitio;
        
    }
    
  @NotifyChange("sitiolist")
    @Command
    public void EditarSitio() {
    

        Sitios Sit = new Sitios();
        Sitio daoSitio = Sit.getSitio((int) seleccionado.getId());
        
        daoSitio.setNombre(seleccionado.getNombre());
        daoSitio.setDireccion(seleccionado.getDireccion());
        daoSitio.setLatitud(seleccionado.getLatitud());
        Sit.updateSitio(daoSitio);
   
    }   
}
