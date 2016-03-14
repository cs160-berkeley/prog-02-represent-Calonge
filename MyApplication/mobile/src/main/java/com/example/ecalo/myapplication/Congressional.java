
package com.example.ecalo.myapplication;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Congressional extends AppCompatActivity {
    private ImageButton senate1;
    private ImageButton senate2;
    private ImageButton house;
    private String rep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_congressional);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent location = getIntent();
        int zip = location.getIntExtra("LOCATION", 93274);
        TextView person = (TextView) findViewById(R.id.hor_legis);
        ImageButton rep_photo = (ImageButton) findViewById(R.id.rep_photo);
        if (zip != 94704){
            String rep = getResources().getString(R.string.hor1);
            person.setText(rep);
            rep_photo.setBackgroundResource(R.drawable.dev);
            person.setBackgroundColor(ContextCompat.getColor(this, R.color.party_color2));
        } else {
            String rep = getResources().getString(R.string.hor2);
            rep_photo.setBackgroundResource(R.drawable.lee);
            person.setBackgroundColor(ContextCompat.getColor(this, R.color.party_color1));
            person.setText(rep);
        }
        house = (ImageButton) findViewById(R.id.rep_photo);
        senate1 = (ImageButton) findViewById(R.id.senate_photo1);
        senate2 = (ImageButton) findViewById(R.id.senate_photo2);
//        Intent sendIntent = new Intent(getBaseContext(), PhoneToWatchService.class);
        final Intent sendIntent = new Intent();
        house.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendIntent.putExtra("REP", rep);
//                startService(sendIntent);
                startActivity(sendIntent);
            }
        });

        senate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendIntent.putExtra("REP", getResources().getString(R.string.senator2));
//                startService(sendIntent);
                startActivity(sendIntent);
            }
        });


        senate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendIntent.putExtra("REP", getResources().getString(R.string.senator1));
//                startService(sendIntent);
                startActivity(sendIntent);
            }
        });
    }


}