package co.edu.unipiloto.rapicoop2;

import android.app.Dialog;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    private TextInputLayout editFullName;
    private TextInputLayout editUserName;
    private TextInputLayout editEmail;
    private TextInputLayout editPassword;
    private EditText editAnoNacimiento;
    private Spinner editTipoUsuario;
    private Button btnAddData;
    private Button btnViewAll;
    private String genero;
    private View view;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup_form);
        getSupportActionBar().setTitle("Formulario Registro");
        myDb=new RapiCoopDatabaseHelper(this);
        editAnoNacimiento = (EditText) view.findViewById(R.id.etPlannedDate);
        editAnoNacimiento.setOnClickListener((View.OnClickListener) this);
        editFullName=(TextInputLayout)findViewById(R.id.editText_fullname);
        editUserName=(TextInputLayout)findViewById(R.id.editText_userName);
        editEmail=(TextInputLayout)findViewById(R.id.editText_email);
        editPassword=(TextInputLayout)findViewById(R.id.editText_password);
        editTipoUsuario=(Spinner) findViewById(R.id.color);

        btnAddData=(Button)findViewById(R.id.button_registrar);
        btnViewAll=(Button)findViewById(R.id.button_mostrar_registro);
        addData();
        viewAll();


    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.etPlannedDate:
                showDatePickerDialog();
                break;
        }
    }
        private void showDatePickerDialog() {
            DatePickerFragment newFragment = new DatePickerFragment();
            newFragment.show(getSupportFragmentManager(), "datePicker");
        }


    public void addData(){
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        User user=new User();
                        user.setFullName(editFullName.getEditText().getText().toString());
                        user.setUserName(editUserName.getEditText().getText().toString());
                        user.setEmail(editEmail.getEditText().getText().toString());
                        user.setPassword(editPassword.getEditText().getText().toString());
                        user.setRol(editTipoUsuario.getItemAtPosition(editTipoUsuario.getSelectedItemPosition()).toString());
                        user.setAno_nacimiento(Integer.parseInt(String.valueOf(editAnoNacimiento.getText())));

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
                            buffer.append(": "+res.getString( 1)+"\n");
                            buffer.append(": "+res.getString( 2)+"\n");
                            buffer.append(": "+res.getString( 3)+"\n");
                            buffer.append(": "+res.getString( 4)+"\n");
                            buffer.append(": "+res.getString( 5)+"\n");
                            buffer.append(": "+res.getString( 6)+"\n");



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
