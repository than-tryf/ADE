package cy.ac.ucy.linc.CloudSoftwareRepo.Parser;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import cy.ac.ucy.linc.CloudSoftwareRepo.CloudSoftwareRepoConstants;
import cy.ac.ucy.linc.CloudSoftwareRepo.Communication.CloudHttp;
import cy.ac.ucy.linc.CloudSoftwareRepo.Entities.Artifacts;
import cy.ac.ucy.linc.CloudSoftwareRepo.Exceptions.RepoExceptions;

public class CloudXMLParser {

	public ArrayList<Artifacts> xmlParseKeywordSearch(String sres)
			throws ParserConfigurationException, SAXException, IOException {
		try {

			ArrayList<Artifacts> nxArtifactList = new ArrayList<Artifacts>();

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder;
			InputSource is;

			builder = factory.newDocumentBuilder();
			is = new InputSource(new StringReader(sres));
			Document doc = builder.parse(is);
			NodeList list = doc.getChildNodes();
			Element root = (Element) list.item(0);

			// Search for tags named artifact (inside are stored information
			// about
			// the artifacts)
			NodeList artifactsNl = root.getElementsByTagName("artifact");

			// Count how many artifacts we get based on the search term
			int numArtifacts = artifactsNl.getLength();

			// Loop through all the results and create artifacts objects.
			for (int i = 0; i < numArtifacts; i++) {
				Node nodeArtifact = artifactsNl.item(i);

				NodeList nlArtifacts = nodeArtifact.getChildNodes();
				Element elementArtifact = (Element) nlArtifacts;

				/**************************************************************************
				 * Get all the basic data needed to create an artifact object
				 **************************************************************************/
				String repositoryId = elementArtifact
						.getElementsByTagName("repositoryId").item(0)
						.getTextContent();
				String artifactId = elementArtifact
						.getElementsByTagName("artifactId").item(0)
						.getTextContent();
				String groupId = elementArtifact
						.getElementsByTagName("groupId").item(0)
						.getTextContent();
				String tkGroupId = splitStringGroup(groupId);
				String version = elementArtifact
						.getElementsByTagName("version").item(0)
						.getTextContent();
				String latestRelease = elementArtifact
						.getElementsByTagName("latestRelease").item(0)
						.getTextContent();
				int extensionCount = elementArtifact.getElementsByTagName(
						"extension").getLength();

				/*******************************************************************************************************
				 * Get only the actual extension of the artifact not the.pom
				 * extension usually NEXUS gives as extension
				 ******************************************************************************************************/
				String extension = null;
				for (int j = 0; j < extensionCount; j++) {
					if (!elementArtifact.getElementsByTagName("extension")
							.item(j).getTextContent().equals("pom"))
						extension = elementArtifact
								.getElementsByTagName("extension").item(j)
								.getTextContent();

				}

				String repositoryURL = CloudSoftwareRepoConstants.NEXUS_URL
						+ CloudSoftwareRepoConstants.NEXUS_ARTIFACT_CONTENT
						+ repositoryId + "/" + tkGroupId + "/" + artifactId
						+ "/" + version + "/" + artifactId + "-" + version
						+ "." + extension;

				String zipURL = CloudSoftwareRepoConstants.NEXUS_URL
						+ CloudSoftwareRepoConstants.NEXUS_ARTIFACT_CONTENT
						+ CloudSoftwareRepoConstants.NEXUS_SHADOW_ZIP + "/"
						+ tkGroupId + "/" + artifactId + "/" + version + "/"
						+ artifactId + "-" + version + "."
						+ "zip-unzip/metadata.xml";

				CloudHttp cHttp = new CloudHttp();

				String retrieveMeta = cHttp.CloudHttpGetRequest(zipURL);

				/**
				 * DEBUG: View the information that go into the artifact object
				 */

				System.out.println("Repository id: " + repositoryId);
				System.out.println("Artifact id: " + artifactId);
				System.out.println("Group id: " + groupId);
				System.out.println("Version: " + version);
				System.out.println("Latest Release: " + latestRelease);
				System.out.println("Extension Count: " + extensionCount);
				System.out.println("Extension: " + extension);
				System.out.println("Artifcat Download URL: " + repositoryURL);

				System.out.println("-----------------------------");

				Artifacts nxArtifact = new Artifacts(repositoryId,
						repositoryId, repositoryURL, tkGroupId, artifactId,
						version, latestRelease, extension, "", "", "", "", "");

				Artifacts finalArtifact = readInternalXML(nxArtifact,
						retrieveMeta);

				// //Artifacts nxArtifact = new Artifacts(repositoryId,
				// repositoryId, repositoryURL, tkGroupId, artifactId,
				// version, latestRelease, extension);
				nxArtifactList.add(finalArtifact);

			}

			return nxArtifactList;
		} catch (RepoExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public Artifacts readInternalXML(Artifacts artifact, String meta)
			throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		InputSource is;

		builder = factory.newDocumentBuilder();
		is = new InputSource(new StringReader(meta));
		Document doc = builder.parse(is);
		NodeList list = doc.getChildNodes();
		Element root = (Element) list.item(0);

		// Search for tags named artifact (inside are stored information
		// about
		// the artifacts)
		/*
		 * NodeList artifactsNl = root.getElementsByTagName("artifact");
		 * 
		 * Node nodeArtifact = artifactsNl.item(0); NodeList nlArtifacts =
		 * nodeArtifact.getChildNodes(); Element elementArtifact = (Element)
		 * nlArtifacts;
		 */

		Element elementArtifact = root;

		String os = elementArtifact.getElementsByTagName("os").item(0)
				.getTextContent();
		String config = elementArtifact.getElementsByTagName("config").item(0)
				.getTextContent();
		String installer = elementArtifact.getElementsByTagName("installer")
				.item(0).getTextContent();
		String hasBin = elementArtifact.getElementsByTagName("binaries")
				.item(0).getTextContent();
		String hasSource = elementArtifact.getElementsByTagName("sources")
				.item(0).getTextContent();

		artifact.setOs(os);
		artifact.setConfig(config);
		artifact.setInstallScript(installer);
		artifact.setHasBin(hasBin);
		artifact.setHasSrc(hasSource);
		return artifact;
	}

	/**
	 * Function that converts the groupId string from a.b into a/b (path)
	 * 
	 * @param groupId
	 *            the group id tou be converted
	 * @return a string that is in the form of a/b
	 */
	public String splitStringGroup(String groupId) {

		String[] token = groupId.split("\\.");
		String newString = token[0];
		int tkLength = token.length;
		for (int i = 1; i < tkLength; i++) {
			newString = newString + "/" + token[i];
		}

		return newString;
	}

	public ArrayList<String> xmlParseIndex(String sres)
			throws ParserConfigurationException, SAXException, IOException {

		ArrayList<String> index = new ArrayList<String>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		InputSource is;

		builder = factory.newDocumentBuilder();
		is = new InputSource(new StringReader(sres));
		Document doc = builder.parse(is);
		NodeList list = doc.getChildNodes();
		Element root = (Element) list.item(0);

		// Search for tags named children
		NodeList childrenNl = root.getElementsByTagName("indexBrowserTreeNode");
		// Count how many children we get from the index
		int numChildren = childrenNl.getLength();
		//System.out.println("Number of Indexed: "+numChildren);
		for (int i = 0; i < numChildren; i++) {
			Node nodeChildren = childrenNl.item(i);
			NodeList nlChildren = nodeChildren.getChildNodes();
			Element elementArtifact = (Element) nlChildren;

			String artName = elementArtifact
					.getElementsByTagName("nodeName").item(0)
					.getTextContent();
			
			//System.out.println("Node: "+artName);
			index.add(artName);
		}

		return index;

	}
}
