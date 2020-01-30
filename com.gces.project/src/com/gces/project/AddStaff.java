package com.gces.project;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import java.sql.*;

public class AddStaff extends JDialog {
    static int ivalid = 0, pvalid = 0, snvalid = 0, emailvalid = 0, contactnumbervalid = 0, addressvalid = 0;

    public AddStaff(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    public static StringBuffer shaFunction(String plainText)
	{
		StringBuffer hexString = new StringBuffer();
		try
		{
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] encodedHash = md.digest(plainText.getBytes(StandardCharsets.UTF_8));
			for (int i = 0; i < encodedHash.length; i++)
			{
				String hex = Integer.toHexString(0xff & encodedHash[i]); //to convert bytes to hexadecimal equivalent and that to string
				if (hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}
			return hexString;
		} catch(NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		return hexString;
	}

    private void initComponents() {

        genderButtonGroup = new ButtonGroup();
        shiftButtonGroup = new ButtonGroup();
        jPanel1 = new JPanel();
        titleSeparator = new JSeparator();
        titleLabel = new JLabel();
        staffIdLabel = new JLabel();
        staffIdTextField = new JTextField();
        staffIdSeperator = new JSeparator();
        showValidationOfStaffId = new JLabel();
        staffNameLabel = new JLabel();
        staffNameTextField = new JTextField();
        staffNameSeparator = new JSeparator();
        showValidationOfStaffName = new JLabel();
        male = new JRadioButton();
        genderLabel = new JLabel();
        female = new JRadioButton();
        passwordLabel = new JLabel();
        passwordField = new JPasswordField();
        passwordSeparator = new JSeparator();
        showValidationOfPassword = new JLabel();
        showpass = new JCheckBox();
        emailLabel = new JLabel();
        emailTextField = new JTextField();
        emailSeparator = new JSeparator();
        showValidationOfEmail = new JLabel();
        contactnoLabel = new JLabel();
        contactNumberTextField = new JTextField();
        contactNumberSeparator = new JSeparator();
        showValidationOfContactNumber = new JLabel();
        addressLabel = new JLabel();
        addressTextField = new JTextField();
        addressSeparator = new JSeparator();
        showValidationOfAddress = new JLabel();
        shiftLabel = new JLabel();
        morning = new JRadioButton();
        day = new JRadioButton();
        addButton = new JButton();
        cancelButton = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setOpacity(0.9F);
        setPreferredSize(new java.awt.Dimension(440, 580));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(1, 50, 67));
        jPanel1.setPreferredSize(new java.awt.Dimension(440, 580));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(titleSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 400, 10));

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setText("Staff Details");
        jPanel1.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 120, -1));

        //--------------------------------------------------------------------------------------------------//
        staffIdLabel.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        staffIdLabel.setForeground(new java.awt.Color(255, 255, 255));
        staffIdLabel.setText("Staff-ID:");
        jPanel1.add(staffIdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 90, 20));

        staffIdTextField.setBackground(new java.awt.Color(1, 50, 67));
        staffIdTextField.setForeground(new java.awt.Color(255, 255, 255));
        staffIdTextField.setBorder(null);
        staffIdTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                staffIdTextFieldKeyReleased(evt);
            }
        });
        jPanel1.add(staffIdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 200, 20));
        jPanel1.add(staffIdSeperator, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 200, 10));

        showValidationOfStaffId.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(showValidationOfStaffId, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 200, 15));

        staffNameLabel.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        staffNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        staffNameLabel.setText("Staff Name:");
        jPanel1.add(staffNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, 20));

        staffNameTextField.setBackground(new java.awt.Color(1, 50, 67));
        staffNameTextField.setForeground(new java.awt.Color(255, 255, 255));
        staffNameTextField.setBorder(null);
        staffNameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                staffNameTextFieldKeyReleased(evt);
            }
        });
        jPanel1.add(staffNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 200, 20));
        jPanel1.add(staffNameSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 200, 10));

        showValidationOfStaffName.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(showValidationOfStaffName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 200, 15));

        male.setBackground(new java.awt.Color(1, 50, 67));
        genderButtonGroup.add(male);
        male.setForeground(new java.awt.Color(255, 255, 255));
        male.setSelected(true);
        male.setText("Male");
        jPanel1.add(male, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 60, 20));

        genderLabel.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        genderLabel.setForeground(new java.awt.Color(255, 255, 255));
        genderLabel.setText("Gender:");
        jPanel1.add(genderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 80, 20));

        female.setBackground(new java.awt.Color(1, 50, 67));
        genderButtonGroup.add(female);
        female.setForeground(new java.awt.Color(255, 255, 255));
        female.setText("Female");
        jPanel1.add(female, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, -1, 20));

        passwordLabel.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(255, 255, 255));
        passwordLabel.setText("Password:");
        jPanel1.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, 20));

        passwordField.setBackground(new java.awt.Color(1, 50, 67));
        passwordField.setForeground(new java.awt.Color(255, 255, 255));
        passwordField.setBorder(null);
        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwordFieldKeyReleased(evt);
            }
        });
        jPanel1.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 200, 20));
        jPanel1.add(passwordSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 200, 10));

        showValidationOfPassword.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(showValidationOfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 200, 15));

        showpass.setBackground(new java.awt.Color(1, 50, 67));
        showpass.setForeground(new java.awt.Color(255, 255, 255));
        showpass.setText("Show Password");
        showpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showpassActionPerformed(evt);
            }
        });
        jPanel1.add(showpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, -1, -1));

        emailLabel.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(255, 255, 255));
        emailLabel.setText("Email:");
        jPanel1.add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, 20));

        emailTextField.setBackground(new java.awt.Color(1, 50, 67));
        emailTextField.setForeground(new java.awt.Color(255, 255, 255));
        emailTextField.setBorder(null);
        emailTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emailTextFieldKeyReleased(evt);
            }
        });
        jPanel1.add(emailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 200, 20));
        jPanel1.add(emailSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 200, 10));

        showValidationOfEmail.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(showValidationOfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 200, 15));

        contactnoLabel.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        contactnoLabel.setForeground(new java.awt.Color(255, 255, 255));
        contactnoLabel.setText("Contact no:");
        jPanel1.add(contactnoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, -1, 20));

        contactNumberTextField.setBackground(new java.awt.Color(1, 50, 67));
        contactNumberTextField.setForeground(new java.awt.Color(255, 255, 255));
        contactNumberTextField.setBorder(null);
        contactNumberTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                contactNumberTextFieldKeyReleased(evt);
            }
        });
        jPanel1.add(contactNumberTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 200, 20));
        jPanel1.add(contactNumberSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, 200, 10));

        showValidationOfContactNumber.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(showValidationOfContactNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, 200, 15));

        addressLabel.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        addressLabel.setForeground(new java.awt.Color(255, 255, 255));
        addressLabel.setText("Address:");
        jPanel1.add(addressLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, -1, 20));

        addressTextField.setBackground(new java.awt.Color(1, 50, 67));
        addressTextField.setForeground(new java.awt.Color(255, 255, 255));
        addressTextField.setBorder(null);
        addressTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                addressTextFieldKeyReleased(evt);
            }
        });
        jPanel1.add(addressTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, 200, 20));
        jPanel1.add(addressSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 200, 10));

        showValidationOfAddress.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(showValidationOfAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 200, 15));

        shiftLabel.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        shiftLabel.setForeground(new java.awt.Color(255, 255, 255));
        shiftLabel.setText("Shift:");
        jPanel1.add(shiftLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, -1, 20));

        morning.setBackground(new java.awt.Color(1, 50, 67));
        shiftButtonGroup.add(morning);
        morning.setForeground(new java.awt.Color(255, 255, 255));
        morning.setSelected(true);
        morning.setText("Morning");
        jPanel1.add(morning, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, -1, -1));

        day.setBackground(new java.awt.Color(1, 50, 67));
        shiftButtonGroup.add(day);
        day.setForeground(new java.awt.Color(255, 255, 255));
        day.setText("Day");
        jPanel1.add(day, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 470, -1, -1));

        //--------------------------------------------------------------------------------------------------//
        addButton.setBackground(new java.awt.Color(255, 255, 255));
        addButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addButton.setText("Add");
        addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        addButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addButtonKeyPressed(evt);
            }
        });
        
        jPanel1.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 530, 80, 30));

        cancelButton.setBackground(new java.awt.Color(255, 255, 255));
        cancelButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.setHorizontalTextPosition(SwingConstants.RIGHT);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        cancelButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cancelButtonKeyPressed(evt);
            }
        });
        
        jPanel1.add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 530, 80, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 580));

        pack();
        setLocationRelativeTo(null);
    }

    //---------------------------------------Validation----------------------------------------------//
    
    private void staffIdTextFieldKeyReleased(java.awt.event.KeyEvent evt) {                                             
        String PATTERN = "^[a-z]{0,4}[0-9]{0,4}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(staffIdTextField.getText());
        if(!match.matches())
        {
            showValidationOfStaffId.setText("Staff ID field is Incorrect");
            staffIdTextField.setForeground(Color.red);
            ivalid = 0;
        }
        if(staffIdTextField.getText().equals(""))
        {
            showValidationOfStaffId.setText("Staff ID field cannot be Empty");
            staffIdTextField.setForeground(Color.white);
            ivalid = 0;
        }
        if(match.matches())
        {
            showValidationOfStaffId.setText(null);
            staffIdTextField.setForeground(Color.white);
            ivalid = 1;
        }
    }                                            

    private void staffNameTextFieldKeyReleased(java.awt.event.KeyEvent evt) {                                               
        String PATTERN = "^[a-zA-Z\\s]{2,22}+$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(staffNameTextField.getText());
        if(!match.matches())
        {
            showValidationOfStaffName.setText("Naming is incorrect!");
            staffNameTextField.setForeground(Color.red);
            snvalid = 0;
        }
        if(staffNameTextField.getText().equals(""))
        {
            showValidationOfStaffName.setText(null);
            staffNameTextField.setForeground(Color.white);
            snvalid = 0;
        }
        if(match.matches())
        {
            showValidationOfStaffName.setText(null);
            staffNameTextField.setForeground(Color.white);
            snvalid = 1;
        }

    }                                              

    private void passwordFieldKeyReleased(java.awt.event.KeyEvent evt) {                                          
        String PATTERN = "^[a-zA-Z0-9]{0,15}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(passwordField.getText());
        if(!match.matches())
        {
            showValidationOfPassword.setText("Password field is Incorrect");
            passwordField.setForeground(Color.red);
            pvalid = 0;
        }
        if(passwordField.getText().equals(""))
        {
            showValidationOfPassword.setText("Password field cannot be Empty");
            passwordField.setForeground(Color.white);
            pvalid = 0;
        }
        if(match.matches())
        {
            showValidationOfPassword.setText(null);
            passwordField.setForeground(Color.white);
            pvalid = 1;
        }
    }                                         

    private void showpassActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if(showpass.isSelected())
        {
            passwordField.setEchoChar((char)0);
        }
        else
        {
            passwordField.setEchoChar('*');
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

    private void addressTextFieldKeyReleased(java.awt.event.KeyEvent evt) {                                             
        String PATTERN = "^[a-zA-Z\\s]{2,25}+$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(addressTextField.getText());
        if(!match.matches())
        {
            showValidationOfAddress.setText("Naming is incorrect!");
            addressTextField.setForeground(Color.red);
            addressvalid = 0;
        }
        if(addressTextField.getText().equals(""))
        {
            showValidationOfAddress.setText(null);
            addressTextField.setForeground(Color.white);
            addressvalid = 0;
        }
        if(match.matches())
        {
            showValidationOfAddress.setText(null);
            addressTextField.setForeground(Color.white);
            addressvalid = 1;
        }
    }                                            

    //---------------------------------------------------------------------------------------------//
    
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        String sid1=staffIdTextField.getText();
        String suser1=staffNameTextField.getText();
        String spass1=passwordField.getText();
        StringBuffer sb = new StringBuffer(shaFunction(spass1));
        String spass = new String(sb);
        
        String semail1=emailTextField.getText();
        String scontactno1=contactNumberTextField.getText();
        String saddress1=addressTextField.getText();
         //------------//
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        Date d1 = new Date();
        String sdate = new String(format.format(d1));  
        //------------//
        String sidcategory1 = "staff";
        String sgender="Male";
            if(female.isSelected())
                {
                    sgender="Female";
                }
        String sshift="Morning";
            if(day.isSelected())
                {
                    sshift="Day";
                }
        int esivalid=0, esnvalid=0, epvalid=0, eevalid=0, ecnvalid=0, eavalid=0;
    
        //-------------------------------------------Check Empty----------------------------------------------------//
        if(sid1.equals(""))
        {
            showValidationOfStaffId.setText("Staff ID Field is Empty!");
            esivalid = 0;
        }
        else{
            showValidationOfStaffId.setText(null);
            esivalid = 1;
        }
        if(suser1.equals(""))
        {
            showValidationOfStaffName.setText("Staff Name Field is Empty!");
            esnvalid = 0;
        }
        else{
            showValidationOfStaffName.setText(null);
            esnvalid = 1;
        }
        if(spass1.equals(""))
        {
            showValidationOfPassword.setText("Password Field is Empty!");
            epvalid = 0;
        }
        else{
            showValidationOfPassword.setText(null);
            epvalid = 1;
        }
        if(semail1.equals(""))
        {
            showValidationOfEmail.setText("Email ID Field is Empty!");
            eevalid = 0;
        }
        else{
            showValidationOfEmail.setText(null);
            eevalid = 1;
        }
        if(scontactno1.equals(""))
        {
            showValidationOfContactNumber.setText("Contact Number Field is Empty!");
            ecnvalid = 0;
        }
        else{
            showValidationOfContactNumber.setText(null);
            ecnvalid = 1;
        }
        if(saddress1.equals(""))
        {
            showValidationOfAddress.setText("Address Field is Empty!");
            eavalid = 0;
        }
        else{
            showValidationOfAddress.setText(null);
            eavalid = 1;
        }
        //------------------------------------------------------------------------------------------------//
        //database
        if(esivalid==1 && esnvalid==1 && epvalid==1 && eevalid==1 && ecnvalid==1 && eavalid==1)
        {
         try
            {
                
                Connection conn;
                Class.forName("com.mysql.jdbc.Driver");
                conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/workerdetails","root","");
                PreparedStatement pstmt = conn.prepareStatement("INSERT INTO workdet VALUES(?,?,?,?,?,?,?,?,?,?)");
                
                if( ivalid == 1 && pvalid == 1 && snvalid == 1 && emailvalid == 1 && contactnumbervalid == 1 && addressvalid == 1)
                {
                pstmt.setString(1,sid1);
                pstmt.setString(2,spass);
                pstmt.setString(3,sidcategory1);
                pstmt.setString(4,suser1);
                pstmt.setString(5,sgender);
                pstmt.setString(6,saddress1);
                pstmt.setString(7,scontactno1);
                pstmt.setString(8,semail1);
                pstmt.setString(9,sdate);
                pstmt.setString(10,sshift);
                
                pstmt.executeUpdate();                                               

                SuccessDialog dial = new SuccessDialog(new JFrame(), true);
                dial.setVisible(true); 
                this.dispose();
                }
                else{
                	InvalidDialog dialog = new InvalidDialog(new JFrame(), true);
                    dialog.setVisible(true);         
                }            
            }catch(java.sql.SQLIntegrityConstraintViolationException icve)
         		{
            		DoubleIdDialog dialog = new DoubleIdDialog(new JFrame(), true);
            		dialog.setVisible(true);
         	}catch(Exception e)
            {
                System.out.println(e);
            }
        }else{
        	EmptyDialog dialog = new EmptyDialog(new JFrame(), true);
            dialog.setVisible(true);
        }
    }                                         

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        this.dispose();
    }          
    
    private void addButtonKeyPressed(java.awt.event.KeyEvent evt) {                                       
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String sid1=staffIdTextField.getText();
            String suser1=staffNameTextField.getText();
            String spass1=passwordField.getText();
            StringBuffer sb = new StringBuffer(shaFunction(spass1));
            String spass = new String(sb);
            
            String semail1=emailTextField.getText();
            String scontactno1=contactNumberTextField.getText();
            String saddress1=addressTextField.getText();
             //------------//
            SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
            Date d1 = new Date();
            String sdate = new String(format.format(d1));  
            //------------//
            String sidcategory1 = "staff";
            String sgender="Male";
                if(female.isSelected())
                    {
                        sgender="Female";
                    }
            String sshift="Morning";
                if(day.isSelected())
                    {
                        sshift="Day";
                    }
            int esivalid=0, esnvalid=0, epvalid=0, eevalid=0, ecnvalid=0, eavalid=0;
        
            //-------------------------------------------Check Empty----------------------------------------------------//
            if(sid1.equals(""))
            {
                showValidationOfStaffId.setText("Staff ID Field is Empty!");
                esivalid = 0;
            }
            else{
                showValidationOfStaffId.setText(null);
                esivalid = 1;
            }
            if(suser1.equals(""))
            {
                showValidationOfStaffName.setText("Staff Name Field is Empty!");
                esnvalid = 0;
            }
            else{
                showValidationOfStaffName.setText(null);
                esnvalid = 1;
            }
            if(spass1.equals(""))
            {
                showValidationOfPassword.setText("Password Field is Empty!");
                epvalid = 0;
            }
            else{
                showValidationOfPassword.setText(null);
                epvalid = 1;
            }
            if(semail1.equals(""))
            {
                showValidationOfEmail.setText("Email ID Field is Empty!");
                eevalid = 0;
            }
            else{
                showValidationOfEmail.setText(null);
                eevalid = 1;
            }
            if(scontactno1.equals(""))
            {
                showValidationOfContactNumber.setText("Contact Number Field is Empty!");
                ecnvalid = 0;
            }
            else{
                showValidationOfContactNumber.setText(null);
                ecnvalid = 1;
            }
            if(saddress1.equals(""))
            {
                showValidationOfAddress.setText("Address Field is Empty!");
                eavalid = 0;
            }
            else{
                showValidationOfAddress.setText(null);
                eavalid = 1;
            }
            //------------------------------------------------------------------------------------------------//
            //database
            if(esivalid==1 && esnvalid==1 && epvalid==1 && eevalid==1 && ecnvalid==1 && eavalid==1)
            {
             try
                {
                    
                    Connection conn;
                    Class.forName("com.mysql.jdbc.Driver");
                    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/workerdetails","root","");
                    PreparedStatement pstmt = conn.prepareStatement("INSERT INTO workdet VALUES(?,?,?,?,?,?,?,?,?,?)");
                    
                    if( ivalid == 1 && pvalid == 1 && snvalid == 1 && emailvalid == 1 && contactnumbervalid == 1 && addressvalid == 1)
                    {
                    pstmt.setString(1,sid1);
                    pstmt.setString(2,spass);
                    pstmt.setString(3,sidcategory1);
                    pstmt.setString(4,suser1);
                    pstmt.setString(5,sgender);
                    pstmt.setString(6,saddress1);
                    pstmt.setString(7,scontactno1);
                    pstmt.setString(8,semail1);
                    pstmt.setString(9,sdate);
                    pstmt.setString(10,sshift);
                    
                    pstmt.executeUpdate();                                               

                    SuccessDialog dial = new SuccessDialog(new JFrame(), true);
                    dial.setVisible(true); 
                    this.dispose();
                    }
                    else{
                    	InvalidDialog dialog = new InvalidDialog(new JFrame(), true);
                        dialog.setVisible(true);         
                    }            
                }catch(java.sql.SQLIntegrityConstraintViolationException icve)
             		{
                		DoubleIdDialog dialog = new DoubleIdDialog(new JFrame(), true);
                		dialog.setVisible(true);
             	}catch(Exception e)
                {
                    System.out.println(e);
                }
            }else{
            	EmptyDialog dialog = new EmptyDialog(new JFrame(), true);
                dialog.setVisible(true);
            }
        }
    }
    
    private void cancelButtonKeyPressed(java.awt.event.KeyEvent evt) {                                       
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
        	this.dispose();
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddStaff dialog = new AddStaff(new JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public JButton addButton;
    private JLabel addressLabel;
    private JSeparator addressSeparator;
    private JTextField addressTextField;
    private JButton cancelButton;
    private JSeparator contactNumberSeparator;
    private JTextField contactNumberTextField;
    private JLabel contactnoLabel;
    private JRadioButton day;
    private JLabel emailLabel;
    private JSeparator emailSeparator;
    private JTextField emailTextField;
    private JRadioButton female;
    private ButtonGroup genderButtonGroup;
    private JLabel genderLabel;
    private JPanel jPanel1;
    private JRadioButton male;
    private JRadioButton morning;
    private JPasswordField passwordField;
    private JLabel passwordLabel;
    private JSeparator passwordSeparator;
    private ButtonGroup shiftButtonGroup;
    private JLabel shiftLabel;
    private JLabel showValidationOfAddress;
    private JLabel showValidationOfContactNumber;
    private JLabel showValidationOfEmail;
    private JLabel showValidationOfPassword;
    private JLabel showValidationOfStaffId;
    private JLabel showValidationOfStaffName;
    private JCheckBox showpass;
    private JLabel staffIdLabel;
    private JSeparator staffIdSeperator;
    private JTextField staffIdTextField;
    private JLabel staffNameLabel;
    private JSeparator staffNameSeparator;
    private JTextField staffNameTextField;
    private JLabel titleLabel;
    private JSeparator titleSeparator;
}
