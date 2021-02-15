package com.example.secondproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.secondproject.adapter.ViewPagerAdapter;
import com.example.secondproject.model.ImageDetails;
import com.example.secondproject.view.LoginRedirectActivity;
import com.example.secondproject.view.MainLoginActivity;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    Button button;
    ViewPager viewPager;
    ViewPagerAdapter adapter;
    List<ImageDetails> detailsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button = findViewById(R.id.login);

        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        detailsList = new ArrayList<>();
        detailsList.add(new ImageDetails(R.drawable.pict));
        detailsList.add(new ImageDetails(R.drawable.woman));

        adapter = new ViewPagerAdapter(detailsList, this);
        viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainLoginActivity.class);
                startActivity(intent);
            }
        });

    }
}