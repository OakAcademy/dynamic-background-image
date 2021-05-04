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
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button goToSettingsActivity;
    ConstraintLayout mainLayout;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goToSettingsActivity = findViewById(R.id.goToSettingsActivity);
        mainLayout = findViewById(R.id.mainLayout);

        changeBackgroundImage();

        goToSettingsActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SettingsActivity.class);
                startActivity(intent);
            }
        });

    }

    public void changeBackgroundImage()
    {
        sharedPreferences = getSharedPreferences("background", Context.MODE_PRIVATE);

        String colorState = sharedPreferences.getString("imageState","WHITE");

        if (colorState.equals("image1"))
        {
            mainLayout.setBackgroundResource(R.drawable.image_one);
        }
        else if (colorState.equals("image2"))
        {
            mainLayout.setBackgroundResource(R.drawable.image_two);
        }
        else if (colorState.equals("image3"))
        {
            mainLayout.setBackgroundResource(R.drawable.image_three);
        }
        else if (colorState.equals("WHITE"))
        {
            mainLayout.setBackgroundColor(Color.WHITE);
        }
    }
}