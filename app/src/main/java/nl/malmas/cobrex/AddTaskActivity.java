package nl.malmas.cobrex;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

public class AddTaskActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {



    Spinner taskspinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        taskspinner = (Spinner) findViewById(R.id.spinner);
        final Activity activity = this;
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.taken,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        taskspinner.setAdapter(adapter);
        taskspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView myText = (TextView) view;
                Toast.makeText(activity,"U selecteerde" +myText.getText(),Toast.LENGTH_SHORT).show(); // bevestiging van wat de gebruiker heeft geselecteerd
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void buttonClickAddTask(View view) throws UnsupportedEncodingException  // scherm RoomOverviewnadat gebruiker inlogt.
    {

            final Activity activity = this;
            ApiClient.getInstance().get(this, "http://mimirus-2.azurewebsites.net/api/Tasks/1", new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject body) {
                    try {
                        switch (taskspinner.getSelectedItemPosition()) {
                            case 0:
                                body.put("Douche", false); //put request

                                break;

                            case 1:
                                body.put("Wasgoed", false);
                                break;

                            case 2:
                                body.put("Nachtcontrole", false);

                                break;

                            case 3:
                                body.put("Communicatie", false);

                                break;


                        }
                        ApiClient.getInstance().put(activity, "http://mimirus-2.azurewebsites.net/api/Tasks/1", new StringEntity(body.toString()), "application/json", new JsonHttpResponseHandler() {
                            @Override
                            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                                super.onSuccess(statusCode, headers, response);
                                try {
                                    response.get("TiD");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                finish();
                            }
                        });
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            });






    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)

    {
        TextView myText = (TextView) view;
        Toast.makeText(this,"U selecteerde\t" +myText.getText(),Toast.LENGTH_SHORT).show(); // bevestiging van wat de gebruiker heeft geselecteerd

    }



}
