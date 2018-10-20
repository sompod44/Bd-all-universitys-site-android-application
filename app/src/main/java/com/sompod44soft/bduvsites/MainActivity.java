package com.sompod44soft.bduvsites;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    TextView textView;
    private int progressStatus = 0;
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.ProgressbarID1);
        textView = findViewById(R.id.progressbarReading);
        new Thread(new Runnable() {
            @Override
            public void run() {
                ShowProgressBar();
                nextactivity();
            }
        }).start();
    }



    public void nextactivity() { // this method for load next login activity.
        Intent intent = new Intent(this,PublicPrivate.class);
        startActivity(intent);

    }

    public void ShowProgressBar(){ // this method for show progressBar with progressing text
        while (progressStatus < 100) {
            progressStatus += 1;
            // Update the progress bar and display the
            //current value in the text view
            handler.post(new Runnable() {
                public void run() {
                    progressBar.setProgress(progressStatus);
                    textView.setText(progressStatus+"/"+progressBar.getMax());
                }
            });
            try {
                // Sleep for 50 milliseconds.
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
