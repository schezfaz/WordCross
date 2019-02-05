package com.example.calnik.makingoftheproject_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button singlePlayerButton, multiPlayerButton;
    RelativeLayout point;
    Button wsx, edc, cancelButton;
    String[] bollymovies, hollymovies;
    int type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        multiPlayerButton = (Button) findViewById(R.id.multiPlayerButton);
        singlePlayerButton = (Button) findViewById(R.id.singlePlayerButton);
        point = (RelativeLayout) findViewById(R.id.point);
        point.setVisibility(View.INVISIBLE);
        wsx = (Button) findViewById(R.id.wsx);
        cancelButton = (Button) findViewById(R.id.cancelButton);
        edc = (Button) findViewById(R.id.edc);
    }


    public void Multiplayer(View view){
        Intent i = new Intent(this, Input_Activity.class);
        startActivity(i);

    }

    public void Singleplayer(View view){
        singlePlayerButton.setVisibility(View.INVISIBLE);
        multiPlayerButton.setVisibility(View.INVISIBLE);
        point.setVisibility(View.VISIBLE);
    }

    public void yeahMahn(View view){
        type = 1;
        autoSelectMovie(type);
    }

    public void noMahn(View view){
        type = 2;
        autoSelectMovie(type);
    }

    public void closeMahn(View view){
        point.setVisibility(View.INVISIBLE);
        singlePlayerButton.setVisibility(View.VISIBLE);
        multiPlayerButton.setVisibility(View.VISIBLE);
    }

    public void autoSelectMovie(int type){
        hollymovies= getResources().getStringArray(R.array.Hollywood);
        bollymovies = getResources().getStringArray(R.array.Bollywood);
        Random r = new Random();
        String s1;
        if(type == 1){
            int r1 = r.nextInt(134 - 1) + 1;
            s1 = hollymovies[r1];
        }

        else{
            int r1 = r.nextInt(115 - 1) + 1;
            s1 = bollymovies[r1];
        }

        Intent x = new Intent(this, Game_Activity.class);
        x.putExtra("Movie", s1);
        String Type = String.valueOf(type);
        x.putExtra("Type", Type);
        startActivity(x);
    }
}

