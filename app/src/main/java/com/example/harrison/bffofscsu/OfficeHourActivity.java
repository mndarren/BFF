package com.example.harrison.bffofscsu;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class OfficeHourActivity extends AppCompatActivity {
    ListView listView;
    String[] names = {"Ramnath Sarnath \nChairperson \nProfessor","Jie H. Meichsner \ncoordinator\nProfessor","Donald O. Hamnes \nProfessor",
            "Bryant A. Julstrom \nProfessor","Mehdi Mekni \nAssistant Professor","Jayantha Herath \nProfessor","Omar Al-Azzam Assistant \nProfessor",
            "Andrew A. Anda \nAssociate Professor","Alek Tomovic Adjunct \nProfessor"};
    String[] departments = {"CSIT","CSIT","CSIT","CSIT","CSIT","CSIT","CSIT","CSIT","CSIT"};
    int[] imgs = {R.drawable.sarnath_icon,R.drawable.meichsner_icon,R.drawable.hamnes_icon,R.drawable.julstrom_icon,
            R.drawable.mekni_icon,R.drawable.herath_icon,
            R.drawable.omar_icon,R.drawable.anda_icon,R.drawable.alex_icon,};

    EditText ETmajorInput;
    Button showProfessorsButton;
    String JSON_STRING;
    JSONObject jsonObject;
    JSONArray jsonArray;
    OHAdapter adapter;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
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
        setContentView(R.layout.office_hour_layout);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        ETmajorInput = (EditText)findViewById(R.id.et_major_input);
        showProfessorsButton = (Button)findViewById(R.id.show_professors);
        listView = (ListView)findViewById(R.id.list_view_office_hour);
        adapter = new OHAdapter(this,R.layout.professor_item_layout);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                if(view==null){
//                    inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                    view = inflater.inflate(R.layout.office_hour_table,null);
//                }
                Intent tableIntent = new Intent(getApplicationContext(),OHTableActivity.class);
                tableIntent.putExtra("json_string",JSON_STRING);
                tableIntent.putExtra("key",1);
                startActivity(tableIntent);


                Toast.makeText(getApplicationContext(),names[position],Toast.LENGTH_LONG).show();
            }
        });

    }

    public void showProfessors(View view){
        EditText et_major = (EditText)findViewById(R.id.et_major_input);
        String temp = et_major.getText().toString();
        String major = (temp ==null?"computer science":temp);
        new BackgroundTask().execute(major);
        try {
            jsonObject = new JSONObject(JSON_STRING);
            jsonArray  = jsonObject.getJSONArray("server_response");

            for(int i=0;i<jsonArray.length();i++){
                JSONObject JO = jsonArray.getJSONObject(i);
                ProfessorInfo professorInfo = new ProfessorInfo.Builder().firstName(JO.getString("professor_first_name"))
                        .lastName(JO.getString("professor_last_name")).jobTitle(JO.getString("professor_job_title"))
                        .department(JO.getString("professor_department")).icon(JO.getString("professor_icon")).build();
                adapter.add(professorInfo);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    public class BackgroundTask extends AsyncTask<String,Void,String> {
        String json_url;

        @Override
        protected void onPreExecute() {
            json_url = "http://bffofscsu.net16.net/json_get_professor_data.php";
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
                String major = params[0];
                String data = URLEncoder.encode("major","UTF-8")+"="+URLEncoder.encode(major,"UTF-8");
                bufferedWriter.write(data);
                outputStream.close();
                bufferedWriter.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                while((JSON_STRING = bufferedReader.readLine()) != null){
                    stringBuilder.append(JSON_STRING);
                }
                inputStream.close();
                bufferedReader.close();
                httpURLConnection.disconnect();

                return stringBuilder.toString().trim();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            ProgressDialog prgDialog = new ProgressDialog(getApplicationContext());
            prgDialog.setMessage(result);
            prgDialog.setIndeterminate(false);
            prgDialog.setMax(100);
            prgDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            prgDialog.setCancelable(false);
            prgDialog.show();
            JSON_STRING = result;
        }
    }
    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "OfficeHour Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.harrison.bffofscsu/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "OfficeHour Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.harrison.bffofscsu/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }


}
