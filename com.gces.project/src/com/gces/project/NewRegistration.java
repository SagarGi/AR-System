package com.gces.project;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author pravinewa
 */
public class NewRegistration extends JFrame {
    static int sidebar = 0;
    static int mousepX, mousepY;  
    String s = null;
    String fileName = null;
    String imgPath = null;
    static int ownernamevalid = 0, educationvalid = 0, occupationvalid = 0, citizenshipnumbervalid = 0, passportnumbervalid = 0, ownerphotovalid = 0, municipalityvalid = 0, houseNumbervalid = 0, tolevalid = 0, housenumbervalid = 0, contactnumbervalid = 0, emailvalid = 0;
    static int compnamevalid = 0, vehnumbvalid = 0, modenumbvalid = 0, vehcolorvalid = 0, engnumbvalid = 0, dispvalid = 0, maxpowvalid = 0, maxtorqvalid = 0, noofseavalid = 0, tankvalid = 0;
    static String LoginID = null, dateTimeStamp = null;
    static int agevalid = 0;
    public NewRegistration() {
    	this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("jarIcon.png")));
    }
    private void close()
    {
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    public ImageIcon ResizeImage(String imgPath, byte[] pic)
    {
    	ImageIcon MyImage = null;
        if(imgPath!=null)
        {
        MyImage = new ImageIcon(imgPath);
        }else{
            MyImage = new ImageIcon(pic);
        }
        Image img = MyImage.getImage();
    	Image newImage = img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
    	ImageIcon image = new ImageIcon(newImage);
    	return image;
    }


    public void initComponents(String LoginID1, String date) {

    	LoginID = LoginID1;
    	dateTimeStamp = date;
    	
        registerPanel = new JPanel();
        sidebarPanel = new JPanel();
        signOutButton = new JButton();
        showButton = new JButton();
        lineSeparator4 = new JSeparator();
        lineSeparator5 = new JSeparator();
        signOutLabel = new JLabel();
        HideLabel = new JLabel();
        addButton = new JButton();
        searchButton = new JButton();
        lineSeparator3 = new JSeparator();
        lineSeparator2 = new JSeparator();
        lineSeparator1 = new JSeparator();
        searchLabel = new JLabel();
        addLabel = new JLabel();
        lineSeparator6 = new JSeparator();
        homeButton = new JButton();
        homeLabel = new JLabel();
        titlePanel = new JPanel();
        closeButton = new JButton();
        minimizeButton = new JButton();
        showUserLabel = new JLabel();
        showUserLabel1 = new JLabel();
        TabbedPane = new JTabbedPane();
        OwnerScrollPane = new JScrollPane();
        OwnerPanel = new JPanel();
        fieldWithLabel = new JLabel();
        redmark0 = new JLabel();
        areMandatoryLabel = new JLabel();
        ownerNameLabel = new JLabel();
        redmark1 = new JLabel();
        ownerNameTextField = new JTextField();
        ownerNameSeparator = new JSeparator();
        showValidationOfOwnerName = new JLabel();
        dateofBirthLabel = new JLabel();
        redmark4 = new JLabel();
        bDateChooser = new com.toedter.calendar.JDateChooser();
        showValidationOfBDate = new JLabel();
        genderLabel = new JLabel();
        redmark3 = new JLabel();
        maleRadioButton = new JRadioButton();
        femaleRadioButton = new JRadioButton();
        ageLabel = new JLabel();
        showAgeLabel = new JLabel();
        ageSeparator = new JSeparator();
        showValidationOfAge = new JLabel();
        educationLabel = new JLabel();
        educationTextField = new JTextField();
        educationSeparator = new JSeparator();
        showValidationOfEducation = new JLabel();
        occupationLabel = new JLabel();
        occupationTextField = new JTextField();
        occupationSeparator = new JSeparator();
        showValidationOfOccupation = new JLabel();
        citizenshipNumberLabel = new JLabel();
        redmark5 = new JLabel();
        citizenshipNumberTextField = new JTextField();
        citizenshipNumberSeparator = new JSeparator();
        showValidationOfCitizenshipNumber = new JLabel();
        CIDLabel = new JLabel();
        redmark6 = new JLabel();
        CIDComboBox = new JComboBox<>();
        showValidationOfCID = new JLabel();
        passportNumberLabel = new JLabel();
        passportNumberTextField = new JTextField();
        passportNumberSeparator = new JSeparator();
        showValidationOfPassportNumber = new JLabel();
        PIDLabel = new JLabel();
        PIDComboBox = new JComboBox<>();
        showValidationOfPID = new JLabel();
        ownerPhotoLabel = new JLabel();
        redmark7 = new JLabel();
        photoChooseButton = new JButton();
        showValidationOfOwnerPhoto = new JLabel();
        zoneLabel = new JLabel();
        redmark8 = new JLabel();
        zoneComboBox = new JComboBox<>();
        showValidationOfZone = new JLabel();
        districtLabel = new JLabel();
        redmark9 = new JLabel();
        districtComboBox = new JComboBox<>();
        showValidationOfDistrict = new JLabel();
        addressLabel = new JLabel();
        redmark10 = new JLabel();
        addressTextField = new JTextField();
        addressSeparator = new JSeparator();
        showValidationOfAddress = new JLabel();
        houseNumberLabel = new JLabel();
        redmark11 = new JLabel();
        houseNumberTextField = new JTextField();
        houseNumberSeparator = new JSeparator();
        showValidationOfhouseNumber = new JLabel();
        contactNumberLabel = new JLabel();
        redmark14 = new JLabel();
        ContactNumberFrontLabel = new JLabel();
        contactNumberTextField = new JTextField();
        contactNumberSeparator = new JSeparator();
        showValidationOfContactNumber = new JLabel();
        emailLabel = new JLabel();
        emailTextField = new JTextField();
        emailSeparator = new JSeparator();
        showValidationOfEmail = new JLabel();
        VehicleScrollPane = new JScrollPane();
        VehiclePanel = new JPanel();
        fieldWithsLabel = new JLabel();
        redmark2 = new JLabel();
        areMandatoryLabel1 = new JLabel();
        companyNameLabel = new JLabel();
        redmark15 = new JLabel();
        companyNameTextField = new JTextField();
        companyNameSeparator = new JSeparator();
        showValidationOfCompanyName = new JLabel();
        vehicleNumberLabel = new JLabel();
        redmark16 = new JLabel();
        vehicleNumberTextField = new JTextField();
        vehicleNumberSeparator = new JSeparator();
        showValidationOfVehicleNumber = new JLabel();
        vehicleTypeLabel = new JLabel();
        redmark17 = new JLabel();
        vehicleTypeComboBox = new JComboBox<>();
        showValidationOfVehicleType = new JLabel();
        modelNumberLabel = new JLabel();
        redmark18 = new JLabel();
        modelNumberTextField = new JTextField();
        modelNumberSeparator = new JSeparator();
        showValidationOfModelNumber = new JLabel();
        vehicleColorLabel = new JLabel();
        redmark19 = new JLabel();
        vehicleColorTextField = new JTextField();
        vehicleColorSeparator = new JSeparator();
        showValidationOfVehicleColor = new JLabel();
        fuelTypeLabel = new JLabel();
        redmark20 = new JLabel();
        fuelTypeComboBox = new JComboBox<>();
        showValidationOfFuelType = new JLabel();
        engineNumberLabel = new JLabel();
        redmark21 = new JLabel();
        engineNumberTextField = new JTextField();
        engineNumberSeparator = new JSeparator();
        showValidationOfEngineNumber = new JLabel();
        displacementLabel = new JLabel();
        redmark22 = new JLabel();
        displacementTextField = new JTextField();
        displacementSeparator = new JSeparator();
        showValidationOfDisplacement = new JLabel();
        MaximumPowerLabel = new JLabel();
        redmark23 = new JLabel();
        maximumPowerTextField = new JTextField();
        maximumPowerSeparator = new JSeparator();
        showValidationOfMaximumPower = new JLabel();
        maximumTorqueLabel = new JLabel();
        redmark24 = new JLabel();
        maximumTorqueTextField = new JTextField();
        maximumTorqueSeparator = new JSeparator();
        showValidationOfMaximumTorque = new JLabel();
        noofSeatsLabel = new JLabel();
        redmark25 = new JLabel();
        noofSeatsTextField = new JTextField();
        noofSeatsSeparator = new JSeparator();
        showValidationOfNoofSeats = new JLabel();
        noofGearsLabel = new JLabel();
        redmark26 = new JLabel();
        noofGearsComboBox = new JComboBox<>();
        showValidationOfNoofGears = new JLabel();
        tankCapacityLabel = new JLabel();
        redmark27 = new JLabel();
        litreLabel = new JLabel();
        tankCapacityTextField = new JTextField();
        tankCapacitySeparator = new JSeparator();
        showValidationOfTankCapacity = new JLabel();
    	handler = new ItemHandler();
    	handler1 = new ItemHandler();
        confirmCheckBox1 = new JCheckBox();
        submitButton = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1040, 680));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        
        registerPanel.setBackground(new java.awt.Color(255, 255, 255));
        registerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidebarPanel.setBackground(new java.awt.Color(1, 50, 67));

        signOutButton.setBackground(new java.awt.Color(1, 50, 67));
        signOutButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        signOutButton.setForeground(new java.awt.Color(255, 255, 255));
        signOutButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/project/icons/sign-out.png"))); // NOI18N
        signOutButton.setBorder(null);
        signOutButton.setBorderPainted(false);
        signOutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signOutButton.setFocusPainted(false);
        signOutButton.setHorizontalTextPosition(SwingConstants.RIGHT);
        signOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signOutButtonActionPerformed(evt);
            }
        });

        showButton.setBackground(new java.awt.Color(1, 50, 67));
        showButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        showButton.setForeground(new java.awt.Color(255, 255, 255));
        showButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/project/icons/menu.png"))); // NOI18N
        showButton.setBorder(null);
        showButton.setBorderPainted(false);
        showButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showButton.setFocusPainted(false);
        showButton.setHorizontalTextPosition(SwingConstants.RIGHT);
        showButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButtonActionPerformed(evt);
            }
        });

        signOutLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        signOutLabel.setForeground(new java.awt.Color(255, 255, 255));
        signOutLabel.setText("Sign Out");
        signOutLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signOutLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signOutLabelMouseClicked(evt);
            }
        });

        HideLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        HideLabel.setForeground(new java.awt.Color(255, 255, 255));
        HideLabel.setText("Hide");
        HideLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        HideLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HideLabelMouseClicked(evt);
            }
        });

        addButton.setBackground(new java.awt.Color(1, 50, 67));
        addButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/project/icons/add.png"))); // NOI18N
        addButton.setBorder(null);
        addButton.setBorderPainted(false);
        addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addButton.setFocusPainted(false);
        addButton.setHorizontalTextPosition(SwingConstants.RIGHT);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        searchButton.setBackground(new java.awt.Color(1, 50, 67));
        searchButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/project/icons/search.png"))); // NOI18N
        searchButton.setBorder(null);
        searchButton.setBorderPainted(false);
        searchButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchButton.setFocusPainted(false);
        searchButton.setHorizontalTextPosition(SwingConstants.RIGHT);
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        searchLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        searchLabel.setForeground(new java.awt.Color(255, 255, 255));
        searchLabel.setText("Search Details");
        searchLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchLabelMouseClicked(evt);
            }
        });

        addLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addLabel.setForeground(new java.awt.Color(255, 255, 255));
        addLabel.setText("New Register");
        addLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addLabelMouseClicked(evt);
            }
        });

        homeButton.setBackground(new java.awt.Color(1, 50, 67));
        homeButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        homeButton.setForeground(new java.awt.Color(255, 255, 255));
        homeButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/project/icons/home.png"))); // NOI18N
        homeButton.setBorder(null);
        homeButton.setBorderPainted(false);
        homeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homeButton.setFocusPainted(false);
        homeButton.setHorizontalTextPosition(SwingConstants.RIGHT);
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        homeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        homeLabel.setForeground(new java.awt.Color(255, 255, 255));
        homeLabel.setText("Home");
        homeLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeLabelMouseClicked(evt);
            }
        });

        GroupLayout sidebarPanelLayout = new GroupLayout(sidebarPanel);
        sidebarPanel.setLayout(sidebarPanelLayout);
        sidebarPanelLayout.setHorizontalGroup(
            sidebarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(sidebarPanelLayout.createSequentialGroup()
                .addGroup(sidebarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lineSeparator3)
                    .addComponent(lineSeparator2)
                    .addComponent(lineSeparator1)
                    .addComponent(lineSeparator6)
                    .addComponent(lineSeparator4)
                    .addComponent(lineSeparator5)
                    .addGroup(sidebarPanelLayout.createSequentialGroup()
                        .addGroup(sidebarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(sidebarPanelLayout.createSequentialGroup()
                                .addComponent(showButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(HideLabel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
                            .addGroup(sidebarPanelLayout.createSequentialGroup()
                                .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchLabel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
                            .addGroup(sidebarPanelLayout.createSequentialGroup()
                                .addComponent(addButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addLabel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
                            .addGroup(sidebarPanelLayout.createSequentialGroup()
                                .addComponent(homeButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(homeLabel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
                            .addGroup(sidebarPanelLayout.createSequentialGroup()
                                .addComponent(signOutButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(signOutLabel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        sidebarPanelLayout.setVerticalGroup(
            sidebarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(sidebarPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(sidebarPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(showButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addComponent(HideLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addComponent(lineSeparator6, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sidebarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(homeButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addComponent(homeLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lineSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sidebarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(addButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addComponent(addLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lineSeparator2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sidebarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(sidebarPanelLayout.createSequentialGroup()
                        .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lineSeparator3, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
                    .addComponent(searchLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 227, Short.MAX_VALUE)
                .addComponent(lineSeparator4, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sidebarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(sidebarPanelLayout.createSequentialGroup()
                        .addComponent(signOutButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lineSeparator5, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
                    .addComponent(signOutLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        registerPanel.add(sidebarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 40, 650));

        titlePanel.setBackground(new java.awt.Color(0, 0, 0));
        titlePanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                titlePanelMouseDragged(evt);
            }
        });
        titlePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                titlePanelMousePressed(evt);
            }
        });

        closeButton.setBackground(new java.awt.Color(0, 0, 0));
        closeButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/project/icons/close-window.png"))); // NOI18N
        closeButton.setBorderPainted(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closeButton.setFocusable(false);
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        minimizeButton.setBackground(new java.awt.Color(0, 0, 0));
        minimizeButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/project/icons/minimize-window-filled.png"))); // NOI18N
        minimizeButton.setBorderPainted(false);
        minimizeButton.setContentAreaFilled(false);
        minimizeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimizeButton.setFocusable(false);
        minimizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeButtonActionPerformed(evt);
            }
        });

        showUserLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        showUserLabel.setForeground(new java.awt.Color(255, 255, 255));
        showUserLabel.setIcon(new ImageIcon(getClass().getResource("/com/gces/project/icons/user.png"))); // NOI18N
        showUserLabel.setText(LoginID);
        showUserLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showUserLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showUserLabelMouseClicked(evt);
            }
        });

        showUserLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        showUserLabel1.setForeground(new java.awt.Color(255, 255, 255));
        showUserLabel1.setText("Logged in at : "+dateTimeStamp);
        showUserLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        GroupLayout titlePanelLayout = new GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, titlePanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(showUserLabel1, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
                .addGap(294, 294, 294)
                .addComponent(showUserLabel, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 349, Short.MAX_VALUE)
                .addComponent(minimizeButton, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(closeButton, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(titlePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(titlePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(showUserLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(showUserLabel1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addGroup(titlePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(closeButton)
                        .addComponent(minimizeButton))))
        );

        registerPanel.add(titlePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 30));

        TabbedPane.setBackground(new java.awt.Color(255, 255, 255));
        TabbedPane.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));


        OwnerScrollPane.setBackground(new java.awt.Color(255, 255, 255));
        OwnerScrollPane.setBorder(null);
        OwnerScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        OwnerScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        OwnerPanel.setBackground(new java.awt.Color(255, 255, 255));
        OwnerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fieldWithLabel.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        fieldWithLabel.setText("Fields with");
        OwnerPanel.add(fieldWithLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        redmark0.setForeground(new java.awt.Color(255, 0, 0));
        redmark0.setText(" *");
        OwnerPanel.add(redmark0, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 10, -1));

        areMandatoryLabel.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        areMandatoryLabel.setText("are Mandatory");
        OwnerPanel.add(areMandatoryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 190, -1));

        ownerNameLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ownerNameLabel.setText("Owner Name");
        OwnerPanel.add(ownerNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, 20));

        redmark1.setForeground(new java.awt.Color(255, 0, 0));
        redmark1.setText("*");
        OwnerPanel.add(redmark1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 10, -1));

        ownerNameTextField.setBorder(null);
        ownerNameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ownerNameTextFieldKeyReleased(evt);
            }
        });
        OwnerPanel.add(ownerNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 240, 20));
        OwnerPanel.add(ownerNameSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 240, 10));

        showValidationOfOwnerName.setBackground(new java.awt.Color(87, 32, 30));
        showValidationOfOwnerName.setForeground(new java.awt.Color(255, 0, 0));
        OwnerPanel.add(showValidationOfOwnerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 240, -1));

        dateofBirthLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dateofBirthLabel.setText("Date of Birth");
        OwnerPanel.add(dateofBirthLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, -1, -1));

        redmark4.setForeground(new java.awt.Color(255, 0, 0));
        redmark4.setText(" *");
        OwnerPanel.add(redmark4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 10, -1));

        bDateChooser.setBackground(new java.awt.Color(255, 255, 255));
        bDateChooser.setDateFormatString("yyyy-M-dd");
        OwnerPanel.add(bDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 70, 240, 30));

        showValidationOfBDate.setBackground(new java.awt.Color(87, 32, 30));
        showValidationOfBDate.setForeground(new java.awt.Color(255, 0, 0));
        OwnerPanel.add(showValidationOfBDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 100, 240, -1));

        genderLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        genderLabel.setText("Gender");
        OwnerPanel.add(genderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, 20));

        redmark3.setForeground(new java.awt.Color(255, 0, 0));
        redmark3.setText("*");
        OwnerPanel.add(redmark3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, -1, -1));

        maleRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        maleRadioButton.setSelected(true);
        maleRadioButton.setText("Male");
        OwnerPanel.add(maleRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 90, 30));

        femaleRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        femaleRadioButton.setText("Female");
        OwnerPanel.add(femaleRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 100, 30));

        ageLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ageLabel.setText("Age");
        OwnerPanel.add(ageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, -1, -1));

        showAgeLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showAgeLabel.setIcon(new ImageIcon(getClass().getResource("/com/gces/project/icons/click.png"))); // NOI18N
        showAgeLabel.setText("Click to Show Age");
        showAgeLabel.setHorizontalTextPosition(SwingConstants.LEFT);
        showAgeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showAgeLabelMouseClicked(evt);
            }
        });
        OwnerPanel.add(showAgeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 130, 240, 20));
        OwnerPanel.add(ageSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 150, 240, 10));

        showValidationOfAge.setBackground(new java.awt.Color(87, 32, 30));
        showValidationOfAge.setForeground(new java.awt.Color(255, 0, 0));
        OwnerPanel.add(showValidationOfAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 150, 240, -1));

        educationLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        educationLabel.setText("Education");
        OwnerPanel.add(educationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, 20));

        educationTextField.setBorder(null);
        educationTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                educationTextFieldKeyReleased(evt);
            }
        });
        OwnerPanel.add(educationTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 240, 20));
        OwnerPanel.add(educationSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 240, 10));

        showValidationOfEducation.setBackground(new java.awt.Color(87, 32, 30));
        showValidationOfEducation.setForeground(new java.awt.Color(255, 0, 0));
        OwnerPanel.add(showValidationOfEducation, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 240, -1));

        occupationLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        occupationLabel.setText("Occupation");
        OwnerPanel.add(occupationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, -1, 20));

        occupationTextField.setBorder(null);
        occupationTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                occupationTextFieldKeyReleased(evt);
            }
        });
        OwnerPanel.add(occupationTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 180, 240, 20));
        OwnerPanel.add(occupationSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 200, 240, 10));

        showValidationOfOccupation.setBackground(new java.awt.Color(87, 32, 30));
        showValidationOfOccupation.setForeground(new java.awt.Color(255, 0, 0));
        OwnerPanel.add(showValidationOfOccupation, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 200, 240, -1));

        citizenshipNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        citizenshipNumberLabel.setText("Citizenship No");
        OwnerPanel.add(citizenshipNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, -1, 20));

        redmark5.setForeground(new java.awt.Color(255, 0, 0));
        redmark5.setText("*");
        OwnerPanel.add(redmark5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 20, -1));

        citizenshipNumberTextField.setBorder(null);
        citizenshipNumberTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                citizenshipNumberTextFieldKeyReleased(evt);
            }
        });
        OwnerPanel.add(citizenshipNumberTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 240, 20));
        OwnerPanel.add(citizenshipNumberSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 240, 10));

        showValidationOfCitizenshipNumber.setBackground(new java.awt.Color(87, 32, 30));
        showValidationOfCitizenshipNumber.setForeground(new java.awt.Color(255, 0, 0));
        OwnerPanel.add(showValidationOfCitizenshipNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 240, -1));

        CIDLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CIDLabel.setText("Citizenship Issue District");
        OwnerPanel.add(CIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, 160, -1));

        redmark6.setForeground(new java.awt.Color(255, 0, 0));
        redmark6.setText(" *");
        OwnerPanel.add(redmark6, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 230, 10, -1));

        CIDComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Choose issue District", "Achham", "Arghakhanchi", "Baglung", "Baitadi", "Bajhang", "Bajura", "Banke", "Bara", "Bardiya", "Bhaktapur", "Bhojpur", "Chitwan", "Dadeldhura", "Dailekh", "Dang", "Darchula", "Dhading", "Dhankuta", "Dhanusa", "Dholkha", "Dolpa", "Doti", "Gorkha", "Gulmi", "Humla", "Ilam", "Jajarkot", "Jhapa", "Jumla", "Kailali", "Kalikot", "Kanchanpur", "Kapilvastu", "Kaski", "Kathmandu", "Kavrepalanchok", "Khotang", "Lalitpur", "Lamjung", "Mahottari", "Makwanpur", "Manang", "Morang", "Mugu", "Mustang", "Myagdi", "Nawalparasi", "Nuwakot", "Okhaldhunga", "Palpa", "Panchthar", "Parbat", "Parsa", "Pyuthan", "Ramechhap", "Rasuwa", "Rautahat", "Rolpa", "Rukum", "Rupandehi", "Salyan", "Sankhuwasabha", "Saptari", "Sarlahi", "Sindhuli", "Sindhupalchok", "Siraha", "Solukhumbu", "Sunsari", "Surkhet", "Syangja", "Tanahu", "Taplejung", "Terhathum", "Udayapur" }));
        OwnerPanel.add(CIDComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 220, 240, 30));

        showValidationOfCID.setBackground(new java.awt.Color(87, 32, 30));
        showValidationOfCID.setForeground(new java.awt.Color(255, 0, 0));
        OwnerPanel.add(showValidationOfCID, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 250, 240, -1));

        passportNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        passportNumberLabel.setText("Passport Number");
        OwnerPanel.add(passportNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, -1, -1));

        passportNumberTextField.setBorder(null);
        passportNumberTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passportNumberTextFieldKeyReleased(evt);
            }
        });
        OwnerPanel.add(passportNumberTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 240, 20));
        OwnerPanel.add(passportNumberSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 240, 10));

        showValidationOfPassportNumber.setBackground(new java.awt.Color(87, 32, 30));
        showValidationOfPassportNumber.setForeground(new java.awt.Color(255, 0, 0));
        OwnerPanel.add(showValidationOfPassportNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 240, -1));

        PIDLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PIDLabel.setText("Passport Issue District");
        OwnerPanel.add(PIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, -1, -1));

        PIDComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Choose issue District", "Achham", "Arghakhanchi", "Baglung", "Baitadi", "Bajhang", "Bajura", "Banke", "Bara", "Bardiya", "Bhaktapur", "Bhojpur", "Chitwan", "Dadeldhura", "Dailekh", "Dang", "Darchula", "Dhading", "Dhankuta", "Dhanusa", "Dholkha", "Dolpa", "Doti", "Gorkha", "Gulmi", "Humla", "Ilam", "Jajarkot", "Jhapa", "Jumla", "Kailali", "Kalikot", "Kanchanpur", "Kapilvastu", "Kaski", "Kathmandu", "Kavrepalanchok", "Khotang", "Lalitpur", "Lamjung", "Mahottari", "Makwanpur", "Manang", "Morang", "Mugu", "Mustang", "Myagdi", "Nawalparasi", "Nuwakot", "Okhaldhunga", "Palpa", "Panchthar", "Parbat", "Parsa", "Pyuthan", "Ramechhap", "Rasuwa", "Rautahat", "Rolpa", "Rukum", "Rupandehi", "Salyan", "Sankhuwasabha", "Saptari", "Sarlahi", "Sindhuli", "Sindhupalchok", "Siraha", "Solukhumbu", "Sunsari", "Surkhet", "Syangja", "Tanahu", "Taplejung", "Terhathum", "Udayapur" }));
        OwnerPanel.add(PIDComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 270, 240, 30));

        showValidationOfPID.setBackground(new java.awt.Color(87, 32, 30));
        showValidationOfPID.setForeground(new java.awt.Color(255, 0, 0));
        OwnerPanel.add(showValidationOfPID, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 300, 240, -1));

        ownerPhotoLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ownerPhotoLabel.setText("Owner Photo");
        OwnerPanel.add(ownerPhotoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, -1, -1));

        redmark7.setForeground(new java.awt.Color(255, 0, 0));
        redmark7.setText(" *");
        OwnerPanel.add(redmark7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, -1, -1));

        photoChooseButton.setBackground(new java.awt.Color(255, 255, 255));
        photoChooseButton.setText("Choose File");
        photoChooseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                photoChooseButtonActionPerformed(evt);
            }
        });
        OwnerPanel.add(photoChooseButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 240, 30));

        showValidationOfOwnerPhoto.setBackground(new java.awt.Color(87, 32, 30));
        showValidationOfOwnerPhoto.setForeground(new java.awt.Color(255, 0, 0));
        OwnerPanel.add(showValidationOfOwnerPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 240, -1));

        zoneLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        zoneLabel.setText("Zone");
        OwnerPanel.add(zoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, -1, -1));

        redmark8.setForeground(new java.awt.Color(255, 0, 0));
        redmark8.setText(" *");
        OwnerPanel.add(redmark8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 10, -1));

        zoneComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Choose Zone", "Bagmati", "Bheri", "Dhawalagiri", "Gandaki", "Janakpur", "Karnali", "Koshi", "Lumbini", "Mahakali", "Mechi", "Narayani", "Rapti", "Sagarmatha", "Seti" }));
        OwnerPanel.add(zoneComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, 240, 30));
        zoneComboBox.addItemListener(handler);
        showValidationOfZone.setForeground(new java.awt.Color(255, 0, 0));
        OwnerPanel.add(showValidationOfZone, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 240, -1));

        districtLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        districtLabel.setText("District");
        OwnerPanel.add(districtLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, 70, -1));

        redmark9.setForeground(new java.awt.Color(255, 0, 0));
        redmark9.setText("*");
        OwnerPanel.add(redmark9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 380, 10, -1));

        districtComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Choose District", "Achham", "Arghakhanchi", "Baglung", "Baitadi", "Bajhang", "Bajura", "Banke", "Bara", "Bardiya", "Bhaktapur", "Bhojpur", "Chitwan", "Dadeldhura", "Dailekh", "Dang", "Darchula", "Dhading", "Dhankuta", "Dhanusa", "Dholkha", "Dolpa", "Doti", "Gorkha", "Gulmi", "Humla", "Ilam", "Jajarkot", "Jhapa", "Jumla", "Kailali", "Kalikot", "Kanchanpur", "Kapilvastu", "Kaski", "Kathmandu", "Kavrepalanchok", "Khotang", "Lalitpur", "Lamjung", "Mahottari", "Makwanpur", "Manang", "Morang", "Mugu", "Mustang", "Myagdi", "Nawalparasi", "Nuwakot", "Okhaldhunga", "Palpa", "Panchthar", "Parbat", "Parsa", "Pyuthan", "Ramechhap", "Rasuwa", "Rautahat", "Rolpa", "Rukum", "Rupandehi", "Salyan", "Sankhuwasabha", "Saptari", "Sarlahi", "Sindhuli", "Sindhupalchok", "Siraha", "Solukhumbu", "Sunsari", "Surkhet", "Syangja", "Tanahu", "Taplejung", "Terhathum", "Udayapur" }));
        OwnerPanel.add(districtComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 370, 240, 30));

        showValidationOfDistrict.setForeground(new java.awt.Color(255, 0, 0));
        OwnerPanel.add(showValidationOfDistrict, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 400, 240, -1));

        addressLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addressLabel.setText("Address");
        OwnerPanel.add(addressLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, -1, -1));

        redmark10.setForeground(new java.awt.Color(255, 0, 0));
        redmark10.setText(" *");
        OwnerPanel.add(redmark10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 10, -1));

        addressTextField.setBorder(null);
        addressTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                addressTextFieldKeyReleased(evt);
            }
        });
        OwnerPanel.add(addressTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, 240, 20));
        OwnerPanel.add(addressSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, 240, 10));

        showValidationOfAddress.setForeground(new java.awt.Color(255, 0, 0));
        OwnerPanel.add(showValidationOfAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, 240, -1));

        houseNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        houseNumberLabel.setText("House Number");
        OwnerPanel.add(houseNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 430, -1, -1));

        redmark11.setForeground(new java.awt.Color(255, 0, 0));
        redmark11.setText("*");
        OwnerPanel.add(redmark11, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 430, 10, -1));

        houseNumberTextField.setBorder(null);
        houseNumberTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                houseNumberTextFieldKeyReleased(evt);
            }
        });
        OwnerPanel.add(houseNumberTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 420, 240, 20));
        OwnerPanel.add(houseNumberSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 440, 240, 10));

        showValidationOfhouseNumber.setForeground(new java.awt.Color(255, 0, 0));
        OwnerPanel.add(showValidationOfhouseNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 440, 240, -1));

        contactNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        contactNumberLabel.setText("Contact Number");
        OwnerPanel.add(contactNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 480, -1, -1));

        redmark14.setForeground(new java.awt.Color(255, 0, 0));
        redmark14.setText(" *");
        OwnerPanel.add(redmark14, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 480, -1, -1));

        ContactNumberFrontLabel.setText("+977");
        OwnerPanel.add(ContactNumberFrontLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, 30, 20));

        contactNumberTextField.setBorder(null);
        contactNumberTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                contactNumberTextFieldKeyReleased(evt);
            }
        });
        OwnerPanel.add(contactNumberTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 470, 210, 20));
        OwnerPanel.add(contactNumberSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 490, 240, 10));

        showValidationOfContactNumber.setForeground(new java.awt.Color(255, 0, 0));
        OwnerPanel.add(showValidationOfContactNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 490, 240, -1));

        emailLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        emailLabel.setText("Email ");
        OwnerPanel.add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 480, -1, -1));

        emailTextField.setBorder(null);
        emailTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emailTextFieldKeyReleased(evt);
            }
        });
        OwnerPanel.add(emailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 470, 240, 20));
        OwnerPanel.add(emailSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 490, 240, 10));

        showValidationOfEmail.setForeground(new java.awt.Color(255, 0, 0));
        OwnerPanel.add(showValidationOfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 490, 240, -1));

        OwnerScrollPane.setViewportView(OwnerPanel);

        TabbedPane.addTab("Owner Details", OwnerScrollPane);

        VehicleScrollPane.setBackground(new java.awt.Color(255, 255, 255));
        VehicleScrollPane.setBorder(null);
        VehicleScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        VehicleScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        VehiclePanel.setBackground(new java.awt.Color(255, 255, 255));
        VehiclePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fieldWithsLabel.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        fieldWithsLabel.setText("Fields with");
        VehiclePanel.add(fieldWithsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        redmark2.setForeground(new java.awt.Color(255, 0, 0));
        redmark2.setText(" *");
        VehiclePanel.add(redmark2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 10, -1));

        areMandatoryLabel1.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        areMandatoryLabel1.setText("are Mandatory");
        VehiclePanel.add(areMandatoryLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 190, -1));

        companyNameLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        companyNameLabel.setText("Company Name");
        VehiclePanel.add(companyNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

        redmark15.setForeground(new java.awt.Color(255, 0, 0));
        redmark15.setText("*");
        VehiclePanel.add(redmark15, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 10, -1));

        companyNameTextField.setBorder(null);
        companyNameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                companyNameTextFieldKeyReleased(evt);
            }
        });
        VehiclePanel.add(companyNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 240, 20));
        VehiclePanel.add(companyNameSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 240, 10));

        showValidationOfCompanyName.setForeground(new java.awt.Color(255, 0, 0));
        VehiclePanel.add(showValidationOfCompanyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 240, -1));

        vehicleNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        vehicleNumberLabel.setText("Vehicle Number");
        VehiclePanel.add(vehicleNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, -1, -1));

        redmark16.setForeground(new java.awt.Color(255, 0, 0));
        redmark16.setText("*");
        VehiclePanel.add(redmark16, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, -1, -1));

        vehicleNumberTextField.setBorder(null);
        vehicleNumberTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                vehicleNumberTextFieldKeyReleased(evt);
            }
        });
        VehiclePanel.add(vehicleNumberTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 70, 240, 20));
        VehiclePanel.add(vehicleNumberSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 90, 240, 10));

        showValidationOfVehicleNumber.setForeground(new java.awt.Color(255, 0, 0));
        VehiclePanel.add(showValidationOfVehicleNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 90, 240, -1));

        vehicleTypeLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        vehicleTypeLabel.setText("Vehicle Type");
        VehiclePanel.add(vehicleTypeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));

        redmark17.setForeground(new java.awt.Color(255, 0, 0));
        redmark17.setText("*");
        VehiclePanel.add(redmark17, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 10, -1));

        vehicleTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Choose Vehicle Type", "Scooter", "Bike", "Car" }));
        VehiclePanel.add(vehicleTypeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 240, 30));
        vehicleTypeComboBox.addItemListener(handler1);
        showValidationOfVehicleType.setForeground(new java.awt.Color(255, 0, 0));
        VehiclePanel.add(showValidationOfVehicleType, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 240, -1));

        modelNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        modelNumberLabel.setText("Model Number");
        VehiclePanel.add(modelNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, -1, -1));

        redmark18.setForeground(new java.awt.Color(255, 0, 0));
        redmark18.setText(" *");
        VehiclePanel.add(redmark18, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, -1, -1));

        modelNumberTextField.setBorder(null);
        modelNumberTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                modelNumberTextFieldKeyReleased(evt);
            }
        });
        VehiclePanel.add(modelNumberTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 120, 240, 20));
        VehiclePanel.add(modelNumberSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 140, 240, 10));

        showValidationOfModelNumber.setForeground(new java.awt.Color(255, 0, 0));
        VehiclePanel.add(showValidationOfModelNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 140, 240, -1));

        vehicleColorLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        vehicleColorLabel.setText("Vehicle Color");
        VehiclePanel.add(vehicleColorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        redmark19.setForeground(new java.awt.Color(255, 0, 0));
        redmark19.setText("*");
        VehiclePanel.add(redmark19, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 10, -1));

        vehicleColorTextField.setBorder(null);
        vehicleColorTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                vehicleColorTextFieldKeyReleased(evt);
            }
        });
        VehiclePanel.add(vehicleColorTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 240, 20));
        VehiclePanel.add(vehicleColorSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 240, 10));

        showValidationOfVehicleColor.setForeground(new java.awt.Color(255, 0, 0));
        VehiclePanel.add(showValidationOfVehicleColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 240, -1));

        fuelTypeLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fuelTypeLabel.setText("Fuel Type");
        VehiclePanel.add(fuelTypeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, -1, -1));

        redmark20.setForeground(new java.awt.Color(255, 0, 0));
        redmark20.setText(" *");
        VehiclePanel.add(redmark20, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 180, -1, -1));

        fuelTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Choose Fuel Type", "Petrol", "Diesel" }));
        VehiclePanel.add(fuelTypeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 170, 240, 30));

        showValidationOfFuelType.setForeground(new java.awt.Color(255, 0, 0));
        VehiclePanel.add(showValidationOfFuelType, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 200, 240, -1));

        engineNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        engineNumberLabel.setText("Engine Number");
        VehiclePanel.add(engineNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, -1, -1));

        redmark21.setForeground(new java.awt.Color(255, 0, 0));
        redmark21.setText(" *");
        VehiclePanel.add(redmark21, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 10, -1));

        engineNumberTextField.setBorder(null);
        engineNumberTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                engineNumberTextFieldKeyReleased(evt);
            }
        });
        VehiclePanel.add(engineNumberTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 240, 20));
        VehiclePanel.add(engineNumberSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 240, 10));

        showValidationOfEngineNumber.setForeground(new java.awt.Color(255, 0, 0));
        VehiclePanel.add(showValidationOfEngineNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 240, -1));

        displacementLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        displacementLabel.setText("Displacement/CC");
        VehiclePanel.add(displacementLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, -1, -1));

        redmark22.setForeground(new java.awt.Color(255, 0, 0));
        redmark22.setText("*");
        VehiclePanel.add(redmark22, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 230, -1, -1));

        displacementTextField.setBorder(null);
        displacementTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                displacementTextFieldKeyReleased(evt);
            }
        });
        VehiclePanel.add(displacementTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 220, 240, 20));
        VehiclePanel.add(displacementSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 240, 240, 10));

        showValidationOfDisplacement.setForeground(new java.awt.Color(255, 0, 0));
        VehiclePanel.add(showValidationOfDisplacement, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 240, 240, -1));

        MaximumPowerLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        MaximumPowerLabel.setText("Maximum Power");
        VehiclePanel.add(MaximumPowerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, -1, -1));

        redmark23.setForeground(new java.awt.Color(255, 0, 0));
        redmark23.setText(" *");
        VehiclePanel.add(redmark23, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 10, -1));

        maximumPowerTextField.setBorder(null);
        maximumPowerTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                maximumPowerTextFieldKeyReleased(evt);
            }
        });
        VehiclePanel.add(maximumPowerTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 240, 20));
        VehiclePanel.add(maximumPowerSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 240, 10));

        showValidationOfMaximumPower.setForeground(new java.awt.Color(255, 0, 0));
        VehiclePanel.add(showValidationOfMaximumPower, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 240, -1));

        maximumTorqueLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        maximumTorqueLabel.setText("Maximum Torque");
        VehiclePanel.add(maximumTorqueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, -1, -1));

        redmark24.setForeground(new java.awt.Color(255, 0, 0));
        redmark24.setText("*");
        VehiclePanel.add(redmark24, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 280, 10, -1));

        maximumTorqueTextField.setBorder(null);
        maximumTorqueTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                maximumTorqueTextFieldKeyReleased(evt);
            }
        });
        VehiclePanel.add(maximumTorqueTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 270, 240, 20));
        VehiclePanel.add(maximumTorqueSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 290, 240, 10));

        showValidationOfMaximumTorque.setForeground(new java.awt.Color(255, 0, 0));
        VehiclePanel.add(showValidationOfMaximumTorque, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 290, 240, -1));

        noofSeatsLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        noofSeatsLabel.setText("Number of Seats");
        VehiclePanel.add(noofSeatsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 110, -1));

        redmark25.setForeground(new java.awt.Color(255, 0, 0));
        redmark25.setText(" *");
        VehiclePanel.add(redmark25, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 10, -1));

        noofSeatsTextField.setBorder(null);
        noofSeatsTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                noofSeatsTextFieldKeyReleased(evt);
            }
        });
        VehiclePanel.add(noofSeatsTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 240, 20));
        VehiclePanel.add(noofSeatsSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 240, 10));

        showValidationOfNoofSeats.setForeground(new java.awt.Color(255, 0, 0));
        VehiclePanel.add(showValidationOfNoofSeats, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 240, -1));

        noofGearsLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        noofGearsLabel.setText("Number of Gears");
        VehiclePanel.add(noofGearsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 330, -1, -1));

        redmark26.setForeground(new java.awt.Color(255, 0, 0));
        redmark26.setText(" *");
        VehiclePanel.add(redmark26, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 330, -1, -1));

        noofGearsComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Choose No of Gears", "1", "2", "3", "4", "5", "6" }));
        VehiclePanel.add(noofGearsComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 320, 240, 30));

        showValidationOfNoofGears.setForeground(new java.awt.Color(255, 0, 0));
        VehiclePanel.add(showValidationOfNoofGears, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 350, 240, -1));

        tankCapacityLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tankCapacityLabel.setText("Tank Capacity");
        VehiclePanel.add(tankCapacityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, -1, -1));

        redmark27.setForeground(new java.awt.Color(255, 0, 0));
        redmark27.setText("*");
        VehiclePanel.add(redmark27, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 10, -1));

        litreLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        litreLabel.setText("Litre");
        VehiclePanel.add(litreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 370, 40, 20));

        tankCapacityTextField.setBorder(null);
        tankCapacityTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tankCapacityTextFieldKeyReleased(evt);
            }
        });
        VehiclePanel.add(tankCapacityTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, 180, 20));
        VehiclePanel.add(tankCapacitySeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 240, 10));

        showValidationOfTankCapacity.setForeground(new java.awt.Color(255, 0, 0));
        VehiclePanel.add(showValidationOfTankCapacity, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, 230, -1));

        confirmCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        confirmCheckBox1.setText("Tick CheckBox to submit above information");
        VehiclePanel.add(confirmCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 460, 280, 30));

        submitButton.setBackground(new java.awt.Color(255, 255, 255));
        submitButton.setText("Submit");
        submitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        VehiclePanel.add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 520, 80, 30));

        VehicleScrollPane.setViewportView(VehiclePanel);

        TabbedPane.addTab("Vehicle Details", VehicleScrollPane);

        registerPanel.add(TabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 1000, 650));

        getContentPane().add(registerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 680));

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }// </editor-fold>                        

    private void signOutButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
    	int logout1 = JOptionPane.showConfirmDialog(null,"Do you really want to Log Out?","Logout Confirmation",JOptionPane.YES_NO_OPTION);
        if(logout1 == 0)
        {
        LoginForm sl = new LoginForm();
        sl.setVisible(true);
        close();
        }

    }                                             

    private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        switch(sidebar)
        {
            case 0:
            {
                sidebarPanel.setSize(220,650);
                showButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/project/icons/hide.png"))); // NOI18N

                //------------------------------------------------------//
                sidebar = 1;
                break;
            }
            case 1:
            {
                sidebarPanel.setSize(40,650);
                showButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/project/icons/menu.png"))); // NOI18N
                sidebar = 0;
                break;
            }
        }
        System.out.println(sidebar);

    }                                          

    private void signOutLabelMouseClicked(java.awt.event.MouseEvent evt) {                                          
    	int logout1 = JOptionPane.showConfirmDialog(null,"Do you really want to Log Out?","Logout Confirmation",JOptionPane.YES_NO_OPTION);
        if(logout1 == 0)
        {
        LoginForm sl = new LoginForm();
        sl.setVisible(true);
        close();
        }

    }                                         

    private void HideLabelMouseClicked(java.awt.event.MouseEvent evt) {                                       
        switch(sidebar)
        {
            case 0:
            {
                sidebarPanel.setSize(220,650);
                showButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/project/icons/hide.png"))); // NOI18N

                //------------------------------------------------------//
                sidebar = 1;
                break;
            }
            case 1:
            {
                sidebarPanel.setSize(40,650);
                showButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/project/icons/menu.png"))); // NOI18N
                sidebar = 0;
                break;
            }
        }

    }                                      

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        close();
    }                                           

    private void minimizeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        this.setState(NewRegistration.ICONIFIED);
    }                                              

    private void showUserLabelMouseClicked(java.awt.event.MouseEvent evt) {                                           
        ShowStaffDetail dialog = new ShowStaffDetail(new JFrame(), true);
        dialog.initComponents(LoginID);

    }                                          

    private void titlePanelMouseDragged(java.awt.event.MouseEvent evt) {                                        
        int kordinateX = evt.getXOnScreen();
        int kordinateY = evt.getYOnScreen();

        this.setLocation(kordinateX-mousepX, kordinateY-mousepY);
    }                                       

    private void titlePanelMousePressed(java.awt.event.MouseEvent evt) {                                        
        mousepX = evt.getX();
        mousepY = evt.getY();

    }                                       

    private void passportNumberTextFieldKeyReleased(java.awt.event.KeyEvent evt) {                                                    
        String PATTERN = "^[0-9]{0,15}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(passportNumberTextField.getText());
        if(!match.matches())
        {
            showValidationOfPassportNumber.setText("Passport Number is incorrect!");
            passportNumberTextField.setForeground(Color.red);
            passportnumbervalid = 0;
        }
        if(match.matches())
        {
            showValidationOfPassportNumber.setText(null);
            passportNumberTextField.setForeground(Color.black);
            passportnumbervalid = 1;
        }
        if(passportNumberTextField.getText().equals(""))
        {
            showValidationOfPassportNumber.setText(null);
            passportNumberTextField.setForeground(Color.black);
            passportnumbervalid = 0;
        }
    }                                                   

    private void addressTextFieldKeyReleased(java.awt.event.KeyEvent evt) {                                             
        String PATTERN = "^[a-zA-Z0-9\\s]{0,25}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(addressTextField.getText());
        if(!match.matches())
        {
            showValidationOfAddress.setText("Address field is Incorrect!");
            addressTextField.setForeground(Color.red);
            municipalityvalid = 0;
        }
        if(match.matches())
        {
            showValidationOfAddress.setText(null);
            addressTextField.setForeground(Color.black);
            municipalityvalid = 1;
        }
        if(addressTextField.getText().equals(""))
        {
            showValidationOfAddress.setText(null);
            addressTextField.setForeground(Color.black);
            municipalityvalid = 0;
        }
    }                                            

    private void houseNumberTextFieldKeyReleased(java.awt.event.KeyEvent evt) {                                                
        String PATTERN = "^[0-9]{0,5}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(houseNumberTextField.getText());
        if(!match.matches())
        {
            showValidationOfhouseNumber.setText("Ward Number is incorrect!");
            houseNumberTextField.setForeground(Color.red);
            houseNumbervalid = 0;
        }
        if(match.matches())
        {
            showValidationOfhouseNumber.setText(null);
            houseNumberTextField.setForeground(Color.black);
            houseNumbervalid = 1;
        }
        if(houseNumberTextField.getText().equals(""))
        {
            showValidationOfhouseNumber.setText(null);
            houseNumberTextField.setForeground(Color.black);
            houseNumbervalid = 0;
        }
    }                                               

    private void showAgeLabelMouseClicked(java.awt.event.MouseEvent evt) {                                          
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        Date d1 = new Date();
        Date d2 ;

        try {
                //System.out.println(format.format(d1));
                d2 = (Date)format.parse(format.format(bDateChooser.getDate()));
        	long diff = d1.getTime() - d2.getTime();
        	
        	long hours = diff/(60*60*1000);
        	long days = hours/24;
        	long years = days/365;
                showAgeLabel.setText(Long.toString(years));
                
                if(years>=18)
                {
                    agevalid = 1;
                    showValidationOfAge.setText(null);
                    showAgeLabel.setIcon(null);
                }
                else
                {
                    agevalid = 0;
                    showValidationOfAge.setText("Age should be 18+");
                }
        }catch(NullPointerException ne)
        {
            showValidationOfAge.setText("Please select Date of Birth");
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }

    }   
                                     

    private void contactNumberTextFieldKeyReleased(java.awt.event.KeyEvent evt) {                                                   
        String PATTERN = "^[0-9]{10}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(contactNumberTextField.getText());
        if(!match.matches())
        {
            showValidationOfContactNumber.setText("Contact Number is incorrect!");
            contactNumberTextField.setForeground(Color.red);
            contactnumbervalid = 0;
        }
        if(match.matches())
        {
            showValidationOfContactNumber.setText(null);
            contactNumberTextField.setForeground(Color.black);
            contactnumbervalid = 1;
        }
        if(contactNumberTextField.getText().equals(""))
        {
            showValidationOfContactNumber.setText(null);
            contactNumberTextField.setForeground(Color.black);
            contactnumbervalid = 0;
        }
    }                                                  

    private void citizenshipNumberTextFieldKeyReleased(java.awt.event.KeyEvent evt) {                                                       
        String PATTERN = "^[0-9\\-\\s]{0,15}+$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(citizenshipNumberTextField.getText());
        if(!match.matches())
        {
            showValidationOfCitizenshipNumber.setText("Citizenship Number is incorrect!");
            citizenshipNumberTextField.setForeground(Color.red);
            citizenshipnumbervalid = 0;
        }
        if(match.matches())
        {
            showValidationOfCitizenshipNumber.setText(null);
            citizenshipNumberTextField.setForeground(Color.black);
            citizenshipnumbervalid = 1;
        }
        if(citizenshipNumberTextField.getText().equals(""))
        {
            showValidationOfCitizenshipNumber.setText(null);
            citizenshipNumberTextField.setForeground(Color.black);
            citizenshipnumbervalid = 0;
        }
    }                                                      

    private void occupationTextFieldKeyReleased(java.awt.event.KeyEvent evt) {                                                
        String PATTERN = "^[a-zA-Z]{2,25}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(occupationTextField.getText());
        if(!match.matches())
        {
            showValidationOfOccupation.setText("Naming is incorrect!");
            occupationTextField.setForeground(Color.red);
            occupationvalid = 0;
        }
        if(match.matches())
        {
            showValidationOfOccupation.setText(null);
            occupationTextField.setForeground(Color.black);
            occupationvalid = 1;
        }
        if(occupationTextField.getText().equals(""))
        {
            showValidationOfOccupation.setText(null);
            occupationTextField.setForeground(Color.black);
            occupationvalid = 0;
        }
    }                                               

    private void educationTextFieldKeyReleased(java.awt.event.KeyEvent evt) {                                               
        String PATTERN = "^[a-zA-Z]{2,25}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(educationTextField.getText());
        if(!match.matches())
        {
            showValidationOfEducation.setText("Naming is incorrect!");
            educationTextField.setForeground(Color.red);
            educationvalid = 0;
        }
        if(match.matches())
        {
            showValidationOfEducation.setText(null);
            educationTextField.setForeground(Color.black);
            educationvalid = 1;
        }
        if(educationTextField.getText().equals(""))
        {
            showValidationOfEducation.setText(null);
            educationTextField.setForeground(Color.black);
            educationvalid = 0;
        }
    }                                              

    private void ownerNameTextFieldKeyReleased(java.awt.event.KeyEvent evt) {                                               
        String PATTERN = "^[a-zA-Z\\s]{2,22}+$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(ownerNameTextField.getText());
        if(!match.matches())
        {
            showValidationOfOwnerName.setText("Naming is incorrect!");
            ownerNameTextField.setForeground(Color.red);
            ownernamevalid = 0;
        }
        if(match.matches())
        {
            showValidationOfOwnerName.setText(null);
            ownerNameTextField.setForeground(Color.black);
            ownernamevalid = 1;
        }
        if(ownerNameTextField.getText().equals(""))
        {
            showValidationOfOwnerName.setText(null);
            ownerNameTextField.setForeground(Color.black);
            ownernamevalid = 0;
        }
    }                                              

    private void emailTextFieldKeyReleased(java.awt.event.KeyEvent evt) {                                           
        String PATTERN = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(emailTextField.getText());
        if(!match.matches())
        {
            showValidationOfEmail.setText("Email Id is incorrect!");
            emailTextField.setForeground(Color.red);
            emailvalid = 0;
        }
        if(match.matches())
        {
            showValidationOfEmail.setText(null);
            emailTextField.setForeground(Color.black);
            emailvalid = 1;
        }
        if(emailTextField.getText().equals(""))
        {
            showValidationOfEmail.setText(null);
            emailTextField.setForeground(Color.black);
            emailvalid = 0;
        }
    }                                          

    private void photoChooseButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
            File selectedFile = fileChooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            ResizeImage(path,null);
            imgPath = path;
            photoChooseButton.setText("Photo Selected");
            showValidationOfOwnerPhoto.setText(null);
            ownerphotovalid = 1;
        }
        else if(result == JFileChooser.CANCEL_OPTION){
            System.out.println("No Data");
            showValidationOfOwnerPhoto.setText("No Photo Selected");
            ownerphotovalid = 0;
        }
    }                                                 

    private class ItemHandler implements ItemListener{
        public void itemStateChanged(ItemEvent event)
        {
            if(event.getSource()== zoneComboBox)
            {
                if(zoneComboBox.getSelectedItem().equals("Bagmati"))
                {
                    System.out.println("out");
                    districtComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Choose District", "Bhaktapur", "Dhading", "Kathmandu", "Kavrepalanchok", "Lalitpur", "Nuwakot", "Ramechhap", "Rasuwa", "Sindhupalchok"}));
        
                }
                if(zoneComboBox.getSelectedItem().equals("Bheri"))
                {
                    System.out.println("out");
                    districtComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Choose District", "Banke", "Bardiya", "Dailekh", "Jajarkot", "Surkhet"}));
        
                }
                if(zoneComboBox.getSelectedItem().equals("Dhawalagiri"))
                {
                    System.out.println("out");
                    districtComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Choose District", "Baglung", "Mustang", "Myagdi", "Parbat"}));
        
                }
                if(zoneComboBox.getSelectedItem().equals("Gandaki"))
                {
                    System.out.println("out");
                    districtComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Choose District", "Gorkha", "Kaski", "Lamjung", "Manang", "Syangja", "Tanahun"}));
        
                }
                if(zoneComboBox.getSelectedItem().equals("Janakpur"))
                {
                    System.out.println("out");
                    districtComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Choose District", "Dhanusa", "Dolakha", "Mahottari", "Ramechhap", "Sarlahi", "Sindhuli"}));
        
                }
                if(zoneComboBox.getSelectedItem().equals("Karnali"))
                {
                    System.out.println("out");
                    districtComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Choose District", "Dolpa", "Humla", "Jumla", "Kalikot", "Mugu"}));
        
                }
                if(zoneComboBox.getSelectedItem().equals("Koshi"))
                {
                    System.out.println("out");
                    districtComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Choose District", "Bhojpur", "Dhankuta", "Morang", "Sankhuwasabha", "Sunsari", "Terhatjum"}));
        
                }
                if(zoneComboBox.getSelectedItem().equals("Lumbini"))
                {
                    System.out.println("out");
                    districtComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Choose District", "Arghakhanchi", "Gulmi", "Kapilvastu", "Palpa", "Rupandehi", "Nawalparasi"}));
        
                }
                if(zoneComboBox.getSelectedItem().equals("Mahakali"))
                {
                    System.out.println("out");
                    districtComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Choose District", "Baitadi", "Dadeldhura", "Darchula", "Kanchanpur"}));
        
                }
                if(zoneComboBox.getSelectedItem().equals("Mechi"))
                {
                    System.out.println("out");
                    districtComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Choose District", "Ilam", "Jhapa", "Panchtar", "Taplejung"}));
        
                }
                if(zoneComboBox.getSelectedItem().equals("Narayani"))
                {
                    System.out.println("out");
                    districtComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Choose District", "Bara", "Parsa", "Rautahat", "Chitwan", "Makwanpur"}));
        
                }
                if(zoneComboBox.getSelectedItem().equals("Rapti"))
                {
                    System.out.println("out");
                    districtComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Choose District", "Dang", "Pyuthan", "Rolpa", "Rukum", "Salyan"}));
        
                }
                if(zoneComboBox.getSelectedItem().equals("Sagarmatha"))
                {
                    System.out.println("out");
                    districtComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Choose District", "Khotang", "Okhaldhunga", "Solukhambu", "Udayapur", "Saptari", "Siraha"}));
        
                }
                if(zoneComboBox.getSelectedItem().equals("Seti"))
                {
                    System.out.println("out");
                    districtComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Choose District", "Achham", "Bajhang", "Bajura", "Doti", "Kailali"}));
        
                }
                
            }
        
            if(event.getSource()== vehicleTypeComboBox)
            {
                if(vehicleTypeComboBox.getSelectedItem().equals("Scooter"))
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
    private void companyNameTextFieldKeyReleased(java.awt.event.KeyEvent evt) {                                                 
        String PATTERN = "^[a-zA-Z]{0,30}$";
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
            companyNameTextField.setForeground(Color.black);
            compnamevalid = 0;
        }
        if(match.matches())
        {
            showValidationOfCompanyName.setText(null);
            companyNameTextField.setForeground(Color.black);
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
            vehicleNumberTextField.setForeground(Color.black);
            vehnumbvalid = 0;
        }
        if(match.matches())
        {
            showValidationOfVehicleNumber.setText(null);
            vehicleNumberTextField.setForeground(Color.black);
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
            modelNumberTextField.setForeground(Color.black);
            modenumbvalid = 0;
        }
        if(match.matches())
        {
            showValidationOfModelNumber.setText(null);
            modelNumberTextField.setForeground(Color.black);
            modenumbvalid = 1;
        }
    }                                                

    private void vehicleColorTextFieldKeyReleased(java.awt.event.KeyEvent evt) {                                                  
        String PATTERN = "^[a-zA-Z]{2,30}$";
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
            vehicleColorTextField.setForeground(Color.black);
            vehcolorvalid = 0;
        }
        if(match.matches())
        {
            showValidationOfVehicleColor.setText(null);
            vehicleColorTextField.setForeground(Color.black);
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
            engineNumberTextField.setForeground(Color.black);
            engnumbvalid = 0;
        }
        if(match.matches())
        {
            showValidationOfEngineNumber.setText(null);
            engineNumberTextField.setForeground(Color.black);
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
            displacementTextField.setForeground(Color.black);
            dispvalid = 0;
        }
        if(match.matches())
        {
            showValidationOfDisplacement.setText(null);
            displacementTextField.setForeground(Color.black);
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
            maximumPowerTextField.setForeground(Color.black);
            maxpowvalid = 0;
        }
        if(match.matches())
        {
            showValidationOfMaximumPower.setText(null);
            maximumPowerTextField.setForeground(Color.black);
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
            maximumTorqueTextField.setForeground(Color.black);
            maxtorqvalid = 0;
        }
        if(match.matches())
        {
            showValidationOfMaximumTorque.setText(null);
            maximumTorqueTextField.setForeground(Color.black);
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
            noofSeatsTextField.setForeground(Color.black);
            noofseavalid = 0;
        }
        if(match.matches())
        {
            showValidationOfNoofSeats.setText(null);
            noofSeatsTextField.setForeground(Color.black);
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
            tankCapacityTextField.setForeground(Color.black);
            tankvalid = 0;
        }
        if(match.matches())
        {
            showValidationOfTankCapacity.setText(null);
            tankCapacityTextField.setForeground(Color.black);
            tankvalid = 1;
        }
    }                                                 

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if(confirmCheckBox1.isSelected())
        {
        int ovalid = 0, bdatevalid = 0, occvalid = 0, eduvalid = 0, citivalid = 0, cidvalid = 0, zonvalid = 0, distvalid = 0, adrsvalid = 0, wardsvalid = 0, cnumbvalid = 0, empcompvalid = 0, empvehnumbvalid = 0, empvehtypevalid = 0, empmodelvalid = 0, empvehcolorvalid = 0, empfuelvalid = 0, empengnumbvalid = 0, empdispvalid = 0, empmaxpowvalid = 0, empmaxtorvalid = 0, empnoofseatvalid = 0, empnoofgearvalid = 0, emptankvalid = 0;

        //-----------------------------------------------------------------------------------------------//
        String OwnerName = ownerNameTextField.getText();
        //------------//
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        Date d1 = new Date();
        String RDate = new String(format.format(d1));  
        //------------//
        String gender;
        if(maleRadioButton.isSelected())
        {
            gender = maleRadioButton.getText();
        }
        else
        {
            gender = femaleRadioButton.getText();
        }
        String BDate = ((JTextField)bDateChooser.getDateEditor().getUiComponent()).getText();
        String Occupation = occupationTextField.getText();
        String Education = educationTextField.getText();
        String CitizenshipNumber= citizenshipNumberTextField.getText();
        String CID = CIDComboBox.getSelectedItem().toString();
        String PassportNumber = passportNumberTextField.getText();
        String PID = PIDComboBox.getSelectedItem().toString();
        String Zone = zoneComboBox.getSelectedItem().toString();
        String District = districtComboBox.getSelectedItem().toString();
        String Address = addressTextField.getText();
        String houseNumber = houseNumberTextField.getText();        
        String ContactNumber = contactNumberTextField.getText();
        String Email = emailTextField.getText();
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

        if(OwnerName.equals(""))
        {
            showValidationOfOwnerName.setText("Owner Name Field is Empty!");
            ovalid = 0;
        }
        else{
            showValidationOfOwnerName.setText(null);
            ovalid = 1;
        }
        if(BDate.equals(""))
        {
            showValidationOfBDate.setText("Date of Birth Field is Empty!");
            bdatevalid = 0;
        }
        else{
            showValidationOfBDate.setText(null);
            bdatevalid = 1;
        }
        if(CitizenshipNumber.equals(""))
        {
            showValidationOfCitizenshipNumber.setText("Citizenship Number Field is Empty!");
            citivalid = 0;
        }
        else{
            showValidationOfCitizenshipNumber.setText(null);
            citivalid = 1;
        }
        if(CID.equals("Choose issue District"))                                
        {
            showValidationOfCID.setText("Please choose valid District!");
            cidvalid = 0;
        }
        else{
            showValidationOfCID.setText(null);
            cidvalid = 1;
        }
        if(Zone.equals("Choose Zone"))
        {
            showValidationOfZone.setText("Zone Field is Empty!");
            zonvalid = 0;
        }
        else{
            showValidationOfZone.setText(null);
            zonvalid = 1;
        }
        if(District.equals("Choose District"))
        {
            showValidationOfDistrict.setText("Please choose valid District!");
            distvalid = 0;
        }
        else{
            showValidationOfDistrict.setText(null);
            distvalid = 1;
        }
        if(Address.equals(""))
        {
            showValidationOfAddress.setText("Address Field is Empty!!");
            adrsvalid = 0;
        }
        else{
            showValidationOfAddress.setText(null);
            adrsvalid = 1;
        }
        if(houseNumber.equals(""))
        {
            showValidationOfhouseNumber.setText("Ward Number Field is Empty!");
            wardsvalid = 0;
        }
        else{
            showValidationOfhouseNumber.setText(null);
            wardsvalid = 1;
        }
        if(ContactNumber.equals(""))
        {
            showValidationOfContactNumber.setText("Contact Number Field is Empty!");
            cnumbvalid = 0;
        }
        else{
            showValidationOfContactNumber.setText(null);
            cnumbvalid = 1;
        }
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

        
        if(Occupation.equals("")) 
        {
            Occupation = "Empty";
        }
        if(Education.equals(""))
        {
            Education = "Empty";
        }
        if(PassportNumber.equals(""))
        {
            PassportNumber = "Empty";
        }
        
        if(PID.equals("Choose issue District"))
        {
            PID = "Empty";
        }
        if(Email.equals(""))
        {
            Email = "Empty";
        }

                

        //-----------------------------------------------------------------------------------------------//
        
        if(ovalid == 1 && bdatevalid == 1 && citivalid == 1 && cidvalid == 1 && zonvalid == 1 && distvalid == 1 &&  wardsvalid == 1 && adrsvalid == 1 && cnumbvalid == 1 && empcompvalid == 1 && empvehnumbvalid == 1 && empvehtypevalid == 1 && empmodelvalid == 1 && empvehcolorvalid == 1 && empfuelvalid == 1 && empengnumbvalid == 1 && empdispvalid == 1 && empmaxpowvalid == 1 && empmaxtorvalid == 1 && empnoofseatvalid == 1 && empnoofgearvalid == 1 && emptankvalid == 1)   
        {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata","root","");
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO ownervehicledetails VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        
        InputStream is = new FileInputStream(new File(imgPath));
        //-----------------------------------------------------------------------------------------------//
        
        
        //-----------------------------------------------------------------------------------------------//
        if(ownernamevalid == 1 && citizenshipnumbervalid == 1 &&  ownerphotovalid == 1 && houseNumbervalid == 1 && contactnumbervalid == 1 && compnamevalid == 1 && vehnumbvalid == 1 && modenumbvalid == 1 && vehcolorvalid == 1 && engnumbvalid == 1 && dispvalid == 1 && maxpowvalid == 1 && maxtorqvalid == 1 && noofseavalid == 1 && tankvalid == 1)
        {
        if(agevalid == 1)
        {
        pstmt.setString(1,OwnerName);
        pstmt.setString(2,RDate);
        pstmt.setString(3,gender);
        pstmt.setString(4,BDate);
        pstmt.setString(5,Occupation);
        pstmt.setString(6,Education);
        pstmt.setString(7,CitizenshipNumber);
        pstmt.setString(8,CID);
        pstmt.setString(9,PassportNumber);
        pstmt.setString(10,PID);
        pstmt.setString(11,Zone);
        pstmt.setString(12,District);
        pstmt.setString(13,Address);
        pstmt.setString(14,houseNumber);
        pstmt.setString(15,ContactNumber);
        pstmt.setString(16,Email);
        pstmt.setString(17,companyName);
        pstmt.setString(18,vehicleNumber);
        pstmt.setString(19,vehicleType);
        pstmt.setString(20,modelNumber);
        pstmt.setString(21,vehicleColor);
        pstmt.setString(22,fuelType);
        pstmt.setString(23,engineNumber);
        pstmt.setString(24,displacement);
        pstmt.setString(25,maximumPower);
        pstmt.setString(26,maximumTorque);
        pstmt.setString(27,noofSeats);
        pstmt.setString(28,noofGears);
        pstmt.setString(29,tankCapacity);
        pstmt.setBlob(30,is);
       
        pstmt.executeUpdate();
        
        SuccessDialog dialog = new SuccessDialog(new JFrame(), true);
        dialog.setVisible(true);
        OpenPanel op = new OpenPanel();
        op.initComponents(LoginID, dateTimeStamp);
        
        pstmt.close();
        conn.close();
        close();
        
        }else{
        	NotEligibleDialog ned = new NotEligibleDialog(new JFrame(), true);
            ned.setVisible(true);
        	confirmCheckBox1.setSelected(false);
        }
        }else{
        	InvalidDialog id = new InvalidDialog(new JFrame(), true);
            id.setVisible(true);	
        	confirmCheckBox1.setSelected(false);
        }
        }catch(java.sql.SQLIntegrityConstraintViolationException icve)
        {
        	DoubleVNDialog dialog = new DoubleVNDialog(new JFrame(), true);
            dialog.setVisible(true);
        	confirmCheckBox1.setSelected(false);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        }else
        {
        	EmptyDialog wd = new EmptyDialog(new JFrame(), true);
            wd.setVisible(true);
        	confirmCheckBox1.setSelected(false);
        }
        }else{
        	CheckboxDialog dialo = new CheckboxDialog(new JFrame(), true);
            dialo.setVisible(true);
        	confirmCheckBox1.setSelected(false);
        }
    }                                            

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
    	//do nothing
    }                                         

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
    	SearchDetails sd = new SearchDetails();
        sd.initComponents(LoginID, dateTimeStamp);
        close();    }                                            

    private void searchLabelMouseClicked(java.awt.event.MouseEvent evt) {                                         
    	SearchDetails sd = new SearchDetails();
        sd.initComponents(LoginID, dateTimeStamp);
        close();    }                                        

    private void addLabelMouseClicked(java.awt.event.MouseEvent evt) {                                      
    	//do nothing
    }                                     

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
    	OpenPanel op = new OpenPanel();
        op.initComponents(LoginID, dateTimeStamp);
        close();
    }                                          

    private void homeLabelMouseClicked(java.awt.event.MouseEvent evt) {                                       
        OpenPanel op = new OpenPanel();
        op.initComponents(LoginID, dateTimeStamp);
        close();
    }                                      

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewRegistration().setVisible(true);
            }
        });
    }

    private JComboBox<String> CIDComboBox;
    private JLabel CIDLabel;
    private JLabel ContactNumberFrontLabel;
    private JLabel HideLabel;
    private JLabel MaximumPowerLabel;
    private JPanel OwnerPanel;
    private JScrollPane OwnerScrollPane;
    private JComboBox<String> PIDComboBox;
    private JLabel PIDLabel;
    private JTabbedPane TabbedPane;
    private JPanel VehiclePanel;
    private JScrollPane VehicleScrollPane;
    private JButton addButton;
    private JLabel addLabel;
    private JLabel addressLabel;
    private JSeparator addressSeparator;
    private JTextField addressTextField;
    private JLabel ageLabel;
    private JSeparator ageSeparator;
    private JLabel areMandatoryLabel;
    private JLabel areMandatoryLabel1;
    private com.toedter.calendar.JDateChooser bDateChooser;
    private JLabel citizenshipNumberLabel;
    private JSeparator citizenshipNumberSeparator;
    private JTextField citizenshipNumberTextField;
    private JButton closeButton;
    private JLabel companyNameLabel;
    private JSeparator companyNameSeparator;
    private JTextField companyNameTextField;
    private JCheckBox confirmCheckBox1;
    private JLabel contactNumberLabel;
    private JSeparator contactNumberSeparator;
    private JTextField contactNumberTextField;
    private JLabel dateofBirthLabel;
    private JLabel displacementLabel;
    private JSeparator displacementSeparator;
    private JTextField displacementTextField;
    private JComboBox<String> districtComboBox;
    private JLabel districtLabel;
    private JLabel educationLabel;
    private JSeparator educationSeparator;
    private JTextField educationTextField;
    private JLabel emailLabel;
    private JSeparator emailSeparator;
    private JTextField emailTextField;
    private JLabel engineNumberLabel;
    private JSeparator engineNumberSeparator;
    private JTextField engineNumberTextField;
    private JRadioButton femaleRadioButton;
    private JLabel fieldWithLabel;
    private JLabel fieldWithsLabel;
    private JComboBox<String> fuelTypeComboBox;
    private JLabel fuelTypeLabel;
    private JLabel genderLabel;
    private JButton homeButton;
    private JLabel homeLabel;
    private JSeparator lineSeparator1;
    private JSeparator lineSeparator2;
    private JSeparator lineSeparator3;
    private JSeparator lineSeparator4;
    private JSeparator lineSeparator5;
    private JSeparator lineSeparator6;
    private JLabel litreLabel;
    private JRadioButton maleRadioButton;
    private JSeparator maximumPowerSeparator;
    private JTextField maximumPowerTextField;
    private JLabel maximumTorqueLabel;
    private JSeparator maximumTorqueSeparator;
    private JTextField maximumTorqueTextField;
    private JButton minimizeButton;
    private JLabel modelNumberLabel;
    private JSeparator modelNumberSeparator;
    private JTextField modelNumberTextField;
    private JComboBox<String> noofGearsComboBox;
    private JLabel noofGearsLabel;
    private JLabel noofSeatsLabel;
    private JSeparator noofSeatsSeparator;
    private JTextField noofSeatsTextField;
    private JLabel occupationLabel;
    private JSeparator occupationSeparator;
    private JTextField occupationTextField;
    private JLabel ownerNameLabel;
    private JSeparator ownerNameSeparator;
    private JTextField ownerNameTextField;
    private JLabel ownerPhotoLabel;
    private JLabel passportNumberLabel;
    private JSeparator passportNumberSeparator;
    private JTextField passportNumberTextField;
    private JButton photoChooseButton;
    private JLabel redmark0;
    private JLabel redmark1;
    private JLabel redmark10;
    private JLabel redmark11;
    private JLabel redmark14;
    private JLabel redmark15;
    private JLabel redmark16;
    private JLabel redmark17;
    private JLabel redmark18;
    private JLabel redmark19;
    private JLabel redmark2;
    private JLabel redmark20;
    private JLabel redmark21;
    private JLabel redmark22;
    private JLabel redmark23;
    private JLabel redmark24;
    private JLabel redmark25;
    private JLabel redmark26;
    private JLabel redmark27;
    private JLabel redmark3;
    private JLabel redmark4;
    private JLabel redmark5;
    private JLabel redmark6;
    private JLabel redmark7;
    private JLabel redmark8;
    private JLabel redmark9;
    private JPanel registerPanel;
    private JButton searchButton;
    private JLabel searchLabel;
    private JLabel showAgeLabel;
    private JButton showButton;
    private JLabel showUserLabel;
    private JLabel showUserLabel1;
    private JLabel showValidationOfAddress;
    private JLabel showValidationOfAge;
    private JLabel showValidationOfBDate;
    private JLabel showValidationOfCID;
    private JLabel showValidationOfCitizenshipNumber;
    private JLabel showValidationOfCompanyName;
    private JLabel showValidationOfContactNumber;
    private JLabel showValidationOfDisplacement;
    private JLabel showValidationOfDistrict;
    private JLabel showValidationOfEducation;
    private JLabel showValidationOfEmail;
    private JLabel showValidationOfEngineNumber;
    private JLabel showValidationOfFuelType;
    private JLabel showValidationOfMaximumPower;
    private JLabel showValidationOfMaximumTorque;
    private JLabel showValidationOfModelNumber;
    private JLabel showValidationOfNoofGears;
    private JLabel showValidationOfNoofSeats;
    private JLabel showValidationOfOccupation;
    private JLabel showValidationOfOwnerName;
    private JLabel showValidationOfOwnerPhoto;
    private JLabel showValidationOfPID;
    private JLabel showValidationOfPassportNumber;
    private JLabel showValidationOfTankCapacity;
    private JLabel showValidationOfVehicleColor;
    private JLabel showValidationOfVehicleNumber;
    private JLabel showValidationOfVehicleType;
    private JLabel showValidationOfhouseNumber;
    private JLabel showValidationOfZone;
    private JPanel sidebarPanel;
    private JButton signOutButton;
    private JLabel signOutLabel;
    private JButton submitButton;
    private JLabel tankCapacityLabel;
    private JSeparator tankCapacitySeparator;
    private JTextField tankCapacityTextField;
    private JPanel titlePanel;
    private JLabel vehicleColorLabel;
    private JSeparator vehicleColorSeparator;
    private JTextField vehicleColorTextField;
    private JLabel vehicleNumberLabel;
    private JSeparator vehicleNumberSeparator;
    private JTextField vehicleNumberTextField;
    private JComboBox<String> vehicleTypeComboBox;
    private JLabel vehicleTypeLabel;
    private JLabel houseNumberLabel;
    private JSeparator houseNumberSeparator;
    private JTextField houseNumberTextField;
    private JComboBox<String> zoneComboBox;
    private JLabel zoneLabel;
    private ItemHandler handler;
    private ItemHandler handler1;
}
