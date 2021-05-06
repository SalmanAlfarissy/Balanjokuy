/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BJK.controler;
import BJK.form.FormNewKasir;
import BJK.model.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import BJK.form.FormLogin;
import BJK.model.Pelanggan;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Salman Alfarissy
 */
public class ControllerNewKasir {
    private FormNewKasir newkasir;
    private FormLogin login;
    private koneksi k;
    Connection conn = k.getKoneksi();
    private DefaultTableModel tabmode;

    public ControllerNewKasir(FormNewKasir newkasir) {
        this.newkasir = newkasir;
    }
     private void hapuslayar(){         
        newkasir.getTxtidkasir().setText("");         
        newkasir.getTxtnamakasir().setText("");         
        newkasir.getTxtidkasir1().setText("");         
        newkasir.getTxtnamakasir1().setText("");         
        newkasir.getTxtpasswd().setText("");            
        newkasir.getTxtalamat().setText("");     
     }
     public void delete(){
        int opsi = JOptionPane.showConfirmDialog(newkasir, "Benarkah anda ingin menghapus data ini ?");
        switch(opsi){
            case JOptionPane.YES_OPTION:
             
             try {
             if(newkasir.getTxtidkasir1().getText().equals("") || newkasir.getTxtnamakasir1().getText().equals("")){
                 JOptionPane.showMessageDialog(newkasir, "Data Tidak Boleh Kosong", "Pesan", JOptionPane.ERROR_MESSAGE);                  
             }else{
              String sql = "DELETE from tkasir where idkasir = ? and  namakasir = ?";
              PreparedStatement ps = conn.prepareStatement(sql);
              ps.setString(1, newkasir.getTxtidkasir1().getText());
              ps.setString(2, newkasir.getTxtnamakasir1().getText());
              ps.executeUpdate();
              JOptionPane.showMessageDialog(newkasir, "Data Sukses Terhapus!!");
              tampil_daftar();
              hapuslayar();
              
             }
            
            } catch (Exception e) {
            }
                break;
            case JOptionPane.NO_OPTION:
                JOptionPane.showMessageDialog(newkasir, "Data Gagal Terhapus!!");;
                hapuslayar();
                break;
            default:
                break;
        }
         
     }
    
    public void create(){
        login = new FormLogin();
        try {
             if(newkasir.getTxtidkasir().getText().equals("") || newkasir.getTxtnamakasir().getText().equals("") || newkasir.getTxtpasswd().getText().equals("") || newkasir.getTxtalamat().getText().equals("")){
                 JOptionPane.showMessageDialog(newkasir, "Data Tidak Boleh Kosong", "Pesan", JOptionPane.ERROR_MESSAGE);                  
                 
             } else {
                String passwd = newkasir.getTxtpasswd().getText(); 
                String sql = "insert into tkasir values (?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(sql);
              
                ps.setString(1, newkasir.getTxtidkasir().getText());
                ps.setString(2, newkasir.getTxtnamakasir().getText());
                ps.setString(3, passwd);
                ps.setString(4, newkasir.getTxtalamat().getText());
                
                ps.executeUpdate();  
                JOptionPane.showMessageDialog(login, "Data Tersimpan",
                        "Image icon",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/gambar/Save.png"));                 
                newkasir.setVisible(false);                
                login.setVisible(true); 
             }
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(newkasir,"This Account is Already exist / Akun Sudah ada ", "Pesan", JOptionPane.WARNING_MESSAGE);   
             hapuslayar();
        }
    }
    public void tampil_daftar(){
        Object[]baris = {"Id Kasir","Nama Kasir" ,"Alamat"};
        tabmode= new DefaultTableModel(null, baris);
        newkasir.getTblkasir().setModel(tabmode);
        String sql = "SELECT * from tkasir order by idkasir asc";
        try { 
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String idkasir = hasil.getString("idkasir");
                String namakasir = hasil.getString("namakasir");
                String alamat = hasil.getString("alamat");
                
                
                String[]data = {idkasir,namakasir ,alamat};
                tabmode.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Menampilkan data GAGAL", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void tablecliock(){
        hapuslayar();
        int Tblkasir = newkasir.getTblkasir().getSelectedRow();
        String idkasir = newkasir.getTblkasir().getValueAt(Tblkasir, 0).toString();
        String namakasir = newkasir.getTblkasir().getValueAt(Tblkasir, 1).toString();
        newkasir.getTxtidkasir1().setText(idkasir);
        newkasir.getTxtnamakasir1().setText(namakasir);
        } 
    
    public void onKeyPresstxtnamakasir(){
        newkasir.getTxtidkasir().requestFocus();
    }
    public void onKeyPresstxtidkasir(){
        newkasir.getTxtalamat().requestFocus();
    }
    public void onKeyPresstxtalamat(){
        newkasir.getTxtpasswd().requestFocus();
    }
    public void onKeyPresstxtpasswd(){
        newkasir.getBtncreate().requestFocus();
    }
    public void onKeyPresstxtnamakasir1(){
        newkasir.getTxtidkasir1().requestFocus();
    }
    public void onKeyPresstxtidkasir1(){
        newkasir.getBtndelete().requestFocus();
    }

}
