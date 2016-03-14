package com.example.ecalo.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "thClw1qxGVumOiCXY4olgFWIv";
    private static final String TWITTER_SECRET = "XcTJfjxwcveUcuBE2WefCB9NlNOngDdhcI8PM1obFCdYvsmS5K";

    private ImageButton mylocation;
    private Button find;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        setContentView(R.layout.content_main);
        mylocation = (ImageButton) findViewById(R.id.pin_button);
        find = (Button) findViewById(R.id.find_button);
        final Intent sendIntent = new Intent();
//        final Intent sendIntent = new Intent(getBaseContext(), PhoneToWatchService.class);
        mylocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendIntent.putExtra("LOCATION", 94704);
//                startService(sendIntent);
                startActivity(sendIntent);
            }
        });

        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText zip = (EditText) findViewById(R.id.zip_code);
                sendIntent.putExtra("LOCATION", Integer.parseInt(zip.getText().toString()));
//                startService(sendIntent);
                startActivity(sendIntent);
            }
        });
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
