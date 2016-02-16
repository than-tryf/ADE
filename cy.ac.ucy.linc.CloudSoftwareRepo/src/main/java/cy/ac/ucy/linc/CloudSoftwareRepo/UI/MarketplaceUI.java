package cy.ac.ucy.linc.CloudSoftwareRepo.UI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.DefaultListModel;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import cy.ac.ucy.linc.CloudSoftwareRepo.ArtifactZipUtils;
import cy.ac.ucy.linc.CloudSoftwareRepo.CloudSoftwareRepo;
import cy.ac.ucy.linc.CloudSoftwareRepo.CloudSoftwareRepoConstants;
import cy.ac.ucy.linc.CloudSoftwareRepo.Entities.Artifacts;
import cy.ac.ucy.linc.CloudSoftwareRepo.Exceptions.RepoExceptions;

import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class MarketplaceUI {

	private JFrame frmCloudSoftwareRepository;
	private JTextField txtKeyword;
	private JTextField txtGroupId;
	private JTextField txtArtifactId;
	private JTextField txtVersion;
	private JTextField txtLatest;
	private JTextField txtExtension;

	public ArrayList<Artifacts> srchResults;

	public int artIndex;
	private JTextField txtOS;
	private JTextField txtInstaller;
	private JTextField txtConfig;
	private JTextField txtBin;
	private JTextField txtSrc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarketplaceUI window = new MarketplaceUI();
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
	public MarketplaceUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCloudSoftwareRepository = new JFrame();
		frmCloudSoftwareRepository.setTitle("Cloud Software Repository");
		frmCloudSoftwareRepository.setBounds(100, 100, 900, 500);
		frmCloudSoftwareRepository.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmCloudSoftwareRepository.setJMenuBar(menuBar);

		JPanel pnlSearch = new JPanel();
		pnlSearch.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.GRAY));
		frmCloudSoftwareRepository.getContentPane().add(pnlSearch, BorderLayout.NORTH);
		pnlSearch.setLayout(new MigLayout("", "[1px][][][][][][][][grow][][][][grow]", "[50px]"));

		Component verticalStrut = Box.createVerticalStrut(80);
		pnlSearch.add(verticalStrut, "cell 0 0,growx,aligny top");

		JLabel lblArtifactKeywordSearch = new JLabel("Artifact Keyword Search");
		pnlSearch.add(lblArtifactKeywordSearch, "cell 5 0");

		txtKeyword = new JTextField();
		pnlSearch.add(txtKeyword, "cell 8 0,growx");
		txtKeyword.setColumns(10);

		JButton btnSearchRepository = new JButton("Search Repository");
		pnlSearch.add(btnSearchRepository, "cell 10 0");

		final JButton btnDownloadArtifact = new JButton("Download Artifact");
		btnDownloadArtifact.setEnabled(false);
		pnlSearch.add(btnDownloadArtifact, "cell 11 0");
		
		JButton btnManage = new JButton("Manage Repository");
		btnManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			}
		});
		pnlSearch.add(btnManage, "cell 12 0");

		JPanel pnlSearchRes = new JPanel();
		pnlSearchRes.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 1, true), "Search Results",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		frmCloudSoftwareRepository.getContentPane().add(pnlSearchRes, BorderLayout.WEST);
		pnlSearchRes.setLayout(new MigLayout("", "[250px,grow]", "[1px][grow]"));

		Component horizontalStrut = Box.createHorizontalStrut(250);
		pnlSearchRes.add(horizontalStrut, "cell 0 0,alignx left,growy");

		final DefaultListModel<String> model = new DefaultListModel<String>();
		model.addElement("");

		final JList<String> lstSearchRes = new JList<String>(model);
		lstSearchRes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		pnlSearchRes.add(lstSearchRes, "flowx,cell 0 1,grow");

		JPanel panel = new JPanel();
		frmCloudSoftwareRepository.getContentPane().add(panel, BorderLayout.EAST);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_1);

		JPanel pnlArtifactMetadata = new JPanel();
		pnlArtifactMetadata.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128)), "Artifact Metadata",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		frmCloudSoftwareRepository.getContentPane().add(pnlArtifactMetadata, BorderLayout.CENTER);
		pnlArtifactMetadata.setLayout(new MigLayout("", "[200][200,grow][grow]", "[220,grow][80,grow]"));

		JPanel pnlGAV = new JPanel();
		pnlGAV.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128)), "GAV", TitledBorder.LEADING,
				TitledBorder.TOP, null, Color.GRAY));
		pnlArtifactMetadata.add(pnlGAV, "cell 0 0,grow");
		pnlGAV.setLayout(new MigLayout("", "[grow]", "[][][][][][][][]"));

		JLabel lblGroupId = new JLabel("Group ID:");
		pnlGAV.add(lblGroupId, "cell 0 0");

		txtGroupId = new JTextField();
		pnlGAV.add(txtGroupId, "cell 0 1,growx");
		txtGroupId.setColumns(10);

		JLabel lblArtifactId = new JLabel("Artifact ID:");
		pnlGAV.add(lblArtifactId, "cell 0 2");

		txtArtifactId = new JTextField();
		pnlGAV.add(txtArtifactId, "cell 0 3,growx");
		txtArtifactId.setColumns(10);

		JLabel lblVersion = new JLabel("Version:");
		pnlGAV.add(lblVersion, "cell 0 4");

		txtVersion = new JTextField();
		pnlGAV.add(txtVersion, "cell 0 5,growx");
		txtVersion.setColumns(10);

		JLabel lblLatestVersion = new JLabel("Latest Version:");
		pnlGAV.add(lblLatestVersion, "cell 0 6");

		txtLatest = new JTextField();
		pnlGAV.add(txtLatest, "cell 0 7,growx");
		txtLatest.setColumns(10);
		
		JPanel pnlAdditional = new JPanel();
		pnlAdditional.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128)), "Additional Metadata", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		pnlArtifactMetadata.add(pnlAdditional, "cell 1 0,grow");
		pnlAdditional.setLayout(new MigLayout("", "[grow]", "[][][][][][][]"));
		
		JLabel lblOperatingSystem = new JLabel("Operating System:");
		pnlAdditional.add(lblOperatingSystem, "flowy,cell 0 0,grow");
		
		txtOS = new JTextField();
		pnlAdditional.add(txtOS, "cell 0 1,growx");
		txtOS.setColumns(10);
		
		JLabel lblInstaller = new JLabel("Installer:");
		pnlAdditional.add(lblInstaller, "flowy,cell 0 2");
		
		txtInstaller = new JTextField();
		pnlAdditional.add(txtInstaller, "cell 0 2,growx");
		txtInstaller.setColumns(10);
		
		JLabel lblConfiguration = new JLabel("Configuration:");
		pnlAdditional.add(lblConfiguration, "cell 0 2");
		
		txtConfig = new JTextField();
		pnlAdditional.add(txtConfig, "cell 0 3,growx");
		txtConfig.setColumns(10);
		
		JLabel lblBinFolder = new JLabel("bin folder?");
		pnlAdditional.add(lblBinFolder, "flowx,cell 0 5");
		
		txtBin = new JTextField();
		pnlAdditional.add(txtBin, "cell 0 5");
		txtBin.setColumns(10);
		
		JLabel lblSrcFolder = new JLabel("src folder?");
		pnlAdditional.add(lblSrcFolder, "flowx,cell 0 6");
		
		txtSrc = new JTextField();
		pnlAdditional.add(txtSrc, "cell 0 6");
		txtSrc.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128)), "Extension", TitledBorder.LEADING,
				TitledBorder.TOP, null, Color.GRAY));
		pnlArtifactMetadata.add(panel_1, "cell 0 1,grow");
		panel_1.setLayout(new MigLayout("", "[grow]", "[][]"));

		JLabel lblExtension = new JLabel("Extension:");
		panel_1.add(lblExtension, "cell 0 0");

		txtExtension = new JTextField();
		panel_1.add(txtExtension, "cell 0 1,growx");
		txtExtension.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		pnlArtifactMetadata.add(panel_2, "cell 1 1,grow");
		panel_2.setLayout(new MigLayout("", "[grow]", "[][][]"));
		
		final JButton btnConfigure = new JButton("Go to Configuration");
		btnConfigure.setEnabled(false);
		panel_2.add(btnConfigure, "cell 0 0,alignx center,aligny center");

		btnSearchRepository.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CloudSoftwareRepo csr = new CloudSoftwareRepo();

				try {
					srchResults = csr.keywordSearch(CloudSoftwareRepoConstants.NEXUS_URL
							+ CloudSoftwareRepoConstants.NEXUS_KEYWORD_SEARCH + txtKeyword.getText() + "*");

					System.out.println("Number of results returned: " + srchResults.size());
					model.clear();
					Artifacts emptyArt = new Artifacts("", "", "", "", "", "", "", "", "", "", "", "", null);
					model.addElement(emptyArt.artifactId);
					for (int i = 0; i < srchResults.size(); i++) {
						System.out.println(srchResults.get(i).artifactId);
						model.addElement(srchResults.get(i).artifactId);

					}
				} catch (RepoExceptions e1) {
					// TODO Auto-generated catch block
					System.out.println(e1.getMessage());
					
				}

			}
		});

		ListSelectionListener artListSelection = new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				artIndex = lstSearchRes.getSelectedIndex() - 1;
				if (artIndex < 0) {
					txtArtifactId.setText("");
					txtGroupId.setText("");
					txtVersion.setText("");
					txtLatest.setText("");
					txtExtension.setText("");
					txtConfig.setText("");
					txtInstaller.setText("");
					txtOS.setText("");
					txtBin.setText("");
					txtSrc.setText("");
					btnDownloadArtifact.setEnabled(false);
					btnConfigure.setEnabled(false);	
				} else {
					btnDownloadArtifact.setEnabled(true);
					txtArtifactId.setText(srchResults.get(artIndex).artifactId);
					txtGroupId.setText(srchResults.get(artIndex).groupId);
					txtVersion.setText(srchResults.get(artIndex).version);
					txtLatest.setText(srchResults.get(artIndex).latestRelease);
					txtExtension.setText(srchResults.get(artIndex).extension);
					txtConfig.setText(srchResults.get(artIndex).config);
					txtInstaller.setText(srchResults.get(artIndex).installScript);
					txtOS.setText(srchResults.get(artIndex).os);
					if(srchResults.get(artIndex).hasBin.equals("0")){
						txtBin.setText("No");
					} else {
						txtBin.setText("Yes");
					}
					if(srchResults.get(artIndex).hasSrc.equals("0")){
						txtSrc.setText("No");
					} else {
						txtSrc.setText("Yes");
					}
					
					if(!srchResults.get(artIndex).config.equals(" ") || srchResults.get(artIndex).config!=null ) {
						btnConfigure.setEnabled(true);						
					}
					// btnDownloadart.setEnabled(true);

				}

			}
		};

		lstSearchRes.addListSelectionListener(artListSelection);

		btnDownloadArtifact.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
				CloudSoftwareRepo csr = new CloudSoftwareRepo();
				System.out.println("Download Link: " + srchResults.get(artIndex).repositoryURL);
				String[] token = srchResults.get(artIndex).repositoryURL.split("/");
				System.out.println(token[token.length - 1]);
				//Download the artifact
				csr.downloadArtifact(srchResults.get(artIndex).repositoryURL, "/root/Downloads/"+token[token.length - 1]);
				//Unzip the artifact
				ArtifactZipUtils unzipper = new ArtifactZipUtils();
				unzipper.unzip("/root/Downloads/"+token[token.length - 1], "/root/Downloads/"+srchResults.get(artIndex).artifactId+"-"+srchResults.get(artIndex).version);
				} catch (NullPointerException e2){
					System.out.println("No Artifact selected for download");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IndexOutOfBoundsException ex){
					System.out.println("No Artifact selected for download");
				}
			}
		});
	}
}
