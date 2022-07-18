package com.example.vcutkitlendeksihesaplayc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SonucActivity extends AppCompatActivity {
    TextView yazi;
    TextView sonuc;
    TextView ideal;
    TextView yagsiz;
    TextView yuzey;
    ImageView img;
    TextView aciklama;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);
        sonuc = (TextView) findViewById(R.id.vkiTxt);
        ideal = (TextView) findViewById(R.id.idealKilo);
        yazi = (TextView)  findViewById(R.id.yazi);
        yagsiz = (TextView) findViewById(R.id.yagsiz);
        yuzey = (TextView) findViewById(R.id.yuzeyAlani);
        img = (ImageView) findViewById(R.id.img);
        aciklama = (TextView) findViewById(R.id.sonucaGoreYazi);
        yazdir();
    }

    public void yazdir(){
        Intent intent = getIntent();
        float vkiDegeri = Float.parseFloat(intent.getStringExtra("vkiDeger"));
        yazi.setText(intent.getStringExtra("durum").toString());
        sonuc.setText(vkiDegeri + "  kg/m^2");
        ideal.setText(intent.getStringExtra("ideal").toString());
        yuzey.setText(intent.getStringExtra("yuzey").toString());
        yagsiz.setText(intent.getStringExtra("yagsiz").toString());

        if (vkiDegeri < 16){
            img.setImageResource(R.drawable.zayif);
            yazi.setBackgroundColor(Color.parseColor("#6fa8dc"));
            aciklama.setText("Boyunuza göre uygun ağırlıkta olmadığınızı, zayıf olduğunuzu gösterir. Zayıflık, bazı hastalıklar için risk oluşturan ve istenmeyen bir durumdur. Boyunuza uygun ağırlığa erişmeniz için yeterli ve dengeli beslenmeli, beslenme alışkanlıklarınızı değiştirmeye özen göstermelisiniz.");
        }
        else if (vkiDegeri > 18.50 && vkiDegeri < 25){
            img.setImageResource(R.drawable.normal);
            yazi.setBackgroundColor(Color.parseColor("#8fce00"));
            aciklama.setText("Boyunuza göre uygun ağırlıkta olduğunuzu gösterir. Yeterli ve dengeli beslenerek, düzenli fiziksel aktivite yaparak bu ağırlığınızı korumaya özen gösteriniz.");
        }
        else if (vkiDegeri > 25 && vkiDegeri < 30) {
            img.setImageResource(R.drawable.sismanlikoncesi);
            yazi.setBackgroundColor(Color.parseColor("#e69138"));
            aciklama.setText("Boyunuza göre vücut ağırlığınızın fazla olduğunu bir başka değişle şişman olduğunuzun bir göstergesidir. Şişmanlık, kalp-damar hastalıkları, diyabet, hipertansiyon v.b. kronik hastalıklar için risk faktörüdür. Bir sağlık kuruluşuna başvurarak hekim/diyetisyen kontrolünde zayıflayarak normal ağırlığa inmeniz sağlığınız açısından çok önemlidir. Lütfen, sağlık kuruluşuna başvurunuz. ");
        }
        else if (vkiDegeri > 30 ) {
            img.setImageResource(R.drawable.sisman);
            yazi.setBackgroundColor(Color.parseColor("#cc0000"));
            aciklama.setText("Boyunuza göre vücut ağırlığınızın fazla olduğunu bir başka değişle şişman olduğunuzun bir göstergesidir. Şişmanlık, kalp-damar hastalıkları, diyabet, hipertansiyon v.b. kronik hastalıklar için risk faktörüdür. Bir sağlık kuruluşuna başvurarak hekim/diyetisyen kontrolünde zayıflayarak normal ağırlığa inmeniz sağlığınız açısından çok önemlidir. Lütfen, sağlık kuruluşuna başvurunuz. ");
        }
    }
}