package com.davidh.ilforno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class PerfilActivity extends AppCompatActivity {

    String usuario,correo,cont;
    TextView us,corr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        Bundle extra=getIntent().getExtras();
        us=(TextView)findViewById(R.id.user2);
        corr=(TextView)findViewById(R.id.correo);

        usuario=extra.getString("Usuario");
        correo=extra.getString("Email");
        cont=extra.getString("Contraseña");
        us.setText(usuario);
        corr.setText(correo);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id =item.getItemId();

        switch(id){

            case R.id.miperfil:

                break;

            case R.id.publicidad:
                Intent intent=new Intent(PerfilActivity.this,MainActivity.class);
                intent.putExtra("Usuario",usuario);
                intent.putExtra("Contraseña",cont);
                intent.putExtra("Email",correo);
                startActivity(intent);
                break;

        }
        return true;
    }
}
