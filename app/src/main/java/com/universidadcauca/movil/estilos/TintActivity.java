package com.universidadcauca.movil.estilos;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class TintActivity extends ActionBarActivity {

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tint);

        img = (ImageView) findViewById(R.id.icon);

        Picasso.with(this)
                .load(R.drawable.call)
                .resize(150, 160)
                .centerCrop()
                .into(img);

        //Drawable d = img.getDrawable();
        //Drawable dc=DrawableCompat.wrap(d);
        //DrawableCompat.setTint(dc, Color.rgb(0xff, 0x66, 0));
        //img.setImageDrawable(dc);
        Espera e =  new Espera();
        e.execute(1000l);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tint, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    public class Espera extends AsyncTask<Long, Integer, Integer>{

        @Override
        protected Integer doInBackground(Long... params) {
            try {
                Thread.sleep(params[0]);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return 0;
            }
            return 1;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            if(integer == 1){
                Drawable d = img.getDrawable();
                Drawable dc=DrawableCompat.wrap(d);
                DrawableCompat.setTint(dc, Color.rgb(0xff, 0x66, 0));
                img.setImageDrawable(dc);

            }
        }
    }

}
