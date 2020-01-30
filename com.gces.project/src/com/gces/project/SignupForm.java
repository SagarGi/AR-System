package com.gces.project;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;

public class SignupForm extends JFrame {
    static int photoChange = 0;
    static String categ = "staff";
    static int sidebar = 0;
    static int mousepX, mousepY; 
    static int ivalid = 0, pvalid = 0;
    static int status = 0, pstatus = 0;
    
    public SignupForm() {
        initComponents();
    }
    private void close()
    {
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
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
			//System.out.println(hexString);
			return hexString;
		} catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		return hexString;
	}

    private void initComponents() {

        jPanel1 = new JPanel();
        jTextField1 = new JTextField();
        jLabel1 = new JLabel();
        jPanel2 = new JPanel();
        closeButton = new JButton();
        minimizeButton = new JButton();
        adminIDLabel = new JLabel();
        adminIdTextField = new JTextField();
        adminIDSeparator = new JSeparator();
        showValidationOfadminId = new JLabel();
        passwordLabel = new JLabel();
        passwordField = new JPasswordField();
        passwordSeparator = new JSeparator();
        showValidationOfPassword = new JLabel();
        signupButton = new JButton();
        showpass = new JCheckBox();
        signInFormLabel = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setOpacity(0.96F);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(1, 50, 67));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setBackground(new java.awt.Color(1, 50, 67));
        jTextField1.setBorder(null);
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/com/gces/project/icons/adminpic.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 200, 200));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
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

        signInFormLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        signInFormLabel.setForeground(new java.awt.Color(255, 255, 255));
        signInFormLabel.setText("Sign up Form");
        signInFormLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(signInFormLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                .addComponent(minimizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(minimizeButton)
                    .addComponent(closeButton)
                    .addComponent(signInFormLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 30));

        adminIDLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        adminIDLabel.setForeground(new java.awt.Color(255, 255, 255));
        adminIDLabel.setText("Admin ID");
        jPanel1.add(adminIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, -1, -1));

        adminIdTextField.setBackground(new java.awt.Color(1, 50, 67));
        adminIdTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        adminIdTextField.setForeground(new java.awt.Color(255, 255, 255));
        adminIdTextField.setText("Enter Admin ID");
        adminIdTextField.setBorder(null);
        adminIdTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                adminIdTextFieldFocusGained(evt);
            }
        });
        adminIdTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                adminIdTextFieldKeyReleased(evt);
            }
        });
        jPanel1.add(adminIdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 240, 20));
        jPanel1.add(adminIDSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 240, 10));

        showValidationOfadminId.setBackground(new java.awt.Color(55, 27, 65));
        showValidationOfadminId.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(showValidationOfadminId, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 240, -1));

        passwordLabel.setBackground(new java.awt.Color(55, 27, 65));
        passwordLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(255, 255, 255));
        passwordLabel.setText("Password");
        jPanel1.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, -1, -1));

        passwordField.setBackground(new java.awt.Color(1, 50, 67));
        passwordField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        passwordField.setForeground(new java.awt.Color(255, 255, 255));
        passwordField.setText("EnterPassword");
        passwordField.setBorder(null);
        passwordField.setPreferredSize(new java.awt.Dimension(76, 15));
        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFieldFocusGained(evt);
            }
        });
        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwordFieldKeyReleased(evt);
            }
        });
        jPanel1.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 240, 20));
        jPanel1.add(passwordSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 240, 10));

        showValidationOfPassword.setBackground(new java.awt.Color(55, 27, 65));
        showValidationOfPassword.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(showValidationOfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 240, -1));

        signupButton.setBackground(new java.awt.Color(255, 255, 255));
        signupButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        signupButton.setText("Sign Up");
        signupButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signupButton.setHorizontalTextPosition(SwingConstants.LEFT);
        signupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupButtonActionPerformed(evt);
            }
        });
        signupButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                signupButtonKeyPressed(evt);
            }
        });
        
        jPanel1.add(signupButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 470, 90, 30));

        showpass.setBackground(new java.awt.Color(1, 50, 67));
        showpass.setForeground(new java.awt.Color(255, 255, 255));
        showpass.setText("Show Password");
        showpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showpassActionPerformed(evt);
            }
        });
        jPanel1.add(showpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void adminIdTextFieldFocusGained(java.awt.event.FocusEvent evt) {                                             
        if(status==0)
        adminIdTextField.setText("");
    }                                            

    private void adminIdTextFieldKeyReleased(java.awt.event.KeyEvent evt) {                                             
        String PATTERN = "^[a-z]{0,4}[0-9]{0,4}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(adminIdTextField.getText());
        if(!match.matches())
        {
            showValidationOfadminId.setText("Given ID is Incorrect");
            adminIdTextField.setForeground(Color.red);
            ivalid = 0;
        }
        if(adminIdTextField.getText().equals(""))
        {
            showValidationOfadminId.setText("Staff ID field cannot be Empty");
            adminIdTextField.setForeground(Color.white);
            ivalid = 0;
        }
        if(match.matches())
        {
            showValidationOfadminId.setText(null);
            adminIdTextField.setForeground(Color.white);
            ivalid = 1;
        }
    }                                            

    private void passwordFieldFocusGained(java.awt.event.FocusEvent evt) {                                          
        if(pstatus==0)
        passwordField.setText("");
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

    private void signupButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
       int ievalid = 0, pevalid = 0;

        String SignupID = adminIdTextField.getText();
        String Password = passwordField.getText();
        StringBuffer sb = new StringBuffer(shaFunction(Password));
        String pass = new String(sb);
        String suser1 = "Empty";
        String semail1="Empty";
        String scontactno1="Empty";
        String saddress1="Empty";
         //------------//
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        java.util.Date d1 = new java.util.Date();
        String sdate = new String(format.format(d1));  
        //------------//
        String sidcategory1 = "admin";
        String sgender="Empty";
        String sshift="Empty";

        if(SignupID.equals(""))
        {
            showValidationOfadminId.setText("admin ID field cannot be Empty");
            ievalid = 1;
        }

        if(Password.equals(""))
        {
            showValidationOfPassword.setText("Password field cannot be Empty");
            pevalid = 1;
        }
        if(ievalid != 1 && pevalid != 1)
        {

     	try
		{
			Connection conn;
			Statement statement;
			conn = DriverManager.getConnection("jdbc:mysql://localhost?useSSL=true","root", "");
			statement = conn.createStatement();
			statement.executeUpdate("CREATE DATABASE IF NOT EXISTS workerdetails;");
			statement.executeUpdate("USE workerdetails");
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS workdet(id varchar(40) primary key,password char(64),idcategory varchar(40), workername varchar(50),gender varchar(25),address varchar(50),contactnumber varchar(40),emailid varchar(50),idregistereddate date,shift varchar(25));");
                        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO workdet VALUES(?,?,?,?,?,?,?,?,?,?)");
                        
                if(ivalid == 1 && pvalid == 1)
                {
                        
                            pstmt.setString(1,SignupID);
                            pstmt.setString(2,pass);
                            pstmt.setString(3,sidcategory1);
                            pstmt.setString(4,suser1);
                            pstmt.setString(5,sgender);
                            pstmt.setString(6,saddress1);
                            pstmt.setString(7,scontactno1);
                            pstmt.setString(8,semail1);
                            pstmt.setString(9,sdate);
                            pstmt.setString(10,sshift);

                            pstmt.executeUpdate();                                               

                            SuccessDialog dialog = new SuccessDialog(new JFrame(), true);
                            dialog.setVisible(true);
                            
			statement.close();
			conn.close();
		}else{
					InvalidDialog dialog = new InvalidDialog(new JFrame(), true);
					dialog.setVisible(true);
             }

			}catch(java.sql.SQLIntegrityConstraintViolationException icve)
               {
					DoubleIdDialog dialog = new DoubleIdDialog(new JFrame(), true);
					dialog.setVisible(true);
               }
     	catch(SQLException e)
		{
			System.out.println(e);
		}
                
        }else{
        	EmptyDialog dialog = new EmptyDialog(new JFrame(), true);
            dialog.setVisible(true);
        }
         try
		{
			Connection conn;
			Statement statement;
			conn = DriverManager.getConnection("jdbc:mysql://localhost?useSSL=true","root", "");
			statement = conn.createStatement();
			statement.executeUpdate("CREATE DATABASE IF NOT EXISTS userdata;");
			statement.executeUpdate("USE userdata");
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS ownervehicledetails(ownername varchar(50), registrationdate date, gender varchar(20), dateofbirth date, occupation varchar(40), education varchar(40), citizenshipnumber varchar(40), citiissdis varchar(40), passportnumber varchar(40), passissdis varchar(40), zone varchar(40), district varchar(40), address varchar(40), housenumber varchar(20), contactnumber varchar(40), emailid varchar(50), companyname varchar(40),vehiclenumber varchar(40) primary key, vehicletype varchar(40), modelnumber varchar(40), vehiclecolor varchar(20), fueltype varchar(20), enginenumber varchar(40), displacement varchar(40), maxpower varchar(40), maxtorque varchar(40), noofseats int(15), noofgears varchar(25), tankcapacity varchar(40), ownerimage longblob);");
                        
			statement.close();
			conn.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
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

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        close();
    }                                           

    private void minimizeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        this.setState(SignupForm.ICONIFIED);
    }                                              

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {                                     
        mousepX = evt.getX();
        mousepY = evt.getY();

    }                                    

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {                                     
        int kordinateX = evt.getXOnScreen();
        int kordinateY = evt.getYOnScreen();
        this.setLocation(kordinateX-mousepX, kordinateY-mousepY);

    }                                    

    private void signupButtonKeyPressed(java.awt.event.KeyEvent evt) {                                       
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int ievalid = 0, pevalid = 0;

            String SignupID = adminIdTextField.getText();
            String Password = passwordField.getText();
            StringBuffer sb = new StringBuffer(shaFunction(Password));
            String pass = new String(sb);
            String suser1 = "Empty";
            String semail1="Empty";
            String scontactno1="Empty";
            String saddress1="Empty";
             //------------//
            SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
            java.util.Date d1 = new java.util.Date();
            String sdate = new String(format.format(d1));  
            //------------//
            String sidcategory1 = "admin";
            String sgender="Empty";
            String sshift="Empty";

            if(SignupID.equals(""))
            {
                showValidationOfadminId.setText("admin ID field cannot be Empty");
                ievalid = 1;
            }

            if(Password.equals(""))
            {
                showValidationOfPassword.setText("Password field cannot be Empty");
                pevalid = 1;
            }
            if(ievalid != 1 && pevalid != 1)
            {

         	try
    		{
    			Connection conn;
    			Statement statement;
    			conn = DriverManager.getConnection("jdbc:mysql://localhost?useSSL=true","root", "");
    			statement = conn.createStatement();
    			statement.executeUpdate("CREATE DATABASE IF NOT EXISTS workerdetails;");
    			statement.executeUpdate("USE workerdetails");
    			statement.executeUpdate("CREATE TABLE IF NOT EXISTS workdet(id varchar(40) primary key,password char(64),idcategory varchar(40), workername varchar(50),gender varchar(25),address varchar(50),contactnumber varchar(40),emailid varchar(50),idregistereddate date,shift varchar(25));");
                            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO workdet VALUES(?,?,?,?,?,?,?,?,?,?)");
                            
                    if(ivalid == 1 && pvalid == 1)
                    {
                            
                                pstmt.setString(1,SignupID);
                                pstmt.setString(2,pass);
                                pstmt.setString(3,sidcategory1);
                                pstmt.setString(4,suser1);
                                pstmt.setString(5,sgender);
                                pstmt.setString(6,saddress1);
                                pstmt.setString(7,scontactno1);
                                pstmt.setString(8,semail1);
                                pstmt.setString(9,sdate);
                                pstmt.setString(10,sshift);

                                pstmt.executeUpdate();                                               

                                SuccessDialog dialog = new SuccessDialog(new JFrame(), true);
                                dialog.setVisible(true);
                                
    			statement.close();
    			conn.close();
    		}else{
    					InvalidDialog dialog = new InvalidDialog(new JFrame(), true);
    					dialog.setVisible(true);
                 }

    			}catch(java.sql.SQLIntegrityConstraintViolationException icve)
                   {
    					DoubleIdDialog dialog = new DoubleIdDialog(new JFrame(), true);
    					dialog.setVisible(true);
                   }
         	catch(SQLException e)
    		{
    			System.out.println(e);
    		}
                    
            }else{
            	EmptyDialog dialog = new EmptyDialog(new JFrame(), true);
                dialog.setVisible(true);
            }
             try
    		{
    			Connection conn;
    			Statement statement;
    			conn = DriverManager.getConnection("jdbc:mysql://localhost?useSSL=true","root", "");
    			statement = conn.createStatement();
    			statement.executeUpdate("CREATE DATABASE IF NOT EXISTS userdata;");
    			statement.executeUpdate("USE userdata");
    			statement.executeUpdate("CREATE TABLE IF NOT EXISTS ownervehicledetails(ownername varchar(50), registrationdate date, gender varchar(20), dateofbirth date, occupation varchar(40), education varchar(40), citizenshipnumber varchar(40), citiissdis varchar(40), passportnumber varchar(40), passissdis varchar(40), zone varchar(40), district varchar(40), address varchar(40), housenumber varchar(20), contactnumber varchar(40), emailid varchar(50), companyname varchar(40),vehiclenumber varchar(40) primary key, vehicletype varchar(40), modelnumber varchar(40), vehiclecolor varchar(20), fueltype varchar(20), enginenumber varchar(40), displacement varchar(40), maxpower varchar(40), maxtorque varchar(40), noofseats int(15), noofgears varchar(25), tankcapacity varchar(40), ownerimage longblob);");
                            
    			statement.close();
    			conn.close();
    		}
    		catch(SQLException e)
    		{
    			e.printStackTrace();
    		}


        }
    }
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignupForm().setVisible(true);
            }
        });
    }

    private JLabel adminIDLabel;
    private JSeparator adminIDSeparator;
    private JTextField adminIdTextField;
    private JButton closeButton;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JTextField jTextField1;
    private JButton minimizeButton;
    private JPasswordField passwordField;
    private JLabel passwordLabel;
    private JSeparator passwordSeparator;
    private JLabel showValidationOfPassword;
    private JLabel showValidationOfadminId;
    private JLabel signInFormLabel;
    private JCheckBox showpass;
    private JButton signupButton;
}
