package com.davidh.ilforno;

import android.app.FragmentManager;
import android.content.pm.ActivityInfo;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class PlatosActivity extends AppCompatActivity {


    private ViewPager vp2;
    FragmentManager fs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_platos);

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        vp2=(ViewPager)findViewById(R.id.pager2);
        vp2.setAdapter(pagerAdapter);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.TabListener tablistener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
                vp2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

            }
        };

        ActionBar.Tab tab=actionBar.newTab().setText("Entradas").setTabListener(tablistener);
        actionBar.addTab(tab);

        tab=actionBar.newTab().setText("Pizzas").setTabListener(tablistener);
        actionBar.addTab(tab);

        tab=actionBar.newTab().setText("Pastas").setTabListener(tablistener);
        actionBar.addTab(tab);

        tab=actionBar.newTab().setText("Combinados").setTabListener(tablistener);
        actionBar.addTab(tab);

        tab=actionBar.newTab().setText("Sanduches").setTabListener(tablistener);
        actionBar.addTab(tab);


        vp2.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){

            public void onPageSelected(int position ){
            getSupportActionBar().setSelectedNavigationItem(position);

            }
        });


    }

    public class PagerAdapter extends FragmentPagerAdapter {
        public PagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position){

                case 0: return new Producto1Fragment();
                case 1: return new LogoFragment();
                case 2: return new Producto2Fragment();
                case 3: return new Producto3Fragment();
                case 4: return new Producto4Fragment();

                default:return null;
            }
            //return null;
        }

        @Override
        public int getCount() {
            return 5;
        }
    }
}
