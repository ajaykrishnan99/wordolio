package com.we4.wordolio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.we4.wordolio.localdb.LocalDB;

public class SimpleScore extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_score);
        String s1,s2,s3,s4,s5;
        t1=(TextView)findViewById(R.id.line1);
        t2=(TextView)findViewById(R.id.line2);
        t3=(TextView)findViewById(R.id.line3);
        t4=(TextView)findViewById(R.id.line4);
        t5=(TextView)findViewById(R.id.line5);
        b1=(Button)findViewById(R.id.button5);

        s1= LocalDB.getInstance().getSimpleScoreStatus(1);
        s2= LocalDB.getInstance().getSimpleScoreStatus(2);
        s3= LocalDB.getInstance().getSimpleScoreStatus(3);
        s4= LocalDB.getInstance().getSimpleScoreStatus(4);
        s5= LocalDB.getInstance().getSimpleScoreStatus(5);
        t1.setText(s1);
        t2.setText(s2);
        t3.setText(s3);
        t4.setText(s4);
        t5.setText(s5);
    }
    public void back(View view)
    {
        Intent i=new Intent(SimpleScore.this,ScoreBoard.class);
        startActivity(i);
        finish();
    }
}
