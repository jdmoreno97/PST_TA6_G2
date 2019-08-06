package com.example.pst_ta6_g2;

import OpenHelper.SQLite_OpenHelper;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    Button tvRegistrese;
    Button btnIngresar;
    SQLite_OpenHelper helper =new SQLite_OpenHelper(this,"BD1",null,1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvRegistrese=(Button)findViewById(R.id.tvRegistrese);
        tvRegistrese.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent i=new Intent(getApplicationContext(),Registro.class);
                startActivity(i);
            }
        });
        btnIngresar=(Button)findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                EditText txtusu=(EditText)findViewById(R.id.txtUsuario);
                EditText txtpas=(EditText)findViewById(R.id.txtPassword);
                try {
                    Cursor cursor = helper.ConsultarUsuPas(txtusu.getText().toString(), txtpas.getText().toString());
                    if(cursor.getCount()>0) {
                        Intent i = new Intent(getApplicationContext(), Principal.class);
                        startActivity(i);
                    }else{
                        Toast.makeText(getApplicationContext(),"Usuario y/o contraseña incorrectos",Toast.LENGTH_LONG).show();
                    }
                    txtusu.setText("");
                    txtpas.setText("");
                    txtusu.findFocus();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

        });
    }
}
