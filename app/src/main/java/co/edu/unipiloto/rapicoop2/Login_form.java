package co.edu.unipiloto.rapicoop2;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.database.sqlite.SQLiteDatabase;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class Login_form extends AppCompatActivity {
    Button usuario;
    private RapiCoopDatabaseHelper myDb;
    private TextInputLayout getUser;
    String user = findViewById(R.id.user_login).toString();
    String psw = findViewById(R.id.user_password).toString();
    SQLiteDatabase sqll= myDb.getWritableDatabase();
    Context context;
    String TABLE_NAME="Registros_RapiCoop";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        usuario = (Button) findViewById(R.id.usuario);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
        getSupportActionBar().setTitle("Login Form");


    }
    public void btn_ingresar (View view){



        if(buscarUsuario(user,psw)) {
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
    public boolean buscarUsuario(String user, String psw){
        RapiCoopDatabaseHelper rapidb = new RapiCoopDatabaseHelper(context);
        SQLiteDatabase db = rapidb.getWritableDatabase();
        Cursor cursorUsuarios = null;
        String rol = null;

        cursorUsuarios = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE usuario LIKE '" + user + "' AND password LIKE '" + psw + "'",null);


        return cursorUsuarios.moveToFirst();

    }

}





