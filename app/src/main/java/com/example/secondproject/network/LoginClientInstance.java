package com.example.secondproject.network;

import com.example.secondproject.callbacks.GetDataService;
import com.example.secondproject.callbacks.UserService;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginClientInstance {
    private static Retrofit retrofit;
    private static final String BASE_URL = "http://35.188.185.194:8080/kreer_app/";

    public static Retrofit getRetrofitInstance(){
        if (retrofit == null){
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();

            clientBuilder.addInterceptor(interceptor);
            OkHttpClient okHttpClient = clientBuilder.build();
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    //.client(okHttpClient)
                    .build();
        }
        return retrofit;
    }
    public static UserService getUserService(){
        return getRetrofitInstance().create(UserService.class);

    }
}
