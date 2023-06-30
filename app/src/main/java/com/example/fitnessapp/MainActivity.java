package com.example.fitnessapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
  Button button1,button2;
  ImageView insta;
  ImageView youtube;
  ImageView website;
  ImageView facebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insta=findViewById(R.id.insta);
        youtube=findViewById(R.id.youtube);
        website=findViewById(R.id.website);
        facebook=findViewById(R.id.facebook);
        findViewById(R.id.mycamera);
        Button button = findViewById(R.id.takepicture);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takepictures();
            }

            private void takepictures() {
                Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,0);

            }
        });

        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl();
            }

            private void gotoUrl() {
                Uri uri= Uri.parse("https://www.instagram.com/mr_.rafik/");
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        }) ;
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl();
            }

            private void gotoUrl() {
                Uri uri= Uri.parse("https://www.facebook.com/mr_.rafik/");
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        }) ;
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl();
            }

            private void gotoUrl() {
                Uri uri= Uri.parse("https://www.youtube.com/codewithharry/");
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        }) ;
        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl();
            }

            private void gotoUrl() {
                Uri uri= Uri.parse("https://www.instagram.com/mr_.rafik/");
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        }) ;


        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        button1=findViewById(R.id.startyoga1);
        button2=findViewById(R.id.startyoga2);
        button1.setOnClickListener(view -> {
            Intent intent=new Intent(MainActivity.this,secondactivity.class);
            startActivity(intent);
        });
        button2.setOnClickListener(view -> {
            Intent intent=new Intent(MainActivity.this,secondactivity2.class);
            startActivity(intent);
        });



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

            Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://fitnessapplicationblog.blogspot.com/2022/12/privacy.html"));
            startActivity(intent);
            return true;

        }
        if(id==R.id.share){

            Intent myintent=new Intent(Intent.ACTION_SEND);
            myintent.setType("text/plain");
            String sharebody="This the best app for exercises \n by this app you streach your body \n this is free download now \n"+"https://play.goggle.com/store/app/details?id=com.example.fitnessapp&h1=en";
            String sharehub="body kraft";
            myintent.putExtra(Intent.EXTRA_SUBJECT,sharehub);
            myintent.putExtra(Intent.EXTRA_TEXT,sharebody);
            startActivity(Intent.createChooser(myintent,"share using"));
            return true;

        }
        if(id==R.id.term){
            Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://conditionandterm.blogspot.com/2022/12/terms-and-conditions-1.html"));
            startActivity(intent);
            return true;
        }
        if(id==R.id.rate){
            try {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("market://details?id="+getPackageName())));

            }catch (Exception ex){
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.goggle.com/store/app/details?id="+getPackageName())));

            }

            return true;

        }

        if(id==R.id.more){
            Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=com.home.workouts.professional"));
            startActivity(intent);
            return true;

        }
        if(id==R.id.about){
            Intent intent= new Intent(MainActivity.this,aboutactivity.class);
            startActivity(intent);

            return true;
        }
        return  true;
    }

    public void Beforeage18(View view) {
        Intent intent= new Intent(MainActivity.this,secondactivity.class);
        startActivity(intent);


    }

    public void Afterage18(View view) {
        Intent intent= new Intent(MainActivity.this,secondactivity2.class);
        startActivity(intent);
    }

    public void food(View view) {
        Intent intent= new Intent(MainActivity.this,foodactivity.class);
        startActivity(intent);
    }

}