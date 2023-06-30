package com.example.fitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class secondactivity2 extends AppCompatActivity {
    int[] newArray;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity2);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        newArray=new int[]{
                R.id.boatpose,
                R.id.boatpose2,
                R.id.boatpose3,
                R.id.boatpose4,
                R.id.boatpose5,
                R.id.boatpose6,
                R.id.boatpose10,
                R.id.boatpose11,
                R.id.boatpose12,
                R.id.boatpose13,
                R.id.boatpose14,
                R.id.boatpose15,




        };

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        if(id==R.id.privacy){
            return true;

        }if(id==R.id.share){
            return true;

        }
        if(id==R.id.term){
            return true;

        }
        if(id==R.id.rate){
            return true;

        }

        if(id==R.id.more){
            return true;

        }
        return  true;
    }


    public void Imagebuttononclick(View view) {
        for (int i=0;i<newArray.length;i++){
            if (view.getId() == newArray[i]){
                int value=i+1;
                Log.i("FIRST",String.valueOf(value));
                Intent intent=new Intent(secondactivity2.this,thirdactivity2.class);
                intent.putExtra("value",String.valueOf(value));
                startActivity(intent);


            }
        }
    }
}