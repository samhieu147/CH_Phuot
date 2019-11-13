package com.example.qlch_phuot.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.core.app.NavUtils;

import com.example.qlch_phuot.database.DatabaseHelper;
import com.example.qlch_phuot.model.TheLoai;

import java.util.ArrayList;
import java.util.List;

public class TheLoaiDAO {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    public static final String TABLE_NAME = "TheLoai";
    public static final String SQL_THE_LOAI = "CREATE TABLE TheLoai(matheloai text primary key," +
            "tentheloai text, mota text, vitri text);";

    public TheLoaiDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();

    }

    //Insert
    public boolean insertTheLoai(TheLoai theLoai) {
        ContentValues values = new ContentValues();
        values.put("matheloai", theLoai.getMaTheLoai());
        values.put("tentheloai", theLoai.getTenTheLoai());
        values.put("mota", theLoai.getMoTa());
        values.put("vitri", theLoai.getViTri());
        long result = db.insert(TABLE_NAME, null, values);
        try {
            if (result == -1) {
                return false;
            }

        } catch (Exception e) {
            Log.e("TheLoaiDAO", e.toString());
            return false;
        }
        return true;

    }

    public List<TheLoai> getAllTheLoai() {
        List<TheLoai> dsTheLoai = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null,
                null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            TheLoai theLoai = new TheLoai();
            theLoai.setMaTheLoai(c.getString(0));
            theLoai.setTenTheLoai(c.getString(1));
            theLoai.setMoTa(c.getString(2));
            theLoai.setViTri(c.getString(3));
            dsTheLoai.add(theLoai);
            Log.d("//=====", theLoai.toString());
            c.moveToNext();

        }
        c.close();
        return dsTheLoai;
    }

    //Update
    public int updateTheLoaiByID(String matheloai, String tentheloai, String mota, String vitri) {
        ContentValues values = new ContentValues();
        values.put("TENTHELOAI", tentheloai);
        values.put("MOTA", mota);
        values.put("VITRI", vitri);
        int result = db.update(TABLE_NAME, values, "matheloai=?", new String[]{matheloai});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    //Delete
    public int deleteTheLoaibyID(String matheloai) {
        int result = db.delete(TABLE_NAME, "matheloai=?", new String[]{matheloai});
        if (result == 0) {
            return -1;
        }
        return 1;
    }
}
