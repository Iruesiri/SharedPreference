package com.example.secondproject.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.secondproject.R;

import java.util.HashMap;

public class LoginRedirectActivity extends AppCompatActivity {

    // Session Manager Class
    SessionManager session;
    Button btnLogout;
    TextView displayName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_redirect);

        session = new SessionManager(this);
        displayName = (TextView) findViewById(R.id.displayName);
        btnLogout = (Button) findViewById(R.id.btnLogout);
        session.checkLogin();

        HashMap<String, String> user = session.getUserDetails();
        String name = user.get(SessionManager.KEY_NAME);

        displayName.setText(String.format("Hello %s", name));

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.logoutUser();
            }
        });
    }
}