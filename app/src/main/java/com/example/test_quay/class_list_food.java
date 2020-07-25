package com.example.test_quay;

import java.io.Serializable;

public class class_list_food implements Serializable {
    //cái image hình ngôi sao chưa biết sửa lý như thế nào để cho có thể thay đổi các đánh giá
    private  int id;
    private String hinhanh,tenmon;
    private int gia,soluong;
    private String Time;
    //làm riêng cho thằng hiển thị thời gian//
    public class_list_food(String time) {
        Time = time;
    }

    public String getTime() {
        return Time;
    }
    public void setTime(String time) {
        Time = time;
    }
    // kết thúc thằng hiển thị thời gian//


    public class_list_food(int id, String tenmon, int gia, int soluong, String hinhanh) {
        this.id = id;
        this.hinhanh = hinhanh;
        this.tenmon = tenmon;
        this.gia = gia;
        this.soluong = soluong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
}
