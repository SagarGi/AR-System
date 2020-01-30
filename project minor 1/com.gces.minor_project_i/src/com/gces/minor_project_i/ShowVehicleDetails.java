package com.gces.minor_project_i;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author pravinewa
 */
public class ShowVehicleDetails extends JFrame {
    static String LoginID, vehicleno, dateTimeStamp;

    public ShowVehicleDetails() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("jarIcon.png")));
    	
        //initComponents();
        
    }
    private void close()
    {
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
                          
    public void initComponents(String LoginID1, String vehicleno1, String date){
        
    	//setIconImage(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/jarIcon.png")).getImage());
    	
    	LoginID = LoginID1;
        vehicleno = vehicleno1;
        dateTimeStamp = date;
        
        vehicleDetailsPanel = new JPanel();
        closeButton = new JButton();
        loggedInTime = new JLabel();
        photoLabel = new JLabel();
        staffIDLabel = new JLabel();
        IDLabel = new JLabel();
        companyNameLabel = new JLabel();
        showCompanyName = new JLabel();
        vehicleNumberLabel = new JLabel();
        showVehicleNumber = new JLabel();
        vehicleTypeLabel = new JLabel();
        showVehicleType = new JLabel();
        modelNumberLabel = new JLabel();
        showModelNumber = new JLabel();
        vehicleColorLabel = new JLabel();
        showVehicleColor = new JLabel();
        fuelTypeLabel = new JLabel();
        showFuelType = new JLabel();
        engineNumberLabel = new JLabel();
        showEngineNumber = new JLabel();
        displacementLabel = new JLabel();
        showDisplacement = new JLabel();
        maximumPowerLabel = new JLabel();
        showMaximumPower = new JLabel();
        maximumTorqueLabel = new JLabel();
        showMaximumTorque = new JLabel();
        noofSeatsLabel = new JLabel();
        showNoofSeats = new JLabel();
        noofGearsLabel = new JLabel();
        showNoofGears = new JLabel();
        tankCapacityLabel = new JLabel();
        showTankCapacity = new JLabel();
        litreLabel = new JLabel();
        ownerDetailsButton = new JButton();
        vehicleDetailsButton = new JButton();
        backButton = new JButton();
        logOutButton = new JButton();
        registerPhotoLabel = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        vehicleDetailsPanel.setBackground(new java.awt.Color(255, 255, 255));
        vehicleDetailsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        //---------------------------------------------------------------------//
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setBackground(new Color(0,0,0,0));
        vehicleDetailsPanel.setBackground(new Color(0,0,0,0));
        //---------------------------------------------------------------------//
        loggedInTime.setForeground(new java.awt.Color(255, 255, 255));
        loggedInTime.setText("Logged in at : "+dateTimeStamp);
        vehicleDetailsPanel.add(loggedInTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 160, -1));

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
        vehicleDetailsPanel.add(closeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 30, -1, -1));

        photoLabel.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/user2.png"))); 
        vehicleDetailsPanel.add(photoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        staffIDLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        staffIDLabel.setForeground(new java.awt.Color(255, 255, 255));
        staffIDLabel.setText("Staff ID : ");
        vehicleDetailsPanel.add(staffIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));

        IDLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        IDLabel.setForeground(new java.awt.Color(255, 255, 255));
        IDLabel.setText(LoginID);
        vehicleDetailsPanel.add(IDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));


        companyNameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        companyNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        companyNameLabel.setText("Company Name");
        vehicleDetailsPanel.add(companyNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, -1, -1));

        showCompanyName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showCompanyName.setForeground(new java.awt.Color(255, 255, 255));
        showCompanyName.setText("Null");
        vehicleDetailsPanel.add(showCompanyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 190, -1));

        vehicleNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        vehicleNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        vehicleNumberLabel.setText("Vehicle Number");
        vehicleDetailsPanel.add(vehicleNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, -1, -1));

        showVehicleNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showVehicleNumber.setForeground(new java.awt.Color(255, 255, 255));
        showVehicleNumber.setText("Null");
        vehicleDetailsPanel.add(showVehicleNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 100, 190, -1));

        vehicleTypeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        vehicleTypeLabel.setForeground(new java.awt.Color(255, 255, 255));
        vehicleTypeLabel.setText("Vehicle Type");
        vehicleDetailsPanel.add(vehicleTypeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, -1, -1));

        showVehicleType.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showVehicleType.setForeground(new java.awt.Color(255, 255, 255));
        showVehicleType.setText("Null");
        vehicleDetailsPanel.add(showVehicleType, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 190, -1));

        modelNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        modelNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        modelNumberLabel.setText("Model Number");
        vehicleDetailsPanel.add(modelNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 150, -1, -1));

        showModelNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showModelNumber.setForeground(new java.awt.Color(255, 255, 255));
        showModelNumber.setText("Null");
        vehicleDetailsPanel.add(showModelNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 150, 190, -1));

        vehicleColorLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        vehicleColorLabel.setForeground(new java.awt.Color(255, 255, 255));
        vehicleColorLabel.setText("Vehicle Color");
        vehicleDetailsPanel.add(vehicleColorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, -1, -1));

        showVehicleColor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showVehicleColor.setForeground(new java.awt.Color(255, 255, 255));
        showVehicleColor.setText("Null");
        vehicleDetailsPanel.add(showVehicleColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, 190, -1));

        fuelTypeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fuelTypeLabel.setForeground(new java.awt.Color(255, 255, 255));
        fuelTypeLabel.setText("Fuel Type");
        vehicleDetailsPanel.add(fuelTypeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 200, -1, -1));

        showFuelType.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showFuelType.setForeground(new java.awt.Color(255, 255, 255));
        showFuelType.setText("Null");
        vehicleDetailsPanel.add(showFuelType, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 200, 190, -1));

        engineNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        engineNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        engineNumberLabel.setText("Engine Number");
        vehicleDetailsPanel.add(engineNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, -1, -1));

        showEngineNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showEngineNumber.setForeground(new java.awt.Color(255, 255, 255));
        showEngineNumber.setText("Null");
        vehicleDetailsPanel.add(showEngineNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 190, -1));

        displacementLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        displacementLabel.setForeground(new java.awt.Color(255, 255, 255));
        displacementLabel.setText("Displacement/CC");
        vehicleDetailsPanel.add(displacementLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 250, -1, -1));

        showDisplacement.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showDisplacement.setForeground(new java.awt.Color(255, 255, 255));
        showDisplacement.setText("Null");
        vehicleDetailsPanel.add(showDisplacement, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 250, 190, -1));

        maximumPowerLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        maximumPowerLabel.setForeground(new java.awt.Color(255, 255, 255));
        maximumPowerLabel.setText("Maximum Power");
        vehicleDetailsPanel.add(maximumPowerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, -1, -1));

        showMaximumPower.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showMaximumPower.setForeground(new java.awt.Color(255, 255, 255));
        showMaximumPower.setText("Null");
        vehicleDetailsPanel.add(showMaximumPower, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 300, 190, -1));

        maximumTorqueLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        maximumTorqueLabel.setForeground(new java.awt.Color(255, 255, 255));
        maximumTorqueLabel.setText("Maximum Torque");
        vehicleDetailsPanel.add(maximumTorqueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 300, -1, -1));

        showMaximumTorque.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showMaximumTorque.setForeground(new java.awt.Color(255, 255, 255));
        showMaximumTorque.setText("Null");
        vehicleDetailsPanel.add(showMaximumTorque, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 300, 190, -1));

        noofSeatsLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        noofSeatsLabel.setForeground(new java.awt.Color(255, 255, 255));
        noofSeatsLabel.setText("Number of Seats");
        vehicleDetailsPanel.add(noofSeatsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, -1, -1));

        showNoofSeats.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showNoofSeats.setForeground(new java.awt.Color(255, 255, 255));
        showNoofSeats.setText("Null");
        vehicleDetailsPanel.add(showNoofSeats, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, 190, -1));

        noofGearsLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        noofGearsLabel.setForeground(new java.awt.Color(255, 255, 255));
        noofGearsLabel.setText("Number of Gears");
        vehicleDetailsPanel.add(noofGearsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 350, -1, -1));

        showNoofGears.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showNoofGears.setForeground(new java.awt.Color(255, 255, 255));
        showNoofGears.setText("Null");
        vehicleDetailsPanel.add(showNoofGears, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 350, 190, -1));

        tankCapacityLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tankCapacityLabel.setForeground(new java.awt.Color(255, 255, 255));
        tankCapacityLabel.setText("Tank Capacity");
        vehicleDetailsPanel.add(tankCapacityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, -1, -1));

        showTankCapacity.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showTankCapacity.setForeground(new java.awt.Color(255, 255, 255));
        showTankCapacity.setText("Null");
        vehicleDetailsPanel.add(showTankCapacity, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 400, 40, -1));

        litreLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        litreLabel.setForeground(new java.awt.Color(255, 255, 255));
        litreLabel.setText("Litre");
        vehicleDetailsPanel.add(litreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400, 60, -1));

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata","root","");
            String sql = "SELECT companyname, vehiclenumber, vehicletype, modelnumber, vehiclecolor, fueltype, enginenumber, displacement, maxpower, maxtorque, noofseats, noofgears, tankcapacity FROM vehicledetails WHERE vehiclenumber='"+vehicleno+"'";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                 showCompanyName.setText(rs.getString("companyname"));
                 showVehicleNumber.setText(rs.getString("vehiclenumber"));
                 showVehicleType.setText(rs.getString("vehicletype"));
                 showModelNumber.setText(rs.getString("modelnumber"));
                 showVehicleColor.setText(rs.getString("vehiclecolor"));
                 showFuelType.setText(rs.getString("fueltype"));
                 showEngineNumber.setText(rs.getString("enginenumber"));
                 showDisplacement.setText(rs.getString("displacement"));
                 showMaximumPower.setText(rs.getString("maxpower"));
                 showMaximumTorque.setText(rs.getString("maxtorque"));
                 showNoofSeats.setText(rs.getString("noofseats"));
                 showNoofGears.setText(rs.getString("noofgears"));
                 showTankCapacity.setText(rs.getString("tankcapacity"));
                 
            }
            rs.close();
            pstmt.close();
            conn.close();
        }catch(Exception e)
        {
        	JOptionPane.showMessageDialog(null,e);
        }
        
        setVisible(true);

        ownerDetailsButton.setBackground(new java.awt.Color(255, 255, 255));
        ownerDetailsButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ownerDetailsButton.setText("Owner Details");
        ownerDetailsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ownerDetailsButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ownerDetailsButtonMouseExited(evt);
            }
        });
        ownerDetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ownerDetailsButtonActionPerformed(evt);
            }
        });
        vehicleDetailsPanel.add(ownerDetailsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 130, 30));

        vehicleDetailsButton.setBackground(new java.awt.Color(255, 255, 255));
        vehicleDetailsButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        vehicleDetailsButton.setText("Vehicle Details");
        vehicleDetailsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vehicleDetailsButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vehicleDetailsButtonMouseExited(evt);
            }
        });
        vehicleDetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicleDetailsButtonActionPerformed(evt);
            }
        });
        vehicleDetailsPanel.add(vehicleDetailsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 130, 30));

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
        vehicleDetailsPanel.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 130, 30));

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
        vehicleDetailsPanel.add(logOutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 130, 30));

        registerPhotoLabel.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/remainingpanel.png"))); // NOI18N
        vehicleDetailsPanel.add(registerPhotoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 670));

        getContentPane().add(vehicleDetailsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 700));

        pack();
        setLocationRelativeTo(null);
    }              
    
    //-------------------------------------------------------------------------//
    private void ownerDetailsButtonMouseEntered(java.awt.event.MouseEvent evt) {                                                
        ownerDetailsButton.setBackground(new java.awt.Color(1, 50, 67));
        ownerDetailsButton.setForeground(new java.awt.Color(255, 255, 255));
    }                                               

    private void ownerDetailsButtonMouseExited(java.awt.event.MouseEvent evt) {                                               
        ownerDetailsButton.setBackground(new java.awt.Color(255, 255, 255));
        ownerDetailsButton.setForeground(new java.awt.Color(0, 0, 0));
    }                                              

    private void vehicleDetailsButtonMouseEntered(java.awt.event.MouseEvent evt) {                                                  
        vehicleDetailsButton.setBackground(new java.awt.Color(1, 50, 67));
        vehicleDetailsButton.setForeground(new java.awt.Color(255, 255, 255));
    }                                                 

    private void vehicleDetailsButtonMouseExited(java.awt.event.MouseEvent evt) {                                                 
        vehicleDetailsButton.setBackground(new java.awt.Color(255, 255, 255));
        vehicleDetailsButton.setForeground(new java.awt.Color(0, 0, 0));
    }                                                

    private void backButtonMouseEntered(java.awt.event.MouseEvent evt) {                                        
        backButton.setBackground(new java.awt.Color(1, 50, 67));
        backButton.setForeground(new java.awt.Color(255, 255, 255));
    }                                       

    private void backButtonMouseExited(java.awt.event.MouseEvent evt) {                                       
        backButton.setBackground(new java.awt.Color(255, 255, 255));
        backButton.setForeground(new java.awt.Color(0, 0, 0));
    }                                      

    private void logOutButtonMouseEntered(java.awt.event.MouseEvent evt) {                                          
        logOutButton.setBackground(new java.awt.Color(1, 50, 67));
        logOutButton.setForeground(new java.awt.Color(255, 255, 255));
    }                                         

    private void logOutButtonMouseExited(java.awt.event.MouseEvent evt) {                                         
        logOutButton.setBackground(new java.awt.Color(255, 255, 255));
        logOutButton.setForeground(new java.awt.Color(0, 0, 0));
    }                                        

    //-------------------------------------------------------------------------//
    private void ownerDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        ShowOwnerDetails sod = new ShowOwnerDetails();
        sod.initComponents(LoginID, vehicleno, dateTimeStamp);
        close();
    }                                                  

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        SearchDetail sd = new SearchDetail();
        sd.initComponents(LoginID, dateTimeStamp);
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

    private void vehicleDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        
    }                                                    

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        close();
    }                                           
    //-------------------------------------------------------------------------//
    
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
                new ShowVehicleDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify    
    private JLabel loggedInTime;
    private JLabel IDLabel;
    private JButton backButton;
    private JButton closeButton;
    private JLabel companyNameLabel;
    private JLabel displacementLabel;
    private JLabel engineNumberLabel;
    private JLabel fuelTypeLabel;
    private JButton logOutButton;
    private JLabel litreLabel;
    private JLabel maximumPowerLabel;
    private JLabel maximumTorqueLabel;
    private JLabel modelNumberLabel;
    private JLabel noofGearsLabel;
    private JLabel noofSeatsLabel;
    private JButton ownerDetailsButton;
    private JLabel photoLabel;
    private JLabel registerPhotoLabel;
    private JLabel showCompanyName;
    private JLabel showDisplacement;
    private JLabel showEngineNumber;
    private JLabel showFuelType;
    private JLabel showMaximumPower;
    private JLabel showMaximumTorque;
    private JLabel showModelNumber;
    private JLabel showNoofGears;
    private JLabel showNoofSeats;
    private JLabel showTankCapacity;
    private JLabel showVehicleColor;
    private JLabel showVehicleNumber;
    private JLabel showVehicleType;
    private JLabel staffIDLabel;
    private JLabel tankCapacityLabel;
    private JLabel vehicleColorLabel;
    private JButton vehicleDetailsButton;
    private JPanel vehicleDetailsPanel;
    private JLabel vehicleNumberLabel;
    private JLabel vehicleTypeLabel;
    // End of variables declaration                   
}
