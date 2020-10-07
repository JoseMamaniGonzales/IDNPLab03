package com.example.idnplab03;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MediaPlayer sonido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void onResume(){
        super.onResume();
        reiniciarAudio();
    }
    protected void onPause(){
        super.onPause();
        pausarAudio();
    }

    public void reiniciarAudio(){
        if(sonido == null){
            sonido = MediaPlayer.create(this,R.raw.musica);
            sonido.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    pausarAudio();
                }
            });
        }
        sonido.start();
    }
    public void pausarAudio(){
        if(sonido != null){
            sonido.pause();
        }
    }
}