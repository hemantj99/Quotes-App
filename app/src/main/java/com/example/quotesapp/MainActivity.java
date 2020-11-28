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

        data data = new data("“The truly free man is the one who can turn down an invitation to dinner without giving an excuse.”");
        data data1 = new data("“Our task must be to free ourselves... by widening our circle of compassion to embrace all living creatures and the whole of nature and it's beauty.”");
        data data2 = new data("“Maybe some women aren't meant to be tamed. Maybe they just need to run free until they find someone just as wild to run with them."");
        data data3 = new data("“Man cannot be freed by the same injustice that enslaved it.”");
        data data4 = new data("“She decided to free herself, dance into the wind, create a new language. And birds fluttered around her, writing “yes” in the sky.”");
        data data5 = new data("“If all men are born free, how is it that all women are born slaves?"");
        data data6 = new data("“I was not born to be free---I was born to adore and obey.”");
        data data7 = new data("“There is strange comfort in knowing that no matter what happens today, the Sun will rise again tomorrow.”");
        data data8 = new data("“Even when you’d lost everything you thought there was to lose, somebody came along and gave you something for free.”");
        data data9 = new data("“The struggles we endure today will be the ‘good old days’ we laugh about tomorrow.”");
        data data10 = new data("“The library is like a candy store where everything is free.”");
        data data11 = new data("“You want to be free. You also want to be mine. You can't be both.”")
        data data12 = new data("“I freely admit I'm confused. I'm a confused and troubled individual but at the same time...Its Free! ”")

        quotesdata.add(data);
        quotesdata.add(data1);
        quotesdata.add(data2);
        quotesdata.add(data3);
        quotesdata.add(data4);
        quotesdata.add(data5);
        quotesdata.add(data6);
        quotesdata.add(data7);
        quotesdata.add(data8);
        quotesdata.add(data9);
        quotesdata.add(data10);
        quotesdata.add(data11);
        quotesdata.add(data12);

                              
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        adapter adapter = new adapter(quotesdata,getApplicationContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
