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
public class Dataset {
    private String info;
    private int value;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    @Override
    public boolean equals(Object o){
        Dataset obj = (Dataset) o;
        return this.getInfo().equals(obj.getInfo());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.info);
        hash = 83 * hash + this.value;
        return hash;
    }
}
