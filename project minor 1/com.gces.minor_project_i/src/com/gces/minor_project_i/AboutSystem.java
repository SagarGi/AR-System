package com.gces.minor_project_i;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.*;

/**
 *
 * @author pravinewa
 */
public class AboutSystem extends JFrame {

    public AboutSystem() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("jarIcon.png")));
    	
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setBackground(new Color(0,0,0,0));
        aboutPanel.setBackground(new Color(0,0,0,0));
    }
    private void close()
    {
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    private void initComponents() {

    	//setIconImage(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/jarIcon.png")).getImage());
    	
    	aboutPanel = new JPanel();
        closeButton = new JButton();
        aboutLabel = new JLabel();
        supervisorPhoto = new JLabel();
        photoSeparator = new JSeparator();
        nischalPhoto = new JLabel();
        pravinewa = new JLabel();
        sagarphoto = new JLabel();
        desc1 = new JLabel();
        desc2 = new JLabel();
        desc3 = new JLabel();
        desc4 = new JLabel();
        desc5 = new JLabel();
        desc6 = new JLabel();
        Separator = new JSeparator();
        supervisorTitleLabel = new JLabel();
        supervisorLabel = new JLabel();
        projectMemberTitleLabel = new JLabel();
        mamberLabel1 = new JLabel();
        memberLabel2 = new JLabel();
        memberLabel3 = new JLabel();
        teamLeaderLabel = new JLabel();
        aboutPanelPhoto = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        aboutPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        closeButton.setBackground(new java.awt.Color(81, 144, 216));
        closeButton.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/closeicon.png"))); // NOI18N
        closeButton.setBorder(null);
        closeButton.setBorderPainted(false);
        closeButton.setContentAreaFilled(false);
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        aboutPanel.add(closeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, -1, -1));

        aboutLabel.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        aboutLabel.setForeground(new java.awt.Color(255, 255, 255));
        aboutLabel.setText("About");
        aboutPanel.add(aboutLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        supervisorPhoto.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/harisir.png"))); // NOI18N
        supervisorPhoto.setText("jLabel2");
        aboutPanel.add(supervisorPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 150, 100, 100));
        aboutPanel.add(photoSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 260, 100, 10));

        nischalPhoto.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/sagar.png"))); // NOI18N
        nischalPhoto.setText("jLabel2");
        aboutPanel.add(nischalPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 510, 100, 100));

        pravinewa.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/newa.png"))); // NOI18N
        pravinewa.setText("jLabel2");
        aboutPanel.add(pravinewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 390, 100, 100));

        sagarphoto.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/nischal.png"))); // NOI18N
        sagarphoto.setText("jLabel2");
        aboutPanel.add(sagarphoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 270, 100, 100));

        desc1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        desc1.setForeground(new java.awt.Color(255, 255, 255));
        desc1.setText("\" Automobile Registration System \" is a Desktop Application built with the help of");
        aboutPanel.add(desc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 490, 40));

        desc2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        desc2.setForeground(new java.awt.Color(255, 255, 255));
        desc2.setText("Core Java and its library. It is used by Automobile Showroom  to register scooty,");
        aboutPanel.add(desc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 500, 40));

        desc3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        desc3.setForeground(new java.awt.Color(255, 255, 255));
        desc3.setText("Motor Bike and Car. This application is  mainly used  to  establish  a  link  between ");
        aboutPanel.add(desc3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 500, 40));

        desc4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        desc4.setForeground(new java.awt.Color(255, 255, 255));
        desc4.setText("vehicle and owner of the vehicle. The main purpose of this application is to Create");
        aboutPanel.add(desc4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 500, 40));

        desc5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        desc5.setForeground(new java.awt.Color(255, 255, 255));
        desc5.setText("new registration of vehicle and to Search all the vehicle and  owner details  in case");
        aboutPanel.add(desc5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 500, 40));

        desc6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        desc6.setForeground(new java.awt.Color(255, 255, 255));
        desc6.setText("of emergency.");
        aboutPanel.add(desc6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 500, 40));
        aboutPanel.add(Separator, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 520, 10));

        supervisorTitleLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        supervisorTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        supervisorTitleLabel.setText("Supervisor :");
        aboutPanel.add(supervisorTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, -1, -1));

        supervisorLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        supervisorLabel.setForeground(new java.awt.Color(255, 255, 255));
        supervisorLabel.setText("Er. Hari K.C.");
        aboutPanel.add(supervisorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 410, -1, -1));

        projectMemberTitleLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        projectMemberTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        projectMemberTitleLabel.setText("Project Members :");
        aboutPanel.add(projectMemberTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, -1, -1));

        mamberLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mamberLabel1.setForeground(new java.awt.Color(255, 255, 255));
        mamberLabel1.setText("Nischal Bhandari");
        aboutPanel.add(mamberLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 460, -1, -1));

        memberLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        memberLabel2.setForeground(new java.awt.Color(255, 255, 255));
        memberLabel2.setText("Prabin Shrestha");
        aboutPanel.add(memberLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 500, -1, -1));

        memberLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        memberLabel3.setForeground(new java.awt.Color(255, 255, 255));
        memberLabel3.setText("Sagar Gurung");
        aboutPanel.add(memberLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 540, -1, -1));

        teamLeaderLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        teamLeaderLabel.setForeground(new java.awt.Color(51, 110, 123));
        teamLeaderLabel.setText("( T )");
        aboutPanel.add(teamLeaderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 500, -1, -1));

        aboutPanelPhoto.setIcon(new ImageIcon(getClass().getResource("/com/gces/minor_project_i/icons/aboutpanel.png"))); // NOI18N
        aboutPanel.add(aboutPanelPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(aboutPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 700));

        pack();
        setLocationRelativeTo(null);
    }                     

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        close();
    }                                           

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AboutSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AboutSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AboutSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AboutSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AboutSystem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private JSeparator Separator;
    private JLabel aboutLabel;
    private JPanel aboutPanel;
    private JLabel aboutPanelPhoto;
    private JButton closeButton;
    private JLabel desc1;
    private JLabel desc2;
    private JLabel desc3;
    private JLabel desc4;
    private JLabel desc5;
    private JLabel desc6;
    private JLabel mamberLabel1;
    private JLabel memberLabel2;
    private JLabel memberLabel3;
    private JLabel nischalPhoto;
    private JSeparator photoSeparator;
    private JLabel pravinewa;
    private JLabel projectMemberTitleLabel;
    private JLabel sagarphoto;
    private JLabel supervisorLabel;
    private JLabel supervisorPhoto;
    private JLabel supervisorTitleLabel;
    private JLabel teamLeaderLabel;
    // End of variables declaration                   
}
