package com.example.calnik.makingoftheproject_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import static com.example.calnik.makingoftheproject_1.R.array.Bollywood;

public class Movie_Selection_Activity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> adapter;
    String[] bollymovies, hollymovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie__selection_);
        listView = (ListView) findViewById(R.id.Lists);
        hollymovies= getResources().getStringArray(R.array.Hollywood);
        bollymovies = getResources().getStringArray(R.array.Bollywood);
        Intent a = getIntent();
        String type = a.getStringExtra("type");

        if (type.charAt(0) == '1') {
            adapter = new ArrayAdapter<String>(this, R.layout.new_movie_layout, R.id.list_item, hollymovies);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String s = parent.getItemAtPosition(position).toString();
                    Intent i = new Intent(getApplicationContext(),Game_Activity.class);
                    i.putExtra("Movie",s);
                    i.putExtra("Type", "1");
                    startActivity(i);
                }
            });
        }
        else {
            adapter = new ArrayAdapter<String>(this, R.layout.new_movie_layout, R.id.list_item, bollymovies);
                    listView.setAdapter(adapter);

                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String s = parent.getItemAtPosition(position).toString();
                            Intent i = new Intent(getApplicationContext(),Game_Activity.class);
                            i.putExtra("Movie",s);
                            i.putExtra("Type", "2");
                            startActivity(i);
                        }
                    });
        }

        /*listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = parent.getItemAtPosition(position).toString();
                Intent i = new Intent(getApplicationContext(),Game_Activity.class);
                i.putExtra("Movie",s);
                i.putExtra("Type", "1");
                startActivity(i);*/



    }
}
