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

public class D2 extends AppCompatActivity {
    TextView t1,t2,t3;
    Button b1,b2;
    EditText e1;
    int ctr=0;
    int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d2);
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
                    if(w.charAt(i)=='z' || w.charAt(i)=='o' || w.charAt(i)=='m' || w.charAt(i)=='b' || w.charAt(i)=='i' || w.charAt(i)=='e')
                        count=count+1;
                if(w.equals("zombie") && count==6)
                {
                    score=score+100;
                    LocalDB.getInstance().insertToSimpleScore(12,score);
                    LocalDB.getInstance().updateSimpleScoreStatus(12,score);
                    LocalDB.getInstance().updateSimpleStatus(13,"true");
                    AlertDialog.Builder ad = new AlertDialog.Builder(D2.this);
                    ad.setTitle("You have found the Correct word !!");
                    ad
                            .setMessage("Play Next ?")
                            .setCancelable(false)
                            .setPositiveButton("Continue",new DialogInterface.OnClickListener(){
                                public void onClick(DialogInterface dialog,int id){
                                    Intent pos=new Intent(D2.this,Difficult.class);
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
