package com.example.ids_jobtask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

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

public class firstPageActivity extends AppCompatActivity {
private static String apiURL="http://www.idsdemo.me/champsservice/GeneralServices.asmx/GetGallery?categoryId=1";

List<page1GalleryInformation> galleryList;
RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        galleryList=new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerView);
     Log.i("hey","I am here");
        GetData getData=new GetData();
        getData.execute();
       recyclerView.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener());
    }
    public class GetData extends AsyncTask<String,String,String>{

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
                    JSONArray jsonArray2=jsonObject1.getJSONArray("Pictures");
                    JSONObject jsonObject2=jsonArray2.getJSONObject(0);
                    page1GalleryInformation model=new page1GalleryInformation();
                    model.setName(jsonObject1.getString("Name"));
                    model.setCroppedImage320x308(jsonObject2.getString("CroppedImage320x308"));

                    galleryList.add(model);
                    Log.i("h",galleryList.toString());
                }

            }catch (JSONException e){
                e.printStackTrace();
            }
            putDataIntoRecyclerView( galleryList);
        }
    }

    private void putDataIntoRecyclerView(List<page1GalleryInformation> galleryList){
        firstAdapter firstAdapter=new firstAdapter(this,galleryList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(firstAdapter);
    }

}