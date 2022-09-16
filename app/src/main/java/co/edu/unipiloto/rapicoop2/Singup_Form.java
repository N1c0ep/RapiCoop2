package co.edu.unipiloto.rapicoop2;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;


public class Singup_Form extends AppCompatActivity {

    private RapiCoopDatabaseHelper myDb;
    private TextInputLayout editFullName, editEmail, editPassword;
    private Button btnAddData;
    private Button btnViewAll;
    private int tipo;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup_form);
        getSupportActionBar().setTitle("Formulario Registro");
        myDb=new RapiCoopDatabaseHelper(this);
        editFullName=(TextInputLayout)findViewById(R.id.editText_fullname);
        editEmail=(TextInputLayout)findViewById(R.id.editText_email);
        editPassword=(TextInputLayout)findViewById(R.id.editText_password);
        btnAddData=(Button)findViewById(R.id.button_registrar);
        btnViewAll=(Button)findViewById(R.id.button_mostrar_registro);
        addData();
        viewAll();

    }
    public void addData(){
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Integer valueInt= new Integer(tipo);
                        User user=new User();
                        user.setFullName(editFullName.getEditText().getText().toString());
                        user.setEmail(editEmail.getEditText().getText().toString());
                        user.setPassword(editPassword.getEditText().getText().toString());
                        user.setTipo(valueInt);
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
                            buffer.append("Correo: "+res.getString( 2)+"\n");
                            buffer.append("Clave: "+res.getString( 3)+"\n");
                            buffer.append("Tipo: "+res.getString( 4)+"\n\n");

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
    public void onRadioButtonClicked(View view){
        boolean checked =((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.radioButton_cliente:
                if(checked)
                    tipo=2;
                    break;

            case R.id.radioButton_repartidor:
                if(checked)
                    tipo=1;
                    break;
            case R.id.radioButton_vendedor:
                if(checked)
                    tipo=0;
                    break;
        }
    }
}
