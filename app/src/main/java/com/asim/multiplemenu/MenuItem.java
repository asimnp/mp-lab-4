package com.asim.multiplemenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

public class MenuItem extends AppCompatActivity {
    Toolbar toolbar;
    AppCompatButton contextMenuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_item);

        findViews();
        initToolbar();
        registerForContextMenu(contextMenuButton);
    }

    private void findViews() {
        toolbar = findViewById(R.id.toolbar);
        contextMenuButton = findViewById(R.id.contentMenuBtn);
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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId() == R.id.contentMenuBtn) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.context_menu, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull android.view.MenuItem item) {
        if (item.getItemId() == R.id.context1) {
            Intent intent = new Intent(MenuItem.this, Context1Activity.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.context2) {
            Intent intent = new Intent(MenuItem.this, Context2Activity.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.context3) {
            Intent intent = new Intent(MenuItem.this, Context3Activity.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.context4) {
            Intent intent = new Intent(MenuItem.this, Context4Activity.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.context5) {
            Intent intent = new Intent(MenuItem.this, Context5Activity.class);
            startActivity(intent);
            return true;
        }
        return super.onContextItemSelected(item);
    }
}