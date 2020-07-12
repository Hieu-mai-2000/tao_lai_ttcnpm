package com.example.test_quay;

import java.io.Serializable;

public class class_quay_hang implements Serializable {
    private int id;
    private String Ten;
    private String Hinh;

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String hinh) {
        Hinh = hinh;
    }

    public class_quay_hang(int id, String ten, String hinh) {
        this.id = id;
        Ten = ten;
        Hinh = hinh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public class_quay_hang(int id, String ten, String hinh, int gia, int soluong) {
        Ten = ten;
        Hinh = hinh;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }


}

