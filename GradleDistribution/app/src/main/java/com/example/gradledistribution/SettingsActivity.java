package com.example.gradledistribution;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {

    Button buttonImageOne, buttonImageTwo, buttonImageThree, goBackMainActivity;
    ConstraintLayout settingsLayout;
    String imageState;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        buttonImageOne = findViewById(R.id.buttonImageOne);
        buttonImageTwo = findViewById(R.id.buttonImageTwo);
        buttonImageThree = findViewById(R.id.buttonImageThree);
        goBackMainActivity = findViewById(R.id.goBackMainActivity);
        settingsLayout = findViewById(R.id.settingsLayout);

        sharedPreferences = getSharedPreferences("background", Context.MODE_PRIVATE);
        String currentBackgroundColor = sharedPreferences.getString("imageState","WHITE");
        if (currentBackgroundColor.equals("image1"))
        {
            settingsLayout.setBackgroundResource(R.drawable.image_one);
        }
        else if (currentBackgroundColor.equals("image2"))
        {
            settingsLayout.setBackgroundResource(R.drawable.image_two);
        }
        else if (currentBackgroundColor.equals("image3"))
        {
            settingsLayout.setBackgroundResource(R.drawable.image_three);
        }
        else if (currentBackgroundColor.equals("WHITE"))
        {
            settingsLayout.setBackgroundColor(Color.WHITE);
        }

        goBackMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharedPreferences = getSharedPreferences("background", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("imageState",imageState);
                editor.apply();

                Intent intent = new Intent(SettingsActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        buttonImageOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                settingsLayout.setBackgroundResource(R.drawable.image_one);
                imageState = "image1";

            }
        });
        buttonImageTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                settingsLayout.setBackgroundResource(R.drawable.image_two);
                imageState = "image2";

            }
        });
        buttonImageThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                settingsLayout.setBackgroundResource(R.drawable.image_three);
                imageState = "image3";

            }
        });

    }
}