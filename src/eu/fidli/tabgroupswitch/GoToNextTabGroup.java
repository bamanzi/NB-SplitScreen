/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.fidli.tabgroupswitch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import jdk.nashorn.internal.runtime.Debug;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.Mode;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;


@ActionID(
	category = "Window",
	id = "eu.fidli.tabgroupswitch.GoToNextTabGroup"
)
@ActionRegistration(
	displayName = "#CTL_GoToNextTabGroup"
)
@ActionReferences({
    @ActionReference(path = "Menu/GoTo", position = 500),
    @ActionReference(path = "Shortcuts", name = "C-Q")
})
@Messages("CTL_GoToNextTabGroup=Go to next tab group")
public final class GoToNextTabGroup extends TabGroups implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
	Mode nextTabGroup = getNextDocumentTabGroup();
	if(nextTabGroup != null){
	    nextTabGroup.getSelectedTopComponent().requestActive();
	}
    }
}
