/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminpanel;

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
public class adminPanell extends javax.swing.JFrame {

    /**
     * Creates new form adminPanell
     */
    public adminPanell() {
        initComponents();
        tableModify();
          this.addWindowFocusListener(new WindowAdapter() {
            public void windowGainedFocus(WindowEvent e ){
            refresh();

            }
        });
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setBackground(new Color(0,0,0,0));
        jPanel1.setBackground(new Color(0,0,0,0));
    }

    /**
     *
     */
   
        private void close()
    {
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
       public void tableModify()
            {
                 JTableHeader header = table.getTableHeader();
                 header.setForeground(new Color(13,76,51));
                 jScrollPane2.getViewport().setBackground(Color.WHITE);
                 table.setRowHeight(40);
                 table.getTableHeader().setFont( new Font( "Arial" , Font.BOLD, 15 ));
                
                table.getColumnModel().getColumn(0).setPreferredWidth(80);
                

                table.getColumnModel().getColumn(1).setPreferredWidth(120);
                table.getColumnModel().getColumn(2).setPreferredWidth(120);

                table.getColumnModel().getColumn(3).setPreferredWidth(100);
                 table.setBackground(Color.white);
               
                
               
               
                       
            }
        public ArrayList<Staff>staffDetail()
    {
        ArrayList<Staff>staffDetail=new ArrayList<>();
        
          try
        {
            Connection conn;
            Statement stmt;


            Class.forName("com.mysql.jdbc.Driver");

            String url="jdbc:mysql://localhost/staffdetails";

            conn=DriverManager.getConnection(url,"root","");



            stmt=conn.createStatement();

            String sql="SELECT staffid,staffname,gender,address,contactnumber,shift FROM staffdet";

            ResultSet rs=stmt.executeQuery(sql);
                                   // JOptionPane.showMessageDialog(this, "Please!!", "Error", JOptionPane.ERROR_MESSAGE);

            

            while(rs.next())
            {
              Staff s= new Staff(rs.getString("staffid"),rs.getString("staffname"),rs.getString("address"),rs.getString("contactnumber"),rs.getString("gender"),rs.getString("shift"));
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
        ArrayList<adminpanel.Staff> list=staffDetail();
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
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        photoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminpanel/icons/user2.png"))); // NOI18N
        jPanel1.add(photoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        staffIdLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        staffIdLabel.setForeground(new java.awt.Color(255, 255, 255));
        staffIdLabel.setText("Admin ID : ");
        jPanel1.add(staffIdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));

        loggedInTime.setForeground(new java.awt.Color(255, 255, 255));
        loggedInTime.setText("Logged in user at :");
        jPanel1.add(loggedInTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 160, -1));

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
        table.setOpaque(false);
        table.setRowHeight(30);
        jScrollPane2.setViewportView(table);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 740, 540));

        staffLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        staffLabel.setForeground(new java.awt.Color(255, 255, 255));
        staffLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        staffLabel.setText("Staff Details:");
        jPanel1.add(staffLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 300, 40));

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
        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 130, -1));

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
        jPanel1.add(deletestaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, 130, -1));

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
        jPanel1.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, 130, -1));

        CloseButton.setBackground(new java.awt.Color(81, 144, 216));
        CloseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminpanel/icons/closeicon.png"))); // NOI18N
        CloseButton.setBorder(null);
        CloseButton.setBorderPainted(false);
        CloseButton.setContentAreaFilled(false);
        CloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseButtonActionPerformed(evt);
            }
        });
        jPanel1.add(CloseButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 30, -1, -1));

        IDLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        IDLabel.setForeground(new java.awt.Color(255, 255, 255));
        IDLabel.setText("Null");
        jPanel1.add(IDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        RegisterPhotoLabel.setBackground(new java.awt.Color(255, 255, 255));
        RegisterPhotoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminpanel/icons/adminpanel.png"))); // NOI18N
        jPanel1.add(RegisterPhotoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 670));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 710));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseButtonActionPerformed
        close();
    }//GEN-LAST:event_CloseButtonActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
           
       staffadd dialog = new staffadd(new javax.swing.JFrame(), true);
             
        dialog.setDefaultCloseOperation(staffadd.DISPOSE_ON_CLOSE);
        dialog.setModal(true);
        dialog.setVisible(true);
            
    }//GEN-LAST:event_addActionPerformed

    private void deletestaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletestaffActionPerformed
       try
       {
            Connection conn = null;


            Class.forName("com.mysql.jdbc.Driver");

            String url="jdbc:mysql://localhost/staffdetails";
            conn=DriverManager.getConnection(url,"root","");
            Statement stmt = conn.createStatement();

            int row= table.getSelectedRow();
            String value=(table.getModel().getValueAt(row, 0).toString());
                      

            int p=JOptionPane.showConfirmDialog(null,"Are You sure You want to Delete?","Delete",JOptionPane.YES_NO_OPTION);
            if(p==0)
            {
                 String delquery="DELETE FROM staffdet  WHERE  staffid='"+value+"'";
                 stmt.executeUpdate(delquery);
                 refresh();
            }
 
       }
       catch(Exception e)
       {
        JOptionPane.showMessageDialog(this, "'Please Select The Staff You Want to Delete From the Table!!!'", "Error", JOptionPane.ERROR_MESSAGE);
           
       }

    }//GEN-LAST:event_deletestaffActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logoutActionPerformed

    private void addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseEntered
        add.setBackground(new java.awt.Color(13, 76, 51));
        add.setForeground(new java.awt.Color(255, 255, 255));
        
    }//GEN-LAST:event_addMouseEntered

    private void addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseExited
        add.setBackground(new java.awt.Color(255, 255, 255));
        add.setForeground(new java.awt.Color(0, 0, 0));
        
    }//GEN-LAST:event_addMouseExited

    private void deletestaffMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletestaffMouseEntered
        deletestaff.setBackground(new java.awt.Color(13, 76, 51));
        deletestaff.setForeground(new java.awt.Color(255, 255, 255));
        
    }//GEN-LAST:event_deletestaffMouseEntered

    private void deletestaffMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletestaffMouseExited
        deletestaff.setBackground(new java.awt.Color(255, 255, 255));
        deletestaff.setForeground(new java.awt.Color(0, 0, 0));
        
    }//GEN-LAST:event_deletestaffMouseExited

    private void logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseEntered
        logout.setBackground(new java.awt.Color(13, 76, 51));
        logout.setForeground(new java.awt.Color(255, 255, 255));
        
    }//GEN-LAST:event_logoutMouseEntered

    private void logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseExited
        logout.setBackground(new java.awt.Color(255, 255, 255));
        logout.setForeground(new java.awt.Color(0, 0, 0));
        
    }//GEN-LAST:event_logoutMouseExited

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
            java.util.logging.Logger.getLogger(adminPanell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminPanell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminPanell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminPanell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminPanell().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CloseButton;
    private javax.swing.JLabel IDLabel;
    private javax.swing.JLabel RegisterPhotoLabel;
    private javax.swing.JButton add;
    private javax.swing.JButton deletestaff;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel loggedInTime;
    private javax.swing.JButton logout;
    private javax.swing.JLabel photoLabel;
    private javax.swing.JLabel staffIdLabel;
    private javax.swing.JLabel staffLabel;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
