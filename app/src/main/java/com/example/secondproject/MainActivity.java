package com.example.secondproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import com.example.secondproject.view.LoginRedirectActivity;
import com.example.secondproject.view.SessionManager;

public class MainActivity extends AppCompatActivity {
    private EditText username, pass;
    private String usernameValue, passwordValue;
    private Button btnLogin;
    private CheckBox checkBox;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    SessionManager sessionManager;

    public static final String TAG = "TAG";
//    public static final String SHARED_PREFS = "sharedPrefs";
//    public static final String TEXT = "text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionManager = new SessionManager(this);

        username = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        checkBox = (CheckBox) findViewById(R.id.check);
        Toast.makeText(getApplicationContext(), "User Login Status: " + sessionManager.isLoggedIn(), Toast.LENGTH_LONG).show();

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();
        checkSharedPreference();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usernameValue = username.getText().toString();
                passwordValue = pass.getText().toString();

                if (usernameValue.equals("Esiri") && passwordValue.equals("esiri")){
                    if (checkBox.isChecked()){
                        Log.d(TAG, "onClick: " + usernameValue);
                        editor.putString(getString(R.string.checkbox), "True");
                        editor.putString(getString(R.string.name), usernameValue);
                        editor.putString(getString(R.string.password), passwordValue);
                        editor.commit();

                        sessionManager.createLoginSession(usernameValue);
                        Intent intent = new Intent(MainActivity.this, LoginRedirectActivity.class);
                        startActivity(intent);
                    }
                    else {
                        editor.putString(getString(R.string.checkbox), "False");
                        editor.putString(getString(R.string.name), "");
                        editor.putString(getString(R.string.password), "");
                        editor.commit();

                        sessionManager.createLoginSession(usernameValue);
                        Intent intent = new Intent(MainActivity.this, LoginRedirectActivity.class);
                        startActivity(intent);
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "Username or Password incorrect", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    private void checkSharedPreference(){
        String checkbox = sharedPreferences.getString(getString(R.string.checkbox), "False");
        String name = sharedPreferences.getString(getString(R.string.name), "");
        String password = sharedPreferences.getString(getString(R.string.password), "");

        username.setText(name);
        pass.setText(password);

        if (checkbox.equals("True")){
            checkBox.setChecked(true);
        }
        else {
            checkBox.setChecked(false);
        }
    }
}