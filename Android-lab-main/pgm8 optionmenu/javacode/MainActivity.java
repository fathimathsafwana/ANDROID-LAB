package com.example.optionmenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, Settings.class));
            return true;
        } else if (id == R.id.action_privacypolicy) {
            startActivity(new Intent(this, PrivacyPolicy.class));
            return true;
        } else if (id == R.id.action_help) {
            startActivity(new Intent(this, Help.class));
            return true;
        } else if (id == R.id.action_terms) {
            startActivity(new Intent(this, Terms.class));
            return true;
        } else if (id == R.id.action_Contactus) {
            startActivity(new Intent(this, ContactUs.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}