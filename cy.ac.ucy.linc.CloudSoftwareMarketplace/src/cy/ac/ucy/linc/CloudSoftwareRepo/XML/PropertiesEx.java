package cy.ac.ucy.linc.CloudSoftwareRepo.XML;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import cy.ac.ucy.linc.CloudSoftwareRepo.Interfaces.ICloudPropertiesViewer;
import cy.ac.ucy.linc.CloudSoftwareRepo.XML.Properties.Property;

public class PropertiesEx extends Properties{

    private Set changeListeners = new HashSet();

    public void propertyChanged(Property property){
    	Iterator iterator = changeListeners.iterator();
    	while(iterator.hasNext()){
    		((ICloudPropertiesViewer)iterator.next()).updateProperty(property);
    	}
    }
    
    /**
	 * @param viewer
	 */
	public void removeChangeListener(ICloudPropertiesViewer viewer) {
		changeListeners.remove(viewer);
	}

	/**
	 * @param viewer
	 */
	public void addChangeListener(ICloudPropertiesViewer viewer) {
		changeListeners.add(viewer);
	}
}
