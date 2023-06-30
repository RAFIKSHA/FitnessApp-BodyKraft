package com.example.fitnessapp;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class thirdactivity2 extends AppCompatActivity {
    String buttonvalue;
    Button startbtn;

    private CountDownTimer countDownTimer;
    TextView mtextview;
    private boolean mtimerunning;
    private  long ltimerunning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdactivity2);



        Intent intent=getIntent();
        buttonvalue= intent.getStringExtra("value");
        int intvalue=Integer.parseInt(buttonvalue);
        switch (intvalue){
            case 1:
                setContentView(R.layout.activity_bow21);
                break;
            case 2:
                setContentView(R.layout.activity_bow22);
                break;
            case 3:
                setContentView(R.layout.activity_bow23);
                break;
            case 4:
                setContentView(R.layout.activity_bow24);
                break;
            case 5:
                setContentView(R.layout.activity_bow25);
                break;
            case 6:
                setContentView(R.layout.activity_bow26);
                break;
            case 7:
                setContentView(R.layout.activity_bow27);
                break;
            case 8:
                setContentView(R.layout.activity_bow28);
                break;
            case 9:
                setContentView(R.layout.activity_bow29);
                break;
            case 10:
                setContentView(R.layout.activity_bow30);
                break;
            case 11:
                setContentView(R.layout.activity_bow31);
                break;
            case 12:
                setContentView(R.layout.activity_bow32);
                break;
        }

        startbtn=findViewById(R.id.startbutton);
        mtextview=findViewById(R.id.time);

        startbtn.setOnClickListener(view -> {
            if(mtimerunning){
                stoptimer();
            }
            else{
                starttimer();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void stoptimer(){
        countDownTimer.cancel();
        mtimerunning=false;
        startbtn.setText("START");
    }

    @SuppressLint("SetTextI18n")
    private  void starttimer(){
        final CharSequence values1=mtextview.getText();
        String num1=values1.toString();
        String num2=num1.substring(0,2);
        String num3=num1.substring(3,5);
        final int number=Integer.parseInt(num2)*60 +Integer.parseInt(num3);
        ltimerunning=number* 1000L;

        countDownTimer=new CountDownTimer(ltimerunning,1000) {
            @Override
            public void onTick(long l) {
                ltimerunning=l;
                updateTimer();

            }

            private void updateTimer() {
                int minutes=(int) ltimerunning/60000;
                int seconds=(int) ltimerunning%60000/1000;

                String timelefttext;
                timelefttext="0";
                timelefttext=timelefttext+minutes+":";
                if(seconds<10)
                    timelefttext="0";
                timelefttext+=seconds;
                mtextview.setText(timelefttext);
            }

            @Override
            public void onFinish() {
                int newvalue=Integer.parseInt(buttonvalue)+1;
                if(newvalue<=7){
                    Intent intent=new Intent(thirdactivity2.this,thirdactivity2.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newvalue));
                    startActivity(intent);
                }
                else {

                    newvalue=1;
                    Intent intent=new Intent(thirdactivity2.this,thirdactivity2.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newvalue));
                    startActivity(intent);
                }
            }

        }.start();
        startbtn.setText("Pause");
        mtimerunning=true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}