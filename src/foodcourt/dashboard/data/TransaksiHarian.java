/*
 * Copyright June - 2018
 * JTK POLBAN.
 * Made in Ciwaruga.
 */
package foodcourt.dashboard.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class TransaksiHarian {
    private Date tglTransaksi = new Date();
    private ArrayList<Transaksi> listTr;

    public Date getTglTransaksi() {
        return tglTransaksi;
    }

    public void setTglTransaksi(Date tglTransaksi) {
        this.tglTransaksi = tglTransaksi;
    }

    public ArrayList<Transaksi> getListTr() {
        return listTr;
    }

    public void setListTr(ArrayList<Transaksi> listTr) {
        this.listTr = listTr;
    }
    
    @Override
    public boolean equals(Object o){
        TransaksiHarian thr = (TransaksiHarian) o;
        return this.getTglTransaksi().equals(thr.getTglTransaksi());
    } 

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.tglTransaksi);
        hash = 83 * hash + Objects.hashCode(this.listTr);
        return hash;
    }
}
