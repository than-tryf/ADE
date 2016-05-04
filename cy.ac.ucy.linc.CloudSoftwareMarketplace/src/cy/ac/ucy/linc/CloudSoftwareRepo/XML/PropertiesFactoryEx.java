package cy.ac.ucy.linc.CloudSoftwareRepo.XML;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class PropertiesFactoryEx extends PropertiesFactory{
	
	@Override
    public PropertiesEx createProperties() {
        return new PropertiesEx();
    }
	

}
