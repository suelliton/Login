package br.eaj.tads.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String ARQUIVO = "PREFERENCIAS" ;
    Context c = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText Elogin = (EditText) findViewById(R.id.Elogin);
        EditText Esenha = (EditText) findViewById(R.id.Esenha);


        Button btnLogar = (Button) findViewById(R.id.Blogar);


        SharedPreferences prefs = getSharedPreferences(ARQUIVO,MODE_PRIVATE);
        SharedPreferences.Editor editor= prefs.edit();

        String nome = prefs.getString("login","");
        String senha = prefs.getString("senha","");
        Bundle bundle = new Bundle();
        bundle.putString("login",nome);
        Intent intent = new Intent(this,Main2Activity.class);
        intent.putExtras(bundle);


        if(senha.equals("")){
        Log.i("blabla","entrou no if");
        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText Elogin = (EditText) findViewById(R.id.Elogin);
                EditText Esenha = (EditText) findViewById(R.id.Esenha);

                String login = Elogin.getText().toString();
                String senha = Esenha.getText().toString();



                if(login.equals("tapioca") && senha.equals("123")){
                    bundle.putString("login",login);
                    intent.putExtras(bundle);
                    SharedPreferences prefs = getSharedPreferences(ARQUIVO,MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("login",login);
                    editor.putString("senha",senha);
                    editor.commit();
                    startActivity(intent);
                }

            }
        });

        }else{


            startActivity(intent);
        }


    }
}
