package com.davidh.ilforno;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PlatosActivity extends AppCompatActivity {


    private ViewPager vp2;
    FragmentManager fs;
    ListView list2;
    private String[] opciones = new String[] {"Mi_perfil","Mis_platos","Mis_promociones","Cerrar_sesion"};
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_platos);

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        vp2=(ViewPager)findViewById(R.id.pager2);
        vp2.setAdapter(pagerAdapter);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        drawerLayout=(DrawerLayout)findViewById(R.id.contenedorprincipal);
        list2=(ListView)findViewById(R.id.menuIzq);
        list2.setAdapter(new ArrayAdapter<String>(getSupportActionBar().getThemedContext(),
                android.R.layout.simple_list_item_1,opciones));


        list2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



                switch(i){

                    case 0:
                        Intent inten = new Intent(PlatosActivity.this, PerfilActivity.class);

                        //inten.putExtra("Usuario", usuario);
                        //inten.putExtra("Contraseña", password);
                        //inten.putExtra("Email", correo);
                        startActivity(inten);

                        break;
                    case 1:


                        break;
                    case 2:
                        Intent inten3 = new Intent(PlatosActivity.this, MainActivity.class);
                        startActivity(inten3);
                        break;

                    case 3:
                        Intent inten4 = new Intent(PlatosActivity.this, LogginActivity.class);
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



        ActionBar.TabListener tablistener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
                vp2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

            }
        };

        ActionBar.Tab tab=actionBar.newTab().setText("Entradas").setTabListener(tablistener);
        actionBar.addTab(tab);

        tab=actionBar.newTab().setText("Pizzas").setTabListener(tablistener);
        actionBar.addTab(tab);

        tab=actionBar.newTab().setText("Pastas").setTabListener(tablistener);
        actionBar.addTab(tab);

        tab=actionBar.newTab().setText("Combinados").setTabListener(tablistener);
        actionBar.addTab(tab);

        tab=actionBar.newTab().setText("Sanduches").setTabListener(tablistener);
        actionBar.addTab(tab);


        vp2.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){

            public void onPageSelected(int position ){
            getSupportActionBar().setSelectedNavigationItem(position);

            }
        });


    }

    public class PagerAdapter extends FragmentPagerAdapter {
        public PagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position){

                case 0: return new Producto1Fragment();
                case 1: return new LogoFragment();
                case 2: return new Producto2Fragment();
                case 3: return new Producto3Fragment();
                case 4: return new Producto4Fragment();

                default:return null;
            }
            //return null;
        }

        @Override
        public int getCount() {
            return 5;
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
}
