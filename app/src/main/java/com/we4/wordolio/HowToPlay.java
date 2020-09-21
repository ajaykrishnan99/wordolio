package com.we4.wordolio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HowToPlay extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_play);
        ImageButton b1=(ImageButton)findViewById(R.id.imageButton11);


    }
    public void home(View view)
    {
        Intent h=new Intent(HowToPlay.this,Home.class);
        startActivity(h);
        finish();
    }
}
