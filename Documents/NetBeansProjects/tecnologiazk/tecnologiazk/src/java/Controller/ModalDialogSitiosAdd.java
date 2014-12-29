/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Window;
/**
 *
 * @author Edu Gonzalez
 */
public class ModalDialogSitiosAdd extends SelectorComposer<Component>{
        
    @Listen("onClick = #orderBtn")
    public void showModal(Event e) {

        Window window = (Window)Executions.createComponents(
                "Sitio.zul", null, null);
        window.doModal();
    }
}
