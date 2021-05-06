/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BJK.controler;

import javax.swing.table.DefaultTableModel;
import BJK.form.FormReport1;
import BJK.form.FormReportMingguan;
import BJK.form.FormReportBulanan;
import BJK.form.FormReportTahunan;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import BJK.model.koneksi;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author Salman Alfarissy
 */
public class ControllerReport {
    private DefaultTableModel tabmode;
    private FormReport1 report;
    private FormReportMingguan reportmingguan;
    private FormReportBulanan reportbulanan;
    private FormReportTahunan reporttahun;
    
    int value = 1;
  
    private koneksi koneksi;
    Connection conn = koneksi.getKoneksi();

    public ControllerReport(FormReport1 report) {
        this.report = report;
    }

    public ControllerReport(FormReportMingguan reportmingguan) {
        this.reportmingguan = reportmingguan;
    }
    public ControllerReport(FormReportBulanan reportbulanan) {
        this.reportbulanan = reportbulanan;
    }

    public ControllerReport(FormReportTahunan reporttahun) {
        this.reporttahun = reporttahun;
    }
    
    
    
    
     public void tampil_Reportnow(){
        Object[]baris = {"Id Transaksi","Nama Menu", "Nama Kasir","Tanggal Transaksi","Jumlah Terjual","Keuntungan"};
        tabmode= new DefaultTableModel(null, baris);
        report.getTblreport().setModel(tabmode);
        String sql = "SELECT id_trans,kode_menu,namakasir,tgltrans,jml_terjual,keuntungan from ttrans " +
"join detail_trans using(id_trans) join tkasir using(idkasir) join tmenu using(kode_menu)" +
"where tgltrans = date(now())" +
" order by id_trans";
        try { 
            value = 1;
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            int totuntung = 0;
            while (hasil.next()){
                String Id_trans = hasil.getString("id_trans");
                String kode_menu = hasil.getString("namamenu");
                String jml_terjual = hasil.getString("jml_terjual");
                String keuntungan = hasil.getString("keuntungan");
                String namakasir = hasil.getString("namakasir");
                String tgl_trans = hasil.getString("tgltrans");
                totuntung = Integer.parseInt(keuntungan)+totuntung;
                String[]data = {Id_trans,kode_menu,namakasir,tgl_trans,jml_terjual,keuntungan};
                tabmode.addRow(data);
            }
            report.getTxttot().setText(String.valueOf(totuntung));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Menampilkan data GAGAL", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    
     public void tampil_Reportall(){
        Object[]baris = {"Id Transaksi","Nama Menu", "Nama Kasir","Tanggal Transaksi","Jumlah Terjual","Keuntungan"};
        tabmode= new DefaultTableModel(null, baris);
        report.getTblreport().setModel(tabmode);
        String sql = "SELECT id_trans,namamenu,jml_terjual,keuntungan,namakasir,tgltrans from ttrans join detail_trans using(id_trans) join tkasir using(idkasir) join tmenu using(kode_menu) order by id_trans";
        try { 
            value = 2;
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            int totuntung = 0;
            while (hasil.next()){
                String Id_trans = hasil.getString("id_trans");
                String kode_menu = hasil.getString("namamenu");
                String jml_terjual = hasil.getString("jml_terjual");
                String keuntungan = hasil.getString("keuntungan");
                String namakasir = hasil.getString("namakasir");
                String tgl_trans = hasil.getString("tgltrans");
                totuntung = Integer.parseInt(keuntungan)+totuntung;
                String[]data = {Id_trans,kode_menu,namakasir,tgl_trans,jml_terjual,keuntungan};
                tabmode.addRow(data);
            }
            report.getTxttot().setText(String.valueOf(totuntung));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Menampilkan data GAGAL", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
     public void tampil_ReportHari(){
        String tgl = "",bln="",thn="",tglreport="";
        tgl = report.getC_tgl().getSelectedItem().toString();
        bln = report.getC_bln().getSelectedItem().toString();
        thn = report.getC_thn().getSelectedItem().toString();
        tglreport = thn+"-"+bln+"-"+tgl;
        String sql = "SELECT  id_trans,namamenu,jml_terjual,keuntungan,namakasir,tgltrans from ttrans join detail_trans using(id_trans) join tkasir using(idkasir) join tmenu using(kode_menu) where tgltrans ='"+tglreport+"' order by id_trans;";
        
        Object[]baris = {"Id Transaksi","Nama Menu", "Nama Kasir","Tanggal Transaksi","Jumlah Terjual","Keuntungan"};
        
        tabmode= new DefaultTableModel(null, baris);
        report.getTblreport().setModel(tabmode);
        
        try { 
            value = 3;
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            int totuntung = 0;
            while (hasil.next()){
                String Id_trans = hasil.getString("id_trans");
                String kode_menu = hasil.getString("namamenu");
                String jml_terjual = hasil.getString("jml_terjual");
                String keuntungan = hasil.getString("keuntungan");
                String namakasir = hasil.getString("namakasir");
                String tgl_trans = hasil.getString("tgltrans");
                totuntung = Integer.parseInt(keuntungan)+totuntung;
                String[]data = {Id_trans,kode_menu,namakasir,tgl_trans,jml_terjual,keuntungan};
                tabmode.addRow(data);
            }
            report.getTxttot().setText(String.valueOf(totuntung));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Menampilkan data GAGAL", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
     public void tampil_ReportMingguan(){
        String tgl = "",bln="",thn="",tglreport="";
        tgl = "01";
        bln = reportmingguan.getC_bln().getSelectedItem().toString();
        thn = reportmingguan.getC_thn().getSelectedItem().toString();
        tglreport = thn+"-"+bln+"-"+tgl;
        String sql = "SELECT namakasir,RIGHT(YEARWEEK(tgltrans), 2),namamenu,sum(jml_terjual),sum(keuntungan) from ttrans join detail_trans using(id_trans) join tkasir using(idkasir) join tmenu using(kode_menu) WHERE CONCAT(YEAR(tgltrans),'/',MONTH(tgltrans))=CONCAT(YEAR('"+tglreport+"'),'/',MONTH('"+tglreport+"')) GROUP BY namamenu order by RIGHT(YEARWEEK(tgltrans), 2) asc ";
        
        Object[]baris = { "Nama Kasir","Minggu Ke","Nama Menu","Jumlah Terjual","Keuntungan"};
        
        tabmode= new DefaultTableModel(null, baris);
        reportmingguan.getTblreport().setModel(tabmode);
        
        try { 
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            int totuntung = 0;
            while (hasil.next()){
                String jml_terjual = hasil.getString("sum(jml_terjual)");
                String keuntungan = hasil.getString("sum(keuntungan)");
                String namakasir = hasil.getString("namakasir");
                String namamenu = hasil.getString("namamenu");
                String tgl_trans = hasil.getString("RIGHT(YEARWEEK(tgltrans), 2)");
                totuntung = Integer.parseInt(keuntungan)+totuntung;
                String[]data = {namakasir,tgl_trans,namamenu,jml_terjual,keuntungan};
                tabmode.addRow(data);
            }
            reportmingguan.getTxttot().setText(String.valueOf(totuntung));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Menampilkan data GAGAL", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
     public void tampil_ReportBulanan(){
       String tgl = "",bln="",thn="",tglreport="";
        tgl = "01";
        bln = "01";
        thn = reportbulanan.getC_thn().getSelectedItem().toString();
        tglreport = thn+"-"+bln+"-"+tgl;
        String sql = "SELECT namakasir,CONCAT(YEAR(tgltrans),'/',MONTH(tgltrans)),namamenu,sum(jml_terjual),sum(keuntungan) \n" +
"FROM ttrans join detail_trans using(id_trans) join tkasir using(idkasir) join tmenu using(kode_menu) \n" +
"WHERE YEAR(tgltrans)=YEAR('"+tglreport+"') GROUP BY namamenu asc;";
        
        Object[]baris = { "Nama Kasir","Tahun/Bulan","Nama Menu","Jumlah Terjual","Keuntungan"};
        
        tabmode= new DefaultTableModel(null, baris);
        reportbulanan.getTblreport().setModel(tabmode);
        
        try { 
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            int totuntung = 0;
            while (hasil.next()){
                String jml_terjual = hasil.getString("sum(jml_terjual)");
                String keuntungan = hasil.getString("sum(keuntungan)");
                String namamenu = hasil.getString("namamenu");
                String idkasir = hasil.getString("namakasir");
                String tgl_trans = hasil.getString("CONCAT(YEAR(tgltrans),'/',MONTH(tgltrans))");
                totuntung = Integer.parseInt(keuntungan)+totuntung;
                String[]data = {idkasir,tgl_trans,namamenu,jml_terjual,keuntungan};
                tabmode.addRow(data);
            }
            reportbulanan.getTxttot().setText(String.valueOf(totuntung));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Menampilkan data GAGAL", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
     public void tampil_ReportTahunan(){
         
        String sql = "SELECT namakasir,YEAR(tgltrans),namamenu,sum(jml_terjual),sum(keuntungan)\n" +
"FROM ttrans join detail_trans using(id_trans) join tkasir using(idkasir) join tmenu using(kode_menu)\n" +
"GROUP BY namamenu order by YEAR(tgltrans) asc";
        
        Object[]baris = { "Nama Kasir","Tahun","Nama Menu","Jumlah Terjual","Keuntungan"};
        
        tabmode= new DefaultTableModel(null, baris);
        reporttahun.getTblreport().setModel(tabmode);
        
        try { 
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            int totuntung = 0;
            while (hasil.next()){
                String jml_terjual = hasil.getString("sum(jml_terjual)");
                String keuntungan = hasil.getString("sum(keuntungan)");
                String idkasir = hasil.getString("namakasir");
                String namamenu = hasil.getString("namamenu");
                String tgl_trans = hasil.getString("YEAR(tgltrans)");
                totuntung = Integer.parseInt(keuntungan)+totuntung;
                String[]data = {idkasir,tgl_trans,namamenu,jml_terjual,keuntungan};
                tabmode.addRow(data);
            }
            reporttahun.getTxttot().setText(String.valueOf(totuntung));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Menampilkan data GAGAL", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    } 
     
     public void print1(){
        try {
        switch (value){
            case 1:
            String file0 = "C:/Users/Salman Alfarissy/Documents/Klp4_Balanjokuy/Klp4_Balanjokuy/src/BJK/form/Report/reportNow.jasper";
            JasperPrint Jp0 = JasperFillManager.fillReport(file0, null,conn);
            JasperViewer Jv0 = new JasperViewer(Jp0, false);
            Jv0.setVisible(true);
                break;
            case 2:
            String file1 = "C:/Users/Salman Alfarissy/Documents/Klp4_Balanjokuy/Klp4_Balanjokuy/src/BJK/form/Report/reportAll.jasper";
            JasperPrint Jp1 = JasperFillManager.fillReport(file1, null,conn);
            JasperViewer Jv1 = new JasperViewer(Jp1, false);
            Jv1.setVisible(true);
                break;
            case 3:
            String tgl = "",bln="",thn="",tglreport="";
            tgl = report.getC_tgl().getSelectedItem().toString();
            bln = report.getC_bln().getSelectedItem().toString();
            thn = report.getC_thn().getSelectedItem().toString();
            tglreport = thn+"-"+bln+"-"+tgl;
            String file2 = "C:/Users/Salman Alfarissy/Documents/Klp4_Balanjokuy/Klp4_Balanjokuy/src/BJK/form/Report/findReport.jasper";
            HashMap param = new HashMap();
            param.put("tgltrans", tglreport);
            JasperPrint Jp2 = JasperFillManager.fillReport(file2, param,conn);
            JasperViewer Jv2 = new JasperViewer(Jp2, false);
            Jv2.setVisible(true);
                break;
        }
        } catch (Exception e) {
         }

}
     public void printMingguan(){
         try {
            String tgl = "",bln="",thn="",tglreport="";
            tgl = "01";
            bln = reportmingguan.getC_bln().getSelectedItem().toString();
            thn = reportmingguan.getC_thn().getSelectedItem().toString();
            tglreport = thn+"-"+bln+"-"+tgl;
            String file = "C:/Users/Salman Alfarissy/Documents/Klp4_Balanjokuy/Klp4_Balanjokuy/src/BJK/form/Report/reportMingguan.jasper";
            HashMap param = new HashMap();
            param.put("tgltrans", tglreport);
            JasperPrint Jp = JasperFillManager.fillReport(file, param,conn);
            JasperViewer Jv = new JasperViewer(Jp, false);
            Jv.setVisible(true);
            
         } catch (Exception e) {
         }
     }
     public void printBulanan(){
         try {
            String tgl = "",bln="",thn="",tglreport="";
            tgl = "01";
            bln = "01";
            thn = reportbulanan.getC_thn().getSelectedItem().toString();
            tglreport = thn+"-"+bln+"-"+tgl;
            String file = "C:/Users/Salman Alfarissy/Documents/Klp4_Balanjokuy/Klp4_Balanjokuy/src/BJK/form/Report/reportBulanan.jasper";
            HashMap param = new HashMap();
            param.put("tgltrans", tglreport);
            JasperPrint Jp = JasperFillManager.fillReport(file, param,conn);
            JasperViewer Jv = new JasperViewer(Jp, false);
            Jv.setVisible(true);
            
         } catch (Exception e) {
         }
     }
     public void printTahunan(){
         try {
            
            String file = "C:/Users/Salman Alfarissy/Documents/Klp4_Balanjokuy/Klp4_Balanjokuy/src/BJK/form/Report/reportTahunan.jasper";
            JasperPrint Jp = JasperFillManager.fillReport(file, null,conn);
            JasperViewer Jv = new JasperViewer(Jp, false);
            Jv.setVisible(true);
            
         } catch (Exception e) {
         }
     }
}
