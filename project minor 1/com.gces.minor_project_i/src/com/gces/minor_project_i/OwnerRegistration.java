package com.gces.minor_project_i;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.io.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.text.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author pravinewa
 */
public class OwnerRegistration extends JFrame {
    static String LoginID, vehicleNumb, dateTimeStamp;
    String s = null;
    String fileName = null;
    String imgPath = null;
    static int ownernamevalid = 0, agevalid = 0, educationvalid = 0, occupationvalid = 0, citizenshipnumbervalid = 0, passportnumbervalid = 0, ownerphotovalid = 0, municipalityvalid = 0, wardnumbervalid = 0, tolevalid = 0, housenumbervalid = 0, contactnumbervalid = 0, emailvalid = 0;
    
    public OwnerRegistration() {
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

    public void initComponents(String LoginID1, String vehicleNumber1, String date) {
    	
    	//setIconImage(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/jarIcon.png")).getImage());
    	
        LoginID = LoginID1;
        vehicleNumb = vehicleNumber1;
        dateTimeStamp = date;
        

        handler = new ItemHandler();
    	genderButtonGroup = new ButtonGroup();
        registerPanel = new JPanel();
        loggedInTime = new JLabel();
        closeButton = new JButton();
        fieldWithLabel = new JLabel();
        redmark0 = new JLabel();
        areMandatoryLabel = new JLabel();
        photoLabel = new JLabel();
        staffIdLabel = new JLabel();
        IDLabel = new JLabel();
        ownerNameLabel = new JLabel();
        redmark1 = new JLabel();
        ownerNameTextField = new JTextField();
        ownerNameSeparator = new JSeparator();
        showValidationOfOwnerName = new JLabel();
        redmark2 = new JLabel();
        ageLabel = new JLabel();
        showAgeLabel = new JLabel();
        ageSeparator = new JSeparator();
        showValidationOfAge = new JLabel();
        genderLabel = new JLabel();
        redmark3 = new JLabel();
        maleRadioButton = new JRadioButton();
        femaleRadioButton = new JRadioButton();
        dateofBirthLabel = new JLabel();
        redmark4 = new JLabel();
        bDateChooser = new com.toedter.calendar.JDateChooser();
        showValidationOfBDate = new JLabel();
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
        municipalityLabel = new JLabel();
        redmark10 = new JLabel();
        municipalityTextField = new JTextField();
        municipalitySeparator = new JSeparator();
        showValidationOfMunicipality = new JLabel();
        wardNumberLabel = new JLabel();
        redmark11 = new JLabel();
        wardNumberTextField = new JTextField();
        wardNumberSeparator = new JSeparator();
        showValidationOfWardNumber = new JLabel();
        toleLabel = new JLabel();
        redmark12 = new JLabel();
        toleTextField = new JTextField();
        toleSeparator = new JSeparator();
        showValidationOfTole = new JLabel();
        houseNumberLabel = new JLabel();
        redmark13 = new JLabel();
        houseNumberTextField = new JTextField();
        houseNumberSeparator = new JSeparator();
        showValidationOfHouseNumber = new JLabel();
        contactNumberLabel = new JLabel();
        redmark14 = new JLabel();
        contactNumberFrontLabel = new JLabel();
        contactNumberTextField = new JTextField();
        contactNumberSeparator = new JSeparator();
        showValidationOfContactNumber = new JLabel();
        emailLabel = new JLabel();
        emailTextField = new JTextField();
        emailSeparator = new JSeparator();
        showValidationOfEmail = new JLabel();
        confirmCheckBox = new JCheckBox();
        submitButton = new JButton();
        homeButton = new JButton();
        logOutButton = new JButton();
        registerPhotoLabel = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        registerPanel.setBackground(new java.awt.Color(255, 255, 255));
        registerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        //---------------------------------------------------------------------//
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setBackground(new Color(0,0,0,0));
        registerPanel.setBackground(new Color(0,0,0,0));
        setVisible(true);
        //---------------------------------------------------------------------//
        loggedInTime.setForeground(new java.awt.Color(255, 255, 255));
        loggedInTime.setText("Logged in at : "+dateTimeStamp);
        registerPanel.add(loggedInTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 160, -1));
 
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
        registerPanel.add(closeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 30, -1, -1));

        fieldWithLabel.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        fieldWithLabel.setForeground(new java.awt.Color(255, 255, 255));
        fieldWithLabel.setText("Fields with");
        registerPanel.add(fieldWithLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, -1, -1));

        redmark0.setForeground(new java.awt.Color(255, 0, 0));
        redmark0.setText(" *");
        registerPanel.add(redmark0, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 10, -1));

        areMandatoryLabel.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        areMandatoryLabel.setForeground(new java.awt.Color(255, 255, 255));
        areMandatoryLabel.setText("are Mandatory");
        registerPanel.add(areMandatoryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 190, -1));

        photoLabel.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/user2.png"))); // NOI18N
        registerPanel.add(photoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        staffIdLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        staffIdLabel.setForeground(new java.awt.Color(255, 255, 255));
        staffIdLabel.setText("Staff ID : ");
        registerPanel.add(staffIdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));

        IDLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        IDLabel.setForeground(new java.awt.Color(255, 255, 255));
        IDLabel.setText(LoginID);
        registerPanel.add(IDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        ownerNameLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ownerNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        ownerNameLabel.setText("Owner Name");
        registerPanel.add(ownerNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, -1, -1));

        redmark1.setForeground(new java.awt.Color(255, 0, 0));
        redmark1.setText("*");
        registerPanel.add(redmark1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 10, -1));

        ownerNameTextField.setBackground(new java.awt.Color(1, 50, 67));
        ownerNameTextField.setForeground(new java.awt.Color(255, 255, 255));
        ownerNameTextField.setBorder(null);
        ownerNameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ownerNameTextFieldKeyReleased(evt);
            }
        });
        registerPanel.add(ownerNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 200, 20));
        registerPanel.add(ownerNameSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 200, 10));

        showValidationOfOwnerName.setBackground(new java.awt.Color(87, 32, 30));
        showValidationOfOwnerName.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        showValidationOfOwnerName.setForeground(new java.awt.Color(255, 0, 0));
        registerPanel.add(showValidationOfOwnerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 190, -1));

        dateofBirthLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dateofBirthLabel.setForeground(new java.awt.Color(255, 255, 255));
        dateofBirthLabel.setText("Date of Birth");
        registerPanel.add(dateofBirthLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, -1, -1));

        redmark4.setForeground(new java.awt.Color(255, 0, 0));
        redmark4.setText(" *");
        registerPanel.add(redmark4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 110, 10, -1));

        bDateChooser.setBackground(new java.awt.Color(255, 255, 255));
        bDateChooser.setDateFormatString("yyyy-M-dd");
        registerPanel.add(bDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 100, 200, 30));

        showValidationOfBDate.setBackground(new java.awt.Color(87, 32, 30));
        showValidationOfBDate.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        showValidationOfBDate.setForeground(new java.awt.Color(255, 0, 0));
        registerPanel.add(showValidationOfBDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 130, 190, -1));

        genderLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        genderLabel.setForeground(new java.awt.Color(255, 255, 255));
        genderLabel.setText("Gender");
        registerPanel.add(genderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, -1, -1));

        redmark3.setForeground(new java.awt.Color(255, 0, 0));
        redmark3.setText("*");
        registerPanel.add(redmark3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, -1, -1));

        maleRadioButton.setBackground(new java.awt.Color(1, 50, 67));
        genderButtonGroup.add(maleRadioButton);
        maleRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        maleRadioButton.setSelected(true);
        maleRadioButton.setText("Male");
        registerPanel.add(maleRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 90, 30));

        femaleRadioButton.setBackground(new java.awt.Color(1, 50, 67));
        genderButtonGroup.add(femaleRadioButton);
        femaleRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        femaleRadioButton.setText("Female");
        registerPanel.add(femaleRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 100, 30));

        ageLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ageLabel.setForeground(new java.awt.Color(255, 255, 255));
        ageLabel.setText("Age");
        registerPanel.add(ageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, -1, -1));

        showAgeLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showAgeLabel.setForeground(new java.awt.Color(255, 255, 255));
        showAgeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/click.png"))); // NOI18N
        showAgeLabel.setText("Click to Show Age");
        showAgeLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        showAgeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showAgeLabelMouseClicked(evt);
            }
        });
        
        registerPanel.add(showAgeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 150, 200, 20));
        registerPanel.add(ageSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 170, 200, 10));

        showValidationOfAge.setBackground(new java.awt.Color(87, 32, 30));
        showValidationOfAge.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        showValidationOfAge.setForeground(new java.awt.Color(255, 0, 0));
        registerPanel.add(showValidationOfAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 180, 190, -1));


        educationLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        educationLabel.setForeground(new java.awt.Color(255, 255, 255));
        educationLabel.setText("Education");
        registerPanel.add(educationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, -1, -1));

        educationTextField.setBackground(new java.awt.Color(1, 50, 67));
        educationTextField.setForeground(new java.awt.Color(255, 255, 255));
        educationTextField.setBorder(null);
        educationTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                educationTextFieldKeyReleased(evt);
            }
        });
        registerPanel.add(educationTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, 200, 20));
        registerPanel.add(educationSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 200, 10));

        showValidationOfEducation.setBackground(new java.awt.Color(87, 32, 30));
        showValidationOfEducation.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        showValidationOfEducation.setForeground(new java.awt.Color(255, 0, 0));
        registerPanel.add(showValidationOfEducation, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 190, -1));

        occupationLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        occupationLabel.setForeground(new java.awt.Color(255, 255, 255));
        occupationLabel.setText("Occupation");
        registerPanel.add(occupationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 210, -1, -1));

        occupationTextField.setBackground(new java.awt.Color(1, 50, 67));
        occupationTextField.setForeground(new java.awt.Color(255, 255, 255));
        occupationTextField.setBorder(null);
        occupationTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                occupationTextFieldKeyReleased(evt);
            }
        });
        registerPanel.add(occupationTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 200, 200, 20));
        registerPanel.add(occupationSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 220, 200, 10));

        showValidationOfOccupation.setBackground(new java.awt.Color(87, 32, 30));
        showValidationOfOccupation.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        showValidationOfOccupation.setForeground(new java.awt.Color(255, 0, 0));
        registerPanel.add(showValidationOfOccupation, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 230, 190, -1));

        citizenshipNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        citizenshipNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        citizenshipNumberLabel.setText("Citizenship No");
        registerPanel.add(citizenshipNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, -1, 30));

        redmark5.setForeground(new java.awt.Color(255, 0, 0));
        redmark5.setText("*");
        registerPanel.add(redmark5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 20, -1));

        citizenshipNumberTextField.setBackground(new java.awt.Color(1, 50, 67));
        citizenshipNumberTextField.setForeground(new java.awt.Color(255, 255, 255));
        citizenshipNumberTextField.setBorder(null);
        citizenshipNumberTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                citizenshipNumberTextFieldKeyReleased(evt);
            }
        });
        registerPanel.add(citizenshipNumberTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 200, 20));
        registerPanel.add(citizenshipNumberSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, 200, 10));

        showValidationOfCitizenshipNumber.setBackground(new java.awt.Color(87, 32, 30));
        showValidationOfCitizenshipNumber.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        showValidationOfCitizenshipNumber.setForeground(new java.awt.Color(255, 0, 0));
        registerPanel.add(showValidationOfCitizenshipNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 190, -1));

        CIDLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CIDLabel.setForeground(new java.awt.Color(255, 255, 255));
        CIDLabel.setText("Citizenship Issue District");
        registerPanel.add(CIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 260, 160, -1));

        redmark6.setForeground(new java.awt.Color(255, 0, 0));
        redmark6.setText(" *");
        registerPanel.add(redmark6, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 260, 10, -1));

        CIDComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Choose issue District", "Achham", "Arghakhanchi", "Baglung", "Baitadi", "Bajhang", "Bajura", "Banke", "Bara", "Bardiya", "Bhaktapur", "Bhojpur", "Chitwan", "Dadeldhura", "Dailekh", "Dang", "Darchula", "Dhading", "Dhankuta", "Dhanusa", "Dholkha", "Dolpa", "Doti", "Gorkha", "Gulmi", "Humla", "Ilam", "Jajarkot", "Jhapa", "Jumla", "Kailali", "Kalikot", "Kanchanpur", "Kapilvastu", "Kaski", "Kathmandu", "Kavrepalanchok", "Khotang", "Lalitpur", "Lamjung", "Mahottari", "Makwanpur", "Manang", "Morang", "Mugu", "Mustang", "Myagdi", "Nawalparasi", "Nuwakot", "Okhaldhunga", "Palpa", "Panchthar", "Parbat", "Parsa", "Pyuthan", "Ramechhap", "Rasuwa", "Rautahat", "Rolpa", "Rukum", "Rupandehi", "Salyan", "Sankhuwasabha", "Saptari", "Sarlahi", "Sindhuli", "Sindhupalchok", "Siraha", "Solukhumbu", "Sunsari", "Surkhet", "Syangja", "Tanahun", "Taplejung", "Terhathum", "Udayapur" }));
        registerPanel.add(CIDComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 250, 200, 30));

        showValidationOfCID.setBackground(new java.awt.Color(87, 32, 30));
        showValidationOfCID.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        showValidationOfCID.setForeground(new java.awt.Color(255, 0, 0));
        registerPanel.add(showValidationOfCID, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 280, 190, -1));

        passportNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        passportNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        passportNumberLabel.setText("Passport Number");
        registerPanel.add(passportNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, -1, -1));

        passportNumberTextField.setBackground(new java.awt.Color(1, 50, 67));
        passportNumberTextField.setBorder(null);
        passportNumberTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passportNumberTextFieldKeyReleased(evt);
            }
        });
        registerPanel.add(passportNumberTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 200, 20));
        registerPanel.add(passportNumberSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 200, 10));

        showValidationOfPassportNumber.setBackground(new java.awt.Color(87, 32, 30));
        showValidationOfPassportNumber.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        showValidationOfPassportNumber.setForeground(new java.awt.Color(255, 0, 0));
        registerPanel.add(showValidationOfPassportNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 190, -1));

        PIDLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PIDLabel.setForeground(new java.awt.Color(255, 255, 255));
        PIDLabel.setText("Passport Issue District");
        registerPanel.add(PIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 310, -1, -1));

        PIDComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Choose issue District", "Achham", "Arghakhanchi", "Baglung", "Baitadi", "Bajhang", "Bajura", "Banke", "Bara", "Bardiya", "Bhaktapur", "Bhojpur", "Chitwan", "Dadeldhura", "Dailekh", "Dang", "Darchula", "Dhading", "Dhankuta", "Dhanusa", "Dholkha", "Dolpa", "Doti", "Gorkha", "Gulmi", "Humla", "Ilam", "Jajarkot", "Jhapa", "Jumla", "Kailali", "Kalikot", "Kanchanpur", "Kapilvastu", "Kaski", "Kathmandu", "Kavrepalanchok", "Khotang", "Lalitpur", "Lamjung", "Mahottari", "Makwanpur", "Manang", "Morang", "Mugu", "Mustang", "Myagdi", "Nawalparasi", "Nuwakot", "Okhaldhunga", "Palpa", "Panchthar", "Parbat", "Parsa", "Pyuthan", "Ramechhap", "Rasuwa", "Rautahat", "Rolpa", "Rukum", "Rupandehi", "Salyan", "Sankhuwasabha", "Saptari", "Sarlahi", "Sindhuli", "Sindhupalchok", "Siraha", "Solukhumbu", "Sunsari", "Surkhet", "Syangja", "Tanahun", "Taplejung", "Terhathum", "Udayapur" }));
        registerPanel.add(PIDComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 300, 200, 30));

        showValidationOfPID.setBackground(new java.awt.Color(87, 32, 30));
        showValidationOfPID.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        showValidationOfPID.setForeground(new java.awt.Color(255, 0, 0));
        registerPanel.add(showValidationOfPID, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 330, 190, -1));

        ownerPhotoLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ownerPhotoLabel.setForeground(new java.awt.Color(255, 255, 255));
        ownerPhotoLabel.setText("Owner Photo");
        registerPanel.add(ownerPhotoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, -1, -1));

        redmark7.setForeground(new java.awt.Color(255, 0, 0));
        redmark7.setText(" *");
        registerPanel.add(redmark7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, -1, -1));

        photoChooseButton.setBackground(new java.awt.Color(255, 255, 255));
        photoChooseButton.setText("Choose File");
        photoChooseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                photoChooseButtonActionPerformed(evt);
            }
        });
        registerPanel.add(photoChooseButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 200, 30));

        showValidationOfOwnerPhoto.setBackground(new java.awt.Color(87, 32, 30));
        showValidationOfOwnerPhoto.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        showValidationOfOwnerPhoto.setForeground(new java.awt.Color(255, 0, 0));
        registerPanel.add(showValidationOfOwnerPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, 190, -1));

        zoneLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        zoneLabel.setForeground(new java.awt.Color(255, 255, 255));
        zoneLabel.setText("Zone");
        registerPanel.add(zoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, -1, -1));

        redmark8.setForeground(new java.awt.Color(255, 0, 0));
        redmark8.setText(" *");
        registerPanel.add(redmark8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 10, -1));

        zoneComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Choose Zone", "Bagmati", "Bheri", "Dhawalagiri", "Gandaki", "Janakpur", "Karnali", "Koshi", "Lumbini", "Mahakali", "Mechi", "Narayani", "Rapti", "Sagarmatha", "Seti" }));
        registerPanel.add(zoneComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 400, 200, 30));
        zoneComboBox.addItemListener(handler);
        
        showValidationOfZone.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        showValidationOfZone.setForeground(new java.awt.Color(255, 0, 0));
        registerPanel.add(showValidationOfZone, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 190, -1));

        districtLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        districtLabel.setForeground(new java.awt.Color(255, 255, 255));
        districtLabel.setText("District");
        registerPanel.add(districtLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 410, 70, -1));

        redmark9.setForeground(new java.awt.Color(255, 0, 0));
        redmark9.setText("*");
        registerPanel.add(redmark9, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 410, -1, -1));

        districtComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Choose District", "Achham", "Arghakhanchi", "Baglung", "Baitadi", "Bajhang", "Bajura", "Banke", "Bara", "Bardiya", "Bhaktapur", "Bhojpur", "Chitwan", "Dadeldhura", "Dailekh", "Dang", "Darchula", "Dhading", "Dhankuta", "Dhanusa", "Dholkha", "Dolpa", "Doti", "Gorkha", "Gulmi", "Humla", "Ilam", "Jajarkot", "Jhapa", "Jumla", "Kailali", "Kalikot", "Kanchanpur", "Kapilvastu", "Kaski", "Kathmandu", "Kavrepalanchok", "Khotang", "Lalitpur", "Lamjung", "Mahottari", "Makwanpur", "Manang", "Morang", "Mugu", "Mustang", "Myagdi", "Nawalparasi", "Nuwakot", "Okhaldhunga", "Palpa", "Panchthar", "Parbat", "Parsa", "Pyuthan", "Ramechhap", "Rasuwa", "Rautahat", "Rolpa", "Rukum", "Rupandehi", "Salyan", "Sankhuwasabha", "Saptari", "Sarlahi", "Sindhuli", "Sindhupalchok", "Siraha", "Solukhumbu", "Sunsari", "Surkhet", "Syangja", "Tanahun", "Taplejung", "Terhathum", "Udayapur" }));
        registerPanel.add(districtComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 400, 200, 30));

        showValidationOfDistrict.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        showValidationOfDistrict.setForeground(new java.awt.Color(255, 0, 0));
        registerPanel.add(showValidationOfDistrict, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 430, 190, -1));

        municipalityLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        municipalityLabel.setForeground(new java.awt.Color(255, 255, 255));
        municipalityLabel.setText("Municipality");
        registerPanel.add(municipalityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 460, -1, -1));

        redmark10.setForeground(new java.awt.Color(255, 0, 0));
        redmark10.setText("*");
        registerPanel.add(redmark10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 460, -1, -1));

        municipalityTextField.setBackground(new java.awt.Color(1, 50, 67));
        municipalityTextField.setForeground(new java.awt.Color(255, 255, 255));
        municipalityTextField.setBorder(null);
        municipalityTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                municipalityTextFieldKeyReleased(evt);
            }
        });
        registerPanel.add(municipalityTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 450, 200, 20));
        registerPanel.add(municipalitySeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 470, 200, 10));

        showValidationOfMunicipality.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        showValidationOfMunicipality.setForeground(new java.awt.Color(255, 0, 0));
        registerPanel.add(showValidationOfMunicipality, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 480, 190, -1));

        wardNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        wardNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        wardNumberLabel.setText("Ward Number");
        registerPanel.add(wardNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 460, -1, -1));

        redmark11.setForeground(new java.awt.Color(255, 0, 0));
        redmark11.setText("*");
        registerPanel.add(redmark11, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 460, 10, -1));

        wardNumberTextField.setBackground(new java.awt.Color(1, 50, 67));
        wardNumberTextField.setBorder(null);
        wardNumberTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                wardNumberTextFieldKeyReleased(evt);
            }
        });
        registerPanel.add(wardNumberTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 450, 200, 20));
        registerPanel.add(wardNumberSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 470, 200, 10));

        showValidationOfWardNumber.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        showValidationOfWardNumber.setForeground(new java.awt.Color(255, 0, 0));
        registerPanel.add(showValidationOfWardNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 480, 190, -1));

        toleLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        toleLabel.setForeground(new java.awt.Color(255, 255, 255));
        toleLabel.setText("Tole");
        registerPanel.add(toleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 510, -1, -1));

        redmark12.setForeground(new java.awt.Color(255, 0, 0));
        redmark12.setText("*");
        registerPanel.add(redmark12, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 510, -1, -1));

        toleTextField.setBackground(new java.awt.Color(1, 50, 67));
        toleTextField.setBorder(null);
        toleTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                toleTextFieldKeyReleased(evt);
            }
        });
        registerPanel.add(toleTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 500, 200, 20));
        registerPanel.add(toleSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 520, 200, 10));

        showValidationOfTole.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        showValidationOfTole.setForeground(new java.awt.Color(255, 0, 0));
        registerPanel.add(showValidationOfTole, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 530, 190, -1));

        houseNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        houseNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        houseNumberLabel.setText("House Number");
        registerPanel.add(houseNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 510, -1, -1));

        redmark13.setForeground(new java.awt.Color(255, 0, 0));
        redmark13.setText(" *");
        registerPanel.add(redmark13, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 510, -1, -1));

        houseNumberTextField.setBackground(new java.awt.Color(1, 50, 67));
        houseNumberTextField.setBorder(null);
        houseNumberTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                houseNumberTextFieldKeyReleased(evt);
            }
        });
        registerPanel.add(houseNumberTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 500, 200, 20));
        registerPanel.add(houseNumberSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 520, 200, 10));

        showValidationOfHouseNumber.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        showValidationOfHouseNumber.setForeground(new java.awt.Color(255, 0, 0));
        registerPanel.add(showValidationOfHouseNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 530, 190, -1));

        contactNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        contactNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        contactNumberLabel.setText("Contact Number");
        registerPanel.add(contactNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 560, -1, -1));

        redmark14.setForeground(new java.awt.Color(255, 0, 0));
        redmark14.setText(" *");
        registerPanel.add(redmark14, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 560, -1, -1));


        contactNumberFrontLabel.setForeground(new java.awt.Color(255, 255, 255));
        contactNumberFrontLabel.setText("+977");
        registerPanel.add(contactNumberFrontLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 550, 30, 20));

        contactNumberTextField.setBackground(new java.awt.Color(1, 50, 67));
        contactNumberTextField.setForeground(new java.awt.Color(255, 255, 255));
        contactNumberTextField.setBorder(null);
        contactNumberTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                contactNumberTextFieldKeyReleased(evt);
            }
        });
        registerPanel.add(contactNumberTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 550, 170, 20));
        registerPanel.add(contactNumberSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 570, 200, 10));

        showValidationOfContactNumber.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        showValidationOfContactNumber.setForeground(new java.awt.Color(255, 0, 0));
        registerPanel.add(showValidationOfContactNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 580, 190, -1));

        emailLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(255, 255, 255));
        emailLabel.setText("Email ");
        registerPanel.add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 560, -1, -1));

        emailTextField.setBackground(new java.awt.Color(1, 50, 67));
        emailTextField.setBorder(null);
        emailTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emailTextFieldKeyReleased(evt);
            }
        });
        registerPanel.add(emailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 550, 200, 20));
        registerPanel.add(emailSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 570, 200, 10));

        showValidationOfEmail.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        showValidationOfEmail.setForeground(new java.awt.Color(255, 0, 0));
        registerPanel.add(showValidationOfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 580, 190, -1));

        confirmCheckBox.setBackground(new java.awt.Color(1, 50, 67));
        confirmCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        confirmCheckBox.setText("Tick CheckBox to submit information");
        registerPanel.add(confirmCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 600, -1, -1));

        submitButton.setBackground(new java.awt.Color(255, 255, 255));
        submitButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        submitButton.setText("Submit");
        submitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                submitButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                submitButtonMouseExited(evt);
            }
        });
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        registerPanel.add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 130, 30));

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
        registerPanel.add(homeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 130, 30));

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
        registerPanel.add(logOutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 130, 30));

        registerPhotoLabel.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/remainingpanel.png"))); // NOI18N
        registerPanel.add(registerPhotoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 670));

        getContentPane().add(registerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 700));

        pack();
        setLocationRelativeTo(null);
    }                       
    
    //-------------------------------------------------------------------------//
    private void submitButtonMouseEntered(java.awt.event.MouseEvent evt) {                                          
        submitButton.setBackground(new java.awt.Color(1, 50, 67));
        submitButton.setForeground(new java.awt.Color(255, 255, 255));
    }                                         

    private void submitButtonMouseExited(java.awt.event.MouseEvent evt) {                                         
        submitButton.setBackground(new java.awt.Color(255, 255, 255));
        submitButton.setForeground(new java.awt.Color(0, 0, 0));
    }                                        

    private void homeButtonMouseEntered(java.awt.event.MouseEvent evt) {                                        
        homeButton.setBackground(new java.awt.Color(1, 50, 67));
        homeButton.setForeground(new java.awt.Color(255, 255, 255));
    }                                       

    private void homeButtonMouseExited(java.awt.event.MouseEvent evt) {                                       
        homeButton.setBackground(new java.awt.Color(255, 255, 255));
        homeButton.setForeground(new java.awt.Color(0, 0, 0));
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
        if(ownerNameTextField.getText().equals(""))
        {
            showValidationOfOwnerName.setText(null);
            ownerNameTextField.setForeground(Color.white);
            ownernamevalid = 0;
        }
        if(match.matches())
        {
            showValidationOfOwnerName.setText(null);
            ownerNameTextField.setForeground(Color.white);
            ownernamevalid = 1;
        }
        
    }                                              

    private void showAgeLabelMouseClicked(java.awt.event.MouseEvent evt) {                                          
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        Date d1 = new Date();
        Date d2 ;

        try {
                //System.out.println(format.format(d1));
                d2 = (Date)format.parse(format.format(bDateChooser.getDate()));
//                System.out.println("d1"+d1);
//                System.out.println("d2"+d2);
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
        if(educationTextField.getText().equals(""))
        {
            showValidationOfEducation.setText(null);
            educationTextField.setForeground(Color.white);
            educationvalid = 0;
        }
        if(match.matches())
        {
            showValidationOfEducation.setText(null);
            educationTextField.setForeground(Color.white);
            educationvalid = 1;
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
        if(occupationTextField.getText().equals(""))
        {
            showValidationOfOccupation.setText(null);
            occupationTextField.setForeground(Color.white);
            occupationvalid = 0;
        }
        if(match.matches())
        {
            showValidationOfOccupation.setText(null);
            occupationTextField.setForeground(Color.white);
            occupationvalid = 1;
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
        if(citizenshipNumberTextField.getText().equals(""))
        {
            showValidationOfCitizenshipNumber.setText(null);
            citizenshipNumberTextField.setForeground(Color.white);
            citizenshipnumbervalid = 0;
        }
        if(match.matches())
        {
            showValidationOfCitizenshipNumber.setText(null);
            citizenshipNumberTextField.setForeground(Color.white);
            citizenshipnumbervalid = 1;
        }
        
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
        if(passportNumberTextField.getText().equals(""))
        {
            showValidationOfPassportNumber.setText(null);
            passportNumberTextField.setForeground(Color.white);
            passportnumbervalid = 0;
        }
        if(match.matches())
        {
            showValidationOfPassportNumber.setText(null);
            passportNumberTextField.setForeground(Color.white);
            passportnumbervalid = 1;
        }
        
    }                                                   

    private void municipalityTextFieldKeyReleased(java.awt.event.KeyEvent evt) {                                                  
        String PATTERN = "^[a-zA-Z\\s]{2,25}+$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(municipalityTextField.getText());
        if(!match.matches())
        {
            showValidationOfMunicipality.setText("Municipality field is Incorrect!");
            municipalityTextField.setForeground(Color.red);
            municipalityvalid = 0;
        }
        if(municipalityTextField.getText().equals(""))
        {
            showValidationOfMunicipality.setText(null);
            municipalityTextField.setForeground(Color.white);
            municipalityvalid = 0;
        }
        if(match.matches())
        {
            showValidationOfMunicipality.setText(null);
            municipalityTextField.setForeground(Color.white);
            municipalityvalid = 1;
        }
        
    }                                                 

    private void wardNumberTextFieldKeyReleased(java.awt.event.KeyEvent evt) {                                                
        String PATTERN = "^[0-9]{0,5}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(wardNumberTextField.getText());
        if(!match.matches())
        {
            showValidationOfWardNumber.setText("Ward Number is incorrect!");
            wardNumberTextField.setForeground(Color.red);
            wardnumbervalid = 0;
        }
        if(wardNumberTextField.getText().equals(""))
        {
            showValidationOfWardNumber.setText(null);
            wardNumberTextField.setForeground(Color.white);
            wardnumbervalid = 0;
        }
        if(match.matches())
        {
            showValidationOfWardNumber.setText(null);
            wardNumberTextField.setForeground(Color.white);
            wardnumbervalid = 1;
        }
        
    }                                               

    private void toleTextFieldKeyReleased(java.awt.event.KeyEvent evt) {                                          
        String PATTERN = "^[a-zA-Z\\s]{2,25}+$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(toleTextField.getText());
        if(!match.matches())
        {
            showValidationOfTole.setText("Naming is incorrect!");
            toleTextField.setForeground(Color.red);
            tolevalid = 0;
        }
        if(toleTextField.getText().equals(""))
        {
            showValidationOfTole.setText(null);
            toleTextField.setForeground(Color.white);
            tolevalid = 0;
        }
        if(match.matches())
        {
            showValidationOfTole.setText(null);
            toleTextField.setForeground(Color.white);
            tolevalid = 1;
        }
        
    }                                         

    private void houseNumberTextFieldKeyReleased(java.awt.event.KeyEvent evt) {                                                 
        String PATTERN = "^[0-9]{0,5}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(houseNumberTextField.getText());
        if(!match.matches())
        {
            showValidationOfHouseNumber.setText("House Number is incorrect!");
            houseNumberTextField.setForeground(Color.red);
            housenumbervalid = 0;
        }
        if(houseNumberTextField.getText().equals(""))
        {
            showValidationOfHouseNumber.setText(null);
            houseNumberTextField.setForeground(Color.white);
            housenumbervalid = 0;
        }
        if(match.matches())
        {
            showValidationOfHouseNumber.setText(null);
            houseNumberTextField.setForeground(Color.white);
            housenumbervalid = 1;
        }
        
    }                                                

    private void contactNumberTextFieldKeyReleased(java.awt.event.KeyEvent evt) {                                                   
        String PATTERN = "^[0-9]{10}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(contactNumberTextField.getText());
        if(!match.matches())
        {
            showValidationOfContactNumber.setText("Contact Number should be 10 digit!");
            contactNumberTextField.setForeground(Color.red);
            contactnumbervalid = 0;
        }
        if(contactNumberTextField.getText().equals(""))
        {
            showValidationOfContactNumber.setText(null);
            contactNumberTextField.setForeground(Color.white);
            contactnumbervalid = 0;
        }
        if(match.matches())
        {
            showValidationOfContactNumber.setText(null);
            contactNumberTextField.setForeground(Color.white);
            contactnumbervalid = 1;
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
        if(emailTextField.getText().equals(""))
        {
            showValidationOfEmail.setText(null);
            emailTextField.setForeground(Color.white);
            emailvalid = 0;
        }
        if(match.matches())
        {
            showValidationOfEmail.setText(null);
            emailTextField.setForeground(Color.white);
            emailvalid = 1;
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
                    districtComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose District", "Bhaktapur", "Dhading", "Kathmandu", "Kavrepalanchok", "Lalitpur", "Nuwakot", "Ramechhap", "Rasuwa", "Sindhupalchok"}));
        
                }
                if(zoneComboBox.getSelectedItem().equals("Bheri"))
                {
                    System.out.println("out");
                    districtComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose District", "Banke", "Bardiya", "Dailekh", "Jajarkot", "Surkhet"}));
        
                }
                if(zoneComboBox.getSelectedItem().equals("Dhawalagiri"))
                {
                    System.out.println("out");
                    districtComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose District", "Baglung", "Mustang", "Myagdi", "Parbat"}));
        
                }
                if(zoneComboBox.getSelectedItem().equals("Gandaki"))
                {
                    System.out.println("out");
                    districtComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose District", "Gorkha", "Kaski", "Lamjung", "Manang", "Syangja", "Tanahun"}));
        
                }
                if(zoneComboBox.getSelectedItem().equals("Janakpur"))
                {
                    System.out.println("out");
                    districtComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose District", "Dhanusa", "Dolakha", "Mahottari", "Ramechhap", "Sarlahi", "Sindhuli"}));
        
                }
                if(zoneComboBox.getSelectedItem().equals("Karnali"))
                {
                    System.out.println("out");
                    districtComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose District", "Dolpa", "Humla", "Jumla", "Kalikot", "Mugu"}));
        
                }
                if(zoneComboBox.getSelectedItem().equals("Koshi"))
                {
                    System.out.println("out");
                    districtComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose District", "Bhojpur", "Dhankuta", "Morang", "Sankhuwasabha", "Sunsari", "Terhatjum"}));
        
                }
                if(zoneComboBox.getSelectedItem().equals("Lumbini"))
                {
                    System.out.println("out");
                    districtComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose District", "Arghakhanchi", "Gulmi", "Kapilvastu", "Palpa", "Rupandehi", "Nawalparasi"}));
        
                }
                if(zoneComboBox.getSelectedItem().equals("Mahakali"))
                {
                    System.out.println("out");
                    districtComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose District", "Baitadi", "Dadeldhura", "Darchula", "Kanchanpur"}));
        
                }
                if(zoneComboBox.getSelectedItem().equals("Mechi"))
                {
                    System.out.println("out");
                    districtComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose District", "Ilam", "Jhapa", "Panchtar", "Taplejung"}));
        
                }
                if(zoneComboBox.getSelectedItem().equals("Narayani"))
                {
                    System.out.println("out");
                    districtComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose District", "Bara", "Parsa", "Rautahat", "Chitwan", "Makwanpur"}));
        
                }
                if(zoneComboBox.getSelectedItem().equals("Rapti"))
                {
                    System.out.println("out");
                    districtComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose District", "Dang", "Pyuthan", "Rolpa", "Rukum", "Salyan"}));
        
                }
                if(zoneComboBox.getSelectedItem().equals("Sagarmatha"))
                {
                    System.out.println("out");
                    districtComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose District", "Khotang", "Okhaldhunga", "Solukhambu", "Udayapur", "Saptari", "Siraha"}));
        
                }
                if(zoneComboBox.getSelectedItem().equals("Seti"))
                {
                    System.out.println("out");
                    districtComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose District", "Achham", "Bajhang", "Bajura", "Doti", "Kailali"}));
        
                }
                
            }
        }
    }

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if(confirmCheckBox.isSelected())
        {
        int ovalid = 0, bdatevalid = 0, occvalid = 0, eduvalid = 0, citivalid = 0, cidvalid = 0, zonvalid = 0, distvalid = 0, municvalid = 0, wardsvalid = 0, tolvalid = 0, hnumbvalid = 0, cnumbvalid = 0;
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
        String Municipality = municipalityTextField.getText();
        String WardNumber = wardNumberTextField.getText();        
        String Tole = toleTextField.getText();        
        String HouseNumber = houseNumberTextField.getText();
        String ContactNumber = contactNumberTextField.getText();
        String Email = emailTextField.getText();
        
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
        if(Municipality.equals(""))
        {
            showValidationOfMunicipality.setText("Municipality Field is Empty!!");
            municvalid = 0;
        }
        else{
            showValidationOfMunicipality.setText(null);
            municvalid = 1;
        }
        if(WardNumber.equals(""))
        {
            showValidationOfWardNumber.setText("Ward Number Field is Empty!");
            wardsvalid = 0;
        }
        else{
            showValidationOfWardNumber.setText(null);
            wardsvalid = 1;
        }
        if(Tole.equals(""))
        {
            showValidationOfTole.setText("Tole Field is Empty!");
            tolvalid = 0;
        }
        else{
            showValidationOfTole.setText(null);
            tolvalid = 1;
        }
        if(HouseNumber.equals(""))
        {
            showValidationOfHouseNumber.setText("House Number Field is Empty!");
            hnumbvalid = 0;
        }
        else{
            showValidationOfHouseNumber.setText(null);
            hnumbvalid = 1;
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
        
        if(ovalid == 1 && bdatevalid == 1 && citivalid == 1 && cidvalid == 1 && zonvalid == 1 && distvalid == 1 && municvalid == 1 && wardsvalid == 1 && tolvalid == 1 && hnumbvalid == 1 && cnumbvalid == 1)   
        {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata","root","");
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO ownerdetails VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        PreparedStatement pstmtt = conn.prepareStatement("INSERT INTO ownerphotos VALUES(?,?)");
        
        
        InputStream is = new FileInputStream(new File(imgPath));
        //-----------------------------------------------------------------------------------------------//
        
        
        //-----------------------------------------------------------------------------------------------//
        if(ownernamevalid == 1 && citizenshipnumbervalid == 1 &&  ownerphotovalid == 1 && municipalityvalid == 1 && wardnumbervalid == 1 && tolevalid == 1 && housenumbervalid == 1 && contactnumbervalid == 1)
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
        pstmt.setString(13,Municipality);
        pstmt.setString(14,WardNumber);
        pstmt.setString(15,Tole);
        pstmt.setString(16,HouseNumber);
        pstmt.setString(17,ContactNumber);
        pstmt.setString(18,Email);
        pstmt.setString(19,vehicleNumb);
        pstmtt.setString(1,vehicleNumb);
        pstmtt.setBlob(2,is);
       
        pstmt.executeUpdate();
        pstmtt.executeUpdate();

        
        JOptionPane.showMessageDialog(null,"Inserted Succesfully");
        pstmt.close();
        pstmtt.close();
        conn.close();
        StaffPanel sp = new StaffPanel();
        sp.initComponents(LoginID, dateTimeStamp);
        close();
        
        }else{
            JOptionPane.showMessageDialog(null,"You are not eligible for Driving");
            confirmCheckBox.setSelected(false);
        }
        }else{
            JOptionPane.showMessageDialog(null,"Invalid Data Entered!");
            confirmCheckBox.setSelected(false);
        }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        }else
        {
            JOptionPane.showMessageDialog(null,"Field cannot be left Empty");
            confirmCheckBox.setSelected(false);
        }
        }else{
            JOptionPane.showMessageDialog(null,"Please fill all the fields and tick Checkbox");
            confirmCheckBox.setSelected(false);
        }
    }                                            

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try {

        	System.out.println("submit"+vehicleNumb);
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata","root","");
        	String sql = "DELETE FROM `vehicledetails` WHERE vehiclenumber=?";
        	PreparedStatement stmt = conn.prepareStatement(sql);
        	stmt.setString(1,vehicleNumb);;
        	stmt.executeUpdate();
        }catch(Exception e)
        {
        	e.printStackTrace();
        }
    	StaffPanel sp = new StaffPanel();
        sp.initComponents(LoginID, dateTimeStamp);
        close();
    }                                          

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
    	try {
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata","root","");
        	String sql = "DELETE FROM `vehicledetails` WHERE vehiclenumber=?";
        	PreparedStatement stmt = conn.prepareStatement(sql);
        	stmt.setString(1,vehicleNumb);;
        	stmt.executeUpdate();
        }catch(Exception e)
        {
        	e.printStackTrace();
        }
    	int logout1 = JOptionPane.showConfirmDialog(null,"Do you really want to Log Out?","Logout Confirmation",JOptionPane.YES_NO_OPTION);
        if(logout1 == 0)
        {
        WorkerLogin sl = new WorkerLogin();
        sl.setVisible(true);
        close();
        }
    }                                            
    
    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
    	try {
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata","root","");
        	String sql = "DELETE FROM `vehicledetails` WHERE vehiclenumber=?";
        	PreparedStatement stmt = conn.prepareStatement(sql);
        	stmt.setString(1,vehicleNumb);;
        	stmt.executeUpdate();
        }catch(Exception e)
        {
        	e.printStackTrace();
        }
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
                new OwnerRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration              
    private JLabel loggedInTime;
    private JComboBox<String> CIDComboBox;
    private JLabel CIDLabel;
    private JLabel IDLabel;
    private JComboBox<String> PIDComboBox;
    private JLabel PIDLabel;
    private JLabel areMandatoryLabel;
    private com.toedter.calendar.JDateChooser bDateChooser;
    private JLabel citizenshipNumberLabel;
    private JSeparator citizenshipNumberSeparator;
    private JTextField citizenshipNumberTextField;
    private JButton closeButton;
    private JCheckBox confirmCheckBox;
    private JLabel contactNumberLabel;
    private JLabel contactNumberFrontLabel;
    private JSeparator contactNumberSeparator;
    private JTextField contactNumberTextField;
    private JLabel dateofBirthLabel;
    private JComboBox<String> districtComboBox;
    private JLabel districtLabel;
    private JLabel educationLabel;
    private JSeparator educationSeparator;
    private JTextField educationTextField;
    private JLabel emailLabel;
    private JSeparator emailSeparator;
    private JTextField emailTextField;
    private JRadioButton femaleRadioButton;
    private JLabel fieldWithLabel;
    private ButtonGroup genderButtonGroup;
    private JLabel genderLabel;
    private JButton homeButton;
    private JLabel houseNumberLabel;
    private JSeparator houseNumberSeparator;
    private JTextField houseNumberTextField;
    private JButton logOutButton;
    private JRadioButton maleRadioButton;
    private JLabel municipalityLabel;
    private JSeparator municipalitySeparator;
    private JTextField municipalityTextField;
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
    private JLabel photoLabel;
    private JLabel redmark0;
    private JLabel redmark1;
    private JLabel redmark10;
    private JLabel redmark11;
    private JLabel redmark12;
    private JLabel redmark13;
    private JLabel redmark14;
    private JLabel redmark2;
    private JLabel redmark3;
    private JLabel redmark4;
    private JLabel redmark5;
    private JLabel redmark6;
    private JLabel redmark7;
    private JLabel redmark8;
    private JLabel redmark9;
    private JPanel registerPanel;
    private JLabel registerPhotoLabel;
    private JLabel ageLabel;
    private JSeparator ageSeparator;
    private JLabel showAgeLabel;
    private JLabel showValidationOfAge;
    private JLabel showValidationOfBDate;
    private JLabel showValidationOfCID;
    private JLabel showValidationOfCitizenshipNumber;
    private JLabel showValidationOfContactNumber;
    private JLabel showValidationOfDistrict;
    private JLabel showValidationOfEducation;
    private JLabel showValidationOfEmail;
    private JLabel showValidationOfHouseNumber;
    private JLabel showValidationOfMunicipality;
    private JLabel showValidationOfOccupation;
    private JLabel showValidationOfOwnerName;
    private JLabel showValidationOfOwnerPhoto;
    private JLabel showValidationOfPID;
    private JLabel showValidationOfPassportNumber;
    private JLabel showValidationOfTole;
    private JLabel showValidationOfWardNumber;
    private JLabel showValidationOfZone;
    private JLabel staffIdLabel;
    private JButton submitButton;
    private JLabel toleLabel;
    private JSeparator toleSeparator;
    private JTextField toleTextField;
    private JLabel wardNumberLabel;
    private JSeparator wardNumberSeparator;
    private JTextField wardNumberTextField;
    private JComboBox<String> zoneComboBox;
    private JLabel zoneLabel;
    private ItemHandler handler;
    // End of variables declaration                   
}
