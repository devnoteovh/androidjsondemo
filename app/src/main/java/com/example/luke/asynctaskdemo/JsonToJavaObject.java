package com.example.luke.asynctaskdemo;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class JsonToJavaObject {

    public static Person getPersonById(int count) {
        HttpURLConnection urlConnection = null;
        StringBuilder result = new StringBuilder();

        try {
            URL url = new URL("http://xxx:3000/persons?id=" + count);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            urlConnection.disconnect();


        }
        JSONArray ja = null;
        Person person = null;
        try {
            ja = new JSONArray(result.toString());
            String pid = ( (JSONObject)ja.get(0)).getString("id");
            String fn = ( (JSONObject)ja.get(0)).getString("first_name");

            person = Person.builder()
                    .id(pid)
                    .first_name(fn)
                    .build();

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return  person;

    }



}
