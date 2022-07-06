package com.subodh.probabilityandstatistics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
    Button btn_r,btn_rs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btn_r=(Button) findViewById(R.id.btn_r);
        btn_rs=(Button) findViewById(R.id.btn_rs);

        btn_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Home.this, Coefficient_R.class);
                intent.putExtra("cor",0);
                startActivity(intent);
            }
        });

        btn_rs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Home.this, Coefficient_R.class);
                intent.putExtra("cor",1);
                startActivity(intent);
            }
        });
    }
}