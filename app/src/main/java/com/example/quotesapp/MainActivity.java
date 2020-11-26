package com.example.quotesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<data> quotesdata = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data data = new data("1stThis is by default shayari This is by default shayari This is by default shayari ");
        data data1 = new data("2ndThis is by default shayari This is by default shayari This is by default shayari ");
        data data2 = new data("3rdThis is by default shayari This is by default shayari This is by default shayari ");
        data data3 = new data("4thThis is by default shayari This is by default shayari This is by default shayari ");

        quotesdata.add(data);
        quotesdata.add(data1);
        quotesdata.add(data2);
        quotesdata.add(data3);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        adapter adapter = new adapter(quotesdata,getApplicationContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}