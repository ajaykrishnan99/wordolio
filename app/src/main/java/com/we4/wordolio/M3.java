package com.we4.wordolio;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.we4.wordolio.localdb.LocalDB;

public class M3 extends AppCompatActivity {
    TextView t1,t2,t3;
    Button b1,b2;
    EditText e1;
    int ctr=0;
    int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m3);
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
                    if(w.charAt(i)=='b' || w.charAt(i)=='r' || w.charAt(i)=='a' || w.charAt(i)=='w'||w.charAt(i)=='l')
                        count=count+1;
                if(w.equals("brawl") && count==5)
                {
                    score=score+100;
                    LocalDB.getInstance().insertToSimpleScore(8,score);
                    LocalDB.getInstance().updateSimpleScoreStatus(8,score);
                    LocalDB.getInstance().updateSimpleStatus(9,"true");
                    AlertDialog.Builder ad = new AlertDialog.Builder(M3.this);
                    ad.setTitle("You have found the Correct word !!");
                    ad
                            .setMessage("Play Next ?")
                            .setCancelable(false)
                            .setPositiveButton("Continue",new DialogInterface.OnClickListener(){
                                public void onClick(DialogInterface dialog,int id){
                                    Intent pos=new Intent(M3.this,Medium.class);
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
