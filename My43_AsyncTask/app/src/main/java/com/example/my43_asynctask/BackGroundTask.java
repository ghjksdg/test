package com.example.my43_asynctask;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

public class BackGroundTask extends AsyncTask<Void, Integer, String> {
    private static final String TAG = "Main : BackGroundTask";

    ProgressBar progressBar;
    int value;

    public BackGroundTask(ProgressBar progressBar, int value) {
        this.progressBar = progressBar;
        this.value = value;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        value = 0;
        progressBar.setProgress(0);
    }

    @Override
    protected String doInBackground(Void... voids) {
        while (isCancelled()==false){
            value++;
            if (value>100){
                break;
            }else{
                publishProgress(value);
//                publishProgress(value,value+1);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return "100% 완료";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progressBar.setProgress(values[0]);
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        Log.d(TAG, "onPostExecute: "+ result);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        Log.d(TAG, "onCancelled: 실행취소됨");
        progressBar.setProgress(0);
    }
}
