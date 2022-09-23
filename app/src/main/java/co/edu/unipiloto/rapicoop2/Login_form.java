package co.edu.unipiloto.rapicoop2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Login_form extends AppCompatActivity {
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
        getSupportActionBar().setTitle("Login Form");
    }
    public void btn_singupForm(View view){
        startActivity(new Intent(getApplicationContext(),Singup_Form.class));
    }

    public void btn_ingresar(View view) {
        startActivity(new Intent(getApplicationContext(),Usuario.class));
    }
}
