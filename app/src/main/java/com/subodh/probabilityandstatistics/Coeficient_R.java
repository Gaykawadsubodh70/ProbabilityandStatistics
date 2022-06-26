package com.subodh.probabilityandstatistics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.TextView;
import android.os.Bundle;
import java.lang.Math;

public class Coeficient_R extends AppCompatActivity {
TextView vox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coeficient_r);
        vox=findViewById(R.id.vor);
        Intent intent=getIntent();

        String vox1=intent.getStringExtra("vox");
        String[] sx=null;
        sx=vox1.split("\\\n");

        String voy1=intent.getStringExtra("voy");
        String[] sy=null;
        sy = voy1.split("\\\n");
        int n=sx.length;

        double[] x=new double[n];
        double[] y=new double[n];
        double[] xy=new double[n];

        double sumx=0,sumy=0,xb=0,yb=0,sxy=0,sx2=0,sy2=0;
        double r=0;

        for(int i=0;i<n;i++)
        {
            x[i] = Double.parseDouble(sx[i]);
            y[i] = Double.parseDouble(sy[i]);
            sumx = sumx + x[i];
            sumy = sumy + y[i];
        }
        print("sumx : ",sumx);
        print("sumy : ",sumy);
        xb=sumx/n;
        yb=sumy/n;
        print("xb : ",xb);
        print("yb : ",yb);

        for(int i=0;i<n;i++)
        {
            x[i] = x[i] - xb;
            y[i] = y[i] - yb;
            xy[i]=x[i]*y[i];
            x[i]=x[i]*x[i];
            y[i]=y[i]*y[i];
            sxy=sxy+xy[i];
            sx2=sx2+x[i];
            sy2=sy2+y[i];
            print("sxy : ",sxy);
            print("sx2 : ",sx2);
            print("sy2 : ",sy2);
        }
        r=sxy/(Math.sqrt(sx2)*Math.sqrt(sy2));
        vox.setText("r = "+String.format("%.4f",r));
        //https://stackoverflow.com/questions/18207470/adding-table-rows-dynamically-in-android

    }

    public void print(String str,double x)
    {
        System.out.println(str+""+x);
    }
}