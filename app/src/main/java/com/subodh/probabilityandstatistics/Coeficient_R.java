package com.subodh.probabilityandstatistics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
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
        TableLayout tbl= (TableLayout) findViewById(R.id.tbl);
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

        head(tbl);

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
            //addrw(tbl,x[i],y[i]);
            double a=0,b=0,c=0,d=0;
            a=x[i];
            b=y[i];
            x[i] = x[i] - xb;
            y[i] = y[i] - yb;
            xy[i]=x[i]*y[i];
            c=x[i];
            d=y[i];
            x[i]=x[i]*x[i];
            y[i]=y[i]*y[i];
            sxy=sxy+xy[i];
            sx2=sx2+x[i];
            sy2=sy2+y[i];
            addrw(tbl,i+1,a,b,c,d,xy[i],x[i],y[i]);
            print("sxy : ",sxy);
            print("sx2 : ",sx2);
            print("sy2 : ",sy2);
        }
        addrw(tbl,0,sumx,sumy,0,0,sxy,sx2,sy2);
        r=sxy/(Math.sqrt(sx2)*Math.sqrt(sy2));
        vox.setText("r = "+String.format("%.4f",r));
        //https://stackoverflow.com/questions/18207470/adding-table-rows-dynamically-in-android

        //init();
    }

    /*
    public void init()
    {


        for (int i=0; i<25; i++)
        {
            TableRow tbr = new TableRow(this);
            TextView t1v = new TextView(this);
            t1v.setText(""+i);
            t1v.setTextColor(Color.BLACK);
            t1v.setGravity(Gravity.CENTER);
            tbr.addView(t1v);

            TextView t2v = new TextView(this);
            t2v.setText(""+i+10);
            t2v.setTextColor(Color.BLACK);
            t2v.setGravity(Gravity.CENTER);
            tbr.addView(t2v);

            TextView t3v = new TextView(this);
            t3v.setText(""+i*(i+10));
            t3v.setTextColor(Color.BLACK);
            t3v.setGravity(Gravity.CENTER);
            tbr.addView(t3v);
            tbl.addView(tbr);
        }
    }

     */

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
        tv0.setText(" x ");
        tv0.setTextColor(Color.BLACK);
        tv0.setGravity(Gravity.CENTER);
        tv0.setBackgroundResource(R.drawable.border);
        tbr0.addView(tv0);

        TextView tv1 = new TextView(this);
        tv1.setText(" y ");
        tv1.setTextColor(Color.BLACK);
        tv1.setGravity(Gravity.CENTER);
        tv1.setBackgroundResource(R.drawable.border);
        tbr0.addView(tv1);

        TextView tv2 = new TextView(this);
        tv2.setText(" X ");
        tv2.setTextColor(Color.BLACK);
        tv2.setGravity(Gravity.CENTER);
        tv2.setBackgroundResource(R.drawable.border);
        tbr0.addView(tv2);

        TextView tv3 = new TextView(this);
        tv3.setText(" Y ");
        tv3.setTextColor(Color.BLACK);
        tv3.setBackgroundResource(R.drawable.border);
        tv3.setGravity(Gravity.CENTER);
        tbr0.addView(tv3);

        TextView tv4 = new TextView(this);
        tv4.setText(" XY ");
        tv4.setTextColor(Color.BLACK);
        tv4.setGravity(Gravity.CENTER);
        tv4.setBackgroundResource(R.drawable.border);
        tbr0.addView(tv4);

        TextView tv5 = new TextView(this);
        tv5.setText(" x2 ");
        tv5.setTextColor(Color.BLACK);
        tv5.setGravity(Gravity.CENTER);
        tv5.setBackgroundResource(R.drawable.border);
        tbr0.addView(tv5);

        TextView tv6 = new TextView(this);
        tv6.setText(" Y2 ");
        tv6.setTextColor(Color.BLACK);
        tv6.setGravity(Gravity.CENTER);
        tv6.setBackgroundResource(R.drawable.border);
        tbr0.addView(tv6);

        tbl.addView(tbr0);

        /*
        TextView tv2 = new TextView(this);
        tv2.setText("xy");
        tv2.setTextColor(Color.BLACK);
        tbr0.addView(tv2);

        tbl.addView(tbr0); */
    }

    public void addrw(TableLayout tbl,int i, double a,double b,double c, double d,double xy,double x,double y)
    {
        TableRow tbr = new TableRow(this);
        //tbr.setBackgroundResource(R.drawable.border);
        if (i==0)
            tbr.setBackgroundColor(Color.LTGRAY);
        TextView tnv = new TextView(this);
        if (i==0)
            tnv.setText(" sum ");
        else
            tnv.setText("  "+i);
        tnv.setTextColor(Color.BLACK);
        tnv.setGravity(Gravity.CENTER);
        tnv.setBackgroundResource(R.drawable.border);
        tbr.addView(tnv);

        TextView t1v = new TextView(this);
        t1v.setText("  "+String.format("%.2f",a));
        t1v.setTextColor(Color.BLACK);
        t1v.setGravity(Gravity.CENTER);
        t1v.setBackgroundResource(R.drawable.border);
        tbr.addView(t1v);

        TextView t2v = new TextView(this);
        t2v.setText("  "+String.format("%.2f",b));
        t2v.setTextColor(Color.BLACK);
        t2v.setGravity(Gravity.CENTER);
        t2v.setBackgroundResource(R.drawable.border);
        tbr.addView(t2v);

        TextView t3v = new TextView(this);
        if (i==0)
            t3v.setText(" ");
        else
        t3v.setText("  "+String.format("%.2f",c));
        t3v.setTextColor(Color.BLACK);
        t3v.setGravity(Gravity.CENTER);
        t3v.setBackgroundResource(R.drawable.border);
        tbr.addView(t3v);

        TextView t4v = new TextView(this);
        if (i==0)
            t4v.setText(" ");
        else
            t4v.setText("  "+String.format("%.2f",d));
        t4v.setTextColor(Color.BLACK);
        t4v.setGravity(Gravity.CENTER);
        t4v.setBackgroundResource(R.drawable.border);
        tbr.addView(t4v);

        TextView t5v = new TextView(this);
        t5v.setText("  "+String.format("%.2f",xy));
        t5v.setTextColor(Color.BLACK);
        t5v.setGravity(Gravity.CENTER);
        t5v.setBackgroundResource(R.drawable.border);
        tbr.addView(t5v);

        TextView t6v = new TextView(this);
        t6v.setText("  "+String.format("%.2f",x));
        t6v.setTextColor(Color.BLACK);
        t6v.setGravity(Gravity.CENTER);
        t6v.setBackgroundResource(R.drawable.border);
        tbr.addView(t6v);

        TextView t7v = new TextView(this);
        t7v.setText("  "+String.format("%.2f",y));
        t7v.setTextColor(Color.BLACK);
        t7v.setGravity(Gravity.CENTER);
        t7v.setBackgroundResource(R.drawable.border);
        tbr.addView(t7v);

        tbl.addView(tbr);

    }
    public void print(String str,double x)
    {
        System.out.println(str+""+x);
    }
}