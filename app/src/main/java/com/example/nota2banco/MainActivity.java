package com.example.nota2banco;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import java.util.HashMap;
public class MainActivity extends AppCompatActivity {
    private TextView mensaje;
    private Button boton;
    private EditText nombre, paswd;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar)findViewById(R.id.progressbar);
        mensaje = (TextView)findViewById(R.id.txtMensaje);
        boton = (Button)findViewById(R.id.btnIngresar);
        boton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (loginConfirmation()) {
                    new Task().execute();
                }
                else{
                    Toast.makeText(MainActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        }
        );
        progressBar.setVisibility(View.INVISIBLE);
    }
    private boolean loginConfirmation() {
        nombre = (EditText) findViewById(R.id.txtn);
        paswd = (EditText) findViewById(R.id.txtp);
        return (nombre.getText().toString().equalsIgnoreCase("android") && paswd.getText().toString().equalsIgnoreCase("123"));
    }
    class Task extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
        }
        @Override
        protected void onPostExecute(String s) {
            Intent i = new Intent(getBaseContext(),HOME_ACT.class);
            startActivity(i);
        }
        @Override
        protected String doInBackground(String... strings) {

            for (int i = 1; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

    }
}