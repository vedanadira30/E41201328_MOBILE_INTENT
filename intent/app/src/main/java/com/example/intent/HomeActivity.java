package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

//Mendeklarasikan Variabel

public class HomeActivity extends AppCompatActivity {
    private static final String TAG="MainActivity";
    private EditText nomorTelp;
    private EditText alamat;
    private Button kirimsms;
    private Button carialamat;

//Untuk menerima data pada activity lain (Intent Explicit)

    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//Menerima variabel nama dari MainActivity meggunakan getIntent

        String nama = getIntent().getExtras().getString("nama");

        result = findViewById(R.id.txt_result);
        result.setText("Hi, " +nama);
    }

    //Membuat fungsi untuk Implicit Intent pada aplikasi SMS

    public void smsSend (View view){
        nomorTelp = (EditText) findViewById(R.id.no_telp);
        String no = String.format("smsto: %s", nomorTelp.getText().toString());
        //Pesan Otomatis
        String sms = "Halo !";
        Intent Ikirimsms = new Intent(Intent.ACTION_SENDTO);
        Ikirimsms.setData(Uri.parse(no));
        Ikirimsms.putExtra("sms_body", sms);
        if (Ikirimsms.resolveActivity(getPackageManager()) != null){
            startActivity(Ikirimsms);
        }else{
            Log.d(TAG, no);
        }
    }

    //Membuat Implicit Intent untuk memindahkan halaman pencarian pada aplikasi MAP
    public void carimap(View view){
        alamat = (EditText) findViewById(R.id.alamat);
        String addr = String.format("geo: 0, 0?q= %s", alamat.getText().toString());
        Uri add = Uri.parse(addr);
        Intent ceklokasi = new Intent(Intent.ACTION_VIEW, add);
        ceklokasi.setPackage("com.google.android.apps.maps");
        if (ceklokasi.resolveActivity(getPackageManager()) != null){
            startActivity(ceklokasi);
        }else{
            Log.d(TAG, addr);
        }
    }
}