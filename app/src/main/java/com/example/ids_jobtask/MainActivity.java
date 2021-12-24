package com.example.ids_jobtask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void toFirstGallery(View view) {
        Intent intent = new Intent(getApplicationContext(), firstPageActivity.class);
        startActivity(intent);
    }

    public void page2(View view) {
        Intent intent = new Intent(getApplicationContext(), activity_second_page.class);
        startActivity(intent);
    }
}