package nl.malmas.cobrex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class SingleRoomActivity extends AppCompatActivity {

    ArrayList<View> tasks;
    LinearLayout tasksLayout;
    private static final String TAG = SingleRoomActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_room);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tasks = new ArrayList<>();
        tasksLayout = (LinearLayout) findViewById(R.id.TasksLinearLayout);


        final TextView tv = (TextView) findViewById(R.id.TaskView);
        assert tv != null;
        ApiClient.getInstance().get(this, "http://mimirus-2.azurewebsites.net/api/Tasks/1", new JsonHttpResponseHandler()
        {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                if (response.has("Mobiliteit") && !response.isNull("Mobiliteit")) {
                    addTaskView("Bed opgemaakt");
                }
                if (response.has("Hulpmiddelen") && !response.isNull("Hulpmiddelen")) {
                    addTaskView("Bed opgemaakt");
                }
                if (response.has("Wasgoed") && !response.isNull("Wasgoed")) {
                    addTaskView("Wasgoed opgehaald");
                }
                if (response.has("Douche") && !response.isNull("Douche")) {
                    addTaskView("Client Gedouched");
                }
                if (response.has("Nachtcontrole") && !response.isNull("Nachtcontrole")) {
                    addTaskView("Nachtcontrole");
                }
                if (response.has("Aangekleed") && !response.isNull("Aangekleed")) {
                    addTaskView("Client Omgekleed");
                }
                if (response.has("Communicatie") && !response.isNull("Communicatie")) {
                    addTaskView("Client Medicijnen toegediend");
                }


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                tv.setText("Er is een fout opgetreden tijdens het ophalen van de gegevens!");
            }
        });


       /* assert tv != null; //get notes van RPI
        ApiClient.getInstance().get(this, "http://mimirus-2.azurewebsites.net/api/notes/1", new JsonHttpResponseHandler()

        {  @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response)
                {
                    super.onSuccess(statusCode, headers, response);

                if (response.has("Text") && !response.isNull("Text")) {
                    addTaskView("Bed opgemaakt");
                    tv.setText(JSONObject);
                    Toast.makeText(SingleRoomActivity.this, result, Toast.LENGTH_LONG).show();
                }


        } */



        //new DownloadTask().execute("http:/m/imirus-2.azurewebsites.net/api/Tasks/1"); //taken ophalen
    }

    public void addTaskView(String taskName) {
        View taskBlock = getLayoutInflater().inflate(R.layout.task_view, tasksLayout, false);
        TextView labelTextView = (TextView) taskBlock.findViewById(R.id.TaskLabel);
        labelTextView.setText(taskName);
        tasksLayout.addView(taskBlock);
        tasks.add(taskBlock);
    }

    public void imageClickOnFab(View view)

    {

        if(view.getId() == R.id.fab)   // add task listener
        {
            Intent addTask = new Intent(this,AddTaskActivity.class);
            startActivity(addTask);
        }


    }

    public void buttonClickBackToRoomOverview(View view)
    {
        if(view.getId() == R.id.BbackToRoomOverview);

        {
            finish();


        }



    }
/*
    private class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            //do your request in here so that you don't interrupt the UI thread
            try {
                return downloadContent(params[0]);
            } catch (IOException e) {
                return "Database Error";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            TextView tv = (TextView) findViewById(R.id.TaskView);
            JSONObject resultJsonObject = null;
            try {
                resultJsonObject = new JSONObject(result);
                if (resultJsonObject.has("Mobiliteit") && resultJsonObject.getBoolean("Mobiliteit")) {
                    assert tv != null;
                    tv.append(", Mobiliteit!");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            tv.setText(result);
            Toast.makeText(SingleRoomActivity.this, result, Toast.LENGTH_LONG).show();
        }
    } */
}
