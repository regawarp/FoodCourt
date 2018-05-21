/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodcourt;

/**
 *
 * @author lenovo
 */
public class MenuMakanan {
    
    private String namaMenu;
    private int quantity;
    private String keterangan;
    
    String getNamaMenu(){
        return this.namaMenu;
    }

    void setNamaMenu(String namaMenu){
        this.namaMenu = namaMenu;
    }

    int getQuantity(){
        return this.quantity;
    }

    void setQuantity(int quantity){
        this.quantity = quantity;
    }
    
    String getKeterangan(){
        return this.keterangan;
    }

    void setKeterangan(String keterangan){
        this.keterangan = keterangan;
    }

    
}
