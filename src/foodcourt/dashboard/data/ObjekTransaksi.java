/*
 * Copyright June - 2018
 * JTK POLBAN.
 * Made in Ciwaruga.
 */
package foodcourt.dashboard.data;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class ObjekTransaksi {
    private Date tanggalTransaksi;
    private String ID;
    private String Toko;
    private double harga;
    
    public ObjekTransaksi(){
        
    }
    
    public ObjekTransaksi(Date tanggal, String id, String toko, double harga){
        this.setHarga(harga);
        this.setID(id);
        this.setTanggalTransaksi(tanggal);
        this.setToko(toko);
    }

    public Date getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(Date tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getToko() {
        return Toko;
    }

    public void setToko(String Toko) {
        this.Toko = Toko;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
    
    @Override
    public boolean equals(Object o){
        ObjekTransaksi OTR = (ObjekTransaksi) o;
        return (this.getTanggalTransaksi().equals(OTR.getTanggalTransaksi()) &&
                this.getID().equals(OTR.getID()));
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.tanggalTransaksi);
        hash = 89 * hash + Objects.hashCode(this.ID);
        hash = 89 * hash + Objects.hashCode(this.Toko);
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.harga) ^ (Double.doubleToLongBits(this.harga) >>> 32));
        return hash;
    }
    
    @Override
    public String toString(){
        return this.getTanggalTransaksi()+" | "+this.getID()+" - "+this.getToko()+" : "+this.getHarga();
    }
}
