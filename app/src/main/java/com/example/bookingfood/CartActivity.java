package com.example.bookingfood;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    ListView lvFood;
    ArrayList<Product> productArrayList;
    private Database db;
    CartAdapter cartAdapter;
    private SQLiteDatabase sqLiteDatabase;
    SharedPreferences sharedPreferencesCart;
    Button buttonBook;
    TextView txtTotal;
    ImageButton imageButtonBack;
    Intent intentFoward;
    Cursor cursor;
    String name;
    int positionCate;
    int positionPro;
    ImageButton info;
    ImageButton cart;
    ImageButton notification;
    //Button check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_cart);
//

        intentFoward = getIntent();
        name = getIntent().getStringExtra("name");
        positionCate = getIntent().getIntExtra("positionCate", -1);
        positionPro = getIntent().getIntExtra("positionPro", -1);

        lvFood = (ListView) findViewById(R.id.lvFood);
        //lvFood.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        buttonBook = (Button) findViewById(R.id.Book);
        //
        txtTotal = (TextView) findViewById(R.id.total);

        productArrayList = new ArrayList<>();
        db = new Database(this);
        sqLiteDatabase = db.getReadableDatabase();

        sharedPreferencesCart = getSharedPreferences("dataCart", MODE_PRIVATE);
        if (sharedPreferencesCart.getFloat("total", 0) != 0) {
            buttonBook.setEnabled(true);
        }

        String query = "SELECT * FROM PRODUCT";
        cursor = db.GetData(query);
        while (cursor.moveToNext()) {
            if (sharedPreferencesCart.getInt("" + cursor.getInt(0), -1) == cursor.getInt(0)) {

                int amount = sharedPreferencesCart.getInt("amount" + cursor.getInt(0), -1);
                productArrayList.add(new Product(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                        cursor.getString(3), amount, cursor.getInt(5)));
            }
        }

        //productArrayList = db.getProductByCategory(positionCate + 1);
        cartAdapter = new CartAdapter(this, R.layout.layout_custom_cart, productArrayList);

        lvFood.setAdapter(cartAdapter);

        float total = sharedPreferencesCart.getFloat("total", 0);
        txtTotal.setText("Tổng: " + total + "VND");

        lvFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(CartActivity.this, CartDetailActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);

            }
        });
//
//
        buttonBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ConfirmAddressActivity.class);
                startActivity(intent);
            }
        });
        cart = (ImageButton)findViewById(R.id.cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new  Intent(getBaseContext(), CartActivity.class);
                startActivity(intent);
            }
        });
//        //
//
//        notification = (ImageButton)findViewById(R.id.notification);
//        notification.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intentRate = new  Intent(getBaseContext(), NotificationActivity.class);
//                startActivity(intentRate);
//            }
//        });
//
//        //
//
//        info = (ImageButton)findViewById(R.id.profile);
//        info.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new  Intent(getBaseContext(), NotificationActivity.class);
//                startActivity(intent);
//            }
//        });
        imageButtonBack = (ImageButton)findViewById(R.id.btnback);
        imageButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentBack = new Intent(getApplicationContext(), ProductDetailActivity.class);
                intentBack.putExtra("positionCate", positionCate);
                intentBack.putExtra("positionPro", positionPro);
                startActivity(intentBack);
            }
        });

    }

}
