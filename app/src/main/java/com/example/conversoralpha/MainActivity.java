package com.example.conversoralpha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText edadEditText;
    EditText pesoEditText;
    Button calculeEdadButton;
    TextView edadHumanaTextView;
    DecimalFormat currency = new DecimalFormat("##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edadEditText        = findViewById(R.id.edadEditText);
        pesoEditText        = findViewById(R.id.pesoEditText);
        calculeEdadButton   = findViewById(R.id.calculeEdadButton);
        edadHumanaTextView  = findViewById(R.id.edadHumanaTextView);

    }

    public void seClickeoCalculoEdad(View view) {
        // traer valor de edad
        String edadStr  = edadEditText.getText().toString();

        // traer valor de edad
        String pesoStr  = pesoEditText.getText().toString();

        // valida que no este vacio

        if (!edadStr.isEmpty()  && !pesoStr.isEmpty()) {

            // parsear string a Entero
            float edadFloat     = Float.parseFloat(edadStr);

            // parsear string a Entero
            float pesoFloat     = Float.parseFloat(pesoStr);


            // genero numero mágico
            double numeroMagico = Double.parseDouble(getString(R.string.numeroMagico));
            numeroMagico = Math.log10(pesoFloat)*numeroMagico;
            // genero resultado
            float resultado = edadFloat * Float.parseFloat(Double.toString(numeroMagico));

            // Muestro edad Humana de perro
            edadHumanaTextView.setText(currency.format(resultado));

        }else {
            Toast.makeText(getApplicationContext(),getString(R.string.mensajeError),Toast.LENGTH_LONG).show();
        }

    }
}
