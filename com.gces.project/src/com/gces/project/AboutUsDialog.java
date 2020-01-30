package com.gces.project;

import java.awt.event.KeyEvent;

import javax.swing.*;

public class AboutUsDialog extends JDialog {

	public AboutUsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new JPanel();
        titleSeparator = new JSeparator();
        titleLabel = new JLabel();
        okButton = new JButton();
        jLabel1 = new JLabel();
        jSeparator1 = new JSeparator();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        titleSeparator1 = new JSeparator();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setOpacity(0.85F);
        setPreferredSize(new java.awt.Dimension(440, 580));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        //Panel
        jPanel1.setBackground(new java.awt.Color(1, 50, 67));
        jPanel1.setPreferredSize(new java.awt.Dimension(440, 580));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(titleSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 400, 10));

        //About Us 
        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setText("About Us");
        jPanel1.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 120, -1));

        //Ok button
        okButton.setBackground(new java.awt.Color(255, 255, 255));
        okButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        okButton.setText("Ok");
        okButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        okButton.setHorizontalTextPosition(SwingConstants.RIGHT);
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        okButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                okButtonKeyPressed(evt);
            }
        });
        
        jPanel1.add(okButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 530, 80, 30));

        jLabel1.setBackground(new java.awt.Color(1, 50, 67));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("( T )");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, -1, 20));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 190, 10));

        jLabel2.setBackground(new java.awt.Color(1, 50, 67));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Prabin Shrestha");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, -1, 20));

        jLabel3.setBackground(new java.awt.Color(1, 50, 67));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Sagar Gurung");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, -1, 20));

        jLabel4.setBackground(new java.awt.Color(1, 50, 67));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Er. Hari K.C.");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, -1, 20));

        jLabel5.setBackground(new java.awt.Color(1, 50, 67));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nischal Bhandari");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, -1, 20));

        jLabel6.setBackground(new java.awt.Color(1, 50, 67));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("( S )");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, -1, 20));

        jScrollPane1.setBackground(new java.awt.Color(1, 50, 67));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(1, 50, 67));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("\" Automobile Registration System \" is  a  Desktop application built with the  help of Core Java and\nits library. It is used by Automobile Showroom to register : scooter,  Motor  Bike  and  Car.  This application  is  mainly  used to establish a link between vehicle and owner of the vehicle.The main purpose  of  this  application is to Create a new registration of vehicle  nd to Search all details of vehicle and owner in case of any emergency.");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(null);
        jTextArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextArea1.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jTextArea1.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 400, 190));
        jPanel1.add(titleSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 400, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 580));

        pack();
        setLocationRelativeTo(null);
    }

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        this.dispose();
    }                                        

    private void okButtonKeyPressed(java.awt.event.KeyEvent evt) {                                       
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
        	this.dispose();
        }
    }
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AboutUsDialog dialog = new AboutUsDialog(new JFrame(), true);
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

    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JTextArea jTextArea1;
    private JButton okButton;
    private JLabel titleLabel;
    private JSeparator titleSeparator;
    private JSeparator titleSeparator1;
 
}
