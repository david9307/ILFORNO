package com.davidh.ilforno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

   String password,usuario,correo;
    TextView pr1;
    int check=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


           Bundle extra = getIntent().getExtras();
           usuario = extra.getString("Usuario");
           password = extra.getString("Contraseña");
           correo = extra.getString("Email");
          // pr1 = (TextView) findViewById(R.id.pr);
           //pr1.setText(usuario);




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id =item.getItemId();

        switch(id){

            case R.id.miperfil:
                Intent intent=new Intent(MainActivity.this,PerfilActivity.class);

                intent.putExtra("Usuario",usuario);
                intent.putExtra("Contraseña",password);
                intent.putExtra("Email",correo);
                startActivity(intent);
                break;

            case R.id.Platos:
                Intent inten=new Intent(MainActivity.this,PlatosActivity.class);

                inten.putExtra("Usuario",usuario);
                inten.putExtra("Contraseña",password);
                inten.putExtra("Email",correo);
                startActivity(inten);
                break;

        }
        return true;

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }
}
