//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.12 at 09:24:04 PM EEST 
//


package cy.ac.ucy.linc.CloudSoftwareRepo.XML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="groupId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="artifactId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="uploadDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="os" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="installer" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="config" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="binaries" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sources" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "groupId",
    "artifactId",
    "version",
    "uploadDate",
    "os",
    "installer",
    "config",
    "binaries",
    "sources"
})
@XmlRootElement(name = "Artifact")
public class Artifact {

    @XmlElement(required = true)
    protected String groupId;
    @XmlElement(required = true)
    protected String artifactId;
    @XmlElement(required = true)
    protected String version;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar uploadDate;
    @XmlElement(required = true)
    protected String os;
    @XmlElement(required = true)
    protected String installer;
    @XmlElement(required = true)
    protected String config;
    protected int binaries;
    protected int sources;

    /**
     * Gets the value of the groupId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * Sets the value of the groupId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupId(String value) {
        this.groupId = value;
    }

    /**
     * Gets the value of the artifactId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArtifactId() {
        return artifactId;
    }

    /**
     * Sets the value of the artifactId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArtifactId(String value) {
        this.artifactId = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the uploadDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUploadDate() {
        return uploadDate;
    }

    /**
     * Sets the value of the uploadDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUploadDate(XMLGregorianCalendar value) {
        this.uploadDate = value;
    }

    /**
     * Gets the value of the os property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOs() {
        return os;
    }

    /**
     * Sets the value of the os property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOs(String value) {
        this.os = value;
    }

    /**
     * Gets the value of the installer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstaller() {
        return installer;
    }

    /**
     * Sets the value of the installer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstaller(String value) {
        this.installer = value;
    }

    /**
     * Gets the value of the config property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfig() {
        return config;
    }

    /**
     * Sets the value of the config property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfig(String value) {
        this.config = value;
    }

    /**
     * Gets the value of the binaries property.
     * 
     */
    public int getBinaries() {
        return binaries;
    }

    /**
     * Sets the value of the binaries property.
     * 
     */
    public void setBinaries(int value) {
        this.binaries = value;
    }

    /**
     * Gets the value of the sources property.
     * 
     */
    public int getSources() {
        return sources;
    }

    /**
     * Sets the value of the sources property.
     * 
     */
    public void setSources(int value) {
        this.sources = value;
    }

}
