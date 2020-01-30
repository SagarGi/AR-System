package com.gces.minor_project_i;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.table.JTableHeader;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pravinewa
 */
public class adminPanel extends javax.swing.JFrame {
	static String LoginID,dateTimeStamp;
    /**
     * Creates new form adminPanel
     */
    public adminPanel() {
    	this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("jarIcon.png")));
    	
    	//initComponents();
          this.addWindowFocusListener(new WindowAdapter() {
            public void windowGainedFocus(WindowEvent e ){
            refresh();

            }
        });
        
    }
        private void close()
    {
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
       public void tableModify()
            {
                 JTableHeader header = table.getTableHeader();
                 header.setForeground(new Color(44,102,76));
                 jScrollPane2.getViewport().setBackground(Color.WHITE);
                 table.setRowHeight(40);
                 table.getTableHeader().setFont( new Font( "Arial" , Font.BOLD, 15 ));
                
                table.getColumnModel().getColumn(0).setPreferredWidth(80);
                

                table.getColumnModel().getColumn(1).setPreferredWidth(120);
                table.getColumnModel().getColumn(2).setPreferredWidth(120);

                table.getColumnModel().getColumn(3).setPreferredWidth(100);
               
            }
        public ArrayList<Staff>staffDetail()
    {
        ArrayList<Staff>staffDetail=new ArrayList<>();
        
          try
        {
            Connection conn;
            Statement stmt;
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/workerdetails","root","");
            stmt=conn.createStatement();
            String sql="SELECT id,workername,gender,address,contactnumber,shift FROM workdet WHERE idcategory ='staff'";
            ResultSet rs=stmt.executeQuery(sql);
                                   // JOptionPane.showMessageDialog(this, "Please!!", "Error", JOptionPane.ERROR_MESSAGE);
            while(rs.next())
            {
              Staff s= new Staff(rs.getString("id"),rs.getString("workername"),rs.getString("address"),rs.getString("contactnumber"),rs.getString("gender"),rs.getString("shift"));
              staffDetail.add(s);
            }
    }
           catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,e, "Error", JOptionPane.ERROR_MESSAGE);

        }
          return staffDetail;
    }
    public void showDetail()
    {
        ArrayList<Staff> list=staffDetail();
        DefaultTableModel model=(DefaultTableModel)table.getModel();
        Object[] row= new Object[6];
        for(int i=0;i<list.size();i++)
        {
            row[0]=list.get(i).getstaffid1();
            row[1]=list.get(i).getusername1();
            row[2]=list.get(i).getcontactno1();           
            row[3]=list.get(i).getaddress1();
            row[4]=list.get(i).getgender1();
            row[5]=list.get(i).getshift1();

            
            model.addRow(row);
        }
    }
     public void refresh()
    {
         DefaultTableModel model=(DefaultTableModel)table.getModel();
         model.setRowCount(0);
         showDetail();
    }
  
                       
    public void initComponents(String LoginID1, String date) {
    	LoginID = LoginID1;
    	dateTimeStamp = date;
    		
        admnpanel = new javax.swing.JPanel();
        photoLabel = new javax.swing.JLabel();
        staffIdLabel = new javax.swing.JLabel();
        loggedInTime = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        staffLabel = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        deletestaff = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        CloseButton = new javax.swing.JButton();
        IDLabel = new javax.swing.JLabel();
        RegisterPhotoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        admnpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        photoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/user2.png"))); // NOI18N
        admnpanel.add(photoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));
        //--------------------------------------------------------------------------//
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setBackground(new Color(0,0,0,0));
        admnpanel.setBackground(new Color(0,0,0,0));
        setVisible(true);
        ///--------------------------------------------------------------------------//
        staffIdLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        staffIdLabel.setForeground(new java.awt.Color(255, 255, 255));
        staffIdLabel.setText("Admin ID : ");
        admnpanel.add(staffIdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));

        loggedInTime.setForeground(new java.awt.Color(255, 255, 255));
        loggedInTime.setText("Logged in user at : "+dateTimeStamp);
        admnpanel.add(loggedInTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 160, -1));

        table.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "StaffID", "Staff Name", "Contact ", "Address", "Gender", "Shift"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(22);
        jScrollPane2.setViewportView(table);

        admnpanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 700, 520));

        staffLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        staffLabel.setForeground(new java.awt.Color(255, 255, 255));
        staffLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        staffLabel.setText("Staff Details:");
        admnpanel.add(staffLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, -1, -1));

        add.setBackground(new java.awt.Color(255, 255, 255));
        add.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        add.setText("Add Staff");
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addMouseExited(evt);
            }
        });
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        admnpanel.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 130, -1));

        deletestaff.setBackground(new java.awt.Color(255, 255, 255));
        deletestaff.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        deletestaff.setText("Delete Staff");
        deletestaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deletestaffMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deletestaffMouseExited(evt);
            }
        });
        deletestaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletestaffActionPerformed(evt);
            }
        });
        admnpanel.add(deletestaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, 130, -1));

        logout.setBackground(new java.awt.Color(255, 255, 255));
        logout.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        logout.setText("Logout");
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutMouseExited(evt);
            }
        });
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        admnpanel.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, 130, -1));

        CloseButton.setBackground(new java.awt.Color(81, 144, 216));
        CloseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/closeicon.png"))); // NOI18N
        CloseButton.setBorder(null);
        CloseButton.setBorderPainted(false);
        CloseButton.setContentAreaFilled(false);
        CloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseButtonActionPerformed(evt);
            }
        });
        admnpanel.add(CloseButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 30, -1, -1));

        IDLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        IDLabel.setForeground(new java.awt.Color(255, 255, 255));
        IDLabel.setText(LoginID);
        admnpanel.add(IDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        RegisterPhotoLabel.setBackground(new java.awt.Color(255, 255, 255));
        RegisterPhotoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/adminpanel.png"))); // NOI18N
        admnpanel.add(RegisterPhotoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 670));

        getContentPane().add(admnpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 710));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void CloseButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        close();
    }                                           

    private void addActionPerformed(java.awt.event.ActionEvent evt) {                                    
           
        staffadd dialog = new staffadd(new javax.swing.JFrame(), true);
        dialog.setDefaultCloseOperation(staffadd.DISPOSE_ON_CLOSE);
        dialog.setModal(true);
        dialog.setVisible(true);
            
    }                                   

    private void deletestaffActionPerformed(java.awt.event.ActionEvent evt) {                                            
       try
       {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/workerdetails","root","");
            Statement stmt = conn.createStatement();

            int row= table.getSelectedRow();
            String value=(table.getModel().getValueAt(row, 0).toString());
                      

            int p=JOptionPane.showConfirmDialog(null,"Are You sure You want to Delete?","Delete",JOptionPane.YES_NO_OPTION);
            if(p==0)
            {
                 String delquery="DELETE FROM workdet WHERE id='"+value+"'";
                 stmt.executeUpdate(delquery);
                 refresh();
            }
 
       }
       catch(Exception e)
       {
        JOptionPane.showMessageDialog(this, "'Please Select The Staff You Want to Delete From the Table!!!'", "Error", JOptionPane.ERROR_MESSAGE);
           
       }

    }                                           

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {                                       
    	int logout1 = JOptionPane.showConfirmDialog(null,"Do you really want to Log Out?","Logout Confirmation",JOptionPane.YES_NO_OPTION);
        if(logout1 == 0)
        {
        WorkerLogin sl = new WorkerLogin();
        sl.setVisible(true);
        close();
        }
    }                                      

    private void addMouseEntered(java.awt.event.MouseEvent evt) {                                 
        add.setBackground(new java.awt.Color(13, 76, 51));
        add.setForeground(new java.awt.Color(255, 255, 255));
        
    }                                

    private void addMouseExited(java.awt.event.MouseEvent evt) {                                
        add.setBackground(new java.awt.Color(255, 255, 255));
        add.setForeground(new java.awt.Color(0, 0, 0));
        
    }                               

    private void deletestaffMouseEntered(java.awt.event.MouseEvent evt) {                                         
        deletestaff.setBackground(new java.awt.Color(13, 76, 51));
        deletestaff.setForeground(new java.awt.Color(255, 255, 255));
        
    }                                        

    private void deletestaffMouseExited(java.awt.event.MouseEvent evt) {                                        
        deletestaff.setBackground(new java.awt.Color(255, 255, 255));
        deletestaff.setForeground(new java.awt.Color(0, 0, 0));
        
    }                                       

    private void logoutMouseEntered(java.awt.event.MouseEvent evt) {                                    
        logout.setBackground(new java.awt.Color(13, 76, 51));
        logout.setForeground(new java.awt.Color(255, 255, 255));
        
    }                                   

    private void logoutMouseExited(java.awt.event.MouseEvent evt) {                                   
        logout.setBackground(new java.awt.Color(255, 255, 255));
        logout.setForeground(new java.awt.Color(0, 0, 0));
        
    }                                  

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(adminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton CloseButton;
    private javax.swing.JLabel IDLabel;
    private javax.swing.JLabel RegisterPhotoLabel;
    private javax.swing.JButton add;
    private javax.swing.JButton deletestaff;
    private javax.swing.JPanel admnpanel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel loggedInTime;
    private javax.swing.JButton logout;
    private javax.swing.JLabel photoLabel;
    private javax.swing.JLabel staffIdLabel;
    private javax.swing.JLabel staffLabel;
    private javax.swing.JTable table;
    // End of variables declaration                   
}
