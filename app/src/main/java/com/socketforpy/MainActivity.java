package com.socketforpy;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hide the ActionBar
        Objects.requireNonNull(getSupportActionBar()).hide();

        //set the app to be fullscreen
        tools.setFullscreen(this);

        //get EditText to reach values of ip and ports
        EditText ip = findViewById(R.id.getIP),
                socketPort = findViewById(R.id.socketPort),
                streamPort = findViewById(R.id.streamPort);

        //set an OnClickListener to response the click
        findViewById(R.id.jmp).setOnClickListener(v->{
            //show some message
            tools.showMsg(this, "Try to open the video stream address.");

            //use an intent to goto next activity, together with some values
            Intent it = new Intent(MainActivity.this, newSocket.class);
            it.putExtra("IP", ip.getText().toString());
            it.putExtra("SOCKETPORT", socketPort.getText().toString());
            it.putExtra("STREAMPORT",streamPort.getText().toString());
            startActivity(it);
        });
    }
}