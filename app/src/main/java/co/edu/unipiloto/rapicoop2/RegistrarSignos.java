package co.edu.unipiloto.rapicoop2;

import static co.edu.unipiloto.rapicoop2.RapiCoopDatabaseHelper.COL1;
import static co.edu.unipiloto.rapicoop2.RapiCoopDatabaseHelper.COL10;
import static co.edu.unipiloto.rapicoop2.RapiCoopDatabaseHelper.COL11;
import static co.edu.unipiloto.rapicoop2.RapiCoopDatabaseHelper.COL12;
import static co.edu.unipiloto.rapicoop2.RapiCoopDatabaseHelper.COL13;
import static co.edu.unipiloto.rapicoop2.RapiCoopDatabaseHelper.COL14;
import static co.edu.unipiloto.rapicoop2.RapiCoopDatabaseHelper.COL15;
import static co.edu.unipiloto.rapicoop2.RapiCoopDatabaseHelper.COL16;
import static co.edu.unipiloto.rapicoop2.RapiCoopDatabaseHelper.COL2;
import static co.edu.unipiloto.rapicoop2.RapiCoopDatabaseHelper.TABLE_NAME;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class RegistrarSignos extends AppCompatActivity {


    private RapiCoopDatabaseHelper myDbs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar_signos);
        myDbs = new RapiCoopDatabaseHelper(RegistrarSignos.this);
        SQLiteDatabase db = myDbs.getReadableDatabase();
        Intent intent = getIntent();
        int valorRecibido = intent.getIntExtra("idUser", 0);
        TextInputLayout glucosaLayout = findViewById(R.id.glucosa1);
        EditText editGlucosa = glucosaLayout.getEditText();

        TextInputLayout hiperLayout = findViewById(R.id.hipertension1);
        EditText editHiper = hiperLayout.getEditText();

        TextInputLayout  frecuenciaLayout= findViewById(R.id.incardiaca1);
        EditText  editFrecuencia= frecuenciaLayout.getEditText();

        TextInputLayout temperaturaLayout = findViewById(R.id.temperatura1);
        EditText editTemperatura = temperaturaLayout.getEditText();

        TextInputLayout sintomasLayout = findViewById(R.id.sintomas1);
        EditText editSintomas = sintomasLayout.getEditText();

        TextInputLayout actividadLayout = findViewById(R.id.actividad_fisica1);
        EditText editActividad = actividadLayout.getEditText();

        TextInputLayout medicamentosLayout = findViewById(R.id.medicamentos1);
        EditText editMedicamentos = medicamentosLayout.getEditText();

        Button signosButton = (Button) findViewById(R.id.button_registrar_signos);

        signosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = db.rawQuery("SELECT * FROM Registros_RapiCoop", null);;
                String glucosa = editGlucosa.getText().toString();
                String hipertension= editHiper.getText().toString();
                String frecuenciaCardiaca = editFrecuencia.getText().toString();
                String temperatura = editTemperatura.getText().toString();
                String sintomas = editSintomas.getText().toString();
                String actividadFisica = editActividad.getText().toString();
                String medicamentos = editMedicamentos.getText().toString();
                ContentValues values = new ContentValues();
                values.put(COL10,glucosa );
                values.put(COL11, hipertension);
                values.put(COL12, frecuenciaCardiaca);
                values.put(COL13, temperatura);
                values.put(COL14, sintomas);
                values.put(COL15, actividadFisica);
                values.put(COL16, medicamentos);
                String f= valorRecibido+"";
                String selection = COL1 + " = ?";
                String[] selectionArgs = { f };

                db.update(
                        TABLE_NAME,
                        values,
                        selection,
                        selectionArgs
                );






            }
        });

    }

    public void button_registrar_signos(View view) {


    }
}
