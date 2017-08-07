package br.eaj.tads.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        Bundle bundle =  new Bundle();
        bundle = intent.getExtras();

        String nome = bundle.getString("login");

        TextView tlogin = (TextView) findViewById(R.id.Tlogin);
        tlogin.setText(nome);





    }
}
