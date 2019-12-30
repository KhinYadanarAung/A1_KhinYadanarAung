package com.example.a1_khinyadanaraung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    SharedPreferences preferences;
    private int theme;
    int[] productImage = {R.drawable.ultraboost, R.drawable.puma};
    String[]productName = {"Adidas Ultra boost", "Puma cali"};
    String[]productPrice = {"S$230" , "S$155"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences("value", MODE_PRIVATE);
        listView = findViewById(R.id.list_view);

        MainAdapter adapter = new MainAdapter(MainActivity.this, productName, productImage, productPrice);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("image", productImage[position]);
                intent.putExtra("name", productName[position]);
                intent.putExtra("price", productPrice[position]);
                startActivity(intent);
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
                startActivity(new Intent(MainActivity.this, ChangeColor.class));
                return true;
            case R.id.cart:
                startActivity(new Intent(MainActivity.this, Cart.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void onStart(){
        super.onStart();
        theme = preferences.getInt("theme",1);
        if (theme == 1){
            listView.setBackgroundResource(R.drawable.roundedbutton_green);

        }else if (theme == 2){
            listView.setBackgroundResource(R.drawable.roundedbutton_red);

        }else if (theme == 3){
            listView.setBackgroundResource(R.drawable.roundedbutton_blue);

        }else if (theme == 4){
            listView.setBackgroundResource(R.drawable.roundedbutton_purple);

        }

    }
}
