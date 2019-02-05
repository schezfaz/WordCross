package com.example.calnik.makingoftheproject_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
// 1 is for HOLLYWOOD and 2 is for BOLLYWOOD
public class Input_Activity extends AppCompatActivity {

    Button hollyButton, bollyButton, hollyPlayButton, bollyPlayButton;
    LinearLayout hollyLayout, bollyLayout;
    EditText holMovieEdit,bolMovieEdit;
    Boolean Caps = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_);
        hollyLayout = (LinearLayout) findViewById(R.id.hollyLayout);
        bollyLayout = (LinearLayout) findViewById(R.id.bollyLayout);
        hollyLayout.setVisibility(View.INVISIBLE);
        bollyLayout.setVisibility(View.INVISIBLE);
        hollyButton = (Button) findViewById(R.id.hollyButton);
        bollyButton = (Button) findViewById((R.id.bollyButton));
        hollyPlayButton = (Button) findViewById(R.id.hollyPlayButton);
        bollyPlayButton = (Button) findViewById(R.id.bollyPlayButton);

    }

    public void Hollywood(View view){
        hollyLayout = (LinearLayout) findViewById(R.id.hollyLayout);
        bollyLayout = (LinearLayout) findViewById(R.id.bollyLayout);
        bollyLayout.setVisibility(View.INVISIBLE);
        hollyLayout.setVisibility(View.VISIBLE);

    }

    public void Bollywood(View view){
        hollyLayout = (LinearLayout) findViewById(R.id.hollyLayout);
        bollyLayout = (LinearLayout) findViewById(R.id.bollyLayout);
        bollyLayout.setVisibility(View.VISIBLE);
        hollyLayout.setVisibility(View.INVISIBLE);

    }

    public void HollyPlay(View view){
        holMovieEdit = (EditText)  findViewById(R.id.holMovieEdit);
        String movieName = holMovieEdit.getText().toString();
        CheckCaps(movieName);
        if(Caps==true) {
            Intent i = new Intent(this, Game_Activity.class);
            i.putExtra("Movie", movieName);
            i.putExtra("Type","1"); // 1 is for HOLLYWOOD and 2 is for BOLLYWOOD
            startActivity(i);
        }
        else
            Toast.makeText(this, "No UpperCases allowed in the Movie name.", Toast.LENGTH_LONG).show();
    }

    public void BollyPlay(View view){
        bolMovieEdit = (EditText)  findViewById(R.id.bolMovieEdit);
        String movieName = bolMovieEdit.getText().toString();
        CheckCaps(movieName);
        if(Caps==true) {
            Intent i = new Intent(this, Game_Activity.class);
            i.putExtra("Movie", movieName);
            i.putExtra("Type","2"); // 1 is for HOLLYWOOD and 2 is for BOLLYWOOD
            startActivity(i);
        }
        else
            Toast.makeText(this, "No UpperCases allowed in the Movie name.", Toast.LENGTH_LONG).show();
    }

    public void HollySelectButton(View view){
        Intent a = new Intent(this,Movie_Selection_Activity.class);
        a.putExtra("type", "1");
        startActivity(a);


    }

    public void BollySelectButton(View view){
        Intent a = new Intent(this,Movie_Selection_Activity.class);
        a.putExtra("type", "2");
        startActivity(a);


    }

    public Boolean CheckCaps(String string){
        for(int z=0; z < string.length(); z++) {
            if (string.charAt(z) >= 'A' && string.charAt(z) <= 'Z') {
                Caps= false;
                break;
            }
            else
                Caps = true;
        }
        return Caps;
    }
}
