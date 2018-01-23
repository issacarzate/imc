package com.example.issac.bmi;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultadosActivity extends Activity {
    private TextView nombre, imc, ideal, energy, imc2,ideal2,energy2;
    private ImageView imageView;
    private Persona p;

    private final int REQUEST_CODE = 7007;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        nombre = (TextView) findViewById(R.id.nombre);
        imc = (TextView) findViewById(R.id.imc);
        ideal = (TextView) findViewById(R.id.pesoIdeal);
        energy = (TextView) findViewById(R.id.energia);
        imageView = (ImageView) findViewById(R.id.imagen);

        p = (Persona) getIntent().getSerializableExtra("persona");

        double imcDouble = p.peso / Math.pow(p.altura, 2.0);
        double idealDouble = Math.pow(p.altura, 2.0) * 22;
        double energiaDouble = idealDouble * 30;

        nombre.setText(p.nombre);

        imc.setText(String.valueOf(imcDouble));
        ideal.setText(String.valueOf(idealDouble));
        energy.setText(String.valueOf(energiaDouble));

        if(p.sexo.equalsIgnoreCase("mujer")){
            if(imcDouble<=17.5 && imcDouble<18.5){
                imageView.setImageResource(R.drawable.woman_bmi_17_5);
            }
            if(imcDouble>=18.5 && imcDouble<22.0){
                imageView.setImageResource(R.drawable.woman_bmi_18_5);
            }
            if(imcDouble>=22.0 && imcDouble<24.9){
                imageView.setImageResource(R.drawable.woman_bmi_22);
            }
            if(imcDouble>=24.9 && imcDouble<30.0){
                imageView.setImageResource(R.drawable.woman_bmi_24_9);
            }
            if(imcDouble>=30.0 && imcDouble<40.0){
                imageView.setImageResource(R.drawable.woman_bmi_30);
            }
            if(imcDouble>=40.0){
                imageView.setImageResource(R.drawable.woman_bmi_40);
            }
        }
        if(p.sexo.equalsIgnoreCase("hombre")){
            if(imcDouble<=17.5 && imcDouble<18.5){
                imageView.setImageResource(R.drawable.men_bmi_17_5);
            }
            if(imcDouble>=18.5 && imcDouble<22.0){
                imageView.setImageResource(R.drawable.men_bmi_18_5);
            }
            if(imcDouble>=22.0 && imcDouble<24.9){
                imageView.setImageResource(R.drawable.men_bmi_22_0);
            }
            if(imcDouble>=24.9 && imcDouble<30.0){
                imageView.setImageResource(R.drawable.men_bmi_24_9);
            }
            if(imcDouble>=30.0 && imcDouble<40.0){
                imageView.setImageResource(R.drawable.men_bmi_30);
            }
            if(imcDouble>=40.0){
                imageView.setImageResource(R.drawable.men_bmi_40);
            }
        }
    }
    public void imc(View view){
        Intent intent = new Intent(ResultadosActivity.this,BMI.class);
        startActivity(intent);
    }
    public void recalculate(View view){
        Intent intent = new Intent(this, DatosNuevos.class);
        startActivityForResult(intent, REQUEST_CODE);
    }
    public void openBMI(View view){
        String url = "https://es.wikipedia.org/wiki/%C3%8Dndice_de_masa_corporal";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
    public void compartir(View view){
        Intent textShareIntent = new Intent(Intent.ACTION_SEND);
        textShareIntent.putExtra(Intent.EXTRA_SUBJECT, "Mensaje");
        textShareIntent.putExtra(Intent.EXTRA_TEXT, "Mi IMC es: " + imc.getText().toString());
        textShareIntent.setType("text/plain");
        startActivity(Intent.createChooser(textShareIntent, "Share text with..."));
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_OK && requestCode == REQUEST_CODE){
            if(data.hasExtra("persona")){
                Persona nueva = (Persona) data.getSerializableExtra("persona");

                double imcDouble = nueva.peso / Math.pow(nueva.altura, 2.0);
                double idealDouble = Math.pow(nueva.altura, 2.0) * 22;
                double energiaDouble = idealDouble * 30;

                imc.setText(String.valueOf(imcDouble));
                ideal.setText(String.valueOf(idealDouble));
                energy.setText(String.valueOf(energiaDouble));


                if(p.sexo.equalsIgnoreCase("mujer")){
                    if(imcDouble<=17.5 && imcDouble<18.5){
                        imageView.setImageResource(R.drawable.woman_bmi_17_5);
                    }
                    if(imcDouble>=18.5 && imcDouble<22.0){
                        imageView.setImageResource(R.drawable.woman_bmi_18_5);
                    }
                    if(imcDouble>=22.0 && imcDouble<24.9){
                        imageView.setImageResource(R.drawable.woman_bmi_22);
                    }
                    if(imcDouble>=24.9 && imcDouble<30.0){
                        imageView.setImageResource(R.drawable.woman_bmi_24_9);
                    }
                    if(imcDouble>=30.0 && imcDouble<40.0){
                        imageView.setImageResource(R.drawable.woman_bmi_30);
                    }
                    if(imcDouble>=40.0){
                        imageView.setImageResource(R.drawable.woman_bmi_40);
                    }
                }
                if(p.sexo.equalsIgnoreCase("hombre")){
                    if(imcDouble<=17.5 && imcDouble<18.5){
                        imageView.setImageResource(R.drawable.men_bmi_17_5);
                    }
                    if(imcDouble>=18.5 && imcDouble<22.0){
                        imageView.setImageResource(R.drawable.men_bmi_18_5);
                    }
                    if(imcDouble>=22.0 && imcDouble<24.9){
                        imageView.setImageResource(R.drawable.men_bmi_22_0);
                    }
                    if(imcDouble>=24.9 && imcDouble<30.0){
                        imageView.setImageResource(R.drawable.men_bmi_24_9);
                    }
                    if(imcDouble>=30.0 && imcDouble<40.0){
                        imageView.setImageResource(R.drawable.men_bmi_30);
                    }
                    if(imcDouble>=40.0){
                        imageView.setImageResource(R.drawable.men_bmi_40);
                    }
                }
            }
        }
    }
}
