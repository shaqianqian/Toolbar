package com.eservice.shaqianqian.toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

import android.support.design.widget.TabLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Analyser l'etat d'Internet
        if (Util.getNetState(this) == Util.NET_NONE) {
            Toast.makeText(getApplicationContext(), "Connextion est mauvais", Toast.LENGTH_LONG).show();

        } else {

            Toast.makeText(getApplicationContext(), "Connextion est bon", Toast.LENGTH_LONG).show();
        }

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        tablayout = (TabLayout) findViewById(R.id.tab_layout);
        //modifier les parametres de toolbar
        toolbar.setTitle("Weather");
        toolbar.setSubtitle("Meteo");
        toolbar.setLogo(R.mipmap.ic_launcher);
        setSupportActionBar(toolbar);

        List<Fragment> list_fragment = new ArrayList<>();
        List<String> tabTitles = new ArrayList<String>();
        list_fragment.add(new Tab1Fragment());
        list_fragment.add(new Tab2Fragment());
        list_fragment.add(new Tab3Fragment());
        list_fragment.add(new Tab4Fragment());
        tabTitles.add("Lille");
        tabTitles.add("Paris");
        tabTitles.add("Lyon");
        tabTitles.add("Nice");
        //Methodes qui ajoute les tabs dans l'interface
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),
                list_fragment, tabTitles);

        viewPager.setAdapter(viewPagerAdapter);
        tablayout.setupWithViewPager(viewPager);


    }

    //Ajouter le menu dans toolbar
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    //Ajouter les fonctionnalites pour les boutons
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add:
                Toast.makeText(MainActivity.this, "add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_delete:
                Toast.makeText(MainActivity.this, "DELETE!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_update:
                Toast.makeText(MainActivity.this, "UPDATE !", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
