package co.edu.unipiloto.rapicoop2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Login_form extends AppCompatActivity {
    Button usuario;
    @Override
    protected void onCreate (Bundle savedInstanceState){

        usuario = (Button) findViewById(R.id.usuario);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
        getSupportActionBar().setTitle("Login Form");

        /*usuario.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent i = new Intent(Login_form.this,Usuario.class);
                startActivity(i);
            }
        });*/
    }

    public void btn_singupForm(View view){

        startActivity(new Intent(Login_form.this, Vendedor.class));
    }


    /*public void btn_ingresar(View view){
        Intent i = new Intent(Login_form.this,Usuario.class);
        startActivity(i);
    }*/



}


