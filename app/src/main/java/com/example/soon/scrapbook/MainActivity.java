package com.example.soon.scrapbook;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    private DrawerLayout drawerLayout;
    private ListView listView;
    private String[] favoriteItem;
    private ActionBarDrawerToggle drawerListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //actionBar setting
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.slogo_actonbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.drawer_icon);

        favoriteItem = getResources().getStringArray(R.array.favoriteMenuArray);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        listView = (ListView) findViewById(R.id.favoriteLeftMenu);

        listView.setAdapter(new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, favoriteItem));
        listView.setOnItemClickListener(this);

        drawerListener = new ActionBarDrawerToggle(this,drawerLayout,R.drawable.drawer_icon,R.string.open,R.string.close){
            @Override
            public void onDrawerClosed(View drawerView){
                Toast.makeText(MainActivity.this,"Closed",Toast.LENGTH_LONG).show();
            }
            @Override
            public void onDrawerOpened(View drawerView){
                Toast.makeText(MainActivity.this,"Opened",Toast.LENGTH_LONG).show();
            }
        };

        drawerLayout.setDrawerListener(drawerListener);

    }

    //??
    @Override
    protected void onPostCreate(Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);
        drawerListener.syncState();
    }

    //?????
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerListener.onConfigurationChanged(newConfig);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,favoriteItem[position],Toast.LENGTH_LONG).show();
        selectItem(position);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(drawerListener.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void selectItem(int position) {
        Fragment fr = new Fragment();

        switch (position) {
            case 0:
                fr = new Music();
                break;
            case 1:
                fr = new Psychology();
                break;
        }

        FragmentManager frm = getSupportFragmentManager();
        frm.beginTransaction().replace(R.id.favoriteMainContent,fr).commit();

        listView.setItemChecked(position, true);
        setTitle(favoriteItem[position]);
        drawerLayout.closeDrawer(listView);

    }

}
