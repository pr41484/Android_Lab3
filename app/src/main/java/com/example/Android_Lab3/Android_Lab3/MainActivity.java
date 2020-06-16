package com.example.moya.padtm_lab03;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                Toast.makeText(getApplicationContext(), "Kliknięto przycisk FAB", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch(id){
            case R.id.action_settings:
                Toast.makeText(this, "Kliknięto domyslna opcje", Toast.LENGTH_SHORT).show();
                Intent intencja2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intencja2, REQUEST_IMAGE_CAPTURE);
                break;
            case R.id.action_settings1:
                Toast.makeText(this, "Kliknięto 1 opcje", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_settings2:
                Toast.makeText(this, "Kliknięto 2 opcje", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_settings3:
                Toast.makeText(this, "Kliknięto 3 opcje", Toast.LENGTH_SHORT).show();
                break;

        }
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    public void kliknij(View _obj){
        Toast.makeText(this, "Kliknięto przycisk Button", Toast.LENGTH_SHORT).show();
        Intent intencja = new Intent(this, LoginActivity.class);
        startActivity(intencja);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        Bundle extras = data.getExtras();
        Bitmap imageBitmap = (Bitmap) extras.get("data");
        ConstraintLayout lay = (ConstraintLayout)findViewById(R.id.cont);
        lay.setBackground(new BitmapDrawable(getResources(), imageBitmap));
    }

    public void losuj(View _obj){
        int random_number = new Random().nextInt(4)+1;
        final ImageButton btnImg = (ImageButton) findViewById(R.id.ikona);
        switch(random_number){
            case 1:
                btnImg.setImageResource(R.drawable.robot);
                break;
            case 2:
                btnImg.setImageResource(R.drawable.tv);
                break;
            case 3:
                btnImg.setImageResource(R.drawable.android);
                break;
            case 4:
                btnImg.setImageResource(android.R.drawable.btn_star);
                break;
        }

        Toast.makeText(this, "Losowa liczba: " + random_number, Toast.LENGTH_SHORT).show();
    }
}
