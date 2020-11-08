package com.example.nota2banco;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;
public class INFO_ACT extends AppCompatActivity {
    private VideoView video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_n_f_o__a_c_t);
        video = (VideoView)findViewById(R.id.Vid);
        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(ruta);
        video.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        video.setMediaController(mediaController);
    }
    public void Maps (View v)
    {
        Intent i = new Intent(this, MAPS_ACT.class);
        startActivity(i);
    }
}