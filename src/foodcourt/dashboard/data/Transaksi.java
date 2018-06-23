/*
 * Copyright June - 2018
 * JTK POLBAN.
 * Made in Ciwaruga.
 */
package foodcourt.dashboard.data;

import java.util.ArrayList;
import java.util.Objects;

/**
 * 
 * @author ASUS
 */
public class Transaksi {

    private String idTransaksi;
    private ArrayList<Penjualan> penjualan;

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public ArrayList<Penjualan> getPenjualan() {
        return penjualan;
    }

    public void setPenjualan(ArrayList<Penjualan> penjualan) {
        this.penjualan = penjualan;
    }
    
    @Override
    public boolean equals(Object o){
        Transaksi tr = (Transaksi) o;
        return (this.getIdTransaksi().equals(tr.getIdTransaksi()));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.idTransaksi);
        hash = 31 * hash + Objects.hashCode(this.penjualan);
        return hash;
    }

}
