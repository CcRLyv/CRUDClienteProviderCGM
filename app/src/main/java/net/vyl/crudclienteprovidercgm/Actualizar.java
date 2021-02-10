package net.vyl.crudclienteprovidercgm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import net.vyl.crudclienteprovidercgm.provider.MiProveedorContenidoContract;

public class Actualizar extends AppCompatActivity {
    Cursor cursor;
    String idUs;
    Button btnAceptar;
    Button btnCanc;
    TextView tbNombre;
    TextView tbCorreo;
    TextView tbContra;
    TextView tbTel;
    private static final String TAG = "Prueba";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar);
        Intent intent =  getIntent();

      idUs = intent.getStringExtra("id");
        tbNombre  = findViewById(R.id.tbNombre);
        tbCorreo  = findViewById(R.id.tbEmail);
        tbContra  = findViewById(R.id.tbPas);
        tbTel  = findViewById(R.id.tbTel);
        btnAceptar = findViewById(R.id.btnAceptar);
        btnCanc = findViewById(R.id.btnCan);
        consultar();

        tbNombre.setText(cursor.getString(cursor.getColumnIndex("nombre")));
        tbCorreo.setText(cursor.getString(cursor.getColumnIndex("email")));
        tbContra.setText(cursor.getString(cursor.getColumnIndex("password")));
        tbTel.setText("" + cursor.getString(cursor.getColumnIndex(MiProveedorContenidoContract.Usuarios.TELEFONO)));

        ContentResolver cr = getApplicationContext().getContentResolver();
        ContentValues cv = new ContentValues();

        btnAceptar.setOnClickListener(l->{
            cv.put(MiProveedorContenidoContract.Usuarios._ID,cursor.getString(cursor.getColumnIndex("_id")));
            cv.put(MiProveedorContenidoContract.Usuarios.NOMBRE,tbNombre.getText().toString() );
            cv.put(MiProveedorContenidoContract.Usuarios.PASS, tbContra.getText().toString());
            cv.put(MiProveedorContenidoContract.Usuarios.EMAIL, tbCorreo.getText().toString());
            cv.put(MiProveedorContenidoContract.Usuarios.TELEFONO, tbTel.getText().toString());

            int resultado = cr.update(MiProveedorContenidoContract.Usuarios.CONTENT_URI, cv,null,null);
            Log.d(TAG, resultado+"");
            if (resultado==1){
                onBackPressed();
            }else{
                Toast.makeText(this,"Error al actualizar",Toast.LENGTH_LONG).show();
            }

        });

        btnCanc.setOnClickListener(a ->{
           onBackPressed();

        });
    }

    public void consultar(){
        Uri uri = Uri.parse(MiProveedorContenidoContract.Usuarios.CONTENT_URI.toString() + "/" +idUs);
        cursor = getBaseContext().getContentResolver().query(uri,
                null, null, null, null);
        cursor.moveToFirst();
        Log.d(TAG, cursor.getString(cursor.getColumnIndex("_id")));

    }
}