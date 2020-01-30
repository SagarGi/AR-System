package com.gces.minor_project_i;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author pravinewa
 */
public class SearchDetail extends JFrame {
    static String LoginID, dateTimeStamp;
    public SearchDetail() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("jarIcon.png")));
    	
        //initComponents();
        
    }
    private void close()
    {
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    public ArrayList<User> userList()
    {
        ArrayList<User> userList = new ArrayList<User>();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata","root","");
            String query = "SELECT t.vehiclenumber, t.companyname, ti.ownername, t.vehicletype, ti.municipality, ti.registrationdate FROM ownerdetails AS ti, vehicledetails AS t WHERE t.vehiclenumber = ti.vehiclenumb";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            User user;
            while(rs.next())
            {
                user = new User(rs.getString("vehiclenumber"), rs.getString("ownername"), rs.getString("companyname"), rs.getString("vehicletype"), rs.getString("municipality"),  rs.getString("registrationdate"));
                userList.add(user);
                
            }
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        return userList;
    }
    public void show_user()
    {
        ArrayList<User> list = userList();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Vehicle Number", "Company Name", "Owner Name", "Vehicle Type", "Municipality", "Registration Date"});
        Object[] row = new Object[6];
        for(int i = 0; i<list.size();i++)
        {
            row[0] = list.get(i).getvehiclenumber();
            row[1] = list.get(i).getownername();
            row[2] = list.get(i).getcompanyname();
            row[3] = list.get(i).getvehicletype();
            row[4] = list.get(i).getmunicipality();
            row[5] = list.get(i).getregistrationdate();            
            model.addRow(row);
        }
        searchTable.setModel(model);
    }
    
    public ArrayList<User> UserList(String ValToSearch)
    {
        ArrayList<User> UserList = new ArrayList<User>();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata","root","");
            String query = "SELECT t.vehiclenumber, t.companyname, ti.ownername, t.vehicletype, ti.municipality, ti.registrationdate FROM ownerdetails AS ti, vehicledetails AS t WHERE t.vehiclenumber = ti.vehiclenumb AND t.vehiclenumber LIKE '%"+ValToSearch+"%'";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            User user;
            while(rs.next())
            {
                user = new User(rs.getString("vehiclenumber"), rs.getString("ownername"), rs.getString("companyname"), rs.getString("vehicletype"), rs.getString("municipality"),  rs.getString("registrationdate"));
                UserList.add(user);
                
            }
            rs.close();
            stmt.close();
            conn.close();
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        return UserList;
    }
    
    public void search_user()
    {
        ArrayList<User> list = UserList(searchTextField.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Vehicle Number", "Company Name", "Owner Name", "Vehicle Type", "Municipality", "Registration Date"});
        Object[] row = new Object[6];
        for(int i = 0; i<list.size();i++)
        {
            row[0] = list.get(i).getvehiclenumber();
            row[1] = list.get(i).getownername();
            row[2] = list.get(i).getcompanyname();
            row[3] = list.get(i).getvehicletype();
            row[4] = list.get(i).getmunicipality();
            row[5] = list.get(i).getregistrationdate();            
            model.addRow(row);
        }
        searchTable.setModel(model);
    }

    public void initComponents(String LoginID1, String date) {
    	
    	//setIconImage(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/jarIcon.png")).getImage());
    	
    	LoginID = LoginID1;
    	dateTimeStamp = date;
    	
        searchPanel = new JPanel();
        loggedInTime = new JLabel();
        CloseButton = new JButton();
        photoLabel = new JLabel();
        staffIdLabel = new JLabel();
        IDLabel = new JLabel();
        searchTextField = new JTextField();
        searchButton = new JButton();
        searchScrollPane = new JScrollPane();
        searchTable = new JTable();
        homeButton = new JButton();
        logOutButton = new JButton();
        jSeparator1 = new JSeparator();
        RegisterPhotoLabel = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchPanel.setBackground(new java.awt.Color(255, 255, 255));
        searchPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        //---------------------------------------------------------------------//
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setBackground(new Color(0,0,0,0));
        searchPanel.setBackground(new Color(0,0,0,0));
        //---------------------------------------------------------------------//
        loggedInTime.setForeground(new java.awt.Color(255, 255, 255));
        loggedInTime.setText("Logged in at : "+dateTimeStamp);
        searchPanel.add(loggedInTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 160, -1));
        
        CloseButton.setBackground(new java.awt.Color(81, 144, 216));
        CloseButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/closeicon.png"))); 
        CloseButton.setBorder(null);
        CloseButton.setBorderPainted(false);
        CloseButton.setContentAreaFilled(false);
        CloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseButtonActionPerformed(evt);
            }
        });
        searchPanel.add(CloseButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 30, -1, -1));

        photoLabel.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/user2.png"))); // NOI18N
        searchPanel.add(photoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        staffIdLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        staffIdLabel.setForeground(new java.awt.Color(255, 255, 255));
        staffIdLabel.setText("Staff ID : ");
        searchPanel.add(staffIdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));

        IDLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        IDLabel.setForeground(new java.awt.Color(255, 255, 255));
        IDLabel.setText(LoginID);
        searchPanel.add(IDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        searchTextField.setBackground(new java.awt.Color(1, 50, 67));
        searchTextField.setForeground(new java.awt.Color(255, 255, 255));
        searchTextField.setText("Enter Vehicle Number");
        searchTextField.setBorder(null);
        searchTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchTextFieldFocusGained(evt);
            }
        });
        
        searchPanel.add(searchTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 250, 30));

        searchButton.setBackground(new java.awt.Color(255, 255, 255));
        searchButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        searchButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/searchicon.png"))); // NOI18N
        searchButton.setText("Search ");
        searchButton.setHorizontalTextPosition(SwingConstants.LEFT);
        searchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchButtonMouseExited(evt);
            }
        });
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        searchPanel.add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 110, 30));

        searchTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        searchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vehicle Number", "Owner Name", "Company Name", "Vehicle Type", "Address", "Registration Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        searchTable.setGridColor(new java.awt.Color(255, 255, 255));
        searchTable.setRowHeight(25);
        searchTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        searchTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        searchTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchTableMouseClicked(evt);
            }
        });
        searchScrollPane.setViewportView(searchTable);
        if (searchTable.getColumnModel().getColumnCount() > 0) {
            searchTable.getColumnModel().getColumn(0).setResizable(false);
            searchTable.getColumnModel().getColumn(1).setResizable(false);
            searchTable.getColumnModel().getColumn(2).setResizable(false);
            searchTable.getColumnModel().getColumn(3).setResizable(false);
            searchTable.getColumnModel().getColumn(4).setResizable(false);
            searchTable.getColumnModel().getColumn(5).setResizable(false);
        }

        searchPanel.add(searchScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 740, 480));

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
        searchPanel.add(homeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 493, 130, 30));

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
        searchPanel.add(logOutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 553, 130, 30));
        searchPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 250, 10));

        RegisterPhotoLabel.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/remainingpanel.png"))); // NOI18N
        searchPanel.add(RegisterPhotoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 670));

        getContentPane().add(searchPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 700));

        pack();
        setLocationRelativeTo(null);
        show_user();
        setVisible(true);
    }                     
                                        
    //-------------------------------------------------------------------------//
    private void searchButtonMouseEntered(java.awt.event.MouseEvent evt) {                                          
        searchButton.setBackground(new java.awt.Color(51, 110, 123));
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/searchicon2.png"))); // NOI18N
        
    }                                         

    private void searchButtonMouseExited(java.awt.event.MouseEvent evt) {                                         
        searchButton.setBackground(new java.awt.Color(255, 255, 255));
        searchButton.setForeground(new java.awt.Color(0, 0, 0));
        searchButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/searchicon.png")));
        
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
    
    private void searchTextFieldFocusGained(java.awt.event.FocusEvent evt) {                                            
        searchTextField.setText("");
    }                                           

    //-------------------------------------------------------------------------//
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        search_user();    
    }                                            

    
    private void CloseButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        close();
    }                                           

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        StaffPanel sp = new StaffPanel();
        sp.initComponents(LoginID, dateTimeStamp);
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

    private void searchTableMouseClicked(java.awt.event.MouseEvent evt) {                                         
        int index = searchTable.getSelectedRow();
        TableModel model = searchTable.getModel();
        String vehicleno = model.getValueAt(index, 0).toString();
        System.out.println(vehicleno);
    	ShowOwnerDetails Sod = new ShowOwnerDetails();
        Sod.initComponents(LoginID, vehicleno, dateTimeStamp);
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
                new SearchDetail().setVisible(true);
            }
        });
    }

    // Variables declaration    
    private JButton CloseButton;
    private JLabel loggedInTime;
    private JLabel IDLabel;
    private JLabel RegisterPhotoLabel;
    private JButton homeButton;
    private JSeparator jSeparator1;
    private JButton logOutButton;
    private JLabel photoLabel;
    private JButton searchButton;
    private JPanel searchPanel;
    private JScrollPane searchScrollPane;
    private JTable searchTable;
    private JTextField searchTextField;
    private JLabel staffIdLabel;
    // End of variables declaration                   

}
