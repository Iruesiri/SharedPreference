package com.example.secondproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.secondproject.databinding.ActivityDataBindingBinding;

public class DataBindingActivity extends AppCompatActivity{

    ActivityDataBindingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);

        //binding.setPerson(getData());
        //binding.setCallback(this);
        DataBindingActivityOnClick onClick = new DataBindingActivityOnClick();
        binding.setCallback(onClick);
//        binding.tvHeading.setText("Welcome to JournalDev.com");
//        binding.tvSubHeading.setText("Welcome to this Android Tutorial on DataBinding");
    }
    public class DataBindingActivityOnClick {
        public void onSubmits() {
            if (!binding.editText.getText().toString().isEmpty()) {
                String text = binding.editText.getText().toString();
                binding.textBox.setText(text);
            }
        }
    }
}