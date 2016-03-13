package cy.ac.ucy.linc.CloudSoftwareRepo.Entities;

public class Artifacts {

	public String repositoryId;
	public String repositoryName;
	public String repositoryURL;
	public String groupId;
	public String artifactId;
	public String version;
	public String latestRelease;
	public String extension;
	public String os;
	public String installScript;
	public String config;
	public String hasBin;
	public String hasSrc;
	
	
	public Artifacts(String repositoryId, String repositoryName, String repositoryURL, String groupId,
			String artifactId, String version, String latestRelease, String extension, String os, String installScript,
			String config, String hasBin, String hasSrc) {
		super();
		this.repositoryId = repositoryId;
		this.repositoryName = repositoryName;
		this.repositoryURL = repositoryURL;
		this.groupId = groupId;
		this.artifactId = artifactId;
		this.version = version;
		this.latestRelease = latestRelease;
		this.extension = extension;
		this.os = os;
		this.installScript = installScript;
		this.config = config;
		this.hasBin = hasBin;
		this.hasSrc = hasSrc;
	}


	public String getRepositoryId() {
		return repositoryId;
	}


	public void setRepositoryId(String repositoryId) {
		this.repositoryId = repositoryId;
	}


	public String getRepositoryName() {
		return repositoryName;
	}


	public void setRepositoryName(String repositoryName) {
		this.repositoryName = repositoryName;
	}


	public String getRepositoryURL() {
		return repositoryURL;
	}


	public void setRepositoryURL(String repositoryURL) {
		this.repositoryURL = repositoryURL;
	}


	public String getGroupId() {
		return groupId;
	}


	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}


	public String getArtifactId() {
		return artifactId;
	}


	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}


	public String getVersion() {
		return version;
	}


	public void setVersion(String version) {
		this.version = version;
	}


	public String getLatestRelease() {
		return latestRelease;
	}


	public void setLatestRelease(String latestRelease) {
		this.latestRelease = latestRelease;
	}


	public String getExtension() {
		return extension;
	}


	public void setExtension(String extension) {
		this.extension = extension;
	}


	public String getOs() {
		return os;
	}


	public void setOs(String os) {
		this.os = os;
	}


	public String getInstallScript() {
		return installScript;
	}


	public void setInstallScript(String installScript) {
		this.installScript = installScript;
	}


	public String getConfig() {
		return config;
	}


	public void setConfig(String config) {
		this.config = config;
	}


	public String getHasBin() {
		return hasBin;
	}


	public void setHasBin(String hasBin) {
		this.hasBin = hasBin;
	}


	public String getHasSrc() {
		return hasSrc;
	}


	public void setHasSrc(String hasSrc) {
		this.hasSrc = hasSrc;
	}
	
	
	
	

	

}
