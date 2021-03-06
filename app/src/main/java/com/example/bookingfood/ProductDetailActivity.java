package com.example.bookingfood;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ProductDetailActivity extends AppCompatActivity {

    ImageButton info;
    ImageButton cart;
    ImageButton notification;
    Intent intentBack;
    int positionCate;
    Database db;
    ArrayList<Product> productArrayList;
    private SQLiteDatabase sqLiteDatabase;
    int positionPro;
    ImageButton imageButtonBack;
    ImageView imgFood;
//    RateAdapter rateAdapter;
    TextView nameFood;
    TextView priceFood;
    TextView description;
//    ArrayList<Rate> rateArrayList;
    ListView lvRate;
    Intent intent;
    EditText txtAmount;
    ImageButton up;
    ImageButton down;
    Button bookNow;
    int dem  = 0;
    int id;
    String price;
    SharedPreferences sharedPreferencesCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        intent = getIntent();

        imgFood = (ImageView)findViewById(R.id.imgFood);
        nameFood = (TextView)findViewById(R.id.nameFood);
        priceFood = (TextView)findViewById(R.id.priceFood);
        description = (TextView)findViewById(R.id.description);
        txtAmount = (EditText)findViewById(R.id.amount);

        up = (ImageButton)findViewById(R.id.up);
        down = (ImageButton)findViewById(R.id.down);
        bookNow = (Button)findViewById(R.id.Book);

        sharedPreferencesCart = getSharedPreferences("dataCart", MODE_PRIVATE);

//        Product product = new Product();
//        positionCate = getIntent().getIntExtra("positionCate", -1);
        positionPro = getIntent().getIntExtra("positionProduct", -1);

        db = new Database(this);
        sqLiteDatabase = db.getReadableDatabase();
        productArrayList = db.getProductByCategory(2);
        for(Product product:productArrayList){
            if(dem == positionPro)
            {
                id = product.get_id();
                imgFood.setImageResource(product.get_picture());
                nameFood.setText(product.get_name());
                price = product.get_price();
                priceFood.setText("Gi??: " + price + " VND");
                description.setText(product.get_description());
                break;
            }
            dem++;
        }

//        rateArrayList = new ArrayList<>();
//        rateArrayList = db.getRateByIdPro(id);
//        rateAdapter = new RateAdapter(this, R.layout.layout_custom_rate, rateArrayList);

//        lvRate.setAdapter(rateAdapter);

        imageButtonBack = (ImageButton)findViewById(R.id.btnback);
        imageButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentBack = new Intent(getApplicationContext(),HomeActivity.class);
                intentBack.putExtra("positionCate", positionCate);
                startActivity(intentBack);
                //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contant_main, new Home()).commit();
            }
        });

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amountNow = txtAmount.getText().toString();
                int amount = 1 + Integer.parseInt(amountNow);
                String a = "" + amount;
                txtAmount.setText(a);
            }
        });

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amountNow = txtAmount.getText().toString();
                if(Integer.parseInt(amountNow) <= 1)
                {

                }
                else
                {
                    int amount = -1 + Integer.parseInt(amountNow);
                    String a = "" + amount;
                    txtAmount.setText(a);
                }

            }
        });

        notification = (ImageButton)findViewById(R.id.notification);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRate = new  Intent(getBaseContext(), NotificationActivity.class);
                startActivity(intentRate);
            }
        });

        bookNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferencesCart.edit();
                if(sharedPreferencesCart.getInt(""+id, -1) == id)
                {
                    String amountNow = txtAmount.getText().toString();
                    int amountBook = Integer.parseInt(amountNow);
                    int amount = sharedPreferencesCart.getInt("amount" + id, 0);
                    editor.putInt("amount" + id, amount + amountBook);
                    float total = sharedPreferencesCart.getFloat("total", 0);
                    editor.putFloat("total", (total + Integer.parseInt(price)*(amountBook)));
                }
                else
                {
                    String amountNow = txtAmount.getText().toString();
                    int amountBook = Integer.parseInt(amountNow);
                    editor.putInt(""+id, id );
                    editor.putInt("amount" + id, amountBook);
                    float total = sharedPreferencesCart.getFloat("total", 0);
                    editor.putFloat("total", (total + Integer.parseInt(price)*amountBook));
                    //editor.put
                }
                editor.commit();
                Intent intent = new Intent(ProductDetailActivity.this, CartActivity.class);
                intent.putExtra("name", "foodDetail");
                intent.putExtra("positionCate", positionCate);
                intent.putExtra("positionPro", positionPro);
                startActivity(intent);
            }
        });
        cart = (ImageButton)findViewById(R.id.cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new  Intent(getBaseContext(), CartActivity.class);
                intent.putExtra("name", "foodDetail");
                startActivity(intent);
            }
        });
        //


    }
}