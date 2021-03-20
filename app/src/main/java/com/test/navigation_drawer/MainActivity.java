package com.test.navigation_drawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawer;
    Toolbar toolbar;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.Container,new Message_Fragement()).commit();
        toolbar=findViewById(R.id.toolbar_id);
        setSupportActionBar(toolbar);
        drawer=findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.OpenDrawer,R.string.CloseDrawer);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView=findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
            return;
        }
        super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.message_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.Container,new Message_Fragement()).commit();
                break;
            case R.id.chat_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.Container,new Chat_Fragement()).commit();
                break;
            case R.id.profile_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.Container,new Profile_Fragement()).commit();
                break;
            case R.id.share_id:
                Toast.makeText(this, "You clicked share item", Toast.LENGTH_SHORT).show();
                break;
            case R.id.send_id:
                Toast.makeText(this, "You clicked send item", Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}