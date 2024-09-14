package com.example.instagram;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import fragment.homeFragment;
import fragment.notificationFragment;
import fragment.searchFragment;

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
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    int itemId = item.getItemId();

                    if(itemId == R.id.nav_home){
                        selectedFragment = new homeFragment();
                    }else if (itemId == R.id.nav_search){
                        selectedFragment = new searchFragment();
                    } else if (itemId == R.id.nav_add) {
                        selectedFragment = null;
                        startActivity(new Intent(MainActivity.this,PostActivity.class));

                    } else if (itemId == R.id.nav_reels) {
                        selectedFragment = new notificationFragment();

                    }else if (itemId == R.id.nav_profile) {
                        selectedFragment = new homeFragment();

                    }

                    return true;
                }
            };
}