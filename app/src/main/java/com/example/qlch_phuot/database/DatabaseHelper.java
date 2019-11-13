package com.example.qlch_phuot.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.qlch_phuot.DAO.SanPhamDAO;
import com.example.qlch_phuot.DAO.TheLoaiDAO;
import com.example.qlch_phuot.model.TheLoai;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "ab";
    public static final int VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TheLoaiDAO.SQL_THE_LOAI);
        db.execSQL(SanPhamDAO.SQL_SAN_PHAM);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TheLoaiDAO.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+SanPhamDAO.TABLE_NAME);

    }
}
