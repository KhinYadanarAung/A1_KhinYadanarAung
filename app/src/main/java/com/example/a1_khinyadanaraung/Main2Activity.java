package com.example.a1_khinyadanaraung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    SharedPreferences preferences;
    private int theme;
    String productName,productPrice,size,img;
    int productImage;
    double shoeSize;
    TextView name, price;
    ImageView image;
    RadioGroup radioGP;
    RadioButton radioButton,radioSize5,radioSize55,radioSize6,radioSize65,radioSize7,radioSize75;

    Items items;
    ArrayList<Items> itemsList = new ArrayList<Items>();
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sharedPreferences = getSharedPreferences("USER",MODE_PRIVATE);
        image = findViewById(R.id.individual_view);
        name = findViewById(R.id.individual_name);
        radioGP = findViewById(R.id.radioGP);
        price = findViewById(R.id.individual_price);
        radioSize5 = findViewById(R.id.radioSize5);
        radioSize55 = findViewById(R.id.radioSize55);
        radioSize6 = findViewById(R.id.radioSize6);
        radioSize65 = findViewById(R.id.radioSize65);
        radioSize7 = findViewById(R.id.radioSize7);
        radioSize75 = findViewById(R.id.radioSize75);
        radioSize5.setChecked(true);


        Intent intent= getIntent();
        productImage = intent.getIntExtra("image", 0);
        productName = intent.getStringExtra("name");
        productPrice = intent.getStringExtra("price");

        image.setImageResource(productImage);

        name.setText(productName);
        price.setText(productPrice);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioID = radioGP.getCheckedRadioButtonId();
                radioButton = findViewById(radioID);
                if(radioButton == radioSize5){
                    shoeSize = 5;
                }
                else if(radioButton == radioSize55) {
                    shoeSize = 5.5;
                }
                else if(radioButton == radioSize6) {
                    shoeSize = 6;
                }
                else if(radioButton == radioSize65) {
                    shoeSize = 6.5;
                }
                else if(radioButton == radioSize7) {
                    shoeSize = 7;
                }
                else {
                   shoeSize = 7.5;
                }

                System.out.println(shoeSize);
                size = String.valueOf(shoeSize);
                img=String.valueOf(productImage);
                items = new Items(img,productName,productPrice,size);
                itemsList.add(items);
                System.out.println(itemsList);

                SharedPreferences preferencesItem = getSharedPreferences("shared item",MODE_PRIVATE);
                Gson gson = new Gson();
                String json = gson.toJson(itemsList);
                System.out.println(json);
                preferencesItem.edit().putString("take item",json).apply();
                Intent myIntent = new Intent(Main2Activity.this, Cart.class);
                startActivity(myIntent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.setting:
                startActivity(new Intent(Main2Activity.this, ChangeColor.class));
                return true;
            case R.id.cart:
                startActivity(new Intent(Main2Activity.this, Cart.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
