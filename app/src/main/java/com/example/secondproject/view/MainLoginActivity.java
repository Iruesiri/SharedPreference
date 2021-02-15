package com.example.secondproject.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.secondproject.LoginActivity;
import com.example.secondproject.MainActivity;
import com.example.secondproject.NavigationActivity;
import com.example.secondproject.R;
import com.example.secondproject.RetrofitActivity;
import com.example.secondproject.callbacks.GetDataService;
import com.example.secondproject.callbacks.UserService;
import com.example.secondproject.model.LoginRequest;
import com.example.secondproject.model.Product;
import com.example.secondproject.model.RetroPhoto;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

import okhttp3.Headers;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.secondproject.network.LoginClientInstance.getUserService;
import static com.example.secondproject.network.RetrofitClientInstance.getDataService;

public class MainLoginActivity extends AppCompatActivity {

    ShapeableImageView imageView;
    private EditText username, pass;
    private String accountValue, passwordValue;
    private Button btnLogin;
    UserService userService;
    LoginRequest loginRequest;

    SharedPreferenceImplement sharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        sharedPreference = new SharedPreferenceImplement(this);

        imageView = findViewById(R.id.back);
        username = (EditText) findViewById(R.id.acct);
        pass = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.btnSign);

        userService = getUserService();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainLoginActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accountValue = username.getText().toString();
                passwordValue = pass.getText().toString();

                if (accountValue.isEmpty() || passwordValue.isEmpty()){
                    Toast.makeText(MainLoginActivity.this, "Please Input Values", Toast.LENGTH_SHORT).show();
                }
                else {
                    loginRequest = new LoginRequest(accountValue, passwordValue);
                    Call<ResponseBody> service = userService.login(loginRequest);
                    service.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            //ResponseBody response1 = response.body();
                            Headers headers = response.headers();
                            String authorizationToken = headers.get("Authorization");
                            String userId = headers.get("UserId");
                            String name = headers.get("First_name");

                            if (authorizationToken == null){
                                Toast.makeText(MainLoginActivity.this, "Invalid login", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                sharedPreference.createLoginSession(authorizationToken, userId, name);
                                Toast.makeText(MainLoginActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainLoginActivity.this, NavigationActivity.class);
                                startActivity(intent);
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Toast.makeText(MainLoginActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}