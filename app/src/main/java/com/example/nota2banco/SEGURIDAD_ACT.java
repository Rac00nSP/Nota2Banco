package com.example.nota2banco;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
public class SEGURIDAD_ACT extends AppCompatActivity {
    private EditText passingres;
    private TextView cifrado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_e_g_u_r_i_d_a_d__a_c_t);
        passingres = (EditText)findViewById(R.id.passingres);
        cifrado = (TextView)findViewById(R.id.txtClaveCifrada);
    }
    private SecretKeySpec generateKey(String password)throws Exception{
        MessageDigest sh = MessageDigest.getInstance("sha-256");
        byte [] key = password.getBytes("UTF-8");
        key = sh.digest(key);
        SecretKeySpec secretkey = new SecretKeySpec(key, "AES");
        return secretkey;
    }
    public String Encriptar (String datos, String password)throws Exception{
        if (!passingres.getText().toString().isEmpty())
        {
            SecretKeySpec secretkey = generateKey(password);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretkey);
            byte[] datosEncriptadosBytes = cipher.doFinal(datos.getBytes());
            String datosEncriptadosString = Base64.encodeToString(datosEncriptadosBytes, Base64.DEFAULT);
            return  datosEncriptadosString;
        }
        else{
            Toast.makeText(this, "Debe ingresar una contraseña", Toast.LENGTH_SHORT).show();
            return null;
        }
    }
    public void  Encriptar (View v)
    {
        try {
            String mensaje = Encriptar(cifrado.getText().toString(), passingres.getText().toString());
            cifrado.setText(mensaje);
            passingres.setText(" ");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}