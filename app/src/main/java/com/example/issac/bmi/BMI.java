package com.example.issac.bmi;

import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class BMI extends AppCompatActivity {
    private EditText nombre, peso, altura;
    private Spinner sexo;
    private String sexoSeleccionado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        nombre = (EditText)findViewById(R.id.nombre);
        peso = (EditText)findViewById(R.id.peso);
        altura = (EditText)findViewById(R.id.altura);
        sexo = (Spinner) findViewById(R.id.sexo);

        //final para hacerlo constante y poder acceder a el desde el contexto de abajo
        final String[] sexos = {"Mujer", "Hombre"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,sexos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sexo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sexoSeleccionado = sexos[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        sexo.setAdapter(adapter);
    }
    public void imc(View view){
        Persona persona = new Persona();
        persona.nombre = nombre.getText().toString();
        String n = nombre.getText().toString();
        String nn = altura.getText().toString();
        String nnn = peso.getText().toString();
        if(TextUtils.isEmpty(n)){
            nombre.setError("Captura un valor");
            altura.setError("Captura un valor");
            peso.setError("Captura un valor");
            return;
        }
        persona.nombre = n;
        persona.peso = Double.parseDouble(nnn);
        persona.altura =  Double.parseDouble(nn);

        persona.peso = Double.parseDouble(peso.getText().toString());
        persona.altura = Double.parseDouble(altura.getText().toString());
        persona.sexo = sexoSeleccionado;
        Intent intent = new Intent(BMI.this,ResultadosActivity.class);
        intent.putExtra("persona", persona);
        startActivity(intent);

    }
}
