package com.example.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.awt.font.TextAttribute;

public class PlayingNowView extends AppCompatActivity {

    TextView Song_Name ;
    TextView Artist_Name ;
    ImageView Song_Image ;
    String current ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_now_view);
        Song_Name = (TextView) findViewById(R.id.playing_name);
        Artist_Name = (TextView) findViewById(R.id.playing_artist);
        Song_Image = (ImageView) findViewById(R.id.playing_image);
        Bundle extras = getIntent().getExtras();
        Song_Name.setText(extras.getString("Song_Name"));
        Artist_Name.setText(extras.getString("Artist_Name"));
        Song_Image.setImageResource(Integer.parseInt(extras.getString("Song_Image")));
        current = extras.getString("current");
    }

    public void Back2Home(View view) {
        Intent intent = new Intent(this , MainActivity.class);
        startActivity(intent);
    }

    public void PreviousPage(View view) {
       if (current.equals("rap")){
           Intent intent = new Intent(this ,RapCategoryView.class);
           startActivity(intent);
       }
       else {
           Intent intent = new Intent(this ,CollectionCategoryView.class);
           startActivity(intent);
       }

    }
}
