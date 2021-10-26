package com.thalpi.saytahminoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView txtViewKalanHak,txtViewSonuc;
    private EditText editTxtSayi;
    private String gelenDeger;
    private int kalanHak=3,randomSayi;
    private Random rndNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtViewKalanHak = (TextView)findViewById(R.id.txtViewKalanHak);
        txtViewSonuc=(TextView)findViewById(R.id.txtViewSonuc);
        editTxtSayi = (EditText)findViewById(R.id.editTxtSayi);

        rndNumber = new Random();
        randomSayi = rndNumber.nextInt(5);
        System.out.println(" Random sayı : "+randomSayi);
    }

    public void btnTahminET(View v) {
        gelenDeger = editTxtSayi.getText().toString();

        if (!TextUtils.isEmpty(gelenDeger))
        {
            if (kalanHak>0)
            {
                if (gelenDeger.equals(String.valueOf(randomSayi)))
                {
                    sonucGoster(" Tebrikler !!! Doğru Tahmin !!!");
                }
                else
                {
                    kalanHak--;
                    txtViewSonuc.setText(" Yanlış tahmin !!!");
                }
                txtViewKalanHak.setText("Kalan Hak : "+kalanHak);
                if (kalanHak==0)
                {
                    sonucGoster(" Tahmin Hakkınız Bitti !!!");
                }
            }
            else
            {
                txtViewSonuc.setText(" Oyun Bitti !!!");
            }
        }
        else
        {
            txtViewSonuc.setText(" Girilen değer boş olamaz !!!");
        }
    }

    private void sonucGoster(String mesaj) {
        editTxtSayi.setEnabled(false);
        txtViewSonuc.setText(mesaj);

    }

}