package cy.ac.ucy.linc.CloudSoftwareRepo.UI;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JTabbedPane;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import cy.ac.ucy.linc.CloudSoftwareRepo.ArtifactZipUtils;
import cy.ac.ucy.linc.CloudSoftwareRepo.CloudSoftwareRepo;
import cy.ac.ucy.linc.CloudSoftwareRepo.CloudSoftwareRepoConstants;
import cy.ac.ucy.linc.CloudSoftwareRepo.Entities.Artifacts;
import cy.ac.ucy.linc.CloudSoftwareRepo.Exceptions.RepoExceptions;
import cy.ac.ucy.linc.CloudSoftwareRepo.XML.Artifact;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JList;

import net.miginfocom.swing.MigLayout;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

@SuppressWarnings("restriction")
public class MarketplaceManagerUI {

	private JFrame frmCloudSoftwareRepository;
	private JTextField txtIntsallScr;
	private JTextField txtConfig;
	private JTextField txtBinaries;
	private JTextField txtSrc;
	private JTextField txtGroupId;
	private JTextField txtArtifactId;
	private JTextField txtVersion;
	private JTextField txtOs;
	private JTextField txtArtifact;
	private JFileChooser fc;

	public ArrayList<Artifacts> index;
	public int artIndex;
	public String configMeta;
	public String installMeta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarketplaceManagerUI window = new MarketplaceManagerUI();
					window.frmCloudSoftwareRepository.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MarketplaceManagerUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCloudSoftwareRepository = new JFrame();
		frmCloudSoftwareRepository
				.setTitle("Cloud Software Repository Manager");
		frmCloudSoftwareRepository.setBounds(100, 100, 734, 472);
		frmCloudSoftwareRepository
				.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmCloudSoftwareRepository.setJMenuBar(menuBar);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmCloudSoftwareRepository.getContentPane().add(tabbedPane,
				BorderLayout.CENTER);

		JPanel pnlUpload = new JPanel();
		tabbedPane.addTab("Upload Artifact", null, pnlUpload, null);
		pnlUpload.setLayout(null);

		JLabel lblSelectInstallationScript = new JLabel("Installation Script");
		lblSelectInstallationScript.setBounds(10, 11, 106, 14);
		pnlUpload.add(lblSelectInstallationScript);

		txtIntsallScr = new JTextField();
		txtIntsallScr.setEditable(false);
		txtIntsallScr.setBounds(150, 8, 177, 20);
		pnlUpload.add(txtIntsallScr);
		txtIntsallScr.setColumns(10);

		final JButton btnOpenInst = new JButton("Choose...");
		btnOpenInst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileFilter ffilter = new FileNameExtensionFilter(
						"Shell Scripts", "sh");
				fc = new JFileChooser();
				fc.setFileFilter(ffilter);
				fc.setAcceptAllFileFilterUsed(false);
				int returnVal = fc.showOpenDialog(frmCloudSoftwareRepository);
				if (returnVal == JFileChooser.APPROVE_OPTION) {

					File file = fc.getSelectedFile();

					System.out.println(file.getName());
					txtIntsallScr.setText(file.getPath());
					installMeta = file.getName();
				}

			}
		});
		btnOpenInst.setBounds(337, 7, 89, 23);
		pnlUpload.add(btnOpenInst);

		JLabel lblConfigurationMetadata = new JLabel("Configuration Metadata");
		lblConfigurationMetadata.setBounds(10, 44, 130, 14);
		pnlUpload.add(lblConfigurationMetadata);

		txtConfig = new JTextField();
		txtConfig.setEditable(false);
		txtConfig.setColumns(10);
		txtConfig.setBounds(150, 41, 177, 20);
		pnlUpload.add(txtConfig);

		final JButton btnOpenConfig = new JButton("Choose...");
		btnOpenConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileFilter ffilter = new FileNameExtensionFilter(
						"XML Document", "xml");
				fc = new JFileChooser();
				fc.setFileFilter(ffilter);
				fc.setAcceptAllFileFilterUsed(false);
				int returnVal = fc.showOpenDialog(frmCloudSoftwareRepository);
				if (returnVal == JFileChooser.APPROVE_OPTION) {

					File file = fc.getSelectedFile();

					System.out.println(file.getName());
					txtConfig.setText(file.getPath());
					configMeta = file.getName();

				}

			}
		});
		btnOpenConfig.setBounds(337, 40, 89, 23);
		pnlUpload.add(btnOpenConfig);

		JLabel lblBinaries = new JLabel("Binaries");
		lblBinaries.setBounds(10, 76, 119, 14);
		pnlUpload.add(lblBinaries);

		txtBinaries = new JTextField();
		txtBinaries.setEditable(false);
		txtBinaries.setColumns(10);
		txtBinaries.setBounds(150, 76, 177, 20);
		pnlUpload.add(txtBinaries);

		final JButton btnOpenBin = new JButton("Choose...");
		btnOpenBin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				fc = new JFileChooser();
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fc.setAcceptAllFileFilterUsed(false);
				int returnVal = fc.showOpenDialog(frmCloudSoftwareRepository);
				if (returnVal == JFileChooser.APPROVE_OPTION) {

					System.out.println(fc.getSelectedFile());
					txtBinaries.setText(fc.getSelectedFile().getPath());
				}

			}
		});
		btnOpenBin.setBounds(337, 74, 89, 23);
		pnlUpload.add(btnOpenBin);

		JLabel lblSources = new JLabel("Sources");
		lblSources.setBounds(10, 113, 119, 14);
		pnlUpload.add(lblSources);

		txtSrc = new JTextField();
		txtSrc.setEditable(false);
		txtSrc.setColumns(10);
		txtSrc.setBounds(150, 110, 177, 20);
		pnlUpload.add(txtSrc);

		final JButton btnOpenSrc = new JButton("Choose...");
		btnOpenSrc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				fc = new JFileChooser();
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fc.setAcceptAllFileFilterUsed(false);
				int returnVal = fc.showOpenDialog(frmCloudSoftwareRepository);
				if (returnVal == JFileChooser.APPROVE_OPTION) {

					System.out.println(fc.getSelectedFile());
					txtSrc.setText(fc.getSelectedFile().getPath());
				}
			}
		});
		btnOpenSrc.setBounds(337, 109, 89, 23);
		pnlUpload.add(btnOpenSrc);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(
				new Color(128, 128, 128)), "Artifact Metadata",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128,
						128, 128)));
		panel.setBounds(10, 197, 408, 164);
		pnlUpload.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(128, 128,
				128)), "GAV", TitledBorder.LEADING, TitledBorder.TOP, null,
				Color.GRAY));
		panel_1.setBounds(10, 26, 388, 84);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblGroupId = new JLabel("Group Id");
		lblGroupId.setBounds(10, 22, 66, 14);
		panel_1.add(lblGroupId);

		txtGroupId = new JTextField();
		txtGroupId.setBounds(10, 47, 99, 20);
		panel_1.add(txtGroupId);
		txtGroupId.setColumns(10);

		JLabel lblArtifactId = new JLabel("Artifact Id");
		lblArtifactId.setBounds(141, 22, 75, 14);
		panel_1.add(lblArtifactId);

		txtArtifactId = new JTextField();
		txtArtifactId.setColumns(10);
		txtArtifactId.setBounds(141, 47, 99, 20);
		panel_1.add(txtArtifactId);

		JLabel lblVersion = new JLabel("Version");
		lblVersion.setBounds(284, 22, 75, 14);
		panel_1.add(lblVersion);

		txtVersion = new JTextField();
		txtVersion.setColumns(10);
		txtVersion.setBounds(279, 47, 99, 20);
		panel_1.add(txtVersion);

		JLabel lblOs = new JLabel("O/S");
		lblOs.setBounds(20, 141, 46, 14);
		panel.add(lblOs);

		txtOs = new JTextField();
		txtOs.setBounds(91, 138, 213, 20);
		panel.add(txtOs);
		txtOs.setColumns(10);

		JButton btnNewButton = new JButton("Upload");

		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setBounds(501, 137, 185, 23);
		pnlUpload.add(btnNewButton);

		JLabel lblOr = new JLabel("- or -");
		lblOr.setBounds(197, 141, 46, 14);
		pnlUpload.add(lblOr);

		JLabel lblSelectArtifact = new JLabel("Select Artifact ");
		lblSelectArtifact.setBounds(10, 161, 119, 14);
		pnlUpload.add(lblSelectArtifact);

		txtArtifact = new JTextField();
		txtArtifact.setEditable(false);
		txtArtifact.setColumns(10);
		txtArtifact.setBounds(150, 158, 177, 20);
		pnlUpload.add(txtArtifact);

		final JButton btnOpenArtifact = new JButton("Choose...");
		btnOpenArtifact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FileFilter ffilter = new FileNameExtensionFilter("Zip file",
						"zip");
				fc = new JFileChooser();
				fc.setFileFilter(ffilter);
				fc.setAcceptAllFileFilterUsed(false);
				int returnVal = fc.showOpenDialog(frmCloudSoftwareRepository);
				if (returnVal == JFileChooser.APPROVE_OPTION) {

					File file = fc.getSelectedFile();

					MarketplaceHandler mh = new MarketplaceHandler();
					String[] gav = mh.guessGav(file.getName());
					System.out.println(file.getName());
					txtArtifact.setText(file.getPath());

					// Show the guessed gav
					txtGroupId.setText(gav[0]);
					txtArtifactId.setText(gav[1]);
					txtVersion.setText(gav[2]);
				}

			}
		});
		btnOpenArtifact.setBounds(337, 157, 89, 23);
		pnlUpload.add(btnOpenArtifact);

		final JCheckBox chkCreate = new JCheckBox("Create Artifact");
		chkCreate.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (chkCreate.isSelected()) {
					btnOpenBin.setEnabled(true);
					btnOpenConfig.setEnabled(true);
					btnOpenInst.setEnabled(true);
					btnOpenSrc.setEnabled(true);
					btnOpenArtifact.setEnabled(false);

				} else {
					btnOpenBin.setEnabled(false);
					btnOpenConfig.setEnabled(false);
					btnOpenInst.setEnabled(false);
					btnOpenSrc.setEnabled(false);
					btnOpenArtifact.setEnabled(true);
				}
			}
		});
		chkCreate.setBounds(501, 51, 130, 23);
		pnlUpload.add(chkCreate);

		JPanel pnlDelete = new JPanel();

		tabbedPane.addTab("Delete Artifact", null, pnlDelete, null);
		pnlDelete.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(128, 128,
				128)), "Artifacts", TitledBorder.LEADING, TitledBorder.TOP,
				null, Color.GRAY));
		panel_2.setBounds(10, 11, 213, 362);
		pnlDelete.add(panel_2);
		panel_2.setLayout(new MigLayout("", "[grow]", "[grow]"));

		final DefaultListModel<String> model = new DefaultListModel<String>();
		model.addElement("");

		final JList<String> lstArtifacts = new JList<String>(model);

		lstArtifacts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel_2.add(lstArtifacts, "cell 0 0,grow");

		JButton btnPublishIndex = new JButton("Publsh Index");
		btnPublishIndex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CloudSoftwareRepo csr = new CloudSoftwareRepo();
				try {
					index = csr.indexRepository();
					System.out.println("Number of results returned: "
							+ index.size());
					model.clear();
					Artifacts emptyArt = new Artifacts("", "", "", "", "", "",
							"", "", "", "", "", "", null);
					model.addElement(emptyArt.artifactId);
					for (int i = 0; i < index.size(); i++) {
						System.out.println(index.get(i).artifactId);
						model.addElement(index.get(i).artifactId + "-"
								+ index.get(i).version);

					}

				} catch (RepoExceptions e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
			}
		});
		btnPublishIndex.setBounds(303, 39, 173, 23);
		pnlDelete.add(btnPublishIndex);

		JButton btnDeleteArtifact = new JButton("Delete Artifact");

		btnDeleteArtifact.setBounds(303, 79, 173, 23);
		pnlDelete.add(btnDeleteArtifact);
		frmCloudSoftwareRepository.getContentPane().setFocusTraversalPolicy(
				new FocusTraversalOnArray(new Component[] { tabbedPane }));

		lstArtifacts.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				artIndex = lstArtifacts.getSelectedIndex() - 1;
				if (artIndex >= 0) {
					System.out.println("Selected Artifact from list: "
							+ index.get(artIndex).artifactId);

				}
			}
		});

		btnDeleteArtifact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("I am going to delete artifact: "
						+ index.get(artIndex).artifactId);
				CloudSoftwareRepo csr = new CloudSoftwareRepo();
				csr.deleteArtifact(index.get(artIndex));

				model.clear();
				try {
					index = csr.indexRepository();
					System.out.println("Number of results returned: "
							+ index.size());
					model.clear();
					Artifacts emptyArt = new Artifacts("", "", "", "", "", "",
							"", "", "", "", "", "", null);
					model.addElement(emptyArt.artifactId);
					for (int i = 0; i < index.size(); i++) {
						System.out.println(index.get(i).artifactId);
						model.addElement(index.get(i).artifactId + "-"
								+ index.get(i).version);

					}
				} catch (RepoExceptions e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int srcint = 1, binint = 1;
				if (chkCreate.isSelected()) {
					MarketplaceHandler mh = new MarketplaceHandler();

					File destinationFolder = new File(
							CloudSoftwareRepoConstants.FOLDER_DESTINATION);
					File desZip = new File(CloudSoftwareRepoConstants.FOLDER_DESTINATION+"/zip");
					if (!destinationFolder.exists()) {
						destinationFolder.mkdir();
						//desZip.mkdir();
						
						System.out
								.println("Destination folder for repositories created...");
					}
					if(!desZip.exists()){
						desZip.mkdir();
						System.out
						.println("Destination folder for zipped artifacts created...");
					}

					String artFolder = CloudSoftwareRepoConstants.FOLDER_DESTINATION
							+ "/"
							+ txtArtifactId.getText()
							+ "-"
							+ txtVersion.getText();
					File aFolder = new File(artFolder);
					if (!aFolder.exists()) {
						aFolder.mkdir();
						System.out
								.println("Destination folder for artifact created @  "
										+ aFolder);
					}
					// Bring the files to a folder

					try {
						if (!txtIntsallScr.getText().equals("")) {
							File src = new File(txtIntsallScr.getText());
							File installScript = new File(artFolder
									+ "/install/");
							installScript.mkdirs();
							mh.copyFile(src, installScript);

						}

						if (!txtConfig.getText().equals("")) {
							File src = new File(txtConfig.getText());
							File configScript = new File(artFolder + "/config/");
							configScript.mkdirs();
							mh.copyFile(src, configScript);
						}

						if (!txtBinaries.getText().equals("")) {
							File src = new File(txtBinaries.getText());
							File binaries = new File(artFolder + "/bin/");
							binaries.mkdirs();
							mh.copyDirectory(src, binaries);
							binint = 0;
						}

						if (!txtSrc.getText().equals("")) {
							File src = new File(txtSrc.getText());
							File sources = new File(artFolder + "/src/");
							sources.mkdirs();
							mh.copyDirectory(src, sources);
							srcint = 0;
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					// Generate metadata.xml
					Artifact artifactXML = new Artifact();
					artifactXML.setGroupId(txtGroupId.getText());
					artifactXML.setArtifactId(txtArtifactId.getText());
					artifactXML.setVersion(txtVersion.getText());

					artifactXML
							.setUploadDate(new SimpleDateFormat("dd-MM-yyyy")
									.format(new Date()));
					artifactXML.setOs(txtOs.getText());

					artifactXML.setInstaller(installMeta);
					artifactXML.setConfig(configMeta);
					artifactXML.setBinaries(binint);
					artifactXML.setSources(srcint);
					try {
						File metadataxml = new File(artFolder + "/metadata.xml");
						JAXBContext jaxbContext = JAXBContext
								.newInstance(Artifact.class);
						Marshaller jaxbMarshaller = jaxbContext
								.createMarshaller();

						// output pretty printed
						jaxbMarshaller.setProperty(
								Marshaller.JAXB_FORMATTED_OUTPUT, true);
						jaxbMarshaller.marshal(artifactXML, metadataxml);
						jaxbMarshaller.marshal(artifactXML, System.out);
					} catch (JAXBException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					// properly zip the files
					ArtifactZipUtils azu = new ArtifactZipUtils();
					String destZip = destinationFolder + "/zip/" + txtArtifactId.getText()
							+ "-" + txtVersion.getText() + ".zip";
					
					try {

						azu.zipFolder(artFolder, destZip);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					// Update the artifact text to point at the location of the
					// zip
					txtArtifact.setText(destZip);
				}

				Map<String, String> parameters = new LinkedHashMap<String, String>();
				parameters.put("r", "releases");
				parameters.put("g", txtGroupId.getText());
				parameters.put("a", txtArtifactId.getText());
				parameters.put("v", txtVersion.getText());
				parameters.put("e", "zip");
				parameters.put("p", "zip");
				parameters.put("hasPom", "false");
				parameters.put("file", txtArtifact.getText());

				CloudSoftwareRepo csr = new CloudSoftwareRepo();
				try {
					csr.uploadArtifact(parameters);
				} catch (RepoExceptions e1) {
					System.out.println(e1);
				}
			}
		});

	}
}
