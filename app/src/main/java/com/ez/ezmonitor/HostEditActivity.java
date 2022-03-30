package com.ez.ezmonitor;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.ez.ezmonitor.databinding.ActivityEditHostBinding;

public class HostEditActivity extends AppCompatActivity {
    private ActivityEditHostBinding binding;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityEditHostBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_host, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.host_edit_save) {
            Host host = getValidHostOrNull();
            if (host != null) {
                HostRepository.getInstance(getApplication()).insert(host);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private Host getValidHostOrNull() {
        String hostNickname = String.valueOf(binding.tieHostName.getText());
        if (inputIsEmpty(hostNickname, "Name")) {
            return null;
        }

        String hostIp = String.valueOf(binding.tieHostIp.getText());
        if (inputIsEmpty(hostIp, "IP")) {
            return null;
        }

        String hostUsername = String.valueOf(binding.tieHostUsername.getText());
        if (inputIsEmpty(hostUsername, "Username")) {
            return null;
        }

        String hostPassword = String.valueOf(binding.tieHostPassword.getText());
        if (inputIsEmpty(hostPassword, "Password")) {
            return null;
        }

        return new Host(hostNickname, hostIp, 22, hostUsername, hostPassword);
    }

    private boolean inputIsEmpty(@NonNull String toValidate, String textName) {
        if (toValidate.length() == 0) {
            AppUtils.toast(getApplicationContext(), textName + " cannot be empty");
            return true;
        }
        return false;
    }
}
