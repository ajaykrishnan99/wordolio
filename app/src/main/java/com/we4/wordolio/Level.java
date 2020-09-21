package com.we4.wordolio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.we4.wordolio.localdb.LocalDB;

public class Level extends AppCompatActivity {
    LocalDB localDB=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        ImageButton ib1=(ImageButton)findViewById(R.id.imageButton6);
        Button b1=(Button)findViewById(R.id.button1);
        Button b2=(Button)findViewById(R.id.button2);
        Button b3=(Button)findViewById(R.id.button3);
        for(int i=0; i<5; i++)
        {
            if(i==0){
                LocalDB.getInstance().insertToSimple(i+1,"true");

            }
            else{
                LocalDB.getInstance().insertToSimple(i+1,"false");
            }
        }
        for(int i=5; i<10; i++)
        {
            if(i==5){
                LocalDB.getInstance().insertToSimple(i+1,"true");

            }
            else{
                LocalDB.getInstance().insertToSimple(i+1,"false");
            }
        }
        for(int i=10; i<15; i++)
        {
            if(i==15){
                LocalDB.getInstance().insertToSimple(i+1,"true");

            }
            else{
                LocalDB.getInstance().insertToSimple(i+1,"false");

            }
        }



    }
    public void simple(View view){

        Intent i1=new Intent(Level.this,Simple.class);
        startActivity(i1);

    }
    public void med(View view){
        Intent i2=new Intent(Level.this,Medium.class);
        startActivity(i2);

    }
    public void dif(View view){
        Intent i3=new Intent(Level.this,Difficult.class);
        startActivity(i3);

    }
    public void goHome(View view)
    {
        Intent home=new Intent(Level.this,Home.class);
        startActivity(home);

    }
}
