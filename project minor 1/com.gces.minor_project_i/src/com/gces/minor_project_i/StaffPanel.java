package com.gces.minor_project_i;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
/**
 *
 * @author pravinewa
 */
public class StaffPanel extends JFrame {
    static String LoginID;
    static String dateTimeStamp;
    
    public StaffPanel() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("jarIcon.png")));
    	
        //initComponents();
        
    }
    private void close()
    {
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    public void initComponents(String LoginID1, String date) {

    	//setIconImage(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/jarIcon.png")).getImage());
    	
    	LoginID = LoginID1;
    	dateTimeStamp = date;
        
        staffWelcomePanel = new JPanel();
        loggedInTime = new JLabel();
        closeButton = new JButton();
        arTitleLabel = new JLabel();
        systemTitleLabel = new JLabel();
        titleSeparator = new JSeparator();
        photoLabel = new JLabel();
        welcomeLabel = new JLabel();
        IDLabel = new JLabel();
        profileButton = new JButton();
        logOutButton = new JButton();
        newRegisterButton = new JButton();
        searchDetailsButton = new JButton();
        passwordLabel = new JLabel();
        panelPhotoLabel = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1050, 700));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        staffWelcomePanel.setBackground(new java.awt.Color(255, 255, 255));
        staffWelcomePanel.setPreferredSize(new java.awt.Dimension(750, 620));
        staffWelcomePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        //---------------------------------------------------------------------//
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setBackground(new Color(0,0,0,0));
        staffWelcomePanel.setBackground(new Color(0,0,0,0));
        setVisible(true);
        //---------------------------------------------------------------------//
        
        loggedInTime.setForeground(new java.awt.Color(255, 255, 255));
        loggedInTime.setText("Logged in at : "+dateTimeStamp);
        staffWelcomePanel.add(loggedInTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 160, -1));

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
        staffWelcomePanel.add(closeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 30, -1, -1));

        arTitleLabel.setBackground(new java.awt.Color(81, 144, 216));
        arTitleLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        arTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        arTitleLabel.setText("Automobile Registration");
        staffWelcomePanel.add(arTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, -1, -1));

        systemTitleLabel.setBackground(new java.awt.Color(51, 110, 123));
        systemTitleLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        systemTitleLabel.setForeground(new java.awt.Color(1, 50, 67));
        systemTitleLabel.setText("System");
        systemTitleLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                systemTitleLabelMouseClicked(evt);
            }
        });
        staffWelcomePanel.add(systemTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 60, -1, -1));
        staffWelcomePanel.add(titleSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 710, 10));

        photoLabel.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/user2.png"))); // NOI18N
        staffWelcomePanel.add(photoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        welcomeLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(255, 255, 255));
        welcomeLabel.setText("WELCOME");
        staffWelcomePanel.add(welcomeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));

        IDLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        IDLabel.setForeground(new java.awt.Color(255, 255, 255));
        IDLabel.setText(LoginID);
        staffWelcomePanel.add(IDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        profileButton.setBackground(new java.awt.Color(255, 255, 255));
        profileButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        profileButton.setText("Profile");
        profileButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profileButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profileButtonMouseExited(evt);
            }
        });
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });
        staffWelcomePanel.add(profileButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 130, 30));

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
        staffWelcomePanel.add(logOutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 130, 30));

        newRegisterButton.setBackground(new java.awt.Color(1, 50, 67));
        newRegisterButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        newRegisterButton.setForeground(new java.awt.Color(255, 255, 255));
        newRegisterButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/add.png"))); // NOI18N
        newRegisterButton.setBorder(null);
        newRegisterButton.setHorizontalTextPosition(SwingConstants.CENTER);
        newRegisterButton.setPreferredSize(new java.awt.Dimension(119, 23));
        newRegisterButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newRegisterButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                newRegisterButtonMouseExited(evt);
            }
        });
        newRegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newRegisterButtonActionPerformed(evt);
            }
        });
        staffWelcomePanel.add(newRegisterButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, 165, 160));

        searchDetailsButton.setBackground(new java.awt.Color(1, 50, 67));
        searchDetailsButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        searchDetailsButton.setForeground(new java.awt.Color(255, 255, 255));
        searchDetailsButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/search.png"))); // NOI18N
        searchDetailsButton.setBorder(null);
        searchDetailsButton.setHorizontalTextPosition(SwingConstants.LEFT);
        searchDetailsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchDetailsButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchDetailsButtonMouseExited(evt);
            }
        });
        searchDetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchDetailsButtonActionPerformed(evt);
            }
        });
        staffWelcomePanel.add(searchDetailsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 290, 165, 160));

        passwordLabel.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(255, 255, 255));
        passwordLabel.setText("To change password contact admin.");
        staffWelcomePanel.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 630, -1, -1));

        panelPhotoLabel.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/staffpanels.png"))); // NOI18N
        staffWelcomePanel.add(panelPhotoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        getContentPane().add(staffWelcomePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 700));

        pack();
        setLocationRelativeTo(null);

    }                        

    //Events
    private void newRegisterButtonMouseEntered(java.awt.event.MouseEvent evt) {                                               
        newRegisterButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/add2.png"))); // NOI18N
        newRegisterButton.setBackground(new java.awt.Color(1, 50, 67));
    }                                              

    private void newRegisterButtonMouseExited(java.awt.event.MouseEvent evt) {                                              
        newRegisterButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/add.png"))); 
        newRegisterButton.setBackground(new java.awt.Color(1, 50, 67));
    }                                             

    private void searchDetailsButtonMouseEntered(java.awt.event.MouseEvent evt) {                                                 
        searchDetailsButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/search2.png"))); // NOI18N
        searchDetailsButton.setBackground(new java.awt.Color(1, 50, 67));
    }                                                

    private void searchDetailsButtonMouseExited(java.awt.event.MouseEvent evt) {                                                
        searchDetailsButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/search.png"))); 
        searchDetailsButton.setBackground(new java.awt.Color(1, 50, 67));
    }                                               

    private void profileButtonMouseEntered(java.awt.event.MouseEvent evt) {                                           
        profileButton.setBackground(new java.awt.Color(51, 110, 123));
        profileButton.setForeground(new java.awt.Color(255, 255, 255));
    }                                          

    private void profileButtonMouseExited(java.awt.event.MouseEvent evt) {                                          
        profileButton.setBackground(new java.awt.Color(255, 255, 255));
        profileButton.setForeground(new java.awt.Color(0, 0, 0));
    }                                         

    private void logOutButtonMouseEntered(java.awt.event.MouseEvent evt) {                                          
        logOutButton.setBackground(new java.awt.Color(51, 110, 123));
        logOutButton.setForeground(new java.awt.Color(255, 255, 255));
    }                                         

    private void logOutButtonMouseExited(java.awt.event.MouseEvent evt) {                                         
        logOutButton.setBackground(new java.awt.Color(255, 255, 255));
        logOutButton.setForeground(new java.awt.Color(0, 0, 0));
    }                                        
    //-------------------------------------------------------------------------//
    //Call next JFrame
    private void newRegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        VehicleRegistration vr = new VehicleRegistration();
        vr.initComponents(LoginID, dateTimeStamp);
        close();
    }                                                 

    private void searchDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        SearchDetail sd = new SearchDetail();
        sd.initComponents(LoginID, dateTimeStamp);
        close();
    }                                                   

    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        StaffProfile sp = new StaffProfile();
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

    private void systemTitleLabelMouseClicked(java.awt.event.MouseEvent evt) {                                              
        AboutSystem as = new AboutSystem();
        as.setVisible(true);
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
                new StaffPanel().setVisible(true);
            }
        });
    }

    // Variables declaration                      
    private JLabel IDLabel;
    private JLabel arTitleLabel;
    private JButton closeButton;
    private JButton logOutButton;
    private JLabel loggedInTime;
    private JButton newRegisterButton;
    private JLabel panelPhotoLabel;
    private JLabel passwordLabel;
    private JLabel photoLabel;
    private JButton profileButton;
    private JButton searchDetailsButton;
    private JPanel staffWelcomePanel;
    private JLabel systemTitleLabel;
    private JSeparator titleSeparator;
    private JLabel welcomeLabel;
    // End of variables declaration                   
}
