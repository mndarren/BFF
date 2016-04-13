/*
package com.example.harrison.bffofscsu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created by harrison on 4/9/16.
 */
/*
public class MenuBar extends MenuBar{
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
}
*/