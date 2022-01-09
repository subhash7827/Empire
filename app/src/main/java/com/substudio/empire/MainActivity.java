package com.substudio.empire;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    MediaPlayer music;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        music = MediaPlayer.create(this, R.raw.song1);
        Timer t = new Timer();

        t.scheduleAtFixedRate(
                new TimerTask() {
                    @Override
                    public void run() {
                        autoplay();
                    }
                }, 0, 2000
        );
    }

    Integer x=R.raw.song1;

        public void musicplay(View v)
        {
            String str ="Now Playing song"+(x-R.raw.song1+1);
            Toast.makeText(this, str, Toast.LENGTH_LONG).show();
            music.start();
        }

        // Pausing the music
        public void musicpause(View v)
        {
            music.pause();
        }

        // Stoping the music
        public void musicnext(View v)
        {
            music.stop();
            if (x==R.raw.song3)
            {
                x=R.raw.song1;
            }
            x++;
            music = MediaPlayer.create(
                    this, x);

            String str ="Now Playing song"+(x-R.raw.song1);
            Toast.makeText(this, str, Toast.LENGTH_LONG).show();
            music.start();
        }
        public void autoplay()
        {
            if (music.getCurrentPosition()+3000>=music.getDuration())
            {
                if (x == R.raw.song3) {
                    x = R.raw.song1;
                }
                x++;
                music = MediaPlayer.create(
                        this, x);

                String str ="Now Playing song"+(x-R.raw.song1);
                Toast.makeText(this, str, Toast.LENGTH_LONG).show();
                music.start();
            }
        }
         public void musicprev(View v)
        {
            music.stop();
            if (x==R.raw.song1)
            {
                x=R.raw.song3;
            }
            x--;
            music = MediaPlayer.create(
                    this, x);

            String str ="Now Playing song"+(x-R.raw.song1);
            Toast.makeText(this, str, Toast.LENGTH_LONG).show();
            music.start();
        }

}
