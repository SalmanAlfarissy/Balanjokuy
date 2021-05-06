/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BJK.model;

/**
 *
 * @author Salman Alfarissy
 */
public class Transaksi {
    private String id_trans;
    private String tgltrans;
    private String jmlpesanan;
    private String totalbyr;
    private String jml_byr;

    public String getId_trans() {
        return id_trans;
    }

    public void setId_trans(String id_trans) {
        this.id_trans = id_trans;
    }

    public String getTgltrans() {
        return tgltrans;
    }

    public void setTgltrans(String tgltrans) {
        this.tgltrans = tgltrans;
    }

    public String getJmlpesanan() {
        return jmlpesanan;
    }

    public void setJmlpesanan(String jmlpesanan) {
        this.jmlpesanan = jmlpesanan;
    }

    public String getTotalbyr() {
        return totalbyr;
    }

    public void setTotalbyr(String totalbyr) {
        this.totalbyr = totalbyr;
    }

    public String getJml_byr() {
        return jml_byr;
    }

    public void setJml_byr(String jml_byr) {
        this.jml_byr = jml_byr;
    }
    
    
    
}
