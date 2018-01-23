package com.example.issac.bmi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class DatosNuevos extends Activity {

    private EditText peso2, altura2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_nuevos);
        peso2 = (EditText) findViewById(R.id.peso2);
        altura2 = (EditText) findViewById(R.id.altura2);
    }
    public void calcula(View view){
        Persona per = new Persona();
        String pesoStr = peso2.getText().toString();
        String alturaStr = altura2.getText().toString();
        if(TextUtils.isEmpty(pesoStr)){
            peso2.setError("Captura un dato!");
            return;
        }
        if(TextUtils.isEmpty(alturaStr)){
            altura2.setError("Captura un dato!");
            return;
        }
        per.peso = Double.parseDouble(pesoStr);
        per.altura = Double.parseDouble(alturaStr);

        Intent intent = new Intent(DatosNuevos.this,ResultadosActivity.class);
        intent.putExtra("persona", per);
        setResult(RESULT_OK, intent);
        super.finish();
    }
}
