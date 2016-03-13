package cy.ac.ucy.linc.CloudSoftwareRepo.Interfaces;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import cy.ac.ucy.linc.CloudSoftwareRepo.Entities.Artifacts;
import cy.ac.ucy.linc.CloudSoftwareRepo.Exceptions.RepoExceptions;

/**
 * DownloadArtifact, UploadArtifact, GetArtifactMetadata, KeyWordSearch
 * 
 * @author Thanasis Tryfonos
 *
 */

public interface ICloudSoftwareRepo {

	/**
	 * Performs a keyword search on the repository
	 * 
	 * @param keyword
	 * @return an ArrayList with the artifacts matching the keyword
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 * @throws RepoExceptions 
	 */
	public ArrayList<Artifacts> keywordSearch(String keyword) throws ParserConfigurationException, SAXException, IOException, RepoExceptions;
	
	
	/**
	 * Downloads the artifact from the repository
	 * 
	 * @param url
	 * @param localArtifact
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public void downloadArtifact(String url, String localArtifact) throws MalformedURLException, IOException;
	
	
	/**
	 * Uploads an artifact to the repository
	 * 
	 * @param parameters
	 * @throws RepoExceptions
	 */
	public void uploadArtifact(Map<String,String> parameters) throws RepoExceptions;
	
	
	/**
	 * Returns the all the uploaded artifacts on the repository
	 * @return
	 * @throws RepoExceptions 
	 */
	public ArrayList<Artifacts> indexRepository() throws RepoExceptions;
	
	
	public void deleteArtifact(Artifacts artifact);

}
