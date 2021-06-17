package com.assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.MenuItem;
import android.widget.Toast;

import com.assignment.fragments.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    NavigationView side_nav;
    DrawerLayout drawer;

    boolean doubleBackToExitPressedOnce = false;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        bottomNavigationView = findViewById(R.id.bottomNavView);
        drawer = findViewById(R.id.drawer);
        side_nav = findViewById(R.id.side_nav);

        side_nav.setNavigationItemSelectedListener(this);

        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Fragment fragment = new HomeFragment();
        loadFragment(fragment);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            bottomNavigationView.getMenu().setGroupCheckable(0, true, true);

            Fragment fragment;

            switch (menuItem.getItemId()) {

                case R.id.bnHome:
                    fragment = new HomeFragment();
                    loadFragment(fragment);
                    return true;

                case R.id.bntables:
                    fragment = new HomeFragment();
                    loadFragment(fragment);
                    return true;

                case R.id.bnTakeAway:
                    fragment = new HomeFragment();
                    loadFragment(fragment);
                    return true;

                case R.id.bnMenu:
                    fragment = new HomeFragment();
                    loadFragment(fragment);
                    return true;

            }
            return false;
        }
    };

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }


    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commitAllowingStateLoss();
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);

    }
}