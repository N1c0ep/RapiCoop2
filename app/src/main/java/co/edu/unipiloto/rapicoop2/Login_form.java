package co.edu.unipiloto.rapicoop2;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class Login_form extends AppCompatActivity {
    Button usuario;
    private RapiCoopDatabaseHelper myDb;
    private TextInputLayout getUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        usuario = (Button) findViewById(R.id.usuario);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
        getSupportActionBar().setTitle("Login Form");


    }
    public void btn_ingresar (View view){


        User res= (User) myDb.getUser(findViewById(R.id.user_login).toString());
        if(res.getPassword()==findViewById(R.id.user_password).toString()) {
            Intent i = new Intent(Login_form.this, UsuarioHamburguesa.class);
            startActivity(i);
        }
        else{
            showMessage( "Error", "Credenciales invalidas");
            return;
        }
    }
    public void btn_singupForm(View view){

        startActivity(new Intent(this,Singup_Form.class));
    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }
}





