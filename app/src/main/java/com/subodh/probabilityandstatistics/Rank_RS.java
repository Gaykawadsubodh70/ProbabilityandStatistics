package com.subodh.probabilityandstatistics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Rank_RS extends AppCompatActivity {
    TextView vox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution_r);
        vox=findViewById(R.id.vor);
        TableLayout tbl= (TableLayout) findViewById(R.id.tbl);
        Intent intent=getIntent();

        String vox1=intent.getStringExtra("vox");
        String[] sx=null;
        sx=vox1.split("\\\n");

        String voy1=intent.getStringExtra("voy");
        String[] sy=null;
        sy = voy1.split("\\\n");

        int pos=intent.getIntExtra("pos",-1);

        int n=sx.length;

        double[] x=new double[n];
        double[] y=new double[n];
        double[] di=new double[n];

        double sdi=0,sdi2=0,rs=0;
        double r=0;

        head(tbl);
        if(pos==1)
        {
            for(int i=0;i<n;i++)
            {
                x[i] = Double.parseDouble(sx[i]);
                y[i] = Double.parseDouble(sy[i]);
            }
            x=calRank(x);
            y=calRank(y);
        }
        for(int i=0;i<n;i++)
        {
            if(pos==0) {
                x[i] = Double.parseDouble(sx[i]);
                y[i] = Double.parseDouble(sy[i]);
            }
            di[i]=x[i]-y[i];
            sdi=di[i]+sdi;
            addrw(tbl,i+1,x[i],y[i],di[i],di[i]*di[i]);
            di[i]=di[i]*di[i];
            sdi2=di[i]+sdi2;
        }

        print("sdi",sdi);
        print("sdi2 ",sdi2);
        if(sdi!=0) {
            print("Calculation Error Occured \n sdi : ", sdi);
            vox.setText("Calculation Error Occured \n sdi : " + sdi);
        }
        else {
            rs = 1 - (6 * sdi2 / (n * ((n * n) - 1)));
            vox.setText("r = " + String.format("%.4f", rs));
            addrw(tbl,0,0,0,sdi,sdi2);
        }

    }

    public void head(TableLayout tbl)
    {
        TableRow tbr0 = new TableRow(this);
        tbr0.setBackgroundColor(Color.GREEN);
        //tbr0.setBackground(Drawable.createFromPath("@drawable/border"));
        TextView tvn = new TextView(this);
        tvn.setText(" Sr no ");
        tvn.setTextColor(Color.BLACK);
        tvn.setGravity(Gravity.CENTER);
        tvn.setBackgroundResource(R.drawable.border);
        tbr0.addView(tvn);

        TextView tv0 = new TextView(this);
        tv0.setText(" Rank x ");
        tv0.setTextColor(Color.BLACK);
        tv0.setGravity(Gravity.CENTER);
        tv0.setBackgroundResource(R.drawable.border);
        tbr0.addView(tv0);

        TextView tv1 = new TextView(this);
        tv1.setText(" Rank y ");
        tv1.setTextColor(Color.BLACK);
        tv1.setGravity(Gravity.CENTER);
        tv1.setBackgroundResource(R.drawable.border);
        tbr0.addView(tv1);

        TextView tv2 = new TextView(this);
        tv2.setText(" di ");
        tv2.setTextColor(Color.BLACK);
        tv2.setGravity(Gravity.CENTER);
        tv2.setBackgroundResource(R.drawable.border);
        tbr0.addView(tv2);

        TextView tv3 = new TextView(this);
        tv3.setText(" di2 ");
        tv3.setTextColor(Color.BLACK);
        tv3.setBackgroundResource(R.drawable.border);
        tv3.setGravity(Gravity.CENTER);
        tbr0.addView(tv3);

        tbl.addView(tbr0);
    }

    public void addrw(TableLayout tbl,int i, double a,double b,double c, double d) {
        TableRow tbr = new TableRow(this);
        //tbr.setBackgroundResource(R.drawable.border);
        if (i == 0)
            tbr.setBackgroundColor(Color.LTGRAY);
        TextView tnv = new TextView(this);
        if (i == 0)
            tnv.setText(" sum ");
        else
            tnv.setText("  " + i);
        tnv.setTextColor(Color.BLACK);
        tnv.setGravity(Gravity.CENTER);
        tnv.setBackgroundResource(R.drawable.border);
        tbr.addView(tnv);

        TextView t1v = new TextView(this);
        if (i == 0)
            t1v.setText(" ");
        else
        t1v.setText("  " + String.format("%.2f", a));
        t1v.setTextColor(Color.BLACK);
        t1v.setGravity(Gravity.CENTER);
        t1v.setBackgroundResource(R.drawable.border);
        tbr.addView(t1v);

        TextView t2v = new TextView(this);
        if (i == 0)
            t2v.setText(" ");
        else
        t2v.setText("  " + String.format("%.2f", b));
        t2v.setTextColor(Color.BLACK);
        t2v.setGravity(Gravity.CENTER);
        t2v.setBackgroundResource(R.drawable.border);
        tbr.addView(t2v);

        TextView t3v = new TextView(this);
        t3v.setText("  " + String.format("%.2f", c));
        t3v.setTextColor(Color.BLACK);
        t3v.setGravity(Gravity.CENTER);
        t3v.setBackgroundResource(R.drawable.border);
        tbr.addView(t3v);

        TextView t4v = new TextView(this);
        t4v.setText("  " + String.format("%.2f", d));
        t4v.setTextColor(Color.BLACK);
        t4v.setGravity(Gravity.CENTER);
        t4v.setBackgroundResource(R.drawable.border);
        tbr.addView(t4v);

        tbl.addView(tbr);
    }


    public void print(String str,double x)
    {
        System.out.println(str+""+x);
    }

    public double[] calRank(double[] num)
    {
        HashMap<Double, Integer> x = new LinkedHashMap<>();
        List<Double> l=new ArrayList<Double>();

        for(double a:num)
        {
            l.add(a);
            x.put(a,0);
        }
        System.out.println("list : "+l);
        int s=l.size();
        int i=1;
        for(int j=0;j<s;j++)
        {
            double min = Collections.min(l);
            x.put(min,i);
            int y=l.indexOf(min);
            l.remove(y);
            i++;
        };

        double[] vox=new double[5];
        int c=0;
        for(int v:x.values())
        {
            vox[c]=v;
            c++;

        }
        return vox;
    }
}