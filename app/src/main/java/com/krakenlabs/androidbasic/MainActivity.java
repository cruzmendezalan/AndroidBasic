package com.krakenlabs.androidbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.krakenlabs.androidbasic.controllers.Controller;

public class MainActivity extends AppCompatActivity {

    private Controller controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        controller = new Controller(getApplicationContext());
        controller.login("h53@h.com","0987654321");
        controller.search();

    }
}
