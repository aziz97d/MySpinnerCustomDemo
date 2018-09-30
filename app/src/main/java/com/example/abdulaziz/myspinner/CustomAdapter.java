package com.example.abdulaziz.myspinner;

import android.content.Context;
import android.content.IntentFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    private String[] countryNames;
    private String[] populations;
    private int[] imgCountry;
    private Context context;

    public CustomAdapter( Context context,int[] imgCountry,String[] countryNames, String[] populations) {
        this.countryNames = countryNames;
        this.populations = populations;
        this.imgCountry = imgCountry;
        this.context = context;
    }

    @Override
    public int getCount() {
        return countryNames.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view==null){

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.custom_layout,null,false);
        }

        ImageView imageView = view.findViewById(R.id.img_country);
        imageView.setImageResource(imgCountry[i]);

        TextView txtCountryName = view.findViewById(R.id.txt_country);
        txtCountryName.setText(countryNames[i]);

        TextView txtPopulation = view.findViewById(R.id.txt_population);
        txtPopulation.setText(populations[i]);

        return view;
    }
}
