package nl.malmas.cobrex;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;

public class RoomOverview extends AppCompatActivity {
private ImageView roomBlock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_overview);

        //setTitle("Kameroverzicht");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        String username= getIntent().getStringExtra("Username");
        TextView tv= (TextView)findViewById(R.id.TVusername);
        tv.setText(username);


    }

}
