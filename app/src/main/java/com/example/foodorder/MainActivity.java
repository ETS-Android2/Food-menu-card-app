package com.example.foodorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.foodorder.Adapters.MainAdapter;
import com.example.foodorder.Models.MainModel;
import com.example.foodorder.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list=new ArrayList<>();
        list.add(new MainModel(R.drawable.cheese_pasta,"Cheese Pasta","0","New item arival alert!!\n This offer will end September 15"));
        list.add(new MainModel(R.drawable.chese_burger,"Cheese Burger","250","Chicken Burger with extra cheese"));

        list.add(new MainModel(R.drawable.burgernfries,"Combo Burger n Fries","350","Chicken Burger with extra cheese, French fries and Drinks"));
        list.add(new MainModel(R.drawable.chicken_bbq_burger,"Chicken BBQ Burger","350","Chicken BBq Burger with cheese"));
        list.add(new MainModel(R.drawable.pizza,"Pizza","450","12' chicken pizza"));
        list.add(new MainModel(R.drawable.cheesey_pizza,"Cheesey Pizza","550","12' Chicken pizza with extra large cheese"));
        list.add(new MainModel(R.drawable.mexican_pizza,"Mexican Pizza","500","Mexican Pizza with extra cheese"));
        list.add(new MainModel(R.drawable.chiken_bbq_pizza,"Chicken BBQ Pizza","600","Chicken BBQ,paper, Origano, onion, Cheese"));


        MainAdapter adapter= new MainAdapter(list,this);
        binding.recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(MainActivity.this, Orders.class));
        }
        return super.onOptionsItemSelected(item);
    }
}