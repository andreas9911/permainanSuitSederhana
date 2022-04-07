package com.example.keren;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Interface1 extends AppCompatActivity implements View.OnClickListener {
    ImageView mulai, petunjuk, keluar;
    MediaPlayer suaraTombol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interface1);

        mulai=findViewById(R.id.tombolMain);
        petunjuk=findViewById(R.id.tombolPetunjuk);
        keluar=findViewById(R.id.tombolKeluar);

        mulai.setOnClickListener(this);
        petunjuk.setOnClickListener(this);
        keluar.setOnClickListener(this);

        suaraTombol = MediaPlayer.create(this, R.raw.suaratombol);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.tombolMain) {
            suaraTombol.start();
            Intent moveIntent = new Intent(Interface1.this, Interface3.class);
            startActivity(moveIntent);
        }
        else if (view.getId() == R.id.tombolPetunjuk) {
            suaraTombol.start();
            Intent moveIntent2 = new Intent(Interface1.this, Interface2.class);
            startActivity(moveIntent2);
        }
        else if (view.getId() == R.id.tombolKeluar) {
            finishAffinity();
        }
    }
}