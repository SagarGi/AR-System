package com.gces.project;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.*;

public class ShowRegister extends JFrame {

	static String LoginID , dateTimeStamp, vehicleno;
    static int sidebar = 0;
    static int mousepX, mousepY;  

    public ShowRegister() {
    	this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("jarIcon.png")));
    }
    private void close()
    {
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    //---------------------------------------------------------------------//
    //resize image
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
    //---------------------------------------------------------------------//

    public void initComponents(String LoginID1,String vehicleno1, String date) {

    	LoginID = LoginID1;
    	vehicleno = vehicleno1;
    	dateTimeStamp = date;


    mainPanel = new JPanel();
    sidebarPanel = new JPanel();
    addButton = new JButton();
    searchButton = new JButton();
    signOutButton = new JButton();
    showButton = new JButton();
    lineSeparator3 = new JSeparator();
    lineSeparator2 = new JSeparator();
    lineSeparator1 = new JSeparator();
    lineSeparator4 = new JSeparator();
    lineSeparator5 = new JSeparator();
    signOutLabel = new JLabel();
    HideLabel = new JLabel();
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
    detailScrollPane = new JScrollPane();
    subPanel = new JPanel();
    showOwnerName = new JLabel();
    registrationDateLabel = new JLabel();
    showRegistrationDate = new JLabel();
    genderLabel = new JLabel();
    showGender = new JLabel();
    dateofBirthLabel = new JLabel();
    showDateOfBirth = new JLabel();
    educationLabel = new JLabel();
    showOwnerEducation = new JLabel();
    occupationLabel = new JLabel();
    showOccupation = new JLabel();
    citizenshipNumberLabel = new JLabel();
    showOwnerCitizenshipNumber = new JLabel();
    CIDLabel = new JLabel();
    showCID = new JLabel();
    passportNumberLabel = new JLabel();
    showPassportNumber = new JLabel();
    PIDLabel = new JLabel();
    showPID = new JLabel();
    zoneLabel = new JLabel();
    showZone = new JLabel();
    districtLabel = new JLabel();
    showDistrict = new JLabel();
    addressLabel = new JLabel();
    showAddress = new JLabel();
    houseNumberLabel = new JLabel();
    showHouseNumber = new JLabel();
    contactNumberLabel = new JLabel();
    ContactNumberFrontLabel = new JLabel();
    showContactNumber = new JLabel();
    emailLabel = new JLabel();
    showEmail = new JLabel();
    showOwnerPhoto = new JLabel();
    ownerNameLabel = new JLabel();
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
    titleSeparator1 = new JSeparator();
    titleSeparator2 = new JSeparator();
    vehicleTitleLabel = new JLabel();
    ownerTitleLabel = new JLabel();
    titleSeparator3 = new JSeparator();
    scrollToUp = new JLabel();
    backButton = new JButton();

    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    setUndecorated(true);
    setPreferredSize(new java.awt.Dimension(1040, 680));
    setResizable(false);
    getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    mainPanel.setBackground(new java.awt.Color(255, 255, 255));
    mainPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));
    mainPanel.setPreferredSize(new java.awt.Dimension(1040, 680));
    mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    sidebarPanel.setBackground(new java.awt.Color(1, 50, 67));

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
        .addComponent(lineSeparator4)
        .addComponent(lineSeparator5)
        .addGroup(sidebarPanelLayout.createSequentialGroup()
            .addGroup(sidebarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(lineSeparator3)
                .addComponent(lineSeparator2)
                .addComponent(lineSeparator1)
                .addComponent(lineSeparator6)
                .addGroup(sidebarPanelLayout.createSequentialGroup()
                    .addGroup(sidebarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(sidebarPanelLayout.createSequentialGroup()
                            .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(searchLabel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
                        .addGroup(sidebarPanelLayout.createSequentialGroup()
                            .addComponent(showButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(HideLabel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
                        .addGroup(sidebarPanelLayout.createSequentialGroup()
                            .addComponent(signOutButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(signOutLabel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
                        .addGroup(sidebarPanelLayout.createSequentialGroup()
                            .addComponent(addButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(addLabel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
                        .addGroup(sidebarPanelLayout.createSequentialGroup()
                            .addComponent(homeButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(homeLabel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)))
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
            .addGap(64, 64, 64)
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
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
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

    mainPanel.add(sidebarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 40, 650));

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

    mainPanel.add(titlePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 30));

    detailScrollPane.setBackground(new java.awt.Color(255, 255, 255));
    detailScrollPane.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));
    detailScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    detailScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

    subPanel.setBackground(new java.awt.Color(255, 255, 255));
    subPanel.setPreferredSize(new java.awt.Dimension(900, 1200));
    subPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    showOwnerName.setBackground(new java.awt.Color(255, 255, 255));
    showOwnerName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    showOwnerName.setText("Null");
    subPanel.add(showOwnerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 220, -1));

    registrationDateLabel.setBackground(new java.awt.Color(255, 255, 255));
    registrationDateLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    registrationDateLabel.setForeground(new java.awt.Color(1, 50, 67));
    registrationDateLabel.setText("Registration Date");
    subPanel.add(registrationDateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, -1, -1));

    showRegistrationDate.setBackground(new java.awt.Color(255, 255, 255));
    showRegistrationDate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    showRegistrationDate.setText("Null");
    subPanel.add(showRegistrationDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 220, 20));

    genderLabel.setBackground(new java.awt.Color(255, 255, 255));
    genderLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    genderLabel.setForeground(new java.awt.Color(1, 50, 67));
    genderLabel.setText("Gender");
    subPanel.add(genderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, -1, -1));

    showGender.setBackground(new java.awt.Color(255, 255, 255));
    showGender.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    showGender.setText("Null");
    subPanel.add(showGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 220, 20));

    dateofBirthLabel.setBackground(new java.awt.Color(255, 255, 255));
    dateofBirthLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    dateofBirthLabel.setForeground(new java.awt.Color(1, 50, 67));
    dateofBirthLabel.setText("Date of Birth");
    subPanel.add(dateofBirthLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, -1, -1));

    showDateOfBirth.setBackground(new java.awt.Color(255, 255, 255));
    showDateOfBirth.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    showDateOfBirth.setText("Null");
    subPanel.add(showDateOfBirth, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 220, 20));

    educationLabel.setBackground(new java.awt.Color(255, 255, 255));
    educationLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    educationLabel.setForeground(new java.awt.Color(1, 50, 67));
    educationLabel.setText("Education");
    subPanel.add(educationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, -1, -1));

    showOwnerEducation.setBackground(new java.awt.Color(255, 255, 255));
    showOwnerEducation.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    showOwnerEducation.setText("Null");
    subPanel.add(showOwnerEducation, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 220, 20));

    occupationLabel.setBackground(new java.awt.Color(255, 255, 255));
    occupationLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    occupationLabel.setForeground(new java.awt.Color(1, 50, 67));
    occupationLabel.setText("Occupation");
    subPanel.add(occupationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, -1, -1));

    showOccupation.setBackground(new java.awt.Color(255, 255, 255));
    showOccupation.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    showOccupation.setText("Null");
    subPanel.add(showOccupation, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 310, 220, 20));

    citizenshipNumberLabel.setBackground(new java.awt.Color(255, 255, 255));
    citizenshipNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    citizenshipNumberLabel.setForeground(new java.awt.Color(1, 50, 67));
    citizenshipNumberLabel.setText("Citizenship No");
    subPanel.add(citizenshipNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, -1, 30));

    showOwnerCitizenshipNumber.setBackground(new java.awt.Color(255, 255, 255));
    showOwnerCitizenshipNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    showOwnerCitizenshipNumber.setText("Null");
    subPanel.add(showOwnerCitizenshipNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 220, 20));

    CIDLabel.setBackground(new java.awt.Color(255, 255, 255));
    CIDLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    CIDLabel.setForeground(new java.awt.Color(1, 50, 67));
    CIDLabel.setText("Citizenship Issue District");
    subPanel.add(CIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 360, 160, -1));

    showCID.setBackground(new java.awt.Color(255, 255, 255));
    showCID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    showCID.setText("Null");
    subPanel.add(showCID, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 360, 220, 20));

    passportNumberLabel.setBackground(new java.awt.Color(255, 255, 255));
    passportNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    passportNumberLabel.setForeground(new java.awt.Color(1, 50, 67));
    passportNumberLabel.setText("Passport Number");
    subPanel.add(passportNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, -1, -1));

    showPassportNumber.setBackground(new java.awt.Color(255, 255, 255));
    showPassportNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    showPassportNumber.setText("Null");
    subPanel.add(showPassportNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 220, 20));

    PIDLabel.setBackground(new java.awt.Color(255, 255, 255));
    PIDLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    PIDLabel.setForeground(new java.awt.Color(1, 50, 67));
    PIDLabel.setText("Passport Issue District");
    subPanel.add(PIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 410, -1, -1));

    showPID.setBackground(new java.awt.Color(255, 255, 255));
    showPID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    showPID.setText("Null");
    subPanel.add(showPID, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 410, 220, 20));

    zoneLabel.setBackground(new java.awt.Color(255, 255, 255));
    zoneLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    zoneLabel.setForeground(new java.awt.Color(1, 50, 67));
    zoneLabel.setText("Zone");
    subPanel.add(zoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 460, -1, -1));

    showZone.setBackground(new java.awt.Color(255, 255, 255));
    showZone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    showZone.setText("Null");
    subPanel.add(showZone, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 460, 220, 20));

    districtLabel.setBackground(new java.awt.Color(255, 255, 255));
    districtLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    districtLabel.setForeground(new java.awt.Color(1, 50, 67));
    districtLabel.setText("District");
    subPanel.add(districtLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 460, 50, -1));

    showDistrict.setBackground(new java.awt.Color(255, 255, 255));
    showDistrict.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    showDistrict.setText("Null");
    subPanel.add(showDistrict, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 460, 220, 20));

    addressLabel.setBackground(new java.awt.Color(255, 255, 255));
    addressLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    addressLabel.setForeground(new java.awt.Color(1, 50, 67));
    addressLabel.setText("Address");
    subPanel.add(addressLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 510, -1, -1));

    showAddress.setBackground(new java.awt.Color(255, 255, 255));
    showAddress.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    showAddress.setText("Null");
    subPanel.add(showAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 510, 220, 20));

    houseNumberLabel.setBackground(new java.awt.Color(255, 255, 255));
    houseNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    houseNumberLabel.setForeground(new java.awt.Color(1, 50, 67));
    houseNumberLabel.setText("House Number");
    subPanel.add(houseNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 510, -1, -1));

    showHouseNumber.setBackground(new java.awt.Color(255, 255, 255));
    showHouseNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    showHouseNumber.setText("Null");
    subPanel.add(showHouseNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 510, 220, 20));

    contactNumberLabel.setBackground(new java.awt.Color(255, 255, 255));
    contactNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    contactNumberLabel.setForeground(new java.awt.Color(1, 50, 67));
    contactNumberLabel.setText("Contact Number");
    subPanel.add(contactNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 560, -1, -1));

    ContactNumberFrontLabel.setBackground(new java.awt.Color(255, 255, 255));
    ContactNumberFrontLabel.setText("+977");
    subPanel.add(ContactNumberFrontLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 560, 30, 20));

    showContactNumber.setBackground(new java.awt.Color(255, 255, 255));
    showContactNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    showContactNumber.setText("Null");
    subPanel.add(showContactNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 560, 190, 20));

    emailLabel.setBackground(new java.awt.Color(255, 255, 255));
    emailLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    emailLabel.setForeground(new java.awt.Color(1, 50, 67));
    emailLabel.setText("Email ");
    subPanel.add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 560, -1, -1));

    showEmail.setBackground(new java.awt.Color(255, 255, 255));
    showEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    showEmail.setText("Null");
    subPanel.add(showEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 560, 220, 20));

    showOwnerPhoto.setBackground(new java.awt.Color(255, 255, 255));
    showOwnerPhoto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    showOwnerPhoto.setText("Photo");
    showOwnerPhoto.setBorder(new javax.swing.border.MatteBorder(null));
    showOwnerPhoto.setMaximumSize(new java.awt.Dimension(170, 170));
    showOwnerPhoto.setMinimumSize(new java.awt.Dimension(170, 170));
    showOwnerPhoto.setPreferredSize(new java.awt.Dimension(170, 170));
    subPanel.add(showOwnerPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 170, 170));

    ownerNameLabel.setBackground(new java.awt.Color(255, 255, 255));
    ownerNameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    ownerNameLabel.setForeground(new java.awt.Color(1, 50, 67));
    ownerNameLabel.setText("Owner Name");
    subPanel.add(ownerNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

    companyNameLabel.setBackground(new java.awt.Color(255, 255, 255));
    companyNameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    companyNameLabel.setForeground(new java.awt.Color(1, 50, 67));
    companyNameLabel.setText("Company Name");
    subPanel.add(companyNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 790, -1, -1));

    showCompanyName.setBackground(new java.awt.Color(255, 255, 255));
    showCompanyName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    showCompanyName.setText("Null");
    subPanel.add(showCompanyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 790, 220, 20));

    vehicleNumberLabel.setBackground(new java.awt.Color(255, 255, 255));
    vehicleNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    vehicleNumberLabel.setForeground(new java.awt.Color(1, 50, 67));
    vehicleNumberLabel.setText("Vehicle Number");
    subPanel.add(vehicleNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 790, -1, -1));

    showVehicleNumber.setBackground(new java.awt.Color(255, 255, 255));
    showVehicleNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    showVehicleNumber.setText("Null");
    subPanel.add(showVehicleNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 790, 220, 20));

    vehicleTypeLabel.setBackground(new java.awt.Color(255, 255, 255));
    vehicleTypeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    vehicleTypeLabel.setForeground(new java.awt.Color(1, 50, 67));
    vehicleTypeLabel.setText("Vehicle Type");
    subPanel.add(vehicleTypeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 840, -1, -1));

    showVehicleType.setBackground(new java.awt.Color(255, 255, 255));
    showVehicleType.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    showVehicleType.setText("Null");
    subPanel.add(showVehicleType, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 840, 220, 20));

    modelNumberLabel.setBackground(new java.awt.Color(255, 255, 255));
    modelNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    modelNumberLabel.setForeground(new java.awt.Color(1, 50, 67));
    modelNumberLabel.setText("Model Number");
    subPanel.add(modelNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 840, -1, -1));

    showModelNumber.setBackground(new java.awt.Color(255, 255, 255));
    showModelNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    showModelNumber.setText("Null");
    subPanel.add(showModelNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 840, 220, 20));

    vehicleColorLabel.setBackground(new java.awt.Color(255, 255, 255));
    vehicleColorLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    vehicleColorLabel.setForeground(new java.awt.Color(1, 50, 67));
    vehicleColorLabel.setText("Vehicle Color");
    subPanel.add(vehicleColorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 890, -1, -1));

    showVehicleColor.setBackground(new java.awt.Color(255, 255, 255));
    showVehicleColor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    showVehicleColor.setText("Null");
    subPanel.add(showVehicleColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 890, 220, 20));

    fuelTypeLabel.setBackground(new java.awt.Color(255, 255, 255));
    fuelTypeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    fuelTypeLabel.setForeground(new java.awt.Color(1, 50, 67));
    fuelTypeLabel.setText("Fuel Type");
    subPanel.add(fuelTypeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 890, -1, -1));

    showFuelType.setBackground(new java.awt.Color(255, 255, 255));
    showFuelType.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    showFuelType.setText("Null");
    subPanel.add(showFuelType, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 890, 220, 20));

    engineNumberLabel.setBackground(new java.awt.Color(255, 255, 255));
    engineNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    engineNumberLabel.setForeground(new java.awt.Color(1, 50, 67));
    engineNumberLabel.setText("Engine Number");
    subPanel.add(engineNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 940, -1, -1));

    showEngineNumber.setBackground(new java.awt.Color(255, 255, 255));
    showEngineNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    showEngineNumber.setText("Null");
    subPanel.add(showEngineNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 940, 220, 20));

    displacementLabel.setBackground(new java.awt.Color(255, 255, 255));
    displacementLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    displacementLabel.setForeground(new java.awt.Color(1, 50, 67));
    displacementLabel.setText("Displacement/CC");
    subPanel.add(displacementLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 940, -1, -1));

    showDisplacement.setBackground(new java.awt.Color(255, 255, 255));
    showDisplacement.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    showDisplacement.setText("Null");
    subPanel.add(showDisplacement, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 940, 220, 20));

    maximumPowerLabel.setBackground(new java.awt.Color(255, 255, 255));
    maximumPowerLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    maximumPowerLabel.setForeground(new java.awt.Color(1, 50, 67));
    maximumPowerLabel.setText("Maximum Power");
    subPanel.add(maximumPowerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 990, -1, -1));

    showMaximumPower.setBackground(new java.awt.Color(255, 255, 255));
    showMaximumPower.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    showMaximumPower.setText("Null");
    subPanel.add(showMaximumPower, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 990, 220, 20));

    maximumTorqueLabel.setBackground(new java.awt.Color(255, 255, 255));
    maximumTorqueLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    maximumTorqueLabel.setForeground(new java.awt.Color(1, 50, 67));
    maximumTorqueLabel.setText("Maximum Torque");
    subPanel.add(maximumTorqueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 990, -1, -1));

    showMaximumTorque.setBackground(new java.awt.Color(255, 255, 255));
    showMaximumTorque.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    showMaximumTorque.setText("Null");
    subPanel.add(showMaximumTorque, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 990, 220, 20));

    noofSeatsLabel.setBackground(new java.awt.Color(255, 255, 255));
    noofSeatsLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    noofSeatsLabel.setForeground(new java.awt.Color(1, 50, 67));
    noofSeatsLabel.setText("Number of Seats");
    subPanel.add(noofSeatsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 1040, -1, -1));

    showNoofSeats.setBackground(new java.awt.Color(255, 255, 255));
    showNoofSeats.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    showNoofSeats.setText("Null");
    subPanel.add(showNoofSeats, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1040, 220, 20));

    noofGearsLabel.setBackground(new java.awt.Color(255, 255, 255));
    noofGearsLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    noofGearsLabel.setForeground(new java.awt.Color(1, 50, 67));
    noofGearsLabel.setText("Number of Gears");
    subPanel.add(noofGearsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 1040, -1, -1));

    showNoofGears.setBackground(new java.awt.Color(255, 255, 255));
    showNoofGears.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    showNoofGears.setText("Null");
    subPanel.add(showNoofGears, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 1040, 220, 20));

    tankCapacityLabel.setBackground(new java.awt.Color(255, 255, 255));
    tankCapacityLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    tankCapacityLabel.setForeground(new java.awt.Color(1, 50, 67));
    tankCapacityLabel.setText("Tank Capacity");
    subPanel.add(tankCapacityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 1090, -1, -1));

    showTankCapacity.setBackground(new java.awt.Color(255, 255, 255));
    showTankCapacity.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    showTankCapacity.setText("Null");
    subPanel.add(showTankCapacity, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1090, 40, 20));

    litreLabel.setBackground(new java.awt.Color(255, 255, 255));
    litreLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    litreLabel.setText("Litre");
    subPanel.add(litreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 1090, 50, 20));
    subPanel.add(titleSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 930, 10));
    subPanel.add(titleSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 740, 930, 10));

        //---------------------------------------------------------------------//
        //database
        try
        {
            byte[] imageByte;
            Image image;
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata","root","");
            System.out.println(vehicleno);
            String sql = "SELECT * FROM ownervehicledetails WHERE vehiclenumber='"+vehicleno+"'";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                 showOwnerName.setText(rs.getString("ownername"));
                 showRegistrationDate.setText(rs.getString("registrationdate"));
                 showGender.setText(rs.getString("gender"));
                 showDateOfBirth.setText(rs.getString("dateofbirth"));
                 showOccupation.setText(rs.getString("occupation"));
                 showOwnerEducation.setText(rs.getString("education"));
                 showOwnerCitizenshipNumber.setText(rs.getString("citizenshipnumber"));
                 showCID.setText(rs.getString("citiissdis"));
                 showPassportNumber.setText(rs.getString("passportnumber"));
                 showPID.setText(rs.getString("passissdis"));
                 showZone.setText(rs.getString("zone"));
                 showDistrict.setText(rs.getString("district"));
                 showAddress.setText(rs.getString("address"));
                 showHouseNumber.setText(rs.getString("housenumber"));
                 showContactNumber.setText(rs.getString("contactnumber"));
                 showEmail.setText(rs.getString("emailid"));
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
                 showOwnerPhoto.setIcon(ResizeImage(null,rs.getBytes("ownerimage")));
            }
            rs.close();
            pstmt.close();
            conn.close();
        	
        }catch(Exception e)
        {
        	JOptionPane.showMessageDialog(null,e);
        }
        
        setVisible(true);

        //---------------------------------------------------------------------//

        vehicleTitleLabel.setBackground(new java.awt.Color(255, 255, 255));
        vehicleTitleLabel.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        vehicleTitleLabel.setForeground(new java.awt.Color(1, 50, 67));
        vehicleTitleLabel.setText("Vehicle Details");
        subPanel.add(vehicleTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 700, -1, -1));

        ownerTitleLabel.setBackground(new java.awt.Color(255, 255, 255));
        ownerTitleLabel.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        ownerTitleLabel.setForeground(new java.awt.Color(1, 50, 67));
        ownerTitleLabel.setText("Owner Details");
        subPanel.add(ownerTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));
        subPanel.add(titleSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, 930, 10));

        scrollToUp.setIcon(new ImageIcon(getClass().getResource("/com/gces/project/icons/up-arrow.png"))); // NOI18N
        scrollToUp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        scrollToUp.setHorizontalTextPosition(SwingConstants.CENTER);
        scrollToUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scrollToUpMouseClicked(evt);
            }
        });
        subPanel.add(scrollToUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 1140, 40, 40));

        backButton.setBackground(new java.awt.Color(1, 50, 67));
        backButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setText("Back");
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false);
        backButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backButton.setHorizontalTextPosition(SwingConstants.LEFT);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        subPanel.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(866, 40, 90, 30));

        detailScrollPane.setViewportView(subPanel);

        mainPanel.add(detailScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 1000, 650));

        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 680));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        NewRegistration nr = new NewRegistration();
        nr.initComponents(LoginID, dateTimeStamp);
        close();
    }                                         

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        SearchDetails sd = new SearchDetails();
        sd.initComponents(LoginID, dateTimeStamp);
        close();
    }                                            

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

    private void searchLabelMouseClicked(java.awt.event.MouseEvent evt) {                                         
        SearchDetails sd = new SearchDetails();
        sd.initComponents(LoginID, dateTimeStamp);
        close();
    }                                        

    private void addLabelMouseClicked(java.awt.event.MouseEvent evt) {                                      
        NewRegistration nr = new NewRegistration();
        nr.initComponents(LoginID, dateTimeStamp);
        close();
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

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        close();
    }                                           

    private void minimizeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        this.setState(ShowRegister.ICONIFIED);
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

    private void scrollToUpMouseClicked(java.awt.event.MouseEvent evt) {                                        
        detailScrollPane.getViewport().setViewPosition(new Point(0,0));
    }                                       

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
    	SearchDetails sd = new SearchDetails();
    	sd.initComponents(LoginID, dateTimeStamp);
    	close();
    }                                          

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowRegister().setVisible(true);
            }
        });
    }

    private JLabel CIDLabel;
    private JLabel ContactNumberFrontLabel;
    private JLabel HideLabel;
    private JLabel PIDLabel;
    private JButton addButton;
    private JLabel addLabel;
    private JButton backButton;
    private JLabel citizenshipNumberLabel;
    private JButton closeButton;
    private JLabel companyNameLabel;
    private JLabel contactNumberLabel;
    private JLabel dateofBirthLabel;
    private JScrollPane detailScrollPane;
    private JLabel displacementLabel;
    private JLabel districtLabel;
    private JLabel educationLabel;
    private JLabel emailLabel;
    private JLabel engineNumberLabel;
    private JLabel fuelTypeLabel;
    private JLabel genderLabel;
    private JButton homeButton;
    private JLabel homeLabel;
    private JLabel houseNumberLabel;
    private JSeparator lineSeparator1;
    private JSeparator lineSeparator2;
    private JSeparator lineSeparator3;
    private JSeparator lineSeparator4;
    private JSeparator lineSeparator5;
    private JSeparator lineSeparator6;
    private JLabel litreLabel;
    private JPanel mainPanel;
    private JLabel maximumPowerLabel;
    private JLabel maximumTorqueLabel;
    private JButton minimizeButton;
    private JLabel modelNumberLabel;
    private JLabel addressLabel;
    private JLabel noofGearsLabel;
    private JLabel noofSeatsLabel;
    private JLabel occupationLabel;
    private JLabel ownerNameLabel;
    private JLabel ownerTitleLabel;
    private JLabel passportNumberLabel;
    private JLabel registrationDateLabel;
    private JLabel scrollToUp;
    private JButton searchButton;
    private JLabel searchLabel;
    private JButton showButton;
    private JLabel showCID;
    private JLabel showCompanyName;
    private JLabel showContactNumber;
    private JLabel showDateOfBirth;
    private JLabel showDisplacement;
    private JLabel showDistrict;
    private JLabel showEmail;
    private JLabel showEngineNumber;
    private JLabel showFuelType;
    private JLabel showGender;
    private JLabel showHouseNumber;
    private JLabel showMaximumPower;
    private JLabel showMaximumTorque;
    private JLabel showModelNumber;
    private JLabel showAddress;
    private JLabel showNoofGears;
    private JLabel showNoofSeats;
    private JLabel showOccupation;
    private JLabel showOwnerCitizenshipNumber;
    private JLabel showOwnerEducation;
    private JLabel showOwnerName;
    private JLabel showOwnerPhoto;
    private JLabel showPID;
    private JLabel showPassportNumber;
    private JLabel showRegistrationDate;
    private JLabel showTankCapacity;
    private JLabel showUserLabel;
    private JLabel showUserLabel1;
    private JLabel showVehicleColor;
    private JLabel showVehicleNumber;
    private JLabel showVehicleType;
    private JLabel showZone;
    private JPanel sidebarPanel;
    private JButton signOutButton;
    private JLabel signOutLabel;
    private JPanel subPanel;
    private JLabel tankCapacityLabel;
    private JPanel titlePanel;
    private JSeparator titleSeparator1;
    private JSeparator titleSeparator2;
    private JSeparator titleSeparator3;
    private JLabel vehicleColorLabel;
    private JLabel vehicleNumberLabel;
    private JLabel vehicleTitleLabel;
    private JLabel vehicleTypeLabel;
    private JLabel zoneLabel;
}
