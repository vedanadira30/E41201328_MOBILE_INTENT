package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//Mendeklarasikan variabel
        nama = findViewById(R.id.username);
    }

    //melakukan pengiriman data variabel yang diinputkan pada activity lain
    public void omIndexSendButtonClicked(View v){

        //Fungsi Perpindahan Halaman
        Intent intent = new Intent(this, HomeActivity.class);
        EditText editText = (EditText) findViewById(R.id.username);
        String index = editText.getText().toString();

        //Fungsi mengirimkan data
        intent.putExtra("HomeIndex", index);
        intent.putExtra("nama" , nama.getText().toString());
        startActivity(intent);
    }
}