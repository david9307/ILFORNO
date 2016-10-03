package com.davidh.ilforno;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class PerfilActivity extends AppCompatActivity {

    String usuario,correo,cont;
    TextView us,corr;
    ListView list2;
    private String[] opciones = new String[] {"Mi_perfil","Mis_platos","Mis_promociones","Cerrar_sesion"};
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_perfil);


        drawerLayout=(DrawerLayout)findViewById(R.id.contenedorprincipal);
        list2=(ListView)findViewById(R.id.menuIzq);
        list2.setAdapter(new ArrayAdapter<String>(getSupportActionBar().getThemedContext(),
                android.R.layout.simple_list_item_1,opciones));


        us=(TextView)findViewById(R.id.user2);
        corr=(TextView)findViewById(R.id.correo);
        SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        usuario = prefs.getString("Usuario", "nada");
        cont= prefs.getString("Password", "nada");
        correo = prefs.getString("Email", "nada");
        us.setText(usuario);
        corr.setText(correo);

        list2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



                switch(i){

                    case 0:


                        break;
                    case 1:
                        Intent inten2 = new Intent(PerfilActivity.this, PlatosActivity.class);

                        //inten2.putExtra("Usuario", usuario);
                        //inten2.putExtra("Contraseña", cont);
                       // inten2.putExtra("Email", correo);
                        startActivity(inten2);

                        break;
                    case 2:
                        Intent inten3 = new Intent(PerfilActivity.this, MainActivity.class);
                        startActivity(inten3);
                        break;

                    case 3:
                        Intent inten4 = new Intent(PerfilActivity.this, LogginActivity.class);
                        startActivity(inten4);
                        break;

                }

                list2.setItemChecked(i,true);
                drawerLayout.closeDrawer(list2);
            }
        });


        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.abierto,R.string.cerrado);
        drawerLayout.setDrawerListener(drawerToggle);
        final ActionBar ab = getSupportActionBar();
        if (ab!=null){

            ab.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            ab.setDisplayHomeAsUpEnabled(true);
        }

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(Gravity.LEFT);
                return true;


        }
        return super.onOptionsItemSelected(item);
    }
  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    */

 /*   @Override
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
    */
}
