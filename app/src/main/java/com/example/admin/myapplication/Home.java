package com.example.admin.myapplication;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();

        HomeFragment home_fragment = new HomeFragment();

        ft.replace(R.id.main_frame , home_fragment );

        ft.commit();
        BottomNavigationView bottom_navigation_view = findViewById(R.id.bottom_navigation);

        BottomNavigationView.OnNavigationItemSelectedListener listener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if( item.getItemId() == R.id.home_btn )
                {
                    FragmentManager fm = getSupportFragmentManager();

                    FragmentTransaction ft = fm.beginTransaction();

                    HomeFragment home_fragment = new HomeFragment();

                    ft.replace(R.id.main_frame , home_fragment );

                    ft.commit();


                }

                if( item.getItemId() == R.id.rent_btn )
                {
                    FragmentManager fm = getSupportFragmentManager();

                    FragmentTransaction ft = fm.beginTransaction();

                    RentFragment rent_fragment = new RentFragment();

                    ft.replace(R.id.main_frame , rent_fragment );

                    ft.commit();


                }

                if( item.getItemId() == R.id.profile_btn )
                {
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ProfileFragment profileFragment = new ProfileFragment();
                    ft.replace(R.id.main_frame , profileFragment );
                    ft.commit();


                }



                return false;
            }
        };

        bottom_navigation_view.setOnNavigationItemSelectedListener(listener);

    }

    public void drawer(View view) {

    }
}