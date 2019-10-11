package com.example.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CollectionCategoryView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_category_view);
        ArrayList<Song> Songs = new ArrayList<Song>();
        Songs.add(new Song("Someone Like You" , "Adele" ,R.drawable.someone_like_you,"collection"));
        Songs.add(new Song("Alive" , "Sia" ,R.drawable.alive,"collection"));
        Songs.add(new Song("Wehyati Khaliky" , "Amr Diab" ,R.drawable.wehyati_khaliky,"collection"));
        Songs.add(new Song("Shape Of You" , "Ed Sheeran" ,R.drawable.shape_of_you,"collection"));
        Songs.add(new Song("Believer" , "Imagine Dragons" ,R.drawable.believer,"collection"));
        ListView songs_list = (ListView) findViewById(R.id.collection_category_list);
        ListAdapter adapter = new ListAdapter(Songs,this);
        songs_list.setAdapter(adapter);
    }


    public void Back2Home(View view) {
        Intent intent = new Intent(this , MainActivity.class);
        startActivity(intent);
    }

    public void GoToPlayingNowFromCollection(View view) {
        if(ListAdapter.song_name != null && ListAdapter.artist_name != null && ListAdapter.song_category != null){
            Intent intent = new Intent(this,PlayingNowView.class);
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
