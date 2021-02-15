package com.example.secondproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.secondproject.adapter.CustomAdapter;
import com.example.secondproject.callbacks.GetDataService;
import com.example.secondproject.model.RetroPhoto;
import com.example.secondproject.network.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.secondproject.network.RetrofitClientInstance.getDataService;

public class RetrofitActivity extends AppCompatActivity {
    private CustomAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);

        recyclerView = findViewById(R.id.recycler);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        if(progressDialog != null)
            progressDialog.dismiss();
        else
            progressDialog.show();


        GetDataService service = getDataService();
        Call<List<RetroPhoto>> call = service.getAllPhotos();
        call.enqueue(new Callback<List<RetroPhoto>>() {
            @Override
            public void onResponse(Call<List<RetroPhoto>> call, Response<List<RetroPhoto>> response) {
                if(progressDialog.isShowing()){
                    progressDialog.dismiss();
                }
                //progressDialog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<RetroPhoto>> call, Throwable t) {
                if(progressDialog.isShowing()){
                    progressDialog.dismiss();
                }
                Toast.makeText(RetrofitActivity.this, "something went wrong", Toast.LENGTH_SHORT).show();

            }

        });
    }

    private void generateDataList(List<RetroPhoto> photoList) {
        adapter = new CustomAdapter(this,photoList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(RetrofitActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}