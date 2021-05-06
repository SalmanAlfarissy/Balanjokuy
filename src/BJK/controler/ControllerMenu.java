/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BJK.controler;
import BJK.form.FormMenu;
import BJK.model.Menu;
import BJK.model.Pelanggan;
import BJK.model.koneksi;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import BJK.model.Transaksi;
import BJK.model.Detailtrans;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author Salman Alfarissy
 */
public class ControllerMenu {
    private FormMenu menu;
    private koneksi koneksi;
    Connection conn = koneksi.getKoneksi();
    int jml_bayar,totalhrg,kembalian;
    private Pelanggan pelanggan;
    private Transaksi transaksi;
    private Detailtrans detail;
    private DefaultTableModel tabmode;
    
    
    public ControllerMenu(FormMenu menu) {
        this.menu = menu;
    }
    
    public void tampil_daftar(){
        Object[]baris = {"Id Transaksi","No Pelanggan" ,"Jumlah Pesanan", "Tanggal Transaksi"};
        tabmode= new DefaultTableModel(null, baris);
        menu.getTbltrans().setModel(tabmode);
        String sql = "SELECT * from ttrans order by id_trans asc";
        try { 
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String Id_trans = hasil.getString("id_trans");
                String nopel = hasil.getString("nopel");
                String jml_pesanan = hasil.getString("jml_pesanan");
                String Tgl_trans = hasil.getString("tgltrans");
                
                String[]data = {Id_trans,nopel ,jml_pesanan, Tgl_trans};
                tabmode.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Menampilkan data GAGAL", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void tablecliock(){
        Reset();
        int Tbltrans = menu.getTbltrans().getSelectedRow();
        String id_trans = menu.getTbltrans().getValueAt(Tbltrans, 0).toString();
        String nopel = menu.getTbltrans().getValueAt(Tbltrans, 1).toString();
        
        try {
            pelanggan = new Pelanggan();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from tpelanggan where nopel='"+nopel+
                    "'");
            
            while (rs.next()) {
              pelanggan.setNopel(rs.getString(1));
              pelanggan.setNamapelanggan(rs.getString(2));
            }
            menu.getTxtnamapelanggan().setText(pelanggan.getNamapelanggan());
        } catch (Exception e) {   
        } 
        
        try {
            transaksi = new Transaksi();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from ttrans where id_trans='"+id_trans+
                    "'");
            
            while (rs.next()) {
              transaksi.setId_trans(rs.getString(1));
              transaksi.setTgltrans(rs.getString(3));
              transaksi.setJmlpesanan(rs.getString(4));
              transaksi.setTotalbyr(rs.getString(5));
              transaksi.setJml_byr(rs.getString(6));
            }
            menu.getTxtidtrans().setText(transaksi.getId_trans());
            menu.getTxttotalharga().setText(transaksi.getTotalbyr());
            menu.getTxtjmlbayar().setText(transaksi.getJml_byr());
            int totalharga =Integer.parseInt(transaksi.getTotalbyr());
            int jumlahbayar =Integer.parseInt(transaksi.getJml_byr());
            int kembalian = jumlahbayar-totalharga;
            menu.getTxtkembalian().setText(String.valueOf(kembalian));
            
        } catch (Exception e) {   
        }
        
        try {
            detail = new Detailtrans();
   
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from detail_trans where id_trans='"+id_trans+
                    "'");
           
            while (rs.next()) {
                
                
              detail.setId_trans(rs.getString(1));
              detail.setKode_menu(rs.getString(2));
              detail.setJml_terjual(rs.getString(3));
              detail.setKeuntungan(rs.getString(4));
              detail.setIdkasir(rs.getString(5));
                
              

                
                if (detail.getKode_menu().equals("M001")) {
                menu.getCkm1().setSelected(true);
                menu.getTxtjmlm1().setText(detail.getJml_terjual());
                }
                if (detail.getKode_menu().equals("M002")) {
                    menu.getCkm2().setSelected(true);
                    menu.getTxtjmlm2().setText(detail.getJml_terjual());
                }
                if (detail.getKode_menu().equals("M003")) {
                    menu.getCkm3().setSelected(true);
                    menu.getTxtjmlm3().setText(detail.getJml_terjual());
                }
              
                if (detail.getKode_menu().equals("M004")) {
                    menu.getCkm4().setSelected(true);
                    menu.getTxtjmlm4().setText(detail.getJml_terjual());
                }
                if (detail.getKode_menu().equals("M005")) {
                    menu.getCkm5().setSelected(true);
                    menu.getTxtjmlm5().setText(detail.getJml_terjual());
                }
                if (detail.getKode_menu().equals("M006")) {
                    menu.getCkm6().setSelected(true);
                    menu.getTxtjmlm6().setText(detail.getJml_terjual());
                }
                
                if (detail.getKode_menu().equals("M007")) {
                menu.getCkm7().setSelected(true);
                menu.getTxtjmlm7().setText(detail.getJml_terjual());
                }
                if (detail.getKode_menu().equals("M008")) {
                    menu.getCkm8().setSelected(true);
                    menu.getTxtjmlm8().setText(detail.getJml_terjual());
                }
                if (detail.getKode_menu().equals("M009")) {
                    menu.getCkm9().setSelected(true);
                    menu.getTxtjmlm9().setText(detail.getJml_terjual());
                }
              
                if (detail.getKode_menu().equals("M010")) {
                    menu.getCkm10().setSelected(true);
                    menu.getTxtjmlm10().setText(detail.getJml_terjual());
                }
                if (detail.getKode_menu().equals("M011")) {
                    menu.getCkm11().setSelected(true);
                    menu.getTxtjmlm11().setText(detail.getJml_terjual());
                }
                if (detail.getKode_menu().equals("M012")) {
                    menu.getCkm12().setSelected(true);
                    menu.getTxtjmlm12().setText(detail.getJml_terjual());
                }
                if (detail.getKode_menu().equals("M013")) {
                    menu.getCkm13().setSelected(true);
                    menu.getTxtjmlm13().setText(detail.getJml_terjual());
                }
                if (detail.getKode_menu().equals("M014")) {
                    menu.getCkm14().setSelected(true);
                    menu.getTxtjmlm14().setText(detail.getJml_terjual());
                }
                
                if (detail.getKode_menu().equals("M101")) {
                menu.getCkn1().setSelected(true);
                menu.getTxtjmlmi1().setText(detail.getJml_terjual());
                }
                if (detail.getKode_menu().equals("M102")) {
                menu.getCkn2().setSelected(true);
                menu.getTxtjmlmi2().setText(detail.getJml_terjual());
                }
                if (detail.getKode_menu().equals("M103")) {
                menu.getCkn3().setSelected(true);
                menu.getTxtjmlmi3().setText(detail.getJml_terjual());
                }
                if (detail.getKode_menu().equals("M104")) {
                menu.getCkn4().setSelected(true);
                menu.getTxtjmlmi4().setText(detail.getJml_terjual());
                }
                if (detail.getKode_menu().equals("M105")) {
                menu.getCkn5().setSelected(true);
                menu.getTxtjmlmi5().setText(detail.getJml_terjual());
                }
                if (detail.getKode_menu().equals("M106")) {
                menu.getCkn6().setSelected(true);
                menu.getTxtjmlmi6().setText(detail.getJml_terjual());
                }
                if (detail.getKode_menu().equals("M107")) {
                menu.getCkn7().setSelected(true);
                menu.getTxtjmlmi7().setText(detail.getJml_terjual());
                }
                if (detail.getKode_menu().equals("M108")) {
                menu.getCkn8().setSelected(true);
                menu.getTxtjmlmi8().setText(detail.getJml_terjual());
                }
                if (detail.getKode_menu().equals("M109")) {
                menu.getCkn9().setSelected(true);
                menu.getTxtjmlmi9().setText(detail.getJml_terjual());
                }
                if (detail.getKode_menu().equals("M110")) {
                menu.getCkn10().setSelected(true);
                menu.getTxtjmlmi10().setText(detail.getJml_terjual());
                }
                if (detail.getKode_menu().equals("M111")) {
                menu.getCkn11().setSelected(true);
                menu.getTxtjmlmi11().setText(detail.getJml_terjual());
                }
            }
        } catch (Exception e) {   
    } 
        
    }

    
    private String gettgl(){
        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return dateformat.format(date);
    }
    
    
    public void Reset(){
        menu.getTxtnamapelanggan().setText("");
        menu.getTxtidtrans().setText("");
        menu.getTxttotalharga().setText("");
        menu.getTxtjmlbayar().setText("");
        menu.getTxtkembalian().setText("");
        
        menu.getCkm1().setSelected(false);
        menu.getTxtjmlm1().setText("");
        
        menu.getCkm2().setSelected(false);
        menu.getTxtjmlm2().setText("");
        
        menu.getCkm3().setSelected(false);
        menu.getTxtjmlm3().setText("");
        
        menu.getCkm4().setSelected(false);
        menu.getTxtjmlm4().setText("");
        
        menu.getCkm5().setSelected(false);
        menu.getTxtjmlm5().setText("");
        
        menu.getCkm6().setSelected(false);
        menu.getTxtjmlm6().setText("");
        
        menu.getCkm7().setSelected(false);
        menu.getTxtjmlm7().setText("");
        
        menu.getCkm8().setSelected(false);
        menu.getTxtjmlm8().setText("");
        
        menu.getCkm9().setSelected(false);
        menu.getTxtjmlm9().setText("");
        
        menu.getCkm10().setSelected(false);
        menu.getTxtjmlm10().setText("");
        
        menu.getCkm11().setSelected(false);
        menu.getTxtjmlm11().setText("");
        
        menu.getCkm12().setSelected(false);
        menu.getTxtjmlm12().setText("");
        
        menu.getCkm13().setSelected(false);
        menu.getTxtjmlm13().setText("");
        
        menu.getCkm14().setSelected(false);
        menu.getTxtjmlm14().setText("");
        
        menu.getCkn1().setSelected(false);
        menu.getTxtjmlmi1().setText("");
        
        menu.getCkn2().setSelected(false);
        menu.getTxtjmlmi2().setText("");
        
        menu.getCkn3().setSelected(false);
        menu.getTxtjmlmi3().setText("");
        
        menu.getCkn4().setSelected(false);
        menu.getTxtjmlmi4().setText("");
        
        menu.getCkn5().setSelected(false);
        menu.getTxtjmlmi5().setText("");
        
        menu.getCkn6().setSelected(false);
        menu.getTxtjmlmi6().setText("");
        
        menu.getCkn7().setSelected(false);
        menu.getTxtjmlmi7().setText("");
        
        menu.getCkn8().setSelected(false);
        menu.getTxtjmlmi8().setText("");
        
        menu.getCkn9().setSelected(false);
        menu.getTxtjmlmi9().setText("");
        
        menu.getCkn10().setSelected(false);
        menu.getTxtjmlmi10().setText("");
        
        menu.getCkn11().setSelected(false);
        menu.getTxtjmlmi11().setText("");
        
    }
    public void setPelanggan(){
        if (menu.getTxtnamapelanggan().getText().toString().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(menu, "maaf tolong isi nama pelanggan terlebih dahulu !!");
        }else{
             try {
            String sql = "INSERT INTO tpelanggan VALUES (?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, null);
            ps.setString(2, menu.getTxtnamapelanggan().getText());
            ps.executeUpdate();
            } catch (Exception e) {
            }
        }  
    }
    
    public void Hitung(){
     
     int total = 0;
     int jmlpesanan = 0;
     
     if(menu.getCkm1().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M001'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan1 = m.getHarga_jual();
       int hrgmakanan1 = Integer.parseInt(makanan1);
       String jml = menu.getTxtjmlm1().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga1  = jumlahpesanan * hrgmakanan1;
       total = total + harga1;
     }
     
     if(menu.getCkm2().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M002'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan2 = m.getHarga_jual();
       int hrgmakanan2 = Integer.parseInt(makanan2);
       String jml = menu.getTxtjmlm2().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga2  = jumlahpesanan * hrgmakanan2;
       total = total + harga2;
     }
     
     if(menu.getCkm3().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M003'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan3 = m.getHarga_jual();
       int hrgmakanan3 = Integer.parseInt(makanan3);
       String jml = menu.getTxtjmlm3().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga3  = jumlahpesanan * hrgmakanan3;
       total = total + harga3;
     }
     
     if(menu.getCkm4().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M004'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan4 = m.getHarga_jual();
       int hrgmakanan4 = Integer.parseInt(makanan4);
       String jml = menu.getTxtjmlm4().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga4  = jumlahpesanan * hrgmakanan4;
       total = total + harga4;
     }
     
     if(menu.getCkm5().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M005'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan5 = m.getHarga_jual();
       int hrgmakanan5 = Integer.parseInt(makanan5);
       String jml = menu.getTxtjmlm5().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga5  = jumlahpesanan * hrgmakanan5;
       total = total + harga5;
     }
     if(menu.getCkm6().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M006'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan6 = m.getHarga_jual();
       int hrgmakanan6 = Integer.parseInt(makanan6);
       String jml = menu.getTxtjmlm6().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga6  = jumlahpesanan * hrgmakanan6;
       total = total + harga6;
     }
     if(menu.getCkm7().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M007'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan7 = m.getHarga_jual();
       int hrgmakanan7 = Integer.parseInt(makanan7);
       String jml = menu.getTxtjmlm7().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga7  = jumlahpesanan * hrgmakanan7;
       total = total + harga7;
     }
     if(menu.getCkm8().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M008'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan8 = m.getHarga_jual();
       int hrgmakanan8 = Integer.parseInt(makanan8);
       String jml = menu.getTxtjmlm8().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga8  = jumlahpesanan * hrgmakanan8;
       total = total + harga8;
     }
     if(menu.getCkm9().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M009'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan9 = m.getHarga_jual();
       int hrgmakanan9 = Integer.parseInt(makanan9);
       String jml = menu.getTxtjmlm9().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga9  = jumlahpesanan * hrgmakanan9;
       total = total + harga9;
     }
     if(menu.getCkm10().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M010'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan10 = m.getHarga_jual();
       int hrgmakanan10 = Integer.parseInt(makanan10);
       String jml = menu.getTxtjmlm10().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga10  = jumlahpesanan * hrgmakanan10;
       total = total + harga10;
     }
     if(menu.getCkm11().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M011'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan11 = m.getHarga_jual();
       int hrgmakanan11 = Integer.parseInt(makanan11);
       String jml = menu.getTxtjmlm11().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga11  = jumlahpesanan * hrgmakanan11;
       total = total + harga11;
     }
     if(menu.getCkm12().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M012'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan12 = m.getHarga_jual();
       int hrgmakanan12 = Integer.parseInt(makanan12);
       String jml = menu.getTxtjmlm12().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga12  = jumlahpesanan * hrgmakanan12;
       total = total + harga12;
     }
     if(menu.getCkm13().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M013'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan13 = m.getHarga_jual();
       int hrgmakanan13 = Integer.parseInt(makanan13);
       String jml = menu.getTxtjmlm13().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga13  = jumlahpesanan * hrgmakanan13;
       total = total + harga13;
     }
     if(menu.getCkm14().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M014'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan14 = m.getHarga_jual();
       int hrgmakanan14 = Integer.parseInt(makanan14);
       String jml = menu.getTxtjmlm14().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga14  = jumlahpesanan * hrgmakanan14;
       total = total + harga14;
     }
     
     if(menu.getCkn1().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M101'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String minuman1 = m.getHarga_jual();
       int hrgminuman1 = Integer.parseInt(minuman1);
       String jml = menu.getTxtjmlmi1().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga1  = jumlahpesanan * hrgminuman1;
       total = total + harga1;
     }
     
     if(menu.getCkn2().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M102'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String minuman2 = m.getHarga_jual();
       int hrgminuman2 = Integer.parseInt(minuman2);
       String jml = menu.getTxtjmlmi2().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga2  = jumlahpesanan * hrgminuman2;
       total = total + harga2;
     }
     
     if(menu.getCkn3().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M103'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String minuman3 = m.getHarga_jual();
       int hrgminuman3 = Integer.parseInt(minuman3);
       String jml = menu.getTxtjmlmi3().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga3  = jumlahpesanan * hrgminuman3;
       total = total + harga3;
     }
     
     if(menu.getCkn4().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M104'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String minuman4 = m.getHarga_jual();
       int hrgminuman4 = Integer.parseInt(minuman4);
       String jml = menu.getTxtjmlmi4().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga4  = jumlahpesanan * hrgminuman4;
       total = total + harga4;
     }
     
     if(menu.getCkn5().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M105'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String minuman5 = m.getHarga_jual();
       int hrgminuman5 = Integer.parseInt(minuman5);
       String jml = menu.getTxtjmlmi5().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga5  = jumlahpesanan * hrgminuman5;
       total = total + harga5;
     }
     
     if(menu.getCkn6().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M106'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String minuman6 = m.getHarga_jual();
       int hrgminuman6 = Integer.parseInt(minuman6);
       String jml = menu.getTxtjmlmi6().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga6  = jumlahpesanan * hrgminuman6;
       total = total + harga6;
     }
     
     if(menu.getCkn7().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M107'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String minuman7 = m.getHarga_jual();
       int hrgminuman7 = Integer.parseInt(minuman7);
       String jml = menu.getTxtjmlmi7().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga7  = jumlahpesanan * hrgminuman7;
       total = total + harga7;
     }
     
     if(menu.getCkn8().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M108'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String minuman8 = m.getHarga_jual();
       int hrgminuman8 = Integer.parseInt(minuman8);
       String jml = menu.getTxtjmlmi8().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga8  = jumlahpesanan * hrgminuman8;
       total = total + harga8;
     }
     
     if(menu.getCkn9().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M109'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String minuman9 = m.getHarga_jual();
       int hrgminuman9 = Integer.parseInt(minuman9);
       String jml = menu.getTxtjmlmi9().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga9  = jumlahpesanan * hrgminuman9;
       total = total + harga9;
     }
     
     if(menu.getCkn10().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M110'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String minuman10 = m.getHarga_jual();
       int hrgminuman10 = Integer.parseInt(minuman10);
       String jml = menu.getTxtjmlmi10().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga10  = jumlahpesanan * hrgminuman10;
       total = total + harga10;
     }
     
     if(menu.getCkn11().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M111'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String minuman11 = m.getHarga_jual();
       int hrgminuman11 = Integer.parseInt(minuman11);
       String jml = menu.getTxtjmlmi11().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga11  = jumlahpesanan * hrgminuman11;
       total = total + harga11;
     }
     
     String tot = String.valueOf(total);
     menu.getTxttotalharga().setText(tot);
    
    }
    
    
    public void Kembalian(){
        if (menu.getTxttotalharga().getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(menu, "Tolong hitung total belanjaan terlebih dahulu!!");
        }else{
            if (menu.getTxtjmlbayar().getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(menu, "Tolong isi jumlah bayar terlebih dahulu !!");
            }else{
            jml_bayar = Integer.parseInt(menu.getTxtjmlbayar().getText());
            totalhrg = Integer.parseInt(menu.getTxttotalharga().getText());
            kembalian = (jml_bayar - totalhrg);
            menu.getTxtkembalian().setText(String.valueOf(kembalian));
            }   
        }
        
    }
    
    public void trans(){
        pelanggan = new Pelanggan();
     try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from tpelanggan where nama_pel='"+menu.getTxtnamapelanggan().getText()+
                    "'");
            
            while (rs.next()) {
              pelanggan.setNopel(rs.getString(1));
              pelanggan.setNamapelanggan(rs.getString(2));
            }
        } catch (Exception e) {   
        } 
     
     int total = 0;
     int jmlpesanan = 0;
     
     if(menu.getCkm1().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M001'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan1 = m.getHarga_jual();
       int hrgmakanan1 = Integer.parseInt(makanan1);
       String jml = menu.getTxtjmlm1().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga1  = jumlahpesanan * hrgmakanan1;
       total = total + harga1;
     }
     
     if(menu.getCkm2().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M002'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan2 = m.getHarga_jual();
       int hrgmakanan2 = Integer.parseInt(makanan2);
       String jml = menu.getTxtjmlm2().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga2  = jumlahpesanan * hrgmakanan2;
       total = total + harga2;
     }
     
     if(menu.getCkm3().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M003'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan3 = m.getHarga_jual();
       int hrgmakanan3 = Integer.parseInt(makanan3);
       String jml = menu.getTxtjmlm3().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga3  = jumlahpesanan * hrgmakanan3;
       total = total + harga3;
     }
     
     if(menu.getCkm4().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M004'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan4 = m.getHarga_jual();
       int hrgmakanan4 = Integer.parseInt(makanan4);
       String jml = menu.getTxtjmlm4().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga4  = jumlahpesanan * hrgmakanan4;
       total = total + harga4;
     }
     
     if(menu.getCkm5().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M005'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan5 = m.getHarga_jual();
       int hrgmakanan5 = Integer.parseInt(makanan5);
       String jml = menu.getTxtjmlm5().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga5  = jumlahpesanan * hrgmakanan5;
       total = total + harga5;
     }
     if(menu.getCkm6().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M006'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan6 = m.getHarga_jual();
       int hrgmakanan6 = Integer.parseInt(makanan6);
       String jml = menu.getTxtjmlm6().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga6  = jumlahpesanan * hrgmakanan6;
       total = total + harga6;
     }
     if(menu.getCkm7().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M007'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan7 = m.getHarga_jual();
       int hrgmakanan7 = Integer.parseInt(makanan7);
       String jml = menu.getTxtjmlm7().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga7  = jumlahpesanan * hrgmakanan7;
       total = total + harga7;
     }
     if(menu.getCkm8().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M008'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan8 = m.getHarga_jual();
       int hrgmakanan8 = Integer.parseInt(makanan8);
       String jml = menu.getTxtjmlm8().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga8  = jumlahpesanan * hrgmakanan8;
       total = total + harga8;
     }
     if(menu.getCkm9().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M009'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan9 = m.getHarga_jual();
       int hrgmakanan9 = Integer.parseInt(makanan9);
       String jml = menu.getTxtjmlm9().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga9  = jumlahpesanan * hrgmakanan9;
       total = total + harga9;
     }
     if(menu.getCkm10().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M010'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan10 = m.getHarga_jual();
       int hrgmakanan10 = Integer.parseInt(makanan10);
       String jml = menu.getTxtjmlm10().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga10  = jumlahpesanan * hrgmakanan10;
       total = total + harga10;
     }
     if(menu.getCkm11().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M011'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan11 = m.getHarga_jual();
       int hrgmakanan11 = Integer.parseInt(makanan11);
       String jml = menu.getTxtjmlm11().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga11  = jumlahpesanan * hrgmakanan11;
       total = total + harga11;
     }
     if(menu.getCkm12().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M012'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan12 = m.getHarga_jual();
       int hrgmakanan12 = Integer.parseInt(makanan12);
       String jml = menu.getTxtjmlm12().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga12  = jumlahpesanan * hrgmakanan12;
       total = total + harga12;
     }
     if(menu.getCkm13().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M013'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan13 = m.getHarga_jual();
       int hrgmakanan13 = Integer.parseInt(makanan13);
       String jml = menu.getTxtjmlm13().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga13  = jumlahpesanan * hrgmakanan13;
       total = total + harga13;
     }
     if(menu.getCkm14().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M014'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan14 = m.getHarga_jual();
       int hrgmakanan14 = Integer.parseInt(makanan14);
       String jml = menu.getTxtjmlm14().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga14  = jumlahpesanan * hrgmakanan14;
       total = total + harga14;
     }
     
     if(menu.getCkn1().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M101'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String minuman1 = m.getHarga_jual();
       int hrgminuman1 = Integer.parseInt(minuman1);
       String jml = menu.getTxtjmlmi1().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga1  = jumlahpesanan * hrgminuman1;
       total = total + harga1;
     }
     
     if(menu.getCkn2().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M102'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String minuman2 = m.getHarga_jual();
       int hrgminuman2 = Integer.parseInt(minuman2);
       String jml = menu.getTxtjmlmi2().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga2  = jumlahpesanan * hrgminuman2;
       total = total + harga2;
     }
     
     if(menu.getCkn3().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M103'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String minuman3 = m.getHarga_jual();
       int hrgminuman3 = Integer.parseInt(minuman3);
       String jml = menu.getTxtjmlmi3().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga3  = jumlahpesanan * hrgminuman3;
       total = total + harga3;
     }
     
     if(menu.getCkn4().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M104'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String minuman4 = m.getHarga_jual();
       int hrgminuman4 = Integer.parseInt(minuman4);
       String jml = menu.getTxtjmlmi4().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga4  = jumlahpesanan * hrgminuman4;
       total = total + harga4;
     }
     
     if(menu.getCkn5().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M105'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String minuman5 = m.getHarga_jual();
       int hrgminuman5 = Integer.parseInt(minuman5);
       String jml = menu.getTxtjmlmi5().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga5  = jumlahpesanan * hrgminuman5;
       total = total + harga5;
     }
     
     if(menu.getCkn6().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M106'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String minuman6 = m.getHarga_jual();
       int hrgminuman6 = Integer.parseInt(minuman6);
       String jml = menu.getTxtjmlmi6().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga6  = jumlahpesanan * hrgminuman6;
       total = total + harga6;
     }
     
     if(menu.getCkn7().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M107'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String minuman7 = m.getHarga_jual();
       int hrgminuman7 = Integer.parseInt(minuman7);
       String jml = menu.getTxtjmlmi7().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga7  = jumlahpesanan * hrgminuman7;
       total = total + harga7;
     }
     
     if(menu.getCkn8().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M108'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String minuman8 = m.getHarga_jual();
       int hrgminuman8 = Integer.parseInt(minuman8);
       String jml = menu.getTxtjmlmi8().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga8  = jumlahpesanan * hrgminuman8;
       total = total + harga8;
     }
     
     if(menu.getCkn9().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M109'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String minuman9 = m.getHarga_jual();
       int hrgminuman9 = Integer.parseInt(minuman9);
       String jml = menu.getTxtjmlmi9().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga9  = jumlahpesanan * hrgminuman9;
       total = total + harga9;
     }
     
     if(menu.getCkn10().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M110'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String minuman10 = m.getHarga_jual();
       int hrgminuman10 = Integer.parseInt(minuman10);
       String jml = menu.getTxtjmlmi10().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga10  = jumlahpesanan * hrgminuman10;
       total = total + harga10;
     }
     
     if(menu.getCkn11().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M111'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String minuman11 = m.getHarga_jual();
       int hrgminuman11 = Integer.parseInt(minuman11);
       String jml = menu.getTxtjmlmi11().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga11  = jumlahpesanan * hrgminuman11;
       total = total + harga11;
     }
     
     
     String tot = String.valueOf(total);
     String jmlpesan = String.valueOf(jmlpesanan);
     
    try {
            String sql = "INSERT INTO ttrans VALUES (?,?,?,?,?,?)";
              PreparedStatement ps = conn.prepareStatement(sql);
              ps.setString(1, menu.getTxtidtrans().getText());
              ps.setString(2, pelanggan.getNopel());
              ps.setString(3, gettgl());
              ps.setString(4, jmlpesan); 
              ps.setString(5, tot); 
              ps.setString(6, menu.getTxtjmlbayar().getText()); 
              ps.executeUpdate();
        } catch (Exception e) {
   
        }
    }
    
    public void Insert(){
        if (menu.getTxtjmlbayar().getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(menu, "maaf tolong isi jumlah bayar terlebih dahulu !!");
        }else{
        trans();
        int total = 0;
        int jmlpesanan = 0;
        String id_kasir = menu.getId_kasir();
        if (menu.getTxtidtrans().getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(menu, "maaf tolong isi id transaksi terlebih dahulu !!");
        }else{
            
        if(menu.getCkm1().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M001'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String makanan1 = m.getHarga_jual();
       int hrgmakanan1 = Integer.parseInt(makanan1);
       String jml = menu.getTxtjmlm1().getText();
       int jumlahpesanan1 = Integer.parseInt(jml);
       int harga1  = jumlahpesanan1 * hrgmakanan1;
       total = total + harga1;
       jmlpesanan = jmlpesanan + jumlahpesanan1;
       int modal1 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgmakanan1 - modal1)*jumlahpesanan1;
       String keuntungan1 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan1); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
               
            } catch (Exception e) {
                 
            }
     }
     
     if(menu.getCkm2().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M002'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan2 = m.getHarga_jual();
       int hrgmakanan2 = Integer.parseInt(makanan2);
       String jml = menu.getTxtjmlm2().getText();
       int jumlahpesanan2 = Integer.parseInt(jml);
       int harga2  = jumlahpesanan2 * hrgmakanan2;
       total = total + harga2;
       jmlpesanan =jmlpesanan + jumlahpesanan2;
       int modal2 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgmakanan2 - modal2)*jumlahpesanan2;
       String keuntungan2 = String.valueOf(untung);
       
       try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan2); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
               
            } catch (Exception e) {
                 
            }
     }
     
     if(menu.getCkm3().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M003'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan3 = m.getHarga_jual();
       int hrgmakanan3 = Integer.parseInt(makanan3);
       String jml = menu.getTxtjmlm3().getText();
       int jumlahpesanan3 = Integer.parseInt(jml);
       int harga3  = jumlahpesanan3 * hrgmakanan3;
       total = total + harga3;
       jmlpesanan =jmlpesanan + jumlahpesanan3;
       int modal3 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgmakanan3 - modal3)*jumlahpesanan3;
       String keuntungan3 = String.valueOf(untung);
       
       try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan3); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
               
            } catch (Exception e) {
                 
            }
     }
     
     if(menu.getCkm4().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M004'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan4 = m.getHarga_jual();
       int hrgmakanan4 = Integer.parseInt(makanan4);
       String jml = menu.getTxtjmlm4().getText();
       int jumlahpesanan4 = Integer.parseInt(jml);
       int harga4  = jumlahpesanan4 * hrgmakanan4;
       total = total + harga4;
       jmlpesanan =jmlpesanan + jumlahpesanan4;
       int modal4 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgmakanan4 - modal4)*jumlahpesanan4;
       String keuntungan4 = String.valueOf(untung);
       
       try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan4); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
               
            } catch (Exception e) {
                 
            }
     }
     
     if(menu.getCkm5().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M005'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
            String makanan5 = m.getHarga_jual();
            int hrgmakanan5 = Integer.parseInt(makanan5);
            String jml = menu.getTxtjmlm5().getText();
            int jumlahpesanan5 = Integer.parseInt(jml);
            int harga5  = jumlahpesanan5 * hrgmakanan5;
            total = total + harga5;
            jmlpesanan =jmlpesanan + jumlahpesanan5;
            int modal5 = Integer.parseInt(m.getHarga_modal());
            int untung = (hrgmakanan5 - modal5)*jumlahpesanan5;
            String keuntungan5 = String.valueOf(untung);
            
      
       try {
            
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan5); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();

            } catch (Exception e) { 

            }
        }
     
     if(menu.getCkm6().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M006'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String makanan6 = m.getHarga_jual();
       int hrgmakanan6 = Integer.parseInt(makanan6);
       String jml = menu.getTxtjmlm6().getText();
       int jumlahpesanan6 = Integer.parseInt(jml);
       int harga6  = jumlahpesanan6 * hrgmakanan6;
       total = total + harga6;
       jmlpesanan = jmlpesanan + jumlahpesanan6;
       int modal6 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgmakanan6 - modal6)*jumlahpesanan6;
       String keuntungan6 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan6); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
               
            } catch (Exception e) {
                 
            }
     }
     
     if(menu.getCkm7().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M007'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String makanan7 = m.getHarga_jual();
       int hrgmakanan7 = Integer.parseInt(makanan7);
       String jml = menu.getTxtjmlm7().getText();
       int jumlahpesanan7 = Integer.parseInt(jml);
       int harga7  = jumlahpesanan7 * hrgmakanan7;
       total = total + harga7;
       jmlpesanan = jmlpesanan + jumlahpesanan7;
       int modal7 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgmakanan7 - modal7)*jumlahpesanan7;
       String keuntungan7 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan7); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
               
            } catch (Exception e) {
                 
            }
     }
     
     if(menu.getCkm8().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M008'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String makanan8 = m.getHarga_jual();
       int hrgmakanan8 = Integer.parseInt(makanan8);
       String jml = menu.getTxtjmlm8().getText();
       int jumlahpesanan8 = Integer.parseInt(jml);
       int harga8  = jumlahpesanan8 * hrgmakanan8;
       total = total + harga8;
       jmlpesanan = jmlpesanan + jumlahpesanan8;
       int modal8 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgmakanan8 - modal8)*jumlahpesanan8;
       String keuntungan8 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan8); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
               
            } catch (Exception e) {
                 
            }
     }
     
     if(menu.getCkm9().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M009'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String makanan9 = m.getHarga_jual();
       int hrgmakanan9 = Integer.parseInt(makanan9);
       String jml = menu.getTxtjmlm9().getText();
       int jumlahpesanan9 = Integer.parseInt(jml);
       int harga9  = jumlahpesanan9 * hrgmakanan9;
       total = total + harga9;
       jmlpesanan = jmlpesanan + jumlahpesanan9;
       int modal9 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgmakanan9 - modal9)*jumlahpesanan9;
       String keuntungan9 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan9); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
               
            } catch (Exception e) {
                 
            }
     }
     
     if(menu.getCkm10().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M010'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String makanan10 = m.getHarga_jual();
       int hrgmakanan10 = Integer.parseInt(makanan10);
       String jml = menu.getTxtjmlm10().getText();
       int jumlahpesanan10 = Integer.parseInt(jml);
       int harga10  = jumlahpesanan10 * hrgmakanan10;
       total = total + harga10;
       jmlpesanan = jmlpesanan + jumlahpesanan10;
       int modal10 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgmakanan10 - modal10)*jumlahpesanan10;
       String keuntungan10 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan10); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
               
            } catch (Exception e) {
                 
            }
     }
     
     if(menu.getCkm11().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M011'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String makanan11 = m.getHarga_jual();
       int hrgmakanan11 = Integer.parseInt(makanan11);
       String jml = menu.getTxtjmlm11().getText();
       int jumlahpesanan11 = Integer.parseInt(jml);
       int harga11  = jumlahpesanan11 * hrgmakanan11;
       total = total + harga11;
       jmlpesanan = jmlpesanan + jumlahpesanan11;
       int modal11 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgmakanan11 - modal11)*jumlahpesanan11;
       String keuntungan11 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan11); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
               
            } catch (Exception e) {
                 
            }
     }
     
     if(menu.getCkm12().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M012'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String makanan12 = m.getHarga_jual();
       int hrgmakanan12 = Integer.parseInt(makanan12);
       String jml = menu.getTxtjmlm12().getText();
       int jumlahpesanan12 = Integer.parseInt(jml);
       int harga12  = jumlahpesanan12 * hrgmakanan12;
       total = total + harga12;
       jmlpesanan = jmlpesanan + jumlahpesanan12;
       int modal12 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgmakanan12 - modal12)*jumlahpesanan12;
       String keuntungan12 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan12); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
               
            } catch (Exception e) {
                 
            }
     }
     
     if(menu.getCkm13().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M013'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String makanan13 = m.getHarga_jual();
       int hrgmakanan13 = Integer.parseInt(makanan13);
       String jml = menu.getTxtjmlm13().getText();
       int jumlahpesanan13 = Integer.parseInt(jml);
       int harga13  = jumlahpesanan13 * hrgmakanan13;
       total = total + harga13;
       jmlpesanan = jmlpesanan + jumlahpesanan13;
       int modal13 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgmakanan13 - modal13)*jumlahpesanan13;
       String keuntungan13 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan13); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
               
            } catch (Exception e) {
                 
            }
     }
     
     if(menu.getCkm14().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M014'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String makanan14 = m.getHarga_jual();
       int hrgmakanan14 = Integer.parseInt(makanan14);
       String jml = menu.getTxtjmlm14().getText();
       int jumlahpesanan14 = Integer.parseInt(jml);
       int harga14  = jumlahpesanan14 * hrgmakanan14;
       total = total + harga14;
       jmlpesanan = jmlpesanan + jumlahpesanan14;
       int modal14 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgmakanan14 - modal14)*jumlahpesanan14;
       String keuntungan14 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan14); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
            } catch (Exception e) {
                 
            }
        }
     
     
     if(menu.getCkn1().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M101'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String minuman1 = m.getHarga_jual();
       int hrgminuman1 = Integer.parseInt(minuman1);
       String jml = menu.getTxtjmlmi1().getText();
       int jumlahpesanan1 = Integer.parseInt(jml);
       int harga1  = jumlahpesanan1 * hrgminuman1;
       total = total + harga1;
       jmlpesanan = jmlpesanan + jumlahpesanan1;
       int modal1 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgminuman1 - modal1)*jumlahpesanan1;
       String keuntungan1 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan1); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
            } catch (Exception e) {
                 
            }
        }
     
     if(menu.getCkn2().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M102'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String minuman2 = m.getHarga_jual();
       int hrgminuman2 = Integer.parseInt(minuman2);
       String jml = menu.getTxtjmlmi2().getText();
       int jumlahpesanan2 = Integer.parseInt(jml);
       int harga2  = jumlahpesanan2 * hrgminuman2;
       total = total + harga2;
       jmlpesanan = jmlpesanan + jumlahpesanan2;
       int modal2 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgminuman2 - modal2)*jumlahpesanan2;
       String keuntungan2 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan2); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
            } catch (Exception e) {
                 
            }
        }
     
     if(menu.getCkn3().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M103'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String minuman3 = m.getHarga_jual();
       int hrgminuman3 = Integer.parseInt(minuman3);
       String jml = menu.getTxtjmlmi3().getText();
       int jumlahpesanan3 = Integer.parseInt(jml);
       int harga3  = jumlahpesanan3 * hrgminuman3;
       total = total + harga3;
       jmlpesanan = jmlpesanan + jumlahpesanan3;
       int modal3 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgminuman3 - modal3)*jumlahpesanan3;
       String keuntungan3 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan3); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
            } catch (Exception e) {
                 
            }
        }
     
     if(menu.getCkn4().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M104'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String minuman4 = m.getHarga_jual();
       int hrgminuman4 = Integer.parseInt(minuman4);
       String jml = menu.getTxtjmlmi4().getText();
       int jumlahpesanan4 = Integer.parseInt(jml);
       int harga4  = jumlahpesanan4 * hrgminuman4;
       total = total + harga4;
       jmlpesanan = jmlpesanan + jumlahpesanan4;
       int modal4 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgminuman4 - modal4)*jumlahpesanan4;
       String keuntungan4 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan4); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
            } catch (Exception e) {
                 
            }
        }
     
     if(menu.getCkn5().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M105'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String minuman5 = m.getHarga_jual();
       int hrgminuman5 = Integer.parseInt(minuman5);
       String jml = menu.getTxtjmlmi5().getText();
       int jumlahpesanan5 = Integer.parseInt(jml);
       int harga5  = jumlahpesanan5 * hrgminuman5;
       total = total + harga5;
       jmlpesanan = jmlpesanan + jumlahpesanan5;
       int modal5 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgminuman5 - modal5)*jumlahpesanan5;
       String keuntungan5 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan5); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
            } catch (Exception e) {
                 
            }
        }
     
     if(menu.getCkn6().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M106'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String minuman6 = m.getHarga_jual();
       int hrgminuman6 = Integer.parseInt(minuman6);
       String jml = menu.getTxtjmlmi6().getText();
       int jumlahpesanan6 = Integer.parseInt(jml);
       int harga6  = jumlahpesanan6 * hrgminuman6;
       total = total + harga6;
       jmlpesanan = jmlpesanan + jumlahpesanan6;
       int modal6 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgminuman6 - modal6)*jumlahpesanan6;
       String keuntungan6 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan6); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
            } catch (Exception e) {
                 
            }
        }
     
     if(menu.getCkn7().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M107'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String minuman7 = m.getHarga_jual();
       int hrgminuman7 = Integer.parseInt(minuman7);
       String jml = menu.getTxtjmlmi7().getText();
       int jumlahpesanan7 = Integer.parseInt(jml);
       int harga7  = jumlahpesanan7 * hrgminuman7;
       total = total + harga7;
       jmlpesanan = jmlpesanan + jumlahpesanan7;
       int modal7 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgminuman7 - modal7)*jumlahpesanan7;
       String keuntungan7 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan7); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
            } catch (Exception e) {
                 
            }
        }
     
     if(menu.getCkn8().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M108'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String minuman8 = m.getHarga_jual();
       int hrgminuman8 = Integer.parseInt(minuman8);
       String jml = menu.getTxtjmlmi8().getText();
       int jumlahpesanan8 = Integer.parseInt(jml);
       int harga8  = jumlahpesanan8 * hrgminuman8;
       total = total + harga8;
       jmlpesanan = jmlpesanan + jumlahpesanan8;
       int modal8 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgminuman8 - modal8)*jumlahpesanan8;
       String keuntungan8 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan8); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
            } catch (Exception e) {
                 
            }
        }
     
     if(menu.getCkn9().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M109'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String minuman9 = m.getHarga_jual();
       int hrgminuman9 = Integer.parseInt(minuman9);
       String jml = menu.getTxtjmlmi9().getText();
       int jumlahpesanan9 = Integer.parseInt(jml);
       int harga9  = jumlahpesanan9 * hrgminuman9;
       total = total + harga9;
       jmlpesanan = jmlpesanan + jumlahpesanan9;
       int modal9 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgminuman9 - modal9)*jumlahpesanan9;
       String keuntungan9 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan9); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
            } catch (Exception e) {
                 
            }
        }
     
     if(menu.getCkn10().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M110'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String minuman10 = m.getHarga_jual();
       int hrgminuman10 = Integer.parseInt(minuman10);
       String jml = menu.getTxtjmlmi10().getText();
       int jumlahpesanan10 = Integer.parseInt(jml);
       int harga10  = jumlahpesanan10 * hrgminuman10;
       total = total + harga10;
       jmlpesanan = jmlpesanan + jumlahpesanan10;
       int modal10 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgminuman10 - modal10)*jumlahpesanan10;
       String keuntungan10 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan10); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
            } catch (Exception e) {
                 
            }
        }
     
     if(menu.getCkn11().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M111'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String minuman11 = m.getHarga_jual();
       int hrgminuman11 = Integer.parseInt(minuman11);
       String jml = menu.getTxtjmlmi11().getText();
       int jumlahpesanan11 = Integer.parseInt(jml);
       int harga11  = jumlahpesanan11 * hrgminuman11;
       total = total + harga11;
       jmlpesanan = jmlpesanan + jumlahpesanan11;
       int modal11 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgminuman11 - modal11)*jumlahpesanan11;
       String keuntungan11 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan11); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
            } catch (Exception e) {
                 
            }
        }

     JOptionPane.showMessageDialog(menu, "Transaksi Sukses :)",
             "Image OptionPane",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Gambar/tenor.gif"));
        } 
        }
            
    }
    
    public void Delete(){            
        int opsi = JOptionPane.showConfirmDialog(menu, "Benarkah anda ingin menghapus data ini ?");
        switch(opsi){
            case JOptionPane.YES_OPTION:
                JOptionPane.showMessageDialog(menu, "Data Sukses Terhapus!!");
                try {
                    String sql = "DELETE from ttrans where id_trans = ?";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setString(1, menu.getTxtidtrans().getText());
                    ps.executeUpdate();
                } catch (Exception e) {
                }
                try {
                      String sql = "DELETE from tpelanggan where nama_pel = ?";
                      PreparedStatement ps = conn.prepareStatement(sql);
                      ps.setString(1, menu.getTxtnamapelanggan().getText());
                      ps.executeUpdate();
                } catch (Exception e) {
                }
                Reset();
                break;
            case JOptionPane.NO_OPTION:
                JOptionPane.showMessageDialog(menu, "Data Gagal Terhapus!!");
                Reset();
                break;
            default:
                break;
        }
    }
    
    public void Deltrans(){
        try {
            String sql = "DELETE from ttrans where id_trans = ?";
              PreparedStatement ps = conn.prepareStatement(sql);
              ps.setString(1, menu.getTxtidtrans().getText());
              ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void setUpdate(){
        Deltrans();
        pelanggan = new Pelanggan();
     try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from tpelanggan where nama_pel='"+menu.getTxtnamapelanggan().getText()+
                    "'");
            
            while (rs.next()) {
              pelanggan.setNopel(rs.getString(1));
              pelanggan.setNamapelanggan(rs.getString(2));
            }
        } catch (Exception e) {   
        } 
     
     int total = 0;
     int jmlpesanan = 0;
     
     if(menu.getCkm1().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M001'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan1 = m.getHarga_jual();
       int hrgmakanan1 = Integer.parseInt(makanan1);
       String jml = menu.getTxtjmlm1().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga1  = jumlahpesanan * hrgmakanan1;
       total = total + harga1;
     }
     
     if(menu.getCkm2().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M002'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan2 = m.getHarga_jual();
       int hrgmakanan2 = Integer.parseInt(makanan2);
       String jml = menu.getTxtjmlm2().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga2  = jumlahpesanan * hrgmakanan2;
       total = total + harga2;
     }
     
     if(menu.getCkm3().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M003'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan3 = m.getHarga_jual();
       int hrgmakanan3 = Integer.parseInt(makanan3);
       String jml = menu.getTxtjmlm3().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga3  = jumlahpesanan * hrgmakanan3;
       total = total + harga3;
     }
     
     if(menu.getCkm4().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M004'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan4 = m.getHarga_jual();
       int hrgmakanan4 = Integer.parseInt(makanan4);
       String jml = menu.getTxtjmlm4().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga4  = jumlahpesanan * hrgmakanan4;
       total = total + harga4;
     }
     
     if(menu.getCkm5().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M005'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan5 = m.getHarga_jual();
       int hrgmakanan5 = Integer.parseInt(makanan5);
       String jml = menu.getTxtjmlm5().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga5  = jumlahpesanan * hrgmakanan5;
       total = total + harga5;
     }
     
      if(menu.getCkm6().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M006'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan6 = m.getHarga_jual();
       int hrgmakanan6 = Integer.parseInt(makanan6);
       String jml = menu.getTxtjmlm6().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga6  = jumlahpesanan * hrgmakanan6;
       total = total + harga6;
     }
     if(menu.getCkm7().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M007'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan7 = m.getHarga_jual();
       int hrgmakanan7 = Integer.parseInt(makanan7);
       String jml = menu.getTxtjmlm7().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga7  = jumlahpesanan * hrgmakanan7;
       total = total + harga7;
     }
     if(menu.getCkm8().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M008'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan8 = m.getHarga_jual();
       int hrgmakanan8 = Integer.parseInt(makanan8);
       String jml = menu.getTxtjmlm8().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga8  = jumlahpesanan * hrgmakanan8;
       total = total + harga8;
     }
     if(menu.getCkm9().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M009'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan9 = m.getHarga_jual();
       int hrgmakanan9 = Integer.parseInt(makanan9);
       String jml = menu.getTxtjmlm9().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga9  = jumlahpesanan * hrgmakanan9;
       total = total + harga9;
     }
     if(menu.getCkm10().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M010'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan10 = m.getHarga_jual();
       int hrgmakanan10 = Integer.parseInt(makanan10);
       String jml = menu.getTxtjmlm10().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga10  = jumlahpesanan * hrgmakanan10;
       total = total + harga10;
     }
     if(menu.getCkm11().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M011'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan11 = m.getHarga_jual();
       int hrgmakanan11 = Integer.parseInt(makanan11);
       String jml = menu.getTxtjmlm11().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga11  = jumlahpesanan * hrgmakanan11;
       total = total + harga11;
     }
     if(menu.getCkm12().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M012'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan12 = m.getHarga_jual();
       int hrgmakanan12 = Integer.parseInt(makanan12);
       String jml = menu.getTxtjmlm12().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga12  = jumlahpesanan * hrgmakanan12;
       total = total + harga12;
     }
     if(menu.getCkm13().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M013'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan13 = m.getHarga_jual();
       int hrgmakanan13 = Integer.parseInt(makanan13);
       String jml = menu.getTxtjmlm13().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga13  = jumlahpesanan * hrgmakanan13;
       total = total + harga13;
     }
     if(menu.getCkm14().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M014'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan14 = m.getHarga_jual();
       int hrgmakanan14 = Integer.parseInt(makanan14);
       String jml = menu.getTxtjmlm14().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga14  = jumlahpesanan * hrgmakanan14;
       total = total + harga14;
     }
     
     if(menu.getCkn1().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M101'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String minuman1 = m.getHarga_jual();
       int hrgminuman1 = Integer.parseInt(minuman1);
       String jml = menu.getTxtjmlmi1().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga1  = jumlahpesanan * hrgminuman1;
       total = total + harga1;
     }
     
     if(menu.getCkn2().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M102'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String minuman2 = m.getHarga_jual();
       int hrgminuman2 = Integer.parseInt(minuman2);
       String jml = menu.getTxtjmlmi2().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga2  = jumlahpesanan * hrgminuman2;
       total = total + harga2;
     }
     
     if(menu.getCkn3().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M103'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String minuman3 = m.getHarga_jual();
       int hrgminuman3 = Integer.parseInt(minuman3);
       String jml = menu.getTxtjmlmi3().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga3  = jumlahpesanan * hrgminuman3;
       total = total + harga3;
     }
     
     if(menu.getCkn4().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M104'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String minuman4 = m.getHarga_jual();
       int hrgminuman4 = Integer.parseInt(minuman4);
       String jml = menu.getTxtjmlmi2().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga4  = jumlahpesanan * hrgminuman4;
       total = total + harga4;
     }
     
     if(menu.getCkn5().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M105'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String minuman5 = m.getHarga_jual();
       int hrgminuman5 = Integer.parseInt(minuman5);
       String jml = menu.getTxtjmlmi5().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga5  = jumlahpesanan * hrgminuman5;
       total = total + harga5;
     }
     
     if(menu.getCkn6().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M106'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String minuman6 = m.getHarga_jual();
       int hrgminuman6 = Integer.parseInt(minuman6);
       String jml = menu.getTxtjmlmi6().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga6  = jumlahpesanan * hrgminuman6;
       total = total + harga6;
     }
     
     if(menu.getCkn7().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M107'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String minuman7 = m.getHarga_jual();
       int hrgminuman7 = Integer.parseInt(minuman7);
       String jml = menu.getTxtjmlmi7().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga7  = jumlahpesanan * hrgminuman7;
       total = total + harga7;
     }
     
     if(menu.getCkn8().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M108'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String minuman8 = m.getHarga_jual();
       int hrgminuman8 = Integer.parseInt(minuman8);
       String jml = menu.getTxtjmlmi8().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga8  = jumlahpesanan * hrgminuman8;
       total = total + harga8;
     }
     
     if(menu.getCkn9().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M109'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String minuman9 = m.getHarga_jual();
       int hrgminuman9 = Integer.parseInt(minuman9);
       String jml = menu.getTxtjmlmi9().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga9  = jumlahpesanan * hrgminuman9;
       total = total + harga9;
     }
     
     if(menu.getCkn10().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M110'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String minuman10 = m.getHarga_jual();
       int hrgminuman10 = Integer.parseInt(minuman10);
       String jml = menu.getTxtjmlmi10().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga10  = jumlahpesanan * hrgminuman10;
       total = total + harga10;
     }
     
     if(menu.getCkn11().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M111'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String minuman11 = m.getHarga_jual();
       int hrgminuman11 = Integer.parseInt(minuman11);
       String jml = menu.getTxtjmlmi11().getText();
       int jumlahpesanan = Integer.parseInt(jml);
       jmlpesanan = jmlpesanan + jumlahpesanan;
       int harga11  = jumlahpesanan * hrgminuman11;
       total = total + harga11;
     }
     
     String tot = String.valueOf(total);
     String jmlpesan = String.valueOf(jmlpesanan);
     
    try {
            String sql = "INSERT INTO ttrans VALUES (?,?,?,?,?,?)";
              PreparedStatement ps = conn.prepareStatement(sql);
              ps.setString(1, menu.getTxtidtrans().getText());
              ps.setString(2, pelanggan.getNopel());
              ps.setString(3, gettgl());
              ps.setString(4, jmlpesan); 
              ps.setString(5, tot); 
              ps.setString(6, menu.getTxtjmlbayar().getText()); 
              ps.executeUpdate();
        } catch (Exception e) {
   
        }
    }
    
    public void Update(){
        
        setUpdate();
        int total = 0;
        int jmlpesanan = 0;
        String id_kasir = menu.getId_kasir();
        
     if(menu.getCkm1().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M001'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String makanan1 = m.getHarga_jual();
       int hrgmakanan1 = Integer.parseInt(makanan1);
       String jml = menu.getTxtjmlm1().getText();
       int jumlahpesanan1 = Integer.parseInt(jml);
       int harga1  = jumlahpesanan1 * hrgmakanan1;
       total = total + harga1;
       jmlpesanan = jmlpesanan + jumlahpesanan1;
       int modal1 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgmakanan1 - modal1)*jumlahpesanan1;
       String keuntungan1 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan1); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
               
            } catch (Exception e) {
                 
            }
     }
     
     if(menu.getCkm2().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M002'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan2 = m.getHarga_jual();
       int hrgmakanan2 = Integer.parseInt(makanan2);
       String jml = menu.getTxtjmlm2().getText();
       int jumlahpesanan2 = Integer.parseInt(jml);
       int harga2  = jumlahpesanan2 * hrgmakanan2;
       total = total + harga2;
       jmlpesanan =jmlpesanan + jumlahpesanan2;
       int modal2 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgmakanan2 - modal2)*jumlahpesanan2;
       String keuntungan2 = String.valueOf(untung);
       
       try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan2); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
               
            } catch (Exception e) {
                 
            }
     }
     
     if(menu.getCkm3().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M003'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan3 = m.getHarga_jual();
       int hrgmakanan3 = Integer.parseInt(makanan3);
       String jml = menu.getTxtjmlm3().getText();
       int jumlahpesanan3 = Integer.parseInt(jml);
       int harga3  = jumlahpesanan3 * hrgmakanan3;
       total = total + harga3;
       jmlpesanan =jmlpesanan + jumlahpesanan3;
       int modal3 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgmakanan3 - modal3)*jumlahpesanan3;
       String keuntungan3 = String.valueOf(untung);
       
       try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan3); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
               
            } catch (Exception e) {
                 
            }
     }
     
     if(menu.getCkm4().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M004'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
       String makanan4 = m.getHarga_jual();
       int hrgmakanan4 = Integer.parseInt(makanan4);
       String jml = menu.getTxtjmlm4().getText();
       int jumlahpesanan4 = Integer.parseInt(jml);
       int harga4  = jumlahpesanan4 * hrgmakanan4;
       total = total + harga4;
       jmlpesanan =jmlpesanan + jumlahpesanan4;
       int modal4 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgmakanan4 - modal4)*jumlahpesanan4;
       String keuntungan4 = String.valueOf(untung);
       
       try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan4); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
               
            } catch (Exception e) {
                 
            }
     }
     
     if(menu.getCkm5().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M005'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
        } catch (Exception e) {
        }
        
      
       try {
            String makanan5 = m.getHarga_jual();
            int hrgmakanan5 = Integer.parseInt(makanan5);
            String jml = menu.getTxtjmlm5().getText();
            int jumlahpesanan5 = Integer.parseInt(jml);
            int harga5  = jumlahpesanan5 * hrgmakanan5;
            total = total + harga5;
            jmlpesanan =jmlpesanan + jumlahpesanan5;
            int modal5 = Integer.parseInt(m.getHarga_modal());
            int untung = (hrgmakanan5 - modal5)*jumlahpesanan5;
            String keuntungan5 = String.valueOf(untung);
            
            
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan5); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();

            } catch (Exception e) { 

            }
        }
     
     if(menu.getCkm6().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M006'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String makanan6 = m.getHarga_jual();
       int hrgmakanan6 = Integer.parseInt(makanan6);
       String jml = menu.getTxtjmlm6().getText();
       int jumlahpesanan6 = Integer.parseInt(jml);
       int harga6  = jumlahpesanan6 * hrgmakanan6;
       total = total + harga6;
       jmlpesanan = jmlpesanan + jumlahpesanan6;
       int modal6 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgmakanan6 - modal6)*jumlahpesanan6;
       String keuntungan6 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan6); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
               
            } catch (Exception e) {
                 
            }
     }
     
     if(menu.getCkm7().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M007'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String makanan7 = m.getHarga_jual();
       int hrgmakanan7 = Integer.parseInt(makanan7);
       String jml = menu.getTxtjmlm7().getText();
       int jumlahpesanan7 = Integer.parseInt(jml);
       int harga7  = jumlahpesanan7 * hrgmakanan7;
       total = total + harga7;
       jmlpesanan = jmlpesanan + jumlahpesanan7;
       int modal7 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgmakanan7 - modal7)*jumlahpesanan7;
       String keuntungan7 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan7); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
               
            } catch (Exception e) {
                 
            }
     }
     
     if(menu.getCkm8().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M008'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String makanan8 = m.getHarga_jual();
       int hrgmakanan8 = Integer.parseInt(makanan8);
       String jml = menu.getTxtjmlm8().getText();
       int jumlahpesanan8 = Integer.parseInt(jml);
       int harga8  = jumlahpesanan8 * hrgmakanan8;
       total = total + harga8;
       jmlpesanan = jmlpesanan + jumlahpesanan8;
       int modal8 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgmakanan8 - modal8)*jumlahpesanan8;
       String keuntungan8 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan8); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
               
            } catch (Exception e) {
                 
            }
     }
     
     if(menu.getCkm9().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M009'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String makanan9 = m.getHarga_jual();
       int hrgmakanan9 = Integer.parseInt(makanan9);
       String jml = menu.getTxtjmlm9().getText();
       int jumlahpesanan9 = Integer.parseInt(jml);
       int harga9  = jumlahpesanan9 * hrgmakanan9;
       total = total + harga9;
       jmlpesanan = jmlpesanan + jumlahpesanan9;
       int modal9 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgmakanan9 - modal9)*jumlahpesanan9;
       String keuntungan9 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan9); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
               
            } catch (Exception e) {
                 
            }
     }
     
     if(menu.getCkm10().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M010'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String makanan10 = m.getHarga_jual();
       int hrgmakanan10 = Integer.parseInt(makanan10);
       String jml = menu.getTxtjmlm10().getText();
       int jumlahpesanan10 = Integer.parseInt(jml);
       int harga10  = jumlahpesanan10 * hrgmakanan10;
       total = total + harga10;
       jmlpesanan = jmlpesanan + jumlahpesanan10;
       int modal10 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgmakanan10 - modal10)*jumlahpesanan10;
       String keuntungan10 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan10); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
               
            } catch (Exception e) {
                 
            }
     }
     
     if(menu.getCkm11().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M011'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String makanan11 = m.getHarga_jual();
       int hrgmakanan11 = Integer.parseInt(makanan11);
       String jml = menu.getTxtjmlm11().getText();
       int jumlahpesanan11 = Integer.parseInt(jml);
       int harga11  = jumlahpesanan11 * hrgmakanan11;
       total = total + harga11;
       jmlpesanan = jmlpesanan + jumlahpesanan11;
       int modal11 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgmakanan11 - modal11)*jumlahpesanan11;
       String keuntungan11 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan11); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
               
            } catch (Exception e) {
                 
            }
     }
     
     if(menu.getCkm12().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M012'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String makanan12 = m.getHarga_jual();
       int hrgmakanan12 = Integer.parseInt(makanan12);
       String jml = menu.getTxtjmlm12().getText();
       int jumlahpesanan12 = Integer.parseInt(jml);
       int harga12  = jumlahpesanan12 * hrgmakanan12;
       total = total + harga12;
       jmlpesanan = jmlpesanan + jumlahpesanan12;
       int modal12 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgmakanan12 - modal12)*jumlahpesanan12;
       String keuntungan12 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan12); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
               
            } catch (Exception e) {
                 
            }
     }
     
     if(menu.getCkm13().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M013'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String makanan13 = m.getHarga_jual();
       int hrgmakanan13 = Integer.parseInt(makanan13);
       String jml = menu.getTxtjmlm13().getText();
       int jumlahpesanan13 = Integer.parseInt(jml);
       int harga13  = jumlahpesanan13 * hrgmakanan13;
       total = total + harga13;
       jmlpesanan = jmlpesanan + jumlahpesanan13;
       int modal13 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgmakanan13 - modal13)*jumlahpesanan13;
       String keuntungan13 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan13); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
               
            } catch (Exception e) {
                 
            }
     }
     
     if(menu.getCkm14().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M014'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String makanan14 = m.getHarga_jual();
       int hrgmakanan14 = Integer.parseInt(makanan14);
       String jml = menu.getTxtjmlm14().getText();
       int jumlahpesanan14 = Integer.parseInt(jml);
       int harga14  = jumlahpesanan14 * hrgmakanan14;
       total = total + harga14;
       jmlpesanan = jmlpesanan + jumlahpesanan14;
       int modal14 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgmakanan14 - modal14)*jumlahpesanan14;
       String keuntungan14 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan14); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
            } catch (Exception e) {
                 
            }
        }
     
     
     if(menu.getCkn1().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M101'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String minuman1 = m.getHarga_jual();
       int hrgminuman1 = Integer.parseInt(minuman1);
       String jml = menu.getTxtjmlmi1().getText();
       int jumlahpesanan1 = Integer.parseInt(jml);
       int harga1  = jumlahpesanan1 * hrgminuman1;
       total = total + harga1;
       jmlpesanan = jmlpesanan + jumlahpesanan1;
       int modal1 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgminuman1 - modal1)*jumlahpesanan1;
       String keuntungan1 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan1); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
            } catch (Exception e) {
                 
            }
        }
     
     if(menu.getCkn2().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M102'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String minuman2 = m.getHarga_jual();
       int hrgminuman2 = Integer.parseInt(minuman2);
       String jml = menu.getTxtjmlmi2().getText();
       int jumlahpesanan2 = Integer.parseInt(jml);
       int harga2  = jumlahpesanan2 * hrgminuman2;
       total = total + harga2;
       jmlpesanan = jmlpesanan + jumlahpesanan2;
       int modal2 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgminuman2 - modal2)*jumlahpesanan2;
       String keuntungan2 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan2); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
            } catch (Exception e) {
                 
            }
        }
     
     if(menu.getCkn3().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M103'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String minuman3 = m.getHarga_jual();
       int hrgminuman3 = Integer.parseInt(minuman3);
       String jml = menu.getTxtjmlmi3().getText();
       int jumlahpesanan3 = Integer.parseInt(jml);
       int harga3  = jumlahpesanan3 * hrgminuman3;
       total = total + harga3;
       jmlpesanan = jmlpesanan + jumlahpesanan3;
       int modal3 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgminuman3 - modal3)*jumlahpesanan3;
       String keuntungan3 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan3); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
            } catch (Exception e) {
                 
            }
        }
     
     if(menu.getCkn4().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M104'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String minuman4 = m.getHarga_jual();
       int hrgminuman4 = Integer.parseInt(minuman4);
       String jml = menu.getTxtjmlmi4().getText();
       int jumlahpesanan4 = Integer.parseInt(jml);
       int harga4  = jumlahpesanan4 * hrgminuman4;
       total = total + harga4;
       jmlpesanan = jmlpesanan + jumlahpesanan4;
       int modal4 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgminuman4 - modal4)*jumlahpesanan4;
       String keuntungan4 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan4); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
            } catch (Exception e) {
                 
            }
        }
     
     if(menu.getCkn5().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M105'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String minuman5 = m.getHarga_jual();
       int hrgminuman5 = Integer.parseInt(minuman5);
       String jml = menu.getTxtjmlmi5().getText();
       int jumlahpesanan5 = Integer.parseInt(jml);
       int harga5  = jumlahpesanan5 * hrgminuman5;
       total = total + harga5;
       jmlpesanan = jmlpesanan + jumlahpesanan5;
       int modal5 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgminuman5 - modal5)*jumlahpesanan5;
       String keuntungan5 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan5); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
            } catch (Exception e) {
                 
            }
        }
     
     if(menu.getCkn6().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M106'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String minuman6 = m.getHarga_jual();
       int hrgminuman6 = Integer.parseInt(minuman6);
       String jml = menu.getTxtjmlmi6().getText();
       int jumlahpesanan6 = Integer.parseInt(jml);
       int harga6  = jumlahpesanan6 * hrgminuman6;
       total = total + harga6;
       jmlpesanan = jmlpesanan + jumlahpesanan6;
       int modal6 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgminuman6 - modal6)*jumlahpesanan6;
       String keuntungan6 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan6); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
            } catch (Exception e) {
                 
            }
        }
     
     if(menu.getCkn7().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M107'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String minuman7 = m.getHarga_jual();
       int hrgminuman7 = Integer.parseInt(minuman7);
       String jml = menu.getTxtjmlmi7().getText();
       int jumlahpesanan7 = Integer.parseInt(jml);
       int harga7  = jumlahpesanan7 * hrgminuman7;
       total = total + harga7;
       jmlpesanan = jmlpesanan + jumlahpesanan7;
       int modal7 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgminuman7 - modal7)*jumlahpesanan7;
       String keuntungan7 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan7); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
            } catch (Exception e) {
                 
            }
        }
     
     if(menu.getCkn8().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M108'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String minuman8 = m.getHarga_jual();
       int hrgminuman8 = Integer.parseInt(minuman8);
       String jml = menu.getTxtjmlmi8().getText();
       int jumlahpesanan8 = Integer.parseInt(jml);
       int harga8  = jumlahpesanan8 * hrgminuman8;
       total = total + harga8;
       jmlpesanan = jmlpesanan + jumlahpesanan8;
       int modal8 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgminuman8 - modal8)*jumlahpesanan8;
       String keuntungan8 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan8); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
            } catch (Exception e) {
                 
            }
        }
     
     if(menu.getCkn9().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M109'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String minuman9 = m.getHarga_jual();
       int hrgminuman9 = Integer.parseInt(minuman9);
       String jml = menu.getTxtjmlmi9().getText();
       int jumlahpesanan9 = Integer.parseInt(jml);
       int harga9  = jumlahpesanan9 * hrgminuman9;
       total = total + harga9;
       jmlpesanan = jmlpesanan + jumlahpesanan9;
       int modal9 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgminuman9 - modal9)*jumlahpesanan9;
       String keuntungan9 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan9); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
            } catch (Exception e) {
                 
            }
        }
     
     if(menu.getCkn10().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M110'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String minuman10 = m.getHarga_jual();
       int hrgminuman10 = Integer.parseInt(minuman10);
       String jml = menu.getTxtjmlmi10().getText();
       int jumlahpesanan10 = Integer.parseInt(jml);
       int harga10  = jumlahpesanan10 * hrgminuman10;
       total = total + harga10;
       jmlpesanan = jmlpesanan + jumlahpesanan10;
       int modal10 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgminuman10 - modal10)*jumlahpesanan10;
       String keuntungan10 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan10); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
            } catch (Exception e) {
                 
            }
        }
     
     if(menu.getCkn11().isSelected()== true){
         Menu m = new Menu();
        try {
            String sql = "SELECT * from tmenu where kode_menu='M111'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                m.setKode_menu(rs.getString(1));
                m.setNamamenu(rs.getString(2));
                m.setStock(rs.getString(3));
                m.setHarga_jual(rs.getString(4));
                m.setHarga_modal(rs.getString(5));
            }
            
        } catch (Exception e) {
        }
        
       String minuman11 = m.getHarga_jual();
       int hrgminuman11 = Integer.parseInt(minuman11);
       String jml = menu.getTxtjmlmi11().getText();
       int jumlahpesanan11 = Integer.parseInt(jml);
       int harga11  = jumlahpesanan11 * hrgminuman11;
       total = total + harga11;
       jmlpesanan = jmlpesanan + jumlahpesanan11;
       int modal11 = Integer.parseInt(m.getHarga_modal());
       int untung = (hrgminuman11 - modal11)*jumlahpesanan11;
       String keuntungan11 = String.valueOf(untung);
       
        try {
             
               String sql = "INSERT INTO detail_trans VALUES (?,?,?,?,?)";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, menu.getTxtidtrans().getText());
               ps.setString(2, m.getKode_menu());
               ps.setString(3, jml);
               ps.setString(4, keuntungan11); 
               ps.setString(5, id_kasir); 
               ps.executeUpdate();
            } catch (Exception e) {
                 
            }
        }
     
     JOptionPane.showMessageDialog(menu, "Update Data Sukses :)",
             "Image Option",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Gambar/updatedata1.png"));
        
    }
    
    public void onKeyPressIdtrans(){
        menu.getTxtnamapelanggan().requestFocus();
    }
    public void cetakNota(){
         try {
            String file = "C:/Users/Salman Alfarissy/Documents/Klp4_Balanjokuy/Klp4_Balanjokuy/src/BJK/form/Report/reportNota.jasper";
            String idtrans = menu.getTxtidtrans().getText();
             HashMap param = new HashMap();
             param.put("id_trans", idtrans);
            JasperPrint Jp = JasperFillManager.fillReport(file, param,conn);
            JasperViewer Jv = new JasperViewer(Jp, false);
            Jv.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error");
        }
    }
}

