package com.example.harrison.bffofscsu;

import android.app.Fragment;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by harrison on 4/9/16.
 */
public class EventNewsFragment extends Fragment {
/*
    private GoogleApiClient client;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_news_layout);

        String[] events = new String[]{"Fall Concert", "Ted Talk", "Ice Cream Social"};
        List<Map<String,String>> data  = new ArrayList<Map<String,String>>();
        for (String event  :events){
            Map<String, String> newEntry = new HashMap<>();
            newEntry.put("title", event);
            newEntry.put("sub-title", new Date().toString());
            data.add(newEntry);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, data,
                android.R.layout.simple_list_item_2,
                new String[] {"title","sub-title"},
                new int[]{ android.R.id.text1,
                        android.R.id.text2});

        ListView listView = (ListView) findViewById(R.id.eventListView);
        listView.setAdapter(adapter);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }*/
}
