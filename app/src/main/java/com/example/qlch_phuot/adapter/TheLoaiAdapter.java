package com.example.qlch_phuot.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.example.qlch_phuot.DAO.TheLoaiDAO;
import com.example.qlch_phuot.R;
import com.example.qlch_phuot.activity.DetailTheLoai_Activity;
import com.example.qlch_phuot.activity.ListTheLoai_Activity;
import com.example.qlch_phuot.model.TheLoai;

import java.util.List;

public class TheLoaiAdapter extends BaseAdapter {
    List<TheLoai> arrTheLoai;
    public LayoutInflater inflater;
    public ListTheLoai_Activity context;
    TheLoaiDAO theLoaiDAO;

    public TheLoaiAdapter(ListTheLoai_Activity context, List<TheLoai> arrTheLoai) {
        this.arrTheLoai = arrTheLoai;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        theLoaiDAO = new TheLoaiDAO(context);
    }

    @Override
    public int getCount() {
        return arrTheLoai.size();
    }

    @Override
    public Object getItem(int position) {
        return arrTheLoai.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public static class viewHolder {
        ImageView imgTL;
        TextView tvMaTL;
        TextView tvTenTL;
        ImageView imgDelete;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final viewHolder holder;
        if (convertView == null) {
            holder = new viewHolder();
            convertView = inflater.inflate(R.layout.item_theloai, null);
            holder.imgTL = (ImageView) convertView.findViewById(R.id.imvTL);
            holder.tvMaTL = (TextView) convertView.findViewById(R.id.tvMaTL);
            holder.tvTenTL = (TextView) convertView.findViewById(R.id.tvTenTL);
            holder.imgDelete = (ImageView) convertView.findViewById(R.id.imvDelete);

            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    theLoaiDAO.deleteTheLoaibyID(arrTheLoai.get(position).getMaTheLoai());
                    arrTheLoai.remove(position);
                    notifyDataSetChanged();
                }
            });
            convertView.setTag(holder);
        } else
            holder = (viewHolder) convertView.getTag();
        TheLoai theLoai = (TheLoai) arrTheLoai.get(position);
        holder.imgTL.setImageResource(R.drawable.dobaoho);
        holder.tvMaTL.setText(theLoai.getMaTheLoai());
        holder.tvTenTL.setText(theLoai.getTenTheLoai());
        return convertView;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }


}
