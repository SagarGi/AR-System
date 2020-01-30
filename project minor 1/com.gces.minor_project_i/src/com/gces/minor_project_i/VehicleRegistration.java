package com.gces.minor_project_i;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

/**
 *
 * @author pravinewa
 */
public class VehicleRegistration extends JFrame {
    static int compnamevalid = 0, vehnumbvalid = 0, modenumbvalid = 0, vehcolorvalid = 0, engnumbvalid = 0, dispvalid = 0, maxpowvalid = 0, maxtorqvalid = 0, noofseavalid = 0, tankvalid = 0;
    static String LoginID, dateTimeStamp;
        
    public VehicleRegistration() {
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
    	
    	handler = new ItemHandler();
        vehicleRegistrationPanel = new JPanel();
        closeButton = new JButton();
        loggedInTime = new JLabel();
        photoLabel = new JLabel();
        staffIdLabel = new JLabel();
        IDLabel = new JLabel();
        fieldWithsLabel = new JLabel();
        redmark0 = new JLabel();
        areMandatoryLabel = new JLabel();
        showValidationOfTankCapacity = new JLabel();
        companyNameLabel = new JLabel();
        redmark1 = new JLabel();
        companyNameTextField = new JTextField();
        companyNameSeparator = new JSeparator();
        showValidationOfCompanyName = new JLabel();
        vehicleNumberLabel = new JLabel();
        redmark2 = new JLabel();
        vehicleNumberTextField = new JTextField();
        vehicleNumberSeparator = new JSeparator();
        showValidationOfVehicleNumber = new JLabel();
        vehicleTypeLabel = new JLabel();
        redmark4 = new JLabel();
        vehicleTypeComboBox = new JComboBox<>();
        showValidationOfVehicleType = new JLabel();
        modelNumberLabel = new JLabel();
        redmark5 = new JLabel();
        modelNumberTextField = new JTextField();
        modelNumberSeparator = new JSeparator();
        showValidationOfModelNumber = new JLabel();
        vehicleColorLabel = new JLabel();
        redmark6 = new JLabel();
        vehicleColorTextField = new JTextField();
        vehicleColorSeparator = new JSeparator();
        showValidationOfVehicleColor = new JLabel();
        fuelTypeLabel = new JLabel();
        redmark7 = new JLabel();
        fuelTypeComboBox = new JComboBox<>();
        showValidationOfFuelType = new JLabel();
        engineNumberLabel = new JLabel();
        redmark8 = new JLabel();
        engineNumberTextField = new JTextField();
        engineNumberSeparator = new JSeparator();
        showValidationOfEngineNumber = new JLabel();
        displacementLabel = new JLabel();
        redmark9 = new JLabel();
        displacementTextField = new JTextField();
        displacementSeparator = new JSeparator();
        showValidationOfDisplacement = new JLabel();
        MaximumPowerLabel = new JLabel();
        redmark10 = new JLabel();
        maximumPowerTextField = new JTextField();
        maximumPowerSeparator = new JSeparator();
        showValidationOfMaximumPower = new JLabel();
        maximumTorqueLabel = new JLabel();
        redmark11 = new JLabel();
        maximumTorqueTextField = new JTextField();
        maximumTorqueSeparator = new JSeparator();
        showValidationOfMaximumTorque = new JLabel();
        noofSeatsLabel = new JLabel();
        redmark12 = new JLabel();
        noofSeatsTextField = new JTextField();
        noofSeatsSeparator = new JSeparator();
        showValidationOfNoofSeats = new JLabel();
        noofGearsLabel = new JLabel();
        redmark13 = new JLabel();
        noofGearsComboBox = new JComboBox<>();
        showValidationOfNoofGears = new JLabel();
        tankCapacityLabel = new JLabel();
        redmark14 = new JLabel();
        litreLabel = new JLabel();
        tankCapacityTextField = new JTextField();
        tankCapacitySeparator = new JSeparator();
        confirmCheckBox = new JCheckBox();
        nextButton = new JButton();
        homeButton = new JButton();
        logOutButton = new JButton();
        RegisterPhotoLabel = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1050, 700));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        vehicleRegistrationPanel.setBackground(new java.awt.Color(255, 255, 255));
        vehicleRegistrationPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        //---------------------------------------------------------------------//
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setBackground(new Color(0,0,0,0));
        vehicleRegistrationPanel.setBackground(new Color(0,0,0,0));
        setVisible(true);
        //---------------------------------------------------------------------//
        loggedInTime.setForeground(new java.awt.Color(255, 255, 255));
        loggedInTime.setText("Logged in at : "+dateTimeStamp);
        vehicleRegistrationPanel.add(loggedInTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 160, -1));
        
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
        vehicleRegistrationPanel.add(closeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 30, -1, -1));

        photoLabel.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/user2.png"))); // NOI18N
        vehicleRegistrationPanel.add(photoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        staffIdLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        staffIdLabel.setForeground(new java.awt.Color(255, 255, 255));
        staffIdLabel.setText("Staff ID : ");
        vehicleRegistrationPanel.add(staffIdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));

        IDLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        IDLabel.setForeground(new java.awt.Color(255, 255, 255));
        IDLabel.setText(LoginID);
        vehicleRegistrationPanel.add(IDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        fieldWithsLabel.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        fieldWithsLabel.setForeground(new java.awt.Color(255, 255, 255));
        fieldWithsLabel.setText("Fields with");
        vehicleRegistrationPanel.add(fieldWithsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, -1, -1));

        redmark0.setForeground(new java.awt.Color(255, 0, 0));
        redmark0.setText(" *");
        vehicleRegistrationPanel.add(redmark0, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 10, -1));

        areMandatoryLabel.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        areMandatoryLabel.setForeground(new java.awt.Color(255, 255, 255));
        areMandatoryLabel.setText("are Mandatory");
        vehicleRegistrationPanel.add(areMandatoryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 190, -1));

        showValidationOfTankCapacity.setForeground(new java.awt.Color(255, 0, 0));
        vehicleRegistrationPanel.add(showValidationOfTankCapacity, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 430, 200, -1));

        companyNameLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        companyNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        companyNameLabel.setText("Company Name");
        vehicleRegistrationPanel.add(companyNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, -1, -1));

        redmark1.setForeground(new java.awt.Color(255, 0, 0));
        redmark1.setText("*");
        vehicleRegistrationPanel.add(redmark1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 10, -1));

        companyNameTextField.setBackground(new java.awt.Color(1, 50, 67));
        companyNameTextField.setForeground(new java.awt.Color(255, 255, 255));
        companyNameTextField.setBorder(null);
        companyNameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                companyNameTextFieldKeyReleased(evt);
            }
        });
        vehicleRegistrationPanel.add(companyNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 200, 20));
        vehicleRegistrationPanel.add(companyNameSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 200, 10));

        showValidationOfCompanyName.setForeground(new java.awt.Color(255, 0, 0));
        vehicleRegistrationPanel.add(showValidationOfCompanyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 200, -1));

        vehicleNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        vehicleNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        vehicleNumberLabel.setText("Vehicle Number");
        vehicleRegistrationPanel.add(vehicleNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, -1, -1));

        redmark2.setForeground(new java.awt.Color(255, 0, 0));
        redmark2.setText("*");
        vehicleRegistrationPanel.add(redmark2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 110, -1, -1));

        vehicleNumberTextField.setBackground(new java.awt.Color(1, 50, 67));
        vehicleNumberTextField.setForeground(new java.awt.Color(255, 255, 255));
        vehicleNumberTextField.setBorder(null);
        vehicleNumberTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                vehicleNumberTextFieldKeyReleased(evt);
            }
        });
        vehicleRegistrationPanel.add(vehicleNumberTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 100, 200, 20));
        vehicleRegistrationPanel.add(vehicleNumberSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 120, 200, 10));

        showValidationOfVehicleNumber.setForeground(new java.awt.Color(255, 0, 0));
        vehicleRegistrationPanel.add(showValidationOfVehicleNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 130, 200, -1));

        vehicleTypeLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        vehicleTypeLabel.setForeground(new java.awt.Color(255, 255, 255));
        vehicleTypeLabel.setText("Vehicle Type");
        vehicleRegistrationPanel.add(vehicleTypeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, -1, -1));

        redmark4.setForeground(new java.awt.Color(255, 0, 0));
        redmark4.setText("*");
        vehicleRegistrationPanel.add(redmark4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 10, -1));

        vehicleTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Choose Vehicle Type", "Scooty", "Bike", "Car" }));
        vehicleRegistrationPanel.add(vehicleTypeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 200, 30));
        vehicleTypeComboBox.addItemListener(handler);
        showValidationOfVehicleType.setForeground(new java.awt.Color(255, 0, 0));
        vehicleRegistrationPanel.add(showValidationOfVehicleType, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 200, -1));

        modelNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        modelNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        modelNumberLabel.setText("Model Number");
        vehicleRegistrationPanel.add(modelNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, -1, -1));

        redmark5.setForeground(new java.awt.Color(255, 0, 0));
        redmark5.setText(" *");
        vehicleRegistrationPanel.add(redmark5, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 160, -1, -1));

        modelNumberTextField.setBackground(new java.awt.Color(1, 50, 67));
        modelNumberTextField.setForeground(new java.awt.Color(255, 255, 255));
        modelNumberTextField.setBorder(null);
        modelNumberTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                modelNumberTextFieldKeyReleased(evt);
            }
        });
        vehicleRegistrationPanel.add(modelNumberTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 150, 200, 20));
        vehicleRegistrationPanel.add(modelNumberSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 170, 200, 10));

        showValidationOfModelNumber.setForeground(new java.awt.Color(255, 0, 0));
        vehicleRegistrationPanel.add(showValidationOfModelNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 180, 200, -1));

        vehicleColorLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        vehicleColorLabel.setForeground(new java.awt.Color(255, 255, 255));
        vehicleColorLabel.setText("Vehicle Color");
        vehicleRegistrationPanel.add(vehicleColorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, -1, -1));

        redmark6.setForeground(new java.awt.Color(255, 0, 0));
        redmark6.setText("*");
        vehicleRegistrationPanel.add(redmark6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 10, -1));

        vehicleColorTextField.setBackground(new java.awt.Color(1, 50, 67));
        vehicleColorTextField.setForeground(new java.awt.Color(255, 255, 255));
        vehicleColorTextField.setBorder(null);
        vehicleColorTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                vehicleColorTextFieldKeyReleased(evt);
            }
        });
        vehicleRegistrationPanel.add(vehicleColorTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, 200, 20));
        vehicleRegistrationPanel.add(vehicleColorSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 200, 10));

        showValidationOfVehicleColor.setForeground(new java.awt.Color(255, 0, 0));
        vehicleRegistrationPanel.add(showValidationOfVehicleColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 200, -1));

        fuelTypeLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fuelTypeLabel.setForeground(new java.awt.Color(255, 255, 255));
        fuelTypeLabel.setText("Fuel Type");
        vehicleRegistrationPanel.add(fuelTypeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 210, -1, -1));

        redmark7.setForeground(new java.awt.Color(255, 0, 0));
        redmark7.setText(" *");
        vehicleRegistrationPanel.add(redmark7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 210, -1, -1));

        fuelTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Choose Fuel Type", "Petrol", "Diesel" }));
        vehicleRegistrationPanel.add(fuelTypeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 200, 200, 30));

        showValidationOfFuelType.setForeground(new java.awt.Color(255, 0, 0));
        vehicleRegistrationPanel.add(showValidationOfFuelType, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 230, 200, -1));

        engineNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        engineNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        engineNumberLabel.setText("Engine Number");
        vehicleRegistrationPanel.add(engineNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, -1, -1));

        redmark8.setForeground(new java.awt.Color(255, 0, 0));
        redmark8.setText(" *");
        vehicleRegistrationPanel.add(redmark8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 10, -1));

        engineNumberTextField.setBackground(new java.awt.Color(1, 50, 67));
        engineNumberTextField.setForeground(new java.awt.Color(255, 255, 255));
        engineNumberTextField.setBorder(null);
        engineNumberTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                engineNumberTextFieldKeyReleased(evt);
            }
        });
        vehicleRegistrationPanel.add(engineNumberTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 200, 20));
        vehicleRegistrationPanel.add(engineNumberSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, 200, 10));

        showValidationOfEngineNumber.setForeground(new java.awt.Color(255, 0, 0));
        vehicleRegistrationPanel.add(showValidationOfEngineNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 200, -1));

        displacementLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        displacementLabel.setForeground(new java.awt.Color(255, 255, 255));
        displacementLabel.setText("Displacement/CC");
        vehicleRegistrationPanel.add(displacementLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 260, -1, -1));

        redmark9.setForeground(new java.awt.Color(255, 0, 0));
        redmark9.setText("*");
        vehicleRegistrationPanel.add(redmark9, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 260, -1, -1));

        displacementTextField.setBackground(new java.awt.Color(1, 50, 67));
        displacementTextField.setForeground(new java.awt.Color(255, 255, 255));
        displacementTextField.setBorder(null);
        displacementTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                displacementTextFieldKeyReleased(evt);
            }
        });
        vehicleRegistrationPanel.add(displacementTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 250, 200, 20));
        vehicleRegistrationPanel.add(displacementSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 270, 200, 10));

        showValidationOfDisplacement.setForeground(new java.awt.Color(255, 0, 0));
        vehicleRegistrationPanel.add(showValidationOfDisplacement, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 280, 200, -1));

        MaximumPowerLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        MaximumPowerLabel.setForeground(new java.awt.Color(255, 255, 255));
        MaximumPowerLabel.setText("Maximum Power");
        vehicleRegistrationPanel.add(MaximumPowerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, -1, -1));

        redmark10.setForeground(new java.awt.Color(255, 0, 0));
        redmark10.setText(" *");
        vehicleRegistrationPanel.add(redmark10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, 10, -1));

        maximumPowerTextField.setBackground(new java.awt.Color(1, 50, 67));
        maximumPowerTextField.setForeground(new java.awt.Color(255, 255, 255));
        maximumPowerTextField.setBorder(null);
        maximumPowerTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                maximumPowerTextFieldKeyReleased(evt);
            }
        });
        vehicleRegistrationPanel.add(maximumPowerTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 200, 20));
        vehicleRegistrationPanel.add(maximumPowerSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 200, 10));

        showValidationOfMaximumPower.setForeground(new java.awt.Color(255, 0, 0));
        vehicleRegistrationPanel.add(showValidationOfMaximumPower, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, 200, -1));

        maximumTorqueLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        maximumTorqueLabel.setForeground(new java.awt.Color(255, 255, 255));
        maximumTorqueLabel.setText("Maximum Torque");
        vehicleRegistrationPanel.add(maximumTorqueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 310, -1, -1));

        redmark11.setForeground(new java.awt.Color(255, 0, 0));
        redmark11.setText("*");
        vehicleRegistrationPanel.add(redmark11, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 310, 10, -1));

        maximumTorqueTextField.setBackground(new java.awt.Color(1, 50, 67));
        maximumTorqueTextField.setForeground(new java.awt.Color(255, 255, 255));
        maximumTorqueTextField.setBorder(null);
        maximumTorqueTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                maximumTorqueTextFieldKeyReleased(evt);
            }
        });
        vehicleRegistrationPanel.add(maximumTorqueTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 300, 200, 20));
        vehicleRegistrationPanel.add(maximumTorqueSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 320, 200, 10));

        showValidationOfMaximumTorque.setForeground(new java.awt.Color(255, 0, 0));
        vehicleRegistrationPanel.add(showValidationOfMaximumTorque, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 330, 200, -1));

        noofSeatsLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        noofSeatsLabel.setForeground(new java.awt.Color(255, 255, 255));
        noofSeatsLabel.setText("Number of Seats");
        vehicleRegistrationPanel.add(noofSeatsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, -1, -1));

        redmark12.setForeground(new java.awt.Color(255, 0, 0));
        redmark12.setText(" *");
        vehicleRegistrationPanel.add(redmark12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, 10, -1));

        noofSeatsTextField.setBackground(new java.awt.Color(1, 50, 67));
        noofSeatsTextField.setForeground(new java.awt.Color(255, 255, 255));
        noofSeatsTextField.setBorder(null);
        noofSeatsTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                noofSeatsTextFieldKeyReleased(evt);
            }
        });
        vehicleRegistrationPanel.add(noofSeatsTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 200, 20));
        vehicleRegistrationPanel.add(noofSeatsSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 370, 200, 10));

        showValidationOfNoofSeats.setForeground(new java.awt.Color(255, 0, 0));
        vehicleRegistrationPanel.add(showValidationOfNoofSeats, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 380, 200, -1));

        noofGearsLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        noofGearsLabel.setForeground(new java.awt.Color(255, 255, 255));
        noofGearsLabel.setText("Number of Gears");
        vehicleRegistrationPanel.add(noofGearsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 360, -1, -1));

        redmark13.setForeground(new java.awt.Color(255, 0, 0));
        redmark13.setText(" *");
        vehicleRegistrationPanel.add(redmark13, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 360, -1, -1));

        noofGearsComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Choose No of Gears", "1", "2", "3", "4", "5", "6" }));
        vehicleRegistrationPanel.add(noofGearsComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 350, 200, 30));

        showValidationOfNoofGears.setForeground(new java.awt.Color(255, 0, 0));
        vehicleRegistrationPanel.add(showValidationOfNoofGears, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 380, 200, -1));

        tankCapacityLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tankCapacityLabel.setForeground(new java.awt.Color(255, 255, 255));
        tankCapacityLabel.setText("Tank Capacity");
        vehicleRegistrationPanel.add(tankCapacityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, -1, -1));

        redmark14.setForeground(new java.awt.Color(255, 0, 0));
        redmark14.setText("*");
        vehicleRegistrationPanel.add(redmark14, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 410, 10, -1));


        litreLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        litreLabel.setForeground(new java.awt.Color(255, 255, 255));
        litreLabel.setText("Litre");
        vehicleRegistrationPanel.add(litreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 400, 50, 20));

        tankCapacityTextField.setBackground(new java.awt.Color(1, 50, 67));
        tankCapacityTextField.setForeground(new java.awt.Color(255, 255, 255));
        tankCapacityTextField.setBorder(null);
        tankCapacityTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tankCapacityTextFieldKeyReleased(evt);
            }
        });
        vehicleRegistrationPanel.add(tankCapacityTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 400, 200, 20));
        vehicleRegistrationPanel.add(tankCapacitySeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 420, 200, 10));

        confirmCheckBox.setBackground(new java.awt.Color(1, 50, 67));
        confirmCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        confirmCheckBox.setText("Tick CheckBox to process on next step");
        vehicleRegistrationPanel.add(confirmCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 600, -1, -1));

        nextButton.setBackground(new java.awt.Color(255, 255, 255));
        nextButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nextButton.setText("Next");
        nextButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nextButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nextButtonMouseExited(evt);
            }
        });
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        vehicleRegistrationPanel.add(nextButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 130, 30));

        homeButton.setBackground(new java.awt.Color(255, 255, 255));
        homeButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        homeButton.setText("Home");
        homeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homeButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homeButtonMouseExited(evt);
            }
        });
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });
        vehicleRegistrationPanel.add(homeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 130, 30));

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
        vehicleRegistrationPanel.add(logOutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 130, 30));

        RegisterPhotoLabel.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/remainingpanel.png"))); // NOI18N
        vehicleRegistrationPanel.add(RegisterPhotoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 670));

        getContentPane().add(vehicleRegistrationPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 680));

        pack();
        setLocationRelativeTo(null);
    }

    //-------------------------------------------------------------------------//
    //Events
    private void logOutButtonMouseEntered(java.awt.event.MouseEvent evt) {                                          
        logOutButton.setBackground(new java.awt.Color(1, 50, 67));
        logOutButton.setForeground(new java.awt.Color(255, 255, 255));
    }                                         

    private void logOutButtonMouseExited(java.awt.event.MouseEvent evt) {                                         
        logOutButton.setBackground(new java.awt.Color(255, 255, 255));
        logOutButton.setForeground(new java.awt.Color(0, 0, 0));
    }                                        

    private void nextButtonMouseEntered(java.awt.event.MouseEvent evt) {                                        
        nextButton.setBackground(new java.awt.Color(1, 50, 67));
        nextButton.setForeground(new java.awt.Color(255, 255, 255));
    }                                       

    private void nextButtonMouseExited(java.awt.event.MouseEvent evt) {                                       
        nextButton.setBackground(new java.awt.Color(255, 255, 255));
        nextButton.setForeground(new java.awt.Color(0, 0, 0));
    }                                      

    private void homeButtonMouseEntered(java.awt.event.MouseEvent evt) {                                        
        homeButton.setBackground(new java.awt.Color(1, 50, 67));
        homeButton.setForeground(new java.awt.Color(255, 255, 255));
    }                                       

    private void homeButtonMouseExited(java.awt.event.MouseEvent evt) {                                       
        homeButton.setBackground(new java.awt.Color(255, 255, 255));
        homeButton.setForeground(new java.awt.Color(0, 0, 0));
    }                                      

    //-------------------------------------------------------------------------//
    private void companyNameTextFieldKeyReleased(java.awt.event.KeyEvent evt) {                                                 
        String PATTERN = "^[a-zA-Z\\s]{0,18}+$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(companyNameTextField.getText());
        if(!match.matches())
        {
            showValidationOfCompanyName.setText("Company Name is incorrect!");
            companyNameTextField.setForeground(Color.red);
            compnamevalid = 0;
        }
        if(companyNameTextField.getText().equals(""))
        {
            showValidationOfCompanyName.setText(null);
            companyNameTextField.setForeground(Color.white);
            compnamevalid = 0;
        }
        if(match.matches())
        {
            showValidationOfCompanyName.setText(null);
            companyNameTextField.setForeground(Color.white);
            compnamevalid = 1;
        }
    }                                                

    private void vehicleNumberTextFieldKeyReleased(java.awt.event.KeyEvent evt) {                                                   
        String PATTERN = "^[a-zA-Z]{0,3}[ ][0-9]{0,2}[ ][a-zA-Z]{0,3}[ ][0-9]{0,4}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(vehicleNumberTextField.getText());
        if(!match.matches())
        {
            showValidationOfVehicleNumber.setText("Vehicle Number is incorrect!");
            vehicleNumberTextField.setForeground(Color.red);
            vehnumbvalid = 0;
        }
        if(vehicleNumberTextField.getText().equals("")){
            showValidationOfVehicleNumber.setText(null);
            vehicleNumberTextField.setForeground(Color.white);
            vehnumbvalid = 0;
        }
        if(match.matches())
        {
            showValidationOfVehicleNumber.setText(null);
            vehicleNumberTextField.setForeground(Color.white);
            vehnumbvalid = 1;
        }
    }                                                  

    private void modelNumberTextFieldKeyReleased(java.awt.event.KeyEvent evt) {                                                 
        String PATTERN = "^[0-9]{0,15}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(modelNumberTextField.getText());
        if(!match.matches())
        {
            showValidationOfModelNumber.setText("Model Number is incorrect!");
            modelNumberTextField.setForeground(Color.red);
            modenumbvalid = 0;
        }
        if(modelNumberTextField.getText().equals("")){
            showValidationOfModelNumber.setText(null);
            modelNumberTextField.setForeground(Color.white);
            modenumbvalid = 0;
        }
        if(match.matches())
        {
            showValidationOfModelNumber.setText(null);
            modelNumberTextField.setForeground(Color.white);
            modenumbvalid = 1;
        }
    }                                                

    private void vehicleColorTextFieldKeyReleased(java.awt.event.KeyEvent evt) {                                                  
        String PATTERN = "^[a-zA-Z\\s]{2,15}+$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(vehicleColorTextField.getText());
        if(!match.matches())
        {
            showValidationOfVehicleColor.setText("Vehicle Color is incorrect!");
            vehicleColorTextField.setForeground(Color.red);
            vehcolorvalid = 0;
        }
        if(vehicleColorTextField.getText().equals("")){
            showValidationOfVehicleColor.setText(null);
            vehicleColorTextField.setForeground(Color.white);
            vehcolorvalid = 0;
        }
        if(match.matches())
        {
            showValidationOfVehicleColor.setText(null);
            vehicleColorTextField.setForeground(Color.white);
            vehcolorvalid = 1;
        }
    }                                                 

    private void engineNumberTextFieldKeyReleased(java.awt.event.KeyEvent evt) {                                                  
        String PATTERN = "^[0-9]{0,15}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(engineNumberTextField.getText());
        if(!match.matches())
        {
            showValidationOfEngineNumber.setText("Engine Number is incorrect!");
            engineNumberTextField.setForeground(Color.red);
            engnumbvalid = 0;
        }
        if(engineNumberTextField.getText().equals("")){
            showValidationOfEngineNumber.setText(null);
            engineNumberTextField.setForeground(Color.white);
            engnumbvalid = 0;
        }
        if(match.matches())
        {
            showValidationOfEngineNumber.setText(null);
            engineNumberTextField.setForeground(Color.white);
            engnumbvalid = 1;
        }
    }                                                 

    private void displacementTextFieldKeyReleased(java.awt.event.KeyEvent evt) {                                                  
        String PATTERN = "^[0-9]{0,5}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(displacementTextField.getText());
        if(!match.matches())
        {
            showValidationOfDisplacement.setText("Displacement/CC is incorrect!");
            displacementTextField.setForeground(Color.red);
            dispvalid = 0;
        }
        if(displacementTextField.getText().equals("")){
            showValidationOfDisplacement.setText(null);
            displacementTextField.setForeground(Color.white);
            dispvalid = 0;
        }
        if(match.matches())
        {
            showValidationOfDisplacement.setText(null);
            displacementTextField.setForeground(Color.white);
            dispvalid = 1;
        }
    }                                                 

    private void maximumPowerTextFieldKeyReleased(java.awt.event.KeyEvent evt) {                                                  
        String PATTERN = "^[0-9]{0,6}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(maximumPowerTextField.getText());
        if(!match.matches())
        {
            showValidationOfMaximumPower.setText("Maximum Power is incorrect!");
            maximumPowerTextField.setForeground(Color.red);
            maxpowvalid = 0;
        }
        if(maximumPowerTextField.getText().equals("")){
            showValidationOfMaximumPower.setText(null);
            maximumPowerTextField.setForeground(Color.white);
            maxpowvalid = 0;
        }
        if(match.matches())
        {
            showValidationOfMaximumPower.setText(null);
            maximumPowerTextField.setForeground(Color.white);
            maxpowvalid = 1;
        }
    }                                                 

    private void maximumTorqueTextFieldKeyReleased(java.awt.event.KeyEvent evt) {                                                   
        String PATTERN = "^[0-9]{0,6}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(maximumTorqueTextField.getText());
        if(!match.matches())
        {
            showValidationOfMaximumTorque.setText("Maximum Torque is incorrect!");
            maximumTorqueTextField.setForeground(Color.red);
            maxtorqvalid = 0;
        }
        if(maximumTorqueTextField.getText().equals("")){
            showValidationOfMaximumTorque.setText(null);
            maximumTorqueTextField.setForeground(Color.white);
            maxtorqvalid = 0;
        }
        if(match.matches())
        {
            showValidationOfMaximumTorque.setText(null);
            maximumTorqueTextField.setForeground(Color.white);
            maxtorqvalid = 1;
        }
    }                                                  

    private void noofSeatsTextFieldKeyReleased(java.awt.event.KeyEvent evt) {                                               
        String PATTERN = "^[0-9]{0,2}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(noofSeatsTextField.getText());
        if(!match.matches())
        {
            showValidationOfNoofSeats.setText("No of Seats is incorrect!");
            noofSeatsTextField.setForeground(Color.red);
            noofseavalid = 0;
        }
        if(noofSeatsTextField.getText().equals("")){
            showValidationOfNoofSeats.setText(null);
            noofSeatsTextField.setForeground(Color.white);
            noofseavalid = 0;
        }
        if(match.matches())
        {
            showValidationOfNoofSeats.setText(null);
            noofSeatsTextField.setForeground(Color.white);
            noofseavalid = 1;
        }
    }                                              

    private void tankCapacityTextFieldKeyReleased(java.awt.event.KeyEvent evt) {                                                  
        String PATTERN = "^[0-9]{0,3}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(tankCapacityTextField.getText());
        if(!match.matches())
        {
            showValidationOfTankCapacity.setText("Numbering is incorrect!");
            tankCapacityTextField.setForeground(Color.red);
            tankvalid = 0;
        }
        if(tankCapacityTextField.getText().equals("")){
            showValidationOfTankCapacity.setText(null);
            tankCapacityTextField.setForeground(Color.white);
            tankvalid = 0;
        }
        if(match.matches())
        {
            showValidationOfTankCapacity.setText(null);
            tankCapacityTextField.setForeground(Color.white);
            tankvalid = 1;
        }
    } 
    
    private class ItemHandler implements ItemListener{
        public void itemStateChanged(ItemEvent event)
        {
            if(event.getSource()== vehicleTypeComboBox)
            {
                if(vehicleTypeComboBox.getSelectedItem().equals("Scooty"))
                {
                    noofGearsComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Choose No of Gears","No Gears" }));
                    fuelTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Choose Fuel Type", "Petrol" }));

                }
                if(vehicleTypeComboBox.getSelectedItem().equals("Bike")){
                	noofGearsComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Choose No of Gears", "1", "2", "3", "4", "5", "6" }));
                    fuelTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Choose Fuel Type", "Petrol" }));

                }
                if(vehicleTypeComboBox.getSelectedItem().equals("Car")){
                	noofGearsComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Choose No of Gears", "1", "2", "3", "4", "5", "6" }));
                    fuelTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Choose Fuel Type", "Petrol", "Diesel" }));

                }
                
            }
        }
     }
    //-------------------------------------------------------------------------//
    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
    if(confirmCheckBox.isSelected())
        {
        int empcompvalid = 0, empvehnumbvalid = 0, empvehtypevalid = 0, empmodelvalid = 0, empvehcolorvalid = 0, empfuelvalid = 0, empengnumbvalid = 0, empdispvalid = 0, empmaxpowvalid = 0, empmaxtorvalid = 0, empnoofseatvalid = 0, empnoofgearvalid = 0, emptankvalid = 0;
        String companyName = companyNameTextField.getText();
        String vehicleNumber = vehicleNumberTextField.getText();
        String vehicleType = vehicleTypeComboBox.getSelectedItem().toString();
        String modelNumber = modelNumberTextField.getText();
        String vehicleColor = vehicleColorTextField.getText();
        String fuelType = fuelTypeComboBox.getSelectedItem().toString();
        String engineNumber = engineNumberTextField.getText();
        String displacement = displacementTextField.getText();
        String maximumPower = maximumPowerTextField.getText();
        String maximumTorque = maximumTorqueTextField.getText();
        String noofSeats = noofSeatsTextField.getText();
        String noofGears = noofGearsComboBox.getSelectedItem().toString();
        String tankCapacity = tankCapacityTextField.getText();
        
        if(companyName.equals(""))
        {
            showValidationOfCompanyName.setText("Company Name Field is Empty!");
            empcompvalid = 0;
        }else{
            empcompvalid = 1;
        }
        if(vehicleNumber.equals(""))
        {
            showValidationOfVehicleNumber.setText("Vehicle Number Field is Empty!");
            empvehnumbvalid = 0;
        }else{
            empvehnumbvalid = 1;
        }
        if(vehicleType.equals("Choose Vehicle Type"))
        {
            showValidationOfVehicleType.setText("Please Choose valid Vehicle Type!");
            empvehtypevalid = 0;
        }else{
            showValidationOfVehicleType.setText(null);
            empvehtypevalid = 1;
        }
        if(modelNumber.equals(""))
        {
            showValidationOfModelNumber.setText("Model Number Field is Empty!");
            empmodelvalid = 0;
        }else{
            empmodelvalid = 1;
        }
        if(vehicleColor.equals(""))
        {
            showValidationOfVehicleColor.setText("Vehicle Color Field is Empty!");
            empvehcolorvalid = 0;
        }else{
            empvehcolorvalid = 1;
        }
        if(fuelType.equals("Choose Fuel Type"))
        {
            showValidationOfFuelType.setText("Please Choose valid Fuel Type!");
            empfuelvalid = 0;
        }else{
            showValidationOfFuelType.setText(null);
            empfuelvalid = 1;
        }
        if(engineNumber.equals(""))
        {
            showValidationOfEngineNumber.setText("Engine Number Field is Empty!");
            empengnumbvalid = 0;
        }else{
            empengnumbvalid = 1;
        }
        if(displacement.equals(""))
        {
            showValidationOfDisplacement.setText("Displacement Field is Empty!");
            empdispvalid = 0;
        }else{
            empdispvalid = 1;
        }
        if(maximumPower.equals(""))
        {
            showValidationOfMaximumPower.setText("Maximum Power Field is Empty!");
            empmaxpowvalid = 0;
        }else{
            empmaxpowvalid = 1;
        }
        if(maximumTorque.equals(""))
        {
            showValidationOfMaximumTorque.setText("Maximum Torque Field is Empty!");
            empmaxtorvalid = 0;
        }else{
            empmaxtorvalid = 1;
        }
        if(noofSeats.equals(""))
        {
            showValidationOfNoofSeats.setText("No of Seats Field is Empty!");
            empnoofseatvalid = 0;
        }else{
            empnoofseatvalid = 1;
        }
        if(noofGears.equals("Choose No of Gears"))
        {
            showValidationOfNoofGears.setText("Please Choose valid No of Gears!");
            empnoofgearvalid = 0;
        }else{
            showValidationOfNoofGears.setText(null);
            empnoofgearvalid = 1;
        }
        if(tankCapacity.equals(""))
        {
            showValidationOfTankCapacity.setText("Fuel Tank Capacity Field is Empty!");
            emptankvalid = 0;
        }else{
            emptankvalid = 1;
        }
        
        if(empcompvalid == 1 && empvehnumbvalid == 1 && empvehtypevalid == 1 && empmodelvalid == 1 && empvehcolorvalid == 1 && empfuelvalid == 1 && empengnumbvalid == 1 && empdispvalid == 1 && empmaxpowvalid == 1 && empmaxtorvalid == 1 && empnoofseatvalid == 1 && empnoofgearvalid == 1 && emptankvalid == 1)
        {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata","root","");
        
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO vehicledetails VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
        //-----------------------------------------------------------------------------------------------//
        if(compnamevalid == 1 && vehnumbvalid == 1 && modenumbvalid == 1 && vehcolorvalid == 1 && engnumbvalid == 1 && dispvalid == 1 && maxpowvalid == 1 && maxtorqvalid == 1 && noofseavalid == 1 && tankvalid == 1)
        {
        pstmt.setString(1,companyName);
        pstmt.setString(2,vehicleNumber);
        pstmt.setString(3,vehicleType);
        pstmt.setString(4,modelNumber);
        pstmt.setString(5,vehicleColor);
        pstmt.setString(6,fuelType);
        pstmt.setString(7,engineNumber);
        pstmt.setString(8,displacement);
        pstmt.setString(9,maximumPower);
        pstmt.setString(10,maximumTorque);
        pstmt.setString(11,noofSeats);
        pstmt.setString(12,noofGears);
        pstmt.setString(13,tankCapacity);
        
        
        pstmt.executeUpdate();
        
        pstmt.close();
        conn.close();
        
        //JOptionPane.showMessageDialog(null,"Stored Succesfully");
        OwnerRegistration or = new OwnerRegistration();
        or.initComponents(LoginID, vehicleNumber, dateTimeStamp);
        close();
        
        }else{
            JOptionPane.showMessageDialog(null,"Invalid Data Entered!");
            confirmCheckBox.setSelected(false);
        }
        }catch(java.sql.SQLIntegrityConstraintViolationException icve)
        {
        	JOptionPane.showMessageDialog(null,"Vehicle Number is already used!");
        	confirmCheckBox.setSelected(false);
        }
        catch(Exception e)
        {
        	//e.printStackTrace();
            JOptionPane.showMessageDialog(null,e);
            confirmCheckBox.setSelected(false);
        }
        }else{
            JOptionPane.showMessageDialog(null,"Field cannot be left Empty");
            confirmCheckBox.setSelected(false);
        }
        }else{
            JOptionPane.showMessageDialog(null,"Please fill all the fields and tick Checkbox");
            confirmCheckBox.setSelected(false);
        }
    }                                          

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
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
                new VehicleRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration 
    private JLabel loggedInTime;
    private JLabel IDLabel;
    private JLabel MaximumPowerLabel;
    private JLabel RegisterPhotoLabel;
    private JLabel areMandatoryLabel;
    private JButton closeButton;
    private JLabel companyNameLabel;
    private JSeparator companyNameSeparator;
    private JTextField companyNameTextField;
    private JCheckBox confirmCheckBox;
    private JLabel displacementLabel;
    private JSeparator displacementSeparator;
    private JTextField displacementTextField;
    private JLabel engineNumberLabel;
    private JSeparator engineNumberSeparator;
    private JTextField engineNumberTextField;
    private JLabel fieldWithsLabel;
    private JComboBox<String> fuelTypeComboBox;
    private JLabel fuelTypeLabel;
    private JButton homeButton;
    private ItemHandler handler;
    private JLabel litreLabel;
    private JButton logOutButton;
    private JSeparator maximumPowerSeparator;
    private JTextField maximumPowerTextField;
    private JLabel maximumTorqueLabel;
    private JSeparator maximumTorqueSeparator;
    private JTextField maximumTorqueTextField;
    private JLabel modelNumberLabel;
    private JSeparator modelNumberSeparator;
    private JTextField modelNumberTextField;
    private JButton nextButton;
    private JComboBox<String> noofGearsComboBox;
    private JLabel noofGearsLabel;
    private JLabel noofSeatsLabel;
    private JSeparator noofSeatsSeparator;
    private JTextField noofSeatsTextField;
    private JLabel photoLabel;
    private JLabel redmark0;
    private JLabel redmark1;
    private JLabel redmark10;
    private JLabel redmark11;
    private JLabel redmark12;
    private JLabel redmark13;
    private JLabel redmark14;
    private JLabel redmark2;
    private JLabel redmark4;
    private JLabel redmark5;
    private JLabel redmark6;
    private JLabel redmark7;
    private JLabel redmark8;
    private JLabel redmark9;
    private JLabel showValidationOfCompanyName;
    private JLabel showValidationOfDisplacement;
    private JLabel showValidationOfEngineNumber;
    private JLabel showValidationOfFuelType;
    private JLabel showValidationOfMaximumPower;
    private JLabel showValidationOfMaximumTorque;
    private JLabel showValidationOfModelNumber;
    private JLabel showValidationOfNoofGears;
    private JLabel showValidationOfNoofSeats;
    private JLabel showValidationOfTankCapacity;
    private JLabel showValidationOfVehicleColor;
    private JLabel showValidationOfVehicleNumber;
    private JLabel showValidationOfVehicleType;
    private JLabel staffIdLabel;
    private JLabel tankCapacityLabel;
    private JSeparator tankCapacitySeparator;
    private JTextField tankCapacityTextField;
    private JLabel vehicleColorLabel;
    private JSeparator vehicleColorSeparator;
    private JTextField vehicleColorTextField;
    private JLabel vehicleNumberLabel;
    private JSeparator vehicleNumberSeparator;
    private JTextField vehicleNumberTextField;
    private JPanel vehicleRegistrationPanel;
    private JComboBox<String> vehicleTypeComboBox;
    private JLabel vehicleTypeLabel;
    
    // End of variables declaration                   
}
