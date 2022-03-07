package com.ez.ezmonitor;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ez.ezmonitor.databinding.ActivityEditHostBinding;

public class HostEditActivity extends AppCompatActivity {
    private ActivityEditHostBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityEditHostBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
