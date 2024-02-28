package com.serveterdogan.catchthekanny;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.serveterdogan.catchthekanny.databinding.ActivityMain2Binding;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {


    /*
    TextView getscoreText;
    TextView gettimeText;

    Image image;

    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    ImageView image5;
    ImageView image6;
    ImageView image7;
    ImageView image8;
    ImageView image9;

     */

    int score = 0;
    ImageView [] imageArray;
    Handler handler;
    Runnable runnable;
    Random random = new Random();

    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        initializeViews();
        appearance();

        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long l) {

                binding.TimeText.setText("Time : " + l / 1000);
            }

            @Override
            public void onFinish() {

                handler.removeCallbacks(runnable);
                binding.TimeText.setText("Time off");

                AlertDialog.Builder alert  = new AlertDialog.Builder(MainActivity2.this);

                alert.setTitle("Reset ?");
                alert.setMessage("Do you want to try again?");

                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        // Resat
                        Intent inten = getIntent();
                        finish();
                        startActivity(inten);

                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity2.this,"Game over",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                        startActivity(intent);
                    }
                });
                alert.show();
            }

        }.start();

    }

    // point = +1;
    public void sadFace(View view){

        score++;
        binding.ScoreText.setText("Score : " + score);

    }


    // point = -1;

    public void angryFace(View view){

        score--;
        binding.ScoreText.setText("Score : " + score);

    }

    public void appearance(){

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {

                for (ImageView imageView : imageArray){
                    imageView.setVisibility(View.INVISIBLE);
                }

                int i = random.nextInt(9); // 0 - 8
                imageArray[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this,500); //
            }
        };

        handler.post(runnable);
    }
    private void initializeViews() {
        imageArray = new ImageView[]{
                binding.imageView1,
                binding.imageView2,
                binding.imageView3,
                binding.imageView4,
                binding.imageView5,
                binding.imageView6,
                binding.imageView7,
                binding.imageView8,
                binding.imageView9,
        };
    }


}