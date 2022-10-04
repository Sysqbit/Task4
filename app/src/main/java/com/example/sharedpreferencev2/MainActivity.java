package com.example.sharedpreferencev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button store, retreive, delete;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.full_name);
        password = findViewById(R.id.password);

        store = findViewById(R.id.store_btn);
        retreive = findViewById(R.id.retreive_btn);
        delete = findViewById(R.id.delete_btn);

        sharedPreferences = getSharedPreferences("Data",MODE_PRIVATE);



        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username",username.getText().toString());
                editor.putString("password",password.getText().toString());
                editor.apply();
                Toast.makeText(getApplicationContext(),"Stored",Toast.LENGTH_SHORT).show();

            }
        });
        retreive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sharedPreferences.contains("username")){
                    username.setText(sharedPreferences.getString("username",""));

                }
                if (sharedPreferences.contains("password")){}
                password.setText(sharedPreferences.getString("password",""));

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.clear();
                editor.apply();
                username.setText("");
                password.setText("");
                Toast.makeText(getApplicationContext(),"deleted",Toast.LENGTH_SHORT).show();

            }
        });





    }
}