package com.example.pst_ta6_g2;
import OpenHelper.SQLite_OpenHelper;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


public class Registro extends AppCompatActivity {
    Button btnGrabarUsu;
    EditText txtNomUsu,txtTelUsu,txtCorUsu,txtPasUsu,txtMailUsu;
    SQLite_OpenHelper helper=new SQLite_OpenHelper(this,"BD1",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        btnGrabarUsu=(Button)findViewById(R.id.btnRegistrarUsu);
        txtNomUsu=(EditText)findViewById(R.id.txtNomUsu);
        txtTelUsu=(EditText)findViewById(R.id.txtTelUsu);
        txtCorUsu=(EditText)findViewById(R.id.txtCorUsu);
        txtPasUsu=(EditText)findViewById(R.id.txtPasUsu);
        txtMailUsu=(EditText)findViewById(R.id.txtMailUsu);

        btnGrabarUsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.abrir();
                helper.insertarReg(String.valueOf(txtNomUsu.getText()),String.valueOf(txtTelUsu.getText()),String.valueOf(txtCorUsu.getText()),
                        String.valueOf(txtPasUsu.getText()),String.valueOf(txtMailUsu.getText()));
                helper.cerrar();
                Toast.makeText(getApplicationContext(),"Registro almacenado con éxito",Toast.LENGTH_LONG).show();
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

    }

}