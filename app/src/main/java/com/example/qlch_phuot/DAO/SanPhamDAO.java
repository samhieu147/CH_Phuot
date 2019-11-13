package com.example.qlch_phuot.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.qlch_phuot.database.DatabaseHelper;
import com.example.qlch_phuot.model.SanPham;
import com.example.qlch_phuot.model.TheLoai;

import java.util.ArrayList;
import java.util.List;

public class SanPhamDAO {

    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    public SanPhamDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public static final String TABLE_NAME = "SanPham";
    public static final String SQL_SAN_PHAM = "CREATE TABLE SanPham (masanpham text primary key," +
            "matheloai text,tensanpham text,giaban double,soluong int);";

    public boolean insertSanPham(SanPham sp) {
        ContentValues values = new ContentValues();
        values.put("masanpham", sp.getMaSanPham());
        values.put("matheloai", sp.getMaTheLoai());
        values.put("tensanpham", sp.getTenSanPham());
        values.put("giaban", sp.getGiaBan());
        values.put("soluong", sp.getSoLuong());

        long result = db.insert(TABLE_NAME, null, values);
        try {
            if (result == -1) {
                return false;
            }

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<SanPham> getAllSanPham() {
        List<SanPham> dsSanPham = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null,
                null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            SanPham sanPham = new SanPham();
            sanPham.setMaSanPham(c.getString(0));
            sanPham.setMaTheLoai(c.getString(1));
            sanPham.setTenSanPham(c.getString(2));
            sanPham.setGiaBan(c.getDouble(3));
            sanPham.setSoLuong(c.getInt(4));
            dsSanPham.add(sanPham);
        }
        c.close();
        return dsSanPham;

    }
}
