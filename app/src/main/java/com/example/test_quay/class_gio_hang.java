package com.example.test_quay;

import java.io.Serializable;

public class class_gio_hang implements Serializable {
    private int  id,somondat,tongTienmonan;
    private String tenmon,ghichu;
    private String hinhmon;

    public class_gio_hang(String hinhmon,String tenmon,String ghichu,int somondat, int tongTienmonan) {
        this.somondat = somondat;
        this.tongTienmonan = tongTienmonan;
        this.tenmon = tenmon;
        this.ghichu = ghichu;
        this.hinhmon = hinhmon;
    }

    public class_gio_hang(int id, String tenmon , int tongTienmonan, int somondat, String ghichu, String hinhmon) {
        this.id = id;
        this.hinhmon = hinhmon;
        this.somondat = somondat;
        this.tongTienmonan = tongTienmonan;
        this.tenmon = tenmon;
        this.ghichu = ghichu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHinhmon() {
        return hinhmon;
    }

    public void setHinhmon(String hinhmon) {
        this.hinhmon = hinhmon;
    }

    public int getSomondat() {
        return somondat;
    }

    public void setSomondat(int somondat) {
        this.somondat = somondat;
    }

    public int getTongTienmonan() {
        return tongTienmonan;
    }

    public void setTongTienmonan(int tongTienmonan) {
        this.tongTienmonan = tongTienmonan;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
}
