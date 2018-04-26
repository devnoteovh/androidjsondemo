package com.example.luke.asynctaskdemo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



public class MainActivity extends AppCompatActivity {
    Button btn;
    private ProgressBar progressBar;
    TextView txt;
    Integer count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setMax(10);
        btn = (Button) findViewById(R.id.btn);
        btn.setText("Start");
        txt = (TextView) findViewById(R.id.output);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 1;
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setProgress(0);
                switch (v.getId()){
                    case R.id.btn:
                        new MyTask().execute(10);
                        break;
                }
            }
        };
        btn.setOnClickListener(listener);
    }

    class MyTask extends AsyncTask<Integer,Integer,String> {

        StringBuilder result;
        protected String doInBackground(Integer... params) {


             result = new StringBuilder();

            for (; count <= params[0]; count++) {
                try {
                    Thread.sleep(400);
                    publishProgress(count);

                    //result.append(JsonTaker.getPersonById(count));
                    result.append(JsonToJavaObject.getPersonById(count));
                    result.append("\n");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }



            }
            try {
                sendPost();
                delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result.toString();
        }
            protected void onPostExecute (String result){
                progressBar.setVisibility(View.GONE);
                txt.setText(result);
                btn.setText("Restart");
            }
            protected void onPreExecute () {
                txt.setText("Task Starting...");
            }
            protected void onProgressUpdate (Integer...values){
                txt.setText("Running.." + /*values[0]*/ result.toString() );
                progressBar.setProgress(values[0]);
            }


        }


    private void sendPost() throws Exception {

        String url = "http://xxx:3000/persons";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();


        con.setRequestMethod("POST");

        String urlParameters = "id=umcsdeletetest&first_name=testowy&last_name=testowy";


        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        Log.i("SENDING","\nSending 'POST' request to URL : " + url);
        Log.i("SENDING","Post parameters : " + urlParameters);
        Log.i("SENDING","Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        Log.i("WYNIK POST ",response.toString());
        con.disconnect();
    }

    private void delete() throws Exception {

        String url = "http://xxx:3000/persons/umcsdeletetest";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("DELETE");
        int responseCode = con.getResponseCode();
        Log.i("DELETE","\nSending 'DELETE' request to URL : " + url);
        Log.i("DELETE","Response Code : " + responseCode);
        con.disconnect();

    }
}

