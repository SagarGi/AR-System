package com.gces.minor_project_i;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author pravinewa
 */
public class StaffProfile extends JFrame {

    static String LoginID, dateTimeStamp;
    
    public StaffProfile() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("jarIcon.png")));
    	
        //initComponents();
        
    }
    private void close()
    {
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    public void initComponents(String  LoginID1, String date) {

    	//setIconImage(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/jarIcon.png")).getImage());
    	
    	LoginID = LoginID1;
    	dateTimeStamp = date;
    	
    	
        profilePanel = new JPanel();
        closeButton = new JButton();
        loggedInTime = new JLabel();
        photoLabel = new JLabel();
        welcomeLabel = new JLabel();
        IDLabel = new JLabel();
        backButton = new JButton();
        logOutButton = new JButton();
        arTitleLabel = new JLabel();
        systemTitleLabel = new JLabel();
        titleSeparator = new JSeparator();
        staffIDLabel = new JLabel();
        staffIdShow = new JLabel();
        staffNameLabel = new JLabel();
        staffNameShow = new JLabel();
        genderLabel = new JLabel();
        genderShow = new JLabel();
        addressLabel = new JLabel();
        addressShow = new JLabel();
        contactNumberLabel = new JLabel();
        contactNumberShow = new JLabel();
        emaiIDlLabel = new JLabel();
        emailIDShow = new JLabel();
        IDRegisteredDateLabel = new JLabel();
        IRDShow = new JLabel();
        shiftLabel = new JLabel();
        shiftShow = new JLabel();
        panelPhotoLabel = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setFocusCycleRoot(false);
        setMinimumSize(new java.awt.Dimension(750, 620));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profilePanel.setBackground(new java.awt.Color(255, 255, 255));
        profilePanel.setPreferredSize(new java.awt.Dimension(750, 620));
        profilePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        //---------------------------------------------------------------------//
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setBackground(new Color(0,0,0,0));
        profilePanel.setBackground(new Color(0,0,0,0));
        //---------------------------------------------------------------------//
        loggedInTime.setForeground(new java.awt.Color(255, 255, 255));
        loggedInTime.setText("Logged in at : "+dateTimeStamp);
        profilePanel.add(loggedInTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 160, -1));

        closeButton.setBackground(new java.awt.Color(81, 144, 216));
        closeButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/closeicon.png"))); // NOI18N
        closeButton.setBorder(null);
        closeButton.setBorderPainted(false);
        closeButton.setContentAreaFilled(false);
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        profilePanel.add(closeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 50, -1, -1));

        photoLabel.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/user2.png"))); // NOI18N
        profilePanel.add(photoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        welcomeLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(255, 255, 255));
        welcomeLabel.setText("WELCOME");
        profilePanel.add(welcomeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, -1));

        IDLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        IDLabel.setForeground(new java.awt.Color(255, 255, 255));
        IDLabel.setText(LoginID);
        profilePanel.add(IDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, -1));

        backButton.setBackground(new java.awt.Color(255, 255, 255));
        backButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backButton.setText("Back");
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backButtonMouseExited(evt);
            }
        });
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        profilePanel.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 130, 30));

        logOutButton.setBackground(new java.awt.Color(255, 255, 255));
        logOutButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        logOutButton.setText("Log Out");
        logOutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logOutButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logOutButtonMouseExited(evt);
            }
        });
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });
        profilePanel.add(logOutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 580, 130, 30));

        arTitleLabel.setBackground(new java.awt.Color(81, 144, 216));
        arTitleLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        arTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        arTitleLabel.setText("Automobile Registration");
        profilePanel.add(arTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, -1));

        systemTitleLabel.setBackground(new java.awt.Color(51, 110, 123));
        systemTitleLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        systemTitleLabel.setForeground(new java.awt.Color(1, 50, 67));
        systemTitleLabel.setText("System");
        profilePanel.add(systemTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, -1, -1));
        profilePanel.add(titleSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 710, 10));

        staffIDLabel.setBackground(new java.awt.Color(51, 110, 123));
        staffIDLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        staffIDLabel.setText("Staff Id");
        profilePanel.add(staffIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, -1, -1));

        staffIdShow.setBackground(new java.awt.Color(81, 114, 216));
        staffIdShow.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        staffIdShow.setForeground(new java.awt.Color(255, 255, 255));
        staffIdShow.setText("NULL");
        profilePanel.add(staffIdShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 190, -1));

        staffNameLabel.setBackground(new java.awt.Color(51, 110, 123));
        staffNameLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        staffNameLabel.setText("Staff Name");
        profilePanel.add(staffNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, -1, -1));

        staffNameShow.setBackground(new java.awt.Color(81, 114, 216));
        staffNameShow.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        staffNameShow.setForeground(new java.awt.Color(255, 255, 255));
        staffNameShow.setText("NULL");
        profilePanel.add(staffNameShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 250, 190, -1));

        genderLabel.setBackground(new java.awt.Color(51, 110, 123));
        genderLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        genderLabel.setText("Gender");
        profilePanel.add(genderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, -1, -1));

        genderShow.setBackground(new java.awt.Color(81, 114, 216));
        genderShow.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        genderShow.setForeground(new java.awt.Color(255, 255, 255));
        genderShow.setText("NULL");
        profilePanel.add(genderShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, 190, -1));

        addressLabel.setBackground(new java.awt.Color(51, 110, 123));
        addressLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addressLabel.setText("Address");
        profilePanel.add(addressLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, -1, -1));

        addressShow.setBackground(new java.awt.Color(81, 114, 216));
        addressShow.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        addressShow.setForeground(new java.awt.Color(255, 255, 255));
        addressShow.setText("NULL");
        profilePanel.add(addressShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, 190, -1));

        contactNumberLabel.setBackground(new java.awt.Color(51, 110, 123));
        contactNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        contactNumberLabel.setText("Contact Number");
        profilePanel.add(contactNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, -1, -1));

        contactNumberShow.setBackground(new java.awt.Color(81, 114, 216));
        contactNumberShow.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        contactNumberShow.setForeground(new java.awt.Color(255, 255, 255));
        contactNumberShow.setText("NULL");
        profilePanel.add(contactNumberShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, 190, -1));

        emaiIDlLabel.setBackground(new java.awt.Color(51, 110, 123));
        emaiIDlLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        emaiIDlLabel.setText("Email ID");
        profilePanel.add(emaiIDlLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, -1, -1));

        emailIDShow.setBackground(new java.awt.Color(81, 114, 216));
        emailIDShow.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        emailIDShow.setForeground(new java.awt.Color(255, 255, 255));
        emailIDShow.setText("NULL");
        profilePanel.add(emailIDShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 370, 310, -1));

        IDRegisteredDateLabel.setBackground(new java.awt.Color(51, 110, 123));
        IDRegisteredDateLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        IDRegisteredDateLabel.setText("ID Registered Date");
        profilePanel.add(IDRegisteredDateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, -1, -1));

        IRDShow.setBackground(new java.awt.Color(81, 114, 216));
        IRDShow.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        IRDShow.setForeground(new java.awt.Color(255, 255, 255));
        IRDShow.setText("NULL");
        profilePanel.add(IRDShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 400, 190, -1));

        shiftLabel.setBackground(new java.awt.Color(51, 110, 123));
        shiftLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        shiftLabel.setText("Shift");
        profilePanel.add(shiftLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, -1, -1));

        shiftShow.setBackground(new java.awt.Color(81, 114, 216));
        shiftShow.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        shiftShow.setForeground(new java.awt.Color(255, 255, 255));
        shiftShow.setText("NULL");
        profilePanel.add(shiftShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 430, 190, -1));

        panelPhotoLabel.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/staffpanels.png"))); // NOI18N
        profilePanel.add(panelPhotoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, -1));

        getContentPane().add(profilePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1050, 720));

        pack();
        setLocationRelativeTo(null);
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/workerdetails","root","");
            String sql = "SELECT id, workername, gender, address, contactnumber, emailid, idregistereddate, shift FROM workdet WHERE id='"+LoginID+"'";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                 staffIdShow.setText(rs.getString("id"));
                 staffNameShow.setText(rs.getString("workername"));
                 genderShow.setText(rs.getString("gender"));
                 addressShow.setText(rs.getString("address"));
                 contactNumberShow.setText(rs.getString("contactnumber"));
                 emailIDShow.setText(rs.getString("emailid"));
                 IRDShow.setText(rs.getString("idregistereddate"));
                 shiftShow.setText(rs.getString("shift"));
            }
            rs.close();
            pstmt.close();
            conn.close();
            
        }catch(Exception e)
        {
        	JOptionPane.showMessageDialog(null,e);
        }
        
        setVisible(true);
    }                        
    //-------------------------------------------------------------------------//
    //Events
    private void logOutButtonMouseExited(java.awt.event.MouseEvent evt) {                                         
        logOutButton.setBackground(new java.awt.Color(255, 255, 255));
        logOutButton.setForeground(new java.awt.Color(0, 0, 0));
    }                                        

    private void logOutButtonMouseEntered(java.awt.event.MouseEvent evt) {                                          
        logOutButton.setBackground(new java.awt.Color(51, 110, 123));
        logOutButton.setForeground(new java.awt.Color(255, 255, 255));
    }                                         

    private void backButtonMouseExited(java.awt.event.MouseEvent evt) {                                       
        backButton.setBackground(new java.awt.Color(255, 255, 255));
        backButton.setForeground(new java.awt.Color(0, 0, 0));
    }                                      

    private void backButtonMouseEntered(java.awt.event.MouseEvent evt) {                                        
        backButton.setBackground(new java.awt.Color(51, 110, 123));
        backButton.setForeground(new java.awt.Color(255, 255, 255));
    }                                       
    //-------------------------------------------------------------------------//
    //action event

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        StaffPanel sp = new StaffPanel();
        sp.initComponents(LoginID, dateTimeStamp);
        close();
    }                                          

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        int logout1 = JOptionPane.showConfirmDialog(null,"Do you really want to Log Out?","Logout Confirmation",JOptionPane.YES_NO_OPTION);
        if(logout1 == 0)
        {
        WorkerLogin sl = new WorkerLogin();
        sl.setVisible(true);
        close();
        }
    }                                            

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        close();
    }                                           

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StaffPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StaffProfile().setVisible(true);
            }
        });
    }

    // Variables declaration
    private JLabel loggedInTime;
    private JLabel IDLabel;
    private JLabel IDRegisteredDateLabel;
    private JLabel IRDShow;
    private JLabel addressLabel;
    private JLabel addressShow;
    private JLabel arTitleLabel;
    private JButton backButton;
    private JButton closeButton;
    private JLabel contactNumberLabel;
    private JLabel contactNumberShow;
    private JLabel emaiIDlLabel;
    private JLabel emailIDShow;
    private JLabel genderLabel;
    private JLabel genderShow;
    private JButton logOutButton;
    private JLabel panelPhotoLabel;
    private JLabel photoLabel;
    private JPanel profilePanel;
    private JLabel shiftLabel;
    private JLabel shiftShow;
    private JLabel staffIDLabel;
    private JLabel staffIdShow;
    private JLabel staffNameLabel;
    private JLabel staffNameShow;
    private JLabel systemTitleLabel;
    private JSeparator titleSeparator;
    private JLabel welcomeLabel;
    // End of variables declaration                   
}
