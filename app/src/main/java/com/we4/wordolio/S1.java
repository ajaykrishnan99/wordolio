package com.we4.wordolio;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.we4.wordolio.localdb.LocalDB;

import static android.R.attr.id;

public class S1 extends AppCompatActivity {
    TextView t1,t2,t3;
    Button b1,b2;
    EditText e1;
    int ctr=0;
    int score=0;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s1);
        t1 = (TextView) findViewById(R.id.textView);
        t2 = (TextView) findViewById(R.id.textView2);
        t3=(TextView)findViewById(R.id.textView4);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button4);
        e1 = (EditText) findViewById(R.id.editText2);
    }
        public void clue(View view)
        {

            t2.setVisibility(View.VISIBLE);
            score=score-30;

        }
    public void ok(View view)
    {
        try
        {
            String w= e1.getText().toString();
            w=w.toLowerCase();
            int n=w.length();
            int i,count=0;
            if(n<3)
            {
                Toast.makeText(getApplicationContext(),"Enter at least a 3 letter word",Toast.LENGTH_SHORT).show();
            }
            else
            {
                for(i=0;i<n;i++)
                 if(w.charAt(i)=='t' || w.charAt(i)=='w' || w.charAt(i)=='i' || w.charAt(i)=='n')
                     count=count+1;
                if(w.equals("twin") && count==4)
                {
                    score=score+100;
                    LocalDB.getInstance().insertToSimpleScore(1,score);
                    LocalDB.getInstance().updateSimpleScoreStatus(1,score);
                    LocalDB.getInstance().updateSimpleStatus(2,"true");
                    AlertDialog.Builder ad = new AlertDialog.Builder(S1.this);
                    ad.setTitle("You have found the Correct word !!");
                    ad
                            .setMessage("Play Next ?")
                            .setCancelable(false)
                            .setPositiveButton("Continue",new DialogInterface.OnClickListener(){
                                public void onClick(DialogInterface dialog,int id){

                                  //  db.execSQL("insert or update into level(falg) values('+flag');");
                                    Intent pos=new Intent(S1.this,Simple.class);
                                    startActivity(pos);
                                    finish();


                                }


                })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
                                public void onClick(DialogInterface dialog,int id) {
                                    dialog.cancel();
                                }
                });
                    AlertDialog alert=ad.create();
                    alert.show();


                }
                //t3.setText("" + count);
                t3.append("\n" + "" + w + "-" + "" + count);
                e1.setText("");
                ctr = ctr + 1;
                if(ctr%10 == 0)
                {
                    score=score-10;
                }

            }
        }
        catch(Exception e){}
    }


}
