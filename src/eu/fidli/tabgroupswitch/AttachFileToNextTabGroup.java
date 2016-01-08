/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.fidli.tabgroupswitch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Set;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.CloneableTopComponent;
import org.openide.windows.Mode;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

@ActionID(
	category = "Edit",
	id = "eu.fidli.tabgroupswitch.AttachFileToNextTabGroup"
)
@ActionRegistration(
	displayName = "#CTL_AttachFileToNextTabGroup"
)
@ActionReferences({
    @ActionReference(path = "Menu/Window", position = 1325),
    @ActionReference(path = "Shortcuts", name = "F12")
})
@Messages("CTL_AttachFileToNextTabGroup=Dock current file to next tab group")
public final class AttachFileToNextTabGroup extends TabGroups implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
	Mode nextTabGroup = getNextDocumentTabGroup();
	if(nextTabGroup != null){
		TopComponent active = TopComponent.getRegistry().getActivated();
		TopComponent activeClone = ((CloneableTopComponent) active).cloneTopComponent();
		active.close();
		nextTabGroup.dockInto(activeClone);
		activeClone.openAtTabPosition(0);
		activeClone.requestActive();
	}
	
    }

    
}
