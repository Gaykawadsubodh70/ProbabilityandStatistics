package com.subodh.probabilityandstatistics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Coefficient_R extends AppCompatActivity {
    Button btr;
    EditText vox,voy;
    TextView line,valuex,valuey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coefficient_r);

        Intent intent=getIntent();
        int cor=intent.getIntExtra("cor",0);
        line=findViewById(R.id.line);
        valuex=findViewById(R.id.valuex);
        valuey=findViewById(R.id.valuey);

        vox=findViewById(R.id.vor);
        voy=findViewById(R.id.voy1);
        btr=findViewById(R.id.bt_r);
        Spinner given = (Spinner) findViewById(R.id.given);
        given.setVisibility(View.INVISIBLE);

        if(cor==1)
        {
            given.setVisibility(View.VISIBLE);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.planets_array, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            given.setAdapter(adapter);

            given.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    String str=given.getSelectedItem().toString();
                    Toast.makeText(getBaseContext(), ""+i, Toast.LENGTH_SHORT).show();
                    if(i==0||i==2)
                    {
                        valuex.setText("Rank of x");
                        valuey.setText("Rank of y");
                        line.setText("Enter the ranks of x and y ");
                    }
                    else
                    {
                        line.setText("Enter the values of x and y \n to calculate their ranks and \n rank coefficient of correlation");
                    }

                    btr.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String a,b;
                            a=vox.getText().toString();
                            b=voy.getText().toString();
                            if(a.length()!=0||b.length()!=0)
                            {
                                if(i==0)
                                {
                                    Intent intent =new Intent(Coefficient_R.this, Rank_RS.class);
                                    intent.putExtra("vox",vox.getText().toString());
                                    intent.putExtra("voy",voy.getText().toString());
                                    intent.putExtra("pos",0);
                                    startActivity(intent);
                                }

                            }
                            else{
                                Toast.makeText(getBaseContext(), "Please Enter values of x and y", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }


        btr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a,b;
                a=vox.getText().toString();
                b=voy.getText().toString();
                if(a.length()!=0||b.length()!=0)
                {
                    Intent intent =new Intent(Coefficient_R.this, SolutionR.class);
                    intent.putExtra("vox",vox.getText().toString());
                    intent.putExtra("voy",voy.getText().toString());
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getBaseContext(), "Please Enter values of x and y", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}