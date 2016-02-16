package cy.ac.ucy.linc.CloudSoftwareRepo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import cy.ac.ucy.linc.CloudSoftwareRepo.Communication.CloudHttp;
import cy.ac.ucy.linc.CloudSoftwareRepo.Entities.Artifacts;
import cy.ac.ucy.linc.CloudSoftwareRepo.Exceptions.RepoExceptions;
import cy.ac.ucy.linc.CloudSoftwareRepo.Interfaces.ICloudSoftwareRepo;
import cy.ac.ucy.linc.CloudSoftwareRepo.Parser.CloudXMLParser;

public class CloudSoftwareRepo implements ICloudSoftwareRepo {

	public CloudHttp cHttp;

	public CloudSoftwareRepo() {
		super();
		// TODO Auto-generated constructor stub
		cHttp = new CloudHttp();

	}

	/**
	 * 
	 */
	public ArrayList<Artifacts> keywordSearch(String keyword)
			throws RepoExceptions {
		// TODO Auto-generated method stub
		try {
			CloudXMLParser parser = new CloudXMLParser();
			String srchResult = cHttp.CloudHttpGetRequest(keyword);
			ArrayList<Artifacts> lstArtifacts;

			lstArtifacts = parser.xmlParseKeywordSearch(srchResult);
			System.out.println(srchResult);
			return lstArtifacts;
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RepoExceptions e) {
			// TODO Auto-generated catch block
			throw e;
			// System.out.println(e.getMessage());
		}
		return null;
	}

	/**
 * 
 */
	public void downloadArtifact(String url, String localArtifact)
			throws IOException {
		// TODO Auto-generated method stub

		URL download = new URL(url);

		InputStream is = null;
		FileOutputStream fos = null;

		try {
			URLConnection urlConn = download.openConnection();

			is = urlConn.getInputStream(); // get connection inputstream
			fos = new FileOutputStream(localArtifact); // open outputstream to
														// local file

			byte[] buffer = new byte[4096]; // declare 4KB buffer
			int len;

			// while we have availble data, continue downloading and storing to
			// local file
			while ((len = is.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} finally {
				if (fos != null) {
					fos.close();
				}
			}
		}

	}

	/**
	 * @throws RepoExceptions
	 * 
	 */
	public void uploadArtifact(Map<String, String> parameters)
			throws RepoExceptions {
		// TODO Auto-generated method stub

		for (Map.Entry<String, String> entry : parameters.entrySet()) {
			System.out.println(entry.getKey() + " + " + entry.getValue());
		}

		try {
			cHttp.addPart(parameters);
			cHttp.CloudHttpPostRequest(CloudSoftwareRepoConstants.NEXUS_URL
					+ CloudSoftwareRepoConstants.NEXUS_UPLOAD_ARTIFACT);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RepoExceptions e) {
			// TODO Auto-generated catch block
			throw e;
		}

	}

	public ArrayList<Artifacts> indexRepository() throws RepoExceptions {
		CloudXMLParser parser = new CloudXMLParser();
		try {
			String XMLIndex;

			XMLIndex = cHttp
					.CloudHttpGetRequest(CloudSoftwareRepoConstants.NEXUS_URL
							+ CloudSoftwareRepoConstants.NEXUS_INDEX_BROWSER);

			System.out.println("INDEX: " + XMLIndex);
			ArrayList<Artifacts> index = new ArrayList<Artifacts>();
			ArrayList<String> arts = parser.xmlParseIndex(XMLIndex);
			for (int i = 0; i < arts.size(); i++) {
				// System.out.println("Art: "+arts.get(i));
				ArrayList<Artifacts> tmp = keywordSearch(CloudSoftwareRepoConstants.NEXUS_URL
						+ CloudSoftwareRepoConstants.NEXUS_KEYWORD_SEARCH
						+ arts.get(i));
				index.addAll(tmp);
				// System.out.println("Index Size: "+index.size());
			}

			for (int j = 0; j < index.size(); j++) {
				System.out.println("Artifact " + j + " : "
						+ index.get(j).artifactId);
			}
			return index;
		} catch (RepoExceptions e1) {
			// TODO Auto-generated catch block
			throw e1;
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public void deleteArtifact(Artifacts artifact) {
		// TODO Auto-generated method stub
		String url = CloudSoftwareRepoConstants.NEXUS_URL
				+ CloudSoftwareRepoConstants.NEXUS_REPOSITORIES
				+ artifact.repositoryId + "/"
				+ CloudSoftwareRepoConstants.NEXUS_CONTENT + artifact.groupId
				+ "/" + artifact.artifactId + "/" + artifact.version;
		String deleteReq = cHttp.CloudHttpDeleteRequest(url);
		
		System.out.println(deleteReq);

	}

}
