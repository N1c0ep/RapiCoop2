package co.edu.unipiloto.rapicoop2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Vendedor extends AppCompatActivity {

    EditText etEnviar, etComida, etDescripcion, etPrecio, etCantidad;
    Button btnEnviar;
    String [] datos = new String[]{etEnviar.getText().toString(),etComida.getText().toString(), etDescripcion.getText().toString(),etPrecio.getText().toString(),
    etCantidad.getText().toString()};

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendedor);
        getSupportActionBar().setTitle("Vendedor");

        etEnviar = findViewById(R.id.editText1);
        etDescripcion = findViewById(R.id.descripcion);
        etPrecio = findViewById(R.id.precio);
        etCantidad = findViewById(R.id.cantidad);
        etComida = findViewById(R.id.nombreComida);
        btnEnviar = findViewById(R.id.button1);

        /*btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle enviarDatos = new Bundle();
                enviarDatos.putStringArray("keyDatos", datos);

                Intent intent = new Intent(Vendedor.this, UsuarioHamburguesa.class);
                intent.putExtras(enviarDatos);
                startActivity(intent);
            }
        });*/
    }


}
