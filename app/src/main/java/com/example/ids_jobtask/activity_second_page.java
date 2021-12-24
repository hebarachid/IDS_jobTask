package com.example.ids_jobtask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class activity_second_page extends AppCompatActivity {


    private static String apiURL;
    String id;
    List<page2GalleryInformation> gallery2List;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                id= null;
            } else {
                id=extras.getString("idOftheGallery");
            }
        } else {
            id= (String) savedInstanceState.getSerializable("idOftheGallery");
        }
        apiURL="http://www.idsdemo.me/champsservice/GeneralServices.asmx/GetGalleryPictures?albumId="+id+"&start=0&end=10";
        Log.i("api",apiURL);
        gallery2List=new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerView2);
        Log.i("hey","I am here");
        GetData getData=new GetData();
        getData.execute();
        recyclerView.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener());
    }
    public class GetData extends AsyncTask<String,String,String> {

        @Override
        protected String doInBackground(String... strings) {
            String current="";
            try{
                URL url;
                HttpURLConnection urlConnection=null;
                try{
                    url=new URL(apiURL);
                    urlConnection=(HttpURLConnection) url.openConnection();

                    InputStream is=urlConnection.getInputStream();
                    InputStreamReader isr=new InputStreamReader(is);

                    int data= isr.read();
                    while (data!=-1){
                        current+=(char)data;
                        data=isr.read();
                        Log.i("cur",data+"");
                    }

                    return current;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(urlConnection!=null){
                        urlConnection.disconnect();
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            return current;
        }
        /*

         */
        @Override
        protected void onPostExecute(String s) {
            try{

                JSONObject jsonObject=new JSONObject(s);
                JSONArray jsonArray=jsonObject.getJSONArray("Items");
                Log.i("he",jsonArray.length()+"");
                for(int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject1=jsonArray.getJSONObject(i);

                    page2GalleryInformation model=new page2GalleryInformation();
                    model.setCaption(jsonObject1.getString("Caption"));
                    model.setCroppedImage320x308(jsonObject1.getString("FilePath"));

                    gallery2List.add(model);
                    Log.i("h",gallery2List.toString());
                }

            }catch (JSONException e){
                e.printStackTrace();
            }
            putDataIntoRecyclerView( gallery2List);
        }
    }

    private void putDataIntoRecyclerView(List<page2GalleryInformation> gallery2List){
        secondAdapter secondAdapter=new secondAdapter(this,gallery2List);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(secondAdapter);
    }
}