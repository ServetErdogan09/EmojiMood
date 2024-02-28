package com.serveterdogan.catchthekanny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.serveterdogan.catchthekanny.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.serveterdogan.catchthekanny.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }
/*
    public void change (View view){

        // Yes
        if (view.getId() == R.id.button){

            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);
        }
    }

 */
}