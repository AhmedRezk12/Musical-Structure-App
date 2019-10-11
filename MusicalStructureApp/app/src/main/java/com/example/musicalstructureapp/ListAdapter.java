package com.example.musicalstructureapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

class ListAdapter extends BaseAdapter
{
    Activity context ;
    ArrayList<Song> Songs = new ArrayList<>();
    static String song_name ;
    static String artist_name ;
    static String song_category ;
    static int song_image ;
    ListAdapter (ArrayList<Song> Songs , Activity context )
    {
        this.Songs = Songs ;
        this.context = context ;
    }

    @Override
    public int getCount()
    {
        return Songs.size();
    }

    @Override
    public long getItemId(int position) {
        return position ;
    }

    @Override
    public Object getItem(int position) {
        return Songs.get(position);
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.row_song , null);

        final ImageView SongImage = (ImageView) view.findViewById(R.id.song_image);
        TextView SongName = (TextView) view.findViewById(R.id.song_name);
        TextView ArtistName = (TextView) view.findViewById(R.id.artist_name);
        Button PlayButton = (Button) view.findViewById(R.id.play_button);

        SongName.setText(String.valueOf(Songs.get(i).SongName));
        ArtistName.setText(Songs.get(i).ArtistName);
        SongImage.setImageResource(Songs.get(i).SongImage);

        PlayButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PlayingNowView.class);
                intent.putExtra("Song_Name",Songs.get(i).SongName);
                intent.putExtra("Artist_Name",Songs.get(i).ArtistName);
                intent.putExtra("Song_Image",Integer.toString(Songs.get(i).SongImage));
                intent.putExtra("current",Songs.get(i).SongCategory);
                context.startActivity(intent);
                song_name = Songs.get(i).SongName ;
                artist_name = Songs.get(i).ArtistName ;
                song_category = Songs.get(i).SongCategory ;
                song_image = Songs.get(i).SongImage ;
                Toast.makeText(context,Songs.get(i).SongName + " is playing", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
