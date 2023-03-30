package co.edu.unipiloto.rapicoop2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrarSignos extends AppCompatActivity {
    EditText glucosa, hipertension, incardiaca, temperatura, sintomas, actividadFisica, medicamentos;
    Button registrarSignos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar_signos);
        glucosa = (EditText) findViewById(R.id.glucosa2);
        hipertension = (EditText) findViewById(R.id.hipertension2);
        incardiaca = (EditText) findViewById(R.id.incardiaca2);
        registrarSignos = (Button) findViewById(R.id.button_registrar_signos);


    }

    public void button_registrar_signos(View view) {


    }
}
