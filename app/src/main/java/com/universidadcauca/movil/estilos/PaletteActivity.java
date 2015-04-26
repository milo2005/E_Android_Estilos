package com.universidadcauca.movil.estilos;

import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;


public class PaletteActivity extends AppCompatActivity {

    ImageView img, v,vl,vd,o,ol,od;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        img = (ImageView) findViewById(R.id.img);

        v = (ImageView) findViewById(R.id.img_v);
        vl = (ImageView) findViewById(R.id.img_vl);
        vd = (ImageView) findViewById(R.id.img_vd);

        o = (ImageView) findViewById(R.id.img_o);
        ol = (ImageView) findViewById(R.id.img_ol);
        od = (ImageView) findViewById(R.id.img_od);

        BitmapDrawable bD = (BitmapDrawable) img.getDrawable();

        Palette p = Palette.from(bD.getBitmap()).generate();
        //Palette p = Palette.generate(bD.getBitmap());

        v.setBackgroundColor(p.getVibrantColor(0));
        vl.setBackgroundColor(p.getLightVibrantColor(0));
        vd.setBackgroundColor(p.getDarkVibrantColor(0));

        o.setBackgroundColor(p.getMutedColor(0));
        ol.setBackgroundColor(p.getLightMutedColor(0));
        od.setBackgroundColor(p.getDarkMutedColor(0));


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_palette, menu);
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
}
