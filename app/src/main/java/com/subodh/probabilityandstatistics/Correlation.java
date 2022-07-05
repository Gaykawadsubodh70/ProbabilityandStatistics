package com.subodh.probabilityandstatistics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;

public class Correlation extends AppCompatActivity {
    Button btr;
    EditText vox,voy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_correlation);

        vox=findViewById(R.id.vor);
        voy=findViewById(R.id.voy1);
        btr=findViewById(R.id.bt_r);
        btr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Correlation.this,Coeficient_R.class);
                intent.putExtra("vox",vox.getText().toString());
                intent.putExtra("voy",voy.getText().toString());
                startActivity(intent);
            }
        });
    }
}