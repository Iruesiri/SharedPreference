package com.example.secondproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.secondproject.databinding.ActivityDemoBinding;
import com.example.secondproject.model.Product;

public class DemoActivity extends AppCompatActivity {
    ActivityDemoBinding activityBinding;
    Product product = new Product("Victory", "siri", "esiri.com");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_demo);
        activityBinding.setProduct(product);
    }
}