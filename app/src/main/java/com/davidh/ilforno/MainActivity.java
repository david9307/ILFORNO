package com.davidh.ilforno;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

   // final String[] productos = new String[] {"hamburguesa","perro","chuzo"};
    ListView list;
    ListView list2;
    private String[] opciones = new String[] {"Mi_perfil","Mis_platos","Mis_promociones","Cerrar_sesion"};
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;


    private productos[] productos =
            new productos[]{
            new productos(R.drawable.pizz,"Miercoles_asombrosos","Pizzas_Pastas","50%_de_descuento"),
            new productos(R.drawable.cump,"Lunes-viernes","El del santo no paga","12-5pm"),
            new productos(R.drawable.tarjetas,"Usala","Tarjeta_Banpro","50% de descuento"),
            new productos(R.drawable.pasteleriaboutique,"Pruebala_gratis","Pasteleria","Por el mes de octubre"),
                    new productos(R.drawable.negocios,"minimo 12 personas","Negocios","20% de descuento")
            };
    String password="", usuario="", correo="";
    TextView pr1;
    int check = 0;
    FragmentManager fs;
    FragmentTransaction ft;
    private ViewPager vp;
    String datos;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter adaptador =new adapter(this, productos);
       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,)

        drawerLayout=(DrawerLayout)findViewById(R.id.contenedorprincipal);
        list2=(ListView)findViewById(R.id.menuIzq);
        list2.setAdapter(new ArrayAdapter<String>(getSupportActionBar().getThemedContext(),
                android.R.layout.simple_list_item_1,opciones));


        list =(ListView)findViewById(R.id.lista);
        list.setAdapter(adaptador);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                        @Override
                                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                            switch (position){
                                                case 0:
                                                    Intent intent = new Intent(MainActivity.this, PromocionesActivity.class);
                                                    intent.putExtra("select",0);
                                                    //inten2.putExtra("Usuario", usuario);
                                                    // inten2.putExtra("Contraseña", password);
                                                    //inten2.putExtra("Email", correo);
                                                    startActivity(intent);
                                                    break;

                                                case 1:
                                                    Intent intent2 = new Intent(MainActivity.this, PromocionesActivity.class);
                                                    intent2.putExtra("select",1);
                                                    //inten2.putExtra("Usuario", usuario);
                                                    // inten2.putExtra("Contraseña", password);
                                                    //inten2.putExtra("Email", correo);
                                                    startActivity(intent2);
                                                    break;
                                                case 2:
                                                    Intent intent3 = new Intent(MainActivity.this, PromocionesActivity.class);
                                                    intent3.putExtra("select",2);
                                                    //inten2.putExtra("Usuario", usuario);
                                                    // inten2.putExtra("Contraseña", password);
                                                    //inten2.putExtra("Email", correo);
                                                    startActivity(intent3);
                                                    break;

                                                case 3:
                                                    Intent intent4 = new Intent(MainActivity.this, PromocionesActivity.class);
                                                    intent4.putExtra("select",3);
                                                    //inten2.putExtra("Usuario", usuario);
                                                    // inten2.putExtra("Contraseña", password);
                                                    //inten2.putExtra("Email", correo);
                                                    startActivity(intent4);
                                                    break;
                                                case 4:
                                                    Intent intent5 = new Intent(MainActivity.this, PromocionesActivity.class);
                                                    intent5.putExtra("select",4);
                                                    //inten2.putExtra("Usuario", usuario);
                                                    // inten2.putExtra("Contraseña", password);
                                                    //inten2.putExtra("Email", correo);
                                                    startActivity(intent5);
                                                    break;


                                            }

                                        }
                                    });


        list2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



                switch(i){

                    case 0:
                        Intent inten = new Intent(MainActivity.this, PerfilActivity.class);

                        //inten.putExtra("Usuario", usuario);
                        //inten.putExtra("Contraseña", password);
                        // inten.putExtra("Email", correo);
                        startActivity(inten);

                        break;
                    case 1:
                        Intent inten2 = new Intent(MainActivity.this, PlatosActivity.class);

                        //inten2.putExtra("Usuario", usuario);
                       // inten2.putExtra("Contraseña", password);
                        //inten2.putExtra("Email", correo);
                        startActivity(inten2);

                        break;
                    case 2:

                        break;

                    case 3:
                        Intent inten4 = new Intent(MainActivity.this, LogginActivity.class);
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

        // list=(ListView)findViewById(R.id.lista);
        //ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,productos);
        //list.setAdapter(adaptador);









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

        //Bundle extra = getIntent().getExtras();
        //usuario = extra.getString("Usuario");
        //password = extra.getString("Contraseña");
        //correo = extra.getString("Email");
        // pr1 = (TextView) findViewById(R.id.pr);
        //pr1.setText(usuario);
        SharedPreferences prefs = getSharedPreferences("MisPreferencias",Context.MODE_PRIVATE);
        usuario = prefs.getString("Usuario", "nada");
        password = prefs.getString("Password", "nada");
        correo = prefs.getString("Email", "nada");

    }




 /*   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;

    }
*/



  /*  @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //ft= fs.beginTransaction();


        switch (id) {

            case android.R.id.home:
                drawerLayout.openDrawer(Gravity.LEFT);

                break;


                //Producto1Fragment ham =new Producto1Fragment();
                //ft.replace(android.R.id.content,ham).commit();



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

*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }



    public class adapter extends ArrayAdapter<productos> {

        Context c;
        productos[] productos;
        public adapter(Context context, productos[] productos) {
            super(context, R.layout.item,productos);

            this.productos=productos;
            this.c=context;
        }


        public View getView(int position, View convertView, ViewGroup parent){

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item =inflater.inflate(R.layout.item,null);

            TextView nombre =(TextView)item.findViewById(R.id.tnombre);
            nombre.setText(productos[position].getNombre());


            TextView descripcion =(TextView)item.findViewById(R.id.tdescripcion);
            descripcion.setText(productos[position].getDescripcion());

            TextView precio =(TextView)item.findViewById(R.id.tprecio);
            precio.setText(productos[position].getPrecio());


            ImageView imagen =(ImageView)item.findViewById(R.id.timagen);
            imagen.setImageResource(productos[position].getIdimagen());




            return(item);
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


