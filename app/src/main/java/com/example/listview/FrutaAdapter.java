package com.example.listview;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.MathContext;
import java.sql.SQLPermission;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class FrutaAdapter extends ArrayAdapter {
    int mResource;
    Context mContext;

    public FrutaAdapter(Context context, int resource, ArrayList objects) {
        super(context, resource, objects);

        mContext = context;
        mResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);

        convertView = inflater.inflate(mResource, parent, false);

        TextView tvCodigo = convertView.findViewById(R.id.tvCodigo);
        TextView tvNome = convertView.findViewById(R.id.tvNome);
        TextView tvPreco = convertView.findViewById(R.id.tvPreco);
        TextView tvPrecoVenda = convertView.findViewById(R.id.tvPrecoVenda);

        Fruta fruta = (Fruta) getItem(position);

        float preco = Math.round(fruta.getPreco().floatValue()*100)/100F;
        float precoVenda = Math.round(fruta.getPreco_venda().floatValue()*100)/100F;

        tvCodigo.setText(String.valueOf(fruta.getCodigo()));
        tvNome.setText(fruta.getNome());
        tvPreco.setText(String.valueOf(preco));
        tvPrecoVenda.setText(String.valueOf(precoVenda));

        ImageView imageView = convertView.findViewById(R.id.imageView);

        imageView.setImageResource(fruta.getImagem());

        return convertView;
    }
}
