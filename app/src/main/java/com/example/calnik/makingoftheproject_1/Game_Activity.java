package com.example.calnik.makingoftheproject_1;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
// //1 is for HOLLYWOOD and 2 is for BOLLYWOOD
public class Game_Activity extends AppCompatActivity {

    LinearLayout linearLayout, letter, letter2;
    RelativeLayout homeLayout;
    TextView guessedText;
    EditText guessedEdit;
    Button guessedButton;
    TextView textView[] = new TextView[100];
    TextView textView2[] = new TextView[100];
    ImageView imageView;
    int counter = 0;
    int winCounter = 0;
    int spaceCounter = 0;

    String guess = "";
    Spannable spannable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_);
        homeLayout = (RelativeLayout) findViewById(R.id.homeLayout);
        homeLayout.setVisibility(View.INVISIBLE);
        imageView= (ImageView) findViewById(R.id.imageView);
        Intent i = getIntent();
        String movieName = i.getStringExtra("Movie");
        String type = i.getStringExtra("Type");

        //Placing Hollywood if type = 1 and Bollywood if type = 2
        if(type.charAt(0) == '1')
            imageView.setImageResource(R.drawable.hollywood_0);
        else
            imageView.setImageResource(R.drawable.bollywood_1);


        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        letter = (LinearLayout) findViewById(R.id.letter);
        letter2 = (LinearLayout) findViewById(R.id.letter2);
        int x= movieName.length();

        //CREATING TEXTVIEWS DYNAMICALLY FOR THE WORD TO BE GUESSED.
        for(int z=0 ; z < x ; z++) {
            textView[z] = new TextView(this);
            if(movieName.charAt(z)== ' ') {

                textView[z].setText("/ ");
                spaceCounter++;
            }
            else if(movieName.charAt(z)== 'a' || movieName.charAt(z)== 'e' || movieName.charAt(z)== 'i' || movieName.charAt(z)== 'o' || movieName.charAt(z)== 'u'){
                textView[z].setText("* ");
            }
            else {

                textView[z].setText("_ ");

            }

            if(movieName.length() < 20)
                textView[z].setTextSize(35);
            else if (movieName.length() >=20 && movieName.length()<30)
                textView[z].setTextSize(23);
            else
                textView[z].setTextSize(18);

            linearLayout.addView(textView[z]);
        }
        char ch = 'a';

        int myColor = this.getResources().getColor(R.color.mycolor1);
        //CREATING TEXTVIEWS FOR THE ALPHABETS FOR THE WRONG GUESSES

        for(int z=0 ; z < 15 ; z++) {
            textView2[z] = new TextView(this);
            String chh= String.valueOf(ch);
            textView2[z].setText(chh + " ");
            textView2[z].setTextSize(20);
            textView2[z].setTextColor(myColor);
            letter.addView(textView2[z]);
            ch++;
        }
        for(int z= 15; z < 26 ; z++) {
            textView2[z] = new TextView(this);
            String chh= String.valueOf(ch);
            textView2[z].setText(chh + " ");
            textView2[z].setTextSize(20);
            textView2[z].setTextColor(myColor);
            letter2.addView(textView2[z]);
            ch++;
        }


    }

    /**
     * THIS CHECKS IF THE INPUT LETTER IS A PART OF THE MOVIE NAME
     *  (Enter Button)
     */

    public void GuessLetter(){
        guessedEdit = (EditText) findViewById(R.id.guessedEdit);
        guessedButton= (Button) findViewById(R.id.guessedButton);
        int myColor = this.getResources().getColor(R.color.mycolor1);
        String LetterGuessed = guessedEdit.getText().toString();
        boolean letterguessed = false;
        Intent i = getIntent();
        String movieName = i.getStringExtra("Movie");
        String type = i.getStringExtra("Type");
        int x= movieName.length();
        guess = guess + LetterGuessed;
        //IF EMPTY STRING IS ENTERED
        if (LetterGuessed.length() == 0 || LetterGuessed.charAt(0) == ' ' || (LetterGuessed.charAt(0)>='A' && LetterGuessed.charAt(0)<='Z')) {
            Toast.makeText(this, "Please Enter a VALID Letter.", Toast.LENGTH_LONG).show();
            guessedEdit.setText("");
            guessedEdit.requestFocus();
        }
        else {
            //CHECKS WHETHER THE LETTER BELONGS TO THE MOVIE
            for (int z = 0; z < x; z++) {
                if (movieName.charAt(z) == LetterGuessed.charAt(0)) {
                    textView[z].setText(LetterGuessed);
                    textView[z].setTextColor(myColor);
                    letterguessed = true;
                    WinCheck();
                    //Strikes out the letter from the letter list
                    for (int zz = 0; zz < 26; zz++) {
                        String what = textView2[zz].getText().toString();
                        if (what.charAt(0) == LetterGuessed.charAt(0)) {
                            textView2[zz].setText(what, TextView.BufferType.SPANNABLE);
                            textView2[zz].setTextColor(Color.RED);
                            Spannable spannable = (Spannable) textView2[zz].getText();
                            spannable.setSpan(new StrikethroughSpan(), 0, what.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                            guessedEdit.setText("");
                            guessedEdit.requestFocus();
                        }
                    }
                }
            }
        }
        //THIS CANCELS THE WRONG LETTER THAT HAS BEEN GUESSED
        if(letterguessed==false) {
            //IF EMPTY STRING IS ENTERED
            if (LetterGuessed.length() == 0|| LetterGuessed.charAt(0) == ' ' || (LetterGuessed.charAt(0)>='A' && LetterGuessed.charAt(0)<='Z')) {
                Toast.makeText(this, "Please Enter a VALID Letter.", Toast.LENGTH_LONG).show();
                guessedEdit.setText("");
                guessedEdit.requestFocus();
            } else {
                for (int z = 0; z < 26; z++) {
                    String what = textView2[z].getText().toString();
                    if (what.charAt(0) == LetterGuessed.charAt(0)) {
                        textView2[z].setText(what, TextView.BufferType.SPANNABLE);
                        textView2[z].setTextColor(Color.RED);
                        Spannable spannable = (Spannable) textView2[z].getText();
                        spannable.setSpan(new StrikethroughSpan(), 0, what.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        guessedEdit.setText("");
                    }
                }
                if(type.charAt(0) == '1')
                    hollyWrongGuess(movieName);
                else
                    bollyWrongGuess(movieName);
            }
        }


    }

    /**
     * this is to change the ImageView (HOLLYWOOD) every time a wrong letter is introduced
     */

    public  void hollyWrongGuess(String movieName){
        counter++;
        imageView = (ImageView) findViewById(R.id.imageView);
        if(counter == 1){
            imageView.setImageResource(R.drawable.hollywood_1);
        }
        if(counter == 2){
            imageView.setImageResource(R.drawable.hollywood_2);
        }
        if(counter == 3){
            imageView.setImageResource(R.drawable.hollywood_3);
        }
        if(counter == 4){
            imageView.setImageResource(R.drawable.hollywood_4);
        }
        if(counter == 5){
            imageView.setImageResource(R.drawable.hollywood_5);
        }
        if(counter == 6){
            imageView.setImageResource(R.drawable.hollywood_6);
        }
        if(counter == 7){
            imageView.setImageResource(R.drawable.hollywood_7);
        }
        if(counter == 8){
            imageView.setImageResource(R.drawable.hollywood_8);
        }
        if(counter == 9){
            imageView.setImageResource(R.drawable.hollywood_9);
            LosePage(movieName);
        }


    }

    /**
     * this is to change the ImageView (BOLLYWOOD) every time a wrong letter is introduced
     */
    public  void bollyWrongGuess(String movieName){
        counter++;
        imageView = (ImageView) findViewById(R.id.imageView);
        if(counter == 1){
            imageView.setImageResource(R.drawable.bollywood_2);
        }
        if(counter == 2){
            imageView.setImageResource(R.drawable.bollywood_3);
        }
        if(counter == 3){
            imageView.setImageResource(R.drawable.bollywood_4);
        }
        if(counter == 4){
            imageView.setImageResource(R.drawable.bollywood_5);
        }
        if(counter == 5){
            imageView.setImageResource(R.drawable.bollywood_6);
        }
        if(counter == 6){
            imageView.setImageResource(R.drawable.bollywood_7);
        }
        if(counter == 7){
            imageView.setImageResource(R.drawable.bollywood_8);
        }
        if(counter == 8){
            imageView.setImageResource(R.drawable.bollywood_9);
        }
        if(counter == 9){
            imageView.setImageResource(R.drawable.bollywood_10);
            LosePage(movieName);
        }


    }

    /**
     * Just to check if all the letters have been guessed or not.
     */
    public void WinCheck(){
        winCounter++;

        Intent i = getIntent();
        String movieName = i.getStringExtra("Movie");
        int x= movieName.length();

        if(winCounter == x-spaceCounter){
            WinPage(movieName);
        }
    }

    /**
     * After all the Letters have been guessed
     */
    public void WinPage(String movieName){

        Intent s = new Intent(this, Win_Lose_Page.class);
        s.putExtra("WinorLose", "Congratulations!");
        s.putExtra("Movie", "You have successfully guessed the Movie Name.");
        startActivity(s);
    }

    /**
     * If all Guessing chances are OVER
     */

    public void LosePage(String movieName){

        Intent s = new Intent(this, Win_Lose_Page.class);
        s.putExtra("WinorLose", "Better Luck Next Time! \nthe movie was:");
        s.putExtra("Movie",movieName);
        startActivity(s);

    }

// If home button is pressed
    public void Home(View view){
        Button yes, no;
        yes = (Button) findViewById(R.id.yesButton);
        no = (Button) findViewById(R.id.noButton);
        homeLayout.setVisibility(View.VISIBLE);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeLayout.setVisibility(View.INVISIBLE);
            }
        });

    }

    public void Guess(View view){
        guessedEdit = (EditText) findViewById(R.id.guessedEdit);
        guessedButton= (Button) findViewById(R.id.guessedButton);
        boolean qwerty = false;
        String LetterGuessed = guessedEdit.getText().toString();
        for(int i=0; i < guess.length(); i++) {
            if (LetterGuessed.charAt(0) == guess.charAt(i)) {
                Toast.makeText(getApplicationContext(), "Letter has already been guessed.",Toast.LENGTH_SHORT).show();
                qwerty=true;
                guessedEdit.setText("");
                guessedEdit.requestFocus();
                break;
            }
        }
        if(qwerty==false){
            GuessLetter();
        }
    }

}
