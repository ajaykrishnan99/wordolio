package com.we4.wordolio;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.we4.wordolio.localdb.LocalDB;


public class Simple extends AppCompatActivity {
   // SQLiteDatabase db;
   static int flag;
    ImageButton b1,b2,b3,b4,b5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        ImageButton b1=(ImageButton)findViewById(R.id.imageButton4);
        ImageButton b2=(ImageButton)findViewById(R.id.imageButton5);
        ImageButton b3=(ImageButton)findViewById(R.id.imageButton6);
        ImageButton b4=(ImageButton)findViewById(R.id.imageButton7);
        ImageButton b5=(ImageButton)findViewById(R.id.imageButton8);
        String status= LocalDB.getInstance().getSimpleStatus(2);
        if(status.equals("true")) {
            b2.setEnabled(true);
            b2.setBackgroundColor(Color.TRANSPARENT);

        }
        else
        {
            b2.setEnabled(false);

        }
        status= LocalDB.getInstance().getSimpleStatus(3);
        if(status.equals("true")) {
            b3.setEnabled(true);
            b3.setBackgroundColor(Color.TRANSPARENT);
        }
        else
        {
            b3.setEnabled(false);
        }
        status= LocalDB.getInstance().getSimpleStatus(4);
        if(status.equals("true")) {
            b4.setEnabled(true);
            b4.setBackgroundColor(Color.TRANSPARENT);
        }
        else
        {
            b4.setEnabled(false);
        }
        status= LocalDB.getInstance().getSimpleStatus(5);
        if(status.equals("true")) {
            b5.setEnabled(true);
            b5.setBackgroundColor(Color.TRANSPARENT);
        }
        else
        {
            b5.setEnabled(false);
        }

        /*for(int i=1;i<5;i++)
        {
            status= LocalDB.getInstance().getSimpleStatus(i+1);
            if(status.equals("true"))
            {

            }

        }*/
        /*Intent pos = getIntent();
        flag=pos.getIntExtra("key1",0);
        if(flag==1)
        {
            b2.setEnabled(true);

        }*/


    }

    public void one(View view)
    {
        Intent s1=new Intent(Simple.this,S1.class);
        startActivity(s1);
        finish();
    }
    public void two(View view)
    {
        Intent s2=new Intent(Simple.this,S2.class);
        startActivity(s2);
        finish();
    }
    public void three(View view)
    {
        Intent s3=new Intent(Simple.this,S3.class);
        startActivity(s3);
        finish();
    }
    public void four(View view)
    {
        Intent s4=new Intent(Simple.this,S4.class);
        startActivity(s4);
        finish();
    }
    public void five(View view)
    {
        Intent s5=new Intent(Simple.this,S5.class);
        startActivity(s5);
        finish();
    }
    public void sb(View view)
    {
        Intent sb=new Intent(Simple.this,SimpleScore.class);
        startActivity(sb);
        finish();
    }


}
