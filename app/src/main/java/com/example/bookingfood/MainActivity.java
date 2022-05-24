package com.example.bookingfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TextView textView;
    //Toolbar toolbar;
    ImageButton info;
    ImageButton cart;
    ImageButton notification;
    BottomNavigationView bottomNavigationView;
    SharedPreferences sharedPreferencesUser;

    Button login;
    TextView txtSignUp;
    TextView txtForgotPass;
    EditText usernameLogin;
    EditText passwordLogin;
    public static Database db;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                          startActivity(intent);
//
//
//          db = new Database(this);
//        db.QueryData("CREATE TABLE IF NOT EXISTS ADDRESS( ID INTEGER PRIMARY KEY AUTOINCREMENT, DESCRIPTION TEXT, IMAGE_ID INTEGER)");
//        db.QueryData("CREATE TABLE IF NOT EXISTS BOOKED( ID INTEGER PRIMARY KEY AUTOINCREMENT, DATE_ORDER TEXT, STATUS INTEGER, ADDRESS TEXT, TOTAL FLOAT)");
//        db.QueryData("CREATE TABLE IF NOT EXISTS ORDERS( ID INTEGER PRIMARY KEY AUTOINCREMENT, ID_PRODUCT INTEGER, PRICE FLOAT, AMOUNT_PRODUCT INTEGER, " +
//                "ID_BOOKED INTEGER)");

        //db.insertAddress("2/5 đường 68 phường Hiệp Phú Quận 9 tp.Thủ Đức", R.drawable.ch1);
        //db.insertAddress("33 Lê Văn Việt phường Hiệp Phú quận 9 tp.Thủ Đức", R.drawable.ch2);
        //db.insertAddress("90 Võ Văn Ngân phường Hiệp Phú quận Thủ Đức tp.Thủ Đức", R.drawable.ch3);
        //db.insertAddress("88 Nguyễn Tri Phương phường 3 quận 6 tp.Trà Vinh", R.drawable.ch4);
        //db.insertAddress("12 Nguyễn Đình Chiểu phường 3 quận 6 tp.Trà Vinh", R.drawable.ch5);

//        db.QueryData("CREATE TABLE IF NOT EXISTS USERS(ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT, " +
//                "PASSWORD TEXT, EMAIL TEXT, NAME TEXT, PHONE TEXT, ADDRESS TEXT)");
//
//          db.QueryData("CREATE TABLE IF NOT EXISTS CATEGORY( ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT)");
//          db.QueryData("CREATE TABLE IF NOT EXISTS PRODUCT( ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, PRICE FLOAT, DESCRIPTION TEXT, " +
//                "ID_CATEGORY INTEGER, IMAGE_ID INTEGER)");
//        db.insertUser("vinhtu125", "123456","vinhtu125@gmail.com","Vĩnh Tú", "0357133416","Đường số 4, phường Trường Thọ, Quận Thủ Đức" );
//        db.insertUser("vinhtu999", "123456","vinhtu999@gmail.com","Vĩnh Tú", "0357133416","Đường số 4, phường Trường Thọ, Quận Thủ Đức" );
//
//        db.insertCategory("Đồ uống");
//        db.insertCategory("Thuc an");
//
//        db.insertProduct("Nước cam", 30000, "Nước cam 100% cam tươi cung cấp vitamin C cho bạn khỏe mạnh", 2, R.drawable.organe);
//        db.insertProduct("Nước cam cà rốt", 50000, "Nước trái cây mix, xịn khỏi chê luôn đó nha..Thử nhanh nào khách iu ơi!", 2, R.drawable.organ_carrot);
//        db.insertProduct("Nước ép táo", 45000, "Nước ép táo, với 100% táo nhập từ Mỹ sẽ giúp bạn cảm thấy sảng khoái đó nhe!!!!!", 2, R.drawable.apple);
//        db.insertProduct("Bạc sĩu", 30000, "Với những bạn muốn uống cà phê mà sợ đắng thì bạc sĩu là một lựa chọn thích hợp và tuyệt vời.", 2, R.drawable.bacsiu);
//        db.insertProduct("Sinh tố bơ", 40000, "Một ly sinh tố bơ sẽ giúp bạn cảm thấy haizzz hôm nay ngọt vậy là đủ tuyệt cú mèo luôn nè!!", 2, R.drawable.bo);
//        db.insertProduct("Nước ép cà chua", 35000, "Nếu một ngày buồn bã thất tình thay vì khóc sự lựa chọn tuyệt vời của bạn là một ly nước ép cà chua để mình sáng mắt ra nè. Đừng buồn nhe!!!!", 2, R.drawable.cachua);


//          db.deleteAllProduct();
//
//        txtSignUp = (TextView) findViewById(R.id.txtRegister);
//        txtForgotPass = (TextView) findViewById(R.id.txtForgotPass);
//        login = (Button)findViewById(R.id.btnLogin);
//        usernameLogin = (EditText)findViewById(R.id.username);
//        passwordLogin = (EditText)findViewById(R.id.password);
//
//        //Sign Up
//        txtSignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new  Intent(getBaseContext(), RegisterActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        //forgotpass
//        txtForgotPass.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new  Intent(getBaseContext(), ForgetPassActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String username = usernameLogin.getText().toString().trim();
//                String password = passwordLogin.getText().toString().trim();
//                if(username.equals("") || password.equals("")){
//                    Toast.makeText(getBaseContext(), "Nhập tên đăng nhập và password luôn bạn iu <3 ơi!", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    String query = "SELECT * FROM USERS";
//                    Cursor cursor = db.GetData(query);
//                    while (cursor.moveToNext()){
//                        if(cursor.getString(1).equals(username) && cursor.getString(2).equals(password)){
//                            Toast.makeText(getBaseContext(), "Thành công!", Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
//                            startActivity(intent);
//                            sharedPreferencesUser = getSharedPreferences("dataLogin", MODE_PRIVATE);
//                            SharedPreferences.Editor editor = sharedPreferencesUser.edit();
//                            editor.putString("username", username);
//                            editor.putString("password", password);
//                            editor.putString("name", cursor.getString(4));
//                            editor.putString("email", cursor.getString(3));
//                            editor.putString("phone", cursor.getString(5));
//                            editor.putString("address", cursor.getString(6));
//
//                            editor.putInt("id", cursor.getInt(0));
//
//                            editor.commit();
//                            break;
//                        }
//                    }
//                }
//            }
//        });





    }

}