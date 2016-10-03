package com.davidh.ilforno;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistroActivity extends AppCompatActivity {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Button canc,accept;
    String name1="Email",name2="Usuario",name3="Password";
    int num_user;
    TextView mostrar;
    EditText persona,password1,password2,email;
    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_registro);






        canc=(Button)findViewById(R.id.cancel);
        accept=(Button)findViewById(R.id.accept);
        persona=(EditText)findViewById(R.id.user);
        password1=(EditText)findViewById(R.id.passw);
        password2=(EditText)findViewById(R.id.passw2);
        email=(EditText)findViewById(R.id.email);
        mostrar=(TextView)findViewById(R.id.mostrar);

        canc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);

                // Finalizamos la Activity para volver a la anterior
                finish();
            }
        });


        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String validar1 = persona.getText().toString();
                String validar2= password1.getText().toString();
                String validar3= password2.getText().toString();
                String validar4= email.getText().toString();
                String comp="nada";
                int look=0,error=0;
                boolean m;

                if(validar1.isEmpty()) {
                    persona.setError("Error");
                    error=1;
                }

                if(validar3.isEmpty()) {
                    password2.setError("Error");
                    error=1;
                    look=1;
                }

                if(TextUtils.isEmpty(validar2)) {
                    password1.setError("Error");
                    error=1;
                    look=1;
                }
                if(look==0) {
                    if (validar2.equals(validar3)){

                    }
                    else{
                        error=1;
                    }


                }

                if(TextUtils.isEmpty(validar4)) {
                    email.setError("Error");
                    error=1;
                }


                m=validateEmail(validar4);

                if(m==false){

                    error=1;
                }




                if(error==1){

                    Toast.makeText(RegistroActivity.this, "uno o mas campos son incorrectos", Toast.LENGTH_SHORT).show();

                }
                else{

                    SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    //num_user = prefs.getInt("numero", 0);
                    //String num = Integer.toString(num_user);
                    //String name1p=name1+num;
                    //String name2p=name2+num;
                    //String name3p=name3+num;
                    editor.putString("Email",email.getText().toString());
                    editor.putString("Usuario",persona.getText().toString());
                    editor.putString("Password",password1.getText().toString());
                    //num_user=num_user+1;
                    //editor.putInt("numero",num_user);
                    editor.commit();
                    Intent i = getIntent();
                    i.putExtra("Email",email.getText().toString());
                    i.putExtra("Usuario",persona.getText().toString());
                    i.putExtra("Password",password1.getText().toString());
                    setResult(RESULT_OK, i);
                    finish();




                }

            }
        });
    }

    public static boolean validateEmail(String email) {

        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);

        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }

}
