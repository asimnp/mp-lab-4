package com.asim.multiplemenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MenuItem extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_item);

        findViews();
        initToolbar();
    }

    private void findViews() {
        toolbar = findViewById(R.id.toolbar);
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Multiple Menus");

        // Show the back arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Handle back arrow click
        toolbar.setNavigationOnClickListener(v -> {
            finish();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull android.view.MenuItem item) {
        if (item.getItemId() == R.id.optionSearch) {
            Intent intent = new Intent(MenuItem.this, OptionSearch.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.optionNotification) {
            Intent intent = new Intent(MenuItem.this, OptionNotificationActivity.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.optionSettings) {
            Intent intent = new Intent(MenuItem.this, OptionSettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}