package com.example.finalassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> theIds = new ArrayList<>();
    private ArrayList<String> theImagesURL = new ArrayList<>();
    private ArrayList<String> theThumbnailURL = new ArrayList<>();
    private ArrayList<String> theTitles = new ArrayList<>();
    private ArrayList<String> theAlbumId = new ArrayList<>();
    Api api;

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        api= ApiClient.getClient().create(Api.class);
        getColors();
    }

    private void getColors() {
        Call<List<Colors>> call = api.getColors();


        call.enqueue(new Callback<List<Colors>>() {
            @Override
            public void onResponse(Call<List<Colors>> call, Response<List<Colors>> response) {
                List<Colors> colorsList = response.body();

                for(int i =0; i < colorsList.size(); i++) {
                    theIds.add(colorsList.get(i).getId());
                    theImagesURL.add(colorsList.get(i).getURL());
                    theThumbnailURL.add(colorsList.get(i).getThumbnailURL());
                    theTitles.add(colorsList.get(i).getTitle());
                    theAlbumId.add(colorsList.get(i).getAlbumId());
                }

                initImageLoad();
                //displaying the string array into RecycleView
                //recyclerView.setAdapter(new ArrayAdapter<String>(getApplicationContext(),
                        //android.R.layout., heroes));
            }

            @Override
            public void onFailure(Call<List<Colors>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


    }

    private void initImageLoad() {

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(theIds,theImagesURL,
                theThumbnailURL,theTitles,theAlbumId,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}