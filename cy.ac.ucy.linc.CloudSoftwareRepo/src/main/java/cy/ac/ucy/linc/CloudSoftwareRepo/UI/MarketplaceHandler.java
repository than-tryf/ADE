package cy.ac.ucy.linc.CloudSoftwareRepo.UI;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class MarketplaceHandler {

	public String[] guessGav(String artifactName) {

		String[] gav = new String[3];

		String[] token = artifactName.split("-");
		for (int i = 0; i < token.length; i++) {
			System.out.println(token[i]);
		}

		gav[0] = token[0];
		gav[1] = token[0];

		gav[2] = token[1].substring(0, token[1].length() - 4);
		return gav;

	}

	public void copyDirectory(File src, File dest) throws IOException {

		FileUtils.copyDirectory(src, dest);
	}

	public void copyFile(File src, File dest) throws IOException {
		FileUtils.copyFileToDirectory(src, dest);

	}
}
