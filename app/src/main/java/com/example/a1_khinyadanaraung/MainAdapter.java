package com.example.a1_khinyadanaraung;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class MainAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private int[] productImage;
    private String[] productName;
    private String[] productPrice;

    public MainAdapter(Context c, String[] productName, int[] productImage, String[] productPrice){
        context = c;
        this.productName = productName;
        this.productImage = productImage;
        this.productPrice = productPrice;
    }

    @Override
    public int getCount() {
        return productName.length;
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

        ImageView imageView = convertView.findViewById(R.id.product_image);
        TextView textView = convertView.findViewById(R.id.product_name);
        TextView textView1 = convertView.findViewById(R.id.product_price);

        imageView.setImageResource(productImage[position]);
        textView.setText(productName[position]);
        textView1.setText(productPrice[position]);
        return convertView;
    }
}
