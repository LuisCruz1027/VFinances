package com.example.vfinancesproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<User> {

    public ListAdapter(Context context, ArrayList<User> userArrayList) {
        super(context, R.layout.remove_confirmation, userArrayList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        User user = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.remove_confirmation, parent, false);
        }

        TextView priceTag = convertView.findViewById(R.id.tagPrice);
        TextView nameTag = convertView.findViewById(R.id.tagName);

        priceTag.setText(user.getUser_email());
        nameTag.setText(user.getUser_password());

        return super.getView(position,convertView,parent);

    }

}
