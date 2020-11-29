/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Becca
 */

package GUI;
public class MainMenu extends javax.swing.JFrame {
    
    private GamePlayScreen GPS;
    
    /**
     * Creates new form StartScreen
     */
    public MainMenu(/*GamePlayScreen gps*/) {
   //     GPS = gps;
        initComponents();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        howToPlayButton = new javax.swing.JButton();
        playButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        howToPlayButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/howtoplaybutton.jpg"))); // NOI18N
        howToPlayButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/howtoplaybuttonrollover.jpg"))); // NOI18N
        howToPlayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                howToPlayButtonActionPerformed(evt);
            }
        });
        getContentPane().add(howToPlayButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 810, 200, 80));

        playButton.setBackground(new java.awt.Color(204, 0, 0));
        playButton.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        playButton.setForeground(new java.awt.Color(255, 255, 255));
        playButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playbutton.jpg"))); // NOI18N
        playButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playbuttonrollover.jpg"))); // NOI18N
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });
        getContentPane().add(playButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 810, 200, 80));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/monopoly_deal_logo_page.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 2058, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        // TODO add your handling code here:
        PlayScreen PS = new PlayScreen();
        PS.setGamePlayScreen(GPS);
        PS.setVisible(true);
        dispose();
    }//GEN-LAST:event_playButtonActionPerformed

    private void howToPlayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_howToPlayButtonActionPerformed
        // TODO add your handling code here:
        HowToPlayScreen HTPS = new HowToPlayScreen();
        HTPS.setVisible(true);
    }//GEN-LAST:event_howToPlayButtonActionPerformed

    
    public void setGamePlayScreen(GamePlayScreen gps){
        GPS = gps;
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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton howToPlayButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton playButton;
    // End of variables declaration//GEN-END:variables
}