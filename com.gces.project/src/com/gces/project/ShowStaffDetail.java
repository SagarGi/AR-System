package com.gces.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

public class ShowStaffDetail extends JDialog {
	static String LoginID;

	public ShowStaffDetail(java.awt.Frame parent, boolean modal) {
    	
        super(parent, modal);
    }

    public void initComponents(String LoginID1) {

    	LoginID = LoginID1;
    	
        jPanel1 = new JPanel();
        staffNameLabel = new JLabel();
        genderLabel = new JLabel();
        addressLabel = new JLabel();
        contactNumberLabel = new JLabel();
        emailIDLabel = new JLabel();
        iRDLabel = new JLabel();
        shiftLabel = new JLabel();
        showStaffNameLabel = new JLabel();
        staffIdLabel = new JLabel();
        showGenderLabel = new JLabel();
        showAddressLabel = new JLabel();
        showContactNumberLabel = new JLabel();
        showEmailIDLabel = new JLabel();
        showIRDLabel = new JLabel();
        showShiftLabel = new JLabel();
        showStaffIDLabel = new JLabel();
        titleSeparator = new JSeparator();
        titleLabel = new JLabel();
        backButton = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setOpacity(0.9F);
        setPreferredSize(new java.awt.Dimension(440, 580));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(1, 50, 67));
        jPanel1.setPreferredSize(new java.awt.Dimension(440, 580));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        staffNameLabel.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        staffNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        staffNameLabel.setText("Staff Name : ");
        jPanel1.add(staffNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 110, 20));

        genderLabel.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        genderLabel.setForeground(new java.awt.Color(255, 255, 255));
        genderLabel.setText("Gender : ");
        jPanel1.add(genderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 80, 20));

        addressLabel.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        addressLabel.setForeground(new java.awt.Color(255, 255, 255));
        addressLabel.setText("Address :");
        jPanel1.add(addressLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 80, 20));

        contactNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        contactNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        contactNumberLabel.setText("Contact Number :");
        jPanel1.add(contactNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 140, 20));

        emailIDLabel.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        emailIDLabel.setForeground(new java.awt.Color(255, 255, 255));
        emailIDLabel.setText("Email ID : ");
        jPanel1.add(emailIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 80, 20));

        iRDLabel.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        iRDLabel.setForeground(new java.awt.Color(255, 255, 255));
        iRDLabel.setText("ID Registered Date : ");
        jPanel1.add(iRDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 160, 20));

        shiftLabel.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        shiftLabel.setForeground(new java.awt.Color(255, 255, 255));
        shiftLabel.setText("Shift : ");
        jPanel1.add(shiftLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 80, 20));

        showStaffNameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        showStaffNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        showStaffNameLabel.setText("NULL");
        jPanel1.add(showStaffNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 210, 20));

        staffIdLabel.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        staffIdLabel.setForeground(new java.awt.Color(255, 255, 255));
        staffIdLabel.setText("Staff ID : ");
        jPanel1.add(staffIdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 80, 20));

        showGenderLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        showGenderLabel.setForeground(new java.awt.Color(255, 255, 255));
        showGenderLabel.setText("NULL");
        jPanel1.add(showGenderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 210, 20));

        showAddressLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        showAddressLabel.setForeground(new java.awt.Color(255, 255, 255));
        showAddressLabel.setText("NULL");
        jPanel1.add(showAddressLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 210, 20));

        showContactNumberLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        showContactNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        showContactNumberLabel.setText("NULL");
        jPanel1.add(showContactNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 210, 20));

        showEmailIDLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        showEmailIDLabel.setForeground(new java.awt.Color(255, 255, 255));
        showEmailIDLabel.setText("NULL");
        jPanel1.add(showEmailIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 210, 20));

        showIRDLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        showIRDLabel.setForeground(new java.awt.Color(255, 255, 255));
        showIRDLabel.setText("NULL");
        jPanel1.add(showIRDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 210, 20));

        showShiftLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        showShiftLabel.setForeground(new java.awt.Color(255, 255, 255));
        showShiftLabel.setText("NULL");
        jPanel1.add(showShiftLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, 210, 20));

        showStaffIDLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        showStaffIDLabel.setForeground(new java.awt.Color(255, 255, 255));
        showStaffIDLabel.setText("NULL");
        jPanel1.add(showStaffIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 210, 20));
        jPanel1.add(titleSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 400, 10));

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setText("Staff Details");
        jPanel1.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 120, -1));

        backButton.setBackground(new java.awt.Color(255, 255, 255));
        backButton.setText("Back");
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false);
        backButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jPanel1.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 500, 80, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 580));

        pack();
        setLocationRelativeTo(null);
        //database connection to show details
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/workerdetails","root","");
            String sql = "SELECT id, workername, gender, address, contactnumber, emailid, idregistereddate, shift FROM workdet WHERE id='"+LoginID+"'";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                 showStaffIDLabel.setText(rs.getString("id"));
                 showStaffNameLabel.setText(rs.getString("workername"));
                 showGenderLabel.setText(rs.getString("gender"));
                 showAddressLabel.setText(rs.getString("address"));
                 showContactNumberLabel.setText(rs.getString("contactnumber"));
                 showEmailIDLabel.setText(rs.getString("emailid"));
                 showIRDLabel.setText(rs.getString("idregistereddate"));
                 showShiftLabel.setText(rs.getString("shift"));
            }
            rs.close();
            pstmt.close();
            conn.close();
            
        }catch(Exception e)
        {
        	JOptionPane.showMessageDialog(null,e);
        }
        
        setVisible(true);
    
    }                     

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        this.dispose();
    }                                          

    public static void main(String args[]) {

    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ShowStaffDetail dialog = new ShowStaffDetail(new JFrame(), true);
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

    private JLabel addressLabel;
    private JButton backButton;
    private JLabel contactNumberLabel;
    private JLabel emailIDLabel;
    private JLabel genderLabel;
    private JLabel iRDLabel;
    private JPanel jPanel1;
    private JLabel shiftLabel;
    private JLabel showAddressLabel;
    private JLabel showContactNumberLabel;
    private JLabel showEmailIDLabel;
    private JLabel showGenderLabel;
    private JLabel showIRDLabel;
    private JLabel showShiftLabel;
    private JLabel showStaffIDLabel;
    private JLabel showStaffNameLabel;
    private JLabel staffIdLabel;
    private JLabel staffNameLabel;
    private JLabel titleLabel;
    private JSeparator titleSeparator;
}
