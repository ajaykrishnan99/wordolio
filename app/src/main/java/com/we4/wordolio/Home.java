package com.we4.wordolio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.we4.wordolio.localdb.LocalDB;

public class Home extends AppCompatActivity {

     TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ImageButton b1=(ImageButton)findViewById(R.id.imageButton1);
        ImageButton b2=(ImageButton)findViewById(R.id.imageButton2);
        ImageButton b3=(ImageButton)findViewById(R.id.imageButton3);
        LocalDB.initLocalDB(this);

    }
    public void htp(View view)
    {
        Intent i1= new Intent(Home.this,HowToPlay.class);
        startActivity(i1);

    }
    public void level(View view)
    {
        Intent i2= new Intent(Home.this,Level.class);
        startActivity(i2);

    }
    public void sb(View view)
    {
        Intent i3= new Intent(Home.this,ScoreBoard.class);
        startActivity(i3);

    }
}
