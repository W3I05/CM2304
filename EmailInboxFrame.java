import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aly Abdelfattah-Elmakhzangui
 */
public class EmailInboxFrame extends javax.swing.JFrame {
    
    protected byte nextState; // indication of which page is next
    protected int state;
    protected Message message; // this message is the one selected to open up to read
    private EmailAttachmentReceiver receiveEmail; // a pointer to EmailAttachmentReceiver, allows for increased functionality

    // create the frame and all the components
    public EmailInboxFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        deleteMailButton = new javax.swing.JButton();
        sendEmailButton = new javax.swing.JButton();
        openEmailButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        logOutButton = new javax.swing.JButton();
        mainMenuButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jButton4.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        deleteMailButton.setText("Delete Email");
        deleteMailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMailButtonActionPerformed(evt);
            }
        });

        sendEmailButton.setText("Send Email");
        sendEmailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendEmailButtonActionPerformed(evt);
            }
        });

        openEmailButton.setText("Open Email");
        openEmailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openEmailButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel3.setText("Email Inbox");

        logOutButton.setText("Log Out");
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutHandler(evt);
            }
        });

        mainMenuButton.setText("Main Menu");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "From", "Date", "Subject", "Attachment"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jTable1.setShowGrid(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(331, 331, 331)
                        .addComponent(mainMenuButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(logOutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(46, 46, 46))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(openEmailButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(sendEmailButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(deleteMailButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(219, 219, 219))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(mainMenuButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logOutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(openEmailButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sendEmailButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteMailButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // what to do if the send email button is pressed
    private void sendEmailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendEmailButtonActionPerformed
        
        // get the position in the table of the selected row
        int selectedMail = jTable1.getSelectedRow();
        
        // number of selected rows
        int numberSelected = jTable1.getSelectedRowCount();
        
        // can only select 1 row at a time, and only rows with values in them
        if (jTable1.getValueAt(selectedMail, 0) != null && numberSelected == 1) {
            nextState = 4;
            state = 2;
        }
        
        else {
            JOptionPane.showMessageDialog(new EmailInboxFrame(), 
                    "Please do not select emtpy or multiple rows", 
                    "Selection error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_sendEmailButtonActionPerformed
    
    // what to do if someone wants to open an email
    private void openEmailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openEmailButtonActionPerformed
        
        // get the position in the table of the selected row
        int selectedMail = jTable1.getSelectedRow();
        
        // number of selected rows
        int numberSelected = jTable1.getSelectedRowCount();
        
        // can only select 1 row at a time, and only rows with values in them
        if (jTable1.getValueAt(selectedMail, 0) != null && numberSelected == 1) {
            nextState = 5;
            state = 3;
        }
        
        else {
            JOptionPane.showMessageDialog(new EmailInboxFrame(), 
                    "Please do not select emtpy or multiple rows", 
                    "Selection error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_openEmailButtonActionPerformed

    private void logOutHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutHandler
        // tell main area to log out
        nextState = -1;
        state = 1;
    }//GEN-LAST:event_logOutHandler

    private void deleteMailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMailButtonActionPerformed
        
        // number of selected rows
        int[] toBeDeleted = jTable1.getSelectedRows();
        
        // check that none of the rows set tobe deleted have already been deleted
        boolean goAhead = true;
        for (int i = 0; i < toBeDeleted.length; i++) {
            if (jTable1.getValueAt(toBeDeleted[i], 0) == null) {
                goAhead = false;
                break;
            }
        }
        
        if (goAhead) {
            for (int i = 0; i < toBeDeleted.length; i++) {
                try {
                    receiveEmail.deleteEmail(receiveEmail.arrayMessages[receiveEmail.arrayMessages.length - toBeDeleted[i] - 1]);
                    for (int j = 0; j < 4; j++) {
                        // to represent deletion in the table, remove values
                        jTable1.setValueAt(null, toBeDeleted[i], j);
                    }
                } 
                
                catch (MessagingException ex) {
                    Logger.getLogger(EmailInboxFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        jTable1.updateUI();
    }//GEN-LAST:event_deleteMailButtonActionPerformed
    
    protected void emailInput() throws IOException {

        try {
            // get all information from the inbox
            receiveEmail.readInbox();
            receiveEmail.getFromAddress();
            receiveEmail.getDate();
            receiveEmail.getSubject();
            receiveEmail.messagesAttachment();
            receiveEmail.messagesContent();
        }

        catch(MessagingException e) {
            System.out.println("NOPE");
        }
        
        // set data in the table
        int count = receiveEmail.arrayMessages.length - 1;
        for (int i = 0; i < receiveEmail.arrayMessages.length; i++) {
            jTable1.setValueAt(receiveEmail.subjectArray.get(i), count, 2);
            jTable1.setValueAt(receiveEmail.fromAddresses.get(i), count, 0);
            jTable1.setValueAt(receiveEmail.dateArray.get(i), count, 1);
            
            // make attachments neater by removing path
            String attachment = receiveEmail.attachmentArray.get(i);
            String toAttach = "";
            for (int j = 0; j < attachment.length(); j++) {
                if (attachment.charAt(j) == ',') {
                    String temp = attachment.substring(0, j);
                    if (temp.contains("/")) {
                        int cutOff = temp.lastIndexOf("/");
                        temp = temp.substring(cutOff + 1);
                        toAttach += temp + ",";
                    }
                }
            }
            
            
            jTable1.setValueAt(toAttach, count, 3);
            
            // count-- allows the emails to be presented in order of newest to oldest
            count--;
        }
    }
    
    protected boolean canConnect(String a, String b) throws ParseException {
        
        // essentailly check that the email address provided is valid
        receiveEmail = new EmailAttachmentReceiver();
        receiveEmail.setLoginDetails(a, b);
        boolean accepted = receiveEmail.connect();
        if (!accepted){
            System.out.println("HI");
            return false;
        }
        
        return true;
    }
    
    // use to determine which email address to send email to
    protected String selectedEmails() {
        int selectedPos = jTable1.getSelectedRow();
        String selectedMail = receiveEmail.fromAddresses.get(receiveEmail.arrayMessages.length - selectedPos - 1);
        return selectedMail;
    }
    
    // stores and returns all the relevant data about the email the user wants to open and read
    protected String[] whichEmailToRead() throws IOException, MessagingException {
        String[] emailDetails = new String[5];
        int selectedEmail = jTable1.getSelectedRow();
        
        emailDetails[0] = receiveEmail.fromAddresses.get(receiveEmail.arrayMessages.length - selectedEmail - 1);
        emailDetails[1] = receiveEmail.subjectArray.get(receiveEmail.arrayMessages.length - selectedEmail - 1);
        emailDetails[2] = receiveEmail.dateArray.get(receiveEmail.arrayMessages.length - selectedEmail - 1);
        emailDetails[3] = receiveEmail.attachmentArray.get(receiveEmail.arrayMessages.length - selectedEmail - 1);
        emailDetails[4] = receiveEmail.textContent.get(receiveEmail.arrayMessages.length - selectedEmail - 1);
        
        message = receiveEmail.arrayMessages[receiveEmail.arrayMessages.length - selectedEmail - 1];
        
        return emailDetails;
        
    }
    
    // getter method for which message to read
    protected Message getMessage() {
        return message;
    }
    
    protected EmailAttachmentReceiver getEmailInstance() {
        return receiveEmail;
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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmailInboxFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EmailInboxFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteMailButton;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton logOutButton;
    private javax.swing.JButton mainMenuButton;
    private javax.swing.JButton openEmailButton;
    private javax.swing.JButton sendEmailButton;
    // End of variables declaration//GEN-END:variables
}