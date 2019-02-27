package com.example.umair.project_j;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class All_Accounts extends AppCompatActivity {

    private Button facebook,twitter,insta;
    private String facebook_package = "com.facebook.katana";
    private String twitter_package = "com.twitter.android";
    private String insta_package = "com.instagram.android";
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all__accounts);


        facebook = findViewById(R.id.facebook_btn);
        twitter = findViewById(R.id.twitter_btn);
        insta = findViewById(R.id.insta_btn);

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = getPackageManager().getLaunchIntentForPackage(facebook_package);
                if (sharingIntent != null) {
                    Uri screenshotUri = Uri.parse("android. resource://com.example.umair.project_j/*");

                    try {
                        InputStream stream = getContentResolver().openInputStream(screenshotUri);
                    } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    sharingIntent.setAction(Intent.ACTION_SEND);
                    sharingIntent.setPackage(facebook_package);
                    sharingIntent.setType("text/plain");

                    sharingIntent.putExtra(Intent.EXTRA_STREAM, screenshotUri);
                    startActivity(sharingIntent);
                } else {
                    Toast.makeText(All_Accounts.this, "Please Install Facebook First!", Toast.LENGTH_LONG).show();
                }
            }
        });

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sharingIntent = getPackageManager().getLaunchIntentForPackage(twitter_package);
                if (sharingIntent != null) {
                    Uri screenshotUri = Uri.parse("android. resource://com.example.umair.project_j/*");

                    try {
                        InputStream stream = getContentResolver().openInputStream(screenshotUri);
                    } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    sharingIntent.setAction(Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    sharingIntent.setPackage(twitter_package);
                    sharingIntent.putExtra(Intent.EXTRA_STREAM, screenshotUri);
                    startActivity(sharingIntent);
                } else {
                    Toast.makeText(All_Accounts.this, "Please Install Twitter First!", Toast.LENGTH_LONG).show();
                }

            }
        });

        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sharingIntent = getPackageManager().getLaunchIntentForPackage(insta_package);
                if (sharingIntent != null) {
                    Uri screenshotUri = Uri.parse("android. resource://com.example.umair.project_j/*");

                    try {
                        InputStream stream = getContentResolver().openInputStream(screenshotUri);
                    } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    sharingIntent.setAction(Intent.ACTION_SEND);
                    sharingIntent.setType("image/*");
                    sharingIntent.setPackage(insta_package);
                    sharingIntent.putExtra(Intent.EXTRA_STREAM, screenshotUri);
                    startActivity(sharingIntent);
                } else {
                    Toast.makeText(All_Accounts.this, "Please Install Instagram First!", Toast.LENGTH_LONG).show();
                }
            }

        });
    }

}

