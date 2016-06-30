package nl.malmas.cobrex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setContentView(R.layout.login_screen);
        setSupportActionBar(toolbar);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }); */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void buttonClickLogIn(View view)  // scherm RoomOverviewnadat gebruiker inlogt.
    {

        if(view.getId() == R.id.Blogin)
        {
            EditText username = (EditText)findViewById(R.id.TFusername);
            String str= username.getText().toString();
            if (str=="Carla")
            {
                Toast.makeText(this, "Verkeerde gegevens", Toast.LENGTH_SHORT).show();

            }

            else {

                Intent roomoverview = new Intent(this, RoomOverviewActivity.class);
                roomoverview.putExtra("Username", str);
                Toast.makeText(this, "Login succesvol", Toast.LENGTH_SHORT).show();
                startActivity(roomoverview);
            }
        }


    }
}
