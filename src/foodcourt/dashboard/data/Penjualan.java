/*
 * Copyright June - 2018
 * JTK POLBAN.
 * Made in Ciwaruga.
 */
package foodcourt.dashboard.data;

import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class Penjualan {
    private String toko;
    private double harga;

    public String getToko() {
        return toko;
    }

    public void setToko(String toko) {
        this.toko = toko;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
    
    @Override
    public boolean equals (Object o){
        Penjualan pj = (Penjualan) o;
        return pj.getToko().equals(pj.getToko());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.toko);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.harga) ^ (Double.doubleToLongBits(this.harga) >>> 32));
        return hash;
    }
}
