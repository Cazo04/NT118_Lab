package com.example.testapp.Lab05;

import android.app.ProgressDialog;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadFileTask extends AsyncTask<String, Integer, Boolean> {
    private Context context;
    private MediaPlayer mediaPlayer;
    private ProgressDialog progressDialog;
    private String mp3Path;

    private TextView tvStatus;


    public DownloadFileTask(Context context, TextView tvStatus) {
        this.context = context;
        this.tvStatus = tvStatus;
        mediaPlayer = new MediaPlayer();
        progressDialog = new ProgressDialog(context);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.setMessage("Downloading...");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected Boolean doInBackground(String... strings) {
        try {
            URL url = new URL(strings[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                return false; // Server returned HTTP error code.
            }

            // Download the file
            InputStream input = connection.getInputStream();
            mp3Path = "downloadedfile.mp3";
            FileOutputStream output = context.openFileOutput(mp3Path, Context.MODE_PRIVATE);
            int fileLength = connection.getContentLength();
            byte[] data = new byte[4096];
            int count;
            long total = 0;

            while ((count = input.read(data)) != -1) {
                total += count;
                // Publishing the progress....
                if (fileLength > 0) // Only if total length is known
                    publishProgress((int) (total * 100 / fileLength));

                output.write(data, 0, count);
            }

            output.close();
            input.close();
            return true;

        } catch (IOException e) {
            Log.e("Download", e.getMessage());
            return false; // Error in downloading.
        }
    }

    @Override
    protected void onPostExecute(Boolean success) {
        super.onPostExecute(success);
        progressDialog.dismiss();
        if (success) {
            try {
                File file = context.getFileStreamPath(mp3Path);
                String filePath = file.getAbsolutePath();
                mediaPlayer.setDataSource(filePath);
                mediaPlayer.prepare();
                mediaPlayer.start();
            } catch (IOException e) {
                Toast.makeText(context, "Error playing the audio", Toast.LENGTH_SHORT).show();
                Log.e("Playing", e.getMessage());
            }
        } else {
            Toast.makeText(context, "Download failed", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        // Cập nhật TextView với tiến trình hiện tại
        tvStatus.setText("Downloaded " + values[0] + "%");
    }
    public void pauseAudio() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }
}

