package com.example.testapp.Lab05;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.MainThread;

import com.example.testapp.R;

public class SlowTask extends AsyncTask<String, Long, Boolean> {
    private ProgressDialog pdWaiting;
    private Context context;
    private Long startTime;
    private TextView tvStatus;

    public SlowTask(Context context, TextView tvStatus) {
        this.context = context;
        this.tvStatus = tvStatus;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        // We can use UI thread here
        pdWaiting = new ProgressDialog(context);
        startTime = System.currentTimeMillis();
        tvStatus.setText("Start time: " + startTime);
        pdWaiting.setMessage(context.getString(R.string.please_wait));
        pdWaiting.show();
    }

    @Override
    protected Boolean doInBackground(String... params) {
        // Doing SLOW job
        try {
            for (Long i = 0L; i < 3L; i++) {
                Thread.sleep(2000);
                publishProgress(i);
            }
        } catch (Exception e) {
            Log.e("SlowJob", e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    protected void onProgressUpdate(Long... values) {
        super.onProgressUpdate(values);

        tvStatus.append("\nWorking..." + values[0]);
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        tvStatus.append("\nDone!");
        pdWaiting.dismiss();
    }
}

