package com.example.qlch_phuot.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.qlch_phuot.DAO.SanPhamDAO;
import com.example.qlch_phuot.DAO.TheLoaiDAO;
import com.example.qlch_phuot.R;
import com.example.qlch_phuot.model.SanPham;
import com.example.qlch_phuot.model.TheLoai;

import java.util.ArrayList;
import java.util.List;

public class AddSanPham_Activity extends AppCompatActivity {

    SanPhamDAO sanPhamDAO;
    TheLoaiDAO theLoaiDAO;
    EditText edMaSP, edTenSP, edSoLuong, edGiaBan;
    Spinner spnTheLoai;
    List<TheLoai> listTheLoai = new ArrayList<>();
    String matheloai = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_san_pham_);
        init();
        getTheLoai();
        spnTheLoai.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                matheloai = listTheLoai.get(spnTheLoai.getSelectedItemPosition()).getMaTheLoai();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void init() {
        spnTheLoai = findViewById(R.id.spnTheLoai);
        edMaSP = findViewById(R.id.edMaSP);
        edTenSP = findViewById(R.id.edTenSP);
        edGiaBan = findViewById(R.id.edGiaBan);
        edSoLuong = findViewById(R.id.edSoLuong);
    }


    private void getTheLoai() {
        theLoaiDAO = new TheLoaiDAO(AddSanPham_Activity.this);
        listTheLoai = theLoaiDAO.getAllTheLoai();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, listTheLoai);
        spnTheLoai.setAdapter(adapter);
    }

    public void addnewSP(View view) {
        sanPhamDAO = new SanPhamDAO(AddSanPham_Activity.this);
        SanPham sanPham = new SanPham(edMaSP.getText().toString(), matheloai, edTenSP.getText().toString(),
                Double.parseDouble(edGiaBan.getText().toString()), Integer.parseInt(edSoLuong.getText().toString()));
        boolean isInsert = sanPhamDAO.insertSanPham(sanPham);
        if (isInsert) {
            Toast.makeText(this, "Thêm Thành Công", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Thêm Thất Bại", Toast.LENGTH_SHORT).show();
        }

    }

    private int validate() {
        int check = 1;
        if (edMaSP.getText().toString().isEmpty() || edTenSP.getText().toString().isEmpty() ||
                edGiaBan.getText().toString().isEmpty() || edSoLuong.getText().toString().isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            check = -1;
        }
        return check;
    }


}
