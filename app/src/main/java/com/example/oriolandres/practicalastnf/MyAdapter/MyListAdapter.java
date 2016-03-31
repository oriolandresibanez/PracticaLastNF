package com.example.oriolandres.practicalastnf.MyAdapter;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.oriolandres.practicalastnf.Model.ItemModel;
import com.example.oriolandres.practicalastnf.R;

import java.util.List;

public class MyListAdapter extends BaseAdapter {

    private Activity activity;
    private List<ItemModel> model;
    private LayoutInflater inflater;
    private int item_layout;

    public MyListAdapter(Activity activity, List<ItemModel> model,int item_layout) {
        this.activity = activity;
        this.model = model;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.item_layout = item_layout;
    }

    @Override
    public int getCount() {
        return this.model.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){convertView = this.inflater.inflate(item_layout,null);}

        TextView nombrePersona = (TextView) convertView.findViewById(R.id.textNombrePers);
        TextView textoDescrip = (TextView) convertView.findViewById(R.id.textDescripc);

        nombrePersona.setText(model.get(position).getNombrePersona());
        textoDescrip.setText(model.get(position).getDinero());

        return convertView;

    }
}
