package com.example.harrison.bffofscsu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventNewsActivity extends AppCompatActivity {

    private GoogleApiClient client;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.office_hour:
                Toast.makeText(this, "Touched office hour", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), OfficeHourActivity.class);
                intent.putExtra("key", 1);
                startActivity(intent);
                return true;
            case R.id.free_resource:
                Toast.makeText(this, "Touched free resource", Toast.LENGTH_LONG).show();
                Intent freeResourceIntent = new Intent(getApplicationContext(), FreeResourceActivity.class);
                freeResourceIntent.putExtra("key", 1);
                startActivity(freeResourceIntent);
                return true;
            case R.id.event_news:
                Toast.makeText(this, "Touched event news", Toast.LENGTH_LONG).show();
                Intent eventIntent = new Intent(getApplicationContext(), EventNewsActivity.class);
                eventIntent.putExtra("key", 1);
                startActivity(eventIntent);
                return true;
            case R.id.me:
                Toast.makeText(this, "Touched profile", Toast.LENGTH_LONG).show();
                Intent meIntent = new Intent(getApplicationContext(), MeActivity.class);
                meIntent.putExtra("key", 1);
                startActivity(meIntent);
                return true;
            case R.id.search:
                Toast.makeText(this, "Touched search", Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_settings:
                Toast.makeText(this, "Touched setting", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
    }
}
