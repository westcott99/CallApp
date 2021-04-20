package com.example.callapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number = findViewById(R.id.number);
    }

    public void call(View view) {

        if(validateCall()){
            Toast.makeText(this,"Validacion correcta",Toast.LENGTH_LONG).show();
            callPhone();
        }else {
            Toast.makeText(this,"Validacion erronea",Toast.LENGTH_LONG).show();
        }
    }

    private boolean validateCall(){
        boolean status = true;

        if(!Valcall.validateCall(number,"Complete el campo")){
            status = false;
        }
        return status;
    }

    public void callPhone(){
        Toast.makeText(MainActivity.this,"Iniciando la llamada ...",Toast.LENGTH_SHORT).show();
        //Iniciaremos un Intent ACTION CALL (Llamada) de llamade del telefono
        Intent intent = new Intent(Intent.ACTION_CALL);

        //Agregaremos parametros, en nuestro caso, utilizaremos el numero de
        //telefono agregado en el EditText
        intent.setData(Uri.parse("tel: "+ number.getText().toString()));

        //CODIGO NO SERA ESCRITO POR USTED
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;

        }
        //Iniciamos la actividad. Se nos va a solicitar
        //agregar permisos en el AndroidManisfest.xml
        //<uses-permission android:name="android.permission.CALL_PHONE" />
        startActivity(intent);
    }
}
