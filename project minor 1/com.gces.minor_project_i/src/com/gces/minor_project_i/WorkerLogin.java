package com.gces.minor_project_i;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.regex.*;
import javax.swing.*;
import javax.swing.event.*;
import java.text.SimpleDateFormat;
import java.nio.charset.StandardCharsets;
import java.security.*;
import javax.swing.ImageIcon;
/**
 *
 * @author pravinewa
 */
public class WorkerLogin extends JFrame {
    static int ivalid = 0, pvalid = 0; //static variable for validation
    static int status=0;
    static int pstatus=0;
    
    public WorkerLogin() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("jarIcon.png")));
    	
        initComponents();
        
        //To make custom close button
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setBackground(new Color(0,0,0,0));
        staffPanel.setBackground(new Color(0,0,0,0));
    }
    //Close method help to close current JFrame while opening another JFrame
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

    	
        staffPanel = new JPanel();
        staffPhotoLabel = new JLabel();
        staffIDLabel = new JLabel();
        staffIdTextField = new JTextField();
        staffIDSeparator = new JSeparator();
        showValidationOfStaffId = new JLabel();
        passwordLabel = new JLabel();
        passwordField = new JPasswordField();
        passwordSeparator = new JSeparator();
        showValidationOfPassword = new JLabel();
        loginButton = new JButton();
        closeButton = new JButton();
        backgroundLabelPhoto = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(750, 620));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        staffPanel.setBackground(new java.awt.Color(255, 255, 255));
        staffPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        staffPhotoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/staff.png"))); // NOI18N
        staffPanel.add(staffPhotoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, -1, -1));

        staffIDLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        staffIDLabel.setForeground(new java.awt.Color(255, 255, 255));
        staffIDLabel.setText("Staff ID");
        staffPanel.add(staffIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, -1, -1));

        staffIdTextField.setBackground(new java.awt.Color(1, 50, 67));
        staffIdTextField.setFont(new java.awt.Font("Tahoma", 0, 12));
        staffIdTextField.setForeground(new java.awt.Color(255, 255, 255));
        staffIdTextField.setText("Enter Your ID");
        staffIdTextField.setBorder(null);
        staffIdTextField.getDocument().addDocumentListener(new DocumentListener()
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
        
        staffIdTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                staffIdTextFieldFocusGained(evt, status);
            }
        });
        staffIdTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                staffIdTextFieldKeyReleased(evt);
            }
        });
        staffPanel.add(staffIdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 240, 20));
        staffPanel.add(staffIDSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 240, 10));

        showValidationOfStaffId.setBackground(new java.awt.Color(55, 27, 65));
        showValidationOfStaffId.setForeground(new java.awt.Color(255, 0, 0));
        staffPanel.add(showValidationOfStaffId, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 240, -1));

        passwordLabel.setBackground(new java.awt.Color(55, 27, 65));
        passwordLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        passwordLabel.setForeground(new java.awt.Color(255, 255, 255));
        passwordLabel.setText("Password");
        staffPanel.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, -1, -1));

        passwordField.setBackground(new java.awt.Color(1, 50, 67));
        passwordField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
                passwordFieldFocusGained(evt, pstatus);
            }
        });
        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwordFieldKeyReleased(evt);
            }
        });
        staffPanel.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, 240, 20));
        staffPanel.add(passwordSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 240, 10));

        showValidationOfPassword.setBackground(new java.awt.Color(55, 27, 65));
        showValidationOfPassword.setForeground(new java.awt.Color(255, 0, 0));
        staffPanel.add(showValidationOfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 240, -1));

        loginButton.setBackground(new java.awt.Color(255, 255, 255));
        loginButton.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        loginButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/lock.png"))); // NOI18N
        loginButton.setText("Login");
        loginButton.setHorizontalTextPosition(SwingConstants.LEFT);
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginButtonMouseExited(evt);
            }
        });
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        staffPanel.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 310, -1, -1));

        closeButton.setBackground(new java.awt.Color(81, 144, 216));
        closeButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/closeicon.png")));
        closeButton.setBorder(null);
        closeButton.setBorderPainted(false);
        closeButton.setContentAreaFilled(false);
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        staffPanel.add(closeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 60, -1, -1));

        backgroundLabelPhoto.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/LoginPanel1.png")));
        staffPanel.add(backgroundLabelPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        getContentPane().add(staffPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 850, 650));

        pack();
        setLocationRelativeTo(null);
        
    	
    }                        
    //-------------------------------------------------------------------------//
    //using some focus event, mouse event 
    private void loginButtonMouseEntered(java.awt.event.MouseEvent evt) {                                         
        loginButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/unlock.png"))); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setBackground(new java.awt.Color(51, 110, 123));
        
    }                                        

    private void loginButtonMouseExited(java.awt.event.MouseEvent evt) {                                        
        loginButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/lock.png"))); // NOI18N
        loginButton.setForeground(new java.awt.Color(0, 0, 0));
        loginButton.setBackground(new java.awt.Color(255, 255, 255));
        
    }                                       

    private void staffIdTextFieldFocusGained(java.awt.event.FocusEvent evt, int status) {                                             
        if(status==0)
            staffIdTextField.setText("");
    
    }                                            

    private void passwordFieldFocusGained(java.awt.event.FocusEvent evt, int pstatus) {                                          
        if(pstatus==0)
            passwordField.setText("");
    }                                         
    //-------------------------------------------------------------------------//
    //Close button help to close JFrame
    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        close();
    }                                           
    //-------------------------------------------------------------------------//
    //check for validation of ID and Password
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
    //-------------------------------------------------------------------------//
    //Login Button action event
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        int ievalid = 0, pevalid = 0;
     
        String LoginID = staffIdTextField.getText();
        StringBuffer Password = shaFunction(passwordField.getText());
            if(LoginID.equals(""))
            {
                showValidationOfStaffId.setText("Staff ID field cannot be Empty");
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
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/workerdetails","root","");
            String sql="SELECT id,password,idcategory FROM workdet";
    	    PreparedStatement pstmt = conn.prepareStatement(sql);
    		ResultSet rs= pstmt.executeQuery();
    	    boolean exist=false;
            String pass = new String(Password);
            
        if(ivalid == 1 && pvalid == 1)
        {    
        	while(rs.next() && exist == false)
        	{
        		String id=rs.getString("id");
        		String pw=rs.getString("password");
        		String cate = rs.getString("idcategory");
        	
        		if(id.equals(LoginID) && pw.equals(pass) && cate.equals("admin"))
        		{
        			//System.out.println("Logged in as Admin");
        			String dateTimeStamp = new SimpleDateFormat("hh:mm a").format(new java.util.Date());
                    status = 0;
                    pstatus = 0;
                    adminPanel ap = new adminPanel();
                    ap.initComponents(LoginID, dateTimeStamp);
                    //SP.setVisible(true);
                    close();
                    exist=true;
        		}
        		else if(id.equals(LoginID) && pw.equals(pass) && cate.equals("staff"))
        		{
        			//System.out.println("Logged in as Staff");
        			String dateTimeStamp = new SimpleDateFormat("hh:mm a").format(new java.util.Date());
                    status = 0;
                    pstatus = 0;
                    StaffPanel SP = new StaffPanel();
                    SP.initComponents(LoginID, dateTimeStamp);
                    //SP.setVisible(true);
                    close();
                    exist=true;
        		}
        		else
        		{
                    exist = false;
        			//System.out.println("ivalid");
        			
        		}
        	}
        	if(exist == false)
        	{
        		JOptionPane.showMessageDialog(null,"Incorrect StaffID and Password","Access Denied",JOptionPane.ERROR_MESSAGE);
                
        	}
        }else
            {
                JOptionPane.showMessageDialog(null,"Invalid StaffID and Password","Access Denied",JOptionPane.ERROR_MESSAGE);
            }

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        
        }else{
            JOptionPane.showMessageDialog(null,"Field cannot be left Empty","Access Denied",JOptionPane.ERROR_MESSAGE);
        }
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
            java.util.logging.Logger.getLogger(WorkerLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WorkerLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WorkerLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WorkerLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WorkerLogin().setVisible(true);
            }
        });
    }

    // Variables declaration          
    private JLabel backgroundLabelPhoto;
    private JButton closeButton;
    private JButton loginButton;
    private JPasswordField passwordField;
    private JLabel passwordLabel;
    private JSeparator passwordSeparator;
    private JLabel showValidationOfPassword;
    private JLabel showValidationOfStaffId;
    private JLabel staffIDLabel;
    private JSeparator staffIDSeparator;
    private JTextField staffIdTextField;
    private JPanel staffPanel;
    private JLabel staffPhotoLabel;
    // End of variables declaration                   
}
