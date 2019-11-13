package com.example.qlch_phuot.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qlch_phuot.DAO.TheLoaiDAO;
import com.example.qlch_phuot.R;
import com.example.qlch_phuot.model.TheLoai;

public class AddTheLoai_Activity extends AppCompatActivity {

    EditText edMaTL, edTenTL, edMota, edVitri;
    TheLoaiDAO theLoaiDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_the_loai_);
        setTitle("THÊM THỂ LOẠI");
        init();
    }

    private void init() {
        edMaTL = findViewById(R.id.edMaTL);
        edTenTL = findViewById(R.id.edTenTL);
        edMota = findViewById(R.id.edmoTa);
        edVitri = findViewById(R.id.edVitri);
    }

    public void addNewTL(View view) {
        theLoaiDAO = new TheLoaiDAO(this);
        TheLoai theLoai = new TheLoai(edMaTL.getText().toString(), edTenTL.getText().toString(),
                edMota.getText().toString(), edVitri.getText().toString());
        try {
            if (validate() > 0) {
                boolean insertTrue = theLoaiDAO.insertTheLoai(theLoai);
                if (insertTrue) {
                    Toast.makeText(getApplicationContext(), "Thêm Thành Công",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Thêm thất Bại",
                            Toast.LENGTH_SHORT).show();
                }
            }

        } catch (Exception e) {

        }

    }

    private int validate() {
        int check = 1;
        if (edMaTL.getText().toString().isEmpty() || edTenTL.getText().toString().isEmpty()
                || edMota.getText().toString().isEmpty() || edVitri.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Vui lòng nhập đầy đủ thông tin",
                    Toast.LENGTH_SHORT).show();
            check = -1;
        }
        return check;
    }

    public void huyTL(View view) {
        finish();
    }

    public void listTL(View view) {
        Intent intent = new Intent(AddTheLoai_Activity.this, ListTheLoai_Activity.class);
        startActivity(intent);
        finish();
    }
}
