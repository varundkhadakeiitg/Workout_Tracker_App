package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.bottomnavigation.databinding.ActivityMainBinding;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    WorkoutFragment workoutFragment = new WorkoutFragment();
    ExercisesFragment exercisesFragment = new ExercisesFragment();
    ProgressFragment progressFragment = new ProgressFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLaytout, homeFragment).commit();
        BadgeDrawable badgeDrawable = bottomNavigationView.getOrCreateBadge(R.id.progress);
        badgeDrawable.setVisible(true);
        badgeDrawable.setNumber(3);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLaytout, homeFragment).commit();
                        return true;
                    case R.id.workout:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLaytout, workoutFragment).commit();
                        return true;
                    case R.id.exercises:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLaytout, exercisesFragment).commit();
                        return true;
                    case R.id.progress:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLaytout, progressFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }
}