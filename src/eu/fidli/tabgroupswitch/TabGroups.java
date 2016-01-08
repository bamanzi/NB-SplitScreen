/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.fidli.tabgroupswitch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import org.openide.windows.Mode;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;


abstract class TabGroups{

    /**
     * 
     * @return currents document tab group
     */
    protected final Mode getCurrentTabGroup(){
	WindowManager manager =	WindowManager.getDefault();
	
	TopComponent active = TopComponent.getRegistry().getActivated();
	
	Set<Mode> modes = (Set<Mode>)manager.getModes();
	for(Mode m : modes){
		    TopComponent top = m.getSelectedTopComponent();
		    if(top != null){
			String className = top.getClass().getName();
			if(className.equals("org.netbeans.core.multiview.MultiViewCloneableTopComponent")){
				if(top == active){
				    return m;
				}
			}
		    }
	}
	return null;
    }
    
    /**
     * Gets the next document tab group. Treats tab groups as they would follow from left to right and from top to bottom
     * @return null if there are not any other document tab groups, next document tab group 
     */
    protected final Mode getNextDocumentTabGroup(){
	WindowManager manager =	WindowManager.getDefault();
	
	TopComponent active = TopComponent.getRegistry().getActivated();
	
	Set<Mode> modes = (Set<Mode>)manager.getModes();
	
	ArrayList<Mode> otherTabGroups= new ArrayList<Mode>();
	for(Mode m : modes){
		    TopComponent top = m.getSelectedTopComponent();
		    if(top == active){
			break;
		    }
		    if(top != null){
			String className = top.getClass().getName();
			if(className.equals("org.netbeans.core.multiview.MultiViewCloneableTopComponent")){
				if(top == active){
				    continue;
				}
				//else
				otherTabGroups.add(m);

			}
		    }
	}
	if(otherTabGroups.isEmpty()){
	    return null;
	}
	//else
	//both are stable sorts, get from left to right;
	otherTabGroups.sort((new Comparator<Mode>() {
	    @Override
	    public int compare(Mode o1, Mode o2) {
		    return ((int)o1.getSelectedTopComponent().getLocationOnScreen().getX()- (int)o2.getSelectedTopComponent().getLocationOnScreen().getX());
	    }
	}));
	
	otherTabGroups.sort((new Comparator<Mode>() {
	    @Override
	    public int compare(Mode o1, Mode o2) {
		return ((int)o1.getSelectedTopComponent().getLocationOnScreen().getY()- (int)o2.getSelectedTopComponent().getLocationOnScreen().getY());
	    }
	}));
	
	//find the correct next one
	for(Mode m : otherTabGroups){
	    double currentX = active.getLocationOnScreen().getX();
	    double currentY = active.getLocationOnScreen().getY();
	    
	    double newX = m.getSelectedTopComponent().getLocationOnScreen().getX();
	    double newY = m.getSelectedTopComponent().getLocationOnScreen().getY();
	    
	    if(currentY == newY){
		if(newX > currentX){
		    return m;
		}
		continue;
	    }
	    if(currentY < newY){
		return m;
	    }
	    
	}
	//no next one, need to wrap around
        return otherTabGroups.get(0);
    }
    
}
