package com.hcmus.tinyscanner;

/**
 * Created by XuanThai_VaiO on 1/1/2017.
 */

public class document {
    private String MoTa;
    private int HinhAnh;
    private Boolean check;

    public document(String moTa, int hinhAnh, Boolean check) {
        MoTa = moTa;
        HinhAnh = hinhAnh;
        this.check = check;
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }

    public String getMoTa() {
        return MoTa;
    }

    public int getHinhAnh() {
        return HinhAnh;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public void setHinhAnh(int hinhAnh) {
        HinhAnh = hinhAnh;
    }
}
