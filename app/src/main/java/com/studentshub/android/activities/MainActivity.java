package com.studentshub.android.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.studentshub.android.R;
import com.studentshub.android.activities.fragments.ArticleFragment;
import com.studentshub.android.activities.fragments.AskQuestionFragment;
import com.studentshub.android.activities.fragments.DocumentFragment;
import com.studentshub.android.activities.fragments.FactFragment;
import com.studentshub.android.activities.fragments.HomeFragment;
import com.studentshub.android.activities.fragments.MCQFragment;
import com.studentshub.android.activities.fragments.NoticeFragment;
import com.studentshub.android.activities.fragments.VideoFragment;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ActionBarDrawerToggle toggle;
    DrawerLayout drawer;
    NavigationView navigationView;
    FragmentTransaction fragmentTransaction = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);


       // toolbar.setTitleTextColor(getResources().getColor(R.color.black));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ImageView menuRight = findViewById(R.id.menuRight);
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);


        menuRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (drawer.isDrawerOpen(GravityCompat.END)) {
                    drawer.closeDrawer(GravityCompat.END);
                } else {
                    drawer.openDrawer(GravityCompat.END);
                }
            }
        });



/////////////////////////////////////degault toggle code//////////////////////////////////////////////
       /* toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.getDrawerArrowDrawable().setColor(Color.BLACK);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
*/


        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, new HomeFragment());
        fragmentTransaction.commit();


        navigationView.setNavigationItemSelectedListener(menuItem -> {
            selectFragment(menuItem);
            return true;
        });


        navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);

    }


    private void selectFragment(MenuItem menuItem) {
        menuItem.setChecked(true);
        switch (menuItem.getItemId()) {

            case R.id.nav_home:
                pushFragment(new HomeFragment());
                Objects.requireNonNull(getSupportActionBar()).setTitle(getResources().getString(R.string.home));
                break;

            case R.id.nav_ask_question:
                pushFragment(new AskQuestionFragment());
                Objects.requireNonNull(getSupportActionBar()).setTitle(getResources().getString(R.string.ask_question));
                break;

            case R.id.nav_article:
                pushFragment(new ArticleFragment());
                Objects.requireNonNull(getSupportActionBar()).setTitle(getResources().getString(R.string.article));
                break;
            case R.id.nav_notice:
                pushFragment(new NoticeFragment());
                Objects.requireNonNull(getSupportActionBar()).setTitle(getResources().getString(R.string.notice));
                break;
            case R.id.nav_video:
                pushFragment(new VideoFragment());
                Objects.requireNonNull(getSupportActionBar()).setTitle(getResources().getString(R.string.video));
                break;
            case R.id.nav_document:
                pushFragment(new DocumentFragment());
                Objects.requireNonNull(getSupportActionBar()).setTitle(getResources().getString(R.string.document));
                break;
            case R.id.nav_fact:
                pushFragment(new FactFragment());
                Objects.requireNonNull(getSupportActionBar()).setTitle(getResources().getString(R.string.fact));
                break;
            case R.id.nav_mcq:
                pushFragment(new MCQFragment());
                Objects.requireNonNull(getSupportActionBar()).setTitle(getResources().getString(R.string.mcq));
                break;


        }

    }


    protected void pushFragment(Fragment fragment) {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.nav_host_fragment, fragment);
        ft.commit();
        ft.addToBackStack(null);
        drawer.closeDrawers();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

       // int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_search) {
//            Toast.makeText(this, "Hello Search", Toast.LENGTH_SHORT).show();
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END);
        } else {

            if (navigationView.getMenu().findItem(R.id.nav_home).isChecked()) {
                super.onBackPressed();
                finish();
            } else {
                pushFragment(new HomeFragment());
                Objects.requireNonNull(getSupportActionBar()).setTitle(getResources().getString(R.string.home));
                navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);

            }
        }
    }
}


