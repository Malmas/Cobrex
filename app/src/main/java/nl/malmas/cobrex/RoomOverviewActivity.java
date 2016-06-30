package nl.malmas.cobrex;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;

import java.util.ArrayList;

public class RoomOverviewActivity extends AppCompatActivity {
private ImageView roomBlock;
    ArrayList<View> rooms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_overview);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        String username= getIntent().getStringExtra("Username");
        TextView tv= (TextView)findViewById(R.id.headerTextView);
        assert tv != null;
        tv.setText(String.format("Welkom %s", username));
        LinearLayout roomsLayout = (LinearLayout) findViewById(R.id.roomsLinearLayout);
        rooms = new ArrayList<>();
        for(int i = 1; i < 4; i++) {
            View roomBlock = getLayoutInflater().inflate(R.layout.room_block, roomsLayout, false);
            TextView headerTextView = (TextView) roomBlock.findViewById(R.id.headerTextView);
            headerTextView.setText(String.format("Room %d", i));
            roomsLayout.addView(roomBlock);
            rooms.add(roomBlock);
        }


    }


    public void imageClickOnRoom(View view)  //
    {
        if(rooms.indexOf(view) == 0) {
            Intent intent = new Intent(this, SingleRoomActivity.class);
            startActivity(intent);
        }

    }

}
