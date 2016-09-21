package com.davidh.ilforno;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    final String[] productos = new String[] {"hamburguesa","perro","chuzo"};
    ListView list;

    String password, usuario, correo;
    TextView pr1;
    int check = 0;
    FragmentManager fs;
    FragmentTransaction ft;
    private ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



       // list=(ListView)findViewById(R.id.lista);
        //ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,productos);
        //list.setAdapter(adaptador);


        class Adapter extends ArrayAdapter<productos> {
            public Adapter(Context context, productos[] productos) {
                super(context,R.layout.item,productos);
            }
        }
        //PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        //vp=(ViewPager)findViewById(R.id.pager);
        //vp.setAdapter(pagerAdapter);
        //ActionBar actionBar=getSupportActionBar();
        //actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        /*ActionBar.TabListener tablistener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

            }
        };



        ActionBar.Tab tab=actionBar.newTab().setText("Hamburguesa").setTabListener(tablistener);
        actionBar.addTab(tab);

        tab=actionBar.newTab().setText("Peros").setTabListener(tablistener);
        actionBar.addTab(tab);*/
        /*fs =getFragmentManager();
        ft= fs.beginTransaction();



        LogoFragment lof =new LogoFragment();
        ft.add(android.R.id.content,lof).commit();*/

        Bundle extra = getIntent().getExtras();
        usuario = extra.getString("Usuario");
        password = extra.getString("Contraseña");
        correo = extra.getString("Email");
        // pr1 = (TextView) findViewById(R.id.pr);
        //pr1.setText(usuario);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //ft= fs.beginTransaction();


        switch (id) {

            case R.id.miperfil:
                Intent intent = new Intent(MainActivity.this, PerfilActivity.class);

                intent.putExtra("Usuario", usuario);
                intent.putExtra("Contraseña", password);
                intent.putExtra("Email", correo);
                startActivity(intent);
                //Producto1Fragment ham =new Producto1Fragment();
                //ft.replace(android.R.id.content,ham).commit();

                break;

            case R.id.Platos:
                Intent inten = new Intent(MainActivity.this, PlatosActivity.class);

                inten.putExtra("Usuario", usuario);
                inten.putExtra("Contraseña", password);
                inten.putExtra("Email", correo);
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

    /*public class PagerAdapter extends FragmentPagerAdapter {
        public PagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position){

                case 0: return new Producto1Fragment();
                case 1: return new LogoFragment();
                default:return null;
            }
               //return null;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }*/


//}


