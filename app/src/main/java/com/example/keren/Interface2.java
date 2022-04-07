package com.example.keren;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Interface2 extends AppCompatActivity implements View.OnClickListener {
    ImageView menu;
    MediaPlayer suaraTombol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interface2);
        menu=findViewById(R.id.tombolMenu);
        menu.setOnClickListener(this);

        suaraTombol = MediaPlayer.create(this, R.raw.suaratombol);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.tombolMenu) {
            suaraTombol.start();
            Intent moveIntent = new Intent(Interface2.this, Interface1.class);
            startActivity(moveIntent);
            finishAffinity();
        }
    }
}