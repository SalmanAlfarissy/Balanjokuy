/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BJK.form;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import BJK.controler.ControllerNewKasir;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;

/**
 *
 * @author Salman Alfarissy
 */
public class FormNewKasir extends javax.swing.JFrame {
    private ControllerNewKasir control;
    private String namakasir;
    private String idkasir;
    private FormHome home;

    /**
     * Creates new form FormNewKasir
     */
    public FormNewKasir() {
        initComponents();
        
        ImageIcon icon = new ImageIcon("src/gambar/logo32.png");
        setIconImage(icon.getImage());
        control = new ControllerNewKasir(this);
        this.setLocationRelativeTo(null);
        control.tampil_daftar();
    }

    public String getNamakasir() {
        return namakasir;
    }

    public void setNamakasir(String namakasir) {
        this.namakasir = namakasir;
    }

    public String getIdkasir() {
        return idkasir;
    }

    public void setIdkasir(String idkasir) {
        this.idkasir = idkasir;
    }
    

    public JTextField getTxtalamat() {
        return txtalamat;
    }

    public JTextField getTxtidkasir() {
        return txtidkasir;
    }

    public JTextField getTxtnamakasir() {
        return txtnamakasir;
    }

    public JPasswordField getTxtpasswd() {
        return txtpasswd;
    }

    public JButton getBtncreate() {
        return btncreate;
    }

    public JButton getBtndelete() {
        return btndelete;
    }

    public JTextField getTxtidkasir1() {
        return txtidkasir1;
    }

    public JTextField getTxtnamakasir1() {
        return txtnamakasir1;
    }

    public JTable getTblkasir() {
        return tblkasir;
    }
    
    
    

    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnhome = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtidkasir = new javax.swing.JTextField();
        txtnamakasir = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtalamat = new javax.swing.JTextField();
        btncreate = new javax.swing.JButton();
        txtpasswd = new javax.swing.JPasswordField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtidkasir1 = new javax.swing.JTextField();
        txtnamakasir1 = new javax.swing.JTextField();
        btndelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblkasir = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btnhome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Iconhome.png"))); // NOI18N
        btnhome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhomeActionPerformed(evt);
            }
        });
        getContentPane().add(btnhome);
        btnhome.setBounds(0, 0, 60, 60);

        jLabel15.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 255, 255));
        jLabel15.setText("Nama Kasir");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(50, 290, 150, 30);

        jLabel14.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 255, 255));
        jLabel14.setText("Id Kasir");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(50, 340, 110, 30);

        txtidkasir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtidkasir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidkasirActionPerformed(evt);
            }
        });
        txtidkasir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtidkasirKeyPressed(evt);
            }
        });
        getContentPane().add(txtidkasir);
        txtidkasir.setBounds(170, 340, 240, 30);

        txtnamakasir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtnamakasir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamakasirActionPerformed(evt);
            }
        });
        txtnamakasir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnamakasirKeyPressed(evt);
            }
        });
        getContentPane().add(txtnamakasir);
        txtnamakasir.setBounds(170, 290, 240, 30);

        jLabel16.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 255, 255));
        jLabel16.setText("Alamat");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(50, 390, 150, 30);

        jLabel17.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(153, 255, 255));
        jLabel17.setText("Password");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(50, 440, 110, 30);

        txtalamat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtalamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtalamatActionPerformed(evt);
            }
        });
        txtalamat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtalamatKeyPressed(evt);
            }
        });
        getContentPane().add(txtalamat);
        txtalamat.setBounds(170, 390, 240, 30);

        btncreate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btncreate.setText("Create");
        btncreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncreateActionPerformed(evt);
            }
        });
        btncreate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btncreateKeyPressed(evt);
            }
        });
        getContentPane().add(btncreate);
        btncreate.setBounds(50, 500, 360, 30);

        txtpasswd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpasswd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpasswdKeyPressed(evt);
            }
        });
        getContentPane().add(txtpasswd);
        txtpasswd.setBounds(170, 440, 240, 30);

        jLabel18.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(153, 255, 255));
        jLabel18.setText("Nama Kasir");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(480, 400, 150, 30);

        jLabel19.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(153, 255, 255));
        jLabel19.setText("Id Kasir");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(480, 450, 110, 30);

        txtidkasir1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtidkasir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidkasir1ActionPerformed(evt);
            }
        });
        txtidkasir1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtidkasir1KeyPressed(evt);
            }
        });
        getContentPane().add(txtidkasir1);
        txtidkasir1.setBounds(600, 450, 240, 30);

        txtnamakasir1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtnamakasir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamakasir1ActionPerformed(evt);
            }
        });
        txtnamakasir1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnamakasir1KeyPressed(evt);
            }
        });
        getContentPane().add(txtnamakasir1);
        txtnamakasir1.setBounds(600, 400, 240, 30);

        btndelete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        btndelete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btndeleteKeyPressed(evt);
            }
        });
        getContentPane().add(btndelete);
        btndelete.setBounds(480, 500, 360, 30);

        tblkasir.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblkasir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblkasirMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblkasir);
        if (tblkasir.getColumnModel().getColumnCount() > 0) {
            tblkasir.getColumnModel().getColumn(0).setResizable(false);
            tblkasir.getColumnModel().getColumn(2).setHeaderValue("Title 3");
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(480, 290, 360, 90);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/account.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 886, 631);

        setBounds(0, 0, 902, 669);
    }// </editor-fold>//GEN-END:initComponents

    private void txtidkasirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidkasirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidkasirActionPerformed

    private void txtnamakasirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamakasirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamakasirActionPerformed

    private void txtnamakasirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnamakasirKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            control.onKeyPresstxtnamakasir();
        }
    }//GEN-LAST:event_txtnamakasirKeyPressed

    private void txtalamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtalamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtalamatActionPerformed

    private void txtalamatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtalamatKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            control.onKeyPresstxtalamat();
        }
    }//GEN-LAST:event_txtalamatKeyPressed

    private void btncreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncreateActionPerformed
        // TODO add your handling code here:
        control.create();
       
    }//GEN-LAST:event_btncreateActionPerformed

    private void txtidkasirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidkasirKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            control.onKeyPresstxtidkasir();
        }
    }//GEN-LAST:event_txtidkasirKeyPressed

    private void txtpasswdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswdKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            control.onKeyPresstxtpasswd();
        }
    }//GEN-LAST:event_txtpasswdKeyPressed

    private void btncreateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btncreateKeyPressed
        // TODO add your handling code here:
        this.getRootPane().setDefaultButton(btncreate);
    }//GEN-LAST:event_btncreateKeyPressed

    private void btnhomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhomeActionPerformed
        // TODO add your handling code here:
        home = new FormHome();
        home.getLbidkasir().setText(idkasir);
        home.getLbnamakasir().setText(namakasir);
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnhomeActionPerformed

    private void txtidkasir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidkasir1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidkasir1ActionPerformed

    private void txtidkasir1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidkasir1KeyPressed
        // TODO add your handling code here:
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            control.onKeyPresstxtidkasir1();
        }
    }//GEN-LAST:event_txtidkasir1KeyPressed

    private void txtnamakasir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamakasir1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamakasir1ActionPerformed

    private void txtnamakasir1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnamakasir1KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            control.onKeyPresstxtnamakasir1();
        }
    }//GEN-LAST:event_txtnamakasir1KeyPressed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
        control.delete();
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btndeleteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btndeleteKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btndeleteKeyPressed

    private void tblkasirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblkasirMouseClicked
        // TODO add your handling code here:
        control.tablecliock();
    }//GEN-LAST:event_tblkasirMouseClicked

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
            java.util.logging.Logger.getLogger(FormNewKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormNewKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormNewKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormNewKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormNewKasir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncreate;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnhome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblkasir;
    private javax.swing.JTextField txtalamat;
    private javax.swing.JTextField txtidkasir;
    private javax.swing.JTextField txtidkasir1;
    private javax.swing.JTextField txtnamakasir;
    private javax.swing.JTextField txtnamakasir1;
    private javax.swing.JPasswordField txtpasswd;
    // End of variables declaration//GEN-END:variables
}