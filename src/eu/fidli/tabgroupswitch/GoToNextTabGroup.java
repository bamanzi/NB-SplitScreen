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
	/*WindowManager manager =	WindowManager.getDefault();
	TopComponent active = TopComponent.getRegistry().getActivated();
	
	Set<Mode> modes = (Set<Mode>)manager.getModes();
	boolean seenActive = false;
	boolean firstOccurence = false;
	TopComponent first = null;
	boolean changed = false;
	for(Mode m : modes){
		    TopComponent top = m.getSelectedTopComponent();
		    
		    if(top != null){
			String className = top.getClass().getName();
			if(className.equals("org.netbeans.core.multiview.MultiViewCloneableTopComponent")){
			    if(!firstOccurence){
				firstOccurence = true;
				first = top;
			    }
			    if(top == active){
				seenActive = true;
				continue;
			    }
			    if(!seenActive){
				continue;
			    }
			    if(active != top){
				top.requestActive();
				changed = true;
				break;
			    }
			}
			
		    }
	}
	
	if(!changed && first != null){
	    first.requestActive();
	}
	*/
	Mode nextTabGroup = getNextDocumentTabGroup();
	if(nextTabGroup != null){
	    nextTabGroup.getSelectedTopComponent().requestActive();
	}
    }
}
