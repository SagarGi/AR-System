package com.gces.minor_project_i;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author pravinewa
 */
public class ShowOwnerDetails extends JFrame {
    
    static String LoginID, vehicleno, dateTimeStamp;
    
    public ShowOwnerDetails() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("jarIcon.png")));
    	
        //initComponents();
        
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


    public void initComponents(String LoginID1, String vehicleno1, String date) {
    	
    	//setIconImage(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/jarIcon.png")).getImage());
    	
        LoginID = LoginID1;
        vehicleno = vehicleno1;
        dateTimeStamp = date;
        
        ownerDetailsPanel = new JPanel();
        closeButton = new JButton();
        loggedInTime = new JLabel();
        photoLabel = new JLabel();
        welcomeLabel = new JLabel();
        IDLabel = new JLabel();
        ownerNameLabel = new JLabel();
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
        municipalityLabel = new JLabel();
        showMunicipality = new JLabel();
        wardNumberLabel = new JLabel();
        showWardNumber = new JLabel();
        toleLabel = new JLabel();
        showTole = new JLabel();
        houseNumberLabel = new JLabel();
        showHouseNumber = new JLabel();
        contactNumberLabel = new JLabel();
        contactNumberFrontLabel = new JLabel();
        showContactNumber = new JLabel();
        emailLabel = new JLabel();
        showEmail = new JLabel();
        showOwnerPhoto = new JLabel();
        ownerDetailsButton = new JButton();
        backButton = new JButton();
        logOutButton = new JButton();
        vehicleDetailsButton = new JButton();
        registerPhotoLabel = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ownerDetailsPanel.setBackground(new java.awt.Color(255, 255, 255));
        ownerDetailsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        //---------------------------------------------------------------------//
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setBackground(new Color(0,0,0,0));
        ownerDetailsPanel.setBackground(new Color(0,0,0,0));
        //---------------------------------------------------------------------//
        loggedInTime.setForeground(new java.awt.Color(255, 255, 255));
        loggedInTime.setText("Logged in at : "+dateTimeStamp);
        ownerDetailsPanel.add(loggedInTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 160, -1));

        closeButton.setBackground(new java.awt.Color(51, 110, 123));
        closeButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/closeicon.png"))); // NOI18N
        closeButton.setBorder(null);
        closeButton.setBorderPainted(false);
        closeButton.setContentAreaFilled(false);
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        ownerDetailsPanel.add(closeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 30, -1, -1));

        photoLabel.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/user2.png"))); // NOI18N
        ownerDetailsPanel.add(photoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        welcomeLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(255, 255, 255));
        welcomeLabel.setText("Staff ID : ");
        ownerDetailsPanel.add(welcomeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));

        IDLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        IDLabel.setForeground(new java.awt.Color(255, 255, 255));
        IDLabel.setText(LoginID);
        ownerDetailsPanel.add(IDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));


        ownerNameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ownerNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        ownerNameLabel.setText("Owner Name");
        ownerDetailsPanel.add(ownerNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, -1, -1));

        showOwnerName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showOwnerName.setForeground(new java.awt.Color(255, 255, 255));
        showOwnerName.setText("Null");
        ownerDetailsPanel.add(showOwnerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 190, -1));

        registrationDateLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        registrationDateLabel.setForeground(new java.awt.Color(255, 255, 255));
        registrationDateLabel.setText("Registration Date");
        ownerDetailsPanel.add(registrationDateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, -1, -1));

        showRegistrationDate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showRegistrationDate.setForeground(new java.awt.Color(255, 255, 255));
        showRegistrationDate.setText("Null");
        ownerDetailsPanel.add(showRegistrationDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 190, -1));

        genderLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        genderLabel.setForeground(new java.awt.Color(255, 255, 255));
        genderLabel.setText("Gender");
        ownerDetailsPanel.add(genderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, -1, -1));

        showGender.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showGender.setForeground(new java.awt.Color(255, 255, 255));
        showGender.setText("Null");
        ownerDetailsPanel.add(showGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, 190, -1));

        dateofBirthLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dateofBirthLabel.setForeground(new java.awt.Color(255, 255, 255));
        dateofBirthLabel.setText("Date of Birth");
        ownerDetailsPanel.add(dateofBirthLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, -1, -1));

        showDateOfBirth.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showDateOfBirth.setForeground(new java.awt.Color(255, 255, 255));
        showDateOfBirth.setText("Null");
        ownerDetailsPanel.add(showDateOfBirth, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 190, -1));

        educationLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        educationLabel.setForeground(new java.awt.Color(255, 255, 255));
        educationLabel.setText("Education");
        ownerDetailsPanel.add(educationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, -1, -1));

        showOwnerEducation.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showOwnerEducation.setForeground(new java.awt.Color(255, 255, 255));
        showOwnerEducation.setText("Null");
        ownerDetailsPanel.add(showOwnerEducation, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 300, 190, -1));

        occupationLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        occupationLabel.setForeground(new java.awt.Color(255, 255, 255));
        occupationLabel.setText("Occupation");
        ownerDetailsPanel.add(occupationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 300, -1, -1));

        showOccupation.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showOccupation.setForeground(new java.awt.Color(255, 255, 255));
        showOccupation.setText("Null");
        ownerDetailsPanel.add(showOccupation, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 300, 190, -1));

        citizenshipNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        citizenshipNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        citizenshipNumberLabel.setText("Citizenship No");
        ownerDetailsPanel.add(citizenshipNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, -1, 30));

        showOwnerCitizenshipNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showOwnerCitizenshipNumber.setForeground(new java.awt.Color(255, 255, 255));
        showOwnerCitizenshipNumber.setText("Null");
        ownerDetailsPanel.add(showOwnerCitizenshipNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, 190, -1));

        CIDLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CIDLabel.setForeground(new java.awt.Color(255, 255, 255));
        CIDLabel.setText("Citizenship Issue District");
        ownerDetailsPanel.add(CIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 350, 160, -1));

        showCID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showCID.setForeground(new java.awt.Color(255, 255, 255));
        showCID.setText("Null");
        ownerDetailsPanel.add(showCID, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 350, 190, -1));

        passportNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        passportNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        passportNumberLabel.setText("Passport Number");
        ownerDetailsPanel.add(passportNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, -1, -1));

        showPassportNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showPassportNumber.setForeground(new java.awt.Color(255, 255, 255));
        showPassportNumber.setText("Null");
        ownerDetailsPanel.add(showPassportNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 400, 190, -1));

        PIDLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PIDLabel.setForeground(new java.awt.Color(255, 255, 255));
        PIDLabel.setText("Passport Issue District");
        ownerDetailsPanel.add(PIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 400, -1, -1));

        showPID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showPID.setForeground(new java.awt.Color(255, 255, 255));
        showPID.setText("Null");
        ownerDetailsPanel.add(showPID, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 400, 190, -1));

        zoneLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        zoneLabel.setForeground(new java.awt.Color(255, 255, 255));
        zoneLabel.setText("Zone");
        ownerDetailsPanel.add(zoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 450, -1, -1));

        showZone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showZone.setForeground(new java.awt.Color(255, 255, 255));
        showZone.setText("Null");
        ownerDetailsPanel.add(showZone, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 450, 190, -1));

        districtLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        districtLabel.setForeground(new java.awt.Color(255, 255, 255));
        districtLabel.setText("District");
        ownerDetailsPanel.add(districtLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 450, 50, -1));

        showDistrict.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showDistrict.setForeground(new java.awt.Color(255, 255, 255));
        showDistrict.setText("Null");
        ownerDetailsPanel.add(showDistrict, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 450, 190, -1));

        municipalityLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        municipalityLabel.setForeground(new java.awt.Color(255, 255, 255));
        municipalityLabel.setText("Municipality");
        ownerDetailsPanel.add(municipalityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 500, -1, -1));

        showMunicipality.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showMunicipality.setForeground(new java.awt.Color(255, 255, 255));
        showMunicipality.setText("Null");
        ownerDetailsPanel.add(showMunicipality, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 500, 190, -1));

        wardNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        wardNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        wardNumberLabel.setText("Ward Number");
        ownerDetailsPanel.add(wardNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 500, -1, -1));

        showWardNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showWardNumber.setForeground(new java.awt.Color(255, 255, 255));
        showWardNumber.setText("Null");
        ownerDetailsPanel.add(showWardNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 500, 190, -1));

        toleLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        toleLabel.setForeground(new java.awt.Color(255, 255, 255));
        toleLabel.setText("Tole");
        ownerDetailsPanel.add(toleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 550, -1, -1));

        showTole.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showTole.setForeground(new java.awt.Color(255, 255, 255));
        showTole.setText("Null");
        ownerDetailsPanel.add(showTole, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 550, 190, -1));

        houseNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        houseNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        houseNumberLabel.setText("House Number");
        ownerDetailsPanel.add(houseNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 550, -1, -1));

        showHouseNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showHouseNumber.setForeground(new java.awt.Color(255, 255, 255));
        showHouseNumber.setText("Null");
        ownerDetailsPanel.add(showHouseNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 550, 190, -1));

        contactNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        contactNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        contactNumberLabel.setText("Contact Number");
        ownerDetailsPanel.add(contactNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 600, -1, -1));


        contactNumberFrontLabel.setForeground(new java.awt.Color(255, 255, 255));
        contactNumberFrontLabel.setText("+977");
        ownerDetailsPanel.add(contactNumberFrontLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 600, 30, -1));

        showContactNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showContactNumber.setForeground(new java.awt.Color(255, 255, 255));
        showContactNumber.setText("Null");
        ownerDetailsPanel.add(showContactNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 600, 160, -1));

        emailLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(255, 255, 255));
        emailLabel.setText("Email ");
        ownerDetailsPanel.add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 600, -1, -1));

        showEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showEmail.setForeground(new java.awt.Color(255, 255, 255));
        showEmail.setText("Null");
        ownerDetailsPanel.add(showEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 600, 190, -1));

        showOwnerPhoto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showOwnerPhoto.setForeground(new java.awt.Color(255, 255, 255));
        showOwnerPhoto.setText(null);
        showOwnerPhoto.setMaximumSize(new java.awt.Dimension(170, 170));
        showOwnerPhoto.setMinimumSize(new java.awt.Dimension(170, 170));
        showOwnerPhoto.setPreferredSize(new java.awt.Dimension(170, 170));
        ownerDetailsPanel.add(showOwnerPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 100, 170, 170));

        try
        {
            byte[] imageByte;
            Image image;
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata","root","");
            System.out.println(vehicleno);
            String sql = "SELECT ownername, registrationdate, gender, dateofbirth, occupation, education, citizenshipnumber, citiissdis, passportnumber, passissdis, zone, district, municipality, wardnumber, tole, housenumber, contactnumber, emailid FROM ownerdetails WHERE vehiclenumb='"+vehicleno+"'";
            String sqll = "SELECT ownerimage FROM ownerphotos WHERE vehiclenumber='"+vehicleno+"'";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            PreparedStatement pstmtt = conn.prepareStatement(sqll);
            ResultSet rs = pstmt.executeQuery();
            ResultSet rss = pstmtt.executeQuery();
            while(rs.next() && rss.next())
            {
                 showOwnerName.setText(rs.getString("ownername"));
                 //System.out.println(rs.getString("ownername"));
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
                 showMunicipality.setText(rs.getString("municipality"));
                 showWardNumber.setText(rs.getString("wardnumber"));
                 showTole.setText(rs.getString("tole"));
                 showHouseNumber.setText(rs.getString("housenumber"));
                 showContactNumber.setText(rs.getString("contactnumber"));
                 showEmail.setText(rs.getString("emailid"));

                 showOwnerPhoto.setIcon(ResizeImage(null,rss.getBytes("ownerimage")));
            }
            rs.close();
            rss.close();
            pstmt.close();
            pstmtt.close();
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
        ownerDetailsPanel.add(ownerDetailsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 130, 30));

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
        ownerDetailsPanel.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 130, 30));

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
        ownerDetailsPanel.add(logOutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 130, 30));

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
        ownerDetailsPanel.add(vehicleDetailsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 130, 30));

        registerPhotoLabel.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/remainingpanel.png"))); // NOI18N
        ownerDetailsPanel.add(registerPhotoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 670));

        getContentPane().add(ownerDetailsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    public ImageIcon ResizeImage(String imgPath)
    {
    	ImageIcon MyImage = new ImageIcon(imgPath);
    	Image img = MyImage.getImage();
    	Image newImage = img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
    	ImageIcon image = new ImageIcon(newImage);
    	return image;
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
        private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
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

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        SearchDetail sp = new SearchDetail();
        sp.initComponents(LoginID, dateTimeStamp);
        close();
    }                                          

    private void ownerDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        
    }                                                  

    private void vehicleDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                     
       ShowVehicleDetails svd = new ShowVehicleDetails();
        svd.initComponents(LoginID, vehicleno, dateTimeStamp);
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
                new ShowOwnerDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify      
    private JLabel loggedInTime;
    private JLabel CIDLabel;
    private JLabel contactNumberFrontLabel;
    private JLabel IDLabel;
    private JLabel PIDLabel;
    private JButton backButton;
    private JLabel citizenshipNumberLabel;
    private JButton closeButton;
    private JLabel contactNumberLabel;
    private JLabel dateofBirthLabel;
    private JLabel districtLabel;
    private JLabel educationLabel;
    private JLabel emailLabel;
    private JLabel genderLabel;
    private JLabel houseNumberLabel;
    private JButton logOutButton;
    private JLabel municipalityLabel;
    private JLabel occupationLabel;
    private JButton ownerDetailsButton;
    private JPanel ownerDetailsPanel;
    private JLabel ownerNameLabel;
    private JLabel passportNumberLabel;
    private JLabel photoLabel;
    private JLabel registerPhotoLabel;
    private JLabel registrationDateLabel;
    private JLabel showCID;
    private JLabel showContactNumber;
    private JLabel showDateOfBirth;
    private JLabel showDistrict;
    private JLabel showEmail;
    private JLabel showGender;
    private JLabel showHouseNumber;
    private JLabel showMunicipality;
    private JLabel showOccupation;
    private JLabel showOwnerCitizenshipNumber;
    private JLabel showOwnerEducation;
    private JLabel showOwnerName;
    private JLabel showOwnerPhoto;
    private JLabel showPID;
    private JLabel showPassportNumber;
    private JLabel showRegistrationDate;
    private JLabel showTole;
    private JLabel showWardNumber;
    private JLabel showZone;
    private JLabel toleLabel;
    private JButton vehicleDetailsButton;
    private JLabel wardNumberLabel;
    private JLabel welcomeLabel;
    private JLabel zoneLabel;
    // End of variables declaration                   
}
