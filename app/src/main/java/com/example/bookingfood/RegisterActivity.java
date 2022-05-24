package com.example.bookingfood;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;

public class RegisterActivity extends AppCompatActivity {


    TextView txtLogin;
    EditText name;
    EditText email;
    EditText username;
    EditText password;
    EditText phone;
    EditText address;
    Button signUp;
    private SQLiteDatabase sqLiteDatabase;

    SharedPreferences sharedPreferencesUser;
    private Database db;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        txtLogin = (TextView)findViewById(R.id.txtLogin);

        name = (EditText)findViewById(R.id.name);
        email = (EditText)findViewById(R.id.email);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        phone = (EditText)findViewById(R.id.phone);
        address = (EditText)findViewById(R.id.address);

        signUp = (Button)findViewById(R.id.btnSignUp);

        sharedPreferencesUser = getSharedPreferences("dataLogin", MODE_PRIVATE);
        db = new Database(this);
        sqLiteDatabase = db.getReadableDatabase();
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent BackIntent = new Intent();
                setResult(RESULT_OK,BackIntent);
                finish();
            }
        });


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameAdd = username.getText().toString().trim();
                String passwordAdd = password.getText().toString().trim();
                String emailAdd = email.getText().toString().trim();
                String nameAdd = name.getText().toString().trim();
                String phoneAdd = phone.getText().toString().trim();
                String addressAdd = address.getText().toString().trim();


                db.insertUser(usernameAdd, passwordAdd, emailAdd, nameAdd, phoneAdd, addressAdd);
                Toast.makeText(getBaseContext(), "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
