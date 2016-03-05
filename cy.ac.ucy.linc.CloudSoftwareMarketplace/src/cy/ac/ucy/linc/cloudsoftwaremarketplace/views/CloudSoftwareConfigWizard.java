package cy.ac.ucy.linc.cloudsoftwaremarketplace.views;

import org.eclipse.jface.wizard.Wizard;

public class CloudSoftwareConfigWizard extends Wizard {

	public CloudSoftwareConfigWizard() {
		setWindowTitle("New Wizard");
	}

	@Override
	public void addPages() {
	}

	@Override
	public boolean performFinish() {
		return false;
	}

}
