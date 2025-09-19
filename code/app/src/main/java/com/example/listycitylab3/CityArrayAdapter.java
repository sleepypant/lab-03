package com.example.listycitylab3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CityArrayAdapter extends ArrayAdapter<City> {

    public CityArrayAdapter(@NonNull Context context, @NonNull ArrayList<City> cities) {
        // We pass 0 as the layout resource because we'll inflate it manually in getView()
        super(context, 0, cities);
    }

    @NonNull
    @Override
    public View getView(int position,
                        @Nullable View convertView,
                        @NonNull ViewGroup parent) {

        // Reuse the view if possible, otherwise inflate a new one
        View view = (convertView != null)
                ? convertView
                : LayoutInflater.from(getContext()).inflate(R.layout.content, parent, false);

        // Get the current City object
        City city = getItem(position);

        // Find the TextViews in the layout
        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        // Bind the data to the views
        if (city != null) {
            cityName.setText(city.getName());
            provinceName.setText(city.getProvince());
        }

        return view;
    }
}
