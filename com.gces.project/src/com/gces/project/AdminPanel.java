package com.gces.project;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;

public class AdminPanel extends javax.swing.JFrame {
    static int sidebar = 0;
    static int mousepX, mousepY;  
    static String LoginID, dateTimeStamp;

    public AdminPanel() {
    	this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("jarIcon.png")));
    	
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
        
    	jPanel1 = new javax.swing.JPanel();
        sidebarPanel = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        signOutButton = new javax.swing.JButton();
        showButton = new javax.swing.JButton();
        lineSeparator3 = new javax.swing.JSeparator();
        lineSeparator2 = new javax.swing.JSeparator();
        lineSeparator1 = new javax.swing.JSeparator();
        lineSeparator4 = new javax.swing.JSeparator();
        lineSeparator5 = new javax.swing.JSeparator();
        signOutLabel = new javax.swing.JLabel();
        HideLabel = new javax.swing.JLabel();
        deleteLabel = new javax.swing.JLabel();
        addLabel = new javax.swing.JLabel();
        lineSeparator6 = new javax.swing.JSeparator();
        homeButton = new javax.swing.JButton();
        homeLabel = new javax.swing.JLabel();
        titlePanel = new javax.swing.JPanel();
        closeButton = new javax.swing.JButton();
        minimizeButton = new javax.swing.JButton();
        showUserLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        staffLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1040, 680));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidebarPanel.setBackground(new java.awt.Color(1, 50, 67));

        addButton.setBackground(new java.awt.Color(1, 50, 67));
        addButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gces/project/icons/add.png"))); // NOI18N
        addButton.setBorder(null);
        addButton.setBorderPainted(false);
        addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addButton.setFocusPainted(false);
        addButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(1, 50, 67));
        deleteButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gces/project/icons/deleteButton.png"))); // NOI18N
        deleteButton.setBorder(null);
        deleteButton.setBorderPainted(false);
        deleteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteButton.setFocusPainted(false);
        deleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        signOutButton.setBackground(new java.awt.Color(1, 50, 67));
        signOutButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        signOutButton.setForeground(new java.awt.Color(255, 255, 255));
        signOutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gces/project/icons/sign-out.png"))); // NOI18N
        signOutButton.setBorder(null);
        signOutButton.setBorderPainted(false);
        signOutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signOutButton.setFocusPainted(false);
        signOutButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        signOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signOutButtonActionPerformed(evt);
            }
        });

        showButton.setBackground(new java.awt.Color(1, 50, 67));
        showButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        showButton.setForeground(new java.awt.Color(255, 255, 255));
        showButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gces/project/icons/menu.png"))); // NOI18N
        showButton.setBorder(null);
        showButton.setBorderPainted(false);
        showButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showButton.setFocusPainted(false);
        showButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
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

        deleteLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteLabel.setForeground(new java.awt.Color(255, 255, 255));
        deleteLabel.setText("Delete Staff");
        deleteLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteLabelMouseClicked(evt);
            }
        });

        addLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addLabel.setForeground(new java.awt.Color(255, 255, 255));
        addLabel.setText("New Staff");
        addLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addLabelMouseClicked(evt);
            }
        });

        homeButton.setBackground(new java.awt.Color(1, 50, 67));
        homeButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        homeButton.setForeground(new java.awt.Color(255, 255, 255));
        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gces/project/icons/home.png"))); // NOI18N
        homeButton.setBorder(null);
        homeButton.setBorderPainted(false);
        homeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homeButton.setFocusPainted(false);
        homeButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
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

        javax.swing.GroupLayout sidebarPanelLayout = new javax.swing.GroupLayout(sidebarPanel);
        sidebarPanel.setLayout(sidebarPanelLayout);
        sidebarPanelLayout.setHorizontalGroup(
            sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lineSeparator4)
            .addComponent(lineSeparator5)
            .addGroup(sidebarPanelLayout.createSequentialGroup()
                .addGroup(sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lineSeparator3)
                    .addComponent(lineSeparator2)
                    .addComponent(lineSeparator1)
                    .addComponent(lineSeparator6)
                    .addGroup(sidebarPanelLayout.createSequentialGroup()
                        .addGroup(sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(sidebarPanelLayout.createSequentialGroup()
                                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(sidebarPanelLayout.createSequentialGroup()
                                .addComponent(showButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(HideLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(sidebarPanelLayout.createSequentialGroup()
                                .addComponent(signOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(signOutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(sidebarPanelLayout.createSequentialGroup()
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(sidebarPanelLayout.createSequentialGroup()
                                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(homeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        sidebarPanelLayout.setVerticalGroup(
            sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(showButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HideLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addComponent(lineSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(homeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lineSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lineSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sidebarPanelLayout.createSequentialGroup()
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lineSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(deleteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
                .addComponent(lineSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sidebarPanelLayout.createSequentialGroup()
                        .addComponent(signOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lineSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(signOutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gces/project/icons/close-window.png"))); // NOI18N
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
        minimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gces/project/icons/minimize-window-filled.png"))); // NOI18N
        minimizeButton.setBorderPainted(false);
        minimizeButton.setContentAreaFilled(false);
        minimizeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimizeButton.setFocusable(false);
        minimizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeButtonActionPerformed(evt);
            }
        });

        showUserLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        showUserLabel1.setForeground(new java.awt.Color(255, 255, 255));
        showUserLabel1.setText("Logged in at : "+dateTimeStamp);
        showUserLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titlePanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(showUserLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 763, Short.MAX_VALUE)
                .addComponent(minimizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(showUserLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minimizeButton)
                    .addComponent(closeButton)))
        );

        jPanel1.add(titlePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 30));

        table.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        //-------------//
		        JTableHeader header = table.getTableHeader();
		        header.setForeground(new Color(1, 50, 67));
		        jScrollPane2.getViewport().setBackground(Color.WHITE);
		        table.setRowHeight(40);
		        table.getTableHeader().setFont( new Font( "Arial" , Font.BOLD, 15 ));
		       
		       table.getColumnModel().getColumn(0).setPreferredWidth(80);
		       
		
		       table.getColumnModel().getColumn(1).setPreferredWidth(120);
		       table.getColumnModel().getColumn(2).setPreferredWidth(120);
		
		       table.getColumnModel().getColumn(3).setPreferredWidth(100);
        //------------//

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 950, 550));

        staffLabel.setBackground(new java.awt.Color(255, 255, 255));
        staffLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        staffLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        staffLabel.setText("Staff Details:");
        jPanel1.add(staffLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 680));

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        
    }                       

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        AddStaff dialog = new AddStaff(new javax.swing.JFrame(), true);
        dialog.setVisible(true);

    }                                         

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
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
        	StaffDeleteDialog dialog = new StaffDeleteDialog(new javax.swing.JFrame(), true);
            dialog.setVisible(true);   
           
        }
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
                showButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gces/project/icons/hide.png"))); // NOI18N
                sidebar = 1;
                break;
            }
            case 1:
            {
                sidebarPanel.setSize(40,650);
                showButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gces/project/icons/menu.png"))); // NOI18N
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
                showButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gces/project/icons/hide.png"))); // NOI18N

                //------------------------------------------------------//
                sidebar = 1;
                break;
            }
            case 1:
            {
                sidebarPanel.setSize(40,650);
                showButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gces/project/icons/menu.png"))); // NOI18N
                sidebar = 0;
                break;
            }
        }

    }                                      

    private void deleteLabelMouseClicked(java.awt.event.MouseEvent evt) {                                         
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
        	System.out.println(e);
        }
    }                                        

    private void addLabelMouseClicked(java.awt.event.MouseEvent evt) {                                      
        AddStaff dialog = new AddStaff(new javax.swing.JFrame(), true);
        dialog.setVisible(true);

    }                                     

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        
    }                                          

    private void homeLabelMouseClicked(java.awt.event.MouseEvent evt) {                                       
        
    }                                      

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        close();
    }                                           

    private void minimizeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        this.setState(AdminPanel.ICONIFIED);
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

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPanel().setVisible(true);
            }
        });
    }

    private javax.swing.JLabel HideLabel;
    private javax.swing.JButton addButton;
    private javax.swing.JLabel addLabel;
    private javax.swing.JButton closeButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel deleteLabel;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel homeLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator lineSeparator1;
    private javax.swing.JSeparator lineSeparator2;
    private javax.swing.JSeparator lineSeparator3;
    private javax.swing.JSeparator lineSeparator4;
    private javax.swing.JSeparator lineSeparator5;
    private javax.swing.JSeparator lineSeparator6;
    private javax.swing.JButton minimizeButton;
    private javax.swing.JButton showButton;
    private javax.swing.JLabel showUserLabel1;
    private javax.swing.JPanel sidebarPanel;
    private javax.swing.JButton signOutButton;
    private javax.swing.JLabel signOutLabel;
    private javax.swing.JLabel staffLabel;
    private javax.swing.JTable table;
    private javax.swing.JPanel titlePanel;
}
