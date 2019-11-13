package com.example.qlch_phuot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.qlch_phuot.activity.ListSanPham_Activity;
import com.example.qlch_phuot.activity.ListTheLoai_Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("ThichDiPhuot");


    }


    public void theLoai(View view) {
        startActivity(new Intent(MainActivity.this, ListTheLoai_Activity.class));
    }

    public void sanPham(View view) {
        startActivity(new Intent(MainActivity.this, ListSanPham_Activity.class));
    }
}
