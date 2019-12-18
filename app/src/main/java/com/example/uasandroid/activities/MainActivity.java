package com.example.uasandroid.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.uasandroid.R;
import com.example.uasandroid.fragment.CoffeFragment;
import com.example.uasandroid.fragment.MakananFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
            return true;
        }
        return false;
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.action_food:
                fragment = new CoffeFragment();
                break;
            case R.id.action_movie:
                fragment = new MakananFragment();
                break;
        }
        return loadFragment(fragment);
    }

    public void btn_handler_kenangan(View view) {
        Intent intent = new Intent(this,KenanganActivity.class);
        startActivity(intent);
    }
    public void btn_handler_kopiyor(View view) {
        Intent intent = new Intent(this,KopiYorActivity.class);
        startActivity(intent);
    }
}

