package com.example.instagram;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.instagram.fragment.profileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.example.instagram.fragment.HomeFragment;
import com.example.instagram.fragment.notificationFragment;
import com.example.instagram.fragment.searchFragment;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Fragment selectedFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    int itemId = item.getItemId();

                    if(itemId == R.id.nav_home){
                       selectedFragment = new HomeFragment();
                    }else if (itemId == R.id.nav_search){
                        selectedFragment = new searchFragment();
                    } else if (itemId == R.id.nav_add) {
                        selectedFragment = null;
                        startActivity(new Intent(MainActivity.this,PostActivity.class));
                    } else if (itemId == R.id.nav_reels) {
                        selectedFragment = new notificationFragment();
                    }else if (itemId == R.id.nav_profile) {
                        SharedPreferences.Editor editor = getSharedPreferences("PREFS",MODE_PRIVATE).edit();
                        editor.putString("profileid", FirebaseAuth.getInstance().getCurrentUser().getUid());
                        editor.apply();
                        selectedFragment = new profileFragment();
                    }

                    if(selectedFragment != null){
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();

                    }

                    return true;
                }
            };
}