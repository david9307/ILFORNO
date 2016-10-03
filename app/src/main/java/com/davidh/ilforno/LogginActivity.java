package com.davidh.ilforno;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class LogginActivity extends AppCompatActivity {

    TextView reg;
    EditText us,cont;
    Button acep;
    String name1="Email",name2="Usuario",name3="Password";
    private final static int EMAIL = 0;
    ArrayList<String> password = new ArrayList<>();
    ArrayList<String> usuario = new ArrayList<>();
    ArrayList<String> correo = new ArrayList<>();
    //SharedPreferences prefs = getSharedPreferences("MisPreferencias",Context.MODE_PRIVATE);
    //String datos = prefs.getString("Usuario", "nada");
    String n="";
    int comp=0;
    String datos,corr,pas;
    int t=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_loggin);
        //editor=pref.edit();
        //editor.putString("Usuario","nada");
        //editor.commit();






        reg=(TextView) findViewById(R.id.registro);
        us=(EditText)findViewById(R.id.usua);
        acep=(Button)findViewById(R.id.ac) ;
        cont=(EditText)findViewById(R.id.contr) ;



        //Bundle extra=getIntent().getExtras();

        //us.setText(extra.getString("Email"));


        acep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* SharedPreferences prefs = getSharedPreferences("MisPreferencias",Context.MODE_PRIVATE);
                int num =prefs.getInt("numero",0);

                for (int s=0 ;s <= num ;s++){
                    String num2 = Integer.toString(s);
                    String name1p=name1+num2;
                    String name2p=name2+num2;
                    String name3p=name3+num2;
                    datos = prefs.getString("Usuario", "nada");
                    corr = prefs.getString("Email","nada");
                    pas =prefs.getString("Password","nada");
                    correo.add(corr) ;
                    usuario.add(datos);
                    password.add(pas);


                }
                */

                SharedPreferences prefs = getSharedPreferences("MisPreferencias",Context.MODE_PRIVATE);
                datos = prefs.getString("Usuario", "nada");
                corr = prefs.getString("Email","nada");
                pas =prefs.getString("Password","nada");
                if (datos.equals("nada")){


                }
                else{


                    correo.add(corr) ;
                    usuario.add(datos);
                    password.add(pas);
                }


                String validar1 = us.getText().toString();
                String validar2 = cont.getText().toString();

                int val = 0,pos=0;

                for (int n = 0; n < usuario.size(); n++) {
                    if (validar1.equals(usuario.get(n))) {
                        val = val + 1;
                        pos=n;
                    }
                }

                for (int n = 0; n < password.size(); n++) {
                    if (validar2.equals(password.get(n))) {
                        val = val + 1;
                    }
                }

                if(val==2){
                    t=pos;
                    Intent intent=new Intent(LogginActivity.this,MainActivity.class);
                    intent.putExtra("Contraseña",password.get(pos));
                    intent.putExtra("Usuario",usuario.get(pos));
                    intent.putExtra("Email",correo.get(pos));

                    startActivity(intent);
                    finish();


                }

                else{

                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Contraseña o Usuario invalidos", Toast.LENGTH_SHORT);

                    toast1.show();
                }

            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(LogginActivity.this,RegistroActivity.class);
                startActivityForResult(intent,0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_CANCELED) {
            // Si es así mostramos mensaje de cancelado por pantalla.
            Toast.makeText(this, "Registro invalido", Toast.LENGTH_SHORT)
                    .show();
        } else {
            // De lo contrario, recogemos el resultado de la segunda actividad.
            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT)
                   .show();
            //correo.add(data.getExtras().getString("Email")) ;
            //usuario.add(data.getExtras().getString("Usuario"));
            //password.add(data.getExtras().getString("Password"));

        }
    }


}



