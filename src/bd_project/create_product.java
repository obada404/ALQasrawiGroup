/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd_project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author data base
 */
public class create_product extends javax.swing.JFrame {

    /**
     * Creates new form create_customer
     */
//    
//   public long aa;
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("bd_projectPU");
        EntityManager em =emf.createEntityManager();
   
    public create_product() {
        initComponents();
    }
    Product a=new Product();
    public void edit_product(Product a) {
       this.a=a;
       jText_NAME.setText(a.getName());
       jTex_com.setText(a.getCompanyName());
       jText_store.setText(String.valueOf(a.getPrice()));
    if(a.getAvailable()==1)
        Available.setSelected(true);
    else 
        notAvailable.setSelected(true);
       
            this.a=em.find(Product.class, a.getProId());
    }
//    public void setsalesmanid(long se){
//        
//        aa=se;
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTex_com = new javax.swing.JTextField();
        jText_NAME = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jText_store = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        Available = new javax.swing.JRadioButton();
        notAvailable = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jTex_com, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 230, -1));
        getContentPane().add(jText_NAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 230, -1));

        jLabel2.setText("NAME");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel3.setText("COMPANY NAME");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jButton1.setText("save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 117, -1));

        jLabel1.setText("PRICE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 46, -1));
        getContentPane().add(jText_store, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 230, -1));

        jButton2.setText("close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, -1, -1));

        Available.setText("Available");
        Available.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AvailableActionPerformed(evt);
            }
        });
        getContentPane().add(Available, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 176, -1, -1));

        notAvailable.setText("Not Available");
        notAvailable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notAvailableActionPerformed(evt);
            }
        });
        getContentPane().add(notAvailable, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 176, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bd_project/product.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          short av;
        if(Available.isSelected())
      av= 1;
        else{
            av=0;
        }
   
      
       
        a.setName(jText_NAME.getText());
        a.setCompanyName(jTex_com.getText());
        a.setPrice(Integer.valueOf(jText_store.getText()));
        a.setAvailable(av);
         em.getTransaction().begin();
       em.persist(a);
       em.getTransaction().commit();
       em.close();
       JOptionPane.showMessageDialog(null," your ID is : \n"+a.getProId());
       this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void AvailableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AvailableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AvailableActionPerformed

    private void notAvailableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notAvailableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_notAvailableActionPerformed

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
            java.util.logging.Logger.getLogger(create_product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(create_product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(create_product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(create_product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new create_product().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Available;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTex_com;
    private javax.swing.JTextField jText_NAME;
    private javax.swing.JTextField jText_store;
    private javax.swing.JRadioButton notAvailable;
    // End of variables declaration//GEN-END:variables
}
