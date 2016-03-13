package cy.ac.ucy.linc.CloudSoftwareRepo;

public class CloudSoftwareRepoConstants {
	
	public static final String NEXUS_URL = "http://localhost:8082/nexus/";
	public static final String NEXUS_SERVER_DOWN = "nexus_server_down";

	public static final String NEXUS_STATUS = "service/local/status";

	// NEXUS_KEYWORD_SEARCH: Append at the end the full name or part of the name
	// with * to search
	public static final String NEXUS_KEYWORD_SEARCH = "service/local/lucene/search?q=";

	// NEXUS_ARTIFACT_CONTENT: Append to the end of the url repository id+group
	// id+artifact id+version
	public static final String NEXUS_ARTIFACT_CONTENT = "content/repositories/";
	public static final String NEXUS_SHADOW_ZIP ="camf";

	public static final String NEXUS_UPLOAD_ARTIFACT = "service/local/artifact/maven/content";
	public static final String NEXUS_INDEX_BROWSER ="service/local/repositories/public/index_content/";
	public static final String NEXUS_REPOSITORIES="service/local/repositories/";
	public static final String NEXUS_CONTENT="content/";

	/**
	 * PREDEFINED NEXUS REPOSITORIES
	 */

	
	public static final String REPO_RELEASES = "releases";
	
	
	/**
	 * Temporary Consts
	 */
	
	public static final String FOLDER_DESTINATION = "C:/USERS/EAEC2/repositoryfolder";
	

}
