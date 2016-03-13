package cy.ac.ucy.linc.CloudSoftwareRepo.XML;

import javax.xml.bind.annotation.*;

@SuppressWarnings("restriction")
@XmlRootElement
public class Artifact {
	
	String groupId;
	String artifactId;
	String version;
	String uploadDate;
	String os;
	String installer;
	String config;
	int binaries;
	int sources;
	
	public String getGroupId() {
		return groupId;
	}
	@XmlElement
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getArtifactId() {
		return artifactId;
	}
	@XmlElement
	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}
	public String getVersion() {
		return version;
	}
	@XmlElement
	public void setVersion(String version) {
		this.version = version;
	}
	public String getUploadDate() {
		return uploadDate;
	}
	@XmlElement
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
	public String getOs() {
		return os;
	}
	@XmlElement
	public void setOs(String os) {
		this.os = os;
	}
	public String getInstaller() {
		return installer;
	}
	@XmlElement
	public void setInstaller(String installer) {
		this.installer = installer;
	}
	public String getConfig() {
		return config;
	}
	@XmlElement
	public void setConfig(String config) {
		this.config = config;
	}
	public int getBinaries() {
		return binaries;
	}
	@XmlElement
	public void setBinaries(int binaries) {
		this.binaries = binaries;
	}
	public int getSources() {
		return sources;
	}
	@XmlElement
	public void setSources(int sources) {
		this.sources = sources;
	}
	
	
	

}
