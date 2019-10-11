package com.example.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RapCategoryView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rap_category_view);
        ArrayList<Song> Songs = new ArrayList<Song>();
        Songs.add(new Song("In da Club" , "50 Cent" ,R.drawable.in_da_club,"rap"));
        Songs.add(new Song("Stan" , "Eminem" ,R.drawable.stan,"rap"));
        Songs.add(new Song("Lose Yourself" , "Eminem" ,R.drawable.lose_yourself,"rap"));
        Songs.add(new Song("Empire State Of Mind" , "Jay-Z feat. Alicia Keys" ,R.drawable.empire_state_of_mind,"rap"));
        Songs.add(new Song("It Was A Good Day" , "Ice Cube" ,R.drawable.it_was_a_good_day,"rap"));
        ListView songs_list = (ListView) findViewById(R.id.rap_category_list);
        ListAdapter adapter = new ListAdapter(Songs,this);
        songs_list.setAdapter(adapter);
    }

    public void Back2Home(View view) {
        Intent intent = new Intent(this , MainActivity.class);
        startActivity(intent);
    }

    public void GoToPlayingNowFromRap(View view) {
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
