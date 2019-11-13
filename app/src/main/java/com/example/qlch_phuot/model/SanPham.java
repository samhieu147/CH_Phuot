package com.example.qlch_phuot.model;

public class SanPham {
    String maSanPham, maTheLoai, TenSanPham;
    Double giaBan;
    int soLuong;

    public SanPham() {
    }

    public SanPham(String maSanPham, String maTheLoai, String tenSanPham, Double giaBan, int soLuong) {
        this.maSanPham = maSanPham;
        this.maTheLoai = maTheLoai;
        TenSanPham = tenSanPham;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(String maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        TenSanPham = tenSanPham;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String toString() {
      return this.maSanPham + " | " +this.TenSanPham;
    }

}
