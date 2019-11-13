package com.example.qlch_phuot.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.qlch_phuot.DAO.TheLoaiDAO;
import com.example.qlch_phuot.R;
import com.example.qlch_phuot.adapter.TheLoaiAdapter;
import com.example.qlch_phuot.model.TheLoai;

import java.util.ArrayList;
import java.util.List;

public class ListTheLoai_Activity extends AppCompatActivity {

    List<TheLoai> dsTheLoai = new ArrayList<>();
    TheLoaiAdapter adapter = null;
    TheLoaiDAO theLoaiDAO;
    ListView lvTheLoai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_the_loai_);
        setTitle("THỂ LOẠI");
        lvTheLoai = findViewById(R.id.lvTheLoai);

        theLoaiDAO = new TheLoaiDAO(ListTheLoai_Activity.this);
        dsTheLoai = theLoaiDAO.getAllTheLoai();
        adapter = new TheLoaiAdapter(this, dsTheLoai);
        lvTheLoai.setAdapter(adapter);
        lvTheLoai.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListTheLoai_Activity.this,DetailTheLoai_Activity.class);
                Bundle bundle = new Bundle();
                bundle.putString("MATHELOAI",dsTheLoai.get(position).getMaTheLoai());
                bundle.putString("TENTHELOAI",dsTheLoai.get(position).getTenTheLoai());
                bundle.putString("MOTA",dsTheLoai.get(position).getMoTa());
                bundle.putString("VITRI",dsTheLoai.get(position).getViTri());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_theloai, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.addTheLoai:
                intent = new
                        Intent(ListTheLoai_Activity.this, AddTheLoai_Activity.class);
                startActivity(intent);
                return (true);

        }
        return super.onOptionsItemSelected(item);

    }
}
