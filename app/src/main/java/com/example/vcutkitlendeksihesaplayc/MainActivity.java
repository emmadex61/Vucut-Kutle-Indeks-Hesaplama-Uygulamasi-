package com.example.vcutkitlendeksihesaplayc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    EditText boy;
    EditText kilo;
    TextView sonuc;
    Button durum;
    ToggleButton cinsiyet;
    public boolean KadinErkek;
    public double idealKilo, yagsizAgirlik, yuzeyAlani;
    NumberFormat nf = NumberFormat.getNumberInstance();
    String durumDeger;
    Double vki;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nf.setMaximumFractionDigits(2);
        boy = (EditText) findViewById(R.id.boy);
        kilo= (EditText)findViewById(R.id.kilo);
        sonuc = (TextView) findViewById(R.id.sonuc);
        durum = (Button) findViewById(R.id.durum);
        cinsiyet = (ToggleButton) findViewById(R.id.KadinErkekButon);
        durum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gecis2();
            }
        });

    }

    public void hesapla(View view) {
        double kiloDeger = Double.parseDouble(kilo.getText().toString());
        double boyDeger = Double.parseDouble(boy.getText().toString()) / 100;
        vki = kiloDeger / (boyDeger * boyDeger);

        yuzeyAlani = 0.20247 * boyDeger  * 0.725 * kiloDeger * 0.425;


        KadinErkek = cinsiyet.isChecked();
        if (KadinErkek)
        {
            idealKilo= 45 + 2.3 * ((boyDeger * 100 / 2.54)-60);
            yagsizAgirlik = (1.07 * kiloDeger) - 148*((kiloDeger * kiloDeger) /  ((100 * boyDeger ) * (100 * boyDeger ))  );

        }
        else
        {
            idealKilo  = 50 + (2.3 * ((boyDeger * 100/2.54) - 60));
            yagsizAgirlik  = (1.10 * kiloDeger) - 128*((kiloDeger * kiloDeger) /  ((100 * boyDeger ) * (100 * boyDeger ))  );
        }


        if (vki < 16)
          durumDeger = "Zayıf (Aşırı Düzeyde Zayıflık)";
      else if ( vki > 16 && vki < 17)
          durumDeger = "Zayıf (Orta Düzeyde Zayıflık)";
      else if (vki > 17 && vki < 18.50 )
          durumDeger = "Zayıf (Hafif Düzeyde Zayıflık)";

      else if (vki > 18.50 && vki < 25)
          durumDeger = "Normal";
      else if (vki > 25 && vki < 30)
          durumDeger = "Şişmanlık Öncesi (Pre-obez)";
      else if (vki > 30 && vki < 35)
          durumDeger = "Şişman I.Derece";
      else if (vki > 35 && vki < 40)
          durumDeger = "Şişman II.Derece";
      else if (vki > 40)
          durumDeger = "Şişman III.Derece";



      String vkiDeger = nf.format(vki);

      sonuc.setText(vkiDeger);
      durum.setText(durumDeger);

    }

    public void gecis2() {
        Intent intent = new Intent(this, SonucActivity.class);
        String ideal = nf.format(idealKilo);
        String yagsiz = nf.format(yagsizAgirlik);
        String vkiDeger = nf.format(vki);
        String yuzey = nf.format(yuzeyAlani);
        intent.putExtra("vkiDeger",vkiDeger);
        intent.putExtra("yuzey",yuzey);
        intent.putExtra("ideal", ideal);
        intent.putExtra("yagsiz",yagsiz);
        intent.putExtra("durum",durumDeger);
        startActivity(intent);
    }
}