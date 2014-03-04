import java.io.File;
import java.io.PrintWriter;

import javax.swing.table.DefaultTableModel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Vanessa
 */

public class ModuleBreakdown extends javax.swing.JFrame {

	// Variables declaration - do not modify
	private String[] moduleInfo, inStaffNames; //exStaffNames; //add if wanted
	private String[][] staffInfo, internalStaff, externalStaff;
	private String[] paperNames;
	private String[][] forms;
	private String module_code = "cm2304"; //read in from List of Module window
	private String module_name, module_leader, formSelected;
	
	private javax.swing.Box.Filler filler1;
	// assessment paper specific variables
	private javax.swing.JLabel assessmentPaperLbl;
	private javax.swing.JComboBox assessmentPaperComboBox;
	private javax.swing.JButton openFormButton;
	private javax.swing.JScrollPane formTableScrollPane1;
	private javax.swing.JTable formTable;
	// general buttons
	private javax.swing.JButton mainMenuButton, logOutButton;
	private javax.swing.JButton saveChangesButton, sendEmailButton;
	// general module info labels
	private javax.swing.JLabel windowTitleLbl;
	private javax.swing.JLabel modNameLbl, modNameValue;
	private javax.swing.JLabel modCodeLbl, modCodeValue;
	private javax.swing.JLabel modLeaderLbl;
	private javax.swing.JComboBox modLeaderComboBox;
	
	private DefaultTableModel formTableModel;
	// End of variables declaration


	/**
	 * Creates new form ModuleTest
	 */
	public ModuleBreakdown() {
		// retrieve and sort information from txt files
		retrieveStaff();
		retrieveModule();
		retrieveForms();
		// initialise and display window
		initComponents();
	}
	
	private void initComponents() {
		// Main Menu Button
		mainMenuButton = new javax.swing.JButton();
		mainMenuButton.setText("Main Menu");
		mainMenuButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mainMenuButtonActionPerformed(evt);
			}
		});
		
		// Log Out Button
		logOutButton = new javax.swing.JButton();
		logOutButton.setText("Log Out");
		logOutButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				logOutButtonActionPerformed(evt);
			}
		});
		
		// Save Changes Button - added actionPerformed method
		saveChangesButton = new javax.swing.JButton();
		saveChangesButton.setText("Save Changes to Form");
		saveChangesButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//saveChangesButtonActionPerformed(evt);
				saveChangesButtonActionPerformed();
			}
		});
		
		// Send Email Button
		sendEmailButton = new javax.swing.JButton();
		sendEmailButton.setText("Send Email");
		sendEmailButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				sendEmailButtonActionPerformed(evt);
			}
		});
		
		// Open Assessment Paper Form (Table) Button - added actionPerformed method
		openFormButton = new javax.swing.JButton();
		openFormButton.setText("OPEN FORM");
		openFormButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				openFormButtonActionPerformed(evt);
				formTableModel.fireTableDataChanged();
			}
		});

		// Labels:
		windowTitleLbl = new javax.swing.JLabel();
		windowTitleLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); 
		windowTitleLbl.setText("Module Information");
		
		modCodeLbl = new javax.swing.JLabel();
		modCodeLbl.setText("Module Code:");
		
		modCodeValue = new javax.swing.JLabel();
		modCodeValue.setText(module_code);

		modNameLbl = new javax.swing.JLabel();
		modNameLbl.setText("Module Name:");

		modNameValue = new javax.swing.JLabel();
		modNameValue.setText("blah");
		
		modLeaderLbl = new javax.swing.JLabel();
		modLeaderLbl.setText("Module Leader:");
		
		modLeaderComboBox = new javax.swing.JComboBox();
		//edited below
		//modLeaderComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
		modLeaderComboBox.setModel(new javax.swing.DefaultComboBoxModel(inStaffNames));
		
		assessmentPaperLbl = new javax.swing.JLabel();
		assessmentPaperLbl.setText("Assessment Paper:");
		
		assessmentPaperComboBox = new javax.swing.JComboBox();
		//assessmentPaperComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
		assessmentPaperComboBox.setModel(new javax.swing.DefaultComboBoxModel(paperNames));
		
		// default Table
		formTableModel = new javax.swing.table.DefaultTableModel(
				new Object [][] {},
				new String [] {
						"Form Stage", "Staff Name", "Deadline", "Date Completed"
				});
		
		// Form (Table) layout structure
		formTable = new javax.swing.JTable();
		formTable.getTableHeader().setReorderingAllowed(false);
		formTableScrollPane1 = new javax.swing.JScrollPane();
		
		formTable.setModel( formTableModel );
		formTableScrollPane1.setViewportView(formTable);
		
		// End of Form Table layout structure
		
		filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 20));
		
		arrangeComponents();
	}
	
	/**
	 * This method is called from within the constructor to initialise the form.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	// properties grouped by component
	private void arrangeComponents() {
		// frame settings
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBounds(new java.awt.Rectangle(0, 0, 0, 0));
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		setPreferredSize(new java.awt.Dimension(800, 600));
		setResizable(false);
		
		// sets up the layout for all components
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addGap(56, 56, 56)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(assessmentPaperLbl)
												.addComponent(modLeaderLbl)
												.addComponent(modNameLbl)
												.addComponent(modCodeLbl)))
												.addGroup(layout.createSequentialGroup()
														.addContainerGap()
														.addComponent(windowTitleLbl)))
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																.addGroup(layout.createSequentialGroup()
																		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(modCodeValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																				.addComponent(modNameValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																				.addGap(120, 120, 120))
																				.addGroup(layout.createSequentialGroup()
																						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																								.addComponent(assessmentPaperComboBox, 0, 345, Short.MAX_VALUE)
																								.addComponent(modLeaderComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(openFormButton)
																								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
																								.addGroup(layout.createSequentialGroup()
																										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
																												.addGroup(layout.createSequentialGroup()
																														.addComponent(mainMenuButton)
																														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																														.addComponent(logOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
																														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																																.addGroup(layout.createSequentialGroup()
																																		.addGap(261, 261, 261)
																																		.addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
																																		.addGroup(layout.createSequentialGroup()
																																				.addGap(27, 27, 27)
																																				.addComponent(formTableScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE))))
																																				.addGap(0, 25, Short.MAX_VALUE))
																																				.addGroup(layout.createSequentialGroup()
																																						.addGap(251, 251, 251)
																																						.addComponent(saveChangesButton)
																																						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																						.addComponent(sendEmailButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
																																						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(16, 16, 16)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(windowTitleLbl)
								.addComponent(mainMenuButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(logOutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(modCodeLbl)
										.addComponent(modCodeValue))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(modNameLbl)
												.addComponent(modNameValue))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(modLeaderLbl)
														.addComponent(modLeaderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGap(18, 18, 18)
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(assessmentPaperLbl)
																.addComponent(assessmentPaperComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(openFormButton))
																.addGap(18, 18, 18)
																.addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(formTableScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(27, 27, 27)
																.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(saveChangesButton)
																		.addComponent(sendEmailButton))
																		.addGap(141, 141, 141))
				);

		pack();
	}// </editor-fold>                        

	private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
		// TODO add your handling code here:
		// read out all changed info to modules.txt and forms.txt files
		ModuleBreakdown.this.dispose();
	}
	
	private void mainMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
		// TODO add your handling code here:
		// open Main menu GUI frame or set it to visible
		MainMenuGUI nextWindow = new MainMenuGUI();
		nextWindow.setVisible(true);
		ModuleBreakdown.this.dispose();
	}

	// selects the assessment paper by name
	// retrieves the corresponding information from form table
	private void openFormButtonActionPerformed(java.awt.event.ActionEvent evt) {
		formSelected = (String)assessmentPaperComboBox.getSelectedItem();
		int formNo = 0;
		for ( int i=0; i<forms.length; i++)
		{
			if (forms[i][1].equals(formSelected))
			{
				formNo = i;
			}
		}
		
		String IM_name = "";
		String EM_name = "";
		
		// retrieves staff names from internal and external staff lists 
		if ( !forms[formNo][3].equals("") ){
			for ( int v=0; v<internalStaff.length; v++){
				if( internalStaff[v][0].equals(forms[formNo][3])){
					IM_name = internalStaff[v][1];
				}
			}
		}
		
		if ( !forms[formNo][4].equals("") ){
			for ( int w=0; w<externalStaff.length; w++){
				if( externalStaff[w][0].equals(forms[formNo][4])){
					EM_name = externalStaff[w][1];
				}
			}
		}
		
		while ( formTableModel.getRowCount() != 0 ){
			formTableModel.removeRow(0);
		}
		
		if ( formSelected.equals("select a paper") ){
			return;
		}
		
		int numRows = 0;
		System.out.println(formSelected + " selected. Opening form...");
		// displays only selected entries for a ASSESSMENT PAPER FORM depending on
		// whether the MODULE has a weighting of over 50% towards degree
		// do not change the order of the rows added below:
		formTableModel.addRow( new Object[]{"Internal Moderation", IM_name, forms[formNo][4], forms[formNo][8]} );
		formTableModel.addRow( new Object[]{"Reviewed by Module Leader", moduleInfo[5], forms[formNo][5], forms[formNo][9]});
		if(moduleInfo[6].equals("50%+")){
			formTableModel.addRow( new Object[]{"External Moderation", EM_name, forms[formNo][6], forms[formNo][10]});
		}
		formTableModel.addRow( new Object[]{"Final Deadline for Checking", "E.L.O.", forms[formNo][7], forms[formNo][11]});
		
		/*formTableModel = new DefaultTableModel(){
		for( int col=0; col<formTableModel.getColumnCount(); col++){
			//formTableModel.isCellEditable(0, col);
			public boolean isCellEditable( int row, int column ){
				return false;
			}
		}
			public boolean isCellEditable( int row, int column ){
				return false;
			}
		};*/
		formTable.setModel( formTableModel );
		System.out.println(formSelected + " form opened.\n");
		
		return;
		
	}
	
	private void sendEmailButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                
		// TODO add your handling code here:
	}
	
	//private void saveChangesButtonActionPerformed(java.awt.event.ActionEvent evt){
	private void saveChangesButtonActionPerformed(){
				// TODO add your handling code here:
		System.out.println( "savechanges method reached");
		
		String nameSelected = (String)modLeaderComboBox.getSelectedItem();
		if( !moduleInfo[5].equals(nameSelected) ){
			moduleInfo[5] = nameSelected;
			System.out.println("new module leader selected: "+moduleInfo[5]);
		}
		
		formTableModel.fireTableDataChanged();
		saveFormTableInfo();
		
		return;
	}
	
	// module:
	//[0] = module name; [1] = module code; [2] = credits; [3] = num coursework; [4] = num exams
	//[5] = module leader; [6] = form type
	private void retrieveModule()
	{
		Database db = new Database();
		db.initDatabase("modules.txt");
		
		moduleInfo = db.getModule( "module code", module_code );
		String module_leader = moduleInfo[5];
		String module_name = moduleInfo[0];

		db.close();
	}	
	
	// reads all staff information into table
	private void retrieveStaff()
	{
		Database db = new Database();
		db.initDatabase("staff.txt");
		staffInfo = db.getAllStaff();
		System.out.println( "staff table copied\n");
		db.close();
		setInternalExternalTables();
	}
	
	/*
	 * Called form the retrieveStaff method
	 * This method sorts the staffInfo table into
	 * separate tables of internal and external staff consisting of:
	 * [0] = staffID; [1] = firstName||lastName
	 * and a list of internal staff names only
	 */
	private void setInternalExternalTables(){
		//retrieveStaff();
		int totalInStaff = 0;
		int totalExStaff = 0;
		// counts the number of staff in each type respectively
		for( int i=0 ; i<staffInfo.length; i++) {
			if( staffInfo[i][5].equals("internal")){
				totalInStaff++;
			}
			else if( staffInfo[i][5].equals("external")){
				totalExStaff++;
			}
			else {System.out.println("duplicateStaff: neither internal or external listed");}
		}
		
		int currentIS = 0;
		int currentES = 0;
		inStaffNames = new String[totalInStaff];
		//exStaffNames = new String[totalExStaff];
		internalStaff = new String[totalInStaff][2];
		externalStaff = new String[totalExStaff][2];
		
		// init staff type tables containing [0] = staffID; [1] = firstName+" "+lastName
		for( int i=0 ; i<staffInfo.length; i++) {
			String ID = staffInfo[i][4];
			String first = staffInfo[i][0];
			String last = staffInfo[i][1];
			if( staffInfo[i][5].equals("internal")){
				inStaffNames[currentIS] = first.concat(" ").concat(last);
				internalStaff[currentIS][0] = ID;
				internalStaff[currentIS][1] = inStaffNames[currentIS]; //first.concat(" ").concat(last);
				System.out.println(internalStaff[currentES][0] +" "+internalStaff[currentES][1]+" added to internalStaff list");
				currentIS++;
			}
			else if( staffInfo[i][5].equals("external")){
				//extra functionality: list of external staff names only
				//exStaffNames[currentES] = first.concat(" ").concat(last);
				externalStaff[currentES][0] = ID;
				externalStaff[currentES][1] = first.concat(" ").concat(last);
				System.out.println(externalStaff[currentES][0] +" "+externalStaff[currentES][1]+" added to externalStaff list");
				currentES++;
			}
		}
		System.out.println();
		return;
	}

	// forms:
	//[0] moduleCode; [1] paperName; [2] ELODeadline; [3] EMDeadline; 
	//[4] MLDeadline; [5] IMDeadline; [6] EM_ID; [7] IM_ID;
	//[8] ELOCompleted; [9] EMCompleted; [10] MLCompleted; [11] IMCompleted
	private void retrieveForms(){
		Database db = new Database();
		db.initDatabase("forms.txt");
		forms = db.getModuleForms(module_code);
		db.close();
		
		paperNames = new String[forms.length+1];
		paperNames[0] = "select a paper";
		for(int i=0; i<forms.length; i++)
		{
			paperNames[i+1] = forms[i][1];
			System.out.println(paperNames[i+1]+" added to drop down list");
		}
		System.out.println();
		return;
	}
	
	// called from within Save Changes button
	private void saveModInfo(){
		//TODO fill here;
		return;
	}
	
	private void saveFormTableInfo(){
		//DefaultTableModel dtm = (DefaultTableModel) formTable.getModel();
		//int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
		int nRow = formTableModel.getRowCount(), nCol = formTableModel.getColumnCount();
				
		Object[][] tableData = new String[nRow][nCol];
		String s ;
		StringBuffer s1 = new StringBuffer();
		//attempt to write to file
		try{
			PrintWriter fw = new PrintWriter(new File("output.txt"));
			s1.append(module_code+","+formSelected+",");
			s1.append(tableData[1][1]+","+tableData[3][1]+",");
			for(int i =0; i <nRow; i++){
				for(int j = 2; j < nCol; j++){
					tableData[i][j] = (String)formTableModel.getValueAt(i,j);
					System.out.println("[i][j]: "+formTableModel.getValueAt(i,j) );
					//s =tableData[i][j].toString();

					s1.append(tableData[i][j]);
					if( !(i == 4) && !(j == 4) ){
						s1.append(",");
					}
					else if ( (i==4) && (j==4) ){
						s1.append(";");
					}
					//s1.append(",");
				}
				//fw.println(s1);
			}
			fw.println("moduleCode,paperName,Module Leader,IM_ID,EM_ID,IMDeadline,MLDeadline,"+
					"EMDeadline,ELODeadline,IMCompleted,MLCompleted,EMCompleted,ELOCompleted");
			fw.println(s1);
			fw.close();
		}
		catch(Exception f ){
			System.out.println("something went wrong   " + f);
		}
		System.out.println( "Updated Form Table saved to file ");
		return;
	}
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
				
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			// main functionality
			
			
			// look and feel - do not modify
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
			
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(ModuleBreakdown.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ModuleBreakdown.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ModuleBreakdown.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ModuleBreakdown.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		//Create and display the form 
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ModuleBreakdown().setVisible(true);
			}
		});
	}
	
}
