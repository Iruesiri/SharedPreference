package com.example.secondproject.callbacks;

import com.example.secondproject.model.LoginRequest;
import com.example.secondproject.model.Product;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserService {

    @POST("/login.php")
    Call<List<Product>> getAllProducts();

    @POST("user/login")
    Call<ResponseBody> login(@Body LoginRequest loginRequest);
}
