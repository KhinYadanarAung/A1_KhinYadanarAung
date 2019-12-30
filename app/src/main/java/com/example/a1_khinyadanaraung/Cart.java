package com.example.a1_khinyadanaraung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Cart extends AppCompatActivity {

    ArrayList<Items> itemList;
    ListView cartView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        loadData();
        cartView = findViewById(R.id.cart_view);

        CartAdapter adapter = new CartAdapter(Cart.this, itemList);
        cartView.setAdapter(adapter);

        Button btn = findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cart.this, MainActivity.class);
                Bundle args = new Bundle();
                args.putSerializable("ARRAYLIST",(Serializable)itemList);
                intent.putExtra("BUNDLE", itemList);
                startActivity(intent);
            }
        });
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared item", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("take item", null);
        Type type = new TypeToken<ArrayList<Items>>() {}.getType();
        itemList = gson.fromJson(json, type);

        if (itemList == null) {
            itemList = new ArrayList<>();
        }

    }

}
