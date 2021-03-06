/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author pazi jamadi
 */
public class StudentHome extends javax.swing.JFrame {

    /**
     * Creates new form StudentHome
     */
    public StudentHome() {
        initComponents();
        question();
    }
 public void question()
 {
        try {
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/quizdb","root","");
            String sql="SELECT*FROM questions";
            PreparedStatement pst;
            pst=conn.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            {
                qsn.setText(rs.getString(2));
            }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
 }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        qsn = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ans = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ANSWER:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 160, 80, 60);
        getContentPane().add(qsn);
        qsn.setBounds(140, 50, 630, 110);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("QUESTION:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 30, 80, 60);
        getContentPane().add(ans);
        ans.setBounds(130, 180, 150, 30);

        jButton1.setText("SUBMIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(130, 250, 120, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          try {
      Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/quizdb","root","");
            String answer=ans.getText();
           String qry="SELECT*FROM answer WHERE Answer=?";
           PreparedStatement pstd=conn.prepareStatement(qry);
           pstd.setString(1,answer);
           ResultSet rst=pstd.executeQuery();
           if(rst.next())
           {
               JOptionPane.showMessageDialog(null,"correct");
           }
           else{
                JOptionPane.showMessageDialog(null,"Incorrect");
           }
                 
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null,ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(StudentHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ans;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel qsn;
    // End of variables declaration//GEN-END:variables
}
