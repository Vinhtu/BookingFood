package com.example.bookingfood;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    TextView textView;
    //Toolbar toolbar;
    ImageButton info;
    ImageButton cart;
    ImageButton notification;
    BottomNavigationView bottomNavigationView;
    SharedPreferences sharedPreferencesUser;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);



        bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(selectedListener );

//        sharedPreferencesUser = getSharedPreferences("dataLogin", MODE_MULTI_PROCESS);
//        textView = (TextView)findViewById(R.id.toolbar);
//        textView.setText("Home");
        HomeFragment fragment = new HomeFragment();
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container,fragment,"");
        fragmentTransaction.commit();



        Intent intent = getIntent();
        String name = getIntent().getStringExtra("name");
        if(name != null){
            if(name.equals("home"))
            {
                bottomNavigationView.setSelectedItemId(R.id.navigation_home);
            }
            else if(name.equals("cart")){
                bottomNavigationView.setSelectedItemId(R.id.navigation_cart);
            }
            else if(name.equals("status"))
            {
                bottomNavigationView.setSelectedItemId(R.id.navigation_status);
            }
            else if(name.equals("setting")){
                bottomNavigationView.setSelectedItemId(R.id.navigation_setting);
            }

        }



    }

    private BottomNavigationView.OnNavigationItemSelectedListener selectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {

                case R.id.navigation_home:
//                    textView.setText("Home");
                    HomeFragment fragment = new HomeFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.container, fragment, "");
                    fragmentTransaction.commit();
                    return true;

                case R.id.navigation_cart:
//                    textView.setText("Products");
                    CartFragment fragment1 = new CartFragment();
                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.container, fragment1);
                    fragmentTransaction1.commit();
                    return true;
                case R.id.navigation_status:
//                    textView.setText("Products");
                    StatusFragment fragment2 = new StatusFragment();
                    FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.container, fragment2);
                    fragmentTransaction2.commit();
                    return true;
                case R.id.navigation_setting:
//                    textView.setText("Products");
                    SettingFragment fragment3 = new SettingFragment();
                    FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction3.replace(R.id.container, fragment3);
                    fragmentTransaction3.commit();
                    return true;

            }
            return false;
        }
    };

}
