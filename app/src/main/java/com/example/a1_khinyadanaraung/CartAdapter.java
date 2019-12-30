package com.example.a1_khinyadanaraung;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class CartAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Items>itemList;

    TextView name, price, radioSize;
    ImageView img;

    public CartAdapter(Context c, ArrayList<Items>itemList) {
        context = c;
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
        return itemList.size();
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
        if (inflater == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, null);
        }

        name = convertView.findViewById(R.id.product_name);
        price = convertView.findViewById(R.id.product_price);
        radioSize = convertView.findViewById(R.id.radioSize);
        img = convertView.findViewById(R.id.product_image);
        Items currentItem = itemList.get(position);

        img.setImageResource(Integer.parseInt(currentItem.getImgIndex()));
        name.setText(currentItem.getName());
        price.setText(currentItem.getPrice());
        radioSize.setText(currentItem.getSize());

        return convertView;
    }
}

