package com.example.my32_navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    Toolbar toolbar;
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;

    FloatingActionButton fab;
    NavigationView navigationView;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

        getSupportFragmentManager().beginTransaction().replace(R.id.contain,fragment1).commit();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        int userLevel = 1;
        String loginID = "BTS";
        View headerView = navigationView.getHeaderView(0);

        TextView navLoginID = headerView.findViewById(R.id.loginID);
        navLoginID.setText("반갑습니다 " + loginID + "님!!!");
        ImageView imageView = headerView.findViewById(R.id.loginImage);
        //imageView.setImageResource(R.drawable.dream03);
        Glide.with(this).load(R.drawable.dream03).circleCrop().into(imageView);
        if (userLevel==0){
            navigationView.getMenu().findItem(R.id.communi).setVisible(false);
        }else if(userLevel==1) {
            navigationView.getMenu().findItem(R.id.communi).setVisible(true);
        }

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Bundle bundle = new Bundle();
        if (id == R.id.nav_home){
            bundle.putString("id", "KIM");
            onFragmentSelected(0, bundle);
        }else if(id == R.id.nav_gallery){
            onFragmentSelected(1, null);
        }else if(id == R.id.nav_slideshow){
            bundle.putString("id", "KIM");
            onFragmentSelected(2, bundle);
        }else if(id == R.id.nav_tools){
            bundle.putString("id", "KIM");
            onFragmentSelected(3, bundle);
        }else if(id == R.id.nav_share){
            bundle.putString("id", "KIM");
            onFragmentSelected(4, bundle);
        }else if(id == R.id.nav_send){
            bundle.putString("id", "KIM");
            onFragmentSelected(5, bundle);
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private void onFragmentSelected(int position, Bundle bundle) {
        Fragment fragment = null;
        switch (position){
            case 0 :
                fragment = fragment1;
                toolbar.setTitle("첫번째 화면");
                break;
            case 1 :
                fragment = fragment2;
                toolbar.setTitle("두번째 화면");
                break;
            case 2 :
                fragment = fragment3;
                toolbar.setTitle("세번째 화면");
                break;
            case 3 :
                fragment = fragment3;
                toolbar.setTitle("네번째 화면");
                break;
            default:
                fragment = fragment1;
                toolbar.setTitle("디폴트 화면");
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.contain,fragment).commit();
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen((GravityCompat.START))){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
}