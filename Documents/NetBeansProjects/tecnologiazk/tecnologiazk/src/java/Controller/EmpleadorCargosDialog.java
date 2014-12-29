/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Window;

/**
 *
 * @author jonathan
 */
public class EmpleadorCargosDialog extends SelectorComposer<Component> {
    private static final long serialVersionUID = 1L;
     
    @Wire 
    Window MantCargosAdd;
    
    @Wire 
    Window CrimenAdd;
     
    @Listen("onClick = #closeBtn2222")
    public void showModal(Event e) {
        MantCargosAdd.detach();
        

    }
    
    
      @Listen("onClick = #closeCrimenAdd")
    public void showModalCrimen(Event e) {
        CrimenAdd.detach();
        

    }
}