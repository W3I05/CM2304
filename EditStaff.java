/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package msettings;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author fibonacci
 */
public class EditStaff extends javax.swing.JDialog {

    /*non-generated fields*/
    private static String surname, firstname, phoneNum, email, modType; 
    private static Object ID;
    
    //boolean flag array that is initially false
    private final boolean[] flags = new boolean[4];
    
   
   
    //no-parameter constructor
    EditStaff(ArrayList arr) {
       initComponents();
       myInitComponents();
       
        surname = (String)arr.get(0);
        snameTextField.setText(surname);
        
        firstname = (String)arr.get(1);
        fnameTextField.setText(firstname);
        
        ID = arr.get(2);    
        
        phoneNum = (String)arr.get(3);
        phoneNumTextfield.setText(phoneNum);
       
        email = (String)arr.get(4);
        emailTextField.setText(email);
        
        //set input validation flags to true 
        Arrays.fill(flags, true);
       }

   
    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        snameLabel = new javax.swing.JLabel();
        fnameLabel = new javax.swing.JLabel();
        phoneNumLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        modTypeLabel = new javax.swing.JLabel();
        modTypeComboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EDIT STAFF DETAILS");
        setAlwaysOnTop(true);
        setResizable(false);

        snameLabel.setText("Surname :");

        saveButton.setText("SAVE CHANGES ");
        saveButton.setToolTipText("Click to save edited staff details to staff database");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        fnameLabel.setText("First Name :");

        snameTextField.setToolTipText("Enter surname containing letters only , e.g: 'Williams'");
        snameTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                snameTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                snameTextFieldFocusLost(evt);
            }
        });

        fnameTextField.setToolTipText("Enter firstname containing letters only, e.g: 'John'");
        fnameTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fnameTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fnameTextFieldFocusLost(evt);
            }
        });

        phoneNumLabel.setText("Phone Number :");

        emailLabel.setText("Email :");

        modTypeLabel.setText("Staff Type :");

        emailTextField.setToolTipText("Enter valid email , e.g: 'jameswhite1994@hotmail.com'");
        emailTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailTextFieldFocusLost(evt);
            }
        });

        phoneNumTextfield.setToolTipText("Enter valid 10/11 digit phone number , e.g: landline: 02082990482 or mobile: 07700420030");
        phoneNumTextfield.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                phoneNumTextfieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                phoneNumTextfieldFocusLost(evt);
            }
        });

        modTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Internal", "External", " " }));
        modTypeComboBox.setToolTipText("Select whether staff member is internal or external");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(modTypeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(modTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(210, 210, 210)
                                .addComponent(saveButton)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(phoneNumLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(phoneNumTextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fnameLabel)
                                    .addComponent(snameLabel)
                                    .addComponent(emailLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fnameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                                    .addComponent(snameTextField)
                                    .addComponent(emailTextField))))
                        .addGap(0, 74, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(snameLabel)
                    .addComponent(snameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fnameLabel)
                    .addComponent(fnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNumTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneNumLabel))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modTypeLabel)
                    .addComponent(modTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(saveButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    //MY BACK-END CODE
    //######################################################################################################
    public final void myInitComponents() {
        setLocationRelativeTo(null);
}
    
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        
        if(inputsValid(flags)){           
            
             //get all information entered in textfields and add to database
            surname = snameTextField.getText().toLowerCase();
            surname = surname.substring(0, 1).toUpperCase() + surname.substring(1);
            firstname = fnameTextField.getText().toLowerCase();
            firstname = firstname.substring(0, 1).toUpperCase() + firstname.substring(1);
            phoneNum = phoneNumTextfield.getText().toLowerCase();
            phoneNum = phoneNum.substring(0, 1).toUpperCase() + phoneNum.substring(1);
            email = emailTextField.getText().toLowerCase();
            email = email.substring(0, 1).toUpperCase() + email.substring(1);
            modType = (String)modTypeComboBox.getSelectedItem();
            modType = modType.substring(0, 1).toUpperCase() + modType.substring(1); 
            
            //open database
            StaffDatabase sdb = new StaffDatabase();
            sdb.insertStaff(surname, firstname, ID, phoneNum, email, modType);

            //close the dialog box and return to 'Manage Users' window       
            dispose();
        }else{
            String invalidInput = "Please enter correct input in the highlighted fields(red)."
                                 +"\n Check that every field is filled before proceeding";
            JOptionPane.showMessageDialog(null, invalidInput, "Invalid Input", JOptionPane.PLAIN_MESSAGE);
        }
               
        
        
    }                                          

      
    
    private void snameTextFieldFocusLost(java.awt.event.FocusEvent evt) {                                         
        String snameRegex = "[a-zA-Z]+";
        if((snameTextField.getText().matches(snameRegex))){                        
            flags[0] = true; 
        }else{            
            snameTextField.setForeground(Color.RED);
            flags[0] = false;
        }
      
    }                                        

    private void fnameTextFieldFocusLost(java.awt.event.FocusEvent evt) {                                         
         String fnameRegex = "[a-zA-Z]+";
        if((fnameTextField.getText().matches(fnameRegex))){                       
            flags[1] = true;
        }else{            
            fnameTextField.setForeground(Color.RED); 
            flags[1] = false;
        }
        
    }                                        

    private void emailTextFieldFocusLost(java.awt.event.FocusEvent evt) {                                         
        String emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if((emailTextField.getText().matches(emailRegex))){                        
            flags[2] = true;
        }else{            
            emailTextField.setForeground(Color.RED);
            flags[2] = false;
        }
        
    }                                        

    private void phoneNumTextfieldFocusLost(java.awt.event.FocusEvent evt) {                                            
        String NumRegex = "(\\+|00)?(44)?([\\d]{10,11})";
        if((phoneNumTextfield.getText().matches(NumRegex))){
            flags[3] = true;
        }else{            
            phoneNumTextfield.setForeground(Color.RED);
            flags[3] = false;
        }
        
    }                                           
 
    private void snameTextFieldFocusGained(java.awt.event.FocusEvent evt) {                                           
        snameTextField.setForeground(Color.BLACK);
        SwingUtilities.invokeLater( new Runnable() {
                @Override
                public void run() {
                        snameTextField.selectAll();		
                }});
    }                                          

    private void fnameTextFieldFocusGained(java.awt.event.FocusEvent evt) {                                           
        fnameTextField.setForeground(Color.BLACK); 
        SwingUtilities.invokeLater( new Runnable() {
                @Override
                public void run() {
                        fnameTextField.selectAll();		
                }});
    }                                          

    private void emailTextFieldFocusGained(java.awt.event.FocusEvent evt) {                                           
        emailTextField.setForeground(Color.BLACK);
        SwingUtilities.invokeLater( new Runnable() {
                @Override
                public void run() {
                        emailTextField.selectAll();		
                }});
    }                                          

    private void phoneNumTextfieldFocusGained(java.awt.event.FocusEvent evt) {                                              
        phoneNumTextfield.setForeground(Color.BLACK); 
        SwingUtilities.invokeLater( new Runnable() {
                @Override
                public void run() {
                        phoneNumTextfield.selectAll();		
                }});
    }                                             

    /**checks if all inputs are valid
     * @param flags array containing boolean values for the input fields
     * @return True if all are valid False otherwise
     */
    public boolean inputsValid(boolean[] flags){
        boolean b = true;
        for(boolean flag : flags){
            if(flag == false){
                b = false;
            }
        }
        return b;    
    } 
    
     
//#############################################################################################################
    
  
    // Variables declaration - do not modify                     
    private javax.swing.JLabel emailLabel;
    private final javax.swing.JTextField emailTextField = new javax.swing.JTextField();
    private javax.swing.JLabel fnameLabel;
    private final javax.swing.JTextField fnameTextField = new javax.swing.JTextField();
    private javax.swing.JComboBox modTypeComboBox;
    private javax.swing.JLabel modTypeLabel;
    private javax.swing.JLabel phoneNumLabel;
    private final javax.swing.JTextField phoneNumTextfield = new javax.swing.JTextField();
    private final javax.swing.JButton saveButton = new javax.swing.JButton();
    private javax.swing.JLabel snameLabel;
    private final javax.swing.JTextField snameTextField = new javax.swing.JTextField();
    // End of variables declaration                   
}
