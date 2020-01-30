package com.gces.project;

import javax.swing.*;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

public class LogoutDialog extends JDialog {
	
    public LogoutDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
        private void close()
    {
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    private void initComponents() {

        jPanel1 = new JPanel();
        MessageLabel = new JLabel();
        cancelButton = new JButton();
        okButton = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setOpacity(0.9F);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(1, 50, 67));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MessageLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        MessageLabel.setForeground(new java.awt.Color(255, 255, 255));
        MessageLabel.setText("Do you really want to Log Out?");
        jPanel1.add(MessageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        cancelButton.setBackground(new java.awt.Color(255, 255, 255));
        cancelButton.setText("Cancel");
        cancelButton.setBorderPainted(false);
        cancelButton.setFocusPainted(false);
        cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelButtonMouseExited(evt);
            }
        });
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        jPanel1.add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 90, -1));

        okButton.setBackground(new java.awt.Color(255, 255, 255));
        okButton.setText("OK");
        okButton.setBorderPainted(false);
        okButton.setFocusPainted(false);
        okButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                okButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                okButtonMouseExited(evt);
            }
        });
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        jPanel1.add(okButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 90, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 160));

        pack();
        setLocationRelativeTo(null);
    }                        

    private void okButtonMouseEntered(java.awt.event.MouseEvent evt) {                                      
        okButton.setBackground(new java.awt.Color(0,153,0));
        okButton.setForeground(new java.awt.Color(255, 255, 255));

    }                                     

    private void okButtonMouseExited(java.awt.event.MouseEvent evt) {                                     
        okButton.setBackground(new java.awt.Color(255, 255, 255));
        okButton.setForeground(new java.awt.Color(0, 0, 0));

    }                                    

    private void cancelButtonMouseEntered(java.awt.event.MouseEvent evt) {                                          
        cancelButton.setBackground(new java.awt.Color(255, 0, 0));
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
    }                                         

    private void cancelButtonMouseExited(java.awt.event.MouseEvent evt) {                                         
        cancelButton.setBackground(new java.awt.Color(255, 255, 255));
        cancelButton.setForeground(new java.awt.Color(0, 0, 0));

    }                                        

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        OpenPanel op = new OpenPanel();
        op.setVisible(true);
    	this.dispose();
    }                                            

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	LoginForm lf = new LoginForm();
    	lf.setVisible(true);
    	this.dispose();
    		
    }                                        

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LogoutDialog dialog = new LogoutDialog(new JFrame(), true);
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

    private JLabel MessageLabel;
    private JButton cancelButton;
    private JPanel jPanel1;
    private JButton okButton;
}
