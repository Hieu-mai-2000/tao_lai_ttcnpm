package com.example.test_quay;

import java.io.Serializable;

public class class_gio_hang implements Serializable {
    private int  id,somondat,tongTienmonan;
    private String tenmon,ghichu;
    private String hinhmon;
    private  int id_KH,Ma_Food;

    public class_gio_hang(int id_KH,int Ma_Food,String hinhmon,String tenmon,String ghichu,int somondat, int tongTienmonan) {
        this.id_KH = id_KH;
        this.Ma_Food = Ma_Food;
        this.somondat = somondat;
        this.tongTienmonan = tongTienmonan;
        this.tenmon = tenmon;
        this.ghichu = ghichu;
        this.hinhmon = hinhmon;
    }

    public int getId_KH() {
        return id_KH;
    }

    public void setId_KH(int id_KH) {
        this.id_KH = id_KH;
    }

    public int getMa_Food() {
        return Ma_Food;
    }

    public void setMa_Food(int ma_Food) {
        Ma_Food = ma_Food;
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
