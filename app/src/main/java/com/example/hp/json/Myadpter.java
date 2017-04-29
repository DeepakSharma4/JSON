package com.example.hp.json;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hp on 4/13/2017.
 */

public class Myadpter extends BaseAdapter {
    private Context context;
    private List<model> arrylist;
    private LayoutInflater inflater;

    public Myadpter(Context context, List<model> arrylist) {
        this.context = context;
        this.arrylist = arrylist;
    }


    @Override
    public int getCount() {
        return arrylist.size();
    }

    @Override
    public Object getItem(int position) {
        return arrylist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.mylayout, parent, false);

        //Getting views of single row
        TextView txtid = (TextView) convertView.findViewById(R.id.id);
        TextView txtNAme = (TextView) convertView.findViewById(R.id.name);
        TextView txtsalary = (TextView) convertView.findViewById(R.id.salary);


        model mm = arrylist.get(position);
        //getting values
        int id = mm.getId();
        String n = mm.getName();
        int salary = mm.getSalary();

        //Setting values in views
        txtid.setText(String.valueOf(id));  //string value of() used to convert int to string for txtview.
        txtNAme.setText(n);
        txtsalary.setText(String.valueOf(salary));


        return convertView;

    }
}
