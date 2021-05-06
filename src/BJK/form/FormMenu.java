/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BJK.form;

/**
 *
 * @author Salman Alfarissy
 */
import BJK.controler.ControllerMenu;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import BJK.controler.ControllerLogin;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import BJK.form.FormHome;
import BJK.form.FormLogin;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class FormMenu extends javax.swing.JFrame {
    private ControllerMenu controler;
    private String id_kasir;
    private FormHome home;
    private FormLogin login;
    private FormReport1 report;



    /**
     * Creates new form FormMenu
     */
    public FormMenu() {
        initComponents();
        
        ImageIcon icon = new ImageIcon("src/gambar/logo32.png");
        setIconImage(icon.getImage());
        controler = new ControllerMenu(this);
        this.setLocationRelativeTo(null);    
        controler.tampil_daftar();
    }

    public String getId_kasir() {
        return id_kasir;
    }

    public void setId_kasir(String id_kasir) {
        this.id_kasir = id_kasir;
    }
    

    public JLabel getLbnamakasir() {
        return lbnamakasir;
    }

    public void setLbnamakasir(JLabel lbnamakasir) {
        this.lbnamakasir = lbnamakasir;
    }
    

    public ControllerMenu getControler() {
        return controler;
    }

    public JButton getBtndelete() {
        return btndelete;
    }

    public JButton getBtnhitung() {
        return btnhitung;
    }

    public JButton getBtninsert() {
        return btninsert;
    }

    public JButton getBtnkembalian() {
        return btnkembalian;
    }

    public JButton getBtnprint() {
        return btnprint;
    }

    public JButton getBtnreset() {
        return btnreset;
    }

    public JButton getBtnupdate() {
        return btnupdate;
    }

    public JCheckBox getCkm1() {
        return ckm1;
    }

    public JCheckBox getCkm2() {
        return ckm2;
    }

    public JCheckBox getCkm3() {
        return ckm3;
    }

    public JCheckBox getCkm4() {
        return ckm4;
    }

    public JCheckBox getCkm5() {
        return ckm5;
    }

    public JCheckBox getCkm10() {
        return ckm10;
    }

    public JCheckBox getCkm11() {
        return ckm11;
    }

    public JCheckBox getCkm12() {
        return ckm12;
    }

    public JCheckBox getCkm13() {
        return ckm13;
    }

    public JCheckBox getCkm14() {
        return ckm14;
    }

    public JCheckBox getCkm6() {
        return ckm6;
    }

    public JCheckBox getCkm7() {
        return ckm7;
    }

    public JCheckBox getCkm8() {
        return ckm8;
    }

    public JCheckBox getCkm9() {
        return ckm9;
    }

    public JCheckBox getCkn1() {
        return ckn1;
    }

    public JCheckBox getCkn10() {
        return ckn10;
    }

    public JCheckBox getCkn11() {
        return ckn11;
    }

    public JCheckBox getCkn2() {
        return ckn2;
    }

    public JCheckBox getCkn3() {
        return ckn3;
    }

    public JCheckBox getCkn4() {
        return ckn4;
    }

    public JCheckBox getCkn5() {
        return ckn5;
    }

    public JCheckBox getCkn6() {
        return ckn6;
    }

    public JCheckBox getCkn7() {
        return ckn7;
    }

    public JCheckBox getCkn8() {
        return ckn8;
    }

    public JCheckBox getCkn9() {
        return ckn9;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JTextField getTxtjmlm10() {
        return txtjmlm10;
    }

    public JTextField getTxtjmlm11() {
        return txtjmlm11;
    }

    public JTextField getTxtjmlm12() {
        return txtjmlm12;
    }

    public JTextField getTxtjmlm13() {
        return txtjmlm13;
    }

    public JTextField getTxtjmlm14() {
        return txtjmlm14;
    }

    public JTextField getTxtjmlm6() {
        return txtjmlm6;
    }

    public JTextField getTxtjmlm7() {
        return txtjmlm7;
    }

    public JTextField getTxtjmlm8() {
        return txtjmlm8;
    }

    public JTextField getTxtjmlm9() {
        return txtjmlm9;
    }

    public JTextField getTxtjmlmi1() {
        return txtjmlmi1;
    }

    public JTextField getTxtjmlmi10() {
        return txtjmlmi10;
    }

    public JTextField getTxtjmlmi11() {
        return txtjmlmi11;
    }

    public JTextField getTxtjmlmi2() {
        return txtjmlmi2;
    }

    public JTextField getTxtjmlmi3() {
        return txtjmlmi3;
    }

    public JTextField getTxtjmlmi4() {
        return txtjmlmi4;
    }

    public JTextField getTxtjmlmi5() {
        return txtjmlmi5;
    }

    public JTextField getTxtjmlmi6() {
        return txtjmlmi6;
    }

    public JTextField getTxtjmlmi7() {
        return txtjmlmi7;
    }

    public JTextField getTxtjmlmi8() {
        return txtjmlmi8;
    }

    public JTextField getTxtjmlmi9() {
        return txtjmlmi9;
    }
    
    

    public JTable getTbltrans() {
        return tbltrans;
    }

    public JTextField getTxtidtrans() {
        return txtidtrans;
    }

    public JTextField getTxtjmlbayar() {
        return txtjmlbayar;
    }

    public JTextField getTxtjmlm1() {
        return txtjmlm1;
    }

    public JTextField getTxtjmlm2() {
        return txtjmlm2;
    }

    public JTextField getTxtjmlm3() {
        return txtjmlm3;
    }

    public JTextField getTxtjmlm4() {
        return txtjmlm4;
    }

    public JTextField getTxtjmlm5() {
        return txtjmlm5;
    }

    public JTextField getTxtkembalian() {
        return txtkembalian;
    }

    public JTextField getTxtnamapelanggan() {
        return txtnamapelanggan;
    }

    public JTextField getTxttotalharga() {
        return txttotalharga;
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
        txtkembalian = new javax.swing.JTextField();
        txtnamapelanggan = new javax.swing.JTextField();
        ckm1 = new javax.swing.JCheckBox();
        ckm2 = new javax.swing.JCheckBox();
        ckm3 = new javax.swing.JCheckBox();
        ckm4 = new javax.swing.JCheckBox();
        ckm5 = new javax.swing.JCheckBox();
        txtjmlm1 = new javax.swing.JTextField();
        txtjmlm2 = new javax.swing.JTextField();
        txtjmlm3 = new javax.swing.JTextField();
        txtjmlm4 = new javax.swing.JTextField();
        txtjmlm5 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbltrans = new javax.swing.JTable();
        txtidtrans = new javax.swing.JTextField();
        txttotalharga = new javax.swing.JTextField();
        txtjmlbayar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnhitung = new javax.swing.JButton();
        btnkembalian = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();
        btninsert = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btnprint = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        ckn2 = new javax.swing.JCheckBox();
        ckn3 = new javax.swing.JCheckBox();
        ckn4 = new javax.swing.JCheckBox();
        ckn5 = new javax.swing.JCheckBox();
        ckn6 = new javax.swing.JCheckBox();
        ckn7 = new javax.swing.JCheckBox();
        ckn8 = new javax.swing.JCheckBox();
        ckn9 = new javax.swing.JCheckBox();
        ckn10 = new javax.swing.JCheckBox();
        ckn11 = new javax.swing.JCheckBox();
        ckn1 = new javax.swing.JCheckBox();
        txtjmlmi2 = new javax.swing.JTextField();
        txtjmlmi1 = new javax.swing.JTextField();
        txtjmlmi4 = new javax.swing.JTextField();
        txtjmlmi3 = new javax.swing.JTextField();
        txtjmlmi6 = new javax.swing.JTextField();
        txtjmlmi5 = new javax.swing.JTextField();
        txtjmlmi8 = new javax.swing.JTextField();
        txtjmlmi7 = new javax.swing.JTextField();
        txtjmlmi10 = new javax.swing.JTextField();
        txtjmlmi9 = new javax.swing.JTextField();
        txtjmlmi11 = new javax.swing.JTextField();
        ckm6 = new javax.swing.JCheckBox();
        ckm7 = new javax.swing.JCheckBox();
        ckm8 = new javax.swing.JCheckBox();
        ckm9 = new javax.swing.JCheckBox();
        ckm10 = new javax.swing.JCheckBox();
        ckm11 = new javax.swing.JCheckBox();
        ckm12 = new javax.swing.JCheckBox();
        ckm13 = new javax.swing.JCheckBox();
        ckm14 = new javax.swing.JCheckBox();
        txtjmlm6 = new javax.swing.JTextField();
        txtjmlm8 = new javax.swing.JTextField();
        txtjmlm7 = new javax.swing.JTextField();
        txtjmlm10 = new javax.swing.JTextField();
        txtjmlm9 = new javax.swing.JTextField();
        txtjmlm12 = new javax.swing.JTextField();
        txtjmlm11 = new javax.swing.JTextField();
        txtjmlm14 = new javax.swing.JTextField();
        txtjmlm13 = new javax.swing.JTextField();
        lbnamakasir = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnreport = new javax.swing.JButton();
        btnhome = new javax.swing.JButton();
        btnlogout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Trajan Pro 3", 0, 10)); // NOI18N
        jLabel1.setText("Kembalian (Rp.)");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(670, 510, 100, 30);

        txtkembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkembalianActionPerformed(evt);
            }
        });
        getContentPane().add(txtkembalian);
        txtkembalian.setBounds(840, 510, 110, 30);

        txtnamapelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamapelangganActionPerformed(evt);
            }
        });
        getContentPane().add(txtnamapelanggan);
        txtnamapelanggan.setBounds(380, 80, 160, 30);

        ckm1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ckm1.setText("Pecel Ayam");
        ckm1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckm1ActionPerformed(evt);
            }
        });
        getContentPane().add(ckm1);
        ckm1.setBounds(250, 180, 100, 20);

        ckm2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ckm2.setText("Ayam Crispy");
        ckm2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckm2ActionPerformed(evt);
            }
        });
        getContentPane().add(ckm2);
        ckm2.setBounds(250, 210, 100, 20);

        ckm3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ckm3.setText("Soto");
        ckm3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckm3ActionPerformed(evt);
            }
        });
        getContentPane().add(ckm3);
        ckm3.setBounds(250, 240, 100, 20);

        ckm4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ckm4.setText("Mie Rebus");
        ckm4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckm4ActionPerformed(evt);
            }
        });
        getContentPane().add(ckm4);
        ckm4.setBounds(250, 270, 100, 20);

        ckm5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ckm5.setText("Mie Goreng");
        ckm5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckm5ActionPerformed(evt);
            }
        });
        getContentPane().add(ckm5);
        ckm5.setBounds(250, 300, 100, 20);

        txtjmlm1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjmlm1ActionPerformed(evt);
            }
        });
        getContentPane().add(txtjmlm1);
        txtjmlm1.setBounds(380, 170, 50, 30);

        txtjmlm2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjmlm2ActionPerformed(evt);
            }
        });
        getContentPane().add(txtjmlm2);
        txtjmlm2.setBounds(380, 200, 50, 30);

        txtjmlm3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjmlm3ActionPerformed(evt);
            }
        });
        getContentPane().add(txtjmlm3);
        txtjmlm3.setBounds(380, 230, 50, 30);

        txtjmlm4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjmlm4ActionPerformed(evt);
            }
        });
        getContentPane().add(txtjmlm4);
        txtjmlm4.setBounds(380, 260, 50, 30);

        txtjmlm5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjmlm5ActionPerformed(evt);
            }
        });
        getContentPane().add(txtjmlm5);
        txtjmlm5.setBounds(380, 290, 50, 30);

        tbltrans.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Transaksi", "No Pelanggan", "Jumlah Pesanan", "Tanggal Transaksi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbltrans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbltransMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbltrans);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(660, 120, 390, 200);

        txtidtrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidtransActionPerformed(evt);
            }
        });
        txtidtrans.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtidtransKeyPressed(evt);
            }
        });
        getContentPane().add(txtidtrans);
        txtidtrans.setBounds(380, 40, 160, 30);

        txttotalharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalhargaActionPerformed(evt);
            }
        });
        getContentPane().add(txttotalharga);
        txttotalharga.setBounds(770, 380, 250, 30);

        txtjmlbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjmlbayarActionPerformed(evt);
            }
        });
        getContentPane().add(txtjmlbayar);
        txtjmlbayar.setBounds(800, 430, 180, 30);

        jLabel8.setFont(new java.awt.Font("Trajan Pro 3", 0, 10)); // NOI18N
        jLabel8.setText("Total Harga  (Rp.)");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(660, 380, 110, 30);

        jLabel9.setFont(new java.awt.Font("Trajan Pro 3", 0, 10)); // NOI18N
        jLabel9.setText("Jumlah Bayar (Rp.)");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(660, 430, 120, 30);

        btnhitung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/hitung.png"))); // NOI18N
        btnhitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhitungActionPerformed(evt);
            }
        });
        getContentPane().add(btnhitung);
        btnhitung.setBounds(810, 330, 60, 50);

        btnkembalian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/hitung.png"))); // NOI18N
        btnkembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkembalianActionPerformed(evt);
            }
        });
        getContentPane().add(btnkembalian);
        btnkembalian.setBounds(860, 460, 60, 50);

        btnreset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/reset.png"))); // NOI18N
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });
        getContentPane().add(btnreset);
        btnreset.setBounds(920, 330, 60, 50);

        btninsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/order.png"))); // NOI18N
        btninsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninsertActionPerformed(evt);
            }
        });
        getContentPane().add(btninsert);
        btninsert.setBounds(800, 540, 60, 60);

        btnupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/update.png"))); // NOI18N
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnupdate);
        btnupdate.setBounds(930, 540, 60, 60);

        btnprint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/print.png"))); // NOI18N
        btnprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprintActionPerformed(evt);
            }
        });
        getContentPane().add(btnprint);
        btnprint.setBounds(910, 610, 60, 50);

        btndelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Delete.png"))); // NOI18N
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btndelete);
        btndelete.setBounds(820, 610, 60, 50);

        ckn2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ckn2.setText("Teh Es");
        ckn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckn2ActionPerformed(evt);
            }
        });
        getContentPane().add(ckn2);
        ckn2.setBounds(270, 460, 110, 20);

        ckn3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ckn3.setText("Teh Panas");
        ckn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckn3ActionPerformed(evt);
            }
        });
        getContentPane().add(ckn3);
        ckn3.setBounds(270, 490, 110, 20);

        ckn4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ckn4.setText("Kofe");
        ckn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckn4ActionPerformed(evt);
            }
        });
        getContentPane().add(ckn4);
        ckn4.setBounds(270, 520, 110, 20);

        ckn5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ckn5.setText("Es Kosong");
        ckn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckn5ActionPerformed(evt);
            }
        });
        getContentPane().add(ckn5);
        ckn5.setBounds(270, 550, 110, 20);

        ckn6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ckn6.setText("Juice Orange");
        ckn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckn6ActionPerformed(evt);
            }
        });
        getContentPane().add(ckn6);
        ckn6.setBounds(270, 580, 110, 20);

        ckn7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ckn7.setText("Juice Naga");
        ckn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckn7ActionPerformed(evt);
            }
        });
        getContentPane().add(ckn7);
        ckn7.setBounds(460, 430, 110, 20);

        ckn8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ckn8.setText("Juice Mangga");
        ckn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckn8ActionPerformed(evt);
            }
        });
        getContentPane().add(ckn8);
        ckn8.setBounds(460, 460, 110, 20);

        ckn9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ckn9.setText("Juice Wortel");
        ckn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckn9ActionPerformed(evt);
            }
        });
        getContentPane().add(ckn9);
        ckn9.setBounds(460, 490, 110, 20);

        ckn10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ckn10.setText("Nutrisari");
        ckn10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckn10ActionPerformed(evt);
            }
        });
        getContentPane().add(ckn10);
        ckn10.setBounds(460, 520, 110, 20);

        ckn11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ckn11.setText("Capucino");
        ckn11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckn11ActionPerformed(evt);
            }
        });
        getContentPane().add(ckn11);
        ckn11.setBounds(460, 550, 110, 20);

        ckn1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ckn1.setText("Teh Manis");
        ckn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckn1ActionPerformed(evt);
            }
        });
        getContentPane().add(ckn1);
        ckn1.setBounds(270, 430, 110, 20);

        txtjmlmi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjmlmi2ActionPerformed(evt);
            }
        });
        getContentPane().add(txtjmlmi2);
        txtjmlmi2.setBounds(390, 450, 50, 30);

        txtjmlmi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjmlmi1ActionPerformed(evt);
            }
        });
        getContentPane().add(txtjmlmi1);
        txtjmlmi1.setBounds(390, 420, 50, 30);

        txtjmlmi4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjmlmi4ActionPerformed(evt);
            }
        });
        getContentPane().add(txtjmlmi4);
        txtjmlmi4.setBounds(390, 510, 50, 30);

        txtjmlmi3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjmlmi3ActionPerformed(evt);
            }
        });
        getContentPane().add(txtjmlmi3);
        txtjmlmi3.setBounds(390, 480, 50, 30);

        txtjmlmi6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjmlmi6ActionPerformed(evt);
            }
        });
        getContentPane().add(txtjmlmi6);
        txtjmlmi6.setBounds(390, 570, 50, 30);

        txtjmlmi5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjmlmi5ActionPerformed(evt);
            }
        });
        getContentPane().add(txtjmlmi5);
        txtjmlmi5.setBounds(390, 540, 50, 30);

        txtjmlmi8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjmlmi8ActionPerformed(evt);
            }
        });
        getContentPane().add(txtjmlmi8);
        txtjmlmi8.setBounds(580, 450, 50, 30);

        txtjmlmi7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjmlmi7ActionPerformed(evt);
            }
        });
        getContentPane().add(txtjmlmi7);
        txtjmlmi7.setBounds(580, 420, 50, 30);

        txtjmlmi10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjmlmi10ActionPerformed(evt);
            }
        });
        getContentPane().add(txtjmlmi10);
        txtjmlmi10.setBounds(580, 510, 50, 30);

        txtjmlmi9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjmlmi9ActionPerformed(evt);
            }
        });
        getContentPane().add(txtjmlmi9);
        txtjmlmi9.setBounds(580, 480, 50, 30);

        txtjmlmi11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjmlmi11ActionPerformed(evt);
            }
        });
        getContentPane().add(txtjmlmi11);
        txtjmlmi11.setBounds(580, 540, 50, 30);

        ckm6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ckm6.setText("MieNas");
        ckm6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckm6ActionPerformed(evt);
            }
        });
        getContentPane().add(ckm6);
        ckm6.setBounds(250, 330, 100, 20);

        ckm7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ckm7.setText("Nasi Goreng");
        ckm7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckm7ActionPerformed(evt);
            }
        });
        getContentPane().add(ckm7);
        ckm7.setBounds(250, 360, 100, 20);

        ckm8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ckm8.setText("Lontong Gulai");
        ckm8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckm8ActionPerformed(evt);
            }
        });
        getContentPane().add(ckm8);
        ckm8.setBounds(450, 180, 111, 20);

        ckm9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ckm9.setText("Lontong Pical");
        ckm9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckm9ActionPerformed(evt);
            }
        });
        getContentPane().add(ckm9);
        ckm9.setBounds(450, 210, 110, 20);

        ckm10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ckm10.setText("Lontong Mie");
        ckm10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckm10ActionPerformed(evt);
            }
        });
        getContentPane().add(ckm10);
        ckm10.setBounds(450, 240, 110, 20);

        ckm11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ckm11.setText("Nasi");
        ckm11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckm11ActionPerformed(evt);
            }
        });
        getContentPane().add(ckm11);
        ckm11.setBounds(450, 270, 110, 20);

        ckm12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ckm12.setText("Ayam Goreng");
        ckm12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckm12ActionPerformed(evt);
            }
        });
        getContentPane().add(ckm12);
        ckm12.setBounds(450, 300, 110, 20);

        ckm13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ckm13.setText("Ayam Gulai");
        ckm13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckm13ActionPerformed(evt);
            }
        });
        getContentPane().add(ckm13);
        ckm13.setBounds(450, 330, 110, 20);

        ckm14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ckm14.setText("Gorengan");
        ckm14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckm14ActionPerformed(evt);
            }
        });
        getContentPane().add(ckm14);
        ckm14.setBounds(450, 360, 110, 20);

        txtjmlm6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjmlm6ActionPerformed(evt);
            }
        });
        getContentPane().add(txtjmlm6);
        txtjmlm6.setBounds(380, 320, 50, 30);

        txtjmlm8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjmlm8ActionPerformed(evt);
            }
        });
        getContentPane().add(txtjmlm8);
        txtjmlm8.setBounds(580, 170, 50, 30);

        txtjmlm7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjmlm7ActionPerformed(evt);
            }
        });
        getContentPane().add(txtjmlm7);
        txtjmlm7.setBounds(380, 350, 50, 30);

        txtjmlm10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjmlm10ActionPerformed(evt);
            }
        });
        getContentPane().add(txtjmlm10);
        txtjmlm10.setBounds(580, 230, 50, 30);

        txtjmlm9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjmlm9ActionPerformed(evt);
            }
        });
        getContentPane().add(txtjmlm9);
        txtjmlm9.setBounds(580, 200, 50, 30);

        txtjmlm12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjmlm12ActionPerformed(evt);
            }
        });
        getContentPane().add(txtjmlm12);
        txtjmlm12.setBounds(580, 290, 50, 30);

        txtjmlm11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjmlm11ActionPerformed(evt);
            }
        });
        getContentPane().add(txtjmlm11);
        txtjmlm11.setBounds(580, 260, 50, 30);

        txtjmlm14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjmlm14ActionPerformed(evt);
            }
        });
        getContentPane().add(txtjmlm14);
        txtjmlm14.setBounds(580, 350, 50, 30);

        txtjmlm13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjmlm13ActionPerformed(evt);
            }
        });
        getContentPane().add(txtjmlm13);
        txtjmlm13.setBounds(580, 320, 50, 30);

        lbnamakasir.setFont(new java.awt.Font("Vivaldi", 1, 24)); // NOI18N
        lbnamakasir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbnamakasir.setText("nama Kasir");
        getContentPane().add(lbnamakasir);
        lbnamakasir.setBounds(830, 0, 210, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Nama Pelanggan ");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(260, 80, 120, 30);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Id Transaksi");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(260, 40, 97, 30);

        btnreport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/iconReportNow.png"))); // NOI18N
        btnreport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreportActionPerformed(evt);
            }
        });
        getContentPane().add(btnreport);
        btnreport.setBounds(890, 80, 150, 40);

        btnhome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Iconhome.png"))); // NOI18N
        btnhome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhomeActionPerformed(evt);
            }
        });
        getContentPane().add(btnhome);
        btnhome.setBounds(10, 10, 60, 60);

        btnlogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Iconlogout2.png"))); // NOI18N
        btnlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogoutActionPerformed(evt);
            }
        });
        getContentPane().add(btnlogout);
        btnlogout.setBounds(890, 40, 150, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Menubarak.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1054, 669);

        setBounds(0, 0, 1069, 707);
    }// </editor-fold>//GEN-END:initComponents

    private void txtkembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkembalianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkembalianActionPerformed

    private void txtnamapelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamapelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamapelangganActionPerformed

    private void ckm1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckm1ActionPerformed
        // TODO add your handling code here:
        if(ckm1.isSelected()==true){
        txtjmlm1.setEditable(true);
        }else{txtjmlm1.setEditable(false);
        txtjmlm1.setText("");}
    }//GEN-LAST:event_ckm1ActionPerformed

    private void ckm2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckm2ActionPerformed
        // TODO add your handling code here:
        if(ckm2.isSelected()==true){
        txtjmlm2.setEditable(true);
        }else{txtjmlm2.setEditable(false);
        txtjmlm2.setText("");}
    }//GEN-LAST:event_ckm2ActionPerformed

    private void ckm3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckm3ActionPerformed
        // TODO add your handling code here:
        if(ckm3.isSelected()==true){
        txtjmlm3.setEditable(true);
        }else{txtjmlm3.setEditable(false);
        txtjmlm3.setText("");}
    }//GEN-LAST:event_ckm3ActionPerformed

    private void ckm4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckm4ActionPerformed
        // TODO add your handling code here:
        if(ckm4.isSelected()==true){
        txtjmlm4.setEditable(true);
        }else{txtjmlm4.setEditable(false);
        txtjmlm4.setText("");}
    }//GEN-LAST:event_ckm4ActionPerformed

    private void ckm5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckm5ActionPerformed
        // TODO add your handling code here:
        if(ckm5.isSelected()==true){
        txtjmlm5.setEditable(true);
        }else{txtjmlm5.setEditable(false);
        txtjmlm5.setText("");}
    }//GEN-LAST:event_ckm5ActionPerformed

    private void txtjmlm1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjmlm1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjmlm1ActionPerformed

    private void txtjmlm2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjmlm2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjmlm2ActionPerformed

    private void txtjmlm3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjmlm3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjmlm3ActionPerformed

    private void txtjmlm4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjmlm4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjmlm4ActionPerformed

    private void txtjmlm5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjmlm5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjmlm5ActionPerformed

    private void txtidtransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidtransActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidtransActionPerformed

    private void txttotalhargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalhargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalhargaActionPerformed

    private void txtjmlbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjmlbayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjmlbayarActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        // TODO add your handling code here:
        controler.Reset();
    }//GEN-LAST:event_btnresetActionPerformed

    private void btnhitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhitungActionPerformed
        // TODO add your handling code here:
        controler.Hitung();
    }//GEN-LAST:event_btnhitungActionPerformed

    private void btnkembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkembalianActionPerformed
        // TODO add your handling code here:
        controler.Kembalian();
    }//GEN-LAST:event_btnkembalianActionPerformed

    private void btninsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninsertActionPerformed
        // TODO add your handling code here:
        controler.setPelanggan();
        controler.Insert();
        controler.tampil_daftar();
    }//GEN-LAST:event_btninsertActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        controler.Update();
        controler.tampil_daftar();
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
        controler.Delete();
        controler.tampil_daftar();
    }//GEN-LAST:event_btndeleteActionPerformed

    private void ckn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckn2ActionPerformed
        // TODO add your handling code here:
        if(ckn2.isSelected()==true){
        txtjmlmi2.setEditable(true);
        }else{txtjmlmi2.setEditable(false);
        txtjmlmi2.setText("");}
    }//GEN-LAST:event_ckn2ActionPerformed

    private void ckn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckn3ActionPerformed
        // TODO add your handling code here:
        if(ckn3.isSelected()==true){
        txtjmlmi3.setEditable(true);
        }else{txtjmlmi3.setEditable(false);
        txtjmlmi3.setText("");}

    }//GEN-LAST:event_ckn3ActionPerformed

    private void ckn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckn4ActionPerformed
        // TODO add your handling code here:
        if(ckn4.isSelected()==true){
        txtjmlmi4.setEditable(true);
        }else{txtjmlmi4.setEditable(false);
        txtjmlmi4.setText("");}

    }//GEN-LAST:event_ckn4ActionPerformed

    private void ckn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckn5ActionPerformed
        // TODO add your handling code here:
        if(ckn5.isSelected()==true){
        txtjmlmi5.setEditable(true);
        }else{txtjmlmi5.setEditable(false);
        txtjmlmi5.setText("");}

    }//GEN-LAST:event_ckn5ActionPerformed

    private void ckn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckn6ActionPerformed
        // TODO add your handling code here:
        if(ckn6.isSelected()==true){
        txtjmlmi6.setEditable(true);
        }else{txtjmlmi6.setEditable(false);
        txtjmlmi6.setText("");}

    }//GEN-LAST:event_ckn6ActionPerformed

    private void ckn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckn7ActionPerformed
        // TODO add your handling code here:
        if(ckn7.isSelected()==true){
        txtjmlmi7.setEditable(true);
        }else{txtjmlmi7.setEditable(false);
        txtjmlmi7.setText("");}

    }//GEN-LAST:event_ckn7ActionPerformed

    private void ckn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckn8ActionPerformed
        // TODO add your handling code here:
        if(ckn8.isSelected()==true){
        txtjmlmi8.setEditable(true);
        }else{txtjmlmi8.setEditable(false);
        txtjmlmi8.setText("");}

    }//GEN-LAST:event_ckn8ActionPerformed

    private void ckn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckn9ActionPerformed
        // TODO add your handling code here:
        if(ckn9.isSelected()==true){
        txtjmlmi9.setEditable(true);
        }else{txtjmlmi9.setEditable(false);
        txtjmlmi9.setText("");}

    }//GEN-LAST:event_ckn9ActionPerformed

    private void ckn10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckn10ActionPerformed
        // TODO add your handling code here:
        if(ckn10.isSelected()==true){
        txtjmlmi10.setEditable(true);
        }else{txtjmlmi10.setEditable(false);
        txtjmlmi10.setText("");}

    }//GEN-LAST:event_ckn10ActionPerformed

    private void ckn11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckn11ActionPerformed
        // TODO add your handling code here:
        if(ckn11.isSelected()==true){
        txtjmlmi11.setEditable(true);
        }else{txtjmlmi11.setEditable(false);
        txtjmlmi11.setText("");}

    }//GEN-LAST:event_ckn11ActionPerformed

    private void ckn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckn1ActionPerformed
        // TODO add your handling code here:
        if(ckn1.isSelected()==true){
        txtjmlmi1.setEditable(true);
        }else{txtjmlmi1.setEditable(false);
        txtjmlmi1.setText("");}
    }//GEN-LAST:event_ckn1ActionPerformed

    private void txtjmlmi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjmlmi2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtjmlmi2ActionPerformed

    private void txtjmlmi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjmlmi1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjmlmi1ActionPerformed

    private void txtjmlmi4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjmlmi4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjmlmi4ActionPerformed

    private void txtjmlmi3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjmlmi3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjmlmi3ActionPerformed

    private void txtjmlmi6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjmlmi6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjmlmi6ActionPerformed

    private void txtjmlmi5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjmlmi5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjmlmi5ActionPerformed

    private void txtjmlmi8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjmlmi8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjmlmi8ActionPerformed

    private void txtjmlmi7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjmlmi7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjmlmi7ActionPerformed

    private void txtjmlmi10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjmlmi10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjmlmi10ActionPerformed

    private void txtjmlmi9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjmlmi9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjmlmi9ActionPerformed

    private void txtjmlmi11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjmlmi11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjmlmi11ActionPerformed

    private void ckm6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckm6ActionPerformed
        // TODO add your handling code here:
        if(ckm6.isSelected()==true){
        txtjmlm6.setEditable(true);
        }else{txtjmlm6.setEditable(false);
        txtjmlm6.setText("");}

    }//GEN-LAST:event_ckm6ActionPerformed

    private void ckm7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckm7ActionPerformed
        // TODO add your handling code here:
        if(ckm7.isSelected()==true){
        txtjmlm7.setEditable(true);
        }else{txtjmlm7.setEditable(false);
        txtjmlm7.setText("");}

    }//GEN-LAST:event_ckm7ActionPerformed

    private void ckm8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckm8ActionPerformed
        // TODO add your handling code here:
        if(ckm8.isSelected()==true){
        txtjmlm8.setEditable(true);
        }else{txtjmlm8.setEditable(false);
        txtjmlm8.setText("");}
    }//GEN-LAST:event_ckm8ActionPerformed

    private void ckm9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckm9ActionPerformed
        // TODO add your handling code here:
        if(ckm9.isSelected()==true){
        txtjmlm9.setEditable(true);
        }else{txtjmlm9.setEditable(false);
        txtjmlm9.setText("");}

    }//GEN-LAST:event_ckm9ActionPerformed

    private void ckm10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckm10ActionPerformed
        // TODO add your handling code here:
        if(ckm10.isSelected()==true){
        txtjmlm10.setEditable(true);
        }else{txtjmlm10.setEditable(false);
        txtjmlm10.setText("");}
    }//GEN-LAST:event_ckm10ActionPerformed

    private void ckm11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckm11ActionPerformed
        // TODO add your handling code here:
        if(ckm11.isSelected()==true){
        txtjmlm11.setEditable(true);
        }else{txtjmlm11.setEditable(false);
        txtjmlm11.setText("");}
    }//GEN-LAST:event_ckm11ActionPerformed

    private void ckm12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckm12ActionPerformed
        // TODO add your handling code here:
        if(ckm12.isSelected()==true){
        txtjmlm12.setEditable(true);
        }else{txtjmlm12.setEditable(false);
        txtjmlm12.setText("");}

    }//GEN-LAST:event_ckm12ActionPerformed

    private void ckm13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckm13ActionPerformed
        // TODO add your handling code here:
        if(ckm13.isSelected()==true){
        txtjmlm13.setEditable(true);
        }else{txtjmlm13.setEditable(false);
        txtjmlm13.setText("");}
    }//GEN-LAST:event_ckm13ActionPerformed

    private void ckm14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckm14ActionPerformed
        // TODO add your handling code here:
        if(ckm14.isSelected()==true){
        txtjmlm14.setEditable(true);
        }else{txtjmlm14.setEditable(false);
        txtjmlm14.setText("");}

    }//GEN-LAST:event_ckm14ActionPerformed

    private void txtjmlm6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjmlm6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjmlm6ActionPerformed

    private void txtjmlm8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjmlm8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjmlm8ActionPerformed

    private void txtjmlm7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjmlm7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjmlm7ActionPerformed

    private void txtjmlm10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjmlm10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjmlm10ActionPerformed

    private void txtjmlm9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjmlm9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjmlm9ActionPerformed

    private void txtjmlm12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjmlm12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjmlm12ActionPerformed

    private void txtjmlm11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjmlm11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjmlm11ActionPerformed

    private void txtjmlm14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjmlm14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjmlm14ActionPerformed

    private void txtjmlm13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjmlm13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjmlm13ActionPerformed

    private void tbltransMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbltransMouseClicked
        // TODO add your handling code here:
        controler.tablecliock();
    }//GEN-LAST:event_tbltransMouseClicked

    private void txtidtransKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidtransKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode()== KeyEvent.VK_ENTER) {
            controler.onKeyPressIdtrans();
        }
    }//GEN-LAST:event_txtidtransKeyPressed

    private void btnhomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhomeActionPerformed
        // TODO add your handling code here:
        home = new FormHome();
        home.getLbidkasir().setText(id_kasir);
        home.getLbnamakasir().setText(lbnamakasir.getText());
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnhomeActionPerformed

    private void btnreportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreportActionPerformed
        // TODO add your handling code here:
        report = new FormReport1();
        report.setId_kasir(id_kasir);
        report.setNamakasir(lbnamakasir.getText());
        report.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnreportActionPerformed

    private void btnprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprintActionPerformed
        // TODO add your handling code here:
       controler.cetakNota();
    }//GEN-LAST:event_btnprintActionPerformed

    private void btnlogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogoutActionPerformed
        // TODO add your handling code here:
        login = new FormLogin();
        int opsi = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Untuk Logout ?");
        switch(opsi){
            case JOptionPane.YES_OPTION:
                JOptionPane.showMessageDialog(null, "Logout");
                login.setVisible(true);
                dispose();
                break;
            case JOptionPane.NO_OPTION:
                JOptionPane.showMessageDialog(null, "Gagal Logout");
                break;
            default:
                break;
        }
        
    }//GEN-LAST:event_btnlogoutActionPerformed

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
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnhitung;
    private javax.swing.JButton btnhome;
    private javax.swing.JButton btninsert;
    private javax.swing.JButton btnkembalian;
    private javax.swing.JButton btnlogout;
    private javax.swing.JButton btnprint;
    private javax.swing.JButton btnreport;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnupdate;
    private javax.swing.JCheckBox ckm1;
    private javax.swing.JCheckBox ckm10;
    private javax.swing.JCheckBox ckm11;
    private javax.swing.JCheckBox ckm12;
    private javax.swing.JCheckBox ckm13;
    private javax.swing.JCheckBox ckm14;
    private javax.swing.JCheckBox ckm2;
    private javax.swing.JCheckBox ckm3;
    private javax.swing.JCheckBox ckm4;
    private javax.swing.JCheckBox ckm5;
    private javax.swing.JCheckBox ckm6;
    private javax.swing.JCheckBox ckm7;
    private javax.swing.JCheckBox ckm8;
    private javax.swing.JCheckBox ckm9;
    private javax.swing.JCheckBox ckn1;
    private javax.swing.JCheckBox ckn10;
    private javax.swing.JCheckBox ckn11;
    private javax.swing.JCheckBox ckn2;
    private javax.swing.JCheckBox ckn3;
    private javax.swing.JCheckBox ckn4;
    private javax.swing.JCheckBox ckn5;
    private javax.swing.JCheckBox ckn6;
    private javax.swing.JCheckBox ckn7;
    private javax.swing.JCheckBox ckn8;
    private javax.swing.JCheckBox ckn9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbnamakasir;
    private javax.swing.JTable tbltrans;
    private javax.swing.JTextField txtidtrans;
    private javax.swing.JTextField txtjmlbayar;
    private javax.swing.JTextField txtjmlm1;
    private javax.swing.JTextField txtjmlm10;
    private javax.swing.JTextField txtjmlm11;
    private javax.swing.JTextField txtjmlm12;
    private javax.swing.JTextField txtjmlm13;
    private javax.swing.JTextField txtjmlm14;
    private javax.swing.JTextField txtjmlm2;
    private javax.swing.JTextField txtjmlm3;
    private javax.swing.JTextField txtjmlm4;
    private javax.swing.JTextField txtjmlm5;
    private javax.swing.JTextField txtjmlm6;
    private javax.swing.JTextField txtjmlm7;
    private javax.swing.JTextField txtjmlm8;
    private javax.swing.JTextField txtjmlm9;
    private javax.swing.JTextField txtjmlmi1;
    private javax.swing.JTextField txtjmlmi10;
    private javax.swing.JTextField txtjmlmi11;
    private javax.swing.JTextField txtjmlmi2;
    private javax.swing.JTextField txtjmlmi3;
    private javax.swing.JTextField txtjmlmi4;
    private javax.swing.JTextField txtjmlmi5;
    private javax.swing.JTextField txtjmlmi6;
    private javax.swing.JTextField txtjmlmi7;
    private javax.swing.JTextField txtjmlmi8;
    private javax.swing.JTextField txtjmlmi9;
    private javax.swing.JTextField txtkembalian;
    private javax.swing.JTextField txtnamapelanggan;
    private javax.swing.JTextField txttotalharga;
    // End of variables declaration//GEN-END:variables
}
