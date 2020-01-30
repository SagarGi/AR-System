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
import javax.swing.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
/**
 *
 * @author pravinewa
 */
public class LoginForm extends JFrame {
    static int photoChange = 0;
    static String categ = "staff";
    static int sidebar = 0;
    static int mousepX, mousepY; 
    static int ivalid = 0, pvalid = 0;
    static int status = 0, pstatus = 0;

    public LoginForm() {
    	this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("jarIcon.png")));
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
			return hexString;
		} catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		return hexString;
	}

    private void initComponents() {
    	categ = "staff";
    	
    	jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jPanel2 = new JPanel();
        jTextField1 = new JTextField();
        closeButton = new JButton();
        minimizeButton = new JButton();
        userIDLabel = new JLabel();
        userIdTextField = new JTextField();
        userIDSeparator = new JSeparator();
        showValidationOfUserID = new JLabel();
        passwordLabel = new JLabel();
        passwordField = new JPasswordField();
        passwordSeparator = new JSeparator();
        showValidationOfPassword = new JLabel();
        loginButton = new JButton();
        showpass = new JCheckBox();
        signInFormLabel = new JLabel();
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setOpacity(0.96F);
        setPreferredSize(new java.awt.Dimension(400, 550));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(1, 50, 67));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        //to avoid starting focus on id textfield
        jTextField1.setBackground(new java.awt.Color(1, 50, 67));
        jTextField1.setBorder(null);
        jTextField1.setForeground(new java.awt.Color(1, 50, 67));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/com/gces/project/icons/staffpic.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
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
        signInFormLabel.setText("Sign in Form");
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

        userIDLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        userIDLabel.setForeground(new java.awt.Color(255, 255, 255));
        userIDLabel.setText("Staff ID");
        jPanel1.add(userIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, -1, -1));

        userIdTextField.setBackground(new java.awt.Color(1, 50, 67));
        userIdTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        userIdTextField.setForeground(new java.awt.Color(255, 255, 255));
        userIdTextField.setText("Enter Staff ID");
        userIdTextField.setBorder(null);


        userIdTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                userIdTextFieldKeyReleased(evt);
            }
        });
        jPanel1.add(userIdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 240, 20));
        jPanel1.add(userIDSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 240, 10));

        showValidationOfUserID.setBackground(new java.awt.Color(55, 27, 65));
        showValidationOfUserID.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(showValidationOfUserID, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 240, -1));

        passwordLabel.setBackground(new java.awt.Color(55, 27, 65));
        passwordLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(255, 255, 255));
        passwordLabel.setText("Password");
        jPanel1.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, -1, -1));

        passwordField.setBackground(new java.awt.Color(1, 50, 67));
        passwordField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passwordField.setForeground(new java.awt.Color(255, 255, 255));
        passwordField.setText("EnterPassword");
        passwordField.setBorder(null);
        passwordField.setPreferredSize(new java.awt.Dimension(76, 15));

        passwordField.getDocument().addDocumentListener(new DocumentListener()
        {
           @Override
            public void insertUpdate(DocumentEvent e) {
               pstatus++;
             //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFieldFocusGained(evt,pstatus);
            }
        });
        
        userIdTextField.getDocument().addDocumentListener(new DocumentListener()
        {
           @Override
            public void insertUpdate(DocumentEvent e) {
               status++;
             //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        userIdTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userIdTextFieldFocusGained(evt,status);
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

        loginButton.setBackground(new java.awt.Color(255, 255, 255));
        loginButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        loginButton.setText("Login");
        loginButton.setFocusPainted(false);
        loginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginButton.setHorizontalTextPosition(SwingConstants.LEFT);
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        loginButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginButtonKeyPressed(evt);
            }
        });
        
        jPanel1.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 470, 70, 30));

        showpass.setBackground(new java.awt.Color(1, 50, 67));
        showpass.setForeground(new java.awt.Color(255, 255, 255));
        showpass.setText("Show Password");
        showpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showpassActionPerformed(evt);
            }
        });
        jPanel1.add(showpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 430, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 550));

        pack();
        setLocationRelativeTo(null);
    }                   



    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        int ievalid = 0, pevalid = 0;

        String LoginID = userIdTextField.getText();
        String Password = passwordField.getText();
        StringBuffer sb = new StringBuffer(shaFunction(Password));
        String pass = new String(sb);
        if(LoginID.equals(""))
        {
            showValidationOfUserID.setText("ID field cannot be Empty");
            ievalid = 1;
        }

        if(Password.equals(""))
        {
            showValidationOfPassword.setText("Password field cannot be Empty");
            pevalid = 1;
        }
        if(ievalid != 1 && pevalid != 1)
        {
            System.out.println(categ);
            if(categ == "admin")
            {
            try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/workerdetails","root","");
            String sql="SELECT id,password FROM workdet WHERE idcategory='admin'";
    	    PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs= pstmt.executeQuery();
    	    boolean exist=false;
            
                if(ivalid == 1 && pvalid == 1)
                {    
        	while(rs.next() && exist == false)
        	{
        		String id=rs.getString("id");
        		String pw=rs.getString("password");
                if(id.equals(LoginID) && pw.equals(pass))
        		{
        			String dateTimeStamp = new SimpleDateFormat("hh:mm a").format(new java.util.Date());
                                exist=true;
                                System.out.println("asdasd");
                                AdminPanel ap = new AdminPanel();
                                ap.initComponents(LoginID, dateTimeStamp);
                                close();
                                status = 0;
                                pstatus = 0;
                                
        		}
                        else{
                            exist=false;
                        }
                }
        	if(exist == false)
        	{
                    PassAdminWrongDialog dialog = new PassAdminWrongDialog(new JFrame(), true);
                        dialog.setVisible(true);
        	}
        }else
            {
                        PassAdminWrongDialog dialog = new PassAdminWrongDialog(new JFrame(), true);
                        dialog.setVisible(true);
            }

        }
            catch(SQLException se)
            {
    				DatabaseConnDialog dialog = new DatabaseConnDialog(new JFrame(), true);
    				dialog.setVisible(true);
            }
             catch(Exception e)
        {
            System.out.println(e);
        }
            }//end of admin
 
        if(categ == "staff")
            {
                try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/workerdetails","root","");
            String sql="SELECT id,password FROM workdet WHERE idcategory='staff'";
    	    PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs= pstmt.executeQuery();
    	    boolean exist=false;
            
                if(ivalid == 1 && pvalid == 1)
                {    
        	while(rs.next() && exist == false)
        	{
        		String id=rs.getString("id");
        		String pw=rs.getString("password");
                	if(id.equals(LoginID) && pw.equals(pass))
        		{
                				String dateTimeStamp = new SimpleDateFormat("hh:mm a").format(new java.util.Date());
                                exist=true;
                                System.out.println("asdasdasdasd");
                                OpenPanel op = new OpenPanel();
                                //op.setVisible(true);
                                op.initComponents(LoginID, dateTimeStamp);
                                close();
                                status = 0;
                                pstatus = 0;
                                
        		}
                        else{
                            exist=false;
                        }
                }
        	if(exist == false)
        	{
                    PassStaffWrongDialog dialog = new PassStaffWrongDialog(new JFrame(), true);
                    dialog.setVisible(true);
        	}
        }else
            {
                    PassStaffWrongDialog dialog = new PassStaffWrongDialog(new JFrame(), true);
                    dialog.setVisible(true);
            }

        }catch(SQLException se)
                {
        				DatabaseConnDialog dialog = new DatabaseConnDialog(new JFrame(), true);
        				dialog.setVisible(true);
                }
         catch(Exception e)
        {
             System.out.println(e);        }
        }//end of if staff
        }else{
            if(categ == "admin")
            {
                            showValidationOfUserID.setText("Admin ID field cannot be Empty");
            }else
            {
                            showValidationOfUserID.setText("Staff ID field cannot be Empty");
                
            }
            EmptyDialog dialog = new EmptyDialog(new JFrame(), true);
                        dialog.setVisible(true);
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

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        switch(photoChange)
        {
            case 0:
            {
                jLabel1.setIcon(new ImageIcon(getClass().getResource("/com/gces/project/icons/adminpic.png")));
                categ = "admin";
                userIDLabel.setText("Admin ID");
                userIdTextField.setText("Enter Admin ID");
                passwordField.setText("Enter Password");
                System.out.println(categ);
                photoChange = 1;
                pstatus = 0;
                status = 0;
                   break;
            }
            case 1:
            {
                jLabel1.setIcon(new ImageIcon(getClass().getResource("/com/gces/project/icons/staffpic.png")));
                categ = "staff";
                userIDLabel.setText("Staff ID");
                userIdTextField.setText("Enter Staff ID");
                passwordField.setText("Enter Password");
                System.out.println(categ);
                photoChange = 0;
                pstatus = 0;
                status = 0;
                
                break;
                
            }
        }
                
    }                                    


    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        close();
    }                                           

    private void minimizeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        this.setState(LoginForm.ICONIFIED);
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

    private void userIdTextFieldFocusGained(java.awt.event.FocusEvent evt, int status) {                                            
        if(status==0)
        userIdTextField.setText("");
    }                                           

    private void userIdTextFieldKeyReleased(java.awt.event.KeyEvent evt) {                                            
        String PATTERN = "^[a-z]{0,4}[0-9]{0,4}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(userIdTextField.getText());
        if(!match.matches())
        {
            showValidationOfUserID.setText("Given ID is Incorrect");
            userIdTextField.setForeground(Color.red);
            ivalid = 0;
        }
        if(userIdTextField.getText().equals(""))
        {
            showValidationOfUserID.setText("ID field cannot be Empty");
            userIdTextField.setForeground(Color.white);
            ivalid = 0;
        }
        if(match.matches())
        {
            showValidationOfUserID.setText(null);
            userIdTextField.setForeground(Color.white);
            ivalid = 1;
        }
    }                                           

    private void passwordFieldFocusGained(java.awt.event.FocusEvent evt, int pstatus) {                                          
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
    
    private void loginButtonKeyPressed(java.awt.event.KeyEvent evt) {                                       
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int ievalid = 0, pevalid = 0;

            String LoginID = userIdTextField.getText();
            String Password = passwordField.getText();
            StringBuffer sb = new StringBuffer(shaFunction(Password));
            String pass = new String(sb);
            if(LoginID.equals(""))
            {
                showValidationOfUserID.setText("ID field cannot be Empty");
                ievalid = 1;
            }

            if(Password.equals(""))
            {
                showValidationOfPassword.setText("Password field cannot be Empty");
                pevalid = 1;
            }
            if(ievalid != 1 && pevalid != 1)
            {
                System.out.println(categ);
                if(categ == "admin")
                {
                try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/workerdetails","root","");
                String sql="SELECT id,password FROM workdet WHERE idcategory='admin'";
        	    PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs= pstmt.executeQuery();
        	    boolean exist=false;
                
                    if(ivalid == 1 && pvalid == 1)
                    {    
            	while(rs.next() && exist == false)
            	{
            		String id=rs.getString("id");
            		String pw=rs.getString("password");
                    if(id.equals(LoginID) && pw.equals(pass))
            		{
            			String dateTimeStamp = new SimpleDateFormat("hh:mm a").format(new java.util.Date());
                                    exist=true;
                                    System.out.println("asdasd");
                                    AdminPanel ap = new AdminPanel();
                                    ap.initComponents(LoginID, dateTimeStamp);
                                    close();
                                    status = 0;
                                    pstatus = 0;
                                    
            		}
                            else{
                                exist=false;
                            }
                    }
            	if(exist == false)
            	{
                        PassAdminWrongDialog dialog = new PassAdminWrongDialog(new JFrame(), true);
                            dialog.setVisible(true);
            	}
            }else
                {
                            PassAdminWrongDialog dialog = new PassAdminWrongDialog(new JFrame(), true);
                            dialog.setVisible(true);
                }

            }
                catch(SQLException se)
                {
        				DatabaseConnDialog dialog = new DatabaseConnDialog(new JFrame(), true);
        				dialog.setVisible(true);
                }
                 catch(Exception e)
            {
                System.out.println(e);
            }
                }//end of admin
     
            if(categ == "staff")
                {
                    try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/workerdetails","root","");
                String sql="SELECT id,password FROM workdet WHERE idcategory='staff'";
        	    PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs= pstmt.executeQuery();
        	    boolean exist=false;
                
                    if(ivalid == 1 && pvalid == 1)
                    {    
            	while(rs.next() && exist == false)
            	{
            		String id=rs.getString("id");
            		String pw=rs.getString("password");
                    	if(id.equals(LoginID) && pw.equals(pass))
            		{
                    				String dateTimeStamp = new SimpleDateFormat("hh:mm a").format(new java.util.Date());
                                    exist=true;
                                    System.out.println("asdasdasdasd");
                                    OpenPanel op = new OpenPanel();
                                    //op.setVisible(true);
                                    op.initComponents(LoginID, dateTimeStamp);
                                    close();
                                    status = 0;
                                    pstatus = 0;
                                    
            		}
                            else{
                                exist=false;
                            }
                    }
            	if(exist == false)
            	{
                        PassStaffWrongDialog dialog = new PassStaffWrongDialog(new JFrame(), true);
                        dialog.setVisible(true);
            	}
            }else
                {
                        PassStaffWrongDialog dialog = new PassStaffWrongDialog(new JFrame(), true);
                        dialog.setVisible(true);
                }

            }catch(SQLException se)
                    {
            				DatabaseConnDialog dialog = new DatabaseConnDialog(new JFrame(), true);
            				dialog.setVisible(true);
                    }
             catch(Exception e)
            {
                 System.out.println(e);        }
            }//end of if staff
            }else{
                if(categ == "admin")
                {
                                showValidationOfUserID.setText("Admin ID field cannot be Empty");
                }else
                {
                                showValidationOfUserID.setText("Staff ID field cannot be Empty");
                    
                }
                EmptyDialog dialog = new EmptyDialog(new JFrame(), true);
                            dialog.setVisible(true);
            }
            
        }
    }     

    public static void main(String args[]) {
        
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    private JButton closeButton;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JTextField jTextField1;
    private JButton loginButton;
    private JButton minimizeButton;
    private JPasswordField passwordField;
    private JLabel passwordLabel;
    private JSeparator passwordSeparator;
    private JLabel showValidationOfPassword;
    private JLabel showValidationOfUserID;
    private JCheckBox showpass;
    private JLabel signInFormLabel;
    private JLabel userIDLabel;
    private JSeparator userIDSeparator;
    private JTextField userIdTextField;
}
