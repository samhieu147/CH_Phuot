package com.example.qlch_phuot.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qlch_phuot.DAO.TheLoaiDAO;
import com.example.qlch_phuot.R;

public class DetailTheLoai_Activity extends AppCompatActivity {

    EditText edTenTL, edMota, edVitri;
    EditText tvMaTL;
    String matl, tentl, mta, vitri;
    TheLoaiDAO theLoaiDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_the_loai_);
        init();
        getData();
        setData();
    }

    private void setData() {
        tvMaTL.setText(matl);
        edTenTL.setText(tentl);
        edMota.setText(mta);
        edVitri.setText(vitri);
    }

    private void getData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        matl = bundle.getString("MATHELOAI");
        tentl = bundle.getString("TENTHELOAI");
        mta = bundle.getString("MOTA");
        vitri = bundle.getString("VITRI");
    }

    private void init() {
        edMota = findViewById(R.id.edmoTa);
        edTenTL = findViewById(R.id.edTenTL);
        edVitri = findViewById(R.id.edVitri);
        tvMaTL = findViewById(R.id.tvMaTL);
    }

    public void updateTL(View view) {
        theLoaiDAO = new TheLoaiDAO(DetailTheLoai_Activity.this);
        if (validate() > 0) {
            if (theLoaiDAO.updateTheLoaiByID(tvMaTL.getText().toString(), edTenTL.getText().toString(),
                    edMota.getText().toString(), edVitri.getText().toString()) > 0) {
                Toast.makeText(this, "Update Thành Công ", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(DetailTheLoai_Activity.this, ListTheLoai_Activity.class));
                finish();
            } else {
                Toast.makeText(this, "Update Thất Bại ", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private int validate() {
        int check = 1;
        if (tvMaTL.getText().toString().isEmpty() || edTenTL.getText().toString().isEmpty() ||
                edMota.getText().toString().isEmpty() || edVitri.getText().toString().isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin ", Toast.LENGTH_SHORT).show();
            check = -1;
        }
        return check;
    }


    public void huyTL(View view) {
        finish();
    }
}
