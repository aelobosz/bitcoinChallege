package com.alobosz.bitcoinbeetrack.presentation.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alobosz.bitcoinbeetrack.util.ViewModelFactory;

import javax.inject.Inject;

public class BaseActivity extends AppCompatActivity {


    @Inject
    public ViewModelFactory viewModelFactory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
    }
}
