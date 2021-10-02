package com.example.foodorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.foodorder.databinding.ActivityDetailsBinding;
import com.example.foodorder.databinding.ActivityMainBinding;

public class DetailsActivity extends AppCompatActivity {
    ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        if (getIntent().getIntExtra("type", 0) == 1) {


            final int image = getIntent().getIntExtra("image", 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            final String name = getIntent().getStringExtra("name");
            final String description = getIntent().getStringExtra("desc");

            binding.detailImageId.setImageResource(image);
            binding.priceLevel.setText(String.format("%d", price));
            binding.foodNameBoldBox.setText(name);
            binding.detailDescriptionID.setText(description);

            //connecting btn with db
            final DBHelper helper1 = new DBHelper(this);
            binding.insertBtnId.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    boolean isInserted = helper1.insertOrder(
                            binding.nameBoxID.getText().toString(),
                            binding.phoneBoxID.getText().toString(),
                            binding.emailBoxID.getText().toString(),
                            price,
                            image,
                            name,
                            description,
                            Integer.parseInt(binding.quantityID.getText().toString())
                    );
                    if (isInserted) {
                        Toast.makeText(DetailsActivity.this, "Order placed successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DetailsActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        } else {
            int id = getIntent().getIntExtra("id", 0);
            DBHelper helper=new DBHelper(this);
            Cursor cursor = helper.getOrderById(id);
            int image= cursor.getInt(5);

            binding.detailImageId.setImageResource(image);
            binding.priceLevel.setText(String.format("%d", cursor.getInt(4)));
            binding.foodNameBoldBox.setText(cursor.getString(6));
            binding.detailDescriptionID.setText(cursor.getString(7));

            binding.nameBoxID.setText(cursor.getString(1));
            binding.phoneBoxID.setText(cursor.getString(2));
            binding.emailBoxID.setText(cursor.getString(3));
            binding.insertBtnId.setText("Update Now");
            binding.insertBtnId.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   boolean isUpdated= helper.updateOrder(
                            binding.nameBoxID.getText().toString(),
                            binding.phoneBoxID.getText().toString(),
                            binding.emailBoxID.getText().toString(),
                            Integer.parseInt(binding.priceLevel.getText().toString()),
                            image,
                            binding.detailDescriptionID.getText().toString(),
                            binding.foodNameBoldBox.getText().toString(),
                            1,
                            id
                    );
                   if(isUpdated){
                       Toast.makeText(DetailsActivity.this,"order is Updated",Toast.LENGTH_SHORT).show();
                   }
                   else{
                       Toast.makeText(DetailsActivity.this,"  Update Error",Toast.LENGTH_SHORT).show();
                   }
                }
            });

        }


    }

}