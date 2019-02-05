package com.example.calnik.makingoftheproject_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SinglePlayerActivity extends AppCompatActivity {

    TextView p1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);
        Intent x = getIntent();
        x.getStringExtra("Type");
       String qq = x.getStringExtra("Movie");
        p1 = (TextView) findViewById(R.id.p1) ;
        p1.setText(qq);
    }
}
