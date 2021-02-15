package com.example.secondproject.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.TextView;

import com.example.secondproject.R;
import com.example.secondproject.databinding.ActivityRedirectBinding;
import com.example.secondproject.model.UserDetails;

import org.w3c.dom.Text;

public class RedirectActivity extends AppCompatActivity {
    TextView textView;
    ActivityRedirectBinding binding;
    SharedPreferenceImplement sharedPreference;
    UserDetails details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_redirect);

        sharedPreference = new SharedPreferenceImplement(this);
        details = sharedPreference.getUserDetail();
        binding.setText(details);
    }
}