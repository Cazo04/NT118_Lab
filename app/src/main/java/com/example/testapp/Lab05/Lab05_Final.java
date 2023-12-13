package com.example.testapp.Lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.testapp.R;

public class Lab05_Final extends AppCompatActivity {
    private DownloadFileTask downloadTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab05_final);

        Button downloadButton = findViewById(R.id.downloadButton);
        Button pauseButton = findViewById(R.id.pauseButton);
        TextView textView = findViewById(R.id.tvStatus);
        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadTask = new DownloadFileTask(Lab05_Final.this, textView);
                downloadTask.execute("https://s3.cazo-dev.net/Download1/Hypnotized.mp3");
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (downloadTask != null) {
                    downloadTask.pauseAudio();
                }
            }
        });
    }
}