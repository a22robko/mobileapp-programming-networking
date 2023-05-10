package com.example.networking;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("LongLogTag")
@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {


    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";
    private final String JSON_FILE = "mountains.json";

    //private Myadapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new JsonFile(this, this).execute(JSON_FILE);
        //  new JsonFile(this, this).execute(JSON_FILE);




    }

    @SuppressLint("LongLogTag")

    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", json);

        Gson gson = new Gson();
        Type type = new TypeToken<List<Mountain>>() {}.getType();
        List<Mountain> listOfMountain = gson.fromJson(json, type);
        ArrayList<RecyclerItem> items = new ArrayList<>();

        for (Mountain robin : listOfMountain){
            Log.d("HEJDÅ", robin.getName());
            items.add(new RecyclerItem(robin.getName()));

        }

      Myadapter adapter = new Myadapter(this, items, new Myadapter.OnClickListener() {
            @Override
            public void onClick(RecyclerItem item) {
                Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_LONG).show();

            }
        });
        RecyclerView view = findViewById(R.id.recycler_view);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);

    }
}

