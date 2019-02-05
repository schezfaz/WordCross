package com.example.calnik.makingoftheproject_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Win_Lose_Page extends AppCompatActivity {
    TextView winloseText, writtenText;
    ImageButton replayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win__lose__page);
       // replayButton = (ImageButton) findViewById(R.id.replyButton);
        winloseText = (TextView) findViewById(R.id.winloseText);
        writtenText = (TextView) findViewById(R.id.writtenText);

        Intent s = getIntent();
        String one = s.getStringExtra("WinorLose");
        String two = s.getStringExtra("Movie");

        writtenText.setText(one);
        writtenText.setTextSize(35);
        winloseText.setText(two);
        winloseText.setTextSize(30);
    }

    public void Replay(View view){
        Intent i = new Intent(this, Input_Activity.class);
        startActivity(i);
    }

    public void Home(View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
