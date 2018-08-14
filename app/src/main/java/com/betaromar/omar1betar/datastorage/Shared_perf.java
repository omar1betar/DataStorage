package com.betaromar.omar1betar.datastorage;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class Shared_perf extends AppCompatActivity {

    EditText name,password;
    CheckBox remember_me;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_perf);
        name = (EditText)findViewById(R.id.name_shared);
        password = (EditText)findViewById(R.id.password_shard);
        remember_me = (CheckBox)findViewById(R.id.remember_me_chack_box);
        //we made mode = 0 to be praivate to this app only
        SharedPreferences pref = getSharedPreferences("test",0);
        if (pref.getBoolean("ch",false)==true){
            String names = pref.getString("n","");
            name.setText(names);
            String pass = pref.getString("p","");
            password.setText(pass);
            remember_me.setChecked(true);
        }

        remember_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("test",0);
                SharedPreferences.Editor handler = pref.edit();
                handler.putString("n",name.getText().toString());
                handler.putString("p",password.getText().toString());
                handler.putBoolean("ch",true);
                handler.commit();
            }
        });

    }
}
