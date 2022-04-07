package com.example.keren;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.keren.R;

import java.util.Random;

public class Interface3 extends AppCompatActivity {

    Button b_batu, b_gunting, b_kertas;
    TextView tv_score;
    ImageView iv_komputer, iv_anda, menu;
    MediaPlayer suaraTombol, suaraGunting, suaraKertas, suaraBatu;

    int SkorAnda, SkorKomputer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interface3);

        b_kertas = (Button) findViewById(R.id.TombolKertas);
        b_gunting = (Button) findViewById(R.id.TombolGunting);
        b_batu = (Button) findViewById(R.id.TombolBatu);

        iv_komputer = (ImageView) findViewById(R.id.komputer);
        iv_anda = (ImageView) findViewById(R.id.anda);

        tv_score = (TextView) findViewById(R.id.score);

        menu = findViewById(R.id.tombolMenu);

        suaraTombol = MediaPlayer.create(this, R.raw.suaratombol);
        suaraGunting = MediaPlayer.create(this, R.raw.suaragunting);
        suaraKertas = MediaPlayer.create(this, R.raw.suarakertas);
        suaraBatu = MediaPlayer.create(this, R.raw.suarabatu);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.tombolMenu) {
                    suaraTombol.start();
                    Intent moveIntent = new Intent(Interface3.this, Interface1.class);
                    startActivity(moveIntent);
                    finishAffinity();
                }
            }
        });

        b_batu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                suaraBatu.start();
                iv_anda.setImageResource(R.drawable.batu);
                String message = play_turn("batu");
                Toast.makeText(Interface3.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Anda: " + Integer.toString(SkorAnda) + " Skor Komputer: " + Integer.toString(SkorKomputer));

            }
        });

        b_gunting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                suaraGunting.start();
                iv_anda.setImageResource(R.drawable.gunting);
                String message = play_turn("gunting");
                Toast.makeText(Interface3.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Anda: " + Integer.toString(SkorAnda) + " Skor Komputer: " + Integer.toString(SkorKomputer));

            }
        });

        b_kertas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                suaraKertas.start();
                iv_anda.setImageResource(R.drawable.kertas);
                String message = play_turn("kertas");
                Toast.makeText(Interface3.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Anda: " + Integer.toString(SkorAnda) + " Skor Komputer: " + Integer.toString(SkorKomputer));

            }
        });


    }

    public String play_turn( String pilihan_anda ) {
        String pilihan_komputer = "";
        Random r = new Random();

        //pilih 1 2 atau 3
        int nomor_pilihan_komputer = r.nextInt(3) + 1;

        if (nomor_pilihan_komputer == 1) {
            pilihan_komputer = "batu";
        }else

        if (nomor_pilihan_komputer == 2) {
            pilihan_komputer = "gunting";
        }else

        if (nomor_pilihan_komputer == 3) {
            pilihan_komputer = "kertas";
        }

        //gambar komputer berdasarkan pilihan
        if (pilihan_komputer == "batu") {
            iv_komputer.setImageResource(R.drawable.batu);
        }else

        if (pilihan_komputer == "gunting") {
            iv_komputer.setImageResource(R.drawable.gunting);
        }else

        if (pilihan_komputer == "kertas") {
            iv_komputer.setImageResource(R.drawable.kertas);
        }

        //menentukan pemenang
        if (pilihan_komputer == pilihan_anda) {
            return "Seri. Tidak ada pemenang.";
        }
        else if (pilihan_anda == "batu" && pilihan_komputer == "gunting") {
            SkorAnda++;
            return "Anda menang.";
        }
        else if (pilihan_anda == "batu" && pilihan_komputer == "kertas") {
            SkorKomputer++;
            return "Anda kalah.";
        }
        else if (pilihan_anda == "gunting" && pilihan_komputer == "batu") {
            SkorKomputer++;
            return "Anda kalah.";
        }
        else if (pilihan_anda == "gunting" && pilihan_komputer == "kertas") {
            SkorAnda++;
            return "Anda menang.";
        }
        else if (pilihan_anda == "kertas" && pilihan_komputer == "batu") {
            SkorAnda++;
            return "Anda menang.";
        }
        else if (pilihan_anda == "kertas" && pilihan_komputer == "gunting") {
            SkorKomputer++;
            return "Anda kalah.";
        }
        else return "Hmm..";




    }
}