package com.example.foodorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.foodorder.Models.ordersModel;
import com.example.foodorder.Adapters.ordersAdapter;
import com.example.foodorder.databinding.ActivityOrdersBinding;

import java.util.ArrayList;

public class Orders extends AppCompatActivity {

    ActivityOrdersBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= ActivityOrdersBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());


        DBHelper helper= new DBHelper(this);
        ArrayList<ordersModel> list= helper.getOrders();

         /*list.add(new ordersModel(R.drawable.burgernfries,"Combo Burger N Fries", "250","215456"));
        list.add(new ordersModel(R.drawable.burgernfries,"Combo Burger N Fries", "250","215456"));
        list.add(new ordersModel(R.drawable.burgernfries,"Combo Burger N Fries", "250","215456"));
        list.add(new ordersModel(R.drawable.burgernfries,"Combo Burger N Fries", "250","215456"));
        list.add(new ordersModel(R.drawable.burgernfries,"Combo Burger N Fries", "250","215456"));
        list.add(new ordersModel(R.drawable.burgernfries,"Combo Burger N Fries", "250","215456"));*/



        ordersAdapter adapter= new ordersAdapter(list,this);
        binding.orderRecyclerViewId.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.orderRecyclerViewId.setLayoutManager(layoutManager);
    }
}