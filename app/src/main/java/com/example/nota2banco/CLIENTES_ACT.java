package com.example.nota2banco;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import AdminSQLiteOpenHelper.AdminSQLiteOpenHelper;
public class CLIENTES_ACT extends AppCompatActivity {
    private EditText edtxCodigo, edtxNombre, edtxSalario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_l_i_e_n_t_e_s__a_c_t);
        edtxCodigo = (EditText)findViewById(R.id.txtCodigo);
        edtxNombre = (EditText)findViewById(R.id.txtNombreBD);
        edtxSalario = (EditText)findViewById(R.id.txtSalario);
    }
    public void AddClientes(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"Formulario",null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String codigo = edtxCodigo.getText().toString();
        if(!codigo.isEmpty()){
            ContentValues cont = new ContentValues();
            cont.put("codigo",edtxCodigo.getText().toString());
            cont.put("nombre",edtxNombre.getText().toString());
            cont.put("salario",edtxSalario.getText().toString());
            db.insert("clientes",null,cont);
            db.close();
            Toast.makeText(this,"guardado",    Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Debe ingresar el formulario",    Toast.LENGTH_SHORT).show();
        }
    }
    public void ShowClientes(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"Formulario",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String codigo = edtxCodigo.getText().toString();
        if(!codigo.isEmpty()){
            Cursor fila = db.rawQuery("SELECT nombre, salario FROM clientes WHERE codigo = "+codigo,null);
            if(fila.moveToFirst()){
                edtxNombre.setText(fila.getString(0));
                edtxSalario.setText(fila.getString(1));
            }
            else{
                Toast.makeText(this, "no se encontraron ", Toast.LENGTH_SHORT).show();
            }
                }
                else{
                    Toast.makeText(this, "No se registran clientes con ese codigo", Toast.LENGTH_SHORT).show();
                }
                db.close();
    }
    public void DeleteClientes(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"Formulario",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String codigo = edtxCodigo.getText().toString();
        db.delete("clientes","codigo="+codigo,null);
        db.close();
        Toast.makeText(this, "ha sido eliminado", Toast.LENGTH_SHORT).show();
        edtxCodigo.setText("");
        edtxNombre.setText("");
        edtxSalario.setText("");
    }
    public void UpdateClientes(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"Formulario",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String codigo = edtxCodigo.getText().toString();
        ContentValues cont = new ContentValues();
        cont.put("codigo",edtxCodigo.getText().toString());
        cont.put("nombre",edtxNombre.getText().toString());
        cont.put("salario",edtxSalario.getText().toString());
        if(!codigo.isEmpty()){
            db.update("clientes",cont,"codigo="+codigo,null);
            db.close();
            Toast.makeText(this, "Cargado correctamente", Toast.LENGTH_SHORT).show();
        }
    }
}