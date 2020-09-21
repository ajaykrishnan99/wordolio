package com.we4.wordolio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ScoreBoard extends AppCompatActivity {
 ImageButton b1,b2,b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);
        b1=(ImageButton)findViewById(R.id.imageButton);
        b2=(ImageButton)findViewById(R.id.imageButton9);
        b3=(ImageButton)findViewById(R.id.imageButton10);
        b4=(ImageButton)findViewById(R.id.imageButton7);

    }
    public void goHome(View view)
    {
        Intent h=new Intent(ScoreBoard.this,Home.class);
        startActivity(h);
        finish();
    }
    public void simpleScore(View view)
    {
        Intent simpleScore=new Intent(ScoreBoard.this,SimpleScore.class);
        startActivity(simpleScore);
        finish();

    }
    public void medScore(View view)
    {
        Intent medScore=new Intent(ScoreBoard.this,MediumScore.class);
        startActivity(medScore);
        finish();

    }
    public void difScore(View view)
    {
        Intent difScore=new Intent(ScoreBoard.this,DifficultScore.class);
        startActivity(difScore);
        finish();

    }
}
