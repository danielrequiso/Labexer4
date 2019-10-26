package com.requiso.labexer4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AndroidAdapter extends ArrayAdapter<AndroidContent> {

    private Context context;
    private int resource;

    public AndroidAdapter(@NonNull Context context, int resource, @NonNull List<AndroidContent> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int i, @Nullable View convertView, @NonNull ViewGroup parent) {
        int logo = getItem(i).getLogo();
        String company = getItem(i).getName();
        String territory = getItem(i).getCountry();
        String type = getItem(i).getIndustry();
        String head = getItem(i).getCeo();

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource, parent, false);

        ImageView img = convertView.findViewById(R.id.ivlogo);
        TextView companyName = convertView.findViewById(R.id.tvcompany);
        TextView country = convertView.findViewById(R.id.tvcountry);
        TextView industry = convertView.findViewById(R.id.tvindustry);
        TextView ceo = convertView.findViewById(R.id.tvceo);

        img.setImageResource(logo);
        companyName.setText(company);
        country.setText(territory);
        industry.setText(type);
        ceo.setText(head);

        return convertView;
    }
}
