package com.example.qlch_phuot.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qlch_phuot.DAO.SanPhamDAO;
import com.example.qlch_phuot.R;
import com.example.qlch_phuot.model.SanPham;
import com.example.qlch_phuot.model.TheLoai;

import java.util.List;

public class SanPhamAdapter extends BaseAdapter {

    List<SanPham> arrSanPham;
    public Activity context;
    public LayoutInflater inflater;
    SanPhamDAO sanPhamDAO;

    public SanPhamAdapter(Activity context, List<SanPham> arrSanPham) {
        this.arrSanPham = arrSanPham;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        sanPhamDAO = new SanPhamDAO(context);
    }

    @Override
    public int getCount() {
        return arrSanPham.size();
    }

    @Override
    public Object getItem(int position) {
        return arrSanPham.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public static class ViewHolder {
        ImageView imvSP;
        TextView tvMaSP;
        TextView tvTenSP;
        TextView tvGiaSP;
        ImageView imvDelete;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_sanpham, null);
            viewHolder.imvSP = convertView.findViewById(R.id.imvSP);
            viewHolder.tvMaSP = convertView.findViewById(R.id.tvMaSP);
            
        }
        return null;
    }
}
