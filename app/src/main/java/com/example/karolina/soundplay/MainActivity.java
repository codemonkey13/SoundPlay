package com.example.karolina.soundplay;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    MediaPlayer soundEffect;
    int startTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Mui mui song", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                        //soundEffect.start();



            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        soundEffect = new MediaPlayer();
        soundEffect = MediaPlayer.create(this, R.raw.muimui);
        soundEffect.setAudioStreamType(AudioManager.STREAM_MUSIC);
        //soundEffect.start();
    }
    @Override
   protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_main);
        if (startTime > 0) {
            soundEffect.seekTo(startTime);
            soundEffect.start();
        }
        else{
            soundEffect.start();
        }
    }
    @Override
    protected  void onPause() {
        super.onPause();

        startTime = soundEffect.getCurrentPosition();
        soundEffect.pause();
    }

    @Override
    protected void onStop() {
        super.onStop();

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        soundEffect.release();
    }



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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
