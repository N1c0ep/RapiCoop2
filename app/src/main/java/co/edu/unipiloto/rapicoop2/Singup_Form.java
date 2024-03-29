package co.edu.unipiloto.rapicoop2;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.time.LocalDate;
import java.time.Period;


public class Singup_Form extends AppCompatActivity {

    private RapiCoopDatabaseHelper myDb;
    private TextInputLayout editFullName,editUserName, editEmail, editPassword, editLatitud, editLongitud, editDireccion, editAnoNacimiento;
    private Spinner editTipoUsuario;

    private Button btnAddData;
    private Button btnViewAll;
    private int tipo;
    private String genero;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup_form);
        getSupportActionBar().setTitle("Formulario Registro");
        myDb=new RapiCoopDatabaseHelper(this);
        editFullName=(TextInputLayout)findViewById(R.id.editText_fullname);
        editUserName=(TextInputLayout)findViewById(R.id.editText_userName);
        editEmail=(TextInputLayout)findViewById(R.id.editText_email);
        editPassword=(TextInputLayout)findViewById(R.id.editText_password);
        editTipoUsuario=(Spinner) findViewById(R.id.tipo);
        editDireccion=(TextInputLayout)findViewById(R.id.txtDireccion);
        editAnoNacimiento=(TextInputLayout) findViewById(R.id.anoNacimiento);
        btnAddData=(Button)findViewById(R.id.button_registrar);
        btnViewAll=(Button)findViewById(R.id.button_mostrar_registro);
        addData();
        viewAll();

    }
    public void addData(){
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @SuppressLint("SuspiciousIndentation")
                    @Override
                    public void onClick(View view) {
                        Integer valueInt= new Integer(tipo);
                        User user=new User();
                        user.setFullName(editFullName.getEditText().getText().toString());
                        user.setUserName(editUserName.getEditText().getText().toString());
                        user.setEmail(editEmail.getEditText().getText().toString());
                        user.setPassword(editPassword.getEditText().getText().toString());
                        user.setRol(editTipoUsuario.getItemAtPosition(editTipoUsuario.getSelectedItemPosition()).toString());
                        user.setAno_nacimiento(Integer.parseInt(String.valueOf(editAnoNacimiento.getEditText().getText())));
                        user.setGenero(genero);
                        boolean isInserted=myDb.insertData(user);
                        if(isInserted)
                            Toast.makeText( Singup_Form.this,  "Informacion registrada", Toast.LENGTH_LONG).show();
                        else
                        Toast.makeText( Singup_Form.this,  "Informacion no registrada", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public void viewAll(){
        btnViewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Cursor res=myDb.getAlldata();
                        if(res.getCount()==0){
                            showMessage( "Error", "Nothing found");
                            return;
                        }
                        StringBuffer buffer=new StringBuffer();
                        while(res.moveToNext()){
                            buffer.append("Id: "+res.getString(0)+"\n");
                            buffer.append("Nombre: "+res.getString( 1)+"\n");
                            buffer.append("Usuario: "+res.getString( 2)+"\n");
                            buffer.append("Correo: "+res.getString( 3)+"\n");
                            buffer.append("Clave: "+res.getString( 4)+"\n");
                            buffer.append("Tipo de usuario: "+res.getString( 5)+"\n");
                            buffer.append("Dirección: "+res.getString( 6)+"\n");
                            buffer.append("Año de nacimiento: "+res.getString( 7)+"\n");
                            buffer.append("Genero: "+res.getString( 8)+"\n");
                            buffer.append("Glucosa: "+res.getString( 9)+"\n");
                            buffer.append("Presión: "+res.getString( 10)+"\n");
                            buffer.append("Frecuencia: "+res.getString( 11)+"\n");
                            buffer.append("Temperatura: "+res.getString( 12)+"\n");
                            buffer.append("Sintomas: "+res.getString( 13)+"\n");
                            buffer.append("Actividad: "+res.getString( 14)+"\n");
                            buffer.append("Medicamentos: "+res.getString( 15)+"\n");




                        }
                        showMessage("Data", buffer.toString());
                    }
                }
        );
    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    static int calcularEdad(int dia, int mes, int anio) {
        LocalDate fechaHoy = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);

        Period periodo = Period.between(fechaNacimiento, fechaHoy);

        return periodo.getYears();
    }
    public void onRadioButtonClicked(View view){
        boolean checked =((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.radioButton_hombre:
                if(checked)
                    genero="hombre";
                    break;

            case R.id.radioButton_mujer:
                if(checked)
                    genero="mujer";
                    break;
            case R.id.radioButton_otro:
                if(checked)
                    genero="otro";
                    break;
        }
    }
}
