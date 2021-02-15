package com.example.secondproject.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.secondproject.LoginActivity;
import com.example.secondproject.MainActivity;
import com.example.secondproject.model.UserDetails;

import java.util.HashMap;

public class SharedPreferenceImplement {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Context context;
    int PRIVATE_MODE = 0;

    private static final String USER_ID = "userId";
    private static final String FIRST_NAME = "first_name";
    private static final String TOKEN = "token";
    private static final String LOGIN = "isLoggedIn";

    public SharedPreferenceImplement(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(TOKEN, PRIVATE_MODE);
        editor = preferences.edit();
    }

    public void createLoginSession(String token, String userId, String first_name) {
        editor.putBoolean(LOGIN, true);
        editor.putString(TOKEN, token);
        editor.putString(USER_ID, userId);
        editor.putString(FIRST_NAME, first_name);
        editor.commit();
    }

    public void endLoginSession() {
        editor.clear();
        editor.commit();
        Intent i = new Intent(context, LoginActivity.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }

    public UserDetails getUserDetail() {
        UserDetails userDetails = new UserDetails();
        userDetails.setUserId(preferences.getString(USER_ID, ""));
        userDetails.setFirst_name(preferences.getString(FIRST_NAME, ""));
        userDetails.setToken(preferences.getString(TOKEN, ""));
        return userDetails;
    }

}
