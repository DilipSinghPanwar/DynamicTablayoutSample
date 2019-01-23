package com.dynamictablayoutsample;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Item> itemsList = new ArrayList<>();
        Item item1 = new Item();
        item1.setContent("A");
        itemsList.add(item1);

        Item item2 = new Item();
        item2.setContent("B");
        itemsList.add(item2);

        Item item3 = new Item();
        item3.setContent("C");
        itemsList.add(item3);

        MainViewPagerAdapter categoriesPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager(), itemsList);
        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(categoriesPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}