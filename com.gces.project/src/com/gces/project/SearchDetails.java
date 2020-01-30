package com.gces.project;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;

public class SearchDetails extends JFrame {
    static int sidebar = 0;
    static int mousepX, mousepY;  
    static String LoginID, dateTimeStamp;

    public SearchDetails() {
    	this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("jarIcon.png")));
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
            String query = "SELECT vehiclenumber, companyname, ownername, vehicletype, address, registrationdate FROM ownervehicledetails";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            User user;
            while(rs.next())
            {
                user = new User(rs.getString("vehiclenumber"), rs.getString("ownername"), rs.getString("companyname"), rs.getString("vehicletype"), rs.getString("address"),  rs.getString("registrationdate"));
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
        model.setColumnIdentifiers(new Object[]{"Vehicle Number", "Company Name", "Owner Name", "Vehicle Type", "Address", "Registration Date"});
        Object[] row = new Object[6];
        for(int i = 0; i<list.size();i++)
        {
            row[0] = list.get(i).getvehiclenumber();
            row[1] = list.get(i).getownername();
            row[2] = list.get(i).getcompanyname();
            row[3] = list.get(i).getvehicletype();
            row[4] = list.get(i).getaddress();
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
            String query = "SELECT vehiclenumber, companyname, ownername, vehicletype, address, registrationdate FROM ownervehicledetails WHERE CONCAT(`vehiclenumber`, `companyname`) LIKE '%"+ValToSearch+"%'";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            User user;
            while(rs.next())
            {
                user = new User(rs.getString("vehiclenumber"), rs.getString("ownername"), rs.getString("companyname"), rs.getString("vehicletype"), rs.getString("address"),  rs.getString("registrationdate"));
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
        model.setColumnIdentifiers(new Object[]{"Vehicle Number", "Company Name", "Owner Name", "Vehicle Type", "Address", "Registration Date"});
        Object[] row = new Object[6];
        for(int i = 0; i<list.size();i++)
        {
            row[0] = list.get(i).getvehiclenumber();
            row[1] = list.get(i).getownername();
            row[2] = list.get(i).getcompanyname();
            row[3] = list.get(i).getvehicletype();
            row[4] = list.get(i).getaddress();
            row[5] = list.get(i).getregistrationdate();            
            model.addRow(row);
        }
        searchTable.setModel(model);
    }


    public void initComponents(String LoginID1, String date) {

    	LoginID = LoginID1;
    	dateTimeStamp = date;
    	
        jPanel1 = new JPanel();
        sidebarPanel = new JPanel();
        addButton = new JButton();
        searchButton = new JButton();
        signOutButton = new JButton();
        showButton = new JButton();
        lineSeparator3 = new JSeparator();
        lineSeparator2 = new JSeparator();
        lineSeparator1 = new JSeparator();
        lineSeparator4 = new JSeparator();
        lineSeparator5 = new JSeparator();
        signOutLabel = new JLabel();
        HideLabel = new JLabel();
        searchLabel = new JLabel();
        addLabel = new JLabel();
        lineSeparator6 = new JSeparator();
        homeButton = new JButton();
        homeLabel = new JLabel();
        titlePanel = new JPanel();
        closeButton = new JButton();
        minimizeButton = new JButton();
        showUserLabel = new JLabel();
        showUserLabel1 = new JLabel();
        searchScrollPane = new JScrollPane();
        searchTable = new JTable();
        searchTextField = new JTextField();
        jSeparator1 = new JSeparator();
        searchButton1 = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1040, 680));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidebarPanel.setBackground(new java.awt.Color(1, 50, 67));

        addButton.setBackground(new java.awt.Color(1, 50, 67));
        addButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/project/icons/add.png"))); // NOI18N
        addButton.setBorder(null);
        addButton.setBorderPainted(false);
        addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addButton.setFocusPainted(false);
        addButton.setHorizontalTextPosition(SwingConstants.RIGHT);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        searchButton.setBackground(new java.awt.Color(1, 50, 67));
        searchButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/project/icons/search.png"))); // NOI18N
        searchButton.setBorder(null);
        searchButton.setBorderPainted(false);
        searchButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchButton.setFocusPainted(false);
        searchButton.setHorizontalTextPosition(SwingConstants.RIGHT);
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        signOutButton.setBackground(new java.awt.Color(1, 50, 67));
        signOutButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        signOutButton.setForeground(new java.awt.Color(255, 255, 255));
        signOutButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/project/icons/sign-out.png"))); // NOI18N
        signOutButton.setBorder(null);
        signOutButton.setBorderPainted(false);
        signOutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signOutButton.setFocusPainted(false);
        signOutButton.setHorizontalTextPosition(SwingConstants.RIGHT);
        signOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signOutButtonActionPerformed(evt);
            }
        });

        showButton.setBackground(new java.awt.Color(1, 50, 67));
        showButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        showButton.setForeground(new java.awt.Color(255, 255, 255));
        showButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/project/icons/menu.png"))); // NOI18N
        showButton.setBorder(null);
        showButton.setBorderPainted(false);
        showButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showButton.setFocusPainted(false);
        showButton.setHorizontalTextPosition(SwingConstants.RIGHT);
        showButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButtonActionPerformed(evt);
            }
        });

        signOutLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        signOutLabel.setForeground(new java.awt.Color(255, 255, 255));
        signOutLabel.setText("Sign Out");
        signOutLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signOutLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signOutLabelMouseClicked(evt);
            }
        });

        HideLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        HideLabel.setForeground(new java.awt.Color(255, 255, 255));
        HideLabel.setText("Hide");
        HideLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        HideLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HideLabelMouseClicked(evt);
            }
        });

        searchLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        searchLabel.setForeground(new java.awt.Color(255, 255, 255));
        searchLabel.setText("Search Details");
        searchLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchLabelMouseClicked(evt);
            }
        });

        addLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addLabel.setForeground(new java.awt.Color(255, 255, 255));
        addLabel.setText("New Register");
        addLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addLabelMouseClicked(evt);
            }
        });

        homeButton.setBackground(new java.awt.Color(1, 50, 67));
        homeButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        homeButton.setForeground(new java.awt.Color(255, 255, 255));
        homeButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/project/icons/home.png"))); // NOI18N
        homeButton.setBorder(null);
        homeButton.setBorderPainted(false);
        homeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homeButton.setFocusPainted(false);
        homeButton.setHorizontalTextPosition(SwingConstants.RIGHT);
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        homeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        homeLabel.setForeground(new java.awt.Color(255, 255, 255));
        homeLabel.setText("Home");
        homeLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeLabelMouseClicked(evt);
            }
        });

        GroupLayout sidebarPanelLayout = new GroupLayout(sidebarPanel);
        sidebarPanel.setLayout(sidebarPanelLayout);
        sidebarPanelLayout.setHorizontalGroup(
            sidebarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(lineSeparator4)
            .addComponent(lineSeparator5)
            .addGroup(sidebarPanelLayout.createSequentialGroup()
                .addGroup(sidebarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lineSeparator3)
                    .addComponent(lineSeparator2)
                    .addComponent(lineSeparator1)
                    .addComponent(lineSeparator6)
                    .addGroup(sidebarPanelLayout.createSequentialGroup()
                        .addGroup(sidebarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(sidebarPanelLayout.createSequentialGroup()
                                .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchLabel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
                            .addGroup(sidebarPanelLayout.createSequentialGroup()
                                .addComponent(showButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(HideLabel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
                            .addGroup(sidebarPanelLayout.createSequentialGroup()
                                .addComponent(signOutButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(signOutLabel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
                            .addGroup(sidebarPanelLayout.createSequentialGroup()
                                .addComponent(addButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addLabel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
                            .addGroup(sidebarPanelLayout.createSequentialGroup()
                                .addComponent(homeButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(homeLabel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        sidebarPanelLayout.setVerticalGroup(
            sidebarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(sidebarPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(sidebarPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(showButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addComponent(HideLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addComponent(lineSeparator6, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sidebarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(homeButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addComponent(homeLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lineSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sidebarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(addButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addComponent(addLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lineSeparator2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sidebarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(sidebarPanelLayout.createSequentialGroup()
                        .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lineSeparator3, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
                    .addComponent(searchLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
                .addComponent(lineSeparator4, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sidebarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(sidebarPanelLayout.createSequentialGroup()
                        .addComponent(signOutButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lineSeparator5, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
                    .addComponent(signOutLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jPanel1.add(sidebarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 40, 650));

        titlePanel.setBackground(new java.awt.Color(0, 0, 0));
        titlePanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                titlePanelMouseDragged(evt);
            }
        });
        titlePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                titlePanelMousePressed(evt);
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

        showUserLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        showUserLabel.setForeground(new java.awt.Color(255, 255, 255));
        showUserLabel.setIcon(new ImageIcon(getClass().getResource("/com/gces/project/icons/user.png"))); // NOI18N
        showUserLabel.setText(LoginID);
        showUserLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showUserLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showUserLabelMouseClicked(evt);
            }
        });

        showUserLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        showUserLabel1.setForeground(new java.awt.Color(255, 255, 255));
        showUserLabel1.setText("Logged in at : "+dateTimeStamp);
        showUserLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        GroupLayout titlePanelLayout = new GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, titlePanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(showUserLabel1, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
                .addGap(294, 294, 294)
                .addComponent(showUserLabel, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 349, Short.MAX_VALUE)
                .addComponent(minimizeButton, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(closeButton, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(titlePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(titlePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(showUserLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(showUserLabel1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addGroup(titlePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(closeButton)
                        .addComponent(minimizeButton))))
        );

        jPanel1.add(titlePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 30));

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
        searchTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchTableMouseClicked(evt);
            }
        });
        searchScrollPane.setViewportView(searchTable);
      //-------------//
		        JTableHeader header = searchTable.getTableHeader();
		        header.setForeground(new Color(1, 50, 67));
		        searchScrollPane.getViewport().setBackground(Color.WHITE);
		        searchTable.setRowHeight(30);
		        searchTable.getTableHeader().setFont( new Font( "Arial" , Font.BOLD, 15 ));
		       
		        searchTable.getColumnModel().getColumn(0).setPreferredWidth(80);
		       
		
		        searchTable.getColumnModel().getColumn(1).setPreferredWidth(120);
		       searchTable.getColumnModel().getColumn(2).setPreferredWidth(120);
		
		       searchTable.getColumnModel().getColumn(3).setPreferredWidth(100);
		//------------//


        jPanel1.add(searchScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 950, 540));

        searchTextField.setText("Enter Vehicle Number");
        searchTextField.setBorder(null);
        searchTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchTextFieldFocusGained(evt);
            }
        });
        jPanel1.add(searchTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 250, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 250, 10));

        searchButton1.setBackground(new java.awt.Color(255, 255, 255));
        searchButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        searchButton1.setText("Search ");
        searchButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchButton1.setHorizontalTextPosition(SwingConstants.LEFT);
        searchButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(searchButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 50, 110, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 680));

        pack();
        setLocationRelativeTo(null);
        show_user();
        setVisible(true);
    }// </editor-fold>                        

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        NewRegistration nr = new NewRegistration();
        nr.initComponents(LoginID, dateTimeStamp);
        close();
    }                                         

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
    	//do nothing
    }                                            

    private void signOutButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
    	int logout1 = JOptionPane.showConfirmDialog(null,"Do you really want to Log Out?","Logout Confirmation",JOptionPane.YES_NO_OPTION);
        if(logout1 == 0)
        {
        LoginForm sl = new LoginForm();
        sl.setVisible(true);
        close();
        }

    }                                             

    private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        switch(sidebar)
        {
            case 0:
            {
                sidebarPanel.setSize(220,650);
                showButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/project/icons/hide.png"))); // NOI18N

                //------------------------------------------------------//
                sidebar = 1;
                break;
            }
            case 1:
            {
                sidebarPanel.setSize(40,650);
                showButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/project/icons/menu.png"))); // NOI18N
                sidebar = 0;
                break;
            }
        }
        System.out.println(sidebar);

    }                                          

    private void signOutLabelMouseClicked(java.awt.event.MouseEvent evt) {                                          
    	int logout1 = JOptionPane.showConfirmDialog(null,"Do you really want to Log Out?","Logout Confirmation",JOptionPane.YES_NO_OPTION);
        if(logout1 == 0)
        {
        LoginForm sl = new LoginForm();
        sl.setVisible(true);
        close();
        }

    }                                         

    private void HideLabelMouseClicked(java.awt.event.MouseEvent evt) {                                       
        switch(sidebar)
        {
            case 0:
            {
                sidebarPanel.setSize(220,650);
                showButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/project/icons/hide.png"))); // NOI18N

                //------------------------------------------------------//
                sidebar = 1;
                break;
            }
            case 1:
            {
                sidebarPanel.setSize(40,650);
                showButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/project/icons/menu.png"))); // NOI18N
                sidebar = 0;
                break;
            }
        }

    }                                      

    private void searchLabelMouseClicked(java.awt.event.MouseEvent evt) {                                         
        //do nothing
    }                                        

    private void addLabelMouseClicked(java.awt.event.MouseEvent evt) {                                      
        NewRegistration nr = new NewRegistration();
        nr.initComponents(LoginID, dateTimeStamp);
        close();
    }                                     

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        OpenPanel op = new OpenPanel();
        op.initComponents(LoginID, dateTimeStamp);
        close();
    }                                          

    private void homeLabelMouseClicked(java.awt.event.MouseEvent evt) {                                       
        OpenPanel op = new OpenPanel();
        op.initComponents(LoginID, dateTimeStamp);
        close();
    }                                      

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        close();
    }                                           

    private void minimizeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        this.setState(SearchDetails.ICONIFIED);
    }                                              

    private void showUserLabelMouseClicked(java.awt.event.MouseEvent evt) {                                           
        ShowStaffDetail dialog = new ShowStaffDetail(new JFrame(), true);
        dialog.initComponents(LoginID);

    }                                          

    private void titlePanelMouseDragged(java.awt.event.MouseEvent evt) {                                        
        int kordinateX = evt.getXOnScreen();
        int kordinateY = evt.getYOnScreen();

        this.setLocation(kordinateX-mousepX, kordinateY-mousepY);
    }                                       

    private void titlePanelMousePressed(java.awt.event.MouseEvent evt) {                                        
        mousepX = evt.getX();
        mousepY = evt.getY();

    }                                       

    private void searchTableMouseClicked(java.awt.event.MouseEvent evt) {                                         
        int index = searchTable.getSelectedRow();
        TableModel model = searchTable.getModel();
        String vehicleno = model.getValueAt(index, 0).toString();
        System.out.println(vehicleno);
    	ShowRegister Sod = new ShowRegister();
        Sod.initComponents(LoginID, vehicleno, dateTimeStamp);
        close();
    }                                        

    private void searchTextFieldFocusGained(java.awt.event.FocusEvent evt) {                                            
        searchTextField.setText("");
    }                                           

    private void searchButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        search_user();
    }                                             

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchDetails().setVisible(true);
            }
        });
    }

    private JLabel HideLabel;
    private JButton addButton;
    private JLabel addLabel;
    private JButton closeButton;
    private JButton homeButton;
    private JLabel homeLabel;
    private JPanel jPanel1;
    private JSeparator jSeparator1;
    private JSeparator lineSeparator1;
    private JSeparator lineSeparator2;
    private JSeparator lineSeparator3;
    private JSeparator lineSeparator4;
    private JSeparator lineSeparator5;
    private JSeparator lineSeparator6;
    private JButton minimizeButton;
    private JButton searchButton;
    private JButton searchButton1;
    private JLabel searchLabel;
    private JScrollPane searchScrollPane;
    private JTable searchTable;
    private JTextField searchTextField;
    private JButton showButton;
    private JLabel showUserLabel;
    private JLabel showUserLabel1;
    private JPanel sidebarPanel;
    private JButton signOutButton;
    private JLabel signOutLabel;
    private JPanel titlePanel;
    }
