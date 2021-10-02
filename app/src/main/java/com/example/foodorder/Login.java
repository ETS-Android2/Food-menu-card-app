package com.example.foodorder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.foodorder.databinding.ActivityDetailsBinding;
import com.example.foodorder.databinding.ActivityLoginBinding;
import com.example.foodorder.databinding.ActivityMainBinding;

public class Login extends AppCompatActivity {
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.logingBtnId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this, MainActivity.class) ;
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(Login.this)
                .setCancelable(false)
                .setTitle("Exit")
                .setIcon(R.drawable.warning)
                .setMessage("Are sure you want to Exit?")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).create().show();

        }
    }
