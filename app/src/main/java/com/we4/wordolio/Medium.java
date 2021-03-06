package com.we4.wordolio;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.we4.wordolio.localdb.LocalDB;

public class Medium extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medium);
        ImageButton b1=(ImageButton)findViewById(R.id.imageButton4);
        ImageButton b2=(ImageButton)findViewById(R.id.imageButton5);
        ImageButton b3=(ImageButton)findViewById(R.id.imageButton6);
        ImageButton b4=(ImageButton)findViewById(R.id.imageButton7);
        ImageButton b5=(ImageButton)findViewById(R.id.imageButton8);
        String status= LocalDB.getInstance().getSimpleStatus(7);
        if(status.equals("true")) {
            b2.setEnabled(true);
            b2.setBackgroundColor(Color.TRANSPARENT);
        }
        else
        {
            b2.setEnabled(false);
        }
        status= LocalDB.getInstance().getSimpleStatus(8);
        if(status.equals("true")) {
            b3.setEnabled(true);
            b3.setBackgroundColor(Color.TRANSPARENT);
        }
        else
        {
            b3.setEnabled(false);
        }
        status= LocalDB.getInstance().getSimpleStatus(9);
        if(status.equals("true")) {
            b4.setEnabled(true);
            b4.setBackgroundColor(Color.TRANSPARENT);
        }
        else
        {
            b4.setEnabled(false);
        }
        status= LocalDB.getInstance().getSimpleStatus(10);
        if(status.equals("true")) {
            b5.setEnabled(true);
            b5.setBackgroundColor(Color.TRANSPARENT);
        }
        else
        {
            b5.setEnabled(false);
        }

    }
    public void one(View view)
    {
        Intent s1=new Intent(Medium.this,M1.class);
        startActivity(s1);
        finish();
    }
    public void two(View view)
    {
        Intent s2=new Intent(Medium.this,M2.class);
        startActivity(s2);
        finish();
    }
    public void three(View view)
    {
        Intent s3=new Intent(Medium.this,M3.class);
        startActivity(s3);
        finish();
    }
    public void four(View view)
    {
        Intent s4=new Intent(Medium.this,M4.class);
        startActivity(s4);
        finish();
    }
    public void five(View view)
    {
        Intent s5=new Intent(Medium.this,M5.class);
        startActivity(s5);
        finish();
    }
    public void sb(View view)
    {
        Intent sb=new Intent(Medium.this,MediumScore.class);
        startActivity(sb);
        finish();
    }


}
