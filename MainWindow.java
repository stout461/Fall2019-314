import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingConstants;

public class MainWindow extends JFrame
{
	private static final long serialVersionUID = -3880026026104218593L;
	private Primes m_Primes;
	private JTextField tfPrimeFileName;
	private JTextField tfCrossFileName;
	private JLabel lblPrimeCount = new JLabel();
	private JLabel lblCrossCount = new JLabel();
	private JLabel lblLargestPrime;
	private JLabel lblLargestCross;
	private JLabel lblStatus;
	private JLabel middletext = new JLabel();
	
	MainWindow(String name, Primes p)
	{
		
		m_Primes = p;
		
		JFrame dPrimes = new JFrame("Prime Number Generation");
		dPrimes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dPrimes.setSize(1000,400);
		GridBagLayout gridLayout = new GridBagLayout();
		dPrimes.getContentPane().setBackground(new Color(80, 0, 0));
		dPrimes.getContentPane().setLayout(gridLayout);
		
		GridBagConstraints gbcDialog = new GridBagConstraints();
		gbcDialog.fill = GridBagConstraints.HORIZONTAL;
		gbcDialog.anchor = GridBagConstraints.NORTHWEST;
		gbcDialog.ipady = 10;
		gbcDialog.weightx = .5;
		gbcDialog.insets = new Insets(5,5,5,5);
		gbcDialog.gridx = 0;
		gbcDialog.gridy = 0;
		
		
		GridBagConstraints gbcPanel = new GridBagConstraints();
		
		gbcPanel.fill = GridBagConstraints.HORIZONTAL;
		gbcPanel.anchor = GridBagConstraints.WEST;
		gbcPanel.weightx = .5;
		gbcPanel.insets = new Insets(0,0,0,0);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 0;
		
		
		JLabel lblNotice = new JLabel("Warning: B");
		lblNotice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		JPanel pnlPrimes = new JPanel();
		pnlPrimes.setBackground(new Color(255,255,255));
		pnlPrimes.setLayout(new GridBagLayout());
		
		JTextField primesTF = new JTextField();
		gbcPanel.anchor = GridBagConstraints.WEST;
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 0;
		gbcPanel.weightx = .90;
		pnlPrimes.add(primesTF, gbcPanel);
		
		lblPrimeCount.setText(String.valueOf(m_Primes.primeCount()));
		gbcPanel.anchor = GridBagConstraints.EAST;
		lblPrimeCount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		gbcPanel.gridx = 1;
		gbcPanel.gridy = 0;
		gbcPanel.weightx = 1;
		pnlPrimes.add(lblPrimeCount, gbcPanel);
		
		JLabel lblPrimeFile = new JLabel("Prime File");
		gbcPanel.anchor = GridBagConstraints.EAST;
		lblPrimeFile.setFont(new Font("Tahoma", Font.PLAIN, 20));
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 1;
		gbcPanel.weightx = 1;
		pnlPrimes.add(lblPrimeFile, gbcPanel);
		
		JButton load = new JButton("Load");
	
		gbcPanel.anchor = GridBagConstraints.EAST;
		gbcPanel.gridx = 1;
		gbcPanel.gridy = 1;
		gbcPanel.weightx = 1;
		pnlPrimes.add(load, gbcPanel);
		
		JButton save = new JButton("Save");
		
		gbcPanel.anchor = GridBagConstraints.EAST;
		gbcPanel.gridx = 2;
		gbcPanel.gridy = 1;
		gbcPanel.weightx = 1;
		pnlPrimes.add(save, gbcPanel);
		
		JLabel lblCount = new JLabel("Primes File");
		lblPrimeFile.setFont(new Font("Tahoma", Font.PLAIN, 25));
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 1;
		gbcPanel.weightx = 2;
		pnlPrimes.add(lblPrimeFile, gbcPanel);
		
		////////////////////
		dPrimes.add(pnlPrimes,gbcDialog);
		//////////////////
		
		
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		JPanel pnlPairs = new JPanel();
		pnlPairs.setBackground(new Color(255,255,255));
		pnlPairs.setLayout(new GridBagLayout());
		
		JTextField pairTF = new JTextField();
		gbcPanel.anchor = GridBagConstraints.WEST;
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 0;
		gbcPanel.weightx = .90;
		pnlPairs.add(pairTF, gbcPanel);
		
		lblCrossCount.setText(String.valueOf(m_Primes.crossesCount()));
		gbcPanel.anchor = GridBagConstraints.EAST;
		lblCrossCount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		gbcPanel.gridx = 1;
		gbcPanel.gridy = 0;
		gbcPanel.weightx = 1;
		pnlPairs.add(lblCrossCount, gbcPanel);
		
		JLabel lblPairFile = new JLabel("Cross File");
		gbcPanel.anchor = GridBagConstraints.EAST;
		lblPairFile.setFont(new Font("Tahoma", Font.PLAIN, 20));
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 1;
		gbcPanel.weightx = 1;
		pnlPairs.add(lblPairFile, gbcPanel);
		
		
		JButton load1 = new JButton("Load");
		
		gbcPanel.anchor = GridBagConstraints.EAST;
		gbcPanel.gridx = 1;
		gbcPanel.gridy = 1;
		gbcPanel.weightx = 1;
		pnlPairs.add(load1, gbcPanel);
		
		
		
		JButton save1 = new JButton("Save");
		
		gbcPanel.anchor = GridBagConstraints.EAST;
		gbcPanel.gridx = 2;
		gbcPanel.gridy = 1;
		gbcPanel.weightx = 1;
		pnlPairs.add(save1, gbcPanel);
		
		JLabel lblCount1 = new JLabel("Hex File");
		lblPairFile.setFont(new Font("Tahoma", Font.PLAIN, 25));
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 1;
		gbcPanel.weightx = 2;
		pnlPairs.add(lblPairFile, gbcPanel);
		
		gbcDialog.gridy = 1;
		dPrimes.add(pnlPairs,gbcDialog);
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		// 	BOTTOM BOTTOM PANEL	
		
		
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JPanel pnlTex = new JPanel();
		pnlTex.setBackground(new Color(255,255,255));
		pnlTex.setLayout(new GridBagLayout());
		
		JButton gp = new JButton("GENERATE PRIMES");
		gp.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  popupGeneratePrimes();
		      }
		    });
		gbcPanel.anchor = GridBagConstraints.WEST;
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 0;
		gbcPanel.weightx = 1;
		pnlTex.add(gp, gbcPanel);
		
		JButton gpairs = new JButton("GENERATE PAIRS");
		gbcPanel.anchor = GridBagConstraints.EAST;
		gbcPanel.gridx = 2;
		gbcPanel.gridy = 0;
		gbcPanel.weightx = 1;
		pnlTex.add(gpairs, gbcPanel);
		gpairs.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  lblNotice.setText("Generating your pairs");
		    	  lblCrossCount.setText(String.valueOf(m_Primes.crossesCount()+1));
		    	  middletext.setText("The Largest Prime has " + Integer.toString(m_Primes.sizeofLastPrime()) + 
		    				" digits \n The Largest cross has " + Integer.toString(m_Primes.sizeofLastCross().left()) + " and " +
		    					Integer.toString(m_Primes.sizeofLastCross().right()) + ".");
		      }
		    });
		
		middletext.setText("The Largest Prime has " + Integer.toString(m_Primes.sizeofLastPrime()) + 
			" digits \n The Largest cross has " + Integer.toString(m_Primes.sizeofLastCross().left()) + " and " +
				Integer.toString(m_Primes.sizeofLastCross().right()) + ".");
		middletext.setFont(new Font("Tahoma", Font.BOLD, 12));
		gbcPanel.anchor = GridBagConstraints.SOUTH;
		gbcPanel.gridx = 1;
		gbcPanel.gridy = 0;
		gbcPanel.weightx = .90;
		pnlTex.add(middletext, gbcPanel);
		
		gbcDialog.weighty = 1;
		gbcDialog.gridy = 2;
		
		dPrimes.add(pnlTex,gbcDialog);
		
		
		///////////////////////////////////////////////////////////////////////////////////
		
		///////// STATUS
		
		
		///////////////////////////////////////////////////////////////////////////////////
		
		JPanel pnlStatus = new JPanel();
		pnlStatus.setLayout(new GridBagLayout());

		gbcPanel.anchor = GridBagConstraints.SOUTHWEST;
		gbcPanel.weightx = .5;
		gbcPanel.insets = new Insets(1,2,0,0);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 0;

		
		pnlStatus.add(lblNotice, gbcPanel);
		
		gbcDialog.gridy = 3;
		dPrimes.add(pnlStatus, gbcDialog);

		////////////////// Load Primes ------------------------------------------
		
		load.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  FileAccess.loadPrimes(m_Primes, primesTF.getText());
				  lblNotice.setText("Your File is being loaded ");
				  updateStats();
		      }
		    });
		
		/////////////////// Load Cross ----------------------------------------
		
		load1.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  FileAccess.loadCrosses(m_Primes, pairTF.getText());
				  lblNotice.setText("Your File is being loaded ");
				  updateStats();
				  lblCrossCount.setText(String.valueOf(m_Primes.crossesCount()));
		      }
		    });
		
		
		/////////////////////////// Save Primes -------------------------------
		
		save.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  FileAccess.loadCrosses(m_Primes, primesTF.getText());
				  lblNotice.setText("Your File is being loaded ");
				 // updateStats();
		      }
		    });
		
		/////////////////////////// Save Cross --------------------------------
		
		save1.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  FileAccess.saveCrosses(m_Primes, pairTF.getText());
				  lblNotice.setText("Your File is being saved. ");
				
				 // updateStats();
		      }
		    });
		
		
		/////////////////////////// create window ----------------------------
		
		dPrimes.setSize(1000,400);
		dPrimes.pack();
		dPrimes.setVisible(true);
	}

	protected void popupGeneratePrimes()
	{
		
		JDialog dPrimes = new JDialog(this, "Prime Number Generation");
		GridBagLayout gridLayout = new GridBagLayout();
		dPrimes.getContentPane().setBackground(new Color(52, 0, 0));
		dPrimes.getContentPane().setLayout(gridLayout);
		
		GridBagConstraints gbcDialog = new GridBagConstraints();
		gbcDialog.fill = GridBagConstraints.HORIZONTAL;
		gbcDialog.anchor = GridBagConstraints.WEST;
		gbcDialog.ipady = 10;
		gbcDialog.weightx = .5;
		gbcDialog.insets = new Insets(1,2,0,0);
		gbcDialog.gridx = 0;
		gbcDialog.gridy = 0;
		
		GridBagConstraints gbcPanel = new GridBagConstraints();
		gbcPanel.anchor = GridBagConstraints.WEST;
		gbcPanel.weightx = .5;
		gbcPanel.insets = new Insets(1,2,0,0);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 0;
		
		JPanel pnlGenerate = new JPanel();
		pnlGenerate.setLayout(new GridBagLayout());
		
		JLabel lblCount = new JLabel("Number of Primes to Generate");
		lblCount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pnlGenerate.add(lblCount, gbcPanel);
		
		JTextField tfCount = new JTextField();
		lblCount.setLabelFor(tfCount);
		tfCount.setColumns(30);
		gbcPanel.gridx = 1;
		pnlGenerate.add(tfCount, gbcPanel);
		
		JLabel lblStart = new JLabel("Starting Number (does not have to be prime)");
		lblStart.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 1;
		pnlGenerate.add(lblStart, gbcPanel);
		
		JTextField tfStart = new JTextField();
		lblStart.setLabelFor(tfStart);
		tfStart.setColumns(30);
		gbcPanel.gridx = 1;
		pnlGenerate.add(tfStart, gbcPanel);
		
		dPrimes.add(pnlGenerate, gbcDialog);
		
		JPanel pnlButtons = new JPanel();
		pnlButtons.setLayout(new GridBagLayout());
		
		JButton btnGeneratePrimes = new JButton("Generate Primes");
		JLabel lblNotice = new JLabel("Warning: This application is single threaded, and will freeze while generating primes.");
		lblNotice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGeneratePrimes.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      	try
      	{
      		BigInteger start = new BigInteger(tfStart.getText());
      		int count = Integer.parseInt(tfCount.getText());
       		m_Primes.generatePrimes(start, count);
       		lblNotice.setText("Status: Excited. Primes have been generated.");
       		updateStats();
      		dPrimes.dispose();
      	}
      	catch(NumberFormatException ex)
      	{
      		lblNotice.setText("You failed to type in an integer successfully. You are terrible at math. Shame.");
      		dPrimes.dispose();
      	}
      	
      }
    });
		
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 0;
		pnlButtons.add(btnGeneratePrimes, gbcPanel);
		
		JButton btnCancel = new JButton("Cancel Generation");
		btnCancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      	dPrimes.dispose();
      }
    });
		gbcPanel.anchor = GridBagConstraints.EAST;
		gbcPanel.gridx = 1;
		pnlButtons.add(btnCancel, gbcPanel);		
		
		gbcDialog.gridy = 1;
		dPrimes.add(pnlButtons, gbcDialog);
		
		JPanel pnlStatus = new JPanel();
		pnlStatus.setLayout(new GridBagLayout());

		gbcPanel.anchor = GridBagConstraints.SOUTHWEST;
		gbcPanel.weightx = .5;
		gbcPanel.insets = new Insets(1,2,0,0);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 1;

		
		pnlStatus.add(lblNotice, gbcPanel);
		
		gbcDialog.gridy = 2;
		dPrimes.add(pnlStatus, gbcDialog);
		
		dPrimes.setSize(200,200);
		dPrimes.pack(); // Knowing what this is and why it is needed is important. You should read the documentation on this function!
		dPrimes.setVisible(true);		
	}

	// This function updates all the GUI statistics. (# of primes, # of crosses, etc)
	private void updateStats()
	{
		
		lblPrimeCount.setText(String.valueOf(m_Primes.primeCount()));
		//lblCrossCount.setText(String.valueOf(m_Primes.crossesCount()));
		m_Primes.generateTwinPrimes();
		m_Primes.generateHexPrimes();
		middletext.setText("The Largest Prime has " + Integer.toString(m_Primes.sizeofLastPrime()) + 
			" digits \n The Largest cross has " + Integer.toString(m_Primes.sizeofLastCross().left()) + " and " +
				Integer.toString(m_Primes.sizeofLastCross().right()) + ".");
 	}

}
