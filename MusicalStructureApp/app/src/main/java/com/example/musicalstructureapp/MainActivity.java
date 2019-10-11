package com.example.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void GoToCollectionCategory(View view) {
        Intent intent = new Intent(MainActivity.this,CollectionCategoryView.class);
        startActivity(intent);
    }

    public void GoToRapCategory(View view) {
        Intent intent = new Intent(MainActivity.this,RapCategoryView.class);
        startActivity(intent);
    }

    public void GoToPlayingNowFromHome(View view) {
        if(ListAdapter.song_name != null && ListAdapter.artist_name != null && ListAdapter.song_category != null){
        Intent intent = new Intent(MainActivity.this,PlayingNowView.class);
        intent.putExtra("Song_Name",ListAdapter.song_name);
        intent.putExtra("Artist_Name",ListAdapter.artist_name);
        intent.putExtra("Song_Image",Integer.toString(ListAdapter.song_image));
        intent.putExtra("current",ListAdapter.song_category);
        startActivity(intent);
        }
        else {
            Toast.makeText(this, "No Songs Playing Now", Toast.LENGTH_SHORT).show();
        }
    }
}
