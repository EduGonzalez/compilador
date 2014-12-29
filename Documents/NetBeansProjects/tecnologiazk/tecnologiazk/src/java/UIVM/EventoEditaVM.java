/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UIVM;

import DAO.Evento;
import VistaModelo.Eventos;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;

/**
 *
 * @author Edu Gonzalez
 */
public class EventoEditaVM extends SelectorComposer<Component>{
    
    
        private Evento seleccionado;

    public Evento getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Evento seleccionado) {
        this.seleccionado = seleccionado;
    }
        
            @AfterCompose
    public void initSetup(@ExecutionArgParam("Evento") Evento selsitio) {  
        seleccionado = selsitio;
        
    }
    
  @NotifyChange("eventolist")
    @Command
    public void EditarEvento() {
    

        Eventos Sit = new Eventos();
        Evento daoEvento = Sit.getEvento((int) seleccionado.getId());
        daoEvento.setId(seleccionado.getId());
        daoEvento.setNombre(seleccionado.getNombre());
        daoEvento.setDescripcion(seleccionado.getDescripcion());
        daoEvento.setLugar(seleccionado.getLugar());
        Sit.updateEvento(daoEvento);
   
    }   
}
